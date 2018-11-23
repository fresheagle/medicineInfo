package com.med.info.service.impl;

import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.domain.Miss_combination_diseaseWithBLOBs;
import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.service.DiseaseInfoService;
import com.med.info.service.dto.DiseaseDTO;
import com.med.info.service.dto.DiseaseDepartmentMapDTO;
import com.med.info.service.dto.DiseaseSymptomMapDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DiseaseInfoServiceImp implements DiseaseInfoService {

    @Override
    public Integer addDiseaseInfo(DiseaseDTO diseaseDTO) {
        return null;
    }

    @Override
    public Integer addChineseDiseaseBlogInfo(Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs) {
        return null;
    }

    @Override
    public Integer addWestDiseaseBlogInfo(Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs) {
        return null;
    }

    @Override
    public Integer addCombinationDiseaseBlogInfo(Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs) {
        return null;
    }

    @Override
    public DiseaseDTO queryDiseaseInfo(Integer diseaseId) {
        return null;
    }

    @Override
    public List<Map<Integer, String>> queryDiseaseInfoName() {
        return null;
    }

    @Override
    public List<DiseaseDepartmentMapDTO> queryDepartmentInfo() {
        return null;
    }

    @Override
    public List<DiseaseSymptomMapDTO> querySymptomInfo() {
        return null;
    }

    @Override
    public Miss_chinese_diseaseWithBLOBs queryChineseDiseaseBlogInfo(Integer chinese_diseaseId) {
        return null;
    }

    @Override
    public Miss_western_diseaseWithBLOBs queryWestDiseaseBlogInfo(Integer western_diseaseId) {
        return null;
    }

    @Override
    public Miss_combination_diseaseWithBLOBs queryCombinationDiseaseBlogInfo(Integer combination_diseaseId) {
        return null;
    }

    @Override
    public Integer updateDiseaseInfo(DiseaseDTO diseaseDTO) {
        return null;
    }

    @Override
    public Integer updateChineseDiseaseBlogInfo(Miss_chinese_diseaseWithBLOBs miss_chinese_diseaseWithBLOBs) {
        return null;
    }

    @Override
    public Integer updateWestDiseaseBlogInfo(Miss_western_diseaseWithBLOBs miss_western_diseaseWithBLOBs) {
        return null;
    }

    @Override
    public Integer updateCombinationDiseaseBlogInfo(Miss_combination_diseaseWithBLOBs miss_combination_diseaseWithBLOBs) {
        return null;
    }

    @Override
    public Integer deleteDiseaseInfo(Integer diseaseId) {
        return null;
    }

    @Override
    public Integer deleteChineseDiseaseBlogInfo(Integer chinese_diseaseId) {
        return null;
    }

    @Override
    public Integer deleteWestDiseaseBlogInfo(Integer western_diseaseId) {
        return null;
    }

    @Override
    public Integer deleteCombinationDiseaseBlogInfo(Integer combination_diseaseId) {
        return null;
    }
}
