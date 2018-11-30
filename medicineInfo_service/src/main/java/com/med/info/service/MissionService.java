package com.med.info.service;

import com.med.info.service.dto.OperateDTO;

/**
 * 任务保存入口，草稿箱，待一审等状态变更
 * @author jiangjialin
 *
 */
public interface MissionService {
	
	public Object saveMission(OperateDTO operateDTO);
	
	public Object getByPage(Integer currentPage, Integer pageSize, String taskStatus);

}
