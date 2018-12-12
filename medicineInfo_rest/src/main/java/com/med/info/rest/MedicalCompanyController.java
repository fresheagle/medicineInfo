package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_medical_companyWithBLOBs;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.MissMedicalCompanyService;

/**
 * Title: 医药企业的参数管理 
 * Description: 医药企业数据的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/api/medicalCompany")
public class MedicalCompanyController {
	
	private static final Logger log = Logger.getLogger(MedicalCompanyController.class);

	@Autowired
	MissMedicalCompanyService missMedicalCompanyService;
	
	@RequestMapping(path = "/page", method = RequestMethod.GET)
	public Response selectDiseaseParam(
		@RequestParam("currentPage") Integer currentPage,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
        @RequestParam(value = "id", required = false) Long id,
        @RequestParam(value = "chineseName", required = false) String chineseName,
        @RequestParam(value = "englishName", required = false) String englishName,
        @RequestParam(value = "location", required = false) String location) {
		Miss_medical_companyWithBLOBs miss_medical_companyWithBLOBs = new Miss_medical_companyWithBLOBs();
		if(id != null) {
			miss_medical_companyWithBLOBs.setId(id);
		}if(chineseName != null) {
			miss_medical_companyWithBLOBs.setChineseName(chineseName);
		}if(englishName != null) {
			miss_medical_companyWithBLOBs.setEnglishName(englishName);
		}if(location != null) {
			miss_medical_companyWithBLOBs.setLocation(location);
		}
		PageObject<Miss_medical_companyWithBLOBs> selectPage = missMedicalCompanyService.selectPageByOperateDto(currentPage, pageSize, miss_medical_companyWithBLOBs);
		return new Response().success(selectPage);
	}
}
