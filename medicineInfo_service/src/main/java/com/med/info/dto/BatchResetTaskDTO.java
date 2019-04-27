package com.med.info.dto;

import java.util.List;

public class BatchResetTaskDTO {

    private List<String> tasks;
    private String resetStatus;
    private Boolean resetFirstAuditedUser;
    private Boolean resetSecondAuditedUser;
    private Boolean resetFinalAuditedUser;
    private String userCode;

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public String getResetStatus() {
        return resetStatus;
    }

    public void setResetStatus(String resetStatus) {
        this.resetStatus = resetStatus;
    }

    public Boolean getResetFirstAuditedUser() {
        return resetFirstAuditedUser;
    }

    public void setResetFirstAuditedUser(Boolean resetFirstAuditedUser) {
        this.resetFirstAuditedUser = resetFirstAuditedUser;
    }

    public Boolean getResetSecondAuditedUser() {
        return resetSecondAuditedUser;
    }

    public void setResetSecondAuditedUser(Boolean resetSecondAuditedUser) {
        this.resetSecondAuditedUser = resetSecondAuditedUser;
    }

    public Boolean getResetFinalAuditedUser() {
        return resetFinalAuditedUser;
    }

    public void setResetFinalAuditedUser(Boolean resetFinalAuditedUser) {
        this.resetFinalAuditedUser = resetFinalAuditedUser;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
