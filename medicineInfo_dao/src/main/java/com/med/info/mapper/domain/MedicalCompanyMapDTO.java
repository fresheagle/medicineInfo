package com.med.info.mapper.domain;

import java.io.Serializable;

public class MedicalCompanyMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long medicalCompany_id;
	private String companyChineseName;
	private String companyEnglishName;
	
	public Long getMedicalCompany_id() {
		return medicalCompany_id;
	}
	public void setMedicalCompany_id(Long medicalCompany_id) {
		this.medicalCompany_id = medicalCompany_id;
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
