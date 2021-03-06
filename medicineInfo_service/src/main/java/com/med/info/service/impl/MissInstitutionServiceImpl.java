package com.med.info.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.med.info.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_institutionMapper;
import com.med.info.mapper.domain.InstitutionInfoDTO;
import com.med.info.mapper.domain.InstitutionInfoMapDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissDepartmentService;
import com.med.info.service.MissInstitutionService;

@Service
public class MissInstitutionServiceImpl extends BaseServiceImpl<Miss_institutionWithBLOBs>
		implements MissInstitutionService {

	@Autowired
	private Miss_institutionMapper institutionMapper;
	@Autowired
	private MissDepartmentService missDepartmentService;

	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return institutionMapper;
	}

	@Override
	public List<InstitutionInfoMapDTO> getInstitutionInfoMapDTOByDoctorId(Long id) {
		return institutionMapper.getInstitutionInfoMapDTOByDoctorId(id);
	}

	@Override
	public Object getByPage(Integer currentPage, Integer pageSize, String name, String level,
			String address, String category) {
		Miss_institutionWithBLOBs institutionWithBLOBs = new Miss_institutionWithBLOBs();
		institutionWithBLOBs.setName(name);
		institutionWithBLOBs.setLevel(level);
		institutionWithBLOBs.setAddress(address);
		institutionWithBLOBs.setCategory(category);
		PageObject<Miss_institutionWithBLOBs> selectPage = super.selectPage(currentPage, pageSize,
				institutionWithBLOBs);
		List<Miss_institutionWithBLOBs> params = selectPage.getParams();
		
		PageObject<OperateDTO> result = new PageObject<>();
		result.setCurrentPage(selectPage.getCurrentPage());
		result.setTotal(selectPage.getTotal());
		List<OperateDTO> reultList = new ArrayList<>();
		for (Miss_institutionWithBLOBs miss_institutionWithBLOBs : params) {
			reultList.add(converseToOperataDTO(getInstitutionInfoDTO(miss_institutionWithBLOBs)));
		}
		result.setParams(reultList);
		return result;
	}

	private InstitutionInfoDTO getInstitutionInfoDTO(Miss_institutionWithBLOBs miss_institutionWithBLOBs) {
		InstitutionInfoDTO institutionInfoDTO = new InstitutionInfoDTO();
		institutionInfoDTO.setDepartmentMapDTO(missDepartmentService.getDepartmentMapByInstitutionId(miss_institutionWithBLOBs.getId()));
		institutionInfoDTO.setMissInstitution(miss_institutionWithBLOBs);
		return institutionInfoDTO;
	}

	@Override
	public String checkInstitutionInfo(String name, String website) throws Exception {

		List<Miss_institutionWithBLOBs> institutionWithBLOBs = institutionMapper.check(name, website);
		if(!CollectionUtil.isNotEmpty(institutionWithBLOBs)){
			return UUID.randomUUID().toString().replace("-", "");
		}
		throw new Exception("该医院信息已经存在！");
	}

    @Override
    public List<InstitutionInfoMapDTO> getByName(String name) {
		return institutionMapper.getInstitutionInfoMapsByName(name);

    }

    @Override
	public String getKeyName() {
		return "missInstitution";
	}
}
