package com.med.info.service.operate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_dislocation;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissDislocationService;

@Component
@Order(6)
public class MissDislocationOperateService extends AbstractOperateService<Miss_dislocation>{

	@Autowired
	private MissDislocationService dislocationService;
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "miss_dislocation";
	}

	@Override
	public BaseService<Miss_dislocation> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return dislocationService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_dislocation.class;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.operate.impl.AbstractOperateService#fishDeal(com.med.info.mapper.domain.OperateDTO)
	 */
	@Override
	public void fishDeal(OperateDTO operateDTO) {
		// TODO Auto-generated method stub
		
	}

}
