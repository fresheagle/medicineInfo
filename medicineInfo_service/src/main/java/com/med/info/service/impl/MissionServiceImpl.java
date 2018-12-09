package com.med.info.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.med.info.domain.Miss_control_task_detailWithBLOBs;
import com.med.info.domain.Miss_control_task_records;
import com.med.info.dto.ControlTaskDetail;
import com.med.info.mapper.Miss_control_task_detailMapper;
import com.med.info.mapper.Miss_control_task_recordsMapper;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissionService;
import com.med.info.service.operate.IOperateService;

@Service
public class MissionServiceImpl implements MissionService {

	@Autowired
	private List<IOperateService> operateServices;

	@Autowired
	private Miss_control_task_recordsMapper taskRecordsMapper;
	@Autowired
	private Miss_control_task_detailMapper taskDetailMapper;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(MissionServiceImpl.class);

	@Override
	public Object saveMission(OperateDTO operateDTO) {
		for (IOperateService iOperateService : operateServices) {
			if (iOperateService.isFilter(operateDTO)) {
				iOperateService.doOperate(operateDTO);
				return operateDTO;
			}
		}	
		return null;
	}

	@Override
	public Object getByPage(Integer currentPage, Integer pageSize, String taskStatus) {
		PageHelper.startPage(currentPage, pageSize);
		Miss_control_task_records record = new Miss_control_task_records();
		record.setTaskstatus(taskStatus);
		record.setTaskcreaterusercode(DefaultTokenManager.getLocalUserCode());
		logger.info("查询任务，record={}",JSON.toJSONString(record));
		Page<Miss_control_task_records> showDataCondition = (Page<Miss_control_task_records>) taskRecordsMapper
				.selectPageBySelective(record);
		List<OperateDTO> list = new ArrayList<>();
		for (Miss_control_task_records miss_control_task_records : showDataCondition) {
			list.add(converseToOperataDTO(miss_control_task_records));
		}
		PageObject object = new PageObject<Miss_control_task_records>();
		object.setCurrentPage(showDataCondition.getPageNum());
		object.setParams(list);
		object.setTotal(showDataCondition.getTotal());
		return object;
	}

	private Miss_control_task_detailWithBLOBs getTaskLastData(String taskId) {

		List<Miss_control_task_detailWithBLOBs> taskDetailsByTime = taskDetailMapper.getTaskDetailsByTime(taskId);
		return taskDetailsByTime.get(0);
	}

	private OperateDTO converseToOperataDTO(Miss_control_task_records control_task_records) {
		OperateDTO operateDTO = new OperateDTO();
		String taskchangeafterjson = getTaskLastData(control_task_records.getTaskId()).getTaskchangeafterjson();
		JSONObject parseObject = JSON
				.parseObject(taskchangeafterjson);
//		parseObject.put("taskId", control_task_records.getTaskId());
		operateDTO.setJsonStr(parseObject);
		operateDTO.setTaskId(control_task_records.getTaskId());
		operateDTO.setTaskType(control_task_records.getTasktype());
		operateDTO.setTaskTitle(control_task_records.getTasktitle());
		operateDTO.setTaskStatus(control_task_records.getTaskstatus());
		operateDTO.setTaskMenuType(control_task_records.getTaskmenutype());
		return operateDTO;
	}

	@Override
	public Object getMissionDetailPage(Integer currentPage, Integer pageSize, String taskId) {
		Miss_control_task_detailWithBLOBs miss_control_task_detailWithBLOBs = new Miss_control_task_detailWithBLOBs();
		if(taskId != null) {
			miss_control_task_detailWithBLOBs.setTaskId(taskId);
		}
		PageHelper.startPage(currentPage, pageSize);
		Page<Miss_control_task_detailWithBLOBs> showDataCondition = (Page<Miss_control_task_detailWithBLOBs>) taskDetailMapper.showDataCondition(miss_control_task_detailWithBLOBs);
		List<OperateDTO> listOp = new ArrayList<>();
		for ( int i=0;i<showDataCondition.size();i++) {
			OperateDTO operateDTO = new OperateDTO();
			ControlTaskDetail controlTaskDetail = new ControlTaskDetail();
			Miss_control_task_detailWithBLOBs taskDetail = showDataCondition.get(i);
			BeanUtils.copyProperties(taskDetail, controlTaskDetail);
			controlTaskDetail.setTaskchangebeforejson(taskDetail.getTaskchangebeforejson() == null ? null : JSONObject.parseObject(taskDetail.getTaskchangebeforejson()));
			controlTaskDetail.setTaskchangeafterjson(taskDetail.getTaskchangeafterjson() == null ? null : JSONObject.parseObject(taskDetail.getTaskchangeafterjson()));
			operateDTO.setJsonStr(JSONObject.parseObject(JSONObject.toJSONString(controlTaskDetail)));
			listOp.add(operateDTO);
		}
		PageObject object = new PageObject<OperateDTO>();
		object.setCurrentPage(showDataCondition.getPageNum());
		object.setParams(listOp);
		object.setTotal(showDataCondition.getTotal());
		return object;
	}

}
