package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.response.Response;
import com.med.info.service.DiseasInfoService;
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
	DiseasInfoService diseasInfoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Response addDisease(@RequestBody DiseaseDTO diseaseDTO) {
		diseasInfoService.addDiseasInfo(diseaseDTO);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateDisease(@RequestBody DiseaseDTO diseaseDTO) {
		diseasInfoService.updateDiseasInfo(diseaseDTO);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Response queryDisease(@RequestBody Integer diseaseId) {
		diseasInfoService.queryDiseasInfo(diseaseId);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteDisease(@RequestBody Integer diseaseId) {
		diseasInfoService.deleteDiseasInfo(diseaseId);
		return null;
	}
	
	@RequestMapping(value="/findDisease",method = RequestMethod.GET)
	public Response queryDiseasInfoName() {
		diseasInfoService.queryDiseasInfoName();
		return null;
	}
	
	@RequestMapping(value="/findDiseaseDepartment",method = RequestMethod.GET)
	public Response queryDepartmentInfo() {
		diseasInfoService.queryDepartmentInfo();
		return null;
	}
	
	@RequestMapping(value="/findDiseaseSymptom",method = RequestMethod.GET)
	public Response querySymptomInfo() {
		diseasInfoService.querySymptomInfo();
		return null;
	}
}
