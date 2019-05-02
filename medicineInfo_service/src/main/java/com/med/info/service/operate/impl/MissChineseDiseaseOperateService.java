package com.med.info.service.operate.impl;

import com.alibaba.fastjson.JSON;
import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.domain.Miss_disease;
import com.med.info.domain.Miss_diseaseWithBLOBs;
import com.med.info.domain.Miss_disease_department_mapping;
import com.med.info.dto.MissChineseDiseaseDTO;
import com.med.info.mapper.Miss_diseaseMapper;
import com.med.info.mapper.Miss_disease_department_mappingMapper;
import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissChineseDiseaseService;
import com.med.info.utils.CollectionUtil;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MissChineseDiseaseOperateService extends AbstractOperateService<Miss_chinese_diseaseWithBLOBs, MissChineseDiseaseDTO> {

    @Autowired
    private MissChineseDiseaseService chineseDiseaseService;
    @Autowired
    private Miss_diseaseMapper miss_diseaseMapper;
    @Autowired
    private Miss_disease_department_mappingMapper miss_disease_department_mappingMapper;
    private static Logger logger = LoggerFactory.getLogger(MissChineseDiseaseOperateService.class);

    @Override
    public String getCurrentMenuType() {
        return "missChineseDisease";
    }

    @Override
    public BaseService<Miss_chinese_diseaseWithBLOBs> baseService(String menuType) {
        return chineseDiseaseService;
    }

    @Override
    public Class<?> getCurrentObjectClass() {
        return MissChineseDiseaseDTO.class;
    }

    @Override
    public Miss_chinese_diseaseWithBLOBs converseObject(MissChineseDiseaseDTO missChineseDiseaseDTO) {
    	Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs = new Miss_chinese_diseaseWithBLOBs();
    	BeanUtils.copyProperties(missChineseDiseaseDTO,miss_chinese_diseaseWithBLOBs);
    	miss_chinese_diseaseWithBLOBs.setSyndromeType(JSON.toJSONString(missChineseDiseaseDTO.getSyndromeType()));
    	return miss_chinese_diseaseWithBLOBs;
    }

    @Override
    protected void dealMapperRelashionShip(MissChineseDiseaseDTO MissChineseDiseaseDTO) {
    	miss_diseaseMapper.deleteByPrimaryKey(MissChineseDiseaseDTO.getId());
    	Miss_diseaseWithBLOBs miss_disease = new Miss_diseaseWithBLOBs();
    	miss_disease.setId(MissChineseDiseaseDTO.getId());
    	miss_disease.setCreateTime(new Date());
    	miss_disease.setTaskId(MissChineseDiseaseDTO.getTaskId());
    	miss_disease.setDatastatus(MissChineseDiseaseDTO.getDataStatus());
    	miss_disease.setTaskStatus(MissChineseDiseaseDTO.getTaskStatus());
    	miss_diseaseMapper.insert(miss_disease);
    	
    	List<DepartmentMapDTO> departmentMapDTO = MissChineseDiseaseDTO.getDepartmentMapDTO();
    	if(CollectionUtil.isNotEmpty(departmentMapDTO)) {
    		miss_disease_department_mappingMapper.deleteByDiseaseId(MissChineseDiseaseDTO.getId());
    		for (DepartmentMapDTO departmentMapDTO2 : departmentMapDTO) {
    			Miss_disease_department_mapping record = new Miss_disease_department_mapping();
    			record.setCreateTime(new Date());
    			record.setDiseaseId(MissChineseDiseaseDTO.getId());
    			record.setDepartmentId(departmentMapDTO2.getId());
    			record.setDatastatus(MissChineseDiseaseDTO.getDataStatus());
    			record.setTaskId(MissChineseDiseaseDTO.getTaskId());
    			record.setTaskStatus(MissChineseDiseaseDTO.getDataStatus());
    			miss_disease_department_mappingMapper.insert(record);
    		}
    	}
    }
    
    @Override
    public boolean needDealMapper() {
        return true;
    }


    @Override
    public String getJsonParamKey() {
        return "missChineseDisease";
    }

}
