package com.med.info.service;

import java.util.List;

import com.med.info.domain.Miss_department;
import com.med.info.mapper.domain.DepartmentMapDTO;

public interface MissDepartmentService extends BaseService<Miss_department>{
	
	 List<DepartmentMapDTO> getDepartmentMapByIds(List<Long> ids);

}
