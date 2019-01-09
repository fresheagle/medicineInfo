package com.med.info.dto;

import java.util.Date;
import java.util.List;

public class SelectTaskDTO {
    private Integer currentPage;
    private Integer pageSize;
    private String taskTitle;
    private String taskType;
    private Integer poolId;
    private List<String> taskStatus;
    private String taskMenuType;
    private List<String> createUser;
    private List<String> firstTrialUser;
    private List<String> secondTrialUser;
    private List<String> finalTrialUser;

    private List<String> createUserCode;
    private List<String> firstTrialUserCode;
    private List<String> secondTrialUserCode;
    private List<String> finalTrialUserCode;
    private List<Date> taskCreateTime;
    private List<Date> taskFirstTrialTime;
    private List<Date> taskSecondTrialTime;
    private List<Date> taskFinalTrialTime;
    private List<Date> updateTime;

    public List<Date> getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(List<Date> updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    public List<String> getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(List<String> taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskMenuType() {
        return taskMenuType;
    }

    public void setTaskMenuType(String taskMenuType) {
        this.taskMenuType = taskMenuType;
    }

    public List<String> getCreateUser() {
        return createUser;
    }

    public void setCreateUser(List<String> createUser) {
        this.createUser = createUser;
    }

    public List<String> getFirstTrialUser() {
        return firstTrialUser;
    }

    public void setFirstTrialUser(List<String> firstTrialUser) {
        this.firstTrialUser = firstTrialUser;
    }

    public List<String> getSecondTrialUser() {
        return secondTrialUser;
    }

    public void setSecondTrialUser(List<String> secondTrialUser) {
        this.secondTrialUser = secondTrialUser;
    }

    public List<String> getFinalTrialUser() {
        return finalTrialUser;
    }

    public void setFinalTrialUser(List<String> finalTrialUser) {
        this.finalTrialUser = finalTrialUser;
    }

    public List<Date> getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(List<Date> taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public List<Date> getTaskFirstTrialTime() {
        return taskFirstTrialTime;
    }

    public void setTaskFirstTrialTime(List<Date> taskFirstTrialTime) {
        this.taskFirstTrialTime = taskFirstTrialTime;
    }

    public List<Date> getTaskSecondTrialTime() {
        return taskSecondTrialTime;
    }

    public void setTaskSecondTrialTime(List<Date> taskSecondTrialTime) {
        this.taskSecondTrialTime = taskSecondTrialTime;
    }

    public List<Date> getTaskFinalTrialTime() {
        return taskFinalTrialTime;
    }

    public void setTaskFinalTrialTime(List<Date> taskFinalTrialTime) {
        this.taskFinalTrialTime = taskFinalTrialTime;
    }

    public List<String> getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(List<String> createUserCode) {
        this.createUserCode = createUserCode;
    }

    public List<String> getFirstTrialUserCode() {
        return firstTrialUserCode;
    }

    public void setFirstTrialUserCode(List<String> firstTrialUserCode) {
        this.firstTrialUserCode = firstTrialUserCode;
    }

    public List<String> getSecondTrialUserCode() {
        return secondTrialUserCode;
    }

    public void setSecondTrialUserCode(List<String> secondTrialUserCode) {
        this.secondTrialUserCode = secondTrialUserCode;
    }

    public List<String> getFinalTrialUserCode() {
        return finalTrialUserCode;
    }

    public void setFinalTrialUserCode(List<String> finalTrialUserCode) {
        this.finalTrialUserCode = finalTrialUserCode;
    }

    public Integer getPoolId() {
        return poolId;
    }

    public void setPoolId(Integer poolId) {
        this.poolId = poolId;
    }
}
