package com.med.info.mapper.domain;

import java.io.Serializable;

/**
 * 部门科室信息传输实体类
 * @author zhangmin
 */
public class DepartmentMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String departmentCode;
	private String departmentName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
