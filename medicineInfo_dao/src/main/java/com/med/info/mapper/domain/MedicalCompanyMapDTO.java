package com.med.info.mapper.domain;

import java.io.Serializable;

public class MedicalCompanyMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long medicalCompanyId;
	private String companyChineseName;
	private String companyEnglishName;

	public Long getMedicalCompanyId() {
		return medicalCompanyId;
	}

	public void setMedicalCompanyId(Long medicalCompanyId) {
		this.medicalCompanyId = medicalCompanyId;
	}

	public String getCompanyChineseName() {
		return companyChineseName;
	}
	public void setCompanyChineseName(String companyChineseName) {
		this.companyChineseName = companyChineseName;
	}
	public String getCompanyEnglishName() {
		return companyEnglishName;
	}
	public void setCompanyEnglishName(String companyEnglishName) {
		this.companyEnglishName = companyEnglishName;
	}
	
}
