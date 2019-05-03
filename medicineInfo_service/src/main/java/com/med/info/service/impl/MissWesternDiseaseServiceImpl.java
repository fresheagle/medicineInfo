package com.med.info.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_western_diseaseMapper;
import com.med.info.service.MissWesternDiseaseService;
import com.med.info.utils.CollectionUtil;

@Service
public class MissWesternDiseaseServiceImpl extends BaseServiceImpl<Miss_western_diseaseWithBLOBs> implements MissWesternDiseaseService{

	@Autowired
	private Miss_western_diseaseMapper westernDiseaseMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return westernDiseaseMapper;
	}

	@Override
	public Long addWestDiseaseBlogInfo(Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Miss_western_diseaseWithBLOBs queryWestDiseaseBlogInfo(Long western_diseaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updateWestDiseaseBlogInfo(Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteWestDiseaseBlogInfo(Long western_diseaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKeyName() {
		return "missWestern";
	}

	@Override
	public String checkWestDiseaseInfo(String chineseName, String englishName, String otherName) throws Exception {
		// TODO Auto-generated method stub
		List<Miss_western_diseaseWithBLOBs> miss_western_diseaseWithBLOBs = westernDiseaseMapper.check(chineseName, englishName,otherName);
		if(!CollectionUtil.isNotEmpty(miss_western_diseaseWithBLOBs)){
			return UUID.randomUUID().toString().replace("-", "");
		}
		throw new Exception("该西医疾病信息已经存在！");
	}
}
