package com.med.info.mapper;

import com.med.info.domain.Miss_disease;

public interface Miss_diseaseMapper extends BaseMapper<Miss_disease>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insert(Miss_disease record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insertSelective(Miss_disease record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    Miss_disease selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_disease record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Miss_disease record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKey(Miss_disease record);
}