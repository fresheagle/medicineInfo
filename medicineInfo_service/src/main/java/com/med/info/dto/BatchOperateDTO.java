package com.med.info.dto;

import com.med.info.utils.TrialStatusEnum;

import java.io.Serializable;
import java.util.List;

public class BatchOperateDTO implements Serializable {

    private List<String> tasks;
    /**
     *传递需要修改的对应状态：
     * @see TrialStatusEnum
     */

    private String trailStatus;

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public String getTrailStatus() {
        return trailStatus;
    }

    public void setTrailStatus(String trailStatus) {
        this.trailStatus = trailStatus;
    }
}
