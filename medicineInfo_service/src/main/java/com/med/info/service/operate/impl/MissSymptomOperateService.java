package com.med.info.service.operate.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_symptom;
import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.domain.Miss_symptom_dislocation_mapping;
import com.med.info.domain.Miss_symptom_medical_mapping;
import com.med.info.mapper.Miss_symptom_dislocation_mappingMapper;
import com.med.info.mapper.Miss_symptom_medical_mappingMapper;
import com.med.info.mapper.domain.DislocationMapDTO;
import com.med.info.mapper.domain.MedicalMapDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.mapper.domain.SymptomDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissSymptomService;
import com.med.info.utils.CollectionUtil;
import com.med.info.utils.OperateEnum;

@Component
@Order(11)
public class MissSymptomOperateService extends AbstractOperateService<Miss_symptomWithBLOBs>{

	@Autowired
	private MissSymptomService symptomService;
	@Autowired private Miss_symptom_dislocation_mappingMapper symptom_dislocation_mappingMapper;
	@Autowired private Miss_symptom_medical_mappingMapper symptom_medical_mappingMapper;
	private static Logger logger = LoggerFactory.getLogger(MissSymptomOperateService.class);
	
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "missSymptom";
	}

	@Override
	public BaseService<Miss_symptomWithBLOBs> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return symptomService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_symptomWithBLOBs.class;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.operate.impl.AbstractOperateService#fishDeal(com.med.info.mapper.domain.OperateDTO)
	 */
	@Override
	public void finishDeal(OperateDTO operateDTO) {
		SymptomDTO symptomDTO = JSONObject.toJavaObject(operateDTO.getJsonStr(), SymptomDTO.class);
		Miss_symptomWithBLOBs miss_symptom = symptomDTO.getMissSymptom();
		if(!operateDTO.getTaskType().equals(OperateEnum.delete.toString())) {
			symptomService.updateByPrimaryKey(miss_symptom);
			symptom_dislocation_mappingMapper.deleteBySymptomId(miss_symptom.getId());
			symptom_medical_mappingMapper.deleteBySymptomId(miss_symptom.getId());
			List<DislocationMapDTO> dislocationList = symptomDTO.getDislocationList();
			if(CollectionUtil.isNotEmpty(dislocationList)) {
				for (DislocationMapDTO dislocationMapDTO : dislocationList) {
					Miss_symptom_dislocation_mapping record = new Miss_symptom_dislocation_mapping();
					record.setCreateTime(new Date());
					record.setDislocationId(dislocationMapDTO.getId());
					record.setSymptomId(miss_symptom.getId());
					symptom_dislocation_mappingMapper.insert(record );
				}
			}
			
			List<MedicalMapDTO> medicalList = symptomDTO.getMedicalList();
			if(CollectionUtil.isNotEmpty(medicalList)) {
				for (MedicalMapDTO medicalMapDTO : medicalList) {
					Miss_symptom_medical_mapping record = new Miss_symptom_medical_mapping();
					record.setCreateTime(new Date());
					record.setMedicalId(medicalMapDTO.getId().intValue());
					record.setSymptomId(miss_symptom.getId().intValue());
					symptom_medical_mappingMapper.insert(record );
				}
			}
		}else {
			logger.info(getCurrentMenuType()+"当前操作为"+operateDTO.getTaskType()+",修改状态为回收站");
			symptom_dislocation_mappingMapper.deleteBySymptomId(miss_symptom.getId());
			symptom_medical_mappingMapper.deleteBySymptomId(miss_symptom.getId());
			miss_symptom.setTaskId(operateDTO.getTaskId());
			miss_symptom.setTaskJson(JSON.toJSONString(operateDTO.getJsonStr()));
			miss_symptom.setTaskStatus(operateDTO.getTaskStatus());
			miss_symptom.setDatastatus("-1");
			symptomService.updateByTaskIdSelective(miss_symptom);
		}
	}

	@Override
	public String getJsonParamKey() {
		// TODO Auto-generated method stub
		return "missSymptom";
	}

}
