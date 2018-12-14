package com.med.info.mapper.domain;

import java.io.Serializable;
import java.util.List;

import com.med.info.domain.Miss_medicalWithBLOBs;

/**
 * 药品信息传输实体类
 * @author zhangmin
 *
 */
public class MedicalDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Miss_medicalWithBLOBs missMedical;
	private List<MedicalCompanyMapDTO> medicalCompanyList;

	public Miss_medicalWithBLOBs getMissMedical() {
		return missMedical;
	}

	public void setMissMedical(Miss_medicalWithBLOBs missMedical) {
		this.missMedical = missMedical;
	}

	public List<MedicalCompanyMapDTO> getMedicalCompanyList() {
		return medicalCompanyList;
	}
	public void setMedicalCompanyList(List<MedicalCompanyMapDTO> medicalCompanyList) {
		this.medicalCompanyList = medicalCompanyList;
	}
	
}
