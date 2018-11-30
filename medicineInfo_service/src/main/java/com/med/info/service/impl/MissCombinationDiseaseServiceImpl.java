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

	@Override
	public Long addCombinationDiseaseBlogInfo(Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Miss_combination_diseaseWithBLOBs queryCombinationDiseaseBlogInfo(Long combination_diseaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updateCombinationDiseaseBlogInfo(Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteCombinationDiseaseBlogInfo(Long combination_diseaseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
