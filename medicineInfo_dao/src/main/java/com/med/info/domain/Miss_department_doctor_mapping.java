package com.med.info.domain;

public class Miss_department_doctor_mapping extends BaseDomain {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_department_doctor_mapping.department_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Long departmentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miss_department_doctor_mapping.doctor_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    private Long doctorId;



    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_department_doctor_mapping.department_id
     *
     * @return the value of miss_department_doctor_mapping.department_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_department_doctor_mapping.department_id
     *
     * @param departmentId the value for miss_department_doctor_mapping.department_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miss_department_doctor_mapping.doctor_id
     *
     * @return the value of miss_department_doctor_mapping.doctor_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public Long getDoctorId() {
        return doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miss_department_doctor_mapping.doctor_id
     *
     * @param doctorId the value for miss_department_doctor_mapping.doctor_id
     *
     * @mbg.generated Sat Nov 24 19:57:07 CST 2018
     */
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}