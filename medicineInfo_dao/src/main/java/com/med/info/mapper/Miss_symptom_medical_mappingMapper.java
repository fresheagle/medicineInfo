package com.med.info.mapper;

import com.med.info.domain.Miss_symptom_medical_mapping;

public interface Miss_symptom_medical_mappingMapper extends BaseMapper<Miss_symptom_medical_mapping>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom_medical_mapping
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom_medical_mapping
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insert(Miss_symptom_medical_mapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom_medical_mapping
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insertSelective(Miss_symptom_medical_mapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom_medical_mapping
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    Miss_symptom_medical_mapping selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom_medical_mapping
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_symptom_medical_mapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom_medical_mapping
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Miss_symptom_medical_mapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom_medical_mapping
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKey(Miss_symptom_medical_mapping record);
}