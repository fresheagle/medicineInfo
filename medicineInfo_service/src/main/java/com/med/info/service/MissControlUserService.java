package com.med.info.service;

import com.med.info.domain.Miss_control_user;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface MissControlUserService extends BaseService<Miss_control_user>{


    public Miss_control_user selectByCode(String userCode);

    public List<String> selectUserCodeByNames(List<String> names);
}
