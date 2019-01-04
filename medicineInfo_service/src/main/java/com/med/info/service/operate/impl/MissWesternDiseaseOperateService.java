package com.med.info.service.operate.impl;

import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.service.BaseService;
import com.med.info.service.MissWesternDiseaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(12)
public class MissWesternDiseaseOperateService extends AbstractOperateService<Miss_western_diseaseWithBLOBs, Miss_western_diseaseWithBLOBs> {

    @Autowired
    private MissWesternDiseaseService westernDiseaseService;
    private static Logger logger = LoggerFactory.getLogger(MissWesternDiseaseOperateService.class);
    @Override
    public String getCurrentMenuType() {
        return "missWestern";
    }

    @Override
    public BaseService<Miss_western_diseaseWithBLOBs> baseService(String menuType) {
        return westernDiseaseService;
    }

    @Override
    public boolean needDealMapper() {
        return false;
    }

    @Override
    public Class<?> getCurrentObjectClass() {
        return Miss_western_diseaseWithBLOBs.class;
    }

    @Override
    public String getJsonParamKey() {
        return "missWestern";
    }

}
