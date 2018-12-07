package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_control_task_detailWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_task_detailMapper;
import com.med.info.service.MissionDetailService;

@Service
public class MissionDetailServiceImpl extends BaseServiceImpl<Miss_control_task_detailWithBLOBs> implements MissionDetailService{

	@Autowired
	private Miss_control_task_detailMapper miss_control_task_detailMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return miss_control_task_detailMapper;
	}

}
