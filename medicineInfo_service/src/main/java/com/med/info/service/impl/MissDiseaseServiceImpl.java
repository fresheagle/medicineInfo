package com.med.info.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.med.info.domain.Miss_control_task_records;
import com.med.info.domain.Miss_diseaseWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_diseaseMapper;
import com.med.info.response.PageObject;
import com.med.info.service.MissDiseaseService;
import com.med.info.service.dto.DiseaseDTO;

@Service
public class MissDiseaseServiceImpl extends BaseServiceImpl<Miss_diseaseWithBLOBs> implements MissDiseaseService{

	@Autowired
	private Miss_diseaseMapper diseaseMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return diseaseMapper;
	}

	@Override
	public Long addDiseaseInfo(DiseaseDTO diseaseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiseaseDTO queryDiseaseInfo(Long diseaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updateDiseaseInfo(DiseaseDTO diseaseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteDiseaseInfo(Long diseaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getByPage(Integer currentPage, Integer pageSize, String chineseName, String englishName,
			String otherName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		Miss_diseaseWithBLOBs disease = new Miss_diseaseWithBLOBs();
		if(chineseName != null) {
			disease.setChineseName(chineseName);
		}
		if(englishName != null) {
			disease.setEnglishName(englishName);
		}
		if(otherName != null) {
			disease.setOtherName(otherName);
		}
		Page<Miss_diseaseWithBLOBs> showDataCondition = (Page<Miss_diseaseWithBLOBs>) diseaseMapper
				.showDataCondition(disease);
		List<DiseaseDTO> list = new ArrayList<>();
		for (int i=0 ; i<showDataCondition.size(); i++) {
			list.add(new DiseaseDTO());
			list.get(i).setMiss_disease(showDataCondition.get(i));
		}
		PageObject object = new PageObject<DiseaseDTO>();
		object.setCurrentPage(showDataCondition.getPageNum());
		object.setParams(list);
		object.setTotal(showDataCondition.getTotal());
		return object;
	}
}
