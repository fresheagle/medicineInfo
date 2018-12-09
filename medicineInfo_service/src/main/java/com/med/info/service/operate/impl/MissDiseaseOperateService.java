package com.med.info.service.operate.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_control_task_detailWithBLOBs;
import com.med.info.domain.Miss_disease;
import com.med.info.domain.Miss_diseaseWithBLOBs;
import com.med.info.domain.Miss_disease_department_mapping;
import com.med.info.domain.Miss_disease_symptom_mapping;
import com.med.info.mapper.Miss_disease_department_mappingMapper;
import com.med.info.mapper.Miss_disease_symptom_mappingMapper;
import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.DiseaseDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.mapper.domain.SymptomMapDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissDiseaseService;
import com.med.info.utils.CollectionUtil;
import com.med.info.utils.OperateEnum;

@Component
@Order(5)
public class MissDiseaseOperateService extends AbstractOperateService<Miss_diseaseWithBLOBs>{

	@Autowired
	private MissDiseaseService diseaseService;
	@Autowired
	private Miss_disease_department_mappingMapper miss_disease_department_mappingMapper;
	@Autowired
	private Miss_disease_symptom_mappingMapper miss_disease_symptom_mappingMapper;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(MissDiseaseOperateService.class);
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "missDisease";
	}

	@Override
	public BaseService<Miss_diseaseWithBLOBs> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return diseaseService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_diseaseWithBLOBs.class;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.operate.impl.AbstractOperateService#fishDeal(com.med.info.mapper.domain.OperateDTO)
	 */
	@Override
	public void finishDeal(OperateDTO operateDTO) {

		DiseaseDTO diseaseDTO = JSONObject.toJavaObject(operateDTO.getJsonStr(), DiseaseDTO.class);
		Long id = diseaseDTO.getMissDisease().getId();
		if(!operateDTO.getTaskType().equals(OperateEnum.delete.toString())) {
			logger.info(getCurrentMenuType()+"当前操作为"+operateDTO.getTaskType()+"入库数据");
			Miss_diseaseWithBLOBs missDisease = diseaseDTO.getMissDisease();
			int updateByPrimaryKey = diseaseService.updateByPrimaryKey(missDisease);
			List<DepartmentMapDTO> departmentMapDTO = diseaseDTO.getDepartmentMapDTO();
			List<SymptomMapDTO> symptomMapDTO = diseaseDTO.getSymptomMapDTO();
			
			miss_disease_department_mappingMapper.deleteByDiseaseId(id);
			miss_disease_symptom_mappingMapper.deleteByDiseaseId(id);
			
			if(CollectionUtil.isNotEmpty(symptomMapDTO)) {
				for (SymptomMapDTO symptomMapDTO2 : symptomMapDTO) {
					Miss_disease_symptom_mapping record = new Miss_disease_symptom_mapping();
					record.setCreateTime(new Timestamp(System.currentTimeMillis()));
					record.setSymptomId(symptomMapDTO2.getId().intValue());
					record.setDiseaseId(id.intValue());
					miss_disease_symptom_mappingMapper.insert(record );
				}
			}
			if(CollectionUtil.isNotEmpty(departmentMapDTO)) {
				for (DepartmentMapDTO departmentMapDTO2 : departmentMapDTO) {
					Miss_disease_department_mapping record = new Miss_disease_department_mapping();
					record.setCreateTime(new Timestamp(System.currentTimeMillis()));
					record.setDepartmentId(departmentMapDTO2.getId());
					record.setDiseaseId(id);
					miss_disease_department_mappingMapper.insert(record );
				}
			}
			
		}else {
			logger.info(getCurrentMenuType()+"当前操作为"+operateDTO.getTaskType()+",修改状态为回收站");
			miss_disease_department_mappingMapper.deleteByDiseaseId(id);
			miss_disease_symptom_mappingMapper.deleteByDiseaseId(id);
			Miss_diseaseWithBLOBs object = diseaseDTO.getMissDisease();
			object.setTaskId(operateDTO.getTaskId());
			object.setTaskJson(JSON.toJSONString(operateDTO.getJsonStr()));
			object.setTaskStatus(operateDTO.getTaskStatus());
			object.setDatastatus("-1");
			diseaseService.updateByTaskIdSelective(object);
		}
		
	}

	@Override
	public String getJsonParamKey() {
		// TODO Auto-generated method stub
		return "missDisease";
	}

}
