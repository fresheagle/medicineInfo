package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_doctorWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_doctorMapper;
import com.med.info.service.MissDoctorService;

@Service
public class MissDoctorServiceImpl extends BaseServiceImpl<Miss_doctorWithBLOBs> implements MissDoctorService {

	@Autowired
	private Miss_doctorMapper doctorMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return doctorMapper;
	}

}
