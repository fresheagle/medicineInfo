package com.med.info.service;

import com.med.info.dto.*;
import com.med.info.mapper.domain.OperateDTO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

/**
 * 任务保存入口，草稿箱，待一审等状态变更
 * @author jiangjialin
 *
 */
public interface MissionService {
	
	public Object saveMission(OperateDTO operateDTO);

	public Object BatchSaveMission(BatchOperateDTO batchOperateDTO) throws Exception;
	
	public Object getByPage(SelectTaskDTO selectTaskDTO, boolean useCurrentUser) throws Exception;

	public XSSFWorkbook exportDatas(SelectTaskDTO selectTaskDTO, boolean useCurrentUser) throws Exception;

	public void deleteMission(List<String> taskIds) throws Exception;
	
	public Object getMissionDetailPage(Integer currentPage, Integer pageSize, String taskId);

	public Object claimTask(ClaimTaskDTO claimTaskDTO) throws Exception;

	public Object BatchAcounts(BatchAcountsDTO accounts) throws Exception;

	void resetTask(BatchResetTaskDTO batchResetTaskDTO) throws Exception;

	void resetCreateUser(BatchResetTaskDTO batchResetTaskDTO) throws Exception;
}
