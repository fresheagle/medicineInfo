package com.med.info.service;

import com.med.info.domain.Miss_western_diseaseWithBLOBs;

public interface MissWesternDiseaseService extends BaseService<Miss_western_diseaseWithBLOBs>{

	/**
	 * 添加西医疾病信息
	 * @param miss_western_diseaseWithBLOBs 包含父类信息参数的西医疾病信息
	 * @return 西医疾病信息id
	 */
	Long addWestDiseaseBlogInfo(Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs);
	
	/**
	 * 查询西医疾病相关信息
	 * @param western_diseaseId 西医疾病相关信息id
	 * @return 西医疾病信息
	 */
	Miss_western_diseaseWithBLOBs queryWestDiseaseBlogInfo(Long western_diseaseId);
	
	/**
	 * 修改西医疾病信息
	 * @param miss_western_diseaseWithBLOBs 包含父类信息参数的西医疾病信息
	 * @return 西医疾病信息id
	 */
	Long updateWestDiseaseBlogInfo(Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs);
	
	/**
	 * 删除西医疾病信息
	 * @param western_diseaseId 包含父类信息参数的西医疾病信息id
	 * @return 西医疾病信息id
	 */
	Integer deleteWestDiseaseBlogInfo(Long western_diseaseId);
	
	String checkWestDiseaseInfo(String chineseName, String englishName, String otherName) throws Exception;
}
