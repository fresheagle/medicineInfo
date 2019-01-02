package com.med.info.service.operate.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.BaseDomain;
import com.med.info.domain.Miss_control_task_detailWithBLOBs;
import com.med.info.domain.Miss_control_task_records;
import com.med.info.mapper.Miss_control_task_detailMapper;
import com.med.info.mapper.Miss_control_task_recordsMapper;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.impl.DefaultTokenManager;
import com.med.info.service.operate.IOperateService;
import com.med.info.utils.*;
import org.junit.Assert;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public abstract class AbstractOperateService<T extends BaseDomain> implements IOperateService {

    @Autowired
    private Miss_control_task_recordsMapper taskRecordsMapper;
    @Autowired
    private Miss_control_task_detailMapper taskDetailMapper;

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(AbstractOperateService.class);


    @Override
    @Transactional
    public String doOperate(OperateDTO operateDTO) {
        logger.info("接受到请求参数={}", JSON.toJSONString(operateDTO));
        T object = (T) JSON.toJavaObject(getParmJsonObject(operateDTO.getJsonStr()), getCurrentClass());
        BaseService<T> baseService = baseService(operateDTO.getTaskMenuType());
        TrialStatusEnum trialStatusEnum = TrialStatusEnum.getTrialStatusEnum(operateDTO.getTaskStatus());
        Assert.assertNotNull("任务状态异常，不能为:"+operateDTO.getTaskStatus()+"，请确认",trialStatusEnum);
        doOperate(operateDTO, object, baseService, trialStatusEnum);
        return null;
    }

    public JSONObject getParmJsonObject(JSONObject object) {

        return object.getJSONObject(getJsonParamKey());

    }

    public abstract String getJsonParamKey();




    public void createTaskDetail(OperateDTO operateDTO, T object, String taskId, TrialStatusEnum trialStatusEnum) {
        Miss_control_task_detailWithBLOBs taskLastData = getTaskLastData(taskId);
        Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
        if (null == taskLastData) {
            controlTaskDetail.setTaskstatuschangebefore(taskLastData.getTaskstatuschangeafter());
            controlTaskDetail.setTaskchangebeforejson(taskLastData.getTaskchangeafterjson());
        }
        controlTaskDetail.setTaskId(object.getTaskId());
        controlTaskDetail.setTaskmenutype(operateDTO.getTaskMenuType());
        controlTaskDetail.setTaskstatuschangeafter(trialStatusEnum.toString());
        controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode().getUserCode());
        controlTaskDetail.setTaskchangepoints(operateDTO.getTaskChangePoints());
        controlTaskDetail.setTaskchangecomments(operateDTO.getTaskChangeComments());
        controlTaskDetail.setTaskchangevote(operateDTO.getTaskChangeVote());
        controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
        controlTaskDetail.setTaskchangetime(new Timestamp(System.currentTimeMillis()));
        controlTaskDetail.setTaskchangeday(getToday());
        controlTaskDetail.setTaskchangeafterjson(JSON.toJSONString(operateDTO.getJsonStr()));
        taskDetailMapper.insert(controlTaskDetail);
    }

    public abstract boolean needDealMapper();

    @Override
    public boolean isFilter(OperateDTO operateDTO) {
        return operateDTO.getTaskMenuType().equals(getCurrentMenuType());
    }

    public abstract String getCurrentMenuType();


    private void createObject(OperateDTO operateDTO, T object, BaseService<T> baseService, String taskId, JSONObject jsonStr, String taskStatus) {
        if (operateDTO.getTaskType().equals(TaskType.create.toString()) && object.getId() == null) {
            object.setTaskJson(JSON.toJSONString(jsonStr));
            object.setTaskId(taskId);
            object.setId(null);
            object.setTaskStatus(taskStatus);
            baseService.insert(object);
            JSONObject parmJsonObject = getParmJsonObject(operateDTO.getJsonStr());
            parmJsonObject.put("id", object.getId());
            operateDTO.getJsonStr().put(getJsonParamKey(), parmJsonObject);
        }
    }

    private String getToday() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        return sf.format(c.getTime());
    }

    private void doOperate(OperateDTO operateDTO, T object, BaseService<T> baseService, TrialStatusEnum trialStatusEnum) {
        Miss_control_task_records taskRecordByTaskId = getTaskRecordByTaskId(operateDTO.getTaskId());
        //如果为空表示新建的task数据需要创建taskRecord
        if (null == taskRecordByTaskId) {
            taskRecordByTaskId = createTaskRecord(operateDTO, operateDTO.getTaskId(), trialStatusEnum);
        }
        JSONObject jsonStr = operateDTO.getJsonStr();
        //判断是否需要创建数据到实际表中
        createObject(operateDTO, object, baseService, operateDTO.getTaskId(), jsonStr, trialStatusEnum.getId());
        T selectByPrimaryId = baseService.selectByPrimaryId(object.getId());
        selectByPrimaryId.setTaskJson(JSON.toJSONString(operateDTO.getJsonStr()));
        selectByPrimaryId.setTaskId(operateDTO.getTaskId());
        selectByPrimaryId.setDatastatus("0");
        selectByPrimaryId.setTaskStatus(getNextStatus(operateDTO.getOperateCode(), trialStatusEnum, taskRecordByTaskId).toString());
        baseService.updateByPrimaryKey(selectByPrimaryId);
        //如果为空表示新建的task数据需要创建taskRecord
        Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
        controlTaskRecord.setTaskId(operateDTO.getTaskId());
        controlTaskRecord.setTaskstatus(getNextStatus(operateDTO.getOperateCode(), trialStatusEnum, taskRecordByTaskId).toString());
        controlTaskRecord.setTasktitle(operateDTO.getTaskTitle());
        controlTaskRecord.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        taskRecordsMapper.updateByTaskIdSelective(controlTaskRecord);
        createTaskDetail(operateDTO, object, operateDTO.getTaskId(), getNextStatus(operateDTO.getOperateCode(), trialStatusEnum, taskRecordByTaskId));


    }

    public TrialStatusEnum getNextStatus(String operateCode, TrialStatusEnum trialStatusEnum, Miss_control_task_records controlTaskRecords) {
        //处理 草稿箱 任务
        if (operateCode == OperateEnum.save.toString() && trialStatusEnum == TrialStatusEnum.DRAFTS) {
            return TrialStatusEnum.DRAFTS;
        }
        if (operateCode == OperateEnum.approveSuccess.toString() && trialStatusEnum == TrialStatusEnum.DRAFTS) {
            if (controlTaskRecords.getFirstTrialRoleCode() != null) {
                return TrialStatusEnum.FIRST_AUDITEDING;
            }
            return TrialStatusEnum.TO_FIRST_AUDITED;
        }
        //处理 初审未通过 任务
        if(trialStatusEnum == TrialStatusEnum.FIRST_AUDITED_FAILED && operateCode == OperateEnum.save.toString() ){
            return TrialStatusEnum.DRAFTS;
        }
        if(trialStatusEnum == TrialStatusEnum.FIRST_AUDITED_FAILED && operateCode == OperateEnum.approveSuccess.toString() ){
            if (controlTaskRecords.getFirstTrialRoleCode() != null) {
                return TrialStatusEnum.FIRST_AUDITEDING;
            }
            return TrialStatusEnum.TO_FIRST_AUDITED;
        }

        //处理 一审中 任务
        if(trialStatusEnum == TrialStatusEnum.FIRST_AUDITEDING && operateCode == OperateEnum.approveFail.toString() ){
            return TrialStatusEnum.FIRST_AUDITED_FAILED;
        }
        if(trialStatusEnum == TrialStatusEnum.FIRST_AUDITEDING && operateCode == OperateEnum.approveSuccess.toString() ){
            if (controlTaskRecords.getSecondTrialRoleCode() != null) {
                return TrialStatusEnum.SECOND_AUDITEDING;
            }
            return TrialStatusEnum.TO_SECOND_AUDITED;
        }

        //处理 二审未通过 任务
        if(trialStatusEnum == TrialStatusEnum.SECOND_AUDITED_FAILED && operateCode == OperateEnum.approveFail.toString() ){
            return TrialStatusEnum.FIRST_AUDITED_FAILED;
        }
        if(trialStatusEnum == TrialStatusEnum.SECOND_AUDITED_FAILED && operateCode == OperateEnum.approveSuccess.toString() ){
            if (controlTaskRecords.getSecondTrialRoleCode() != null) {
                return TrialStatusEnum.SECOND_AUDITEDING;
            }
            return TrialStatusEnum.TO_SECOND_AUDITED;
        }

        //处理 二审中 任务
        if(trialStatusEnum == TrialStatusEnum.SECOND_AUDITEDING && operateCode == OperateEnum.approveFail.toString() ){
            return TrialStatusEnum.SECOND_AUDITED_FAILED;
        }
        if(trialStatusEnum == TrialStatusEnum.SECOND_AUDITEDING && operateCode == OperateEnum.approveSuccess.toString() ){
            if (controlTaskRecords.getFinalTrialRoleCode() != null) {
                return TrialStatusEnum.FINAL_AUDITEDING;
            }
            return TrialStatusEnum.TO_FINAL_AUDITED;
        }

        //处理 终审未通过 任务
        if(trialStatusEnum == TrialStatusEnum.FINAL_AUDITED_FAILED && operateCode == OperateEnum.approveFail.toString() ){
            return TrialStatusEnum.SECOND_AUDITED_FAILED;
        }
        if(trialStatusEnum == TrialStatusEnum.FINAL_AUDITED_FAILED && operateCode == OperateEnum.approveSuccess.toString() ){
            if (controlTaskRecords.getSecondTrialRoleCode() != null) {
                return TrialStatusEnum.FINAL_AUDITEDING;
            }
            return TrialStatusEnum.TO_FINAL_AUDITED;
        }

        //处理 终审中 任务
        if(trialStatusEnum == TrialStatusEnum.FINAL_AUDITEDING && operateCode == OperateEnum.approveFail.toString() ){
            return TrialStatusEnum.FINAL_AUDITED_FAILED;
        }
        if(trialStatusEnum == TrialStatusEnum.FINAL_AUDITEDING && operateCode == OperateEnum.approveSuccess.toString() ){
            return TrialStatusEnum.FINAL_AUDITED_SUCCESS;
        }

        return null;
    }


    private Miss_control_task_records createTaskRecord(OperateDTO operateDTO, String taskId, TrialStatusEnum drafts) {
        Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
        controlTaskRecord.setTaskcreaterusercode(DefaultTokenManager.getLocalUserCode().getUserCode());
        controlTaskRecord.setTaskcreatetime(new Timestamp(System.currentTimeMillis()));
        controlTaskRecord.setTaskcreateday(getToday());
        controlTaskRecord.setTaskId(taskId);
        controlTaskRecord.setTaskstatus(drafts.getId());
        controlTaskRecord.setTaskmenutype(operateDTO.getTaskMenuType());
        controlTaskRecord.setTasktype(operateDTO.getTaskType());
        controlTaskRecord.setTasktitle(operateDTO.getTaskTitle());
        taskRecordsMapper.insert(controlTaskRecord);
        return controlTaskRecord;
    }


    private Miss_control_task_detailWithBLOBs getTaskLastData(String taskId) {

        List<Miss_control_task_detailWithBLOBs> taskDetailsByTime = taskDetailMapper.getTaskDetailsByTime(taskId);
        return taskDetailsByTime.get(0);
    }

    private Miss_control_task_records getTaskRecordByTaskId(String taskId) {
        return taskRecordsMapper.selectByPrimaryKey(taskId);
    }


    public abstract BaseService<T> baseService(String menuType);

    protected void dealMapperRelashionShip(OperateDTO operateDTO){

    }

    public abstract Class<?> getCurrentClass();

}
