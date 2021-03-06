package com.med.info.dto;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_control_task_detail;

public class ControlTaskDetail extends Miss_control_task_detail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_control_task_detail.taskChangeComments
    *
    * @mbg.generated Sat Nov 24 19:57:07 CST 2018
    */
   private String taskchangecomments;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_control_task_detail.taskChangeBeforeJson
    *
    * @mbg.generated Sat Nov 24 19:57:07 CST 2018
    */
   private JSONObject taskchangebeforejson;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_control_task_detail.taskChangeAfterJson
    *
    * @mbg.generated Sat Nov 24 19:57:07 CST 2018
    */
   private JSONObject taskchangeafterjson;

public String getTaskchangecomments() {
	return taskchangecomments;
}

public void setTaskchangecomments(String taskchangecomments) {
	this.taskchangecomments = taskchangecomments;
}

public JSONObject getTaskchangebeforejson() {
	return taskchangebeforejson;
}

public void setTaskchangebeforejson(JSONObject taskchangebeforejson) {
	this.taskchangebeforejson = taskchangebeforejson;
}

public JSONObject getTaskchangeafterjson() {
	return taskchangeafterjson;
}

public void setTaskchangeafterjson(JSONObject taskchangeafterjson) {
	this.taskchangeafterjson = taskchangeafterjson;
}
   
   
	
}
