package com.med.info.service.dto;

import java.io.Serializable;
import java.util.List;

import com.med.info.domain.Miss_disease;
import com.med.info.domain.Miss_diseaseWithBLOBs;

/**
 * 疾病基础信息传输实体类
 * @author zhangmin
 */
public class DiseaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Miss_diseaseWithBLOBs miss_disease;
	private List<DepartmentMapDTO> disease_department_mapping_list;
	private List<SymptomMapDTO> disease_symptom_mapping_list;
	
	public Miss_diseaseWithBLOBs getMiss_disease() {
		return miss_disease;
	}
	public void setMiss_disease(Miss_diseaseWithBLOBs miss_disease) {
		this.miss_disease = miss_disease;
	}
	public List<DepartmentMapDTO> getDisease_department_mapping_list() {
		return disease_department_mapping_list;
	}
	public void setDisease_department_mapping_list(List<DepartmentMapDTO> disease_department_mapping_list) {
		this.disease_department_mapping_list = disease_department_mapping_list;
	}
	public List<SymptomMapDTO> getDisease_symptom_mapping_list() {
		return disease_symptom_mapping_list;
	}
	public void setDisease_symptom_mapping_list(List<SymptomMapDTO> disease_symptom_mapping_list) {
		this.disease_symptom_mapping_list = disease_symptom_mapping_list;
	}
}
