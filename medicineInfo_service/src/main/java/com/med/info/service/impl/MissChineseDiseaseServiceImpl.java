package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_chinese_diseaseMapper;
import com.med.info.service.MissChineseDiseaseService;

@Service
public class MissChineseDiseaseServiceImpl extends BaseServiceImpl<Miss_chinese_diseaseWithBLOBs> implements MissChineseDiseaseService {

	@Autowired
	private Miss_chinese_diseaseMapper chineseDiseaseMapper;
	
	@Override
	public BaseMapper getMapper() {
		return chineseDiseaseMapper;
	}

	@Override
	public Long addChineseDiseaseBlogInfo(Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Miss_chinese_diseaseWithBLOBs queryChineseDiseaseBlogInfo(Long chinese_diseaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updateChineseDiseaseBlogInfo(Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteChineseDiseaseBlogInfo(Long chinese_diseaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKeyName() {
		return "missChineseDisease";
	}
}
