package com.med.info.domain;

public class Miss_disease_symptom_mapping extends BaseDomain {

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_disease_symptom_mapping.disease_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Integer diseaseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_disease_symptom_mapping.symptom_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Integer symptomId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_disease_symptom_mapping.disease_id
     *
     * @return the value of miss_disease_symptom_mapping.disease_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public Integer getDiseaseId() {
        return diseaseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_disease_symptom_mapping.disease_id
     *
     * @param diseaseId the value for miss_disease_symptom_mapping.disease_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_disease_symptom_mapping.symptom_id
     *
     * @return the value of miss_disease_symptom_mapping.symptom_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public Integer getSymptomId() {
        return symptomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_disease_symptom_mapping.symptom_id
     *
     * @param symptomId the value for miss_disease_symptom_mapping.symptom_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
    }

}