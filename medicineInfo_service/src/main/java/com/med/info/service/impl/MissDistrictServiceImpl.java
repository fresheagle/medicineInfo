package com.med.info.service.impl;

import com.med.info.mapper.domain.DislocationMapDTO;
import com.med.info.mapper.domain.DistrictMapDTO;
import com.med.info.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_district;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_districtMapper;
import com.med.info.service.MissDistrictService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MissDistrictServiceImpl extends BaseServiceImpl<Miss_district> implements MissDistrictService {

	@Autowired
	private Miss_districtMapper districtMapper;

	@Override
	public BaseMapper getMapper() {
		return districtMapper;
	}

	@Override
	public String getKeyName() {
		return "missDistrict";
	}


	@Override
	public List<DistrictMapDTO> selectDistrict(Long parentId, String level) {
		List<DistrictMapDTO> dislocationMapDTOS = new ArrayList<>();
		List<Miss_district> missDistricts = districtMapper.selectDistrict(parentId, level);
		if(CollectionUtil.isNotEmpty(missDistricts)){
			for (Miss_district missDistrict : missDistricts) {
				DistrictMapDTO districtMapDTO = new DistrictMapDTO();
				districtMapDTO.setDistrictCode(missDistrict.getDistrictCode());
				districtMapDTO.setDistrictName(missDistrict.getDistrictName());
				districtMapDTO.setId(missDistrict.getId());
				districtMapDTO.setLevel(missDistrict.getLevel());
				dislocationMapDTOS.add(districtMapDTO);
			}
		}
		return dislocationMapDTOS;
	}
}
