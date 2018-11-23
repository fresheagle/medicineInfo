package com.med.info.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.med.info.domain.Miss_control_task_detail;
import com.med.info.domain.Miss_control_task_detailWithBLOBs;
import com.med.info.domain.Miss_control_task_records;
import com.med.info.domain.Miss_district;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_task_detailMapper;
import com.med.info.mapper.Miss_control_task_recordsMapper;
import com.med.info.mapper.Miss_districtMapper;
import com.med.info.service.MissDistrictService;
import com.med.info.utils.TrialStatusEnum;
import com.med.info.utils.UuidUtils;

public class MissDistrictServiceImpl extends BaseServiceImpl<Miss_district> implements MissDistrictService {

	@Autowired
	private Miss_districtMapper districtMapper;
	@Autowired
	private Miss_control_task_recordsMapper taskRecordsMapper;
	@Autowired
	private Miss_control_task_detailMapper taskDetailMapper;

	@Override
	public BaseMapper getMapper() {
		return districtMapper;
	}

	@Override
	@Transactional
	public Miss_district createTask(Miss_district district, String taskTitle, String taskType, String taskMenuType) {
		// 插入数据到
		if (null == district.getTaskId()) {
			String taskId = UuidUtils.generateUUID();
			String jsonStr = JSON.toJSONString(district);
			district.setTaskJson(jsonStr);
			district.setTaskId(taskId);
			district.setTaskStatus(TrialStatusEnum.CREATING.getId());
			districtMapper.insert(district);

			Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
			controlTaskRecord.setTaskcreaterusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskRecord.setTaskcreatetime(new Date());
			controlTaskRecord.setTaskId(taskId);
			controlTaskRecord.setTaskmenutype(taskMenuType);
			controlTaskRecord.setTasktype(taskType);
			controlTaskRecord.setTasktitle(taskTitle);
			taskRecordsMapper.insert(controlTaskRecord);

			Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
			controlTaskDetail.setTaskId(taskId);
			controlTaskDetail.setTaskmenutype(taskMenuType);
			controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.CREATING.getId());
			controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			controlTaskDetail.setTaskchangetime(new Date());
			controlTaskDetail.setTaskchangeafterjson(jsonStr);
			taskDetailMapper.insert(controlTaskDetail);
		} else {
			district.setTaskJson(null);
			String jsonStr = JSON.toJSONString(district);
			district.setTaskJson(jsonStr);
			districtMapper.updateByTaskIdSelective(district);
			Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
			controlTaskDetail.setTaskId(district.getTaskId());
			controlTaskDetail.setTaskmenutype(taskMenuType);
			controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.CREATING.getId());
			controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			controlTaskDetail.setTaskchangetime(new Date());
			controlTaskDetail.setTaskchangeafterjson(jsonStr);
			taskDetailMapper.insert(controlTaskDetail);

		}
		return district;
	}

	@Override
	public Miss_district submitTask(Miss_district district, String taskTitle, String taskType, String taskMenuType) {
		// 插入数据到
		if (null == district.getTaskId()) {
			String taskId = UuidUtils.generateUUID();
			String jsonStr = JSON.toJSONString(district);
			district.setTaskJson(jsonStr);
			district.setTaskId(taskId);
			district.setTaskStatus(TrialStatusEnum.FINAL_TRIAL.getId());
			districtMapper.insert(district);

			Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
			controlTaskRecord.setTaskcreaterusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskRecord.setTaskcreatetime(new Date());
			controlTaskRecord.setTaskId(taskId);
			controlTaskRecord.setTaskmenutype(taskMenuType);
			controlTaskRecord.setTasktype(taskType);
			controlTaskRecord.setTasktitle(taskTitle);
			taskRecordsMapper.insert(controlTaskRecord);

			Miss_control_task_detailWithBLOBs createTaskDetail = new Miss_control_task_detailWithBLOBs();
			createTaskDetail.setTaskId(taskId);
			createTaskDetail.setTaskmenutype(taskMenuType);
			createTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.CREATING.getId());
			createTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			createTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			createTaskDetail.setTaskchangetime(new Date());
			createTaskDetail.setTaskchangeafterjson(jsonStr);
			taskDetailMapper.insert(createTaskDetail);
			
			Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
			controlTaskDetail.setTaskId(taskId);
			controlTaskDetail.setTaskmenutype(taskMenuType);
			controlTaskDetail.setTaskstatuschangebefore(TrialStatusEnum.CREATING.getId());
			controlTaskDetail.setTaskchangebeforejson(jsonStr);
			controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.FINAL_TRIAL.getId());
			controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			controlTaskDetail.setTaskchangetime(new Date());
			controlTaskDetail.setTaskchangeafterjson(jsonStr);
			taskDetailMapper.insert(controlTaskDetail);
		} else {
			district.setTaskJson(null);
			String jsonStr = JSON.toJSONString(district);
			district.setTaskJson(jsonStr);
			district.setTaskStatus(TrialStatusEnum.FINAL_TRIAL.getId());
			districtMapper.updateByTaskIdSelective(district);
			Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
			controlTaskDetail.setTaskId(district.getTaskId());
			controlTaskDetail.setTaskmenutype(taskMenuType);
			controlTaskDetail.setTaskstatuschangebefore(TrialStatusEnum.CREATING.getId());
			controlTaskDetail.setTaskchangebeforejson(getLastStatusJson(district.getTaskId(), TrialStatusEnum.CREATING.getId()));
			controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.FINAL_TRIAL.getId());
			controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			controlTaskDetail.setTaskchangetime(new Date());
			controlTaskDetail.setTaskchangeafterjson(jsonStr);
			taskDetailMapper.insert(controlTaskDetail);
		}
		return district;
	}

	@Override
	public void firstTrial(Miss_district district, String taskMenuType) {
		district.setTaskStatus(TrialStatusEnum.SECOND_TRIAL.getId());
		districtMapper.updateByTaskIdSelective(district);
		Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
		controlTaskDetail.setTaskId(district.getTaskId());
		controlTaskDetail.setTaskmenutype(taskMenuType);
		controlTaskDetail.setTaskstatuschangebefore(TrialStatusEnum.FIRST_TRIAL.getId());
		controlTaskDetail.setTaskchangebeforejson(getLastStatusJson(district.getTaskId(), TrialStatusEnum.FIRST_TRIAL.getId()));
		controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.SECOND_TRIAL.getId());
		controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
		controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
		controlTaskDetail.setTaskchangetime(new Date());
		controlTaskDetail.setTaskchangeafterjson(district.getTaskJson());
		taskDetailMapper.insert(controlTaskDetail);
	}

	@Override
	public void secondTrial(Miss_district district, String taskMenuType) {
		district.setTaskStatus(TrialStatusEnum.FINAL_TRIAL.getId());
		districtMapper.updateByTaskIdSelective(district);
		Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
		controlTaskDetail.setTaskId(district.getTaskId());
		controlTaskDetail.setTaskmenutype(taskMenuType);
		controlTaskDetail.setTaskstatuschangebefore(TrialStatusEnum.SECOND_TRIAL.getId());
		controlTaskDetail.setTaskchangebeforejson(getLastStatusJson(district.getTaskId(), TrialStatusEnum.SECOND_TRIAL.getId()));
		controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.FINAL_TRIAL.getId());
		controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
		controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
		controlTaskDetail.setTaskchangetime(new Date());
		controlTaskDetail.setTaskchangeafterjson(district.getTaskJson());
		taskDetailMapper.insert(controlTaskDetail);

	}

	@Override
	public void finalTrial(Miss_district district, String taskMenuType) {
		district.setTaskStatus(TrialStatusEnum.END_TRIAL.getId());
		districtMapper.updateByTaskIdSelective(district);
		Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
		controlTaskDetail.setTaskId(district.getTaskId());
		controlTaskDetail.setTaskmenutype(taskMenuType);
		controlTaskDetail.setTaskstatuschangebefore(TrialStatusEnum.FINAL_TRIAL.getId());
		controlTaskDetail.setTaskchangebeforejson(getLastStatusJson(district.getTaskId(), TrialStatusEnum.FINAL_TRIAL.getId()));
		controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.END_TRIAL.getId());
		controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
		controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
		controlTaskDetail.setTaskchangetime(new Date());
		controlTaskDetail.setTaskchangeafterjson(district.getTaskJson());
		taskDetailMapper.insert(controlTaskDetail);

	}

	@Override
	public void publishData(Miss_district district, String taskMenuType) {
		// TODO Auto-generated method stub

	}
	
	private String getLastStatusJson(String taskId, String taskStatus) {
		Miss_control_task_detailWithBLOBs record = new Miss_control_task_detailWithBLOBs();
		record.setTaskId(taskId);
		record.setTaskstatuschangebefore(taskStatus);
		return taskDetailMapper.getLastStatusJson(record );
	}

}
