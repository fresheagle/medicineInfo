package com.med.info.domain;

public class Miss_article extends BaseDomain{
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.id
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    //private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.title
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.author
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.thumbnail
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String thumbnail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.keyword
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String keyword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.description
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.publish_time
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String publishTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.reading
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private Integer reading;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.reserve1
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String reserve1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.reserve2
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String reserve2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.reserve3
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String reserve3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.dataStatus
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String datastatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.task_id
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.task_status
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String taskStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.edit_doctor
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private Long editDoctor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.audit_doctor
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private Long auditDoctor;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.id
     *
     * @return the value of miss_article.id
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
//    public Long getId() {
//        return id;
//    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.id
     *
     * @param id the value for miss_article.id
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
//    public void setId(Long id) {
//        this.id = id;
//    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.title
     *
     * @return the value of miss_article.title
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.title
     *
     * @param title the value for miss_article.title
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.author
     *
     * @return the value of miss_article.author
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.author
     *
     * @param author the value for miss_article.author
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.thumbnail
     *
     * @return the value of miss_article.thumbnail
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.thumbnail
     *
     * @param thumbnail the value for miss_article.thumbnail
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.keyword
     *
     * @return the value of miss_article.keyword
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.keyword
     *
     * @param keyword the value for miss_article.keyword
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.description
     *
     * @return the value of miss_article.description
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.description
     *
     * @param description the value for miss_article.description
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.publish_time
     *
     * @return the value of miss_article.publish_time
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.publish_time
     *
     * @param publishTime the value for miss_article.publish_time
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime == null ? null : publishTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.reading
     *
     * @return the value of miss_article.reading
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public Integer getReading() {
        return reading;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.reading
     *
     * @param reading the value for miss_article.reading
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setReading(Integer reading) {
        this.reading = reading;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.reserve1
     *
     * @return the value of miss_article.reserve1
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getReserve1() {
        return reserve1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.reserve1
     *
     * @param reserve1 the value for miss_article.reserve1
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.reserve2
     *
     * @return the value of miss_article.reserve2
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getReserve2() {
        return reserve2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.reserve2
     *
     * @param reserve2 the value for miss_article.reserve2
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.reserve3
     *
     * @return the value of miss_article.reserve3
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getReserve3() {
        return reserve3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.reserve3
     *
     * @param reserve3 the value for miss_article.reserve3
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.dataStatus
     *
     * @return the value of miss_article.dataStatus
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getDatastatus() {
        return datastatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.dataStatus
     *
     * @param datastatus the value for miss_article.dataStatus
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setDatastatus(String datastatus) {
        this.datastatus = datastatus == null ? null : datastatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.task_id
     *
     * @return the value of miss_article.task_id
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.task_id
     *
     * @param taskId the value for miss_article.task_id
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.task_status
     *
     * @return the value of miss_article.task_status
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.task_status
     *
     * @param taskStatus the value for miss_article.task_status
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.edit_doctor
     *
     * @return the value of miss_article.edit_doctor
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public Long getEditDoctor() {
        return editDoctor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.edit_doctor
     *
     * @param editDoctor the value for miss_article.edit_doctor
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setEditDoctor(Long editDoctor) {
        this.editDoctor = editDoctor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.audit_doctor
     *
     * @return the value of miss_article.audit_doctor
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public Long getAuditDoctor() {
        return auditDoctor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.audit_doctor
     *
     * @param auditDoctor the value for miss_article.audit_doctor
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setAuditDoctor(Long auditDoctor) {
        this.auditDoctor = auditDoctor;
    }
}