package com.med.info.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.med.info.domain.Miss_control_role;
import com.med.info.domain.Miss_control_user;
import com.med.info.dto.BatchOperateDTO;
import com.med.info.dto.ClaimTaskDTO;
import com.med.info.dto.SelectTaskDTO;
import com.med.info.mapper.domain.UserInfoDTO;
import com.med.info.mapper.domain.UserRoleDTO;
import com.med.info.service.MissControlRoleService;
import com.med.info.service.MissControlUserService;
import com.med.info.utils.CollectionUtil;
import com.med.info.utils.OperateEnum;
import com.med.info.utils.SelectMapUtil;
import com.med.info.utils.TrialStatusEnum;
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
	@Autowired
	private MissControlUserService missControlUserService;
	@Autowired
	private MissControlRoleService missControlRoleService;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(MissionServiceImpl.class);

	private static Map<String, String> taskStatusToRecordField = new HashMap<>();

	static {
		taskStatusToRecordField.put("toFirAudited", "taskfirsttrialcode");
		taskStatusToRecordField.put("toSecAudited", "tasksecondtrialcode");
		taskStatusToRecordField.put("toFinalAudited", "taskfinaltrialcode");
	}

	@Override
	public Object saveMission(OperateDTO operateDTO) {
		operateDTO.verify();
		for (IOperateService iOperateService : operateServices) {
			if (iOperateService.isFilter(operateDTO.getTaskMenuType())) {
				iOperateService.doOperate(operateDTO);
				return operateDTO;
			}
		}	
		return null;
	}

	@Override
	public Object BatchSaveMission(BatchOperateDTO batchOperateDTO) throws Exception {
		if(CollectionUtil.isNotEmpty(batchOperateDTO.getTasks())){
			List<Miss_control_task_records> missControlTaskRecords = taskRecordsMapper.getCurrentTrialStatusByTaskids(batchOperateDTO.getTasks());
			checkTaskStatus(missControlTaskRecords, batchOperateDTO.getTrailStatus());
			if(batchOperateDTO.getTrailStatus().equals(TrialStatusEnum.ONLINE.getId())){
				for (Miss_control_task_records taskRecord : missControlTaskRecords) {
					for (IOperateService operateService : operateServices) {
						if (operateService.isFilter(taskRecord.getTaskmenutype())) {
							operateService.doOnline(taskRecord);
						}
					}
				}
			} else if (batchOperateDTO.getTrailStatus().equals(TrialStatusEnum.OFFLINE.getId())){
				for (Miss_control_task_records taskRecord : missControlTaskRecords) {
					for (IOperateService operateService : operateServices) {
						if (operateService.isFilter(taskRecord.getTaskmenutype())) {
							operateService.doOffline(taskRecord);
						}
					}
				}
			}else{
				for (Miss_control_task_records taskRecord : missControlTaskRecords) {
					for (IOperateService operateService : operateServices) {
						if (operateService.isFilter(taskRecord.getTaskmenutype())) {
							if(batchOperateDTO.getTrailStatus().equals(TrialStatusEnum.FIRST_AUDITED_SUCCESS.getId()) ||
									batchOperateDTO.getTrailStatus().equals(TrialStatusEnum.SECOND_AUDITED_SUCCESS.getId()) ||
									batchOperateDTO.getTrailStatus().equals(TrialStatusEnum.FINAL_AUDITED_SUCCESS.getId())){
								operateService.doBatchOperate(taskRecord, OperateEnum.approveSuccess.toString(), batchOperateDTO.getApproveMessage());
							}else{
								operateService.doBatchOperate(taskRecord, OperateEnum.approveFail.toString(), batchOperateDTO.getApproveMessage());
							}
						}
					}
				}
			}

		}


		return null;
	}

	private boolean checkTaskStatus(List<Miss_control_task_records> missControlTaskRecords, String nextTrailStatus) throws Exception {
		if(CollectionUtil.isNotEmpty(missControlTaskRecords)){
			//初审状态
			if(nextTrailStatus.equals(TrialStatusEnum.FIRST_AUDITED_FAILED.getId()) || nextTrailStatus.equals(TrialStatusEnum.FIRST_AUDITED_SUCCESS.getId())){
				for (Miss_control_task_records records : missControlTaskRecords) {
					if(!records.getTaskstatus().equals(TrialStatusEnum.FINAL_AUDITEDING.getId())){
						throw new Exception("当前任务不是都为一审中，请检查！");
					}
				}
			}
			//二审状态
			if(nextTrailStatus.equals(TrialStatusEnum.SECOND_AUDITED_FAILED.getId()) || nextTrailStatus.equals(TrialStatusEnum.SECOND_AUDITED_SUCCESS.getId())){
				for (Miss_control_task_records records : missControlTaskRecords) {
					if(!records.getTaskstatus().equals(TrialStatusEnum.SECOND_AUDITEDING.getId())){
						throw new Exception("当前任务不是都为二审中，请检查！");
					}
				}
			}
			//终审状态
			if(nextTrailStatus.equals(TrialStatusEnum.FINAL_AUDITED_FAILED.getId()) || nextTrailStatus.equals(TrialStatusEnum.FINAL_AUDITED_SUCCESS.getId())){
				for (Miss_control_task_records records : missControlTaskRecords) {
					if(!records.getTaskstatus().equals(TrialStatusEnum.FINAL_AUDITEDING.getId())){
						throw new Exception("当前任务不是都为终审中，请检查！");
					}
				}
			}

			//上线
			if(nextTrailStatus.equals(TrialStatusEnum.ONLINE.getId())){
				for (Miss_control_task_records records : missControlTaskRecords) {
					if(!records.getTaskstatus().equals(TrialStatusEnum.FINAL_AUDITED_SUCCESS.getId())){
						throw new Exception("当前任务不是都为终审通过，请检查！");
					}
				}
			}


		}
		throw new Exception("批量操作任务状态不正确，请检查！");

	}

	@Override
	public Object getByPage(SelectTaskDTO selectTaskDTO, boolean useCurrentUser) {

		selectTaskDTO.setCreateUserCode(missControlUserService.selectUserCodeByNames(selectTaskDTO.getCreateUser()));
		selectTaskDTO.setFinalTrialUserCode(missControlUserService.selectUserCodeByNames(selectTaskDTO.getFinalTrialUser()));
		selectTaskDTO.setFirstTrialUserCode(missControlUserService.selectUserCodeByNames(selectTaskDTO.getFirstTrialUser()));
		selectTaskDTO.setSecondTrialUserCode(missControlUserService.selectUserCodeByNames(selectTaskDTO.getSecondTrialUser()));
		Map<String, Object> record = SelectMapUtil.converseObjectToMap(selectTaskDTO);
		if(useCurrentUser){
			record.put("currentUser", DefaultTokenManager.getLocalUserCode().getUserCode());
		}
		logger.info("查询任务，record={}",JSON.toJSONString(record));
        PageHelper.startPage(selectTaskDTO.getCurrentPage(), selectTaskDTO.getPageSize() == null ? 10 : selectTaskDTO.getPageSize());
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
			operateDTO.setTaskMenuType(taskDetail.getTaskmenutype());
			listOp.add(operateDTO);
		}
		PageObject object = new PageObject<OperateDTO>();
		object.setCurrentPage(showDataCondition.getPageNum());
		object.setParams(listOp);
		object.setTotal(showDataCondition.getTotal());
		return object;
	}


	@Override
	public Object claimTask(ClaimTaskDTO claimTaskDTO) throws Exception {
		String taskFeild = taskStatusToRecordField.get(claimTaskDTO.getTaskStatus());
		Miss_control_task_records miss_control_task_records = taskRecordsMapper.selectByPrimaryKey(claimTaskDTO.getTaskId());
		if(claimTaskDTO.getStatus() == 1){
			Field field = Miss_control_task_records.class.getField(taskFeild);
			field.setAccessible(true);
			Object o = field.get(miss_control_task_records);
			if(null == o || o.toString().equals("") || o.toString().equals(DefaultTokenManager.getLocalUserCode())){
				field.set(miss_control_task_records, DefaultTokenManager.getLocalUserCode());
				taskRecordsMapper.updateByTaskIdSelective(miss_control_task_records);
			}else{
				throw new Exception("当前任务已经被标记，请选择其他任务！");
			}
		}else{
			Field field = Miss_control_task_records.class.getField(taskFeild);
			field.setAccessible(true);
			Object o = field.get(miss_control_task_records);
			if(null != o && !o.toString().equals("") && o.toString().equals(DefaultTokenManager.getLocalUserCode())){
				field.set(miss_control_task_records, null);
				taskRecordsMapper.updateByPrimaryKey(miss_control_task_records);
			}else{
				throw new Exception("当前任务已经被其他操作者标记，请选择其他任务！");
			}
		}
		return null;
	}

	private Miss_control_task_detailWithBLOBs getTaskLastData(String taskId) {

		List<Miss_control_task_detailWithBLOBs> taskDetailsByTime = taskDetailMapper.getTaskDetailsByTime(taskId);
		return taskDetailsByTime.get(0);
	}

	private OperateDTO converseToOperataDTO(Miss_control_task_records control_task_records) {
		OperateDTO operateDTO = new OperateDTO();
		operateDTO.setTaskId(control_task_records.getTaskId());
		operateDTO.setTaskType(control_task_records.getTasktype());
		operateDTO.setTaskTitle(control_task_records.getTasktitle());
		operateDTO.setTaskStatus(control_task_records.getTaskstatus());
		operateDTO.setTaskMenuType(control_task_records.getTaskmenutype());
		Miss_control_user createUser = missControlUserService.selectByCode(control_task_records.getTaskcreaterusercode());
		if(null == createUser){
			operateDTO.setCreateUser(new UserInfoDTO(control_task_records.getTaskcreaterusercode(), ""));
		}else{
			operateDTO.setCreateUser(new UserInfoDTO(control_task_records.getTaskcreaterusercode(), createUser.getUserName()));
		}
		operateDTO.setTaskCreateTime(control_task_records.getTaskcreatetime());
		Miss_control_role createRole = missControlRoleService.selectByRoleCode(control_task_records.getTaskCreateRoleCode());
		if(null == createRole){
			operateDTO.setCreateUserRole(new UserRoleDTO(control_task_records.getTaskCreateRoleCode(), ""));
		}else{
			operateDTO.setCreateUserRole(new UserRoleDTO(control_task_records.getTaskCreateRoleCode(), createRole.getRolename()));
		}
		Miss_control_user firstTrialUser = missControlUserService.selectByCode(control_task_records.getTaskfirsttrialcode());
		if(null == firstTrialUser){
			operateDTO.setFirstTrialUser(new UserInfoDTO(control_task_records.getTaskfirsttrialcode(), ""));
		}else{
			operateDTO.setFirstTrialUser(new UserInfoDTO(control_task_records.getTaskfirsttrialcode(), firstTrialUser.getUserName()));
		}
		operateDTO.setTaskFirstTrialPoint(control_task_records.getTaskFirstTrialPoint());
		operateDTO.setTaskFirstTrialTime(control_task_records.getTaskFirstTrialTime());

		Miss_control_user secondTrialUser = missControlUserService.selectByCode(control_task_records.getTasksecondtrialcode());
		if(null == secondTrialUser){
			operateDTO.setSecondTrialUser(new UserInfoDTO(control_task_records.getTasksecondtrialcode(), ""));
		}else{
			operateDTO.setSecondTrialUser(new UserInfoDTO(control_task_records.getTasksecondtrialcode(), secondTrialUser.getUserName()));
		}
		operateDTO.setTaskSecondTrialPoint(control_task_records.getTaskSecondTrialPoint());
		operateDTO.setTaskSecondTrialTime(control_task_records.getTaskSecondTrialTime());

		Miss_control_user finalTrialUser = missControlUserService.selectByCode(control_task_records.getTaskfinaltrialcode());
		if(null == finalTrialUser){
			operateDTO.setFinalTrialUser(new UserInfoDTO(control_task_records.getTaskfinaltrialcode(), ""));
		}else{
			operateDTO.setFinalTrialUser(new UserInfoDTO(control_task_records.getTaskfinaltrialcode(), finalTrialUser.getUserName()));
		}
		operateDTO.setTaskFinalTrialTime(control_task_records.getTaskFinalTrialTime());

		operateDTO.setUpdateTime(control_task_records.getUpdateTime());

		return operateDTO;
	}
}
