package com.med.info.service.operate.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.dto.MissSymptomDTO;
import com.med.info.mapper.Miss_symptom_dislocation_mappingMapper;
import com.med.info.mapper.Miss_symptom_medical_mappingMapper;
import com.med.info.service.BaseService;
import com.med.info.service.MissSymptomService;

@Component
@Order(7)
public class MissChineseSymptomOperateService extends AbstractOperateService<Miss_symptomWithBLOBs, MissSymptomDTO> {
    @Autowired
    private MissSymptomService symptomService;
    @Autowired
    private Miss_symptom_dislocation_mappingMapper symptom_dislocation_mappingMapper;
    @Autowired
    private Miss_symptom_medical_mappingMapper symptom_medical_mappingMapper;
    private static Logger logger = LoggerFactory.getLogger(MissWesternSymptomOperateService.class);

    @Override
    public boolean needDealMapper() {
        return true;
    }

    @Override
    public String getCurrentMenuType() {
        return "missSymptom";
    }

    @Override
    public BaseService<Miss_symptomWithBLOBs> baseService(String menuType) {
        return symptomService;
    }

    @Override
    public Class<?> getCurrentObjectClass() {
        return Miss_symptomWithBLOBs.class;
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
        return "missSymptom";
    }

}

