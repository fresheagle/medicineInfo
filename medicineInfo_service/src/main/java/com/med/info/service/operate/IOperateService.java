package com.med.info.service.operate;

import com.med.info.service.dto.OperateDTO;

public interface IOperateService {
	
	public String doOperate(OperateDTO operateDTO);
	
	public boolean isFilter(OperateDTO operateDTO);
}
