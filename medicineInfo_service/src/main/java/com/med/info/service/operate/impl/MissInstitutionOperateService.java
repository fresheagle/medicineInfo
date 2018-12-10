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
import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.domain.Miss_institution_keypartment_mapping;
import com.med.info.mapper.Miss_institution_keypartment_mappingMapper;
import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.InstitutionInfoDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.service.BaseService;
import com.med.info.service.MissInstitutionService;
import com.med.info.utils.CollectionUtil;
import com.med.info.utils.OperateEnum;

@Component
@Order(8)
public class MissInstitutionOperateService extends AbstractOperateService<Miss_institutionWithBLOBs>{

	@Autowired
	private MissInstitutionService institutionService;
	
	@Autowired private Miss_institution_keypartment_mappingMapper institution_keypartment_mappingMapper;
			   private static Logger logger = LoggerFactory.getLogger(MissInstitutionOperateService.class);
	@Override
	public String getCurrentMenuType() {
		// TODO Auto-generated method stub
		return "missInstitution";
	}

	@Override
	public BaseService<Miss_institutionWithBLOBs> getBaseService(String menuType) {
		// TODO Auto-generated method stub
		return institutionService;
	}

	@Override
	public Class<?> getCurrentClass() {
		// TODO Auto-generated method stub
		return Miss_institutionWithBLOBs.class;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.operate.impl.AbstractOperateService#fishDeal(com.med.info.mapper.domain.OperateDTO)
	 */
	@Override
	public void finishDeal(OperateDTO operateDTO) {
		InstitutionInfoDTO javaObject = JSONObject.toJavaObject(operateDTO.getJsonStr(), InstitutionInfoDTO.class);
		Miss_institutionWithBLOBs missInstitutionWithBLOBs = javaObject.getMissInstitutionWithBLOBs();
		if(!operateDTO.getTaskType().equals(OperateEnum.delete.toString())) {
			institutionService.updateByPrimaryKey(missInstitutionWithBLOBs);
			institution_keypartment_mappingMapper.deleteByInstitutionId(missInstitutionWithBLOBs.getId());
			List<DepartmentMapDTO> departmentMapDTO = javaObject.getDepartmentMapDTO();
			if(CollectionUtil.isNotEmpty(departmentMapDTO)) {
				for (DepartmentMapDTO departmentMapDTO2 : departmentMapDTO) {
					Miss_institution_keypartment_mapping record = new Miss_institution_keypartment_mapping();
					record.setCreateTime(new Date());
					record.setInstitutionId(missInstitutionWithBLOBs.getId());
					record.setDepartmentId(departmentMapDTO2.getId());
					institution_keypartment_mappingMapper.insert(record );
				}
			}
		}else {
			logger.info(getCurrentMenuType()+"当前操作为"+operateDTO.getTaskType()+",修改状态为回收站");
			institution_keypartment_mappingMapper.deleteByInstitutionId(missInstitutionWithBLOBs.getId());
			missInstitutionWithBLOBs.setTaskId(operateDTO.getTaskId());
			missInstitutionWithBLOBs.setTaskJson(JSON.toJSONString(operateDTO.getJsonStr()));
			missInstitutionWithBLOBs.setTaskStatus(operateDTO.getTaskStatus());
			missInstitutionWithBLOBs.setDatastatus("-1");
			institutionService.updateByTaskIdSelective(missInstitutionWithBLOBs);
		}
	}

	@Override
	public String getJsonParamKey() {
		// TODO Auto-generated method stub
		return "missInstitution";
	}

}
