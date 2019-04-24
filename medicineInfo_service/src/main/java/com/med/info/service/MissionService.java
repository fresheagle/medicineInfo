package com.med.info.service;

import com.med.info.dto.BatchAcountsDTO;
import com.med.info.dto.BatchOperateDTO;
import com.med.info.dto.ClaimTaskDTO;
import com.med.info.dto.SelectTaskDTO;
import com.med.info.mapper.domain.OperateDTO;

import java.util.List;

/**
 * 任务保存入口，草稿箱，待一审等状态变更
 * @author jiangjialin
 *
 */
public interface MissionService {
	
	public Object saveMission(OperateDTO operateDTO);

	public Object BatchSaveMission(BatchOperateDTO batchOperateDTO) throws Exception;
	
	public Object getByPage(SelectTaskDTO selectTaskDTO, boolean useCurrentUser);

	public void deleteMission(List<String> taskIds);
	
	public Object getMissionDetailPage(Integer currentPage, Integer pageSize, String taskId);

	public Object claimTask(ClaimTaskDTO claimTaskDTO) throws Exception;

	public Object BatchAcounts(BatchAcountsDTO accounts);
}
