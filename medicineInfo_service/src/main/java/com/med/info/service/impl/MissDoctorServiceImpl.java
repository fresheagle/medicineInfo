package com.med.info.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.med.info.domain.Miss_doctorWithBLOBs;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_doctorMapper;
import com.med.info.mapper.domain.DiseaseDTO;
import com.med.info.mapper.domain.DoctorDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissDepartmentService;
import com.med.info.service.MissDoctorService;
import com.med.info.service.MissInstitutionService;

@Service
public class MissDoctorServiceImpl extends BaseServiceImpl<Miss_doctorWithBLOBs> implements MissDoctorService {

	@Autowired
	private Miss_doctorMapper doctorMapper;
	@Autowired
	private MissDepartmentService missDepartmentService;
	@Autowired
	private MissInstitutionService missInstitutionService;
	
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return doctorMapper;
	}

	@Override
	public Object getByPage(Integer currentPage, Integer pageSize, String name, String sex, String graduate, String profession, String origin) {
		Miss_doctorWithBLOBs bloBs = new Miss_doctorWithBLOBs();
		bloBs.setName(name);bloBs.setSex(sex);bloBs.setGraduate(graduate);
		bloBs.setProfession(profession);bloBs.setOrigin(origin);
		
		PageObject<Miss_doctorWithBLOBs> selectPage = super.selectPage(currentPage, pageSize, bloBs);
		List<Miss_doctorWithBLOBs> params = selectPage.getParams();

		PageObject<OperateDTO> pageObject = new PageObject<>();
		pageObject.setCurrentPage(selectPage.getCurrentPage());
		pageObject.setTotal(selectPage.getTotal());
		List<OperateDTO> list = new ArrayList<>();
		for (Miss_doctorWithBLOBs miss_doctorWithBLOBs : params) {
			list.add(converseToOperataDTO(getDoctorDTO(miss_doctorWithBLOBs)));
		}
		pageObject.setParams(list);
		return pageObject;
	}
	
	public DoctorDTO getDoctorDTO(Miss_doctorWithBLOBs bloBs) {
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setMiss_doctor(bloBs);
		doctorDTO.setDepartment_list(missDepartmentService.getDepartmentMapByDoctorId(bloBs.getId()));
		doctorDTO.setInstitution_list(missInstitutionService.getInstitutionInfoMapDTOByDoctorId(bloBs.getId()));
		return doctorDTO;
	}

	public Miss_doctorMapper getDoctorMapper() {
		return doctorMapper;
	}

	public void setDoctorMapper(Miss_doctorMapper doctorMapper) {
		this.doctorMapper = doctorMapper;
	}

	
	
}
