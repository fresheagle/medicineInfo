package com.med.info.mapper.domain;

import java.io.Serializable;

public class InstitutionInfoMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String institutionName;
	private String institutionLevel;
	private String institutionAddress;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getInstitutionLevel() {
		return institutionLevel;
	}
	public void setInstitutionLevel(String institutionLevel) {
		this.institutionLevel = institutionLevel;
	}
	public String getInstitutionAddress() {
		return institutionAddress;
	}
	public void setInstitutionAddress(String institutionAddress) {
		this.institutionAddress = institutionAddress;
	}
	
	
}
