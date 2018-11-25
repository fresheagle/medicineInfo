package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_medical;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_medicalMapper;
import com.med.info.service.MissMedicalService;

@Service
public class MissMedicalServiceImpl extends BaseServiceImpl<Miss_medical> implements MissMedicalService{

	@Autowired
	private Miss_medicalMapper medicalMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return medicalMapper;
	}

}
