package com.med.info.domain;

public class Miss_articleWithBLOBs extends Miss_article {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.intro
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String intro;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.content
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.picturepath
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String picturepath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_article.task_json
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    private String taskJson;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.intro
     *
     * @return the value of miss_article.intro
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getIntro() {
        return intro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.intro
     *
     * @param intro the value for miss_article.intro
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.content
     *
     * @return the value of miss_article.content
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.content
     *
     * @param content the value for miss_article.content
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.picturepath
     *
     * @return the value of miss_article.picturepath
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getPicturepath() {
        return picturepath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.picturepath
     *
     * @param picturepath the value for miss_article.picturepath
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath == null ? null : picturepath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_article.task_json
     *
     * @return the value of miss_article.task_json
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public String getTaskJson() {
        return taskJson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_article.task_json
     *
     * @param taskJson the value for miss_article.task_json
     *
     * @mbg.generated Thu May 02 15:20:23 CST 2019
     */
    public void setTaskJson(String taskJson) {
        this.taskJson = taskJson == null ? null : taskJson.trim();
    }
}