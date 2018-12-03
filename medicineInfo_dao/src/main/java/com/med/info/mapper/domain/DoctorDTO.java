package com.med.info.mapper.domain;

import java.io.Serializable;
import java.util.List;

import com.med.info.domain.Miss_doctor;

public class DoctorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Miss_doctor miss_doctor;
	private List<DepartmentMapDTO> department_list;
	private List<InstitutionInfoMapDTO> institution_list;
	
	public Miss_doctor getMiss_doctor() {
		return miss_doctor;
	}
	public void setMiss_doctor(Miss_doctor miss_doctor) {
		this.miss_doctor = miss_doctor;
	}
	public List<DepartmentMapDTO> getDepartment_list() {
		return department_list;
	}
	public void setDepartment_list(List<DepartmentMapDTO> department_list) {
		this.department_list = department_list;
	}
	public List<InstitutionInfoMapDTO> getInstitution_list() {
		return institution_list;
	}
	public void setInstitution_list(List<InstitutionInfoMapDTO> institution_list) {
		this.institution_list = institution_list;
	}
	
}