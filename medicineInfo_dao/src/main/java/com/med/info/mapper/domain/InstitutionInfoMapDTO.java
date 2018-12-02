package com.med.info.mapper.domain;

import java.io.Serializable;

public class InstitutionInfoMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long institution_id;
	private String institution_name;
	private String institution_level;
	private String institution_address;
	
	public Long getInstitution_id() {
		return institution_id;
	}
	public void setInstitution_id(Long institution_id) {
		this.institution_id = institution_id;
	}
	public String getInstitution_name() {
		return institution_name;
	}
	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}
	public String getInstitution_level() {
		return institution_level;
	}
	public void setInstitution_level(String institution_level) {
		this.institution_level = institution_level;
	}
	public String getInstitution_address() {
		return institution_address;
	}
	public void setInstitution_address(String institution_address) {
		this.institution_address = institution_address;
	}
}
