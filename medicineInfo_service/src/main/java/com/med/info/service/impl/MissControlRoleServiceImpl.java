package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_control_role;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_roleMapper;
import com.med.info.service.MissControlRoleService;

@Service
public class MissControlRoleServiceImpl extends BaseServiceImpl<Miss_control_role> implements MissControlRoleService{

	@Autowired
	private Miss_control_roleMapper roleMapper;
	
	@Override
	public BaseMapper getMapper() {
		return roleMapper;
	}

	@Override
	public int deleteByPrimaryId(String uuid) {
		return roleMapper.deleteByPrimaryKey(uuid);
	}

}
