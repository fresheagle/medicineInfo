package com.med.info.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 认领任务请求
 */
public class ClaimTaskDTO implements Serializable {

    /**
     * 认领状态 1：认领 ;0.取消认领
     */
    private Integer status;
    /**
     * 任务ID
     */
    private List<String> taskIds;
    /**
     * 当前任务状态 （用于判断应该设置当前用户到那个字段）
     */
    private String taskStatus;

    public Integer getStatus() {
        return status;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }
}
