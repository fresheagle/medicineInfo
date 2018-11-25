package com.med.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_dislocation;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_dislocationMapper;
import com.med.info.service.MissDislocationService;

@Service
public class MissDislocationServiceImpl extends BaseServiceImpl<Miss_dislocation> implements MissDislocationService{

	@Autowired
	private Miss_dislocationMapper dislocationMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return dislocationMapper;
	}

}
