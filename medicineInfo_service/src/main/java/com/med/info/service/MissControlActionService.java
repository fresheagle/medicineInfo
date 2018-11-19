package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_control_action;

public interface MissControlActionService extends BaseService<Miss_control_action>{
	
	public void deleteByActions(String[] uuids) throws Exception;
	
	public List<Miss_control_action> getControlActionsByUserCode(String userCode);

}
