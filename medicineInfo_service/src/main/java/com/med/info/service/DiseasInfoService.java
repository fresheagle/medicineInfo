package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.domain.Miss_combination_diseaseWithBLOBs;
import com.med.info.domain.Miss_department;
import com.med.info.domain.Miss_disease;
import com.med.info.domain.Miss_disease_department_mapping;
import com.med.info.domain.Miss_disease_symptom_mapping;
import com.med.info.domain.Miss_symptom;
import com.med.info.domain.Miss_western_diseaseWithBLOBs;

/**
 * 
 * @author zhangmin
 *
 */
public interface DiseasInfoService {

	/**
	 * 添加疾病基础信息
	 * @param miss_disease 疾病基础信息
	 * @param miss_disease_department_mapping 疾病、科室部门关联信息
	 * @param miss_disease_symptom_mapping 疾病、症状关联信息
	 * @return 疾病信息id
	 */
	public Integer addDiseasInfo(Miss_disease miss_disease, Miss_disease_department_mapping miss_disease_department_mapping, Miss_disease_symptom_mapping miss_disease_symptom_mapping);
	
	/**
	 * 添加中医疾病信息
	 * @param miss_chinese_diseaseWithBLOBs 包含父类信息参数的中医疾病信息
	 * @return 中医疾病信息id
	 */
	public Integer addChineseDiseaseBlogInfo(Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs);
	
	/**
	 * 添加西医疾病信息
	 * @param miss_western_diseaseWithBLOBs 包含父类信息参数的西医疾病信息
	 * @return 西医疾病信息id
	 */
	public Integer addWestDiseaseBlogInfo(Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs);
	
	/**
	 * 添加中西医结合疾病信息
	 * @param miss_combination_diseaseWithBLOBs 包含父类信息参数的中西医结合疾病信息
	 * @return 中西医结合疾病信息id
	 */
	public Integer addCombinationDiseaseBlogInfo(Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs);
	
	/**
	 * 查询疾病基础信息
	 * @param diseaseId 疾病基础信息id
	 * @return 疾病基础信息内容
	 */
    public Miss_disease queryDiseasInfo(Integer diseaseId);
	
    /**
	 * 查询疾病相关科室部门信息
	 * @param diseaseId 疾病基础信息id
	 * @return 疾病相关科室部门信息
	 */
    public List<Miss_department> queryDepartmentInfo(Integer diseaseId);
    
    /**
     * 查询疾病相关症状信息
     * @param diseaseId 疾病基础信息id
     * @return 疾病相关症状信息
     */
    public List<Miss_symptom> querySymptomInfo(Integer diseaseId);
    
    /**
     * 
     * @param chinese_diseaseId
     * @return
     */
	public Miss_chinese_diseaseWithBLOBs queryChineseDiseaseBlogInfo(Integer chinese_diseaseId);
	
	/**
	 * 
	 * @param western_diseaseId
	 * @return
	 */
	public Miss_western_diseaseWithBLOBs queryWestDiseaseBlogInfo(Integer western_diseaseId);
	
	/**
	 * 
	 * @param combination_diseaseId
	 * @return
	 */
	public Miss_combination_diseaseWithBLOBs queryCombinationDiseaseBlogInfo(Integer combination_diseaseId);
	

}
