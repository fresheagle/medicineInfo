package com.med.info.service.operate.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.med.info.domain.BaseDomain;
import com.med.info.domain.Miss_control_task_detailWithBLOBs;
import com.med.info.domain.Miss_control_task_records;
import com.med.info.mapper.Miss_control_task_detailMapper;
import com.med.info.mapper.Miss_control_task_recordsMapper;
import com.med.info.service.BaseService;
import com.med.info.service.dto.OperateDTO;
import com.med.info.service.impl.DefaultTokenManager;
import com.med.info.service.operate.IOperateService;
import com.med.info.utils.TrialStatusEnum;
import com.med.info.utils.UuidUtils;

public abstract class AbstractOperateService<T extends BaseDomain> implements IOperateService {

	@Autowired
	private Miss_control_task_recordsMapper taskRecordsMapper;
	@Autowired
	private Miss_control_task_detailMapper taskDetailMapper;

	@Override
	public String doOperate(OperateDTO operateDTO) {

		T object = (T) JSON.parseObject(operateDTO.getJsonStr(), getCurrentClass());
		BaseService<T> baseService = getBaseService(operateDTO.getTaskMenuType());
		if (operateDTO.getTaskStatus().equals(TrialStatusEnum.CREATING.getId())) {
			creatingOperate(operateDTO, object, baseService);
		} else if (operateDTO.getTaskStatus().equals(TrialStatusEnum.FIRST_TRIAL.getId())) {
			firstTrialOperate(operateDTO, object, baseService);
		} else if (operateDTO.getTaskStatus().equals(TrialStatusEnum.SECOND_TRIAL.getId())
				|| operateDTO.getTaskStatus().equals(TrialStatusEnum.FINAL_TRIAL.getId())) {
			updateStatus(operateDTO, object, baseService);
		} else if(operateDTO.getTaskStatus().equals(TrialStatusEnum.END_TRIAL.getId())) {
			updateStatus(operateDTO, object, baseService);
			Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
			controlTaskRecord.setTaskpublishusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskRecord.setTaskId(object.getTaskId());
			controlTaskRecord.setTaskmenutype(operateDTO.getTaskMenuType());
			controlTaskRecord.setTasktype(operateDTO.getTaskType());
			controlTaskRecord.setTasktitle(operateDTO.getTaskTitle());
			controlTaskRecord.setTaskpublishtime(new Date());
			controlTaskRecord.setTaskpublishfinalcontentjson(operateDTO.getJsonStr());
			controlTaskRecord.setTaskpublishday(getToday());
			taskRecordsMapper.updateByPrimaryKeySelective(controlTaskRecord);
			
		}
		return null;
	}
	
	@Override
	public boolean isFilter(OperateDTO operateDTO) {
		return operateDTO.getTaskMenuType().equals(getCurrentMenuType());
	}

	public abstract String getCurrentMenuType();

	private void updateStatus(OperateDTO operateDTO, T object, BaseService<T> baseService) {
		object.setTaskJson(operateDTO.getJsonStr());
		object.setTaskStatus(operateDTO.getTaskStatus());
		Miss_control_task_detailWithBLOBs taskLastData = getTaskLastData(object.getTaskId());
		baseService.updateByTaskIdSelective(object);
		Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
		controlTaskDetail.setTaskId(object.getTaskId());
		controlTaskDetail.setTaskmenutype(operateDTO.getTaskMenuType());
		controlTaskDetail.setTaskstatuschangebefore(taskLastData.getTaskstatuschangeafter());
		controlTaskDetail.setTaskchangebeforejson(taskLastData.getTaskchangeafterjson());
		controlTaskDetail.setTaskstatuschangeafter(operateDTO.getTaskStatus());
		controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
		controlTaskDetail.setTaskchangepoints(operateDTO.getTaskChangePoints());
		controlTaskDetail.setTaskchangecomments(operateDTO.getTaskChangeComments());
		controlTaskDetail.setTaskchangevote(operateDTO.getTaskChangeVote());
		controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
		controlTaskDetail.setTaskchangetime(new Date());
		controlTaskDetail.setTaskchangeday(getToday());
		controlTaskDetail.setTaskchangeafterjson(operateDTO.getJsonStr());
		taskDetailMapper.insert(controlTaskDetail);
	}

	private void firstTrialOperate(OperateDTO operateDTO, T object, BaseService<T> baseService) {
		// 插入数据到
		if (null == object.getTaskId()) {
			String taskId = UuidUtils.generateUUID();
			object.setTaskJson(operateDTO.getJsonStr());
			object.setTaskId(taskId);
			object.setTaskStatus(TrialStatusEnum.FINAL_TRIAL.getId());
			baseService.insert(object);

			Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
			controlTaskRecord.setTaskcreaterusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskRecord.setTaskcreatetime(new Date());
			controlTaskRecord.setTaskcreateday(getToday());
			controlTaskRecord.setTaskId(taskId);
			controlTaskRecord.setTaskmenutype(operateDTO.getTaskMenuType());
			controlTaskRecord.setTasktype(operateDTO.getTaskType());
			controlTaskRecord.setTasktitle(operateDTO.getTaskTitle());
			taskRecordsMapper.insert(controlTaskRecord);

			Miss_control_task_detailWithBLOBs createTaskDetail = new Miss_control_task_detailWithBLOBs();
			createTaskDetail.setTaskId(taskId);
			createTaskDetail.setTaskmenutype(operateDTO.getTaskMenuType());
			createTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.CREATING.getId());
			createTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			createTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			createTaskDetail.setTaskchangetime(new Date());
			createTaskDetail.setTaskchangeday(getToday());
			createTaskDetail.setTaskchangeafterjson(operateDTO.getJsonStr());
			taskDetailMapper.insert(createTaskDetail);

			Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
			controlTaskDetail.setTaskId(taskId);
			controlTaskDetail.setTaskmenutype(operateDTO.getTaskMenuType());
			controlTaskDetail.setTaskstatuschangebefore(TrialStatusEnum.CREATING.getId());
			controlTaskDetail.setTaskchangebeforejson(operateDTO.getJsonStr());
			controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.FIRST_TRIAL.getId());
			controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			controlTaskDetail.setTaskchangeday(getToday());
			controlTaskDetail.setTaskchangetime(new Date());
			controlTaskDetail.setTaskchangeafterjson(operateDTO.getJsonStr());
			taskDetailMapper.insert(controlTaskDetail);
		} else {
			updateStatus(operateDTO, object, baseService);
		}
	}
	
	private String getToday() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		return sf.format(c.getTime());
	}

	private void creatingOperate(OperateDTO operateDTO, T object, BaseService<T> baseService) {
		
		// 插入数据到
		if (null == object.getTaskId()) {
			String taskId = UuidUtils.generateUUID();
			String jsonStr = JSON.toJSONString(object);
			object.setTaskJson(operateDTO.getJsonStr());
			object.setTaskId(taskId);
			object.setTaskStatus(TrialStatusEnum.CREATING.getId());
			baseService.insert(object);

			Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
			controlTaskRecord.setTaskcreaterusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskRecord.setTaskcreatetime(new Date());
			controlTaskRecord.setTaskcreateday(getToday());
			controlTaskRecord.setTaskId(taskId);
			controlTaskRecord.setTaskmenutype(operateDTO.getTaskMenuType());
			controlTaskRecord.setTasktype(operateDTO.getTaskType());
			controlTaskRecord.setTasktitle(operateDTO.getTaskTitle());
			taskRecordsMapper.insert(controlTaskRecord);

			Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
			controlTaskDetail.setTaskId(taskId);
			controlTaskDetail.setTaskmenutype(operateDTO.getTaskMenuType());
			controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.CREATING.getId());
			controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			controlTaskDetail.setTaskchangetime(new Date());
			controlTaskDetail.setTaskchangeday(getToday());
			controlTaskDetail.setTaskchangeafterjson(operateDTO.getJsonStr());
			taskDetailMapper.insert(controlTaskDetail);
		} else {
			updateStatus(operateDTO, object, baseService);
		}
	}

	private Miss_control_task_detailWithBLOBs getTaskLastData(String taskId) {
		return null;
	}

	public abstract BaseService<T> getBaseService(String menuType);

	public abstract Class<?> getCurrentClass();

}
