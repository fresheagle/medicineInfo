package com.med.info.service.operate.impl;

import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_medicalWithBLOBs;
import com.med.info.domain.Miss_medical_medicalcompany_mapping;
import com.med.info.mapper.Miss_medical_medicalcompany_mappingMapper;
import com.med.info.mapper.domain.MedicalCompanyMapDTO;
import com.med.info.mapper.domain.MedicalDTO;
import com.med.info.utils.CollectionUtil;
import com.med.info.utils.OperateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_medical;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissMedicalService;

import java.util.Date;
import java.util.List;

@Component
@Order(10)
public class MissMedicalOperateService extends AbstractOperateService<Miss_medical>{

	@Autowired
	private MissMedicalService medicalService;
	@Autowired
	private Miss_medical_medicalcompany_mappingMapper medicalMedicalcompanyMappingMapper;
	
	@Override
	public String getCurrentMenuType() {
		return "missMedical";
	}

	@Override
	public BaseService<Miss_medical> baseService(String menuType) {
		return medicalService;
	}

	@Override
	public Class<?> getCurrentClass() {
		return Miss_medical.class;
	}

	@Override
	protected void dealMapperRelashionShip(OperateDTO operateDTO) {
		MedicalDTO medicalDTO = JSONObject.toJavaObject(operateDTO.getJsonStr(), MedicalDTO.class);
		Miss_medicalWithBLOBs miss_medical = medicalDTO.getMiss_medical();
		medicalMedicalcompanyMappingMapper.deleteByMedicalId(miss_medical.getId());
		if(!operateDTO.getTaskType().equals(OperateEnum.delete.toString())){
			List<MedicalCompanyMapDTO> medicalCompanyList = medicalDTO.getMedicalCompanyList();
			if(CollectionUtil.isNotEmpty(medicalCompanyList)){
				for (MedicalCompanyMapDTO medicalCompanyMapDTO : medicalCompanyList) {
					Miss_medical_medicalcompany_mapping record = new Miss_medical_medicalcompany_mapping();
					record.setMedicalCompanyId(medicalCompanyMapDTO.getMedicalCompany_id());
					record.setMedicalId(miss_medical.getId());
					record.setCreateTime(new Date());
					medicalMedicalcompanyMappingMapper.insert(record);
				}
			}
		}
	}

	@Override
	public String getJsonParamKey() {
		return "missMedical";
	}

	@Override
	public boolean needDealMapper() {
		return true;
	}
}
