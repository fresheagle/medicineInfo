package com.med.info.service;

import com.med.info.domain.Miss_district;

public interface MissDistrictService extends BaseService<Miss_district>{
	
	public Miss_district createTask(Miss_district district, String taskTitle, String taskType, String taskMenuType);
	
	public Miss_district submitTask(Miss_district district, String taskTitle, String taskType, String taskMenuType);
	
	public void firstTrial(Miss_district district, String taskMenuType);
	
	public void secondTrial(Miss_district district, String taskMenuType);
	
	public void finalTrial(Miss_district district, String taskMenuType);
	
	public void publishData(Miss_district district, String taskMenuType);
	

}
