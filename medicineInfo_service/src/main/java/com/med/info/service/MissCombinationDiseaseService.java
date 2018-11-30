package com.med.info.service;

import com.med.info.domain.Miss_combination_diseaseWithBLOBs;

public interface MissCombinationDiseaseService extends BaseService<Miss_combination_diseaseWithBLOBs>{

	/**
	 * 添加中西医结合疾病信息
	 * @param miss_combination_diseaseWithBLOBs 包含父类信息参数的中西医结合疾病信息
	 * @return 中西医结合疾病信息id
	 */
	Long addCombinationDiseaseBlogInfo(Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs);
	
	/**
	 * 查询中西医结合疾病相关信息 
	 * @param combination_diseaseId 中西医结合疾病相关信息id
	 * @return 中西医结合疾病相关信息
	 */
	Miss_combination_diseaseWithBLOBs queryCombinationDiseaseBlogInfo(Long combination_diseaseId);
	
	/**
	 * 修改中西医结合疾病信息
	 * @param miss_combination_diseaseWithBLOBs 包含父类信息参数的中西医结合疾病信息
	 * @return 中西医结合疾病信息id
	 */
	Long updateCombinationDiseaseBlogInfo(Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs);
	
	/**
	 * 删除中西医结合疾病信息
	 * @param combination_diseaseId 包含父类信息参数的中西医结合疾病信息id
	 * @return 中西医结合疾病信息id
	 */
	Integer deleteCombinationDiseaseBlogInfo(Long combination_diseaseId);
}
