package com.med.info.service.dto;

import java.io.Serializable;
import java.util.List;

import com.med.info.domain.Miss_disease;

public class DiseaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Miss_disease miss_disease;
	private List<DiseaseDepartmentMapDTO> disease_department_mapping_list;
	private List<DiseaseSymptomMapDTO> disease_symptom_mapping_list;
	
	public Miss_disease getMiss_disease() {
		return miss_disease;
	}
	public void setMiss_disease(Miss_disease miss_disease) {
		this.miss_disease = miss_disease;
	}
	public List<DiseaseDepartmentMapDTO> getDisease_department_mapping_list() {
		return disease_department_mapping_list;
	}
	public void setDisease_department_mapping_list(List<DiseaseDepartmentMapDTO> disease_department_mapping_list) {
		this.disease_department_mapping_list = disease_department_mapping_list;
	}
	public List<DiseaseSymptomMapDTO> getDisease_symptom_mapping_list() {
		return disease_symptom_mapping_list;
	}
	public void setDisease_symptom_mapping_list(List<DiseaseSymptomMapDTO> disease_symptom_mapping_list) {
		this.disease_symptom_mapping_list = disease_symptom_mapping_list;
	}
}
