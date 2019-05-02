package com.med.info.mapper.domain;

import java.io.Serializable;

/**
 * 部门科室信息传输实体类
 * @author zhangmin
 */
public class DepartmentMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long departmentId;
	private Long parentDepartmentId;
	private String office;
	private String departmentCode;
	private String departmentName;
	private String departmentLevel;
	public Long getId() {
		return departmentId;
	}
	public void setId(Long departmentId) {
		this.departmentId = departmentId;
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

	public String getDepartmentLevel() {
		return departmentLevel;
	}

	public void setDepartmentLevel(String departmentLevel) {
		this.departmentLevel = departmentLevel;
	}
	public Long getParentDepartmentId() {
		return parentDepartmentId;
	}
	public void setParentDepartmentId(Long parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
}
