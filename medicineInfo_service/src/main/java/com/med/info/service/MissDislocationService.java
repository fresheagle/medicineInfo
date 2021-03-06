package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_dislocation;
import com.med.info.mapper.domain.DislocationMapDTO;

public interface MissDislocationService extends BaseService<Miss_dislocation>{
	
	Object getDislocationMapDTOByName(Integer currentPage, Integer pageSize, Long id, Long parentDislocationId, String dislocationName);

	List<DislocationMapDTO> getDislocationMapDTOBySymptomId(Long id);
}
