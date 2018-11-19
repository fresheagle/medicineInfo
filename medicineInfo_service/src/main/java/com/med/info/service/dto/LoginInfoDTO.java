package com.med.info.service.dto;

import java.io.Serializable;

public class LoginInfoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userUuid;    
	private String userName;
	private String userCode;
	
	private UserPrivilegeDTO userPrivilege;

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public UserPrivilegeDTO getUserPrivilege() {
		return userPrivilege;
	}

	public void setUserPrivilege(UserPrivilegeDTO userPrivilege) {
		this.userPrivilege = userPrivilege;
	}
	
}
