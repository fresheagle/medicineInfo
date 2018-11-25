package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_doctorWithBLOBs;
import com.med.info.service.BaseService;
import com.med.info.service.MissDoctorService;

@Component
@Order(7)
public class MissDoctorOperateService extends AbstractOperateService<Miss_doctorWithBLOBs>{

	@Autowired
	private MissDoctorService doctorService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_doctor";
	}

	@Override
	public BaseService<Miss_doctorWithBLOBs> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return doctorService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_doctorWithBLOBs.class;
	}

}
