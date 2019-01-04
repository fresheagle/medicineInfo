package com.med.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.med.info.domain.Miss_control_reference;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_referenceMapper;
import com.med.info.service.MissControlReferenceService;
import org.springframework.stereotype.Service;

@Service
public class MissControlReferenceServiceImpl extends BaseServiceImpl<Miss_control_reference> implements MissControlReferenceService{

	@Autowired
	Miss_control_referenceMapper miss_control_referenceMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Miss_control_reference> showByTaskId(String taskId) {
		// TODO Auto-generated method stub
		Miss_control_reference missControlReference = new Miss_control_reference();
		missControlReference.setTaskId(taskId);
		return miss_control_referenceMapper.showByTaskId(missControlReference);
	}

	@Override
	public void deleteByTaskId(String taskId) {
		miss_control_referenceMapper.deleteByTaskId(taskId);
	}
}
