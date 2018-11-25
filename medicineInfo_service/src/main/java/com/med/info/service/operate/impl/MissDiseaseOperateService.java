package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_disease;
import com.med.info.service.BaseService;
import com.med.info.service.MissDiseaseService;

@Component
@Order(5)
public class MissDiseaseOperateService extends AbstractOperateService<Miss_disease>{

	@Autowired
	private MissDiseaseService diseaseService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_disease";
	}

	@Override
	public BaseService<Miss_disease> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return diseaseService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_disease.class;
	}

}
