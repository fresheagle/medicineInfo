package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_district;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissDistrictService;

@Component
@Order(1)
public class MissDistrictOperateService extends AbstractOperateService<Miss_district>{

	@Autowired
	private MissDistrictService districtService;

	@Override
	public boolean needDealMapper() {
		return false;
	}

	@Override
	public BaseService<Miss_district> baseService(String menuType) {
		// TODO Auto-generated method stub
		return districtService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_district.class;
	}

	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "missDistrict";
	}

	@Override
	public String getJsonParamKey() {
		// TODO Auto-generated method stub
		return "missDistrict";
	}


}
