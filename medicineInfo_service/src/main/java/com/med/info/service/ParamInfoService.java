package com.med.info.service;

import java.util.List;
import java.util.Map;

import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.SymptomMapDTO;

/**
 * Title: 列表参数查询服务
 * Description: 列表参数查询服务
 * @author DELETE
 *
 */
public interface ParamInfoService {
    /**
     * 查询疾病id与名称
     * @param
     * @return 疾病基础信息的id和名称列表
     */
    List<Map<Integer,String>> queryDiseaseInfoName();

    /**
     * 查询医疗机构id与名称
     * @param
     * @return 医疗机构信息的id和名称列表
     */
    List<Map<Integer,String>> queryInstitutionInfoName();

    /**
     * 查询疾病相关科室部门信息
     * @param
     * @return 疾病相关科室部门信息
     */
    List<DepartmentMapDTO> queryDepartmentInfo();

    /**
     * 查询疾病相关症状信息
     * @param
     * @return 疾病相关症状信息
     */
    List<SymptomMapDTO> querySymptomInfo();

}
