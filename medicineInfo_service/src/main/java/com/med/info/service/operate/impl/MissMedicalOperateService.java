package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_medical;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissMedicalService;

@Component
@Order(10)
public class MissMedicalOperateService extends AbstractOperateService<Miss_medical>{

	@Autowired
	private MissMedicalService medicalService;
	
	@Override
	public String getCurrentMenuType() {
		return "missMedical";
	}

	@Override
	public BaseService<Miss_medical> baseService(String menuType) {
		return medicalService;
	}

	@Override
	public Class<?> getCurrentClass() {
		return Miss_medical.class;
	}


	@Override
	public String getJsonParamKey() {
		return "missMedical";
	}

	@Override
	public boolean needDealMapper() {
		//TODO 需要修改为true 并实现返回，在家里面电脑实现
		return false;
	}
}
