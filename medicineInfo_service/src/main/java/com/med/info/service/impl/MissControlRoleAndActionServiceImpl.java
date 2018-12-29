package com.med.info.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_control_action;
import com.med.info.domain.Miss_control_role;
import com.med.info.domain.Miss_control_roleAndAction;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_actionMapper;
import com.med.info.mapper.Miss_control_roleAndActionMapper;
import com.med.info.mapper.Miss_control_roleMapper;
import com.med.info.mapper.domain.RoleAndActionDTO;
import com.med.info.service.MissControlRoleAndActionService;
import com.med.info.utils.CollectionUtil;
import com.med.info.utils.UuidUtils;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class MissControlRoleAndActionServiceImpl extends BaseServiceImpl<Miss_control_roleAndAction> implements MissControlRoleAndActionService {

	@Autowired
	private Miss_control_roleAndActionMapper roleAndActionMapper;
	@Autowired
	private Miss_control_actionMapper missControlActionMapper;
	@Autowired
	private Miss_control_roleMapper missControlRoleMapper;
	
	@Override
	public BaseMapper getMapper() {
		return roleAndActionMapper;
	}

	@Override
	public boolean insertRoleAndAction(RoleAndActionDTO roleAndActionDTO) {
		// TODO Auto-generated method stub
		roleAndActionMapper.deleteByRoleCode(roleAndActionDTO.getMissControlRole().getRolecode());
		if(CollectionUtil.isNotEmpty(roleAndActionDTO.getMissControlAction())) {
			for(Miss_control_action miss_control_action : roleAndActionDTO.getMissControlAction()) {
				Miss_control_roleAndAction miss_control_roleAndAction = new Miss_control_roleAndAction();
				miss_control_roleAndAction.setRauuid(UuidUtils.generateUUID());
				miss_control_roleAndAction.setRolecode(roleAndActionDTO.getMissControlRole().getRolecode());
				miss_control_roleAndAction.setActioncode(miss_control_action.getActioncode());
				roleAndActionMapper.insert(miss_control_roleAndAction);
			}
			return true;
		}
		return false;
	}

	@Override
	public RoleAndActionDTO showRoelAndAction(Miss_control_role miss_control_role) {
		// TODO Auto-generated method stub
		RoleAndActionDTO roleAndActionDTO = new RoleAndActionDTO();
		Miss_control_roleAndAction missControlRoleAndAction = new Miss_control_roleAndAction();
		missControlRoleAndAction.setRolecode(miss_control_role.getRolecode());
		List<Miss_control_roleAndAction> selectPage = roleAndActionMapper.selectByRoleCode(missControlRoleAndAction);
		List<Miss_control_action> missControlAction = new ArrayList<>();
		for(int i=0;i<selectPage.size();i++){
			missControlAction.add(missControlActionMapper.selectByActionCode(selectPage.get(i).getActioncode()).get(0));
		}
		List<Miss_control_action> missControlActionElse = new ArrayList<>();
		missControlActionElse=missControlActionMapper.selectAll(new Miss_control_action());
		for(int i=0;i<missControlAction.size();i++) {
			for(int j=0;j<missControlActionElse.size();j++) {
				if(missControlAction.get(i).getActionuuid().equals(missControlActionElse.get(j).getActionuuid())) {
					missControlActionElse.remove(j);
				}
			}
		}
		roleAndActionDTO.setMissControlActionElse(missControlActionElse);
		roleAndActionDTO.setMissControlRole(missControlRoleMapper.selectByRoleCode(miss_control_role.getRolecode()));
		roleAndActionDTO.setMissControlAction(missControlAction);
		return roleAndActionDTO;
	}

	@Override
	public int deleteByRoleCode(String roleCode) {
		return roleAndActionMapper.deleteByRoleCode(roleCode);
	}
}
