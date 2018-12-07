package com.med.info.service.operate.impl;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.spi.LoggerFactory;
import org.apache.tomcat.jni.Time;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.BaseDomain;
import com.med.info.domain.Miss_control_task_detail;
import com.med.info.domain.Miss_control_task_detailWithBLOBs;
import com.med.info.domain.Miss_control_task_records;
import com.med.info.mapper.Miss_control_task_detailMapper;
import com.med.info.mapper.Miss_control_task_recordsMapper;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.impl.DefaultTokenManager;
import com.med.info.service.operate.IOperateService;
import com.med.info.utils.TrialStatusEnum;
import com.med.info.utils.UuidUtils;

public abstract class AbstractOperateService<T extends BaseDomain> implements IOperateService {

	@Autowired
	private Miss_control_task_recordsMapper taskRecordsMapper;
	@Autowired
	private Miss_control_task_detailMapper taskDetailMapper;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(AbstractOperateService.class);

	
	
	@Override
	public String doOperate(OperateDTO operateDTO) {
		operateDTO.verify();
		logger.info("接受到请求参数={}",JSON.toJSONString(operateDTO));
		T object = (T) JSON.toJavaObject(getParmJsonObject(operateDTO.getJsonStr()), getCurrentClass());
		BaseService<T> baseService = getBaseService(operateDTO.getTaskMenuType());
		if (operateDTO.getTaskStatus().equals(TrialStatusEnum.DRAFTS.getId())) {
			creatingOperate(operateDTO, object, baseService);
		} else if (operateDTO.getTaskStatus().equals(TrialStatusEnum.TO_FIRST_AUDITED.getId())) {
			firstTrialOperate(operateDTO, object, baseService);
		} else if (operateDTO.getTaskStatus().equals(TrialStatusEnum.TO_SECOND_AUDITED.getId())
				|| operateDTO.getTaskStatus().equals(TrialStatusEnum.TO_FINAL_AUDITED.getId())) {
			updateStatus(operateDTO, object, baseService);
		} else if(operateDTO.getTaskStatus().equals(TrialStatusEnum.FINISHED.getId())) {
			updateStatus(operateDTO, object, baseService);
			Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
			controlTaskRecord.setTaskpublishusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskRecord.setTaskId(object.getTaskId());
			controlTaskRecord.setTaskmenutype(operateDTO.getTaskMenuType());
			controlTaskRecord.setTasktype(operateDTO.getTaskType());
			controlTaskRecord.setTasktitle(operateDTO.getTaskTitle());
			controlTaskRecord.setTaskpublishtime(new Date());
			controlTaskRecord.setTaskpublishfinalcontentjson(JSON.toJSONString(operateDTO.getJsonStr()));
			controlTaskRecord.setTaskpublishday(getToday());
			taskRecordsMapper.updateByPrimaryKeySelective(controlTaskRecord);
			fishDeal(operateDTO);
		}
		return null;
	}
	
	public JSONObject getParmJsonObject(JSONObject object) {
		
		return object.getJSONObject(getJsonParamKey());
		
	}
	
	public abstract String getJsonParamKey();
	
	/**
	 * @author jialin.jiang
	 * Function: 终审发布处理 <br/> 
	 * @param operateDTO
	 */
	public abstract void fishDeal(OperateDTO operateDTO);

	@Override
	public boolean isFilter(OperateDTO operateDTO) {
		return operateDTO.getTaskMenuType().equals(getCurrentMenuType());
	}

	public abstract String getCurrentMenuType();

	private void updateStatus(OperateDTO operateDTO, T object, BaseService<T> baseService) {
		object.setTaskId(operateDTO.getTaskId());
		object.setTaskJson(JSON.toJSONString(operateDTO.getJsonStr()));
		object.setTaskStatus(operateDTO.getTaskStatus());
		Miss_control_task_detailWithBLOBs taskLastData = getTaskLastData(object.getTaskId());
		baseService.updateByTaskIdSelective(object);
		Miss_control_task_records record = new Miss_control_task_records();
		record.setTaskId(object.getTaskId());
		record.setTaskstatus(operateDTO.getTaskStatus());
		taskRecordsMapper.updateByTaskIdSelective(record );
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
		controlTaskDetail.setTaskchangetime(new Timestamp(System.currentTimeMillis()));
		controlTaskDetail.setTaskchangeday(getToday());
		controlTaskDetail.setTaskchangeafterjson(JSON.toJSONString(operateDTO.getJsonStr()));
		taskDetailMapper.insert(controlTaskDetail);
	}

	private void firstTrialOperate(OperateDTO operateDTO, T object, BaseService<T> baseService) {
		// 插入数据到
		if (null == operateDTO.getTaskId()) {
			String taskId = UuidUtils.generateUUID();
			object.setTaskJson(JSON.toJSONString(operateDTO.getJsonStr()));
			object.setTaskId(taskId);
			object.setTaskStatus(TrialStatusEnum.TO_FIRST_AUDITED.getId());
			baseService.insert(object);

			Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
			controlTaskRecord.setTaskcreaterusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskRecord.setTaskcreatetime(new Timestamp(System.currentTimeMillis()));
			controlTaskRecord.setTaskcreateday(getToday());
			controlTaskRecord.setTaskId(taskId);
			controlTaskRecord.setTaskstatus(TrialStatusEnum.TO_FIRST_AUDITED.getId());
			controlTaskRecord.setTaskmenutype(operateDTO.getTaskMenuType());
			controlTaskRecord.setTasktype(operateDTO.getTaskType());
			controlTaskRecord.setTasktitle(operateDTO.getTaskTitle());
			taskRecordsMapper.insert(controlTaskRecord);

			Miss_control_task_detailWithBLOBs createTaskDetail = new Miss_control_task_detailWithBLOBs();
			createTaskDetail.setTaskId(taskId);
			createTaskDetail.setTaskmenutype(operateDTO.getTaskMenuType());
			createTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.DRAFTS.getId());
			createTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			createTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			createTaskDetail.setTaskchangetime(new Timestamp(System.currentTimeMillis()));
			createTaskDetail.setTaskchangeday(getToday());
			createTaskDetail.setTaskchangeafterjson(JSON.toJSONString(operateDTO.getJsonStr()));
			taskDetailMapper.insert(createTaskDetail);

			Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
			controlTaskDetail.setTaskId(taskId);
			controlTaskDetail.setTaskmenutype(operateDTO.getTaskMenuType());
			controlTaskDetail.setTaskstatuschangebefore(TrialStatusEnum.DRAFTS.getId());
			controlTaskDetail.setTaskchangebeforejson(JSON.toJSONString(operateDTO.getJsonStr()));
			controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.TO_FIRST_AUDITED.getId());
			controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			controlTaskDetail.setTaskchangeday(getToday());
			controlTaskDetail.setTaskchangetime(new Timestamp(System.currentTimeMillis()));
			controlTaskDetail.setTaskchangeafterjson(JSON.toJSONString(operateDTO.getJsonStr()));
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
		if (null == operateDTO.getTaskId()) {
			String taskId = UuidUtils.generateUUID();
			object.setTaskJson(JSON.toJSONString(operateDTO.getJsonStr()));
			object.setTaskId(taskId);
			object.setTaskStatus(TrialStatusEnum.DRAFTS.getId());
			baseService.insert(object);

			Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
			controlTaskRecord.setTaskcreaterusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskRecord.setTaskcreatetime(new Timestamp(System.currentTimeMillis()));
			controlTaskRecord.setTaskcreateday(getToday());
			controlTaskRecord.setTaskId(taskId);
			controlTaskRecord.setTaskstatus(TrialStatusEnum.DRAFTS.getId());
			controlTaskRecord.setTaskmenutype(operateDTO.getTaskMenuType());
			controlTaskRecord.setTasktype(operateDTO.getTaskType());
			controlTaskRecord.setTasktitle(operateDTO.getTaskTitle());
			taskRecordsMapper.insert(controlTaskRecord);

			Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
			controlTaskDetail.setTaskId(taskId);
			controlTaskDetail.setTaskmenutype(operateDTO.getTaskMenuType());
			controlTaskDetail.setTaskstatuschangeafter(TrialStatusEnum.DRAFTS.getId());
			controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode());
			controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
			controlTaskDetail.setTaskchangetime(new Timestamp(System.currentTimeMillis()));
			controlTaskDetail.setTaskchangeday(getToday());
			controlTaskDetail.setTaskchangeafterjson(JSON.toJSONString(operateDTO.getJsonStr()));
			taskDetailMapper.insert(controlTaskDetail);
		} else {
			updateStatus(operateDTO, object, baseService);
		}
	}

	
	private Miss_control_task_detailWithBLOBs getTaskLastData(String taskId) {
		
		List<Miss_control_task_detailWithBLOBs> taskDetailsByTime = taskDetailMapper.getTaskDetailsByTime(taskId);
		return taskDetailsByTime.get(0);
	}

	public abstract BaseService<T> getBaseService(String menuType);

	public abstract Class<?> getCurrentClass();

}
