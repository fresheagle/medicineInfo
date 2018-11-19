package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.med.info.domain.Miss_control_userAndRole;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_userAndRoleMapper;
import com.med.info.service.MissControlUserAndRoleService;

public class MissControlUserAndRoleServiceImpl extends BaseServiceImpl<Miss_control_userAndRole> implements MissControlUserAndRoleService {

	@Autowired
	private Miss_control_userAndRoleMapper userAndRoleMapper;

	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return userAndRoleMapper;
	}
	
	
	
}
