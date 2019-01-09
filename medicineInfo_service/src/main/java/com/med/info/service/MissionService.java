package com.med.info.service;

import com.med.info.dto.BatchOperateDTO;
import com.med.info.dto.ClaimTaskDTO;
import com.med.info.dto.SelectTaskDTO;
import com.med.info.mapper.domain.OperateDTO;

/**
 * 任务保存入口，草稿箱，待一审等状态变更
 * @author jiangjialin
 *
 */
public interface MissionService {
	
	public Object saveMission(OperateDTO operateDTO);

	public Object BatchSaveMission(BatchOperateDTO batchOperateDTO) throws Exception;
	
	public Object getByPage(SelectTaskDTO selectTaskDTO, boolean useCurrentUser);
	
	public Object getMissionDetailPage(Integer currentPage, Integer pageSize, String taskId);

	public Object claimTask(ClaimTaskDTO claimTaskDTO) throws Exception;

}
