package com.med.info.service;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;

public interface MissChineseDiseaseService extends BaseService<Miss_chinese_diseaseWithBLOBs>{

	/**
	 * 添加中医疾病信息
	 * @param miss_chinese_diseaseWithBLOBs 包含父类信息参数的中医疾病信息
	 * @return 中医疾病信息id
	 */
	Long addChineseDiseaseBlogInfo(Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs);
	
	/**
     * 查询中医疾病相关信息
     * @param chinese_diseaseId 中医疾病相关信息id
     * @return 中医疾病信息
     */
	Miss_chinese_diseaseWithBLOBs queryChineseDiseaseBlogInfo(Long chinese_diseaseId);
	
	/**
	 * 修改中医疾病信息
	 * @param miss_chinese_diseaseWithBLOBs 包含父类信息参数的中医疾病信息
	 * @return 中医疾病信息id
	 */
	Long updateChineseDiseaseBlogInfo(Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs);
	
	/**
	 * 删除中医疾病信息
	 * @param chinese_diseaseId 包含父类信息参数的中医疾病信息id
	 * @return 中医疾病信息id
	 */
	Integer deleteChineseDiseaseBlogInfo(Long chinese_diseaseId);
	
	
	String checkChineseDiseaseInfo(String chineseName, String englishName, String otherName) throws Exception;
}
