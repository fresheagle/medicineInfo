package com.med.info.domain;

public class Miss_institution_doctor_mapping extends BaseDomain {

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_institution_doctor_mapping.institution_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Long institutionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_institution_doctor_mapping.doctor_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Long doctorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_institution_doctor_mapping.weight
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private String weight;
    
    private String exportsTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_institution_doctor_mapping.institution_id
     *
     * @return the value of miss_institution_doctor_mapping.institution_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public Long getInstitutionId() {
        return institutionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_institution_doctor_mapping.institution_id
     *
     * @param institutionId the value for miss_institution_doctor_mapping.institution_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_institution_doctor_mapping.doctor_id
     *
     * @return the value of miss_institution_doctor_mapping.doctor_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public Long getDoctorId() {
        return doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_institution_doctor_mapping.doctor_id
     *
     * @param doctorId the value for miss_institution_doctor_mapping.doctor_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_institution_doctor_mapping.weight
     *
     * @return the value of miss_institution_doctor_mapping.weight
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public String getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_institution_doctor_mapping.weight
     *
     * @param weight the value for miss_institution_doctor_mapping.weight
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

	public String getExportsTime() {
		return exportsTime;
	}

	public void setExportsTime(String exportsTime) {
		this.exportsTime = exportsTime;
	}
}