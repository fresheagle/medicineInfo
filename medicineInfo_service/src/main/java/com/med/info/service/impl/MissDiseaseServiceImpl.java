package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_diseaseWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_diseaseMapper;
import com.med.info.service.MissDiseaseService;

@Service
public class MissDiseaseServiceImpl extends BaseServiceImpl<Miss_diseaseWithBLOBs> implements MissDiseaseService{

	@Autowired
	private Miss_diseaseMapper diseaseMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return diseaseMapper;
	}

}
