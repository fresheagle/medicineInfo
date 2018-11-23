package com.med.info.rest;

import com.med.info.service.ParamInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.response.Response;
import com.med.info.service.DiseaseInfoService;
import com.med.info.service.dto.DiseaseDTO;

/**
 * Title: 疾病参数配置管理 
 * Description: 对疾病相关参数的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/disease")
public class DiseaseController {
	private static final Logger log = Logger.getLogger(DiseaseController.class);
	
	@Autowired
	DiseaseInfoService diseaseInfoService;
	@Autowired
	ParamInfoService paramInfoService;

	/**
	 * 添加疾病基础信息
	 * @param diseaseDTO 疾病基础信息
	 * @return 疾病信息id
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Response addDisease(@RequestBody DiseaseDTO diseaseDTO) {
		try{
			return new Response().success(diseaseInfoService.addDiseaseInfo(diseaseDTO));
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
			return new Response().success(diseaseInfoService.updateDiseaseInfo(diseaseDTO));
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
	public Response queryDisease(@RequestBody Integer diseaseId) {
		try{
			return new Response().success(diseaseInfoService.queryDiseaseInfo(diseaseId));
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
	public Response deleteDisease(@RequestBody Integer diseaseId) {
		try{
			return new Response().success(diseaseInfoService.deleteDiseaseInfo(diseaseId));
		}catch (Exception e){
			return new Response().failure();
		}
	}
}
