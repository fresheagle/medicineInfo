package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.mapper.domain.SymptomMapDTO;

public interface MissSymptomService extends BaseService<Miss_symptomWithBLOBs>{

	List<SymptomMapDTO> getSymptomMapDTOByDiseaseId(Long id);
}
