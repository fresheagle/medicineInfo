package com.med.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.med.info.domain.Miss_dislocation;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_dislocationMapper;
import com.med.info.mapper.domain.DislocationMapDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissDislocationService;

@Service
public class MissDislocationServiceImpl extends BaseServiceImpl<Miss_dislocation> implements MissDislocationService{

	@Autowired
	private Miss_dislocationMapper dislocationMapper;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return dislocationMapper;
	}

	@Override
	public Object getDislocationMapDTOByName(Integer currentPage, Integer pageSize, Long id, Long parentDislocationId, String dislocationName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		DislocationMapDTO dislocationMapDTO = new DislocationMapDTO();
		if(id != null) {
			dislocationMapDTO.setId(id);
		}if(parentDislocationId != null) {
			dislocationMapDTO.setParent_dislocation_id(parentDislocationId);
		}if(dislocationName != null) {
			dislocationMapDTO.setDislocation_name(dislocationName);
		}
		Page<DislocationMapDTO> showDataCondition = (Page<DislocationMapDTO>)dislocationMapper.queryDislocationParam(dislocationMapDTO);
		PageObject object = new PageObject<DislocationMapDTO>();
		object.setCurrentPage(currentPage);
		object.setTotal(showDataCondition.getTotal());
		object.setParams(showDataCondition.getResult());
		return object;
	}

	@Override
	public List<DislocationMapDTO> getDislocationMapDTOBySymptomId(Long id) {
		return dislocationMapper.getDislocationMapDTOBySymptomId(id);
	}

}
