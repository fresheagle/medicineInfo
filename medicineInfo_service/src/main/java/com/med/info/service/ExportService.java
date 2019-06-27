package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_control_task_records;
import com.med.info.dto.BatchOperateDTO;

public interface ExportService {
	
	String exportFile(List<Miss_control_task_records> missControlTaskRecords, BatchOperateDTO batchOperateDTO) throws Exception;
}
