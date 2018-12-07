package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissInstitutionService;

@Component
@Order(8)
public class MissInstitutionOperateService extends AbstractOperateService<Miss_institutionWithBLOBs>{

	@Autowired
	private MissInstitutionService institutionService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_institution";
	}

	@Override
	public BaseService<Miss_institutionWithBLOBs> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return institutionService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_institutionWithBLOBs.class;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.operate.impl.AbstractOperateService#fishDeal(com.med.info.mapper.domain.OperateDTO)
	 */
	@Override
	public void fishDeal(OperateDTO operateDTO) {
		// TODO Auto-generated method stub
		
	}

}
