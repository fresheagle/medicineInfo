package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_district;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_districtMapper;
import com.med.info.service.MissDistrictService;

@Service
public class MissDistrictServiceImpl extends BaseServiceImpl<Miss_district> implements MissDistrictService {

	@Autowired
	private Miss_districtMapper districtMapper;

	@Override
	public BaseMapper getMapper() {
		return districtMapper;
	}

	@Override
	public String getKeyName() {
		return "missDistrict";
	}
}
