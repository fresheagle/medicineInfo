package com.med.info.mapper;

import com.med.info.domain.Miss_medical_company;
import com.med.info.domain.Miss_medical_companyWithBLOBs;
import com.med.info.mapper.domain.MedicalCompanyMapDTO;

import java.util.List;

public interface Miss_medical_companyMapper extends BaseMapper<Miss_medical_companyWithBLOBs>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_medical_company
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_medical_company
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insert(Miss_medical_companyWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_medical_company
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insertSelective(Miss_medical_companyWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_medical_company
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    Miss_medical_companyWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_medical_company
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_medical_companyWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_medical_company
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Miss_medical_companyWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_medical_company
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKey(Miss_medical_company record);

    List<MedicalCompanyMapDTO> getCompanyByMedicalId(Long id);
}