package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_western_diseaseMapper;
import com.med.info.service.MissWesternDiseaseService;

@Service
public class MissWesternDiseaseServiceImpl extends BaseServiceImpl<Miss_western_diseaseWithBLOBs> implements MissWesternDiseaseService{

	@Autowired
	private Miss_western_diseaseMapper westernDiseaseMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return westernDiseaseMapper;
	}

	
}
