package com.med.info.service.dto;

import java.io.Serializable;
import java.util.List;

import com.med.info.domain.Miss_symptom;

public class SymptomDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Miss_symptom miss_symptom;
	private List<MedicalMapDTO> medical_list;
	private List<DislocationMapDTO> dislocation_list;
	
	public Miss_symptom getMiss_symptom() {
		return miss_symptom;
	}
	public void setMiss_symptom(Miss_symptom miss_symptom) {
		this.miss_symptom = miss_symptom;
	}
	public List<MedicalMapDTO> getMedical_list() {
		return medical_list;
	}
	public void setMedical_list(List<MedicalMapDTO> medical_list) {
		this.medical_list = medical_list;
	}
	public List<DislocationMapDTO> getDislocation_list() {
		return dislocation_list;
	}
	public void setDislocation_list(List<DislocationMapDTO> dislocation_list) {
		this.dislocation_list = dislocation_list;
	}
}
