package com.med.info.export;

import java.util.List;

import com.med.info.domain.Miss_disease_department_mapping;
import com.med.info.domain.Miss_disease_dislocation_mapping;
import com.med.info.domain.Miss_western_diseaseWithBLOBs;

public class MissWesternDiseaseTransBean {
	private List<Miss_western_diseaseWithBLOBs> miss_western_diseaseWithBLOBs;
	private List<Miss_disease_department_mapping> miss_disease_department_mapping;
	private List<Miss_disease_dislocation_mapping> miss_disease_dislocation_mapping;
	public List<Miss_western_diseaseWithBLOBs> getMiss_western_diseaseWithBLOBs() {
		return miss_western_diseaseWithBLOBs;
	}
	public void setMiss_western_diseaseWithBLOBs(List<Miss_western_diseaseWithBLOBs> miss_western_diseaseWithBLOBs) {
		this.miss_western_diseaseWithBLOBs = miss_western_diseaseWithBLOBs;
	}
	public List<Miss_disease_department_mapping> getMiss_disease_department_mapping() {
		return miss_disease_department_mapping;
	}
	public void setMiss_disease_department_mapping(List<Miss_disease_department_mapping> miss_disease_department_mapping) {
		this.miss_disease_department_mapping = miss_disease_department_mapping;
	}
	public List<Miss_disease_dislocation_mapping> getMiss_disease_dislocation_mapping() {
		return miss_disease_dislocation_mapping;
	}
	public void setMiss_disease_dislocation_mapping(List<Miss_disease_dislocation_mapping> miss_disease_dislocation_mapping) {
		this.miss_disease_dislocation_mapping = miss_disease_dislocation_mapping;
	}
} 
