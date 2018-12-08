package com.med.info.mapper.domain;

import java.io.Serializable;

public class MedicalMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String medicalName;
	private String medicalType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMedicalName() {
		return medicalName;
	}
	public void setMedicalName(String medicalName) {
		this.medicalName = medicalName;
	}
	public String getMedicalType() {
		return medicalType;
	}
	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}
	
}
