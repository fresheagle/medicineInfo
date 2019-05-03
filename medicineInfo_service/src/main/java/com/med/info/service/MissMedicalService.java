package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_medical;
import com.med.info.domain.Miss_medicalWithBLOBs;
import com.med.info.mapper.domain.MedicalMapDTO;

public interface MissMedicalService extends BaseService<Miss_medicalWithBLOBs>{

	List<MedicalMapDTO> getMedicalMapDTOBySymptomId(Long id);

	Object getByPage(Integer currentPage, Integer pageSize, String name, String chinesePinyin, String alisaName, String shopName, String englishName);

	String checkMedicalInfo(String comName, String englishName, String chinesePinyin, String shopName) throws Exception;
}
