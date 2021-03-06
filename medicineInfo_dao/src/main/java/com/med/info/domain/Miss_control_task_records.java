package com.med.info.domain;

import java.util.Date;

public class Miss_control_task_records extends BaseDomain{
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.task_id
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskCreaterUserCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String taskcreaterusercode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskTitle
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String tasktitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskType
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String tasktype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskStatus
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String taskstatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskMenuType
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String taskmenutype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskCreateDay
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String taskcreateday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskCreateTime
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private Date taskcreatetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskPublishUserCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String taskpublishusercode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskPublishDay
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String taskpublishday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskPublishTime
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private Date taskpublishtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskFirstTrialCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String taskfirsttrialcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskSecondTrialCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String tasksecondtrialcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskFinalTrialCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String taskfinaltrialcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_records.taskPublishFinalContentJson
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    private String taskpublishfinalcontentjson;

    
    private String taskFirstTrialPoint;
    private String taskSecondTrialPoint;
    private String taskFinalTrialPint;
    private String firstTrialRoleCode;
    private String secondTrialRoleCode;
    private String finalTrialRoleCode;
    private String taskCreateRoleCode;
    private Date taskFirstTrialTime;
    private Date taskSecondTrialTime;
    private Date taskFinalTrialTime;
    private Date updateTime;

    private String accounts;
    
    private String dataStatus;
    
    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

	public String getFirstTrialRoleCode() {
		return firstTrialRoleCode;
	}

	public void setFirstTrialRoleCode(String firstTrialRoleCode) {
		this.firstTrialRoleCode = firstTrialRoleCode;
	}

	public String getSecondTrialRoleCode() {
		return secondTrialRoleCode;
	}

	public void setSecondTrialRoleCode(String secondTrialRoleCode) {
		this.secondTrialRoleCode = secondTrialRoleCode;
	}

	public String getFinalTrialRoleCode() {
		return finalTrialRoleCode;
	}

	public void setFinalTrialRoleCode(String finalTrialRoleCode) {
		this.finalTrialRoleCode = finalTrialRoleCode;
	}

    public String getTaskCreateRoleCode() {
        return taskCreateRoleCode;
    }

    public void setTaskCreateRoleCode(String taskCreateRoleCode) {
        this.taskCreateRoleCode = taskCreateRoleCode;
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

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.task_id
     *
     * @return the value of miss_control_task_records.task_id
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.task_id
     *
     * @param taskId the value for miss_control_task_records.task_id
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskCreaterUserCode
     *
     * @return the value of miss_control_task_records.taskCreaterUserCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTaskcreaterusercode() {
        return taskcreaterusercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskCreaterUserCode
     *
     * @param taskcreaterusercode the value for miss_control_task_records.taskCreaterUserCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskcreaterusercode(String taskcreaterusercode) {
        this.taskcreaterusercode = taskcreaterusercode == null ? null : taskcreaterusercode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskTitle
     *
     * @return the value of miss_control_task_records.taskTitle
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTasktitle() {
        return tasktitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskTitle
     *
     * @param tasktitle the value for miss_control_task_records.taskTitle
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle == null ? null : tasktitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskType
     *
     * @return the value of miss_control_task_records.taskType
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTasktype() {
        return tasktype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskType
     *
     * @param tasktype the value for miss_control_task_records.taskType
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTasktype(String tasktype) {
        this.tasktype = tasktype == null ? null : tasktype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskStatus
     *
     * @return the value of miss_control_task_records.taskStatus
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTaskstatus() {
        return taskstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskStatus
     *
     * @param taskstatus the value for miss_control_task_records.taskStatus
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus == null ? null : taskstatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskMenuType
     *
     * @return the value of miss_control_task_records.taskMenuType
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTaskmenutype() {
        return taskmenutype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskMenuType
     *
     * @param taskmenutype the value for miss_control_task_records.taskMenuType
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskmenutype(String taskmenutype) {
        this.taskmenutype = taskmenutype == null ? null : taskmenutype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskCreateDay
     *
     * @return the value of miss_control_task_records.taskCreateDay
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTaskcreateday() {
        return taskcreateday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskCreateDay
     *
     * @param taskcreateday the value for miss_control_task_records.taskCreateDay
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskcreateday(String taskcreateday) {
        this.taskcreateday = taskcreateday == null ? null : taskcreateday.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskCreateTime
     *
     * @return the value of miss_control_task_records.taskCreateTime
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public Date getTaskcreatetime() {
        return taskcreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskCreateTime
     *
     * @param taskcreatetime the value for miss_control_task_records.taskCreateTime
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskcreatetime(Date taskcreatetime) {
        this.taskcreatetime = taskcreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskPublishUserCode
     *
     * @return the value of miss_control_task_records.taskPublishUserCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTaskpublishusercode() {
        return taskpublishusercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskPublishUserCode
     *
     * @param taskpublishusercode the value for miss_control_task_records.taskPublishUserCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskpublishusercode(String taskpublishusercode) {
        this.taskpublishusercode = taskpublishusercode == null ? null : taskpublishusercode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskPublishDay
     *
     * @return the value of miss_control_task_records.taskPublishDay
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTaskpublishday() {
        return taskpublishday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskPublishDay
     *
     * @param taskpublishday the value for miss_control_task_records.taskPublishDay
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskpublishday(String taskpublishday) {
        this.taskpublishday = taskpublishday == null ? null : taskpublishday.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskPublishTime
     *
     * @return the value of miss_control_task_records.taskPublishTime
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public Date getTaskpublishtime() {
        return taskpublishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskPublishTime
     *
     * @param taskpublishtime the value for miss_control_task_records.taskPublishTime
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskpublishtime(Date taskpublishtime) {
        this.taskpublishtime = taskpublishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskFirstTrialCode
     *
     * @return the value of miss_control_task_records.taskFirstTrialCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTaskfirsttrialcode() {
        return taskfirsttrialcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskFirstTrialCode
     *
     * @param taskfirsttrialcode the value for miss_control_task_records.taskFirstTrialCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskfirsttrialcode(String taskfirsttrialcode) {
        this.taskfirsttrialcode = taskfirsttrialcode == null ? null : taskfirsttrialcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskSecondTrialCode
     *
     * @return the value of miss_control_task_records.taskSecondTrialCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTasksecondtrialcode() {
        return tasksecondtrialcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskSecondTrialCode
     *
     * @param tasksecondtrialcode the value for miss_control_task_records.taskSecondTrialCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTasksecondtrialcode(String tasksecondtrialcode) {
        this.tasksecondtrialcode = tasksecondtrialcode == null ? null : tasksecondtrialcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskFinalTrialCode
     *
     * @return the value of miss_control_task_records.taskFinalTrialCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTaskfinaltrialcode() {
        return taskfinaltrialcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskFinalTrialCode
     *
     * @param taskfinaltrialcode the value for miss_control_task_records.taskFinalTrialCode
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskfinaltrialcode(String taskfinaltrialcode) {
        this.taskfinaltrialcode = taskfinaltrialcode == null ? null : taskfinaltrialcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_records.taskPublishFinalContentJson
     *
     * @return the value of miss_control_task_records.taskPublishFinalContentJson
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public String getTaskpublishfinalcontentjson() {
        return taskpublishfinalcontentjson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_records.taskPublishFinalContentJson
     *
     * @param taskpublishfinalcontentjson the value for miss_control_task_records.taskPublishFinalContentJson
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    public void setTaskpublishfinalcontentjson(String taskpublishfinalcontentjson) {
        this.taskpublishfinalcontentjson = taskpublishfinalcontentjson == null ? null : taskpublishfinalcontentjson.trim();
    }

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}
}