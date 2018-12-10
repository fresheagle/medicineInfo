package com.med.info.mapper.domain;

import java.io.Serializable;
import java.util.List;

import com.med.info.domain.Miss_symptom;
import com.med.info.domain.Miss_symptomWithBLOBs;

public class SymptomDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Miss_symptomWithBLOBs missSymptom;
	private List<MedicalMapDTO> medicalList;
	private List<DislocationMapDTO> dislocationList;
	public Miss_symptomWithBLOBs getMissSymptom() {
		return missSymptom;
	}
	public void setMissSymptom(Miss_symptomWithBLOBs missSymptom) {
		this.missSymptom = missSymptom;
	}
	public List<MedicalMapDTO> getMedicalList() {
		return medicalList;
	}
	public void setMedicalList(List<MedicalMapDTO> medicalList) {
		this.medicalList = medicalList;
	}
	public List<DislocationMapDTO> getDislocationList() {
		return dislocationList;
	}
	public void setDislocationList(List<DislocationMapDTO> dislocationList) {
		this.dislocationList = dislocationList;
	}
	
	
}
