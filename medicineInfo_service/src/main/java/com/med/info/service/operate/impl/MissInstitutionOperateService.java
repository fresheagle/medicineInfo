package com.med.info.service.operate.impl;

import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.domain.Miss_institution_keypartment_mapping;
import com.med.info.mapper.Miss_institution_keypartment_mappingMapper;
import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.InstitutionInfoDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissInstitutionService;
import com.med.info.utils.CollectionUtil;
import com.med.info.utils.OperateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Order(8)
public class MissInstitutionOperateService extends AbstractOperateService<Miss_institutionWithBLOBs> {

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
    public Class<?> getCurrentClass() {
        return Miss_institutionWithBLOBs.class;
    }

    @Override
    protected void dealMapperRelashionShip(OperateDTO operateDTO) {
        InstitutionInfoDTO javaObject = JSONObject.toJavaObject(operateDTO.getJsonStr(), InstitutionInfoDTO.class);
        Miss_institutionWithBLOBs missInstitutionWithBLOBs = javaObject.getMissInstitutionWithBLOBs();
        if (!operateDTO.getTaskType().equals(OperateEnum.delete.toString())) {
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
        } else {
            logger.info(getCurrentMenuType() + "当前操作为" + operateDTO.getTaskType() + ",修改状态为回收站");
            institution_keypartment_mappingMapper.deleteByInstitutionId(missInstitutionWithBLOBs.getId());

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
