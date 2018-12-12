package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.med.info.domain.Miss_control_role;
import com.med.info.domain.Miss_control_userAndRole;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_userAndRoleMapper;
import com.med.info.mapper.domain.UserAndRoleDTO;
import com.med.info.service.MissControlUserAndRoleService;
import com.med.info.utils.CollectionUtil;
import com.med.info.utils.UuidUtils;

public class MissControlUserAndRoleServiceImpl extends BaseServiceImpl<Miss_control_userAndRole> implements MissControlUserAndRoleService {

	@Autowired
	private Miss_control_userAndRoleMapper userAndRoleMapper;

	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return userAndRoleMapper;
	}

	@Override
	public boolean insertUserAndRole(UserAndRoleDTO userAndRoleDTO) {
		// TODO Auto-generated method stub
		userAndRoleMapper.deleteByUserCode(userAndRoleDTO.getMissControlUser().getUserCode());
		if(CollectionUtil.isNotEmpty(userAndRoleDTO.getMissControlRole())) {
			for(Miss_control_role miss_control_role : userAndRoleDTO.getMissControlRole()) {
				Miss_control_userAndRole miss_control_userAndRole = new Miss_control_userAndRole();
				miss_control_userAndRole.setUruuid(UuidUtils.generateUUID());
				miss_control_userAndRole.setUsercode(userAndRoleDTO.getMissControlUser().getUserCode());
				miss_control_userAndRole.setRolecode(miss_control_role.getRolecode());
//				miss_control_userAndRole.setRelationcreatedate(relationcreatedate);
				userAndRoleMapper.insert(miss_control_userAndRole);
			}
			return true;
		}
		return false;
	}
	
	
	
}
