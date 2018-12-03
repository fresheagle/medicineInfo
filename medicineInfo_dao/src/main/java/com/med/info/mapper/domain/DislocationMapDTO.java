package com.med.info.mapper.domain;

import java.io.Serializable;

public class DislocationMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String level;
	private String dislocation_name;
	private Long parent_dislocation_id;
	
	public Long getParent_dislocation_id() {
		return parent_dislocation_id;
	}
	public void setParent_dislocation_id(Long parent_dislocation_id) {
		this.parent_dislocation_id = parent_dislocation_id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDislocation_name() {
		return dislocation_name;
	}
	public void setDislocation_name(String dislocation_name) {
		this.dislocation_name = dislocation_name;
	}
}
