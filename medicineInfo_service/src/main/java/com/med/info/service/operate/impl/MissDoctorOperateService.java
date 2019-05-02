package com.med.info.service.operate.impl;

import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_department_doctor_mapping;
import com.med.info.domain.Miss_doctorWithBLOBs;
import com.med.info.domain.Miss_institution_doctor_mapping;
import com.med.info.mapper.Miss_department_doctor_mappingMapper;
import com.med.info.mapper.Miss_institution_doctor_mappingMapper;
import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.DoctorDTO;
import com.med.info.mapper.domain.InstitutionInfoMapDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissDoctorService;
import com.med.info.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Order(2)
public class MissDoctorOperateService extends AbstractOperateService<Miss_doctorWithBLOBs, Miss_doctorWithBLOBs> {

    @Autowired
    private MissDoctorService doctorService;
    @Autowired
    private Miss_institution_doctor_mappingMapper institutionDoctorMappingMapper;
    @Autowired
    private Miss_department_doctor_mappingMapper departmentDoctorMappingMapper;
    private static Logger logger = LoggerFactory.getLogger(MissDoctorOperateService.class);

    @Override
    public String getCurrentMenuType() {
        return "missDoctor";
    }

    @Override
    public BaseService<Miss_doctorWithBLOBs> baseService(String menuType) {
        return doctorService;
    }

    @Override
    public Class<?> getCurrentObjectClass() {
        return Miss_doctorWithBLOBs.class;
    }

    @Override
    public boolean needDealMapper() {
        return true;
    }

    @Override
    public String getJsonParamKey() {
        return "missDoctor";
    }

}
