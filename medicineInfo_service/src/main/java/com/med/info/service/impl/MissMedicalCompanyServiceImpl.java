package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_medical_companyWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_medical_companyMapper;
import com.med.info.service.MissMedicalCompanyService;

@Service
public class MissMedicalCompanyServiceImpl extends BaseServiceImpl<Miss_medical_companyWithBLOBs> implements MissMedicalCompanyService{

	@Autowired
	private Miss_medical_companyMapper medicalCompanyMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return medicalCompanyMapper;
	}

}
