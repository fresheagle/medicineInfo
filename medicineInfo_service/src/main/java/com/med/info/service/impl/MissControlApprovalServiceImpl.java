package com.med.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.med.info.domain.Miss_control_approvalWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_approvalMapper;
import com.med.info.service.MissControlApprovalService;

public class MissControlApprovalServiceImpl extends BaseServiceImpl<Miss_control_approvalWithBLOBs> implements MissControlApprovalService{

	@Autowired
	Miss_control_approvalMapper miss_control_approvalMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Miss_control_approvalWithBLOBs> showByTaskId(String taskId) {
		// TODO Auto-generated method stub
		Miss_control_approvalWithBLOBs missControlApproval = new Miss_control_approvalWithBLOBs();
		missControlApproval.setTaskId(taskId);
		return miss_control_approvalMapper.showByTaskId(missControlApproval);
	}

}
