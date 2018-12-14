package com.med.info.service.impl;

import com.med.info.domain.Miss_control_user;
import com.med.info.mapper.Miss_control_roleMapper;
import com.med.info.mapper.Miss_control_userMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.med.info.domain.Miss_control_role;
import com.med.info.domain.Miss_control_userAndRole;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_userAndRoleMapper;
import com.med.info.mapper.domain.UserAndRoleDTO;
import com.med.info.service.MissControlUserAndRoleService;
import com.med.info.utils.CollectionUtil;
import com.med.info.utils.UuidUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class MissControlUserAndRoleServiceImpl extends BaseServiceImpl<Miss_control_userAndRole> implements MissControlUserAndRoleService {

	@Autowired
	private Miss_control_userAndRoleMapper userAndRoleMapper;

	@Autowired
	private Miss_control_roleMapper missControlRoleMapper;
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

	@Override
	public UserAndRoleDTO showUserAndRole(Miss_control_user miss_control_user) {
		UserAndRoleDTO userAndRoleDTO = new UserAndRoleDTO();
		Miss_control_userAndRole miss_control_userAndRole = new Miss_control_userAndRole();
		miss_control_userAndRole.setUsercode(miss_control_user.getUserCode());
		List<Miss_control_userAndRole> selectPage = userAndRoleMapper.selectByCode(miss_control_userAndRole);
		List<Miss_control_role> missControlRole = new ArrayList<>();
		for(int i=0;i<selectPage.size();i++){
			missControlRole.add(i,missControlRoleMapper.selectByRoleCode(selectPage.get(i).getRolecode()));
		}
		userAndRoleDTO.setMissControlRole(missControlRole);
		userAndRoleDTO.setMissControlUser(miss_control_user);
		return userAndRoleDTO;
	}


}
