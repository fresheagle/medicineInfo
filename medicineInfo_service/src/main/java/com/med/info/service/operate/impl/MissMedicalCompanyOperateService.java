package com.med.info.service.operate.impl;

import com.med.info.domain.Miss_medical_companyWithBLOBs;
import com.med.info.service.BaseService;
import com.med.info.service.MissMedicalCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(9)
public class MissMedicalCompanyOperateService extends AbstractOperateService<Miss_medical_companyWithBLOBs, Miss_medical_companyWithBLOBs> {

    @Autowired
    private MissMedicalCompanyService medicalCompanyService;
    private static Logger logger = LoggerFactory.getLogger(MissMedicalCompanyOperateService.class);

    @Override
    public String getCurrentMenuType() {
        return "missMedicalCompany";
    }

    @Override
    public BaseService<Miss_medical_companyWithBLOBs> baseService(String menuType) {
        return medicalCompanyService;
    }

    @Override
    public Class<?> getCurrentObjectClass() {
        return Miss_medical_companyWithBLOBs.class;
    }

    @Override
    public boolean needDealMapper() {
        return false;
    }

    @Override
    public String getJsonParamKey() {
        return "missMedicalCompany";
    }

}
