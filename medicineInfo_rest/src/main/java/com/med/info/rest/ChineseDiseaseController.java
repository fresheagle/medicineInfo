package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.response.Response;
import com.med.info.service.DiseasInfoService;

/**
 * Title: 中医疾病参数配置管理 
 * Description: 对中医疾病相关参数的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/chineseDisease")
public class ChineseDiseaseController {
	private static final Logger log = Logger.getLogger(DiseaseController.class);
	
	@Autowired
	DiseasInfoService diseasInfoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Response addChineseDisease(@RequestBody Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs) {
		diseasInfoService.addChineseDiseaseBlogInfo(miss_chinese_diseaseWithBLOBs);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateChineseDisease(@RequestBody Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs) {
		diseasInfoService.updateChineseDiseaseBlogInfo(miss_chinese_diseaseWithBLOBs);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Response queryChineseDisease(@RequestBody Integer chinese_diseaseId) {
		diseasInfoService.queryChineseDiseaseBlogInfo(chinese_diseaseId);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteChineseDisease(@RequestBody Integer chinese_diseaseId) {
		diseasInfoService.deleteChineseDiseaseBlogInfo(chinese_diseaseId);
		return null;
	}
}
