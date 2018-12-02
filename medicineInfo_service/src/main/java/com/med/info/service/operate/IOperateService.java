package com.med.info.service.operate;

import com.med.info.mapper.domain.OperateDTO;

public interface IOperateService {
	
	public String doOperate(OperateDTO operateDTO);
	
	public boolean isFilter(OperateDTO operateDTO);
}
