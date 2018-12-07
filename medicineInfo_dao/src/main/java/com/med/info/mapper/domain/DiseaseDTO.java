package com.med.info.mapper.domain;

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
	
	private Miss_diseaseWithBLOBs missDisease;
	private List<DepartmentMapDTO> diseaseDepartmentMappingList;
	private List<SymptomMapDTO> diseaseSymptomMappingList;
	public Miss_diseaseWithBLOBs getMissDisease() {
		return missDisease;
	}
	public void setMissDisease(Miss_diseaseWithBLOBs missDisease) {
		this.missDisease = missDisease;
	}
	public List<DepartmentMapDTO> getDiseaseDepartmentMappingList() {
		return diseaseDepartmentMappingList;
	}
	public void setDiseaseDepartmentMappingList(List<DepartmentMapDTO> diseaseDepartmentMappingList) {
		this.diseaseDepartmentMappingList = diseaseDepartmentMappingList;
	}
	public List<SymptomMapDTO> getDiseaseSymptomMappingList() {
		return diseaseSymptomMappingList;
	}
	public void setDiseaseSymptomMappingList(List<SymptomMapDTO> diseaseSymptomMappingList) {
		this.diseaseSymptomMappingList = diseaseSymptomMappingList;
	}
	
	
	
}
