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
import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.DiseaseDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissDepartmentService;
import com.med.info.service.MissDiseaseService;
import com.med.info.service.MissSymptomService;

@Service
public class MissDiseaseServiceImpl extends BaseServiceImpl<Miss_diseaseWithBLOBs> implements MissDiseaseService {

	@Autowired
	private Miss_diseaseMapper diseaseMapper;

	@Autowired
	private MissDepartmentService missDepartmentServicece;
	@Autowired
	private MissSymptomService missSymptomService;

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
		disease.setChineseName(chineseName);
		disease.setEnglishName(englishName);
		disease.setOtherName(otherName);
		Page<Miss_diseaseWithBLOBs> showDataCondition = (Page<Miss_diseaseWithBLOBs>) diseaseMapper
				.showDataCondition(disease);
		List<DiseaseDTO> list = new ArrayList<>();
		for (Miss_diseaseWithBLOBs miss_diseaseWithBLOBs : showDataCondition) {
			DiseaseDTO diseaseDTO = new DiseaseDTO();
			diseaseDTO.setMiss_disease(miss_diseaseWithBLOBs);
			List<Long> departMentList = getDepartMentList(miss_diseaseWithBLOBs);
			if (null != departMentList && departMentList.size() > 0) {
				List<DepartmentMapDTO> departmentMapByIds = missDepartmentServicece
						.getDepartmentMapByIds(departMentList);
				diseaseDTO.setDisease_department_mapping_list(departmentMapByIds);
			}
			diseaseDTO.setDisease_symptom_mapping_list(
					missSymptomService.getSymptomMapDTOByDiseaseId(miss_diseaseWithBLOBs.getId()));
			list.add(diseaseDTO);
		}
		PageObject object = new PageObject<DiseaseDTO>();
		object.setCurrentPage(showDataCondition.getPageNum());
		object.setParams(list);
		object.setTotal(showDataCondition.getTotal());
		return object;
	}

	private List<Long> getDepartMentList(Miss_diseaseWithBLOBs diseaseWithBLOBs) {
		List<Long> result = new ArrayList<>();
		if (diseaseWithBLOBs.getDepartmentId() != null) {
			result.add(diseaseWithBLOBs.getDepartmentId());
		}
		if (diseaseWithBLOBs.getDepartmentPid() != null) {
			result.add(diseaseWithBLOBs.getDepartmentPid());
		}
		return result;
	}

}
