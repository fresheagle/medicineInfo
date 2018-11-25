package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_symptomMapper;
import com.med.info.service.MissSymptomService;

@Service
public class MissSymptomServiceImpl extends BaseServiceImpl<Miss_symptomWithBLOBs> implements MissSymptomService{

	@Autowired
	private Miss_symptomMapper symptomMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return symptomMapper;
	}

}
