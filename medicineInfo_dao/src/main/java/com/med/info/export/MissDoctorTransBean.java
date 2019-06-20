package com.med.info.export;

import java.util.List;

import com.med.info.domain.Miss_department_doctor_mapping;
import com.med.info.domain.Miss_doctorWithBLOBs;
import com.med.info.domain.Miss_institution_doctor_mapping;

public class MissDoctorTransBean {
	private List<Miss_doctorWithBLOBs> miss_doctorWithBLOBs;
	private List<Miss_institution_doctor_mapping> miss_institution_doctor_mapping;
	private List<Miss_department_doctor_mapping> miss_department_doctor_mapping;
	public List<Miss_doctorWithBLOBs> getMiss_doctorWithBLOBs() {
		return miss_doctorWithBLOBs;
	}

	public void setMiss_doctorWithBLOBs(List<Miss_doctorWithBLOBs> miss_doctorWithBLOBs) {
		this.miss_doctorWithBLOBs = miss_doctorWithBLOBs;
	}

	public List<Miss_institution_doctor_mapping> getMiss_institution_doctor_mapping() {
		return miss_institution_doctor_mapping;
	}

	public void setMiss_institution_doctor_mapping(List<Miss_institution_doctor_mapping> miss_institution_doctor_mapping) {
		this.miss_institution_doctor_mapping = miss_institution_doctor_mapping;
	}

	public List<Miss_department_doctor_mapping> getMiss_department_doctor_mapping() {
		return miss_department_doctor_mapping;
	}

	public void setMiss_department_doctor_mapping(List<Miss_department_doctor_mapping> miss_department_doctor_mapping) {
		this.miss_department_doctor_mapping = miss_department_doctor_mapping;
	}
	
}
