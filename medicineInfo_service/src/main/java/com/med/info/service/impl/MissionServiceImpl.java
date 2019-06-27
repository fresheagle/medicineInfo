package com.med.info.service.impl;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

import com.med.info.domain.Miss_control_role;
import com.med.info.domain.Miss_control_user;
import com.med.info.dto.*;
import com.med.info.mapper.domain.UserInfoDTO;
import com.med.info.mapper.domain.UserRoleDTO;
import com.med.info.service.ExportService;
import com.med.info.service.MissControlRoleService;
import com.med.info.service.MissControlUserService;
import com.med.info.utils.CollectionUtil;
import com.med.info.utils.OperateEnum;
import com.med.info.utils.SelectMapUtil;
import com.med.info.utils.TrialStatusEnum;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.med.info.mapper.Miss_control_task_detailMapper;
import com.med.info.mapper.Miss_control_task_recordsMapper;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissionService;
import com.med.info.service.operate.IOperateService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MissionServiceImpl implements MissionService {

	@Autowired
	private List<IOperateService> operateServices;
//	@Autowired
//	private IOperateService iOperateService;
	@Autowired
	private Miss_control_task_recordsMapper taskRecordsMapper;
	@Autowired
	private Miss_control_task_detailMapper taskDetailMapper;
	@Autowired
	private MissControlUserService missControlUserService;
	@Autowired
	private MissControlRoleService missControlRoleService;
	@Autowired
	private ExportService exportService;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(MissionServiceImpl.class);

	private static Map<String, String> taskStatusToRecordField = new HashMap<>();

	private static Map<String, String> taskStatusToRoleCode = new HashMap<>();

	private static Map<String, String> taskStatusToNextStatus = new HashMap<>();

	private static List<String> title = new ArrayList<>();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static {
		taskStatusToRecordField.put("toFirAudited", "taskfirsttrialcode");
		taskStatusToRecordField.put("toSecAudited", "tasksecondtrialcode");
		taskStatusToRecordField.put("toFinalAudited", "taskfinaltrialcode");


		taskStatusToRoleCode.put("taskfirsttrialcode", "002");
		taskStatusToRoleCode.put("tasksecondtrialcode", "003");
		taskStatusToRoleCode.put("taskfinaltrialcode", "004");

        title.add("标题");title.add("最新进度");title.add("作者");title.add("创建日期");
        title.add("编辑组");title.add("初审者");title.add("初审得分");title.add("初审日期");
        title.add("二审者");title.add("二审得分");title.add("二审日期");title.add("终审者");
        title.add("终审得分");title.add("终审日期");title.add("更新日期");title.add("版本");
        title.add("在线状态");title.add("其他状态");
	}

	static {
		taskStatusToNextStatus.put("toFirAudited", "firAuditeding");
		taskStatusToNextStatus.put("toSecAudited", "secAuditeding");
		taskStatusToNextStatus.put("toFinalAudited", "finalAuditeding");
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
		if(null != batchOperateDTO.getTrailStatus() && missControlUserService.isOnlyEditor(DefaultTokenManager.getLocalUserCode().getUserCode())) {
			throw new Exception("当前用户无权限批量操作");
		}
		if((batchOperateDTO.getTrailStatus().equals("online") || batchOperateDTO.getTrailStatus().equals("offline")) && !missControlUserService.isAdministrator(DefaultTokenManager.getLocalUserCode().getUserCode())) {
			throw new Exception("当前用户无权限批量操作");
		}
		
		if(CollectionUtil.isNotEmpty(batchOperateDTO.getTasks())){
			List<Miss_control_task_records> missControlTaskRecords = taskRecordsMapper.getCurrentTrialStatusByTaskids(batchOperateDTO.getTasks());
			logger.info("批量操作任务，数量为：{}, tasks:{}", null == missControlTaskRecords ? 0 : missControlTaskRecords.size(), batchOperateDTO.getTasks());
			checkTaskStatus(missControlTaskRecords, batchOperateDTO.getTrailStatus());
			if(batchOperateDTO.getTrailStatus().equals(TrialStatusEnum.ONLINE.getId())){
				if("success".equals(exportService.exportFile(missControlTaskRecords, batchOperateDTO))){
					for (Miss_control_task_records taskRecord : missControlTaskRecords) {
						for (IOperateService operateService : operateServices) {
							if (operateService.isFilter(taskRecord.getTaskmenutype())) {
								operateService.doOnline(taskRecord);
							}
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
					if(!records.getTaskstatus().equals(TrialStatusEnum.FIRST_AUDITEDING.getId())){
						throw new Exception("当前任务不是都为一审中，请检查！");
					}
				}
				return true;
			}
			//二审状态
			if(nextTrailStatus.equals(TrialStatusEnum.SECOND_AUDITED_FAILED.getId()) || nextTrailStatus.equals(TrialStatusEnum.SECOND_AUDITED_SUCCESS.getId())){
				for (Miss_control_task_records records : missControlTaskRecords) {
					if(!records.getTaskstatus().equals(TrialStatusEnum.SECOND_AUDITEDING.getId())){
						throw new Exception("当前任务不是都为二审中，请检查！");
					}
				}
				return true;
			}
			//终审状态
			if(nextTrailStatus.equals(TrialStatusEnum.FINAL_AUDITED_FAILED.getId()) || nextTrailStatus.equals(TrialStatusEnum.FINAL_AUDITED_SUCCESS.getId())){
				for (Miss_control_task_records records : missControlTaskRecords) {
					if(!records.getTaskstatus().equals(TrialStatusEnum.FINAL_AUDITEDING.getId())){
						throw new Exception("当前任务不是都为终审中，请检查！");
					}
				}
				return true;
			}

			//上线
			if(nextTrailStatus.equals(TrialStatusEnum.ONLINE.getId())){
				for (Miss_control_task_records records : missControlTaskRecords) {
					if(!records.getTaskstatus().equals(TrialStatusEnum.FINAL_AUDITED_SUCCESS.getId())){
						throw new Exception("当前任务不是都为终审通过，请检查！");
					}
				}
				return true;
			}
			if(nextTrailStatus.equals(TrialStatusEnum.OFFLINE.getId())){
                for (Miss_control_task_records records : missControlTaskRecords) {
                    if(null != records.getDataStatus() && !records.getDataStatus().equals(TrialStatusEnum.ONLINE.getId())){
                        throw new Exception("当前任务不是都为已上线，请检查！");
                    }
                }
                return true;
            }
		}
		throw new Exception("批量操作任务状态不正确，请检查！");

	}

	@Override
	public Object getByPage(SelectTaskDTO selectTaskDTO, boolean useCurrentUser) throws Exception {


		Map<String, Object> record = getStringObjectMap(selectTaskDTO, useCurrentUser);
		PageHelper.startPage(selectTaskDTO.getCurrentPage(), selectTaskDTO.getPageSize() == null ? 10 : selectTaskDTO.getPageSize());
        Page<Miss_control_task_records> showDataCondition = (Page<Miss_control_task_records>) taskRecordsMapper
				.selectPageBySelective(record);
		List<OperateDTO> list = new ArrayList<>();
		for (Miss_control_task_records miss_control_task_records : showDataCondition) {
			list.add(converseToOperataDTO(miss_control_task_records));
		}
		PageObject object = new PageObject<OperateDTO>();
		object.setCurrentPage(showDataCondition.getPageNum());
		object.setParams(list);
		object.setTotal(showDataCondition.getTotal());
		return object;
	}

	@Override
	public XSSFWorkbook exportDatas(SelectTaskDTO selectTaskDTO, boolean useCurrentUser) throws Exception {
		PageObject<OperateDTO> byPage = (PageObject<OperateDTO>) this.getByPage(selectTaskDTO, useCurrentUser);
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("sheet1");
		int rowNum = 0;
		XSSFRow row = sheet.createRow(rowNum++);
		HSSFCell cell = null;
		for(int i=0;i<title.size();i++){
			row.createCell(i).setCellValue(title.get(i));
		}
		Map<String, Object> record = getStringObjectMap(selectTaskDTO, useCurrentUser);
		List<Miss_control_task_records> showDataCondition = taskRecordsMapper.selectPageBySelective(record);
		List<OperateDTO> list = new ArrayList<>();
		for (Miss_control_task_records miss_control_task_records : showDataCondition) {
			OperateDTO param = converseToOperataDTO(miss_control_task_records);
			row = sheet.createRow(rowNum++);
			List<String> data = new ArrayList<>(title.size());
			data.add(param.getTaskTitle());
			data.add(TrialStatusEnum.getTrialStatusEnum(param.getTaskStatus()).getDesc());
			data.add(param.getCreateUser().getUserName());
			data.add(getTimeStr(param.getTaskCreateTime()));
			data.add(param.getCreateUser().getUserCode());
			data.add(param.getFirstTrialUser().getUserName());
			data.add(param.getTaskFirstTrialPoint());
			data.add(getTimeStr(param.getTaskFirstTrialTime()));
			data.add(param.getSecondTrialUser().getUserName());
			data.add(param.getTaskSecondTrialPoint());
			data.add(getTimeStr(param.getTaskSecondTrialTime()));
			data.add(param.getFinalTrialUser().getUserName());
			data.add(param.getTaskFinalTrialPint());
			data.add(getTimeStr(param.getTaskFinalTrialTime()));
			data.add(getTimeStr(param.getUpdateTime()));
			data.add(param.getDetailCount().toString());
			data.add(param.getDataStatus() == null ? "":param.getDataStatus().equalsIgnoreCase("1") ? "上线":"下线");
			data.add(param.getAccounts());
			for(int j=0;j<data.size();j++) {
				row.createCell(j).setCellValue(data.get(j));
			}
		}
        return wb;
	}

	private Map<String, Object> getStringObjectMap(SelectTaskDTO selectTaskDTO, boolean useCurrentUser) throws Exception {
		List<String> roleCodes = DefaultTokenManager.getLocalUserCode().getRoleCodes();
		if (selectTaskDTO.getPoolId() != null) {
			List<String> taskStatus = selectTaskDTO.getTaskStatus();
			if (taskStatus.contains(TrialStatusEnum.TO_FIRST_AUDITED.getId()) && !(roleCodes.contains("002") || roleCodes.contains("000"))) {
				throw new Exception("当前用户不包含初审角色，不能查看待初审任务");
			}
			if (taskStatus.contains(TrialStatusEnum.TO_SECOND_AUDITED.getId()) && !(roleCodes.contains("003") || roleCodes.contains("000"))) {
				throw new Exception("当前用户不包含二审角色，不能查看待二审任务");
			}
			if (taskStatus.contains(TrialStatusEnum.TO_FINAL_AUDITED.getId()) && !(roleCodes.contains("004") || roleCodes.contains("000"))) {
				throw new Exception("当前用户不包含终审角色，不能查看待终审任务");
			}
		}
		logger.info("当前查询部分参数为：poolId:{}, roleCodes:{}, taskStatus: {}", selectTaskDTO.getPoolId(), roleCodes, selectTaskDTO.getTaskStatus());
		if (roleCodes.contains("000")) {
			Map<String, Object> record = SelectMapUtil.converseObjectToMap(selectTaskDTO);
			logger.info("查询任务，record={}", JSON.toJSONString(record));
			return record;
		}
		selectTaskDTO.setCreateUserCode(missControlUserService.selectUserCodeByNames(selectTaskDTO.getCreateUser()));
		selectTaskDTO.setFinalTrialUserCode(missControlUserService.selectUserCodeByNames(selectTaskDTO.getFinalTrialUser()));
		selectTaskDTO.setFirstTrialUserCode(missControlUserService.selectUserCodeByNames(selectTaskDTO.getFirstTrialUser()));
		selectTaskDTO.setSecondTrialUserCode(missControlUserService.selectUserCodeByNames(selectTaskDTO.getSecondTrialUser()));
		Map<String, Object> record = SelectMapUtil.converseObjectToMap(selectTaskDTO);
		if (useCurrentUser) {
			record.put("currentUser", DefaultTokenManager.getLocalUserCode().getUserCode());
		}
		logger.info("查询任务，record={}", JSON.toJSONString(record));
		return record;
	}

	private String getTimeStr(Date time) {
	    if(time == null){
	        return "";
        }
        return sdf.format(time);
    }

    @Override
	@Transactional
    public void deleteMission(List<String> taskIds) throws Exception{
    	if(!missControlUserService.isAdministrator(DefaultTokenManager.getLocalUserCode().getUserCode())) {
    		throw new Exception("当前用户无权限批量操作");
    	}
		taskIds.forEach(s -> {
			Miss_control_task_records taskRecord = taskRecordsMapper.selectByPrimaryKey(s);
			taskRecord.setTaskStatus(TrialStatusEnum.RECYCLE.getId());
			taskRecordsMapper.updateByTaskIdSelective(taskRecord);
			for (IOperateService operateService : operateServices) {
				if(operateService.isFilter(taskRecord.getTaskmenutype())){
					operateService.doOffline(taskRecord);
				}
			}
		});
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
		String s = taskStatusToRoleCode.get(taskFeild);
		logger.info("当前认领任务状态需要设置{}， 需要对应角色权限为：{}", taskFeild, s);
		//TODO 添加权限匹配

		for (String taskId : claimTaskDTO.getTaskIds()) {
			Miss_control_task_records miss_control_task_records = taskRecordsMapper.selectByPrimaryKey(taskId);
			if(claimTaskDTO.getStatus() == 1){
				Field field = Miss_control_task_records.class.getDeclaredField(taskFeild);
				field.setAccessible(true);
				Object o = field.get(miss_control_task_records);
				if(null == o || o.toString().equals("") || o.toString().equals(DefaultTokenManager.getLocalUserCode().getUserCode())){
					field.set(miss_control_task_records, DefaultTokenManager.getLocalUserCode().getUserCode());
					miss_control_task_records.setTaskstatus(taskStatusToNextStatus.get(claimTaskDTO.getTaskStatus()));
					taskRecordsMapper.updateByTaskIdSelective(miss_control_task_records);
				}else{
					throw new Exception("当前任务已经被标记，请选择其他任务！");
				}
			}else{
				Field field = Miss_control_task_records.class.getDeclaredField(taskFeild);
				field.setAccessible(true);
				Object o = field.get(miss_control_task_records);
				if(null != o && !o.toString().equals("") && o.toString().equals(DefaultTokenManager.getLocalUserCode().getUserCode())){
					field.set(miss_control_task_records, null);
					taskRecordsMapper.updateByPrimaryKey(miss_control_task_records);
				}else{
					throw new Exception("当前任务已经被其他操作者标记，请选择其他任务！");
				}
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
		List<Miss_control_task_detailWithBLOBs> taskDetailsByTime = taskDetailMapper.getTaskDetailsByTime(control_task_records.getTaskId());
		operateDTO.setDetailCount(taskDetailsByTime.size());
		operateDTO.setJsonStr(JSONObject.parseObject(taskDetailsByTime.get(0).getTaskchangeafterjson()));
		operateDTO.setTaskChangeComments(taskDetailsByTime.get(0).getTaskchangecomments());
		operateDTO.setAccounts(control_task_records.getAccounts());
		operateDTO.setDataStatus(control_task_records.getDataStatus());
		return operateDTO;
	}

	@Override
	@Transactional
	public Object BatchAcounts(BatchAcountsDTO accounts) throws Exception{
		if(!missControlUserService.isAdministrator(DefaultTokenManager.getLocalUserCode().getUserCode())) {
    		throw new Exception("当前用户无权限批量操作");
    	}
		if(CollectionUtil.isNotEmpty(accounts.getTasks())) {
			List<Miss_control_task_records> missControlTaskRecords = taskRecordsMapper.getCurrentTrialStatusByTaskids(accounts.getTasks());
			for (Miss_control_task_records missControlTaskRecord : missControlTaskRecords) {
				for (IOperateService operateService : operateServices) {
					if(operateService.isFilter(missControlTaskRecord.getTaskmenutype())){
						operateService.accounts(missControlTaskRecord, accounts.getAccounts());
					}
				}
			}
		}
		return null;
	}

	@Override
	@Transactional
	public void resetTask(BatchResetTaskDTO batchResetTaskDTO) throws Exception{
		if(!missControlUserService.isAdministrator(DefaultTokenManager.getLocalUserCode().getUserCode())) {
    		throw new Exception("当前用户无权限批量操作");
    	}
		List<String> tasks = batchResetTaskDTO.getTasks();
		List<Miss_control_task_records> currentTrialStatusByTaskids = taskRecordsMapper.getCurrentTrialStatusByTaskids(tasks);
		for (Miss_control_task_records controlTaskRecords : currentTrialStatusByTaskids) {
			if(batchResetTaskDTO.getTrialUser() != null && batchResetTaskDTO.getTrialUser().contains("finalTrialUser")){
				controlTaskRecords.setTaskfinaltrialcode(null);
			}
			if(batchResetTaskDTO.getTrialUser() != null && batchResetTaskDTO.getTrialUser().contains("firstTrialUser")){
				controlTaskRecords.setTaskfirsttrialcode(null);
			}
			if(batchResetTaskDTO.getTrialUser() != null && batchResetTaskDTO.getTrialUser().contains("secondTrialUser")){
				controlTaskRecords.setTasksecondtrialcode(null);
			}
			controlTaskRecords.setUpdateTime(new Date());
			taskRecordsMapper.updateByPrimaryKey(controlTaskRecords);
			for (IOperateService operateService : operateServices) {
				if(operateService.isFilter(controlTaskRecords.getTaskmenutype())){
					operateService.resetStatus(controlTaskRecords, batchResetTaskDTO.getResetStatus());
				}
			}
		}
	}

	@Override
	@Transactional
	public void resetCreateUser(BatchResetTaskDTO batchResetTaskDTO) throws Exception{
		if(!missControlUserService.isAdministrator(DefaultTokenManager.getLocalUserCode().getUserCode())) {
    		throw new Exception("当前用户无权限批量操作");
    	}
		List<String> tasks = batchResetTaskDTO.getTasks();
		taskRecordsMapper.resetCreateUserByTaskids(tasks, batchResetTaskDTO.getUserCode());
	}
}
