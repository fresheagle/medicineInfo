package com.med.info.service.dto;

import java.io.Serializable;

public class LoginInfoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserPrivilegeDTO userPrivilege;

	public UserPrivilegeDTO getUserPrivilege() {
		return userPrivilege;
	}

	public void setUserPrivilege(UserPrivilegeDTO userPrivilege) {
		this.userPrivilege = userPrivilege;
	}
	
}
