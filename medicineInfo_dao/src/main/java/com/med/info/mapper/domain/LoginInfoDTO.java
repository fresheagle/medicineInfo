package com.med.info.mapper.domain;

import java.io.Serializable;
import java.util.List;

public class LoginInfoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userUuid;    
	private String userName;
	private String userCode;
	private String token;
	private List<String> roleCodes;
	private List<UserPrivilegeDTO> userPrivilege;

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

	public List<UserPrivilegeDTO> getUserPrivilege() {
		return userPrivilege;
	}

	public void setUserPrivilege(List<UserPrivilegeDTO> userPrivilege) {
		this.userPrivilege = userPrivilege;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getRoleCodes() {
		return roleCodes;
	}

	public void setRoleCodes(List<String> roleCodes) {
		this.roleCodes = roleCodes;
	}

	@Override
	public boolean equals(Object obj) {
		LoginInfoDTO loginInfo  = (LoginInfoDTO) obj;
		if(this.userUuid != null && loginInfo.getUserUuid() != null){
			return this.userUuid.equals(loginInfo.getUserUuid());
		}
		return false;
	}
}
