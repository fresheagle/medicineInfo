package com.med.info.service.operate.impl;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.service.BaseService;
import com.med.info.service.MissChineseDiseaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class MissChineseDiseaseOperateService extends AbstractOperateService<Miss_chinese_diseaseWithBLOBs> {

    @Autowired
    private MissChineseDiseaseService chineseDiseaseService;
    private static Logger logger = LoggerFactory.getLogger(MissChineseDiseaseOperateService.class);

    @Override
    public String getCurrentMenuType() {
        return "missChineseDisease";
    }

    @Override
    public BaseService<Miss_chinese_diseaseWithBLOBs> baseService(String menuType) {
        return chineseDiseaseService;
    }

    @Override
    public Class<?> getCurrentClass() {
        return Miss_chinese_diseaseWithBLOBs.class;
    }


    @Override
    public boolean needDealMapper() {
        return false;
    }


    @Override
    public String getJsonParamKey() {
        return "missChineseDisease";
    }

}
