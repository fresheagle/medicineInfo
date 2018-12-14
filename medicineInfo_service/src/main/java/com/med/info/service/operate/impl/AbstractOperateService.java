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
import com.med.info.utils.OperateEnum;
import com.med.info.utils.StringUtil;
import com.med.info.utils.TrialStatusEnum;
import com.med.info.utils.UuidUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        if (operateDTO.getTaskStatus().equals(TrialStatusEnum.DRAFTS.getId())) {
            creatingOperate(operateDTO, object, baseService);
        } else if (operateDTO.getTaskStatus().equals(TrialStatusEnum.TO_FIRST_AUDITED.getId())) {
            firstTrialOperate(operateDTO, object, baseService);
        } else if (operateDTO.getTaskStatus().equals(TrialStatusEnum.TO_SECOND_AUDITED.getId())
                || operateDTO.getTaskStatus().equals(TrialStatusEnum.TO_FINAL_AUDITED.getId())) {
            updateStatus(operateDTO, object, baseService);
        } else if (operateDTO.getTaskStatus().equals(TrialStatusEnum.FINISHED.getId())) {
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
            taskRecordsMapper.updateByTaskIdSelective(controlTaskRecord);
            finishDeal(operateDTO, object, baseService);
        }
        return null;
    }

    public JSONObject getParmJsonObject(JSONObject object) {

        return object.getJSONObject(getJsonParamKey());

    }

    public abstract String getJsonParamKey();

    /**
     * @param operateDTO
     * @author jialin.jiang
     * Function: 终审发布处理 <br/>
     */
    public void finishDeal(OperateDTO operateDTO, T object, BaseService<T> baseService) {

        if (!operateDTO.getTaskType().equals(OperateEnum.delete.toString())) {
            logger.info(getCurrentMenuType() + "当前操作为" + operateDTO.getTaskType() + ",修改数据入库");
            baseService.updateByPrimaryKey(object);
        } else {
            logger.info(getCurrentMenuType() + "当前操作为" + operateDTO.getTaskType() + ",修改状态为回收站");
            object.setTaskId(operateDTO.getTaskId());
            object.setTaskJson(JSON.toJSONString(operateDTO.getJsonStr()));
            object.setTaskStatus(operateDTO.getTaskStatus());
            object.setDatastatus("-1");
            baseService.updateByTaskIdSelective(object);
        }

        if (needDealMapper()) {
            dealMapperRelashionShip(operateDTO);
        }

    }

    protected void dealMapperRelashionShip(OperateDTO operateDTO){}


    public abstract boolean needDealMapper();

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
        taskRecordsMapper.updateByTaskIdSelective(record);
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
        if (StringUtil.isEmpty(operateDTO.getTaskId())) {
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
        if (StringUtil.isEmpty(operateDTO.getTaskId())) {
            String taskId = UuidUtils.generateUUID();
            JSONObject jsonStr = operateDTO.getJsonStr();
            //如果是创建，就先插入数据，获取数据ID,并放入json中，方便后续处理
            if (operateDTO.getTaskType().equals(OperateEnum.create.toString())) {
                object.setTaskJson(JSON.toJSONString(jsonStr));
                object.setTaskId(taskId);
                object.setTaskStatus(TrialStatusEnum.DRAFTS.getId());
                int insertId = baseService.insert(object);
                jsonStr.put("id", insertId);
                object.setId(Long.valueOf(insertId));
            }
            T selectByPrimaryId = baseService.selectByPrimaryId(object.getId());
            selectByPrimaryId.setTaskJson(JSON.toJSONString(jsonStr));
            selectByPrimaryId.setTaskId(taskId);
            selectByPrimaryId.setTaskStatus(TrialStatusEnum.DRAFTS.getId());
            baseService.updateByPrimaryKey(selectByPrimaryId);


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
            controlTaskDetail.setTaskchangeafterjson(JSON.toJSONString(jsonStr));
            taskDetailMapper.insert(controlTaskDetail);
        } else {
            updateStatus(operateDTO, object, baseService);
        }
    }


    private Miss_control_task_detailWithBLOBs getTaskLastData(String taskId) {

        List<Miss_control_task_detailWithBLOBs> taskDetailsByTime = taskDetailMapper.getTaskDetailsByTime(taskId);
        return taskDetailsByTime.get(0);
    }

    public abstract BaseService<T> baseService(String menuType);

    public abstract Class<?> getCurrentClass();

}
