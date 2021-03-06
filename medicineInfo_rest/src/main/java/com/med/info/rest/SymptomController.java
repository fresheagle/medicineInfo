package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.MissSymptomService;

/**
 * Title: 发病症状的参数管理 
 * Description: 发病症状数据的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/api/symptom")
public class SymptomController {
	private static final Logger log = Logger.getLogger(SymptomController.class);

	@Autowired
	MissSymptomService missSymptomService;
	
	@RequestMapping(path = "/page", method = RequestMethod.GET)
	public Response getByPage(@RequestParam("currentPage") Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "chineseName", required = false) String chineseName,
			@RequestParam(value = "englishName", required = false) String englishName,
			@RequestParam(value = "otherName", required = false) String otherName,
			@RequestParam(value = "symptom", required = false) String symptom,
			@RequestParam(value = "commonSymptom", required = false) String commonSymptom) {
		try {
			Object byPage = missSymptomService.getByPage(currentPage, pageSize, chineseName, englishName, otherName, symptom, commonSymptom);
			return new Response().success(byPage);
		} catch (Exception e) {
			return new Response().failure(e.getMessage());
		}
	}
	
	@RequestMapping(path = "/param", method = RequestMethod.GET)
	public Response selectDiseaseParam(@RequestParam("currentPage") Integer currentPage,
                                       @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                       @RequestParam(value = "chineseName", required = false) String chineseName){
//		return new Response().success(missSymptomService.querySymptomMapDTOParam(currentPage,pageSize,chineseName));
		Miss_symptomWithBLOBs miss_symptomWithBLOBs = new Miss_symptomWithBLOBs();
		if(chineseName != null) {
			miss_symptomWithBLOBs.setChineseName(chineseName);
		}
		PageObject<Miss_symptomWithBLOBs> selectPage = missSymptomService.selectPageByOperateDto(currentPage, pageSize, miss_symptomWithBLOBs);
		return new Response().success(selectPage);
	}
	
	public Response selectPage(@RequestParam("currentPage") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
            @RequestParam(value = "chineseName", required = false) String chineseName,
            @RequestParam(value = "englishName", required = false) String englishName,
            @RequestParam(value = "otherName", required = false) String otherName,
            @RequestParam(value = "symptom", required = false) String symptom,
            @RequestParam(value = "commonSymptom", required = false) String commonSymptom) {
		Object byPage = missSymptomService.getByPage(currentPage, pageSize, chineseName, englishName, otherName, symptom, commonSymptom);
		return new Response().success(byPage);
	}
	
	@RequestMapping(value = "check", method = RequestMethod.GET)
    public Response checkInfo(@RequestParam(value = "chineseName", required = false) String chineseName, @RequestParam(value = "englishName", required = false) String englishName, @RequestParam(value = "otherName", required = false) String otherName) {
        if (null == chineseName && null == englishName && null == otherName) {
            return new Response().failure("校验条件至少传递一个");
        }
        try {
            String taskId = missSymptomService.checkSymptomInfo(chineseName, englishName, otherName);
            return new Response().success(taskId);
        } catch (Exception e) {
            return new Response().failure(e.getMessage());
        }
    }
}
