package com.med.info.service.dto;

import java.io.Serializable;

public class OperateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String taskTitle;
	private String taskType;
	private String taskStatus;
	private String taskMenuType;
	private String taskChangeVote;
	private String taskChangePoints;
	private String taskChangeComments;
	private String pageNo;
	private String contentNo;
	private String jsonStr;

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getContentNo() {
		return contentNo;
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
