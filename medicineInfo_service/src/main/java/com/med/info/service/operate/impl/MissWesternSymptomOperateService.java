package com.med.info.service.operate.impl;

import com.alibaba.fastjson.JSONObject;
import com.med.info.domain.Miss_disease_symptom_mapping;
import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.domain.Miss_symptom_dislocation_mapping;
import com.med.info.domain.Miss_symptom_medical_mapping;
import com.med.info.dto.MissInstitutionDTO;
import com.med.info.dto.MissSymptomDTO;
import com.med.info.mapper.Miss_disease_symptom_mappingMapper;
import com.med.info.mapper.Miss_symptom_dislocation_mappingMapper;
import com.med.info.mapper.Miss_symptom_medical_mappingMapper;
import com.med.info.mapper.domain.DislocationMapDTO;
import com.med.info.mapper.domain.MedicalMapDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.mapper.domain.SymptomDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissSymptomService;
import com.med.info.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Order(4)
public class MissWesternSymptomOperateService extends AbstractOperateService<Miss_symptomWithBLOBs, MissSymptomDTO> {

    @Autowired
    private MissSymptomService symptomService;
    @Autowired
    private Miss_symptom_dislocation_mappingMapper symptom_dislocation_mappingMapper;
    @Autowired
    private Miss_disease_symptom_mappingMapper miss_disease_symptom_mappingMapper;

    private static Logger logger = LoggerFactory.getLogger(MissWesternSymptomOperateService.class);

    @Override
    public boolean needDealMapper() {
        return true;
    }

    @Override
    public String getCurrentMenuType() {
        return "missWesternSymptom";
    }

    @Override
    public BaseService<Miss_symptomWithBLOBs> baseService(String menuType) {
        return symptomService;
    } 

    @Override
    public Class<?> getCurrentObjectClass() {
        return MissSymptomDTO.class;
    }

    @Override
    public Miss_symptomWithBLOBs converseObject(MissSymptomDTO missSymptomDTO) {
    	Miss_symptomWithBLOBs miss_symptomWithBLOBs = new Miss_symptomWithBLOBs();
    	BeanUtils.copyProperties(missSymptomDTO, miss_symptomWithBLOBs);
    	return miss_symptomWithBLOBs;
    }
    
    @Override
    protected void dealMapperRelashionShip(MissSymptomDTO objectF) {
    	symptom_dislocation_mappingMapper.deleteBySymptomId(objectF.getId());
    	List<DislocationMapDTO> dislocationList = objectF.getDislocationList();
    	if(CollectionUtil.isNotEmpty(dislocationList)) {
    		for(DislocationMapDTO dislocationMapDTO : dislocationList) {
    			Miss_symptom_dislocation_mapping record = new Miss_symptom_dislocation_mapping();
    			record.setCreateTime(new Date());
    			record.setSymptomId(objectF.getId());
    			record.setDislocationId(dislocationMapDTO.getId());
    			record.setTaskId(objectF.getTaskId());
    			record.setDatastatus(objectF.getDataStatus());
    			record.setTaskStatus(objectF.getTaskStatus());
    			symptom_dislocation_mappingMapper.insert(record);
    		}
    	}
    	miss_disease_symptom_mappingMapper.deleteBySymptomId(objectF.getId());
    	List<Long> chineseDiseaseList = objectF.getChineseDiseaseList();
    	if(CollectionUtil.isNotEmpty(chineseDiseaseList)) {
    		for(Long chineseDiseaseId : chineseDiseaseList) {
    			Miss_disease_symptom_mapping record = new Miss_disease_symptom_mapping();
    			record.setCreateTime(new Date());
    			record.setDiseaseId(chineseDiseaseId);
    			record.setSymptomId(objectF.getId());
    			record.setTaskId(objectF.getTaskId());
    			record.setDatastatus(objectF.getDataStatus());
    			record.setTaskStatus(objectF.getTaskStatus());
    			miss_disease_symptom_mappingMapper.insert(record);
    		}
    	}
    	List<Long> westernDiseaseList = objectF.getWesternDiseaseList();
    	if(CollectionUtil.isNotEmpty(chineseDiseaseList)) {
    		for(Long westernDiseaseId : westernDiseaseList) {
    			Miss_disease_symptom_mapping record = new Miss_disease_symptom_mapping();
    			record.setCreateTime(new Date());
    			record.setDiseaseId(westernDiseaseId);
    			record.setSymptomId(objectF.getId());
    			record.setTaskId(objectF.getTaskId());
    			record.setDatastatus(objectF.getDataStatus());
    			record.setTaskStatus(objectF.getTaskStatus());
    			miss_disease_symptom_mappingMapper.insert(record);
    		}
    	}
    }
//    @Override
//    protected void dealMapperRelashionShip(OperateDTO operateDTO) {
//        {
//            SymptomDTO symptomDTO = JSONObject.toJavaObject(operateDTO.getJsonStr(), SymptomDTO.class);
//            Miss_symptomWithBLOBs miss_symptom = symptomDTO.getMissSymptom();
//            symptom_dislocation_mappingMapper.deleteBySymptomId(miss_symptom.getId());
//            symptom_medical_mappingMapper.deleteBySymptomId(miss_symptom.getId());
//            List<DislocationMapDTO> dislocationList = symptomDTO.getDislocationList();
//            if (CollectionUtil.isNotEmpty(dislocationList)) {
//                for (DislocationMapDTO dislocationMapDTO : dislocationList) {
//                    Miss_symptom_dislocation_mapping record = new Miss_symptom_dislocation_mapping();
//                    record.setCreateTime(new Date());
//                    record.setDislocationId(dislocationMapDTO.getId());
//                    record.setSymptomId(miss_symptom.getId());
//                    symptom_dislocation_mappingMapper.insert(record);
//                }
//            }
//
//            List<MedicalMapDTO> medicalList = symptomDTO.getMedicalList();
//            if (CollectionUtil.isNotEmpty(medicalList)) {
//                for (MedicalMapDTO medicalMapDTO : medicalList) {
//                    Miss_symptom_medical_mapping record = new Miss_symptom_medical_mapping();
//                    record.setCreateTime(new Date());
//                    record.setMedicalId(medicalMapDTO.getId());
//                    record.setSymptomId(miss_symptom.getId());
//                    symptom_medical_mappingMapper.insert(record);
//                }
//            }
//        }
//    }

    @Override
    public String getJsonParamKey() {
        return "missWesternSymptom";
    }

}
