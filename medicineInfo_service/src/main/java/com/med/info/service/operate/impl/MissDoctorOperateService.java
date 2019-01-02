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
@Order(7)
public class MissDoctorOperateService extends AbstractOperateService<Miss_doctorWithBLOBs> {

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
    public Class<?> getCurrentClass() {
        return Miss_doctorWithBLOBs.class;
    }

    @Override
    public boolean needDealMapper() {
        return true;
    }

    @Override
    protected void dealMapperRelashionShip(OperateDTO operateDTO) {
        DoctorDTO doctorDTO = JSONObject.toJavaObject(operateDTO.getJsonStr(), DoctorDTO.class);
        Miss_doctorWithBLOBs missDoctor = doctorDTO.getMissDoctor();
        institutionDoctorMappingMapper.deleteByDoctorId(missDoctor.getId());
        departmentDoctorMappingMapper.deleteByDoctorId(missDoctor.getId());
        List<InstitutionInfoMapDTO> institutionList = doctorDTO.getInstitutionList();
        if (CollectionUtil.isNotEmpty(institutionList)) {
            for (InstitutionInfoMapDTO institutionInfoMapDTO : institutionList) {
                Miss_institution_doctor_mapping record = new Miss_institution_doctor_mapping();
                record.setCreateTime(new Date());
                record.setDoctorId(missDoctor.getId());
                record.setInstitutionId(institutionInfoMapDTO.getId());
                institutionDoctorMappingMapper.insert(record);
            }
        }
        List<DepartmentMapDTO> departmentList = doctorDTO.getDepartmentList();
        if (CollectionUtil.isNotEmpty(departmentList)) {
            for (DepartmentMapDTO departmentMapDTO : departmentList) {
                Miss_department_doctor_mapping record = new Miss_department_doctor_mapping();
                record.setCreateTime(new Date());
                record.setDoctorId(missDoctor.getId());
                record.setDepartmentId(departmentMapDTO.getId());
                departmentDoctorMappingMapper.insert(record);
            }
        }
    }

    @Override
    public String getJsonParamKey() {
        return "missDoctor";
    }

}
