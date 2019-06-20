package com.med.info.export;

import java.util.List;

import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.domain.Miss_institution_keypartment_mapping;

public class MissInstitutionTransBean {
	List<Miss_institutionWithBLOBs> miss_institutionWithBLOBs;
	List<Miss_institution_keypartment_mapping> miss_institution_keypartment_mapping;

	public List<Miss_institutionWithBLOBs> getMiss_institutionWithBLOBs() {
		return miss_institutionWithBLOBs;
	}

	public void setMiss_institutionWithBLOBs(List<Miss_institutionWithBLOBs> miss_institutionWithBLOBs) {
		this.miss_institutionWithBLOBs = miss_institutionWithBLOBs;
	}

	public List<Miss_institution_keypartment_mapping> getMiss_institution_keypartment_mapping() {
		return miss_institution_keypartment_mapping;
	}

	public void setMiss_institution_keypartment_mapping(
			List<Miss_institution_keypartment_mapping> miss_institution_keypartment_mapping) {
		this.miss_institution_keypartment_mapping = miss_institution_keypartment_mapping;
	}
	
}
