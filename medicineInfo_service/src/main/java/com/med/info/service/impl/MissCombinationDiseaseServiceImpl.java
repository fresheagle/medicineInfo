package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_combination_diseaseWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_combination_diseaseMapper;
import com.med.info.service.MissCombinationDiseaseService;

@Service
public class MissCombinationDiseaseServiceImpl extends BaseServiceImpl<Miss_combination_diseaseWithBLOBs> implements MissCombinationDiseaseService{

	@Autowired
	private Miss_combination_diseaseMapper combinationDiseaseMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return combinationDiseaseMapper;
	}

}
