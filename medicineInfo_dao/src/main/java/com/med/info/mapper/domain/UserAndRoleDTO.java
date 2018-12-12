package com.med.info.mapper.domain;

import java.util.List;

import com.med.info.domain.Miss_control_role;
import com.med.info.domain.Miss_control_user;

public class UserAndRoleDTO {

	Miss_control_user missControlUser;
	List<Miss_control_role> missControlRole;
	public Miss_control_user getMissControlUser() {
		return missControlUser;
	}
	public void setMissControlUser(Miss_control_user missControlUser) {
		this.missControlUser = missControlUser;
	}
	public List<Miss_control_role> getMissControlRole() {
		return missControlRole;
	}
	public void setMissControlRole(List<Miss_control_role> missControlRole) {
		this.missControlRole = missControlRole;
	}
	
}
