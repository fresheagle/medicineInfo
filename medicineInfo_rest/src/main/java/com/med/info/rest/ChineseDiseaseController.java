package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.domain.Miss_diseaseWithBLOBs;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.DiseaseInfoService;
import com.med.info.service.MissChineseDiseaseService;

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
	MissChineseDiseaseService missChineseDiseaseService;

	/**
	 * 分页查询疾病列表
	 */
	@RequestMapping(path="/page", method = RequestMethod.GET)
	public Response selectPage(@RequestParam("currentPage") Integer currentPage, 
			@RequestParam(value="pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value="diseaseId", required = false) Long diseaseId) {
		Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs = new Miss_chinese_diseaseWithBLOBs();
		if(diseaseId != null) {
			miss_chinese_diseaseWithBLOBs.setDiseaseId(diseaseId);
		}
		PageObject<Miss_chinese_diseaseWithBLOBs> selectPage = missChineseDiseaseService.selectPageByOperateDto(currentPage, pageSize, miss_chinese_diseaseWithBLOBs);
		return new Response().success(selectPage);
	}
	
	/**
	 * 添加中医疾病信息
	 * @param miss_chinese_diseaseWithBLOBs 包含父类信息参数的中医疾病信息
	 * @return 中医疾病信息id
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Response addChineseDisease(@RequestBody Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs) {
		try{
			return new Response().success(missChineseDiseaseService.insert(miss_chinese_diseaseWithBLOBs));
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
			return new Response().success(missChineseDiseaseService.updateByPrimaryKey(miss_chinese_diseaseWithBLOBs));
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
	public Response queryChineseDisease(@RequestBody Long chinese_diseaseId) {
		try{
			return new Response().success(missChineseDiseaseService.selectByPrimaryId(chinese_diseaseId));
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
	public Response deleteChineseDisease(@RequestBody Long chinese_diseaseId) {
		try{
			return new Response().success(missChineseDiseaseService.deleteByPrimaryKey(chinese_diseaseId));
		}catch (Exception e){
			return new Response().failure();
		}
	}
}
