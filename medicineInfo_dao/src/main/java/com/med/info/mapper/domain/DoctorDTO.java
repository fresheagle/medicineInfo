package com.med.info.mapper.domain;

import java.io.Serializable;
import java.util.List;

import com.med.info.domain.Miss_doctor;
import com.med.info.domain.Miss_doctorWithBLOBs;

public class DoctorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Miss_doctorWithBLOBs missDoctor;
	private List<DepartmentMapDTO> departmentList;
	private List<InstitutionInfoMapDTO> institutionList;
	public Miss_doctorWithBLOBs getMissDoctor() {
		return missDoctor;
	}
	public void setMissDoctor(Miss_doctorWithBLOBs missDoctor) {
		this.missDoctor = missDoctor;
	}
	public List<DepartmentMapDTO> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<DepartmentMapDTO> departmentList) {
		this.departmentList = departmentList;
	}
	public List<InstitutionInfoMapDTO> getInstitutionList() {
		return institutionList;
	}
	public void setInstitutionList(List<InstitutionInfoMapDTO> institutionList) {
		this.institutionList = institutionList;
	}
	
	
	
}
