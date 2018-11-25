package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_department;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_departmentMapper;
import com.med.info.service.MissDepartmentService;

@Service
public class MissDepartmentServiceImpl extends BaseServiceImpl<Miss_department> implements MissDepartmentService{

	@Autowired
	private Miss_departmentMapper departmentMapper;

	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return departmentMapper;
	}
}
