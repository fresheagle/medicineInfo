package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.med.info.domain.Miss_control_user;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_userMapper;
import com.med.info.service.MissControlUserService;

public class MissControlUserServiceImpl extends BaseServiceImpl<Miss_control_user> implements MissControlUserService{

	@Autowired
	private Miss_control_userMapper userMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return userMapper;
	}

}
