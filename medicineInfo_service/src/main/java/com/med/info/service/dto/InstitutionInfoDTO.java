package com.med.info.service.dto;

import com.med.info.domain.Miss_institutionWithBLOBs;

import java.io.Serializable;
import java.util.List;

/**
 * 医疗机构信息传输实体类
 * @author zhangmin
 */
public class InstitutionInfoDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Miss_institutionWithBLOBs miss_institutionWithBLOBs;
    private List<DepartmentMapDTO> institution_department_mapping_list;

    public Miss_institutionWithBLOBs getMiss_institutionWithBLOBs() {
        return miss_institutionWithBLOBs;
    }

    public void setMiss_institutionWithBLOBs(Miss_institutionWithBLOBs miss_institutionWithBLOBs) {
        this.miss_institutionWithBLOBs = miss_institutionWithBLOBs;
    }

    public List<DepartmentMapDTO> getInstitution_department_mapping_list() {
        return institution_department_mapping_list;
    }

    public void setInstitution_department_mapping_list(List<DepartmentMapDTO> institution_department_mapping_list) {
        this.institution_department_mapping_list = institution_department_mapping_list;
    }
}
