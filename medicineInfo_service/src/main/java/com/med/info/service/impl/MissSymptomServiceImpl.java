package com.med.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_symptomMapper;
import com.med.info.mapper.domain.DiseaseDTO;
import com.med.info.mapper.domain.DiseaseMapDTO;
import com.med.info.mapper.domain.SymptomMapDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissSymptomService;

@Service
public class MissSymptomServiceImpl extends BaseServiceImpl<Miss_symptomWithBLOBs> implements MissSymptomService{

	@Autowired
	private Miss_symptomMapper symptomMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return symptomMapper;
	}

	@Override
	public List<SymptomMapDTO> getSymptomMapDTOByDiseaseId(Long id) {
		// TODO Auto-generated method stub
		return symptomMapper.getSymptomMapDTOByDiseaseId(id);
	}

	@Override
	public Object querySymptomMapDTOParam(Integer currentPage, Integer pageSize, String chineseName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		Page<SymptomMapDTO> showDataCondition = (Page<SymptomMapDTO>) symptomMapper.querySymptomMapDTOParam(chineseName);
		PageObject object = new PageObject<SymptomMapDTO>();
		object.setCurrentPage(currentPage);
		object.setParams(showDataCondition.getResult());
		object.setTotal(showDataCondition.getTotal());
		return object;
	}

}
