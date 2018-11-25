package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_institutionMapper;
import com.med.info.service.MissInstitutionService;

@Service
public class MissInstitutionServiceImpl extends BaseServiceImpl<Miss_institutionWithBLOBs> implements MissInstitutionService{

	@Autowired
	private Miss_institutionMapper institutionMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return institutionMapper;
	}

}
