package com.med.info.service.impl;

import com.med.info.domain.Miss_medicalWithBLOBs;
import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_medicalMapper;
import com.med.info.mapper.domain.MedicalDTO;
import com.med.info.mapper.domain.MedicalMapDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissMedicalCompanyService;
import com.med.info.service.MissMedicalService;
import com.med.info.utils.CollectionUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MissMedicalServiceImpl extends BaseServiceImpl<Miss_medicalWithBLOBs> implements MissMedicalService {

    @Autowired
    private Miss_medicalMapper medicalMapper;

    @Autowired
    private MissMedicalCompanyService medicalCompanyService;

    @Override
    public BaseMapper getMapper() {
        // TODO Auto-generated method stub
        return medicalMapper;
    }

    @Override
    public List<MedicalMapDTO> getMedicalMapDTOBySymptomId(Long id) {
        // TODO Auto-generated method stub
        return medicalMapper.getMedicalMapDTOBySymptomId(id);
    }

    @Override
    public Object getByPage(Integer currentPage, Integer pageSize, String name, String chinesePinyin, String alisaName, String shopName, String englishName) {
        Miss_medicalWithBLOBs miss_medical = new Miss_medicalWithBLOBs();
        miss_medical.setComName(name);
        miss_medical.setChinesePinyin(chinesePinyin);
        miss_medical.setAlisaName(alisaName);
        miss_medical.setShopName(shopName);
        miss_medical.setEnglishName(englishName);
        PageObject<Miss_medicalWithBLOBs> selectPage = super.selectPage(currentPage, pageSize, miss_medical);
        List<Miss_medicalWithBLOBs> params = selectPage.getParams();

        PageObject<OperateDTO> pageObject = new PageObject<>();
        pageObject.setCurrentPage(selectPage.getCurrentPage());
        pageObject.setTotal(selectPage.getTotal());
        List<OperateDTO> list = new ArrayList<>();
        for (Miss_medicalWithBLOBs miss_doctorWithBLOBs : params) {
            list.add(converseToOperataDTO(geMedicalMapDTO(miss_doctorWithBLOBs)));
        }
        pageObject.setParams(list);
        return pageObject;
    }

    private MedicalDTO geMedicalMapDTO(Miss_medicalWithBLOBs miss_medicalWithBLOBs) {
        MedicalDTO medicalDTO = new MedicalDTO();
        medicalDTO.setMissMedical(miss_medicalWithBLOBs);
        medicalDTO.setMedicalCompanyList(medicalCompanyService.getCompanyByMedicalId(miss_medicalWithBLOBs.getId()));
        return medicalDTO;
    }

    @Override
    public String getKeyName() {
        return "missMedical";
    }

	@Override
	public String checkMedicalInfo(String comName, String englishName, String chinesePinyin, String shopName)
			throws Exception {
		// TODO Auto-generated method stub
		List<Miss_medicalWithBLOBs> miss_medicalWithBLOBs = medicalMapper.check(comName, englishName, chinesePinyin, shopName);
		if(!CollectionUtil.isNotEmpty(miss_medicalWithBLOBs)){
			return UUID.randomUUID().toString().replace("-", "");
		}
		throw new Exception("该药品信息已经存在！");
	}
}
