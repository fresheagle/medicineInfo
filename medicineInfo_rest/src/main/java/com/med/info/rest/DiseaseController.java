package com.med.info.rest;

import com.med.info.service.ParamInfoService;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_diseaseWithBLOBs;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.DiseaseInfoService;
import com.med.info.service.MissDiseaseService;
import com.med.info.service.dto.DepartmentMapDTO;
import com.med.info.service.dto.DiseaseDTO;

/**
 * Title: 疾病参数配置管理 
 * Description: 对疾病相关参数的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/api/disease")
public class DiseaseController {
	private static final Logger log = Logger.getLogger(DiseaseController.class);
	
	@Autowired 
	private MissDiseaseService diseaseService;
	/**
	 * 分页查询疾病列表
	 */
	@RequestMapping(path="/page", method = RequestMethod.GET)
	public Response selectPage(@RequestParam("currentPage") Integer currentPage, @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize) {
		PageObject<Miss_diseaseWithBLOBs> selectPage = diseaseService.selectPage(currentPage, pageSize, new Miss_diseaseWithBLOBs());
		return new Response().success(selectPage);
	}
	/**
	 * 添加疾病基础信息
	 * @param diseaseDTO 疾病基础信息
	 * @return 疾病信息id
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Response addDisease(@RequestBody DiseaseDTO diseaseDTO) {
		try{
			return new Response().success(diseaseService.insert(diseaseDTO.getMiss_disease()));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 修改疾病基础信息
	 * @param diseaseDTO 疾病基础信息
	 * @return 疾病信息id
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateDisease(@RequestBody DiseaseDTO diseaseDTO) {
		try{
			return new Response().success(diseaseService.updateByPrimaryKey(diseaseDTO.getMiss_disease()));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 查询疾病基础信息
	 * @param diseaseId 疾病基础信息id
	 * @return 疾病基础信息内容
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Response queryDisease(@RequestBody Long diseaseId) {
		try{
			DiseaseDTO respDiseaseDTO = new DiseaseDTO();//响应实体类
			Miss_diseaseWithBLOBs miss_diseaseWithBLOBs = diseaseService.selectByPrimaryId(diseaseId);
//			List<DepartmentMapDTO> disease_department_mapping_list =
			return new Response().success(respDiseaseDTO);
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 删除疾病基础信息
	 * @param diseaseId 疾病基础信息id
	 * @return 疾病信息id
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteDisease(@RequestBody Long diseaseId) {
		try{
			return new Response().success(diseaseService.deleteByPrimaryKey(diseaseId));
		}catch (Exception e){
			return new Response().failure();
		}
	}
}
