package com.med.info.service.operate;

import com.med.info.domain.Miss_control_task_records;
import com.med.info.mapper.domain.OperateDTO;

public interface IOperateService {
	
	public String doOperate(OperateDTO operateDTO);

	public String doBatchOperate(Miss_control_task_records miss_control_task_records, String operateCode);

	public String doOnline(Miss_control_task_records miss_control_task_records);

	public String doOffline(Miss_control_task_records miss_control_task_record);
	
	public boolean isFilter(String taskMenuType);
}
