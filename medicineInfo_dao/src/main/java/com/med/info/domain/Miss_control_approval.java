package com.med.info.domain;

import java.util.Date;

public class Miss_control_approval {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.id
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.task_id
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private String taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.refer_model
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private String referModel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.refer_model_chinese_name
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private String referModelChineseName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.fisrt_trail_approval_result
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private String fisrtTrailApprovalResult;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.second_trail_approval_result
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private String secondTrailApprovalResult;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.final_trail_approval_result
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private String finalTrailApprovalResult;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.first_approval_point
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private Integer firstApprovalPoint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.second_approval_point
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private Integer secondApprovalPoint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.final_approval_point
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private Integer finalApprovalPoint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.first_trail_suggest_time
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private Date firstTrailSuggestTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.second_trail_suggest_time
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private Date secondTrailSuggestTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_control_approval.final_trail_suggest_time
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    private Date finalTrailSuggestTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.id
     *
     * @return the value of miss_control_approval.id
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.id
     *
     * @param id the value for miss_control_approval.id
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.task_id
     *
     * @return the value of miss_control_approval.task_id
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.task_id
     *
     * @param taskId the value for miss_control_approval.task_id
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.refer_model
     *
     * @return the value of miss_control_approval.refer_model
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public String getReferModel() {
        return referModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.refer_model
     *
     * @param referModel the value for miss_control_approval.refer_model
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setReferModel(String referModel) {
        this.referModel = referModel == null ? null : referModel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.refer_model_chinese_name
     *
     * @return the value of miss_control_approval.refer_model_chinese_name
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public String getReferModelChineseName() {
        return referModelChineseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.refer_model_chinese_name
     *
     * @param referModelChineseName the value for miss_control_approval.refer_model_chinese_name
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setReferModelChineseName(String referModelChineseName) {
        this.referModelChineseName = referModelChineseName == null ? null : referModelChineseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.fisrt_trail_approval_result
     *
     * @return the value of miss_control_approval.fisrt_trail_approval_result
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public String getFisrtTrailApprovalResult() {
        return fisrtTrailApprovalResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.fisrt_trail_approval_result
     *
     * @param fisrtTrailApprovalResult the value for miss_control_approval.fisrt_trail_approval_result
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setFisrtTrailApprovalResult(String fisrtTrailApprovalResult) {
        this.fisrtTrailApprovalResult = fisrtTrailApprovalResult == null ? null : fisrtTrailApprovalResult.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.second_trail_approval_result
     *
     * @return the value of miss_control_approval.second_trail_approval_result
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public String getSecondTrailApprovalResult() {
        return secondTrailApprovalResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.second_trail_approval_result
     *
     * @param secondTrailApprovalResult the value for miss_control_approval.second_trail_approval_result
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setSecondTrailApprovalResult(String secondTrailApprovalResult) {
        this.secondTrailApprovalResult = secondTrailApprovalResult == null ? null : secondTrailApprovalResult.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.final_trail_approval_result
     *
     * @return the value of miss_control_approval.final_trail_approval_result
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public String getFinalTrailApprovalResult() {
        return finalTrailApprovalResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.final_trail_approval_result
     *
     * @param finalTrailApprovalResult the value for miss_control_approval.final_trail_approval_result
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setFinalTrailApprovalResult(String finalTrailApprovalResult) {
        this.finalTrailApprovalResult = finalTrailApprovalResult == null ? null : finalTrailApprovalResult.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.first_approval_point
     *
     * @return the value of miss_control_approval.first_approval_point
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public Integer getFirstApprovalPoint() {
        return firstApprovalPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.first_approval_point
     *
     * @param firstApprovalPoint the value for miss_control_approval.first_approval_point
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setFirstApprovalPoint(Integer firstApprovalPoint) {
        this.firstApprovalPoint = firstApprovalPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.second_approval_point
     *
     * @return the value of miss_control_approval.second_approval_point
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public Integer getSecondApprovalPoint() {
        return secondApprovalPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.second_approval_point
     *
     * @param secondApprovalPoint the value for miss_control_approval.second_approval_point
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setSecondApprovalPoint(Integer secondApprovalPoint) {
        this.secondApprovalPoint = secondApprovalPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.final_approval_point
     *
     * @return the value of miss_control_approval.final_approval_point
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public Integer getFinalApprovalPoint() {
        return finalApprovalPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.final_approval_point
     *
     * @param finalApprovalPoint the value for miss_control_approval.final_approval_point
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setFinalApprovalPoint(Integer finalApprovalPoint) {
        this.finalApprovalPoint = finalApprovalPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.first_trail_suggest_time
     *
     * @return the value of miss_control_approval.first_trail_suggest_time
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public Date getFirstTrailSuggestTime() {
        return firstTrailSuggestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.first_trail_suggest_time
     *
     * @param firstTrailSuggestTime the value for miss_control_approval.first_trail_suggest_time
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setFirstTrailSuggestTime(Date firstTrailSuggestTime) {
        this.firstTrailSuggestTime = firstTrailSuggestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.second_trail_suggest_time
     *
     * @return the value of miss_control_approval.second_trail_suggest_time
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public Date getSecondTrailSuggestTime() {
        return secondTrailSuggestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.second_trail_suggest_time
     *
     * @param secondTrailSuggestTime the value for miss_control_approval.second_trail_suggest_time
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setSecondTrailSuggestTime(Date secondTrailSuggestTime) {
        this.secondTrailSuggestTime = secondTrailSuggestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_control_approval.final_trail_suggest_time
     *
     * @return the value of miss_control_approval.final_trail_suggest_time
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public Date getFinalTrailSuggestTime() {
        return finalTrailSuggestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_control_approval.final_trail_suggest_time
     *
     * @param finalTrailSuggestTime the value for miss_control_approval.final_trail_suggest_time
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    public void setFinalTrailSuggestTime(Date finalTrailSuggestTime) {
        this.finalTrailSuggestTime = finalTrailSuggestTime;
    }
}