package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_combination_diseaseWithBLOBs;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissCombinationDiseaseService;

@Component
@Order(3)
public class MissCombinationDiseaseOperateService extends AbstractOperateService<Miss_combination_diseaseWithBLOBs>{

	@Autowired
	private MissCombinationDiseaseService combinationDiseaseService;
	
	@Override
	public String getCurrentMenuType() {
		return "missCombineDisease";
	}

	@Override
	public BaseService<Miss_combination_diseaseWithBLOBs> baseService(String menuType) {
		return combinationDiseaseService;
	}

	@Override
	public Class<?> getCurrentClass() {
		return Miss_combination_diseaseWithBLOBs.class;
	}

	@Override
	public boolean needDealMapper() {
		return false;
	}

	@Override
	public String getJsonParamKey() {
		return "missCombineDisease";
	}

	
}
