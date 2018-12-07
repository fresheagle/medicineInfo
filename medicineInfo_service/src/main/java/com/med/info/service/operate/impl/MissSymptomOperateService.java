package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissSymptomService;

@Component
@Order(11)
public class MissSymptomOperateService extends AbstractOperateService<Miss_symptomWithBLOBs>{

	@Autowired
	private MissSymptomService symptomService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_symptom";
	}

	@Override
	public BaseService<Miss_symptomWithBLOBs> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return symptomService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_symptomWithBLOBs.class;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.operate.impl.AbstractOperateService#fishDeal(com.med.info.mapper.domain.OperateDTO)
	 */
	@Override
	public void fishDeal(OperateDTO operateDTO) {
		// TODO Auto-generated method stub
		
	}

}
