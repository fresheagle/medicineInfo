package com.med.info.service.operate.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.*;
import com.med.info.dto.MissReferenceDTO;
import com.med.info.dto.RefrenceDTO;
import com.med.info.mapper.Miss_control_task_detailMapper;
import com.med.info.mapper.Miss_control_task_recordsMapper;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissControlApprovalService;
import com.med.info.service.MissControlReferenceService;
import com.med.info.service.impl.DefaultTokenManager;
import com.med.info.service.operate.IOperateService;
import com.med.info.utils.*;
import org.junit.Assert;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class AbstractOperateService<T extends BaseDomain, F> implements IOperateService {

    @Autowired
    private Miss_control_task_recordsMapper taskRecordsMapper;
    @Autowired
    private Miss_control_task_detailMapper taskDetailMapper;
    @Autowired
    private MissControlReferenceService missControlReferenceService;

    @Autowired
    private MissControlApprovalService missControlApprovalService;

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(AbstractOperateService.class);


    @Override
    @Transactional
    public String doOperate(OperateDTO operateDTO) {
        logger.info("接受到请求参数={}", JSON.toJSONString(operateDTO));
        F objectF = (F) JSON.toJavaObject(getParmJsonObject(operateDTO.getJsonStr()), getCurrentObjectClass());
        T object = converseObject(objectF);
        BaseService<T> baseService = baseService(operateDTO.getTaskMenuType());
        TrialStatusEnum trialStatusEnum = TrialStatusEnum.getTrialStatusEnum(operateDTO.getTaskStatus());
        Assert.assertNotNull("任务状态异常，不能为:" + operateDTO.getTaskStatus() + "，请确认", trialStatusEnum);
        doOperate(operateDTO, object, baseService, trialStatusEnum);
        return null;
    }


    @Override
    public String doBatchOperate(Miss_control_task_records miss_control_task_records, String operateCode, String approveMessage) {
        OperateDTO operateDTO = new OperateDTO();
        operateDTO.setTaskTitle(miss_control_task_records.getTasktitle());
        operateDTO.setTaskId(miss_control_task_records.getTaskId());
        operateDTO.setTaskType(miss_control_task_records.getTasktype());
        operateDTO.setTaskStatus(miss_control_task_records.getTaskstatus());
        operateDTO.setOperateCode(operateCode);
        operateDTO.setTaskMenuType(miss_control_task_records.getTaskmenutype());
        operateDTO.setTaskChangeComments(approveMessage);
        Miss_control_task_detailWithBLOBs taskLastData = getTaskLastData(operateDTO.getTaskId());
        operateDTO.setJsonStr(JSONObject.parseObject(taskLastData.getTaskchangeafterjson()));
        doOperate(operateDTO);
        return null;
    }

    @Override
    public String doOnline(Miss_control_task_records miss_control_task_records) {
        logger.info("上线taskId={}", miss_control_task_records.getTaskId());
        BaseService<T> baseService = baseService(miss_control_task_records.getTaskmenutype());
        String recordJson = miss_control_task_records.getTaskpublishfinalcontentjson();
        logger.info("上线当前任务信息为 {}", recordJson);
        F objectF = (F) JSON.parseObject(recordJson, getCurrentObjectClass());
        T object = converseObject(objectF);
        object.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        object.setDatastatus("1");
        baseService.updateByTaskIdSelective(object);
        if (needDealMapper()) {
            dealMapperRelashionShip(objectF);
        }
        missControlApprovalService.deleteByTaskId(miss_control_task_records.getTaskId());
        return null;
    }
    
    @Override
    public String doOffline(Miss_control_task_records miss_control_task_records) {
    	logger.info("下线taskId={}", miss_control_task_records.getTaskId());
        BaseService<T> baseService = baseService(miss_control_task_records.getTaskmenutype());
        String recordJson = miss_control_task_records.getTaskpublishfinalcontentjson();
        F objectF = (F) JSON.parseObject(recordJson, getCurrentObjectClass());
        T object = converseObject(objectF);
        object.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        object.setDatastatus("0");
        baseService.updateByTaskIdSelective(object);
        if (needDealMapper()) {
            dealMapperRelashionShip(objectF);
        }
        missControlApprovalService.deleteByTaskId(miss_control_task_records.getTaskId());
        return null;
    }

    public JSONObject getParmJsonObject(JSONObject object) {

        return object.getJSONObject(getJsonParamKey());

    }

    public abstract String getJsonParamKey();


    public void createTaskDetail(OperateDTO operateDTO, TrialStatusEnum trialStatusEnum) {
        Miss_control_task_detailWithBLOBs taskLastData = getTaskLastData(operateDTO.getTaskId());
        Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
        if (null != taskLastData) {
            controlTaskDetail.setTaskstatuschangebefore(taskLastData.getTaskstatuschangeafter());
            controlTaskDetail.setTaskchangebeforejson(taskLastData.getTaskchangeafterjson());
        }
        controlTaskDetail.setTaskId(operateDTO.getTaskId());
        controlTaskDetail.setTaskmenutype(operateDTO.getTaskMenuType());
        controlTaskDetail.setTaskstatuschangeafter(trialStatusEnum.getId());
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
    public boolean isFilter(String taskMenuType) {
        return taskMenuType.equals(getCurrentMenuType());
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
        String taskId = operateDTO.getTaskId();
        if(StringUtil.isEmpty(taskId)){
            taskId = UUID.randomUUID().toString().replace("-", "");
            operateDTO.setTaskId(taskId);
        }
        Miss_control_task_records taskRecordByTaskId = getTaskRecordByTaskId(taskId);
        //如果为空表示新建的task数据需要创建taskRecord
        if (null == taskRecordByTaskId) {
            taskRecordByTaskId = createTaskRecord(operateDTO, taskId, trialStatusEnum);
        }
        JSONObject jsonStr = operateDTO.getJsonStr();
        //判断是否需要创建数据到实际表中
        createObject(operateDTO, object, baseService, taskId, jsonStr, trialStatusEnum.getId());
        T selectByPrimaryId = baseService.selectByPrimaryId(object.getId());
        selectByPrimaryId.setTaskJson(JSON.toJSONString(operateDTO.getJsonStr()));
        selectByPrimaryId.setTaskId(taskId);
        selectByPrimaryId.setDatastatus("0");
        TrialStatusEnum nextTrialStatusEnum1 = getNextStatus(operateDTO.getOperateCode(), trialStatusEnum, taskRecordByTaskId);
        logger.info("taskId={} 当前taskStatus={},操作为 {}, 下一流程为：{}", taskId, trialStatusEnum.getDesc(), operateDTO.getOperateCode(), nextTrialStatusEnum1.getDesc());
        selectByPrimaryId.setTaskStatus(nextTrialStatusEnum1.getId());
        baseService.updateByPrimaryKey(selectByPrimaryId);

        createTaskDetail(operateDTO, nextTrialStatusEnum1);

        //保存参考资料
        List<Miss_control_reference> references = getReferences(operateDTO);
        saveRefrences(references, taskId);
        //保存模块审核结果
        List<Miss_control_approvalWithBLOBs> approves = getApproves(operateDTO);
        saveApproves(approves, taskId, trialStatusEnum);

        //更新taskReconrd 更新其对应数据
        Miss_control_task_records controlTaskRecord = new Miss_control_task_records();
        controlTaskRecord.setTaskId(taskId);
        controlTaskRecord.setTaskstatus(nextTrialStatusEnum1.getId());
        controlTaskRecord.setTasktitle(operateDTO.getTaskTitle());
        if (trialStatusEnum == TrialStatusEnum.FIRST_AUDITEDING) {
            // 添加用户角色权限校验，一审中只能对应相同用户才能操作
            Assert.assertEquals("初审用户与当前用户不一致，无审批权限", taskRecordByTaskId.getTaskfirsttrialcode(), DefaultTokenManager.getLocalUserCode().getUserCode());
            controlTaskRecord.setTaskFirstTrialTime(new Timestamp(System.currentTimeMillis()));
        }
        if (trialStatusEnum == TrialStatusEnum.SECOND_AUDITEDING) {
            Assert.assertEquals("二审用户与当前用户不一致，无审批权限", taskRecordByTaskId.getTasksecondtrialcode(), DefaultTokenManager.getLocalUserCode().getUserCode());
            controlTaskRecord.setTaskSecondTrialTime(new Timestamp(System.currentTimeMillis()));
        }
        if (trialStatusEnum == TrialStatusEnum.FINAL_AUDITEDING) {
            Assert.assertEquals("终审用户与当前用户不一致，无审批权限", taskRecordByTaskId.getTaskfinaltrialcode(), DefaultTokenManager.getLocalUserCode().getUserCode());
            controlTaskRecord.setTaskFinalTrialTime(new Timestamp(System.currentTimeMillis()));
        }
        controlTaskRecord.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        controlTaskRecord.setTaskpublishfinalcontentjson(JSON.toJSONString(getParmJsonObject(operateDTO.getJsonStr())));
        taskRecordsMapper.updateByTaskIdSelective(controlTaskRecord);

    }

    public TrialStatusEnum getNextStatus(String operateCode, TrialStatusEnum trialStatusEnum, Miss_control_task_records controlTaskRecords) {
        //处理 草稿箱 任务
        if (operateCode.equals(OperateEnum.save.toString()) && trialStatusEnum == TrialStatusEnum.DRAFTS) {
            return TrialStatusEnum.DRAFTS;
        }
        if (operateCode.equals(OperateEnum.approveSuccess.toString()) && trialStatusEnum == TrialStatusEnum.DRAFTS) {
            if (controlTaskRecords.getFirstTrialRoleCode() != null) {
                return TrialStatusEnum.FIRST_AUDITEDING;
            }
            return TrialStatusEnum.TO_FIRST_AUDITED;
        }
        //处理 初审未通过 任务
        if (trialStatusEnum == TrialStatusEnum.FIRST_AUDITED_FAILED && operateCode.equals(OperateEnum.save.toString())) {
            return TrialStatusEnum.DRAFTS;
        }
        if (trialStatusEnum == TrialStatusEnum.FIRST_AUDITED_FAILED && operateCode.equals(OperateEnum.approveSuccess.toString())) {
            if (controlTaskRecords.getFirstTrialRoleCode() != null) {
                return TrialStatusEnum.FIRST_AUDITEDING;
            }
            return TrialStatusEnum.TO_FIRST_AUDITED;
        }

        //处理 一审中 任务
        if (trialStatusEnum == TrialStatusEnum.FIRST_AUDITEDING && operateCode.equals(OperateEnum.approveFail.toString())) {
            return TrialStatusEnum.FIRST_AUDITED_FAILED;
        }
        if (trialStatusEnum == TrialStatusEnum.FIRST_AUDITEDING && operateCode.equals(OperateEnum.approveSuccess.toString())) {
            if (controlTaskRecords.getSecondTrialRoleCode() != null) {
                return TrialStatusEnum.SECOND_AUDITEDING;
            }
            return TrialStatusEnum.TO_SECOND_AUDITED;
        }

        //处理 二审未通过 任务
        if (trialStatusEnum == TrialStatusEnum.SECOND_AUDITED_FAILED && operateCode.equals(OperateEnum.approveFail.toString())) {
            return TrialStatusEnum.FIRST_AUDITED_FAILED;
        }
        if (trialStatusEnum == TrialStatusEnum.SECOND_AUDITED_FAILED && operateCode.equals(OperateEnum.approveSuccess.toString())) {
            if (controlTaskRecords.getSecondTrialRoleCode() != null) {
                return TrialStatusEnum.SECOND_AUDITEDING;
            }
            return TrialStatusEnum.TO_SECOND_AUDITED;
        }

        //处理 二审中 任务
        if (trialStatusEnum == TrialStatusEnum.SECOND_AUDITEDING && operateCode.equals(OperateEnum.approveFail.toString())) {
            return TrialStatusEnum.SECOND_AUDITED_FAILED;
        }
        if (trialStatusEnum == TrialStatusEnum.SECOND_AUDITEDING && operateCode.equals(OperateEnum.approveSuccess.toString())) {
            if (controlTaskRecords.getFinalTrialRoleCode() != null) {
                return TrialStatusEnum.FINAL_AUDITEDING;
            }
            return TrialStatusEnum.TO_FINAL_AUDITED;
        }

        //处理 终审未通过 任务
        if (trialStatusEnum == TrialStatusEnum.FINAL_AUDITED_FAILED && operateCode.equals(OperateEnum.approveFail.toString())) {
            return TrialStatusEnum.SECOND_AUDITED_FAILED;
        }
        if (trialStatusEnum == TrialStatusEnum.FINAL_AUDITED_FAILED && operateCode.equals(OperateEnum.approveSuccess.toString())) {
            if (controlTaskRecords.getSecondTrialRoleCode() != null) {
                return TrialStatusEnum.FINAL_AUDITEDING;
            }
            return TrialStatusEnum.TO_FINAL_AUDITED;
        }

        //处理 终审中 任务
        if (trialStatusEnum == TrialStatusEnum.FINAL_AUDITEDING && operateCode.equals(OperateEnum.approveFail.toString())) {
            return TrialStatusEnum.FINAL_AUDITED_FAILED;
        }
        if (trialStatusEnum == TrialStatusEnum.FINAL_AUDITEDING && operateCode.equals(OperateEnum.approveSuccess.toString())) {
            return TrialStatusEnum.FINAL_AUDITED_SUCCESS;
        }

        if(operateCode.equals(OperateEnum.save.toString())){
            return trialStatusEnum;
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
        if (CollectionUtil.isNotEmpty(taskDetailsByTime)) {
            return taskDetailsByTime.get(0);
        }
        return null;
    }

    private Miss_control_task_records getTaskRecordByTaskId(String taskId) {
        return taskRecordsMapper.selectByPrimaryKey(taskId);
    }


    public abstract BaseService<T> baseService(String menuType);

    protected void dealMapperRelashionShip(F objectF) {

    }

    public List<Miss_control_reference> getReferences(OperateDTO operateDTO) {
        List<Miss_control_reference> result = new ArrayList<>();
        JSONObject o = operateDTO.getJsonStr().getJSONObject("refrences");
        if(null == o){
            return result;
        }
        RefrenceDTO refrenceDTO = JSONObject.parseObject(o.toString(), RefrenceDTO.class);
        if(null != refrenceDTO.getImage()){
            for (MissReferenceDTO missReferenceDTO : refrenceDTO.getImage()) {
                createReference(operateDTO, result, missReferenceDTO, "image");
            }
        }
        if(null != refrenceDTO.getTextcontent()){
            for (MissReferenceDTO missReferenceDTO : refrenceDTO.getTextcontent()) {
                    Miss_control_reference miss_control_reference = new Miss_control_reference();
                    BeanUtils.copyProperties(missReferenceDTO, miss_control_reference);
                    miss_control_reference.setReferenceType("text");
                    miss_control_reference.setReferColumnschinese(null == missReferenceDTO.getReferColumnschineses() ? null : missReferenceDTO.getReferColumnschineses().toString());
                    miss_control_reference.setReferColumnscode(null == missReferenceDTO.getReferColumnscodes() ? null : missReferenceDTO.getReferColumnscodes().toString());
                    miss_control_reference.setTaskId(operateDTO.getTaskId());
                    result.add(miss_control_reference);
                createReference(operateDTO, result, missReferenceDTO, "text");
            }
        }
        return result;
    }

    private void createReference(OperateDTO operateDTO, List<Miss_control_reference> result, MissReferenceDTO missReferenceDTO, String type) {
        Miss_control_reference miss_control_reference = new Miss_control_reference();
        BeanUtils.copyProperties(missReferenceDTO, miss_control_reference);
        miss_control_reference.setReferenceType(type);
        miss_control_reference.setReferColumnschinese(null == missReferenceDTO.getReferColumnschineses() ? null : missReferenceDTO.getReferColumnschineses().toString());
        miss_control_reference.setReferColumnscode(null == missReferenceDTO.getReferColumnscodes() ? null : missReferenceDTO.getReferColumnscodes().toString());
        miss_control_reference.setTaskId(operateDTO.getTaskId());
        result.add(miss_control_reference);
    }

    private void saveRefrences(List<Miss_control_reference> missControlReferences, String taskId) {
        if (CollectionUtil.isNotEmpty(missControlReferences)) {
            missControlReferenceService.deleteByTaskId(taskId);
            int i = 1;
            for (Miss_control_reference missControlReference : missControlReferences) {
                missControlReference.setSequenc(i++);
                missControlReferenceService.insert(missControlReference);
            }
        }
    }

    public List<Miss_control_approvalWithBLOBs> getApproves(OperateDTO operateDTO) {
        List<Miss_control_approvalWithBLOBs> result = new ArrayList<>();
        JSONArray approves = operateDTO.getJsonStr().getJSONArray("approves");
        logger.info("taskId={}, 模块评审结果={}", operateDTO.getTaskId(), null == approves ? null : approves.toString());
        if (null != approves && approves.size() > 0) {
            for (Object approve : approves) {
                Miss_control_approvalWithBLOBs controlApprovalWithBLOBs = JSONObject.parseObject(approve.toString(), Miss_control_approvalWithBLOBs.class);
                result.add(controlApprovalWithBLOBs);
            }
        }
        return result;
    }

    public void saveApproves(List<Miss_control_approvalWithBLOBs> missControlReferences, String taskId, TrialStatusEnum trialStatusEnum) {

        if (CollectionUtil.isNotEmpty(missControlReferences)) {
            for (Miss_control_approvalWithBLOBs missControlReference : missControlReferences) {
                if (trialStatusEnum == TrialStatusEnum.FIRST_AUDITEDING) {
                    missControlReference.setFirstTrailSuggestTime(new Date());
                } else if (trialStatusEnum == TrialStatusEnum.SECOND_AUDITEDING) {
                    missControlReference.setSecondTrailSuggestTime(new Date());
                } else if (trialStatusEnum == TrialStatusEnum.FINAL_AUDITEDING) {
                    missControlReference.setFinalTrailSuggestTime(new Date());
                }
                if (missControlApprovalService.updateByTaskIdAndModel(missControlReference) <= 0) {
                    missControlApprovalService.insert(missControlReference);
                }
            }
        }

    }

    public abstract Class<?> getCurrentObjectClass();

    public T converseObject(F f) {
        return (T) f;
    }

    @Override
    public String accounts(Miss_control_task_records miss_control_task_records, String accounts) {
        miss_control_task_records.setTaskStatus(accounts);
    	taskRecordsMapper.updateByPrimaryKey(miss_control_task_records);
        Miss_control_task_detailWithBLOBs taskLastData = getTaskLastData(miss_control_task_records.getTaskId());
        BaseService<T> baseService = baseService(miss_control_task_records.getTaskmenutype());
        String recordJson = miss_control_task_records.getTaskpublishfinalcontentjson();
        F objectF = (F) JSON.parseObject(taskLastData.getTaskchangeafterjson(), getCurrentObjectClass());
        T object = converseObject(objectF);
        object.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        object.setDatastatus(accounts);
        baseService.updateByTaskIdSelective(object);
        return null;
    }

    @Override
    public void resetStatus(Miss_control_task_records controlTaskRecords, String resetStatus) {
        controlTaskRecords.setTaskStatus(resetStatus);
        taskRecordsMapper.updateByPrimaryKey(controlTaskRecords);
        Miss_control_task_detailWithBLOBs taskLastData = getTaskLastData(controlTaskRecords.getTaskId());
        BaseService<T> baseService = baseService(controlTaskRecords.getTaskmenutype());
        F objectF = (F) JSON.parseObject(taskLastData.getTaskchangeafterjson(), getCurrentObjectClass());
        T object = converseObject(objectF);
        object.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        object.setDatastatus(resetStatus);
        baseService.updateByTaskIdSelective(object);
        Miss_control_task_detailWithBLOBs controlTaskDetail = new Miss_control_task_detailWithBLOBs();
        if (null != taskLastData) {
            controlTaskDetail.setTaskstatuschangebefore(taskLastData.getTaskstatuschangeafter());
            controlTaskDetail.setTaskchangebeforejson(taskLastData.getTaskchangeafterjson());
        }
        controlTaskDetail.setTaskId(controlTaskRecords.getTaskId());
        controlTaskDetail.setTaskmenutype(controlTaskRecords.getTaskmenutype());
        controlTaskDetail.setTaskstatuschangeafter(resetStatus);
        controlTaskDetail.setTaskchangeusercode(DefaultTokenManager.getLocalUserCode().getUserCode());
        controlTaskDetail.setTaskuuid(UuidUtils.generateUUID());
        controlTaskDetail.setTaskchangetime(new Timestamp(System.currentTimeMillis()));
        controlTaskDetail.setTaskchangeday(getToday());
        controlTaskDetail.setTaskchangeafterjson(taskLastData.getTaskchangeafterjson());
        taskDetailMapper.insert(controlTaskDetail);
    }
}
