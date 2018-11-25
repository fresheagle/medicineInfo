package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_medical_companyWithBLOBs;
import com.med.info.service.BaseService;
import com.med.info.service.MissMedicalCompanyService;

@Component
@Order(9)
public class MissMedicalCompanyOperateService extends AbstractOperateService<Miss_medical_companyWithBLOBs>{

	@Autowired
	private MissMedicalCompanyService medicalCompanyService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_medical_company";
	}

	@Override
	public BaseService<Miss_medical_companyWithBLOBs> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return medicalCompanyService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_medical_companyWithBLOBs.class;
	}

}
