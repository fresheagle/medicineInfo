package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissChineseDiseaseService;

@Component
@Order(2)
public class MissChineseDiseaseOperateService extends AbstractOperateService<Miss_chinese_diseaseWithBLOBs>{

	@Autowired
	private MissChineseDiseaseService chineseDiseaseService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_chinese_disease";
	}

	@Override
	public BaseService<Miss_chinese_diseaseWithBLOBs> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return chineseDiseaseService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_chinese_diseaseWithBLOBs.class;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.operate.impl.AbstractOperateService#fishDeal(com.med.info.mapper.domain.OperateDTO)
	 */
	@Override
	public void finishDeal(OperateDTO operateDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getJsonParamKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
