package com.med.info.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_symptomMapper;
import com.med.info.mapper.domain.DiseaseDTO;
import com.med.info.mapper.domain.DiseaseMapDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.mapper.domain.SymptomDTO;
import com.med.info.mapper.domain.SymptomMapDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissDislocationService;
import com.med.info.service.MissMedicalService;
import com.med.info.service.MissSymptomService;

@Service
public class MissSymptomServiceImpl extends BaseServiceImpl<Miss_symptomWithBLOBs> implements MissSymptomService{

	@Autowired
	private Miss_symptomMapper symptomMapper;
	@Autowired
	private MissDislocationService missDislocationService;
	@Autowired
	private MissMedicalService missMedicalService;
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

	@Override
	public Object getByPage(Integer currentPage, Integer pageSize, String chineseName, String englishName,
			String otherName, String symptom, String commonSymptom) {
		Miss_symptomWithBLOBs symptomWithBLOBs= new Miss_symptomWithBLOBs();
		symptomWithBLOBs.setChineseName(chineseName);
		symptomWithBLOBs.setEnglishName(englishName);
		symptomWithBLOBs.setOtherName(otherName);
		symptomWithBLOBs.setSymptom(commonSymptom);
		symptomWithBLOBs.setCommonSymptom(commonSymptom);
		
		PageObject<Miss_symptomWithBLOBs> selectPage = super.selectPage(currentPage, pageSize, symptomWithBLOBs);
		List<Miss_symptomWithBLOBs> params = selectPage.getParams();
		
		PageObject<OperateDTO> result = new PageObject<>();
		result.setCurrentPage(selectPage.getCurrentPage());
		result.setTotal(selectPage.getTotal());
		List<OperateDTO> reultList = new ArrayList<>();
		for (Miss_symptomWithBLOBs miss_symptomWithBLOBs : params) {
			reultList.add(converseToOperataDTO(getSymptomDTO(miss_symptomWithBLOBs)));
		}
		result.setParams(reultList);
		return result;
	}

	private SymptomDTO getSymptomDTO(Miss_symptomWithBLOBs miss_symptomWithBLOBs) {
		SymptomDTO symptomDTO = new SymptomDTO();
		symptomDTO.setMiss_symptom(miss_symptomWithBLOBs);
		symptomDTO.setDislocation_list(missDislocationService.getDislocationMapDTOBySymptomId(miss_symptomWithBLOBs.getId()));
		symptomDTO.setMedical_list(missMedicalService.getMedicalMapDTOBySymptomId(miss_symptomWithBLOBs.getId()));
		return symptomDTO;
	}

}
