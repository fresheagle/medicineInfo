package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_medical;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissMedicalService;

@Component
@Order(10)
public class MissMedicalOperateService extends AbstractOperateService<Miss_medical>{

	@Autowired
	private MissMedicalService medicalService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_medical";
	}

	@Override
	public BaseService<Miss_medical> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return medicalService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_medical.class;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.operate.impl.AbstractOperateService#fishDeal(com.med.info.mapper.domain.OperateDTO)
	 */
	@Override
	public void fishDeal(OperateDTO operateDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getJsonParamKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
