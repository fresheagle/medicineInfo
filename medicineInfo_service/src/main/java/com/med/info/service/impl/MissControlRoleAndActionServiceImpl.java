package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.med.info.domain.Miss_control_roleAndAction;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_roleAndActionMapper;
import com.med.info.service.MissControlRoleAndActionService;

public class MissControlRoleAndActionServiceImpl extends BaseServiceImpl<Miss_control_roleAndAction> implements MissControlRoleAndActionService {

	@Autowired
	private Miss_control_roleAndActionMapper roleAndActionMapper;
	
	@Override
	public BaseMapper getMapper() {
		return roleAndActionMapper;
	}

}
