package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.response.Response;
import com.med.info.service.DiseasInfoService;

/**
 * Title: 西医疾病参数配置管理 
 * Description: 对西医疾病相关参数的增删改查
 * 
 * @author DELETE
 * 
 */

@RestController
@RequestMapping("/westDisease")
public class WestDiseaseController {
	private static final Logger log = Logger.getLogger(WestDiseaseController.class);
		
	@Autowired
	DiseasInfoService diseasInfoService;
		
	@RequestMapping(method = RequestMethod.POST)
	public Response addWestDiseaseBlogInfo(@RequestBody Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs) {
		diseasInfoService.addWestDiseaseBlogInfo(miss_western_diseaseWithBLOBs);
		return null;
	}
		
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateWestDiseaseBlogInfo(@RequestBody Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs) {
		diseasInfoService.updateWestDiseaseBlogInfo(miss_western_diseaseWithBLOBs);
		return null;
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public Response queryWestDiseaseBlogInfo(@RequestBody Integer western_diseaseId) {
		diseasInfoService.queryWestDiseaseBlogInfo(western_diseaseId);
		return null;
	}
		
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteWestDiseaseBlogInfo(@RequestBody Integer western_diseaseId) {
		diseasInfoService.deleteWestDiseaseBlogInfo(western_diseaseId);
		return null;	
	}
}
