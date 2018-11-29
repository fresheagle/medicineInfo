package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.response.Response;
import com.med.info.service.DiseaseInfoService;

/**
 * Title: 中医疾病参数配置管理 
 * Description: 对中医疾病相关参数的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/api/chineseDisease")
public class ChineseDiseaseController {
	private static final Logger log = Logger.getLogger(DiseaseController.class);
	
	@Autowired
	DiseaseInfoService diseaseInfoService;

	/**
	 * 添加中医疾病信息
	 * @param miss_chinese_diseaseWithBLOBs 包含父类信息参数的中医疾病信息
	 * @return 中医疾病信息id
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Response addChineseDisease(@RequestBody Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs) {
		try{
			return new Response().success(diseaseInfoService.addChineseDiseaseBlogInfo(miss_chinese_diseaseWithBLOBs));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 修改中医疾病信息
	 * @param miss_chinese_diseaseWithBLOBs 包含父类信息参数的中医疾病信息
	 * @return 中医疾病信息id
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateChineseDisease(@RequestBody Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs) {
		try{
			return new Response().success(diseaseInfoService.updateChineseDiseaseBlogInfo(miss_chinese_diseaseWithBLOBs));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 查询中医疾病相关信息
	 * @param chinese_diseaseId 中医疾病相关信息id
	 * @return 中医疾病信息
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Response queryChineseDisease(@RequestBody Integer chinese_diseaseId) {
		try{
			return new Response().success(diseaseInfoService.queryChineseDiseaseBlogInfo(chinese_diseaseId));
		}catch (Exception e){
			return new Response().failure();
		}
	}
	/**
	 * 删除中医疾病信息
	 * @param chinese_diseaseId 包含父类信息参数的中医疾病信息id
	 * @return 中医疾病信息id
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteChineseDisease(@RequestBody Integer chinese_diseaseId) {
		try{
			return new Response().success(diseaseInfoService.deleteChineseDiseaseBlogInfo(chinese_diseaseId));
		}catch (Exception e){
			return new Response().failure();
		}
	}
}
