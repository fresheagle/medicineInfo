package com.med.info.service;

import com.med.info.domain.Miss_control_user;
import com.med.info.domain.Miss_control_userAndRole;
import com.med.info.mapper.domain.UserAndRoleDTO;

public interface MissControlUserAndRoleService extends BaseService<Miss_control_userAndRole>{

	public boolean insertUserAndRole(UserAndRoleDTO userAndRoleDTO);

	public UserAndRoleDTO showUserAndRole(Miss_control_user miss_control_user);

	public int deleteByUserCode(String userCode);
}
