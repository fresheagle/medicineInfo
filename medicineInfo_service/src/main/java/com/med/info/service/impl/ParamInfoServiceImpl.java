package com.med.info.service.impl;

import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.SymptomMapDTO;
import com.med.info.service.ParamInfoService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ParamInfoServiceImpl implements ParamInfoService {
    @Override
    public List<Map<Integer, String>> queryDiseaseInfoName() {
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
