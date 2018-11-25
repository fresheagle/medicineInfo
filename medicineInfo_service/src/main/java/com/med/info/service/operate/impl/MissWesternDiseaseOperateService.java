package com.med.info.service.operate.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.service.BaseService;
import com.med.info.service.MissWesternDiseaseService;

@Component
@Order(12)
public class MissWesternDiseaseOperateService extends AbstractOperateService<Miss_western_diseaseWithBLOBs>{

	private MissWesternDiseaseService westernDiseaseService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_western";
	}

	@Override
	public BaseService<Miss_western_diseaseWithBLOBs> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return westernDiseaseService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_western_diseaseWithBLOBs.class;
	}

}
