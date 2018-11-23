package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_combination_diseaseWithBLOBs;
import com.med.info.response.Response;
import com.med.info.service.DiseaseInfoService;

/**
 * Title: 中西医结合疾病参数配置管理 
 * Description: 对中西医结合疾病相关参数的增删改查
 * 
 * @author DELETE
 * 
 */

@RestController
@RequestMapping("/combinationDisease")
public class CombinationDiseaseController {
	private static final Logger log = Logger.getLogger(WestDiseaseController.class);
	
	@Autowired
	DiseaseInfoService diseaseInfoService;
		
	@RequestMapping(method = RequestMethod.POST)
	public Response addCombinationDiseaseBlogInfo(@RequestBody Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs) {
		diseaseInfoService.addCombinationDiseaseBlogInfo(miss_combination_diseaseWithBLOBs);
		return null;
	}
		
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateCombinationDiseaseBlogInfo(@RequestBody Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs) {
		diseaseInfoService.updateCombinationDiseaseBlogInfo(miss_combination_diseaseWithBLOBs);
		return null;
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public Response queryCombinationDiseaseBlogInfo(@RequestBody Integer combination_diseaseId) {
		diseaseInfoService.queryCombinationDiseaseBlogInfo(combination_diseaseId);
		return null;
	}
		
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteCombinationDiseaseBlogInfo(@RequestBody Integer combination_diseaseId) {
		diseaseInfoService.deleteCombinationDiseaseBlogInfo(combination_diseaseId);
		return null;	
	}
}
