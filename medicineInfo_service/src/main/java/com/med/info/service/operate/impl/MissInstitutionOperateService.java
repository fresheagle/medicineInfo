package com.med.info.service.operate.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.domain.Miss_institution_keypartment_mapping;
import com.med.info.dto.MissInstitutionDTO;
import com.med.info.mapper.Miss_institution_keypartment_mappingMapper;
import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.InstitutionInfoDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissInstitutionService;
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
@Order(8)
public class MissInstitutionOperateService extends AbstractOperateService<Miss_institutionWithBLOBs, MissInstitutionDTO> {

    @Autowired
    private MissInstitutionService institutionService;

    @Autowired
    private Miss_institution_keypartment_mappingMapper institution_keypartment_mappingMapper;
    private static Logger logger = LoggerFactory.getLogger(MissInstitutionOperateService.class);

    @Override
    public String getCurrentMenuType() {
        return "missInstitution";
    }

    @Override
    public BaseService<Miss_institutionWithBLOBs> baseService(String menuType) {
        return institutionService;
    }

    @Override
    public Class<?> getCurrentObjectClass() {
        return MissInstitutionDTO.class;
    }

    @Override
    public Miss_institutionWithBLOBs converseObject(MissInstitutionDTO missInstitutionDTO) {
        Miss_institutionWithBLOBs institutionWithBLOBs = new Miss_institutionWithBLOBs();
        BeanUtils.copyProperties(missInstitutionDTO, institutionWithBLOBs);
        institutionWithBLOBs.setLeadteamInfo(JSON.toJSONString(missInstitutionDTO.getLeadteamInfo()));
        institutionWithBLOBs.setEnvironment(JSON.toJSONString(missInstitutionDTO.getEnvironment()));
        return institutionWithBLOBs;
    }

    @Override
    protected void dealMapperRelashionShip(OperateDTO operateDTO) {
        InstitutionInfoDTO javaObject = JSONObject.toJavaObject(operateDTO.getJsonStr(), InstitutionInfoDTO.class);
        Miss_institutionWithBLOBs missInstitutionWithBLOBs = javaObject.getMissInstitution();
        institution_keypartment_mappingMapper.deleteByInstitutionId(missInstitutionWithBLOBs.getId());
        List<DepartmentMapDTO> departmentMapDTO = javaObject.getDepartmentMapDTO();
        if (CollectionUtil.isNotEmpty(departmentMapDTO)) {
            for (DepartmentMapDTO departmentMapDTO2 : departmentMapDTO) {
                Miss_institution_keypartment_mapping record = new Miss_institution_keypartment_mapping();
                record.setCreateTime(new Date());
                record.setInstitutionId(missInstitutionWithBLOBs.getId());
                record.setDepartmentId(departmentMapDTO2.getId());
                institution_keypartment_mappingMapper.insert(record);
            }
        }
    }

    @Override
    public String getJsonParamKey() {
        return "missInstitution";
    }

    @Override
    public boolean needDealMapper() {
        return true;
    }
}
