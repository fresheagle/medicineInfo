package com.med.info.service;

import com.med.info.domain.Miss_medical_companyWithBLOBs;
import com.med.info.mapper.domain.MedicalCompanyMapDTO;

import java.util.List;

public interface MissMedicalCompanyService extends BaseService<Miss_medical_companyWithBLOBs>{

    List<MedicalCompanyMapDTO> getCompanyByMedicalId(Long id);
}
