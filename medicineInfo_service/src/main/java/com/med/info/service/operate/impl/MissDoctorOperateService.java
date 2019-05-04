package com.med.info.service.operate.impl;

import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_department_doctor_mapping;
import com.med.info.domain.Miss_doctorWithBLOBs;
import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.domain.Miss_institution_doctor_mapping;
import com.med.info.dto.MissDoctorDTO;
import com.med.info.dto.MissInstitutionDTO;
import com.med.info.mapper.Miss_department_doctor_mappingMapper;
import com.med.info.mapper.Miss_institution_doctor_mappingMapper;
import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.DoctorDTO;
import com.med.info.mapper.domain.InstitutionDepartMapDTO;
import com.med.info.mapper.domain.InstitutionInfoMapDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissDoctorService;
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
@Order(9)
public class MissDoctorOperateService extends AbstractOperateService<Miss_doctorWithBLOBs, MissDoctorDTO> {

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
        return MissDoctorDTO.class;
    }

    @Override
    public Miss_doctorWithBLOBs converseObject(MissDoctorDTO missDoctorDTO) {
    	Miss_doctorWithBLOBs miss_doctorWithBLOBs = new Miss_doctorWithBLOBs();
    	BeanUtils.copyProperties(missDoctorDTO, miss_doctorWithBLOBs);
    	return miss_doctorWithBLOBs;
    }
    @Override
    protected void dealMapperRelashionShip(MissDoctorDTO objectF) {
    	institutionDoctorMappingMapper.deleteByDoctorId(objectF.getId());
    	departmentDoctorMappingMapper.deleteByDoctorId(objectF.getId());
    	List<InstitutionDepartMapDTO> institutionList = objectF.getInstitutionList();
    	if (CollectionUtil.isNotEmpty(institutionList)) {
    		for(InstitutionDepartMapDTO institutionDepartMapDTO : institutionList) {
    			Miss_institution_doctor_mapping record = new Miss_institution_doctor_mapping();
    			record.setCreateTime(new Date());
    			record.setDoctorId(objectF.getId());
    			record.setInstitutionId(institutionDepartMapDTO.getInstitutionId());
    			record.setExportsTime(institutionDepartMapDTO.getExportsTime());
    			record.setDatastatus(objectF.getDataStatus());
    			record.setTaskId(objectF.getTaskId());
    			record.setTaskStatus(objectF.getTaskStatus());
    			institutionDoctorMappingMapper.insert(record);
    		}
    		for(InstitutionDepartMapDTO institutionDepartMapDTO : institutionList) {
    			Miss_department_doctor_mapping record = new Miss_department_doctor_mapping();
    			record.setCreateTime(new Date());
    			record.setDoctorId(objectF.getId());
    			record.setDepartmentId(institutionDepartMapDTO.getDepartmentId());;
    			record.setDatastatus(objectF.getDataStatus());
    			record.setTaskId(objectF.getTaskId());
    			record.setTaskStatus(objectF.getTaskStatus());
    			departmentDoctorMappingMapper.insert(record);
    		}
    	}
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
