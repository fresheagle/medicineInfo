package com.med.info.mapper;

import com.med.info.domain.Miss_chinese_disease;
import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;

public interface Miss_chinese_diseaseMapper extends BaseMapper<Miss_chinese_diseaseWithBLOBs> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_chinese_disease
     *
     * @mbg.generated Sat Nov 17 18:12:50 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_chinese_disease
     *
     * @mbg.generated Sat Nov 17 18:12:50 CST 2018
     */
    int insert(Miss_chinese_diseaseWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_chinese_disease
     *
     * @mbg.generated Sat Nov 17 18:12:50 CST 2018
     */
    int insertSelective(Miss_chinese_diseaseWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_chinese_disease
     *
     * @mbg.generated Sat Nov 17 18:12:50 CST 2018
     */
    Miss_chinese_diseaseWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_chinese_disease
     *
     * @mbg.generated Sat Nov 17 18:12:50 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_chinese_diseaseWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_chinese_disease
     *
     * @mbg.generated Sat Nov 17 18:12:50 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Miss_chinese_diseaseWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_chinese_disease
     *
     * @mbg.generated Sat Nov 17 18:12:50 CST 2018
     */
    int updateByPrimaryKey(Miss_chinese_disease record);
}