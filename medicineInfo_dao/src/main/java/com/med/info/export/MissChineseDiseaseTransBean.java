package com.med.info.export;

import java.util.List;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.domain.Miss_disease_department_mapping;
import com.med.info.domain.Miss_disease_dislocation_mapping;

public class MissChineseDiseaseTransBean {
	private List<Miss_chinese_diseaseWithBLOBs> miss_chinese_diseaseWithBLOBs;
	private List<Miss_disease_department_mapping> miss_disease_department_mapping;
	private List<Miss_disease_dislocation_mapping> miss_disease_dislocation_mapping;
	public List<Miss_disease_department_mapping> getMiss_disease_department_mapping() {
		return miss_disease_department_mapping;
	}
	public void setMiss_disease_department_mapping(List<Miss_disease_department_mapping> miss_disease_department_mapping) {
		this.miss_disease_department_mapping = miss_disease_department_mapping;
	}
	public List<Miss_disease_dislocation_mapping> getMiss_disease_dislocation_mapping() {
		return miss_disease_dislocation_mapping;
	}
	public void setMiss_disease_dislocation_mapping(
			List<Miss_disease_dislocation_mapping> miss_disease_dislocation_mapping) {
		this.miss_disease_dislocation_mapping = miss_disease_dislocation_mapping;
	}
	public List<Miss_chinese_diseaseWithBLOBs> getMiss_chinese_diseaseWithBLOBs() {
		return miss_chinese_diseaseWithBLOBs;
	}
	public void setMiss_chinese_diseaseWithBLOBs(List<Miss_chinese_diseaseWithBLOBs> miss_chinese_diseaseWithBLOBs) {
		this.miss_chinese_diseaseWithBLOBs = miss_chinese_diseaseWithBLOBs;
	}
}
