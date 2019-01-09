package com.med.info.service;

import com.med.info.domain.Miss_district;
import com.med.info.mapper.domain.DislocationMapDTO;
import com.med.info.mapper.domain.DistrictMapDTO;

import java.util.List;

public interface MissDistrictService extends BaseService<Miss_district>{


    List<DistrictMapDTO> selectDistrict(Long parentId, String level);
}
