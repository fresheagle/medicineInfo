package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_control_approvalWithBLOBs;

public interface MissControlApprovalService extends BaseService<Miss_control_approvalWithBLOBs>{
	/**
	 * 根据taskId查询字段审批信息
	 * @param taskId
	 * @return
	 */
	List<Miss_control_approvalWithBLOBs> showByTaskId(String taskId);

    int updateByTaskIdAndModel(Miss_control_approvalWithBLOBs approvalWithBLOBs);
}
