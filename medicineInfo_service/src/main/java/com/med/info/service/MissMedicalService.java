package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_medical;
import com.med.info.mapper.domain.MedicalMapDTO;

public interface MissMedicalService extends BaseService<Miss_medical>{

	List<MedicalMapDTO> getMedicalMapDTOBySymptomId(Long id);

}
