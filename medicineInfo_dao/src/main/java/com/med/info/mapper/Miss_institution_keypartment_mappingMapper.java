package com.med.info.mapper;

import com.med.info.domain.Miss_institution_keypartment_mapping;

public interface Miss_institution_keypartment_mappingMapper extends BaseMapper<Miss_institution_keypartment_mapping>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_institution_keypartment_mapping
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_institution_keypartment_mapping
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int insert(Miss_institution_keypartment_mapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_institution_keypartment_mapping
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int insertSelective(Miss_institution_keypartment_mapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_institution_keypartment_mapping
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    Miss_institution_keypartment_mapping selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_institution_keypartment_mapping
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_institution_keypartment_mapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_institution_keypartment_mapping
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Miss_institution_keypartment_mapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_institution_keypartment_mapping
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKey(Miss_institution_keypartment_mapping record);

	/**
	 * @author jialin.jiang
	 * Function: TODO ADD FUNCTION. <br/> 
	 * @param id
	 */
	void deleteByInstitutionId(Long id);
}