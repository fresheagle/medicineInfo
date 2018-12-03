package com.med.info.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.DiseaseMapDTO;
import com.med.info.mapper.domain.SymptomMapDTO;
import com.med.info.service.ParamInfoService;


@Service
public class ParamInfoServiceImpl implements ParamInfoService {
    @Override
    public List<DiseaseMapDTO> queryDiseaseInfoName() {
        return null;
    }

    @Override
    public List<Map<Integer, String>> queryInstitutionInfoName() {
        return null;
    }

    @Override
    public List<DepartmentMapDTO> queryDepartmentInfo() {
        return null;
    }

    @Override
    public List<SymptomMapDTO> querySymptomInfo() {
        return null;
    }
}
