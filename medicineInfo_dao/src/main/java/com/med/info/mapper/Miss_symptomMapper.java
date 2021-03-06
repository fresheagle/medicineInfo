package com.med.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.med.info.domain.Miss_symptom;
import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.mapper.domain.SymptomMapDTO;

public interface Miss_symptomMapper extends BaseMapper<Miss_symptomWithBLOBs> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int insert(Miss_symptomWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int insertSelective(Miss_symptomWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    Miss_symptomWithBLOBs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_symptomWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Miss_symptomWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_symptom
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKey(Miss_symptom record);
    
    
    List<SymptomMapDTO> getSymptomMapDTOByIds(List<Long> ids);

	List<SymptomMapDTO> getSymptomMapDTOByDiseaseId(Long id);
	
	List<SymptomMapDTO> querySymptomMapDTOParam(String chineseName);
	
	List<Miss_symptomWithBLOBs> check(@Param("chineseName") String chineseName, @Param("englishName") String englishName,  @Param("otherName") String otherName);
}