package com.med.info.mapper.domain;

import com.med.info.domain.Miss_institutionWithBLOBs;

import java.io.Serializable;
import java.util.List;

/**
 * 医疗机构信息传输实体类
 * @author zhangmin
 */
public class InstitutionInfoDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Miss_institutionWithBLOBs missInstitutionWithBLOBs;
    private List<DepartmentMapDTO> departmentMapDTO;
	public Miss_institutionWithBLOBs getMissInstitutionWithBLOBs() {
		return missInstitutionWithBLOBs;
	}
	public void setMissInstitutionWithBLOBs(Miss_institutionWithBLOBs missInstitutionWithBLOBs) {
		this.missInstitutionWithBLOBs = missInstitutionWithBLOBs;
	}
	public List<DepartmentMapDTO> getDepartmentMapDTO() {
		return departmentMapDTO;
	}
	public void setDepartmentMapDTO(List<DepartmentMapDTO> departmentMapDTO) {
		this.departmentMapDTO = departmentMapDTO;
	}

   
}
