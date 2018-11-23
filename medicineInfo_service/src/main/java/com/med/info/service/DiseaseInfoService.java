package com.med.info.service;

import java.util.List;
import java.util.Map;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.domain.Miss_combination_diseaseWithBLOBs;
import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.service.dto.DiseaseDTO;
import com.med.info.service.dto.DiseaseDepartmentMapDTO;
import com.med.info.service.dto.DiseaseSymptomMapDTO;
import org.springframework.stereotype.Service;

/**
 * 
 * @author zhangmin
 *
 */

public interface DiseaseInfoService {

	/**
	 * 添加疾病基础信息
	 * @param diseaseDTO 疾病基础信息
	 * @return 疾病信息id
	 */
	public Integer addDiseaseInfo(DiseaseDTO diseaseDTO);
	
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
    public DiseaseDTO queryDiseaseInfo(Integer diseaseId);
    
    /**
	 * 查询疾病id与名称
	 * @param
	 * @return 疾病基础信息的id和名称列表
	 */
    public List<Map<Integer,String>> queryDiseaseInfoName();
	
    /**
	 * 查询疾病相关科室部门信息
	 * @param
	 * @return 疾病相关科室部门信息
	 */
    public List<DiseaseDepartmentMapDTO> queryDepartmentInfo();
    
    /**
     * 查询疾病相关症状信息
     * @param
     * @return 疾病相关症状信息
     */
    public List<DiseaseSymptomMapDTO> querySymptomInfo();
    
    /**
     * 查询中医疾病相关信息
     * @param chinese_diseaseId 中医疾病相关信息id
     * @return 中医疾病信息
     */
	public Miss_chinese_diseaseWithBLOBs queryChineseDiseaseBlogInfo(Integer chinese_diseaseId);
	
	/**
	 * 查询西医疾病相关信息
	 * @param western_diseaseId 西医疾病相关信息id
	 * @return 西医疾病信息
	 */
	public Miss_western_diseaseWithBLOBs queryWestDiseaseBlogInfo(Integer western_diseaseId);
	
	/**
	 * 查询中西医结合疾病相关信息 
	 * @param combination_diseaseId 中西医结合疾病相关信息id
	 * @return 中西医结合疾病相关信息
	 */
	public Miss_combination_diseaseWithBLOBs queryCombinationDiseaseBlogInfo(Integer combination_diseaseId);
	
	/**
	 * 修改疾病基础信息
	 * @param diseaseDTO 疾病基础信息
	 * @return 疾病信息id
	 */
	public Integer updateDiseaseInfo(DiseaseDTO diseaseDTO);

	/**
	 * 修改中医疾病信息
	 * @param miss_chinese_diseaseWithBLOBs 包含父类信息参数的中医疾病信息
	 * @return 中医疾病信息id
	 */
	public Integer updateChineseDiseaseBlogInfo(Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs);
	
	/**
	 * 修改西医疾病信息
	 * @param miss_western_diseaseWithBLOBs 包含父类信息参数的西医疾病信息
	 * @return 西医疾病信息id
	 */
	public Integer updateWestDiseaseBlogInfo(Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs);
	
	/**
	 * 修改中西医结合疾病信息
	 * @param miss_combination_diseaseWithBLOBs 包含父类信息参数的中西医结合疾病信息
	 * @return 中西医结合疾病信息id
	 */
	public abstract Integer updateCombinationDiseaseBlogInfo(Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs);
	
	/**
	 * 删除疾病基础信息
	 * @param diseaseId 疾病基础信息id
	 * @return 疾病信息id
	 */
	public Integer deleteDiseaseInfo(Integer diseaseId);
	
	/**
	 * 删除中医疾病信息
	 * @param chinese_diseaseId 包含父类信息参数的中医疾病信息id
	 * @return 中医疾病信息id
	 */
	public Integer deleteChineseDiseaseBlogInfo(Integer chinese_diseaseId);
	
	/**
	 * 删除西医疾病信息
	 * @param western_diseaseId 包含父类信息参数的西医疾病信息id
	 * @return 西医疾病信息id
	 */
	public Integer deleteWestDiseaseBlogInfo(Integer western_diseaseId);
	
	/**
	 * 删除中西医结合疾病信息
	 * @param combination_diseaseId 包含父类信息参数的中西医结合疾病信息id
	 * @return 中西医结合疾病信息id
	 */
	public Integer deleteCombinationDiseaseBlogInfo(Integer combination_diseaseId);
}
