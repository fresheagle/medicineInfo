package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_medical;
import com.med.info.service.BaseService;
import com.med.info.service.MissMedicalService;

@Component
@Order(10)
public class MissMedicalOperateService extends AbstractOperateService<Miss_medical>{

	@Autowired
	private MissMedicalService medicalService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_medical";
	}

	@Override
	public BaseService<Miss_medical> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return medicalService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_medical.class;
	}

}
