package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_combination_diseaseWithBLOBs;
import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.DiseaseInfoService;
import com.med.info.service.MissCombinationDiseaseService;

/**
 * Title: 中西医结合疾病参数配置管理 
 * Description: 对中西医结合疾病相关参数的增删改查
 * 
 * @author DELETE
 * 
 */

@RestController
@RequestMapping("/api/combinationDisease")
public class CombinationDiseaseController {
	private static final Logger log = Logger.getLogger(WestDiseaseController.class);
	
	@Autowired
	DiseaseInfoService diseaseInfoService;
	
	MissCombinationDiseaseService missCombinationDiseaseService;

	/**
	 * 分页查询疾病列表
	 */
	@RequestMapping(path="/page", method = RequestMethod.GET)
	public Response selectPage(@RequestParam("currentPage") Integer currentPage, @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize) {
		PageObject<Miss_combination_diseaseWithBLOBs> selectPage = missCombinationDiseaseService.selectPage(currentPage, pageSize, new Miss_combination_diseaseWithBLOBs());
		return new Response().success(selectPage);	
	}
	
	/**
	 * 添加中西医结合疾病信息
	 * @param miss_combination_diseaseWithBLOBs 包含父类信息参数的中西医结合疾病信息
	 * @return 中西医结合疾病信息id
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Response addCombinationDiseaseBlogInfo(@RequestBody Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs) {
		try{
			return new Response().success(missCombinationDiseaseService.insert(miss_combination_diseaseWithBLOBs));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 修改中西医结合疾病信息
	 * @param miss_combination_diseaseWithBLOBs 包含父类信息参数的中西医结合疾病信息
	 * @return 中西医结合疾病信息id
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateCombinationDiseaseBlogInfo(@RequestBody Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs) {
		try{
			return new Response().success(missCombinationDiseaseService.updateByPrimaryKey(miss_combination_diseaseWithBLOBs));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 查询中西医结合疾病相关信息
	 * @param combination_diseaseId 中西医结合疾病相关信息id
	 * @return 中西医结合疾病相关信息
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Response queryCombinationDiseaseBlogInfo(@RequestBody Long combination_diseaseId) {
		try{
			return new Response().success(missCombinationDiseaseService.selectByPrimaryId(combination_diseaseId));
		}catch (Exception e){
			return new Response().failure();
		}
	}

	/**
	 * 删除中西医结合疾病信息
	 * @param combination_diseaseId 包含父类信息参数的中西医结合疾病信息id
	 * @return 中西医结合疾病信息id
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteCombinationDiseaseBlogInfo(@RequestBody Long combination_diseaseId) {
		try{
			return new Response().success(missCombinationDiseaseService.deleteByPrimaryKey(combination_diseaseId));
		}catch (Exception e){
			return new Response().failure();
		}
	}
}
