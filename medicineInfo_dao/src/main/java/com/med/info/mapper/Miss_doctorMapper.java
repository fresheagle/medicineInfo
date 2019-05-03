package com.med.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.domain.Miss_doctor;
import com.med.info.domain.Miss_doctorWithBLOBs;

public interface Miss_doctorMapper extends BaseMapper<Miss_doctorWithBLOBs>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_doctor
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_doctor
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int insert(Miss_doctorWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_doctor
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int insertSelective(Miss_doctorWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_doctor
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    Miss_doctorWithBLOBs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_doctor
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_doctorWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_doctor
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Miss_doctorWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_doctor
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKey(Miss_doctor record);
    
    
    List<Miss_doctorWithBLOBs> check(@Param("name") String name, @Param("sex") String sex,  @Param("birthday") String birthday);
}