package com.med.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.med.info.domain.Miss_articleWithBLOBs;
import com.med.info.domain.Miss_chinese_diseaseWithBLOBs;
import com.med.info.domain.Miss_control_task_records;
import com.med.info.domain.Miss_department_doctor_mapping;
import com.med.info.domain.Miss_disease_department_mapping;
import com.med.info.domain.Miss_disease_dislocation_mapping;
import com.med.info.domain.Miss_doctorWithBLOBs;
import com.med.info.domain.Miss_institutionWithBLOBs;
import com.med.info.domain.Miss_institution_doctor_mapping;
import com.med.info.domain.Miss_institution_keypartment_mapping;
import com.med.info.domain.Miss_medicalWithBLOBs;
import com.med.info.domain.Miss_symptomWithBLOBs;
import com.med.info.domain.Miss_symptom_department_mapping;
import com.med.info.domain.Miss_symptom_dislocation_mapping;
import com.med.info.domain.Miss_western_diseaseWithBLOBs;
import com.med.info.dto.BatchOperateDTO;
import com.med.info.export.MissArticleTransBean;
import com.med.info.export.MissChineseDiseaseTransBean;
import com.med.info.export.MissDoctorTransBean;
import com.med.info.export.MissInstitutionTransBean;
import com.med.info.export.MissMedicalTransBean;
import com.med.info.export.MissSymptomTransBean;
import com.med.info.export.MissWesternDiseaseTransBean;
import com.med.info.mapper.Miss_articleMapper;
import com.med.info.mapper.Miss_chinese_diseaseMapper;
import com.med.info.mapper.Miss_department_doctor_mappingMapper;
import com.med.info.mapper.Miss_disease_department_mappingMapper;
import com.med.info.mapper.Miss_disease_dislocation_mappingMapper;
import com.med.info.mapper.Miss_doctorMapper;
import com.med.info.mapper.Miss_institutionMapper;
import com.med.info.mapper.Miss_institution_doctor_mappingMapper;
import com.med.info.mapper.Miss_institution_keypartment_mappingMapper;
import com.med.info.mapper.Miss_medicalMapper;
import com.med.info.mapper.Miss_symptomMapper;
import com.med.info.mapper.Miss_symptom_department_mappingMapper;
import com.med.info.mapper.Miss_symptom_dislocation_mappingMapper;
import com.med.info.mapper.Miss_western_diseaseMapper;
import com.med.info.service.ExportService;
import com.med.info.utils.HttpUtils;
import com.alibaba.fastjson.*;

@Service
public class ExportServiceImpl implements ExportService{

	@Autowired
	private Miss_institutionMapper miss_institutionMapper;
	@Autowired
	private Miss_institution_keypartment_mappingMapper miss_institution_keypartment_mappingMapper;
	@Autowired
	private Miss_chinese_diseaseMapper miss_chinese_diseaseMapper;
	@Autowired
	private Miss_western_diseaseMapper miss_western_diseaseMapper;
	@Autowired
	private Miss_disease_department_mappingMapper miss_disease_department_mappingMapper;
	@Autowired
	private Miss_disease_dislocation_mappingMapper miss_disease_dislocation_mappingMapper;
	@Autowired
	private Miss_doctorMapper miss_doctorMapper;
	@Autowired
	private Miss_institution_doctor_mappingMapper miss_institution_doctor_mappingMapper;
	@Autowired
	private Miss_department_doctor_mappingMapper miss_department_doctor_mappingMapper;
	@Autowired
	private Miss_symptomMapper miss_symptomMapper;
	@Autowired
	private Miss_symptom_department_mappingMapper miss_symptom_department_mappingMapper;
	@Autowired
	private Miss_symptom_dislocation_mappingMapper miss_symptom_dislocation_mappingMapper;
	@Autowired
	private Miss_medicalMapper miss_medicalMapper;
	@Autowired
	private Miss_articleMapper miss_articleMapper;
	
	@Override
	public String exportFile(List<Miss_control_task_records> missControlTaskRecords,BatchOperateDTO batchOperateDTO) throws Exception {
		// TODO Auto-generated method stub
		HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        String url = "http://localhost:8084/medicine/";
		if("missInstitution".equals(missControlTaskRecords.get(0).getTaskmenutype())) {
			List<Miss_institutionWithBLOBs> miss_institutionWithBLOBs = miss_institutionMapper.exportSQL(batchOperateDTO.getTasks());
			List<Miss_institution_keypartment_mapping> miss_institution_keypartment_mapping = miss_institution_keypartment_mappingMapper.exportSQL(batchOperateDTO.getTasks());
			MissInstitutionTransBean missInstitutionTransBean = new MissInstitutionTransBean();
			missInstitutionTransBean.setMiss_institutionWithBLOBs(miss_institutionWithBLOBs);
			missInstitutionTransBean.setMiss_institution_keypartment_mapping(miss_institution_keypartment_mapping);
			HttpEntity<MissInstitutionTransBean> entity = new HttpEntity<MissInstitutionTransBean>(missInstitutionTransBean);
			RestTemplate restTemplate=new RestTemplate();
	        ResponseEntity<String> result = restTemplate.exchange(url+"institution", HttpMethod.POST, entity, String.class);
	        System.out.println(result.getBody());
	        return result.getBody();
		}if("missChineseDisease".equals(missControlTaskRecords.get(0).getTaskmenutype())) {
			List<Miss_chinese_diseaseWithBLOBs> miss_chinese_diseaseWithBLOBs = miss_chinese_diseaseMapper.exportSQL(batchOperateDTO.getTasks());
			List<Miss_disease_department_mapping> miss_disease_department_mapping = miss_disease_department_mappingMapper.exportSQL(batchOperateDTO.getTasks());
			List<Miss_disease_dislocation_mapping> miss_disease_dislocation_mapping = miss_disease_dislocation_mappingMapper.exportSQL(batchOperateDTO.getTasks());
			MissChineseDiseaseTransBean missChineseDiseaseTransBean = new MissChineseDiseaseTransBean();
			missChineseDiseaseTransBean.setMiss_chinese_diseaseWithBLOBs(miss_chinese_diseaseWithBLOBs);
			missChineseDiseaseTransBean.setMiss_disease_department_mapping(miss_disease_department_mapping);
			missChineseDiseaseTransBean.setMiss_disease_dislocation_mapping(miss_disease_dislocation_mapping);
			HttpEntity<MissChineseDiseaseTransBean> entity = new HttpEntity<MissChineseDiseaseTransBean>(missChineseDiseaseTransBean);
			RestTemplate restTemplate=new RestTemplate();
	        ResponseEntity<String> result = restTemplate.exchange(url+"chineseDisease", HttpMethod.POST, entity, String.class);
	        System.out.println(result.getBody());
	        return result.getBody();
		}if("missWesternDisease".equals(missControlTaskRecords.get(0).getTaskmenutype())) {
			List<Miss_western_diseaseWithBLOBs> miss_western_diseaseWithBLOBs = miss_western_diseaseMapper.exportSQL(batchOperateDTO.getTasks());
			List<Miss_disease_department_mapping> miss_disease_department_mapping = miss_disease_department_mappingMapper.exportSQL(batchOperateDTO.getTasks());
			List<Miss_disease_dislocation_mapping> miss_disease_dislocation_mapping = miss_disease_dislocation_mappingMapper.exportSQL(batchOperateDTO.getTasks());
			MissWesternDiseaseTransBean missWesternDiseaseTransBean = new MissWesternDiseaseTransBean();
			missWesternDiseaseTransBean.setMiss_disease_department_mapping(miss_disease_department_mapping);
			missWesternDiseaseTransBean.setMiss_western_diseaseWithBLOBs(miss_western_diseaseWithBLOBs);
			missWesternDiseaseTransBean.setMiss_disease_dislocation_mapping(miss_disease_dislocation_mapping);
			HttpEntity<MissWesternDiseaseTransBean> entity = new HttpEntity<MissWesternDiseaseTransBean>(missWesternDiseaseTransBean);
			RestTemplate restTemplate=new RestTemplate();
	        ResponseEntity<String> result = restTemplate.exchange(url+"westernDisease", HttpMethod.POST, entity, String.class);
	        System.out.println(result.getBody());
	        return result.getBody();
		}if("missChineseMedical".equals(missControlTaskRecords.get(0).getTaskmenutype()) || "missWesternMedical".equals(missControlTaskRecords.get(0).getTaskmenutype())) {
			List<Miss_medicalWithBLOBs> miss_medicalWithBLOBs = miss_medicalMapper.exportSQL(batchOperateDTO.getTasks());
			MissMedicalTransBean missMedicalTransBean = new MissMedicalTransBean();
			missMedicalTransBean.setMiss_medicalWithBLOBs(miss_medicalWithBLOBs);
			HttpEntity<MissMedicalTransBean> entity = new HttpEntity<MissMedicalTransBean>(missMedicalTransBean);
			RestTemplate restTemplate=new RestTemplate();
	        ResponseEntity<String> result = restTemplate.exchange(url+"medical", HttpMethod.POST, entity, String.class);
	        System.out.println(result.getBody());
	        return result.getBody();
		}if("missWesternSymptom".equals(missControlTaskRecords.get(0).getTaskmenutype()) || "missChineseSymptom".equals(missControlTaskRecords.get(0).getTaskmenutype())) {
			List<Miss_symptomWithBLOBs> miss_symptomWithBLOBs = miss_symptomMapper.exportSQL(batchOperateDTO.getTasks());
			List<Miss_symptom_department_mapping> miss_symptom_department_mapping = miss_symptom_department_mappingMapper.exportSQL(batchOperateDTO.getTasks());
			List<Miss_symptom_dislocation_mapping> miss_symptom_dislocation_mapping = miss_symptom_dislocation_mappingMapper.exportSQL(batchOperateDTO.getTasks());
			MissSymptomTransBean missSymptomTransBean = new MissSymptomTransBean();
			missSymptomTransBean.setMiss_symptomWithBLOBs(miss_symptomWithBLOBs);
			missSymptomTransBean.setMiss_symptom_department_mapping(miss_symptom_department_mapping);
			missSymptomTransBean.setMiss_symptom_dislocation_mapping(miss_symptom_dislocation_mapping);
			HttpEntity<MissSymptomTransBean> entity = new HttpEntity<MissSymptomTransBean>(missSymptomTransBean);
			RestTemplate restTemplate=new RestTemplate();
	        ResponseEntity<String> result = restTemplate.exchange(url+"symptom", HttpMethod.POST, entity, String.class);
	        System.out.println(result.getBody());
	        return result.getBody();
		}if("missDoctor".equals(missControlTaskRecords.get(0).getTaskmenutype())) {
			List<Miss_doctorWithBLOBs> miss_doctorWithBLOBs = miss_doctorMapper.exportSQL(batchOperateDTO.getTasks());
			List<Miss_department_doctor_mapping> miss_department_doctor_mapping = miss_department_doctor_mappingMapper.exportSQL(batchOperateDTO.getTasks());
			List<Miss_institution_doctor_mapping> miss_institution_doctor_mapping = miss_institution_doctor_mappingMapper.exportSQL(batchOperateDTO.getTasks());
			MissDoctorTransBean missDoctorTransBean = new MissDoctorTransBean();
			missDoctorTransBean.setMiss_doctorWithBLOBs(miss_doctorWithBLOBs);
			missDoctorTransBean.setMiss_department_doctor_mapping(miss_department_doctor_mapping);
			missDoctorTransBean.setMiss_institution_doctor_mapping(miss_institution_doctor_mapping);
			HttpEntity<MissDoctorTransBean> entity = new HttpEntity<MissDoctorTransBean>(missDoctorTransBean);
			RestTemplate restTemplate=new RestTemplate();
	        ResponseEntity<String> result = restTemplate.exchange(url+"doctor", HttpMethod.POST, entity, String.class);
	        System.out.println(result.getBody());
	        return result.getBody();
		}if("missArticle".equals(missControlTaskRecords.get(0).getTaskmenutype())) {
			List<Miss_articleWithBLOBs> miss_articleWithBLOBs = miss_articleMapper.exportSQL(batchOperateDTO.getTasks());
			MissArticleTransBean missArticleTransBean = new MissArticleTransBean();
			missArticleTransBean.setMiss_articleWithBLOBs(miss_articleWithBLOBs);
			HttpEntity<MissArticleTransBean> entity = new HttpEntity<MissArticleTransBean>(missArticleTransBean);
			RestTemplate restTemplate=new RestTemplate();
	        ResponseEntity<String> result = restTemplate.exchange(url+"article", HttpMethod.POST, entity, String.class);
	        System.out.println(result.getBody());
	        return result.getBody();
		}
		return "false";
	}
}
