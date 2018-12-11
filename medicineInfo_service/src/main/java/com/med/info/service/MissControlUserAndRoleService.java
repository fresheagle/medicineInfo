package com.med.info.service;

import com.med.info.domain.Miss_control_userAndRole;
import com.med.info.mapper.domain.UserAndRoleDTO;

public interface MissControlUserAndRoleService extends BaseService<Miss_control_userAndRole>{

	public boolean insertUserAndRole(UserAndRoleDTO userAndRoleDTO);
}
