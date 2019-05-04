package com.med.info.service.operate.impl;

import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_medicalWithBLOBs;
import com.med.info.domain.Miss_medical_medicalcompany_mapping;
import com.med.info.dto.MissInstitutionDTO;
import com.med.info.dto.MissMedicalDTO;
import com.med.info.mapper.Miss_medical_medicalcompany_mappingMapper;
import com.med.info.mapper.domain.MedicalCompanyMapDTO;
import com.med.info.mapper.domain.MedicalDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissMedicalService;
import com.med.info.utils.CollectionUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Order(6)
public class MissWesternMedicalOperateService extends AbstractOperateService<Miss_medicalWithBLOBs, MissMedicalDTO> {

    @Autowired
    private MissMedicalService medicalService;

    private static Logger logger = LoggerFactory.getLogger(MissWesternMedicalOperateService.class);
    
    @Override
    public String getCurrentMenuType() {
        return "missWestMedical";
    }

    @Override
    public BaseService<Miss_medicalWithBLOBs> baseService(String menuType) {
        return medicalService;
    }

    @Override
    public Class<?> getCurrentObjectClass() {
        return MissMedicalDTO.class;
    }

    @Override
    public Miss_medicalWithBLOBs converseObject(MissMedicalDTO missMedicalDTO) {
    	Miss_medicalWithBLOBs miss_medicalWithBLOBs = new Miss_medicalWithBLOBs();
    	BeanUtils.copyProperties(missMedicalDTO, miss_medicalWithBLOBs);
    	return miss_medicalWithBLOBs;
    }

    @Override
    public boolean needDealMapper() {
        return false;
    }

	@Override
	public String getJsonParamKey() {
		// TODO Auto-generated method stub
		return "missWestMedical";
	}
}
