package com.med.info.domain;

public class Miss_control_task_detailWithBLOBs extends Miss_control_task_detail {
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
    private String taskchangebeforejson;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_task_detail.taskChangeAfterJson
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private String taskchangeafterjson;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_detail.taskChangeComments
     *
     * @return the value of miss_control_task_detail.taskChangeComments
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public String getTaskchangecomments() {
        return taskchangecomments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_detail.taskChangeComments
     *
     * @param taskchangecomments the value for miss_control_task_detail.taskChangeComments
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setTaskchangecomments(String taskchangecomments) {
        this.taskchangecomments = taskchangecomments == null ? null : taskchangecomments.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_detail.taskChangeBeforeJson
     *
     * @return the value of miss_control_task_detail.taskChangeBeforeJson
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public String getTaskchangebeforejson() {
        return taskchangebeforejson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_detail.taskChangeBeforeJson
     *
     * @param taskchangebeforejson the value for miss_control_task_detail.taskChangeBeforeJson
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setTaskchangebeforejson(String taskchangebeforejson) {
        this.taskchangebeforejson = taskchangebeforejson == null ? null : taskchangebeforejson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_task_detail.taskChangeAfterJson
     *
     * @return the value of miss_control_task_detail.taskChangeAfterJson
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public String getTaskchangeafterjson() {
        return taskchangeafterjson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_task_detail.taskChangeAfterJson
     *
     * @param taskchangeafterjson the value for miss_control_task_detail.taskChangeAfterJson
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setTaskchangeafterjson(String taskchangeafterjson) {
        this.taskchangeafterjson = taskchangeafterjson == null ? null : taskchangeafterjson.trim();
    }
}