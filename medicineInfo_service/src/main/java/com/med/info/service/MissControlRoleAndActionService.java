package com.med.info.service;

import com.med.info.domain.Miss_control_role;
import com.med.info.domain.Miss_control_roleAndAction;
import com.med.info.mapper.domain.RoleAndActionDTO;

public interface MissControlRoleAndActionService extends BaseService<Miss_control_roleAndAction>{

	public boolean insertRoleAndAction(RoleAndActionDTO roleAndActionDTO);
	
	public RoleAndActionDTO showRoelAndAction(Miss_control_role miss_control_role);
}
