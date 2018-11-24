package com.med.info.domain;

public class Miss_disease_department_mapping {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_disease_department_mapping.id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_disease_department_mapping.disease_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Long diseaseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_disease_department_mapping.department_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Long departmentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_disease_department_mapping.dataStatus
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private String datastatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_disease_department_mapping.task_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private String taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_disease_department_mapping.task_status
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private String taskStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_disease_department_mapping.task_json
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private String taskJson;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_disease_department_mapping.id
     *
     * @return the value of miss_disease_department_mapping.id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_disease_department_mapping.id
     *
     * @param id the value for miss_disease_department_mapping.id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_disease_department_mapping.disease_id
     *
     * @return the value of miss_disease_department_mapping.disease_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public Long getDiseaseId() {
        return diseaseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_disease_department_mapping.disease_id
     *
     * @param diseaseId the value for miss_disease_department_mapping.disease_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_disease_department_mapping.department_id
     *
     * @return the value of miss_disease_department_mapping.department_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_disease_department_mapping.department_id
     *
     * @param departmentId the value for miss_disease_department_mapping.department_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_disease_department_mapping.dataStatus
     *
     * @return the value of miss_disease_department_mapping.dataStatus
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public String getDatastatus() {
        return datastatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_disease_department_mapping.dataStatus
     *
     * @param datastatus the value for miss_disease_department_mapping.dataStatus
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setDatastatus(String datastatus) {
        this.datastatus = datastatus == null ? null : datastatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_disease_department_mapping.task_id
     *
     * @return the value of miss_disease_department_mapping.task_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_disease_department_mapping.task_id
     *
     * @param taskId the value for miss_disease_department_mapping.task_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_disease_department_mapping.task_status
     *
     * @return the value of miss_disease_department_mapping.task_status
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_disease_department_mapping.task_status
     *
     * @param taskStatus the value for miss_disease_department_mapping.task_status
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_disease_department_mapping.task_json
     *
     * @return the value of miss_disease_department_mapping.task_json
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public String getTaskJson() {
        return taskJson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_disease_department_mapping.task_json
     *
     * @param taskJson the value for miss_disease_department_mapping.task_json
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setTaskJson(String taskJson) {
        this.taskJson = taskJson == null ? null : taskJson.trim();
    }
}