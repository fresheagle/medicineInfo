package com.med.info.mapper.domain;

import java.io.Serializable;

public class DislocationMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String level;
	private String dislocationName;
	private Long dislocationId;
	private Long parentDislocationId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDislocationName() {
		return dislocationName;
	}

	public void setDislocationName(String dislocationName) {
		this.dislocationName = dislocationName;
	}

	public Long getParentDislocationId() {
		return parentDislocationId;
	}

	public void setParentDislocationId(Long parentDislocationId) {
		this.parentDislocationId = parentDislocationId;
	}

	public Long getDislocationId() {
		return dislocationId;
	}

	public void setDislocationId(Long dislocationId) {
		this.dislocationId = dislocationId;
	}
}
