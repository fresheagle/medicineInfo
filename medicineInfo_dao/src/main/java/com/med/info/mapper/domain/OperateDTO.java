package com.med.info.mapper.domain;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.med.info.utils.OperateEnum;
import com.med.info.utils.TrialStatusEnum;

import junit.framework.Assert;

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
	private JSONObject jsonStr;
	
	public void verify() {
		Assert.assertNotNull("任务类型需要填写", this.taskType);
		Assert.assertNotNull("任务操作数据需要填写", this.taskMenuType);
		Assert.assertNotNull("任务状态需要填写", this.taskStatus);
		Assert.assertNotNull("任务标题需要填写", this.taskTitle);
		Assert.assertNotNull("任务操作对应值不能为空", this.jsonStr);
		boolean flag = false;
		TrialStatusEnum[] values = TrialStatusEnum.values();
		for (TrialStatusEnum trialStatusEnum : values) {
			if(this.taskStatus.equals(trialStatusEnum.getId())) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue("任务状态与已有状态不一致", flag);
		flag = false;
		OperateEnum[] values2 = OperateEnum.values();
		for (OperateEnum operateEnum : values2) {
			if(this.taskType.equals(operateEnum.toString())) {
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
}
