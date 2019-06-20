package com.med.info.export;

import java.util.List;

import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.domain.Miss_symptom_department_mapping;
import com.med.info.domain.Miss_symptom_dislocation_mapping;

public class MissSymptomTransBean {
	private List<Miss_symptomWithBLOBs>  miss_symptomWithBLOBs;
	private List<Miss_symptom_department_mapping> miss_symptom_department_mapping;
	private List<Miss_symptom_dislocation_mapping> miss_symptom_dislocation_mapping;
	public List<Miss_symptomWithBLOBs> getMiss_symptomWithBLOBs() {
		return miss_symptomWithBLOBs;
	}
	public void setMiss_symptomWithBLOBs(List<Miss_symptomWithBLOBs> miss_symptomWithBLOBs) {
		this.miss_symptomWithBLOBs = miss_symptomWithBLOBs;
	}
	public List<Miss_symptom_department_mapping> getMiss_symptom_department_mapping() {
		return miss_symptom_department_mapping;
	}
	public void setMiss_symptom_department_mapping(List<Miss_symptom_department_mapping> miss_symptom_department_mapping) {
		this.miss_symptom_department_mapping = miss_symptom_department_mapping;
	}
	public List<Miss_symptom_dislocation_mapping> getMiss_symptom_dislocation_mapping() {
		return miss_symptom_dislocation_mapping;
	}
	public void setMiss_symptom_dislocation_mapping(List<Miss_symptom_dislocation_mapping> miss_symptom_dislocation_mapping) {
		this.miss_symptom_dislocation_mapping = miss_symptom_dislocation_mapping;
	}
	
	
}
