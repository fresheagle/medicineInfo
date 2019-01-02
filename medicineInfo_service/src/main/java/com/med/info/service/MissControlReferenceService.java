package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_control_reference;

public interface MissControlReferenceService extends BaseService<Miss_control_reference>{
	/**
	 * 通过taskId查询相关资料
	 * @param taskId
	 * @return
	 */
	List<Miss_control_reference> showByTaskId(String taskId);
}
