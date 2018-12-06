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
}
