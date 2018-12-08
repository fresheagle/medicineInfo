package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.mapper.domain.InstitutionInfoDTO;
import com.med.info.mapper.domain.InstitutionInfoMapDTO;

public interface MissInstitutionService extends BaseService<Miss_institutionWithBLOBs>{

	List<InstitutionInfoMapDTO> getInstitutionInfoMapDTOByDoctorId(Long id);

	Object getByPage(Integer currentPage, Integer pageSize, String name, String level, String address, String category);
	
}
