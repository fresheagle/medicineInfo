package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.med.info.domain.Miss_institution_keypartment_mapping;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_institution_keypartment_mappingMapper;
import com.med.info.service.MissInstitutionDepartmentService;

public class MissInstitutionDepartmentServiceImpl extends BaseServiceImpl<Miss_institution_keypartment_mapping> implements MissInstitutionDepartmentService{

	@Autowired
	private Miss_institution_keypartment_mappingMapper miss_institution_keypartment_mappingMapper;
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return miss_institution_keypartment_mappingMapper;
	}

}
