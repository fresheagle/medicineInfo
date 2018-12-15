package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.DiseaseInfoService;
import com.med.info.service.MissWesternDiseaseService;

/**
 * Title: 西医疾病参数配置管理 
 * Description: 对西医疾病相关参数的增删改查
 * 
 * @author DELETE
 * 
 */

@RestController
@RequestMapping("/api/westDisease")
public class WestDiseaseController {
	private static final Logger log = Logger.getLogger(WestDiseaseController.class);
		
	@Autowired
	MissWesternDiseaseService missWestDiseaseService;

	/**
	 * 分页查询疾病列表
	 */
	@RequestMapping(path="/page", method = RequestMethod.GET)
	public Response selectPage(@RequestParam("currentPage") Integer currentPage, 
			@RequestParam(value="pageSize",defaultValue = "10") Integer pageSize,
			@RequestParam(value="diseaseId", required = false) Long diseaseId) {
		Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs = new Miss_western_diseaseWithBLOBs();
		if(diseaseId != null) {
			miss_western_diseaseWithBLOBs.setDiseaseId(diseaseId);
		}
		PageObject<Miss_western_diseaseWithBLOBs> selectPage = missWestDiseaseService.selectPageByOperateDto(currentPage, pageSize, miss_western_diseaseWithBLOBs);
		return new Response().success(selectPage);	
	}
	
	/**
	 * 添加西医疾病信息
	 * @param miss_western_diseaseWithBLOBs 包含父类信息参数的西医疾病信息
	 * @return 西医疾病信息id
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Response addWestDiseaseBlogInfo(@RequestBody Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs) {
		try{
			return new Response().success(missWestDiseaseService.insert(miss_western_diseaseWithBLOBs));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 修改西医疾病信息
	 * @param miss_western_diseaseWithBLOBs 包含父类信息参数的西医疾病信息
	 * @return 西医疾病信息id
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateWestDiseaseBlogInfo(@RequestBody Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs) {
		try{
			return new Response().success(missWestDiseaseService.updateByPrimaryKey(miss_western_diseaseWithBLOBs));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 查询西医疾病相关信息
	 * @param western_diseaseId 西医疾病相关信息id
	 * @return 西医疾病信息
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Response queryWestDiseaseBlogInfo(@RequestBody Long western_diseaseId) {
		try{
			return new Response().success(missWestDiseaseService.selectByPrimaryId(western_diseaseId));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 删除西医疾病信息
	 * @param western_diseaseId 包含父类信息参数的西医疾病信息id
	 * @return 西医疾病信息id
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteWestDiseaseBlogInfo(@RequestBody Long western_diseaseId) {
		try{
			return new Response().success(missWestDiseaseService.selectByPrimaryId(western_diseaseId));
		}catch (Exception e){
			return new Response().failure();
		}
	}
}
