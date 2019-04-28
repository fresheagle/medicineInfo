package com.med.info.dto;

import java.util.List;

public class BatchResetTaskDTO {

    private List<String> tasks;
    private String resetStatus;
    private List<String> trialUser;
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
    public List<String> getTrialUser() {
        return trialUser;
    }

    public void setTrialUser(List<String> trialUser) {
        this.trialUser = trialUser;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
