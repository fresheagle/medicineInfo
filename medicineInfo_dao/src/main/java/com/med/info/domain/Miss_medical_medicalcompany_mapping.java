package com.med.info.domain;

public class Miss_medical_medicalcompany_mapping {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_medical_medicalcompany_mapping.id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_medical_medicalcompany_mapping.medical_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private Long medicalId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_medical_medicalcompany_mapping.medical_company_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private Long medicalCompanyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_medical_medicalcompany_mapping.task_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private String taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_medical_medicalcompany_mapping.task_status
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private String taskStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_medical_medicalcompany_mapping.task_json
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private String taskJson;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_medical_medicalcompany_mapping.id
     *
     * @return the value of miss_medical_medicalcompany_mapping.id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_medical_medicalcompany_mapping.id
     *
     * @param id the value for miss_medical_medicalcompany_mapping.id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_medical_medicalcompany_mapping.medical_id
     *
     * @return the value of miss_medical_medicalcompany_mapping.medical_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public Long getMedicalId() {
        return medicalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_medical_medicalcompany_mapping.medical_id
     *
     * @param medicalId the value for miss_medical_medicalcompany_mapping.medical_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setMedicalId(Long medicalId) {
        this.medicalId = medicalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_medical_medicalcompany_mapping.medical_company_id
     *
     * @return the value of miss_medical_medicalcompany_mapping.medical_company_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public Long getMedicalCompanyId() {
        return medicalCompanyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_medical_medicalcompany_mapping.medical_company_id
     *
     * @param medicalCompanyId the value for miss_medical_medicalcompany_mapping.medical_company_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setMedicalCompanyId(Long medicalCompanyId) {
        this.medicalCompanyId = medicalCompanyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_medical_medicalcompany_mapping.task_id
     *
     * @return the value of miss_medical_medicalcompany_mapping.task_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_medical_medicalcompany_mapping.task_id
     *
     * @param taskId the value for miss_medical_medicalcompany_mapping.task_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_medical_medicalcompany_mapping.task_status
     *
     * @return the value of miss_medical_medicalcompany_mapping.task_status
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_medical_medicalcompany_mapping.task_status
     *
     * @param taskStatus the value for miss_medical_medicalcompany_mapping.task_status
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_medical_medicalcompany_mapping.task_json
     *
     * @return the value of miss_medical_medicalcompany_mapping.task_json
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public String getTaskJson() {
        return taskJson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_medical_medicalcompany_mapping.task_json
     *
     * @param taskJson the value for miss_medical_medicalcompany_mapping.task_json
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setTaskJson(String taskJson) {
        this.taskJson = taskJson == null ? null : taskJson.trim();
    }
}