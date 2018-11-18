package com.med.info.domain;

public class Miss_district {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_district.id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_district.district_code
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private String districtCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_district.district_name
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private String districtName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_district.level
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private String level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_district.parent_district_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private Long parentDistrictId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_district.task_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private String taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_district.task_status
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private String taskStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_district.task_json
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    private String taskJson;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_district.id
     *
     * @return the value of miss_district.id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_district.id
     *
     * @param id the value for miss_district.id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_district.district_code
     *
     * @return the value of miss_district.district_code
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_district.district_code
     *
     * @param districtCode the value for miss_district.district_code
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_district.district_name
     *
     * @return the value of miss_district.district_name
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_district.district_name
     *
     * @param districtName the value for miss_district.district_name
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_district.level
     *
     * @return the value of miss_district.level
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_district.level
     *
     * @param level the value for miss_district.level
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_district.parent_district_id
     *
     * @return the value of miss_district.parent_district_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public Long getParentDistrictId() {
        return parentDistrictId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_district.parent_district_id
     *
     * @param parentDistrictId the value for miss_district.parent_district_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setParentDistrictId(Long parentDistrictId) {
        this.parentDistrictId = parentDistrictId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_district.task_id
     *
     * @return the value of miss_district.task_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_district.task_id
     *
     * @param taskId the value for miss_district.task_id
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_district.task_status
     *
     * @return the value of miss_district.task_status
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_district.task_status
     *
     * @param taskStatus the value for miss_district.task_status
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_district.task_json
     *
     * @return the value of miss_district.task_json
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public String getTaskJson() {
        return taskJson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_district.task_json
     *
     * @param taskJson the value for miss_district.task_json
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    public void setTaskJson(String taskJson) {
        this.taskJson = taskJson == null ? null : taskJson.trim();
    }
}