package com.med.info.service;

import com.med.info.domain.Miss_diseaseWithBLOBs;
import com.med.info.service.dto.DiseaseDTO;

public interface MissDiseaseService extends BaseService<Miss_diseaseWithBLOBs>{

	/**
	 * 添加疾病基础信息
	 * @param diseaseDTO 疾病基础信息
	 * @return 疾病信息id
	 */
	Long addDiseaseInfo(DiseaseDTO diseaseDTO);
	
	/**
	 * 查询疾病基础信息
	 * @param diseaseId 疾病基础信息id
	 * @return 疾病基础信息内容
	 */
	DiseaseDTO queryDiseaseInfo(Long diseaseId);
	
	/**
	 * 修改疾病基础信息
	 * @param diseaseDTO 疾病基础信息
	 * @return 疾病信息id
	 */
	Long updateDiseaseInfo(DiseaseDTO diseaseDTO);
	
	/**
	 * 删除疾病基础信息
	 * @param diseaseId 疾病基础信息id
	 * @return 疾病信息id
	 */
	Integer deleteDiseaseInfo(Long diseaseId);
	
	public Object getByPage(Integer currentPage, Integer pageSize, String chineseName, String englishName, String otherName);
}
