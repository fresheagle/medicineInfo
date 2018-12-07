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
	private List<DepartmentMapDTO> departmentMapDTO;
	private List<SymptomMapDTO> symptomMapDTO;
	public Miss_diseaseWithBLOBs getMissDisease() {
		return missDisease;
	}
	public void setMissDisease(Miss_diseaseWithBLOBs missDisease) {
		this.missDisease = missDisease;
	}
	public List<DepartmentMapDTO> getDepartmentMapDTO() {
		return departmentMapDTO;
	}
	public void setDepartmentMapDTO(List<DepartmentMapDTO> departmentMapDTO) {
		this.departmentMapDTO = departmentMapDTO;
	}
	public List<SymptomMapDTO> getSymptomMapDTO() {
		return symptomMapDTO;
	}
	public void setSymptomMapDTO(List<SymptomMapDTO> symptomMapDTO) {
		this.symptomMapDTO = symptomMapDTO;
	}
	
	
}
