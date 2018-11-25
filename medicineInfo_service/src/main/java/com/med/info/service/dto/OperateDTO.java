package com.med.info.service.dto;

import java.io.Serializable;

public class OperateDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String taskTitle;
	private String taskType;
	private String taskStatus;
	private String taskMenuType;
	private String jsonStr;
	
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
	public String getJsonStr() {
		return jsonStr;
	}
	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
}
