package com.med.info.mapper;

import com.med.info.domain.Miss_combination_disease;
import com.med.info.domain.Miss_combination_diseaseWithBLOBs;

public interface Miss_combination_diseaseMapper extends BaseMapper<Miss_combination_diseaseWithBLOBs>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_combination_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_combination_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insert(Miss_combination_diseaseWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_combination_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insertSelective(Miss_combination_diseaseWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_combination_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    Miss_combination_diseaseWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_combination_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_combination_diseaseWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_combination_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Miss_combination_diseaseWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_combination_disease
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKey(Miss_combination_disease record);
}