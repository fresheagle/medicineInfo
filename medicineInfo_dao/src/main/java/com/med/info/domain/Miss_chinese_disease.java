package com.med.info.domain;

public class Miss_chinese_disease extends BaseDomain{
//    /**
//     *
//     * This field was generated by MyBatis Generator.
//     * This field corresponds to the database column miss_chinese_disease.id
//     *
//     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
//     */
//    private Long id;

	/**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.chinese_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String chineseName;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.disease_id
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private Long diseaseId;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.reserve1
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String reserve1;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.reserve2
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String reserve2;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.reserve3
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String reserve3;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.dataStatus
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String datastatus;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.task_id
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String taskId;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.task_status
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String taskStatus;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.english_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String englishName;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.other_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String otherName;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.latin_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String latinName;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.related_diseases
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String relatedDiseases;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.disease_type
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String diseaseType;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.location_pid
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private Long locationPid;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.location_disease
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private Long locationDisease;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.main_causes
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String mainCauses;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.common_symptom
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String commonSymptom;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.multiple_population
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String multiplePopulation;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.infectivity
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private Integer infectivity;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.sea_characteristic
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String seaCharacteristic;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.department_pid
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private Long departmentPid;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.department_id
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private Long departmentId;

   /**
    *
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column miss_chinese_disease.thumbnail
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   private String thumbnail;

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.chinese_name
    *
    * @return the value of miss_chinese_disease.chinese_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getChineseName() {
       return chineseName;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.chinese_name
    *
    * @param chineseName the value for miss_chinese_disease.chinese_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setChineseName(String chineseName) {
       this.chineseName = chineseName == null ? null : chineseName.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.disease_id
    *
    * @return the value of miss_chinese_disease.disease_id
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public Long getDiseaseId() {
       return diseaseId;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.disease_id
    *
    * @param diseaseId the value for miss_chinese_disease.disease_id
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setDiseaseId(Long diseaseId) {
       this.diseaseId = diseaseId;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.reserve1
    *
    * @return the value of miss_chinese_disease.reserve1
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getReserve1() {
       return reserve1;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.reserve1
    *
    * @param reserve1 the value for miss_chinese_disease.reserve1
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setReserve1(String reserve1) {
       this.reserve1 = reserve1 == null ? null : reserve1.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.reserve2
    *
    * @return the value of miss_chinese_disease.reserve2
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getReserve2() {
       return reserve2;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.reserve2
    *
    * @param reserve2 the value for miss_chinese_disease.reserve2
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setReserve2(String reserve2) {
       this.reserve2 = reserve2 == null ? null : reserve2.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.reserve3
    *
    * @return the value of miss_chinese_disease.reserve3
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getReserve3() {
       return reserve3;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.reserve3
    *
    * @param reserve3 the value for miss_chinese_disease.reserve3
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setReserve3(String reserve3) {
       this.reserve3 = reserve3 == null ? null : reserve3.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.dataStatus
    *
    * @return the value of miss_chinese_disease.dataStatus
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getDatastatus() {
       return datastatus;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.dataStatus
    *
    * @param datastatus the value for miss_chinese_disease.dataStatus
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setDatastatus(String datastatus) {
       this.datastatus = datastatus == null ? null : datastatus.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.task_id
    *
    * @return the value of miss_chinese_disease.task_id
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getTaskId() {
       return taskId;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.task_id
    *
    * @param taskId the value for miss_chinese_disease.task_id
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setTaskId(String taskId) {
       this.taskId = taskId == null ? null : taskId.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.task_status
    *
    * @return the value of miss_chinese_disease.task_status
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getTaskStatus() {
       return taskStatus;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.task_status
    *
    * @param taskStatus the value for miss_chinese_disease.task_status
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setTaskStatus(String taskStatus) {
       this.taskStatus = taskStatus == null ? null : taskStatus.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.english_name
    *
    * @return the value of miss_chinese_disease.english_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getEnglishName() {
       return englishName;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.english_name
    *
    * @param englishName the value for miss_chinese_disease.english_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setEnglishName(String englishName) {
       this.englishName = englishName == null ? null : englishName.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.other_name
    *
    * @return the value of miss_chinese_disease.other_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getOtherName() {
       return otherName;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.other_name
    *
    * @param otherName the value for miss_chinese_disease.other_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setOtherName(String otherName) {
       this.otherName = otherName == null ? null : otherName.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.latin_name
    *
    * @return the value of miss_chinese_disease.latin_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getLatinName() {
       return latinName;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.latin_name
    *
    * @param latinName the value for miss_chinese_disease.latin_name
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setLatinName(String latinName) {
       this.latinName = latinName == null ? null : latinName.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.related_diseases
    *
    * @return the value of miss_chinese_disease.related_diseases
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getRelatedDiseases() {
       return relatedDiseases;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.related_diseases
    *
    * @param relatedDiseases the value for miss_chinese_disease.related_diseases
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setRelatedDiseases(String relatedDiseases) {
       this.relatedDiseases = relatedDiseases == null ? null : relatedDiseases.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.disease_type
    *
    * @return the value of miss_chinese_disease.disease_type
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getDiseaseType() {
       return diseaseType;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.disease_type
    *
    * @param diseaseType the value for miss_chinese_disease.disease_type
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setDiseaseType(String diseaseType) {
       this.diseaseType = diseaseType == null ? null : diseaseType.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.location_pid
    *
    * @return the value of miss_chinese_disease.location_pid
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public Long getLocationPid() {
       return locationPid;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.location_pid
    *
    * @param locationPid the value for miss_chinese_disease.location_pid
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setLocationPid(Long locationPid) {
       this.locationPid = locationPid;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.location_disease
    *
    * @return the value of miss_chinese_disease.location_disease
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public Long getLocationDisease() {
       return locationDisease;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.location_disease
    *
    * @param locationDisease the value for miss_chinese_disease.location_disease
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setLocationDisease(Long locationDisease) {
       this.locationDisease = locationDisease;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.main_causes
    *
    * @return the value of miss_chinese_disease.main_causes
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getMainCauses() {
       return mainCauses;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.main_causes
    *
    * @param mainCauses the value for miss_chinese_disease.main_causes
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setMainCauses(String mainCauses) {
       this.mainCauses = mainCauses == null ? null : mainCauses.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.common_symptom
    *
    * @return the value of miss_chinese_disease.common_symptom
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getCommonSymptom() {
       return commonSymptom;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.common_symptom
    *
    * @param commonSymptom the value for miss_chinese_disease.common_symptom
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setCommonSymptom(String commonSymptom) {
       this.commonSymptom = commonSymptom == null ? null : commonSymptom.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.multiple_population
    *
    * @return the value of miss_chinese_disease.multiple_population
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getMultiplePopulation() {
       return multiplePopulation;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.multiple_population
    *
    * @param multiplePopulation the value for miss_chinese_disease.multiple_population
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setMultiplePopulation(String multiplePopulation) {
       this.multiplePopulation = multiplePopulation == null ? null : multiplePopulation.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.infectivity
    *
    * @return the value of miss_chinese_disease.infectivity
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public Integer getInfectivity() {
       return infectivity;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.infectivity
    *
    * @param infectivity the value for miss_chinese_disease.infectivity
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setInfectivity(Integer infectivity) {
       this.infectivity = infectivity;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.sea_characteristic
    *
    * @return the value of miss_chinese_disease.sea_characteristic
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getSeaCharacteristic() {
       return seaCharacteristic;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.sea_characteristic
    *
    * @param seaCharacteristic the value for miss_chinese_disease.sea_characteristic
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setSeaCharacteristic(String seaCharacteristic) {
       this.seaCharacteristic = seaCharacteristic == null ? null : seaCharacteristic.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.department_pid
    *
    * @return the value of miss_chinese_disease.department_pid
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public Long getDepartmentPid() {
       return departmentPid;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.department_pid
    *
    * @param departmentPid the value for miss_chinese_disease.department_pid
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setDepartmentPid(Long departmentPid) {
       this.departmentPid = departmentPid;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.department_id
    *
    * @return the value of miss_chinese_disease.department_id
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public Long getDepartmentId() {
       return departmentId;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.department_id
    *
    * @param departmentId the value for miss_chinese_disease.department_id
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setDepartmentId(Long departmentId) {
       this.departmentId = departmentId;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column miss_chinese_disease.thumbnail
    *
    * @return the value of miss_chinese_disease.thumbnail
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public String getThumbnail() {
       return thumbnail;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column miss_chinese_disease.thumbnail
    *
    * @param thumbnail the value for miss_chinese_disease.thumbnail
    *
    * @mbg.generated Sun Apr 21 18:34:02 CST 2019
    */
   public void setThumbnail(String thumbnail) {
       this.thumbnail = thumbnail == null ? null : thumbnail.trim();
   }
   private Long editDoctor;
   private Long auditDoctor;
public Long getEditDoctor() {
	return editDoctor;
}

public void setEditDoctor(Long editDoctor) {
	this.editDoctor = editDoctor;
}

public Long getAuditDoctor() {
	return auditDoctor;
}

public void setAuditDoctor(Long auditDoctor) {
	this.auditDoctor = auditDoctor;
}
}