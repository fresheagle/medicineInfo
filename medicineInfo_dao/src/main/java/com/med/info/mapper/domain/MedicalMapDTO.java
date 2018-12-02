package com.med.info.mapper.domain;

import java.io.Serializable;

public class MedicalMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long medical_id;
	private String medical_name;
	private String medical_type;
	
	public Long getMedical_id() {
		return medical_id;
	}
	public void setMedical_id(Long medical_id) {
		this.medical_id = medical_id;
	}
	public String getMedical_name() {
		return medical_name;
	}
	public void setMedical_name(String medical_name) {
		this.medical_name = medical_name;
	}
	public String getMedical_type() {
		return medical_type;
	}
	public void setMedical_type(String medical_type) {
		this.medical_type = medical_type;
	}
}
