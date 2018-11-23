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
	
	@RequestMapping(method = RequestMethod.POST)
	public Response addDisease(@RequestBody DiseaseDTO diseaseDTO) {
		diseaseInfoService.addDiseaseInfo(diseaseDTO);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateDisease(@RequestBody DiseaseDTO diseaseDTO) {
		diseaseInfoService.updateDiseaseInfo(diseaseDTO);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Response queryDisease(@RequestBody Integer diseaseId) {
		diseaseInfoService.queryDiseaseInfo(diseaseId);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteDisease(@RequestBody Integer diseaseId) {
		diseaseInfoService.deleteDiseaseInfo(diseaseId);
		return null;
	}
}
