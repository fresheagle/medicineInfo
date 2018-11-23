package com.med.info.service.dto;

import java.io.Serializable;

/**
 * 部门科室信息传输实体类
 * @author zhangmin
 */
public class DepartmentMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer department_id;
	private String department_code;
	private String department_name;
	
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_code() {
		return department_code;
	}
	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
}
