package com.med.info.mapper.domain;

import java.io.Serializable;
import java.util.List;

import com.med.info.domain.Miss_control_action;
import com.med.info.domain.Miss_control_role;

public class RoleAndActionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Miss_control_role missControlRole;
	private List<Miss_control_action> missControlAction;
	private List<Miss_control_action> missControlActionElse;
	public List<Miss_control_action> getMissControlActionElse() {
		return missControlActionElse;
	}
	public void setMissControlActionElse(List<Miss_control_action> missControlActionElse) {
		this.missControlActionElse = missControlActionElse;
	}
	public Miss_control_role getMissControlRole() {
		return missControlRole;
	}
	public void setMissControlRole(Miss_control_role missControlRole) {
		this.missControlRole = missControlRole;
	}
	public List<Miss_control_action> getMissControlAction() {
		return missControlAction;
	}
	public void setMissControlAction(List<Miss_control_action> missControlAction) {
		this.missControlAction = missControlAction;
	}
	
}
