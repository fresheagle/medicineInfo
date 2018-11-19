package com.med.info.service.dto;

import java.io.Serializable;
import java.util.List;

public class UserPrivilegeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String path;
	private String name;
	private List<UserPrivilegeDTO> children;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserPrivilegeDTO> getChildren() {
		return children;
	}
	public void setChildren(List<UserPrivilegeDTO> children) {
		this.children = children;
	}
	
	
	

}
