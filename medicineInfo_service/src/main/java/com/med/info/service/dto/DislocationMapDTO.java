package com.med.info.service.dto;

import java.io.Serializable;

public class DislocationMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long dislocation_id;
	private String dislocation_code;
	private String dislocation_name;
	
	public Long getDislocation_id() {
		return dislocation_id;
	}
	public void setDislocation_id(Long dislocation_id) {
		this.dislocation_id = dislocation_id;
	}
	public String getDislocation_code() {
		return dislocation_code;
	}
	public void setDislocation_code(String dislocation_code) {
		this.dislocation_code = dislocation_code;
	}
	public String getDislocation_name() {
		return dislocation_name;
	}
	public void setDislocation_name(String dislocation_name) {
		this.dislocation_name = dislocation_name;
	}
}
