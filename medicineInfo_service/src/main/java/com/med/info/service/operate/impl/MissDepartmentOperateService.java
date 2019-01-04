package com.med.info.service.operate.impl;

import com.med.info.domain.Miss_department;
import com.med.info.service.BaseService;
import com.med.info.service.MissDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class MissDepartmentOperateService extends AbstractOperateService<Miss_department, Miss_department> {

    @Autowired
    private MissDepartmentService departmentService;

    @Override
    public String getCurrentMenuType() {
        return "missDepartment";
    }

    @Override
    public BaseService<Miss_department> baseService(String menuType) {
        return departmentService;
    }

    @Override
    public Class<?> getCurrentObjectClass() {
        return Miss_department.class;
    }

    @Override
    public boolean needDealMapper() {
        return false;
    }

    @Override
    public String getJsonParamKey() {
        return "missDepartment";
    }

}
