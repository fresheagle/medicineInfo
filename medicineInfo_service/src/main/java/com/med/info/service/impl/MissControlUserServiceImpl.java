package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.med.info.domain.Miss_control_user;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_userMapper;
import com.med.info.service.MissControlUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissControlUserServiceImpl extends BaseServiceImpl<Miss_control_user> implements MissControlUserService{

	@Autowired
	private Miss_control_userMapper userMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return userMapper;
	}

	@Override
	public Miss_control_user selectByCode(String userCode) {
		return userMapper.selectByCode(userCode);
	}

	@Override
	public List<String> selectUserCodeByNames(List<String> names) {
		if(null == names || names.size() == 0){
			return null;
		}
		return userMapper.selectUserCodeByNames(names);
	}

	@Override
	public boolean isOnlyEditor(String userCode) {
		// TODO Auto-generated method stub
		List<String> roleList = userMapper.getUserRoleCode(userCode);
		if(1 == roleList.size() &&  roleList.get(0).equals("001")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isAdministrator(String userCode) {
		// TODO Auto-generated method stub
		List<String> roleList = userMapper.getUserRoleCode(userCode);
		for (String role : roleList) {
			if(role.equals("000")) {
				return true;
			}
		}
		return false;
	}
}
