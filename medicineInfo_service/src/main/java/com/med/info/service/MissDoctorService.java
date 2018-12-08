package com.med.info.service;

import com.med.info.domain.Miss_doctorWithBLOBs;

public interface MissDoctorService extends BaseService<Miss_doctorWithBLOBs>{

	
	/**
	 * 根据医生姓名或男女查询对应医生page
	 * @param currentPage
	 * @param pageSize
	 * @param name
	 * @param institutionName
	 * @return
	 */
	public Object getByPage(Integer currentPage, Integer pageSize, String name, String sex, String graduate, String profession, String origin);
}
