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

public interface DiseasInfoService {

	public Integer addDiseasInfo(Miss_disease miss_disease, Miss_disease_department_mapping miss_disease_department_mapping, Miss_disease_symptom_mapping miss_disease_symptom_mapping);
	
	public Integer addChineseDiseaseBlogInfo(Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs);
	
	public Integer addWestDiseaseBlogInfo(Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs);
	
	public Integer addCombinationDiseaseBlogInfo(Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs);
	
    public Miss_disease queryDiseasInfo(Integer diseaseId);
	
    public List<Miss_department> queryDepartmentInfo(Integer diseaseId);
    
    public List<Miss_symptom> querySymptomInfo(Integer diseaseId);
    
	public Miss_chinese_diseaseWithBLOBs queryChineseDiseaseBlogInfo(Integer chinese_diseaseId);
	
	public Miss_western_diseaseWithBLOBs queryWestDiseaseBlogInfo(Integer western_diseaseId);
	
	public Miss_combination_diseaseWithBLOBs queryCombinationDiseaseBlogInfo(Integer combination_diseaseId);
	

}
