package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_combination_diseaseWithBLOBs;
import com.med.info.service.BaseService;
import com.med.info.service.MissCombinationDiseaseService;

@Component
@Order(3)
public class MissCombinationDiseaseOperateService extends AbstractOperateService<Miss_combination_diseaseWithBLOBs>{

	@Autowired
	private MissCombinationDiseaseService combinationDiseaseService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_combine_disease";
	}

	@Override
	public BaseService<Miss_combination_diseaseWithBLOBs> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return combinationDiseaseService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_combination_diseaseWithBLOBs.class;
	}

	
}
