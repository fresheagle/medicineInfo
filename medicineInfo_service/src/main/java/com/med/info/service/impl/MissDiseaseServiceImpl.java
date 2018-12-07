package com.med.info.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.med.info.mapper.domain.OperateDTO;
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
import com.med.info.mapper.domain.DiseaseMapDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissDepartmentService;
import com.med.info.service.MissDiseaseService;
import com.med.info.service.MissSymptomService;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
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
			diseaseDTO.setMissDisease(miss_diseaseWithBLOBs);
			List<Long> departMentList = getDepartMentList(miss_diseaseWithBLOBs);
			if (null != departMentList && departMentList.size() > 0) {
				List<DepartmentMapDTO> departmentMapByIds = missDepartmentServicece
						.getDepartmentMapByIds(departMentList);
				diseaseDTO.setDepartmentMapDTO(departmentMapByIds);
			}
			diseaseDTO.setSymptomMapDTO(
					missSymptomService.getSymptomMapDTOByDiseaseId(miss_diseaseWithBLOBs.getId()));
			list.add(diseaseDTO);
		}
		List<OperateDTO> listOp = new ArrayList<>();
		for (DiseaseDTO diseaseDTO : list) {
			listOp.add(converseToOperataDTO(diseaseDTO));
		}
		PageObject object = new PageObject<DiseaseDTO>();
		object.setCurrentPage(showDataCondition.getPageNum());
		object.setParams(listOp);
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

	/* (non-Javadoc)
	 * @see com.med.info.service.MissDiseaseService#queryDiseaseInfoName(java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public Object queryDiseaseInfoName(Integer currentPage, Integer pageSize, String chineseName) {
		// TODO Auto-generated method stub DiseaseMapDTO
		PageHelper.startPage(currentPage, pageSize);
		Page<DiseaseMapDTO> showDataCondition = (Page<DiseaseMapDTO>) diseaseMapper.getDiseaseMapDTOByName(chineseName);
		PageObject object = new PageObject<DiseaseDTO>();
		object.setCurrentPage(currentPage);
		object.setParams(showDataCondition.getResult());
		object.setTotal(showDataCondition.getTotal());
		return object;
	}

	private OperateDTO converseToOperataDTO(DiseaseDTO diseaseDTO) {
		OperateDTO operateDTO = new OperateDTO();
		JSONObject json =  JSONObject.parseObject(JSONObject.toJSONString(diseaseDTO));
		operateDTO.setJsonStr(json);
		return operateDTO;
	}
}
