package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_department;
import com.med.info.service.BaseService;
import com.med.info.service.MissDepartmentService;

@Component
@Order(4)
public class MissDepartmentOperateService extends AbstractOperateService<Miss_department> {

	@Autowired
	private MissDepartmentService departmentService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_department";
	}

	@Override
	public BaseService<Miss_department> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return departmentService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_department.class;
	}

}
