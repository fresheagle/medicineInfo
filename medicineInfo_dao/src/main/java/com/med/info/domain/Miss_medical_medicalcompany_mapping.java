package com.med.info.domain;

public class Miss_medical_medicalcompany_mapping extends BaseDomain {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_medical_medicalcompany_mapping.medical_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Long medicalId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_medical_medicalcompany_mapping.medical_company_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Long medicalCompanyId;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_medical_medicalcompany_mapping.medical_id
     *
     * @return the value of miss_medical_medicalcompany_mapping.medical_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
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
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
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
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
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
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setMedicalCompanyId(Long medicalCompanyId) {
        this.medicalCompanyId = medicalCompanyId;
    }

}