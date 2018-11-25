package com.med.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.service.MissionService;
import com.med.info.service.dto.OperateDTO;
import com.med.info.service.operate.IOperateService;

@Service
public class MissionServiceImpl implements MissionService{

	@Autowired
	private List<IOperateService> operateServices;
	
	@Override
	public Object saveMission(OperateDTO operateDTO) {
		for (IOperateService iOperateService : operateServices) {
			if (iOperateService.isFilter(operateDTO)) {
				iOperateService.doOperate(operateDTO);
				return null;
			}
		}
		return null;
	}

}
