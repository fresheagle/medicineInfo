package com.med.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.med.info.domain.Miss_control_action;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_actionMapper;
import com.med.info.service.MissControlActionService;

@Service
public class MissControlActionServiceImpl extends BaseServiceImpl<Miss_control_action> implements MissControlActionService {

	@Autowired
	private Miss_control_actionMapper actionMapper;
	
	@Override
	public BaseMapper getMapper() {
		return actionMapper ;
	}

	@Override
	@Transactional
	public void deleteByActions(String[] uuids) throws Exception {
		
		for (String string : uuids) {
			int deleteByPrimaryKey = actionMapper.deleteByPrimaryKey(string);
			if(deleteByPrimaryKey <0 ) {
				throw new Exception("ɾ������"+string+"����");
			}
		}
	}

	@Override
	public List<Miss_control_action> getControlActionsByUserCode(String userCode) {
		// TODO Auto-generated method stub
		return actionMapper.getControlActionsByUserCode(userCode);
	}

}
