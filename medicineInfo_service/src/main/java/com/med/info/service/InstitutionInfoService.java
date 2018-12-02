package com.med.info.service;

import com.med.info.mapper.domain.InstitutionInfoDTO;

/**
 * Title: 医疗机构信息维护
 * Description: 医疗机构信息维护
 * @author DELETE
 *
 */
public interface InstitutionInfoService {

    /**
     * 添加医疗机构信息
     * @param institutionInfoDTO 医疗机构信息
     * @return 医疗机构id
     */
    Integer addInstitutionInfo(InstitutionInfoDTO institutionInfoDTO);

    /**
     * 修改医疗机构信息
     * @param institutionInfoDTO 医疗机构信息
     * @return 医疗机构id
     */
    Integer updateInstitutionInfo(InstitutionInfoDTO institutionInfoDTO);

    /**
     * 查询医疗机构信息
     * @param institutionId 医疗机构id
     * @return
     */
    InstitutionInfoDTO queryInstitutionInfo(Integer institutionId);
    /**
     * 删除医疗机构信息
     * @param institutionId 医疗机构id
     * @return
     */
    InstitutionInfoDTO deleteInstitutionInfo(Integer institutionId);
}
