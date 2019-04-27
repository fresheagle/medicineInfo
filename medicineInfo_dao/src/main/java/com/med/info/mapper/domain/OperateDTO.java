package com.med.info.mapper.domain;

import com.alibaba.fastjson.JSONObject;
import com.med.info.utils.TaskType;
import com.med.info.utils.TrialStatusEnum;
import junit.framework.Assert;

import java.io.Serializable;
import java.util.Date;

public class OperateDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String taskTitle;
    private String taskId;
    private String taskType;
    private String taskStatus;
    private String operateCode;
    private String taskMenuType;
    private String taskChangeVote;
    private String taskChangePoints;
    private String taskChangeComments;
    private String taskFirstTrialPoint;
    private String taskSecondTrialPoint;
    private String taskFinalTrialPint;
    private UserInfoDTO createUser;
    private UserRoleDTO createUserRole;
    private UserInfoDTO firstTrialUser;
    private UserInfoDTO secondTrialUser;
    private UserInfoDTO finalTrialUser;
    private Date taskCreateTime;
    private Date taskFirstTrialTime;
    private Date taskSecondTrialTime;
    private Date taskFinalTrialTime;
    private Date updateTime;
    private Integer detailCount;
    private String pageNo;
    private String contentNo;
    private String accounts;
    private JSONObject jsonStr;


    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public Integer getDetailCount() {
        return detailCount;
    }

    public void setDetailCount(Integer detailCount) {
        this.detailCount = detailCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void verify() {
        Assert.assertNotNull("任务类型需要填写", this.taskType);
        Assert.assertNotNull("任务操作数据需要填写", this.taskMenuType);
        Assert.assertNotNull("任务状态需要填写", this.taskStatus);
        Assert.assertNotNull("任务标题需要填写", this.taskTitle);
        Assert.assertNotNull("任务惟一ID需要填写", this.taskId);
        Assert.assertNotNull("任务操作结果需要填写", this.operateCode);
        Assert.assertNotNull("任务操作对应值不能为空", this.jsonStr);
        boolean flag = false;
        TrialStatusEnum[] values = TrialStatusEnum.values();
        for (TrialStatusEnum trialStatusEnum : values) {
            if (this.taskStatus.equals(trialStatusEnum.getId())) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue("任务状态与已有状态不一致", flag);
        flag = false;
        TaskType[] values2 = TaskType.values();
        for (TaskType operateEnum : values2) {
            if (this.taskType.equals(operateEnum.toString())) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue("任务操作码与实际不一致", flag);
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getContentNo() {
        return contentNo;
    }

    public Date getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(Date taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public String getTaskFirstTrialPoint() {
        return taskFirstTrialPoint;
    }

    public void setTaskFirstTrialPoint(String taskFirstTrialPoint) {
        this.taskFirstTrialPoint = taskFirstTrialPoint;
    }

    public String getTaskSecondTrialPoint() {
        return taskSecondTrialPoint;
    }

    public void setTaskSecondTrialPoint(String taskSecondTrialPoint) {
        this.taskSecondTrialPoint = taskSecondTrialPoint;
    }

    public String getTaskFinalTrialPint() {
        return taskFinalTrialPint;
    }

    public void setTaskFinalTrialPint(String taskFinalTrialPint) {
        this.taskFinalTrialPint = taskFinalTrialPint;
    }

    public Date getTaskFirstTrialTime() {
        return taskFirstTrialTime;
    }

    public void setTaskFirstTrialTime(Date taskFirstTrialTime) {
        this.taskFirstTrialTime = taskFirstTrialTime;
    }

    public Date getTaskSecondTrialTime() {
        return taskSecondTrialTime;
    }

    public void setTaskSecondTrialTime(Date taskSecondTrialTime) {
        this.taskSecondTrialTime = taskSecondTrialTime;
    }

    public Date getTaskFinalTrialTime() {
        return taskFinalTrialTime;
    }

    public void setTaskFinalTrialTime(Date taskFinalTrialTime) {
        this.taskFinalTrialTime = taskFinalTrialTime;
    }

    public void setContentNo(String contentNo) {
        this.contentNo = contentNo;
    }

    public String getTaskChangeVote() {
        return taskChangeVote;
    }

    public void setTaskChangeVote(String taskChangeVote) {
        this.taskChangeVote = taskChangeVote;
    }

    public String getTaskChangePoints() {
        return taskChangePoints;
    }

    public void setTaskChangePoints(String taskChangePoints) {
        this.taskChangePoints = taskChangePoints;
    }

    public String getTaskChangeComments() {
        return taskChangeComments;
    }

    public void setTaskChangeComments(String taskChangeComments) {
        this.taskChangeComments = taskChangeComments;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskMenuType() {
        return taskMenuType;
    }

    public void setTaskMenuType(String taskMenuType) {
        this.taskMenuType = taskMenuType;
    }

    public JSONObject getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(JSONObject jsonStr) {
        this.jsonStr = jsonStr;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public UserInfoDTO getCreateUser() {
        return createUser;
    }

    public void setCreateUser(UserInfoDTO createUser) {
        this.createUser = createUser;
    }

    public UserRoleDTO getCreateUserRole() {
        return createUserRole;
    }

    public void setCreateUserRole(UserRoleDTO createUserRole) {
        this.createUserRole = createUserRole;
    }

    public UserInfoDTO getFirstTrialUser() {
        return firstTrialUser;
    }

    public void setFirstTrialUser(UserInfoDTO firstTrialUser) {
        this.firstTrialUser = firstTrialUser;
    }

    public UserInfoDTO getSecondTrialUser() {
        return secondTrialUser;
    }

    public void setSecondTrialUser(UserInfoDTO secondTrialUser) {
        this.secondTrialUser = secondTrialUser;
    }

    public UserInfoDTO getFinalTrialUser() {
        return finalTrialUser;
    }

    public void setFinalTrialUser(UserInfoDTO finalTrialUser) {
        this.finalTrialUser = finalTrialUser;
    }

    public String getOperateCode() {
        return operateCode;
    }

    public void setOperateCode(String operateCode) {
        this.operateCode = operateCode;
    }
}
