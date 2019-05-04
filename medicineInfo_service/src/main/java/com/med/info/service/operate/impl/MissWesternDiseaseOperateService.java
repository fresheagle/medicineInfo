package com.med.info.service.operate.impl;

import com.med.info.domain.Miss_diseaseWithBLOBs;
import com.med.info.domain.Miss_disease_department_mapping;
import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.dto.MissWesternDiseaseDTO;
import com.med.info.mapper.Miss_diseaseMapper;
import com.med.info.mapper.Miss_disease_department_mappingMapper;
import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissWesternDiseaseService;
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
@Order(5)
public class MissWesternDiseaseOperateService extends AbstractOperateService<Miss_western_diseaseWithBLOBs, MissWesternDiseaseDTO> {

    @Autowired
    private MissWesternDiseaseService westernDiseaseService;
    @Autowired
    private Miss_diseaseMapper miss_diseaseMapper;
    @Autowired
    private Miss_disease_department_mappingMapper miss_disease_department_mappingMapper;
    private static Logger logger = LoggerFactory.getLogger(MissWesternDiseaseOperateService.class);
    @Override
    public String getCurrentMenuType() {
        return "missWsetDisease";
    }

    @Override
    public BaseService<Miss_western_diseaseWithBLOBs> baseService(String menuType) {
        return westernDiseaseService;
    }

    @Override
    public Miss_western_diseaseWithBLOBs converseObject(MissWesternDiseaseDTO missWesternDiseaseDTO) {
    	Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs = new Miss_western_diseaseWithBLOBs();
    	BeanUtils.copyProperties(missWesternDiseaseDTO,miss_western_diseaseWithBLOBs);
    	return miss_western_diseaseWithBLOBs;
    }
    
    @Override
    protected void dealMapperRelashionShip(MissWesternDiseaseDTO missWesternDiseaseDTO) {
    	miss_diseaseMapper.deleteByPrimaryKey(missWesternDiseaseDTO.getId());
    	Miss_diseaseWithBLOBs miss_disease = new Miss_diseaseWithBLOBs();
    	miss_disease.setId(missWesternDiseaseDTO.getId());
    	miss_disease.setCreateTime(new Date());
    	miss_disease.setTaskId(missWesternDiseaseDTO.getTaskId());
    	miss_disease.setDatastatus(missWesternDiseaseDTO.getDataStatus());
    	miss_disease.setTaskStatus(missWesternDiseaseDTO.getTaskStatus());
    	miss_diseaseMapper.insert(miss_disease);
    	
    	List<DepartmentMapDTO> departmentMapDTO = missWesternDiseaseDTO.getDepartmentMapDTO();
    	if(CollectionUtil.isNotEmpty(departmentMapDTO)) {
    		miss_disease_department_mappingMapper.deleteByDiseaseId(missWesternDiseaseDTO.getId());
    		for (DepartmentMapDTO departmentMapDTO2 : departmentMapDTO) {
    			Miss_disease_department_mapping record = new Miss_disease_department_mapping();
    			record.setCreateTime(new Date());
    			record.setDiseaseId(missWesternDiseaseDTO.getId());
    			record.setDepartmentId(departmentMapDTO2.getId());
    			record.setDatastatus(missWesternDiseaseDTO.getDataStatus());
    			record.setTaskId(missWesternDiseaseDTO.getTaskId());
    			record.setTaskStatus(missWesternDiseaseDTO.getDataStatus());
    			miss_disease_department_mappingMapper.insert(record);
    		}
    	}
    }
    
    @Override
    public boolean needDealMapper() {
        return true;
    }

    @Override
    public Class<?> getCurrentObjectClass() {
        return MissWesternDiseaseDTO.class;
    }

    @Override
    public String getJsonParamKey() {
        return "missWsetDisease";
    }

}
