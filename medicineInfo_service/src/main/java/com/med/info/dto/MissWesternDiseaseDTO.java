package com.med.info.dto;

import java.io.Serializable;
import java.util.List;

import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.DislocationMapDTO;

public class MissWesternDiseaseDTO implements Serializable{
	private Long id;
	private Long diseaseId;
	private String epidemiology;
	private String tRelatedDiseases;
	private String etiologyPathogenesis;
	private String pathology;
	private String clinicalTypesClass;
	private String clinicalManifestation;
	private String symptom;
	private String sign;
	private String laboratoryExamination;
	private String textOtherCheck;
	private String diagnosticPoints;
	private String differentialDiagnosis;
	private String preventionTreatment;
	private String treatmentPrognosis;
	private String management;
	private String preventiveNursing;
	private String nursing;
	private String preventionMeasures;
	private String modernResearch;
	private String drugResistance;
	private String dietaryConditioning;
	private String attentionMatter;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String dataReference;
	private String dataStatus;
	private String taskId;
	private String taskStatus;
	private String taskJson;
	private String introduction;
	private String chineseName;
	private String englishName;
	private String otherName;
	private String relatedDiseases;
	private String diseaseType;
	private Long locationPid;
	private Long locationDisease;
	private String mainCauses;
	private String commonSymptom;
	private String multiplePopulation;
	private String infectivity;
	private Long departmentPid;
	private Long departmentId;
	private String consultation;
	private String section;
	private String treatmentCost;
	private Long editDoctor;
	private Long auditDoctor;
	private List<DepartmentMapDTO> departmentMapDTO;
	private List<DislocationMapDTO> dislocationList;
	private String medicalExamination;
	private String familyTreatment;
	private String department;
	private String doctorConsultation;
	private String expectedInspection;
	private String expectedTreatment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(Long diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getEpidemiology() {
		return epidemiology;
	}
	public void setEpidemiology(String epidemiology) {
		this.epidemiology = epidemiology;
	}
	public String gettRelatedDiseases() {
		return tRelatedDiseases;
	}
	public void settRelatedDiseases(String tRelatedDiseases) {
		this.tRelatedDiseases = tRelatedDiseases;
	}
	public String getEtiologyPathogenesis() {
		return etiologyPathogenesis;
	}
	public void setEtiologyPathogenesis(String etiologyPathogenesis) {
		this.etiologyPathogenesis = etiologyPathogenesis;
	}
	public String getPathology() {
		return pathology;
	}
	public void setPathology(String pathology) {
		this.pathology = pathology;
	}
	public String getClinicalTypesClass() {
		return clinicalTypesClass;
	}
	public void setClinicalTypesClass(String clinicalTypesClass) {
		this.clinicalTypesClass = clinicalTypesClass;
	}
	public String getClinicalManifestation() {
		return clinicalManifestation;
	}
	public void setClinicalManifestation(String clinicalManifestation) {
		this.clinicalManifestation = clinicalManifestation;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getLaboratoryExamination() {
		return laboratoryExamination;
	}
	public void setLaboratoryExamination(String laboratoryExamination) {
		this.laboratoryExamination = laboratoryExamination;
	}
	public String getTextOtherCheck() {
		return textOtherCheck;
	}
	public void setTextOtherCheck(String textOtherCheck) {
		this.textOtherCheck = textOtherCheck;
	}
	public String getDiagnosticPoints() {
		return diagnosticPoints;
	}
	public void setDiagnosticPoints(String diagnosticPoints) {
		this.diagnosticPoints = diagnosticPoints;
	}
	public String getDifferentialDiagnosis() {
		return differentialDiagnosis;
	}
	public void setDifferentialDiagnosis(String differentialDiagnosis) {
		this.differentialDiagnosis = differentialDiagnosis;
	}
	public String getPreventionTreatment() {
		return preventionTreatment;
	}
	public void setPreventionTreatment(String preventionTreatment) {
		this.preventionTreatment = preventionTreatment;
	}
	public String getTreatmentPrognosis() {
		return treatmentPrognosis;
	}
	public void setTreatmentPrognosis(String treatmentPrognosis) {
		this.treatmentPrognosis = treatmentPrognosis;
	}
	public String getManagement() {
		return management;
	}
	public void setManagement(String management) {
		this.management = management;
	}
	public String getPreventiveNursing() {
		return preventiveNursing;
	}
	public void setPreventiveNursing(String preventiveNursing) {
		this.preventiveNursing = preventiveNursing;
	}
	public String getNursing() {
		return nursing;
	}
	public void setNursing(String nursing) {
		this.nursing = nursing;
	}
	public String getPreventionMeasures() {
		return preventionMeasures;
	}
	public void setPreventionMeasures(String preventionMeasures) {
		this.preventionMeasures = preventionMeasures;
	}
	public String getModernResearch() {
		return modernResearch;
	}
	public void setModernResearch(String modernResearch) {
		this.modernResearch = modernResearch;
	}
	public String getDrugResistance() {
		return drugResistance;
	}
	public void setDrugResistance(String drugResistance) {
		this.drugResistance = drugResistance;
	}
	public String getDietaryConditioning() {
		return dietaryConditioning;
	}
	public void setDietaryConditioning(String dietaryConditioning) {
		this.dietaryConditioning = dietaryConditioning;
	}
	public String getAttentionMatter() {
		return attentionMatter;
	}
	public void setAttentionMatter(String attentionMatter) {
		this.attentionMatter = attentionMatter;
	}
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	public String getReserve2() {
		return reserve2;
	}
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	public String getReserve3() {
		return reserve3;
	}
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	public String getDataReference() {
		return dataReference;
	}
	public void setDataReference(String dataReference) {
		this.dataReference = dataReference;
	}
	public String getDataStatus() {
		return dataStatus;
	}
	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskJson() {
		return taskJson;
	}
	public void setTaskJson(String taskJson) {
		this.taskJson = taskJson;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getRelatedDiseases() {
		return relatedDiseases;
	}
	public void setRelatedDiseases(String relatedDiseases) {
		this.relatedDiseases = relatedDiseases;
	}
	public String getDiseaseType() {
		return diseaseType;
	}
	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}
	public Long getLocationPid() {
		return locationPid;
	}
	public void setLocationPid(Long locationPid) {
		this.locationPid = locationPid;
	}
	public Long getLocationDisease() {
		return locationDisease;
	}
	public void setLocationDisease(Long locationDisease) {
		this.locationDisease = locationDisease;
	}
	public String getMainCauses() {
		return mainCauses;
	}
	public void setMainCauses(String mainCauses) {
		this.mainCauses = mainCauses;
	}
	public String getCommonSymptom() {
		return commonSymptom;
	}
	public void setCommonSymptom(String commonSymptom) {
		this.commonSymptom = commonSymptom;
	}
	public String getMultiplePopulation() {
		return multiplePopulation;
	}
	public void setMultiplePopulation(String multiplePopulation) {
		this.multiplePopulation = multiplePopulation;
	}
	public String getInfectivity() {
		return infectivity;
	}
	public void setInfectivity(String infectivity) {
		this.infectivity = infectivity;
	}
	public Long getDepartmentPid() {
		return departmentPid;
	}
	public void setDepartmentPid(Long departmentPid) {
		this.departmentPid = departmentPid;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getConsultation() {
		return consultation;
	}
	public void setConsultation(String consultation) {
		this.consultation = consultation;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getTreatmentCost() {
		return treatmentCost;
	}
	public void setTreatmentCost(String treatmentCost) {
		this.treatmentCost = treatmentCost;
	}
	public Long getEditDoctor() {
		return editDoctor;
	}
	public void setEditDoctor(Long editDoctor) {
		this.editDoctor = editDoctor;
	}
	public Long getAuditDoctor() {
		return auditDoctor;
	}
	public void setAuditDoctor(Long auditDoctor) {
		this.auditDoctor = auditDoctor;
	}
	public List<DepartmentMapDTO> getDepartmentMapDTO() {
		return departmentMapDTO;
	}
	public void setDepartmentMapDTO(List<DepartmentMapDTO> departmentMapDTO) {
		this.departmentMapDTO = departmentMapDTO;
	}
	public List<DislocationMapDTO> getDislocationList() {
		return dislocationList;
	}
	public void setDislocationList(List<DislocationMapDTO> dislocationList) {
		this.dislocationList = dislocationList;
	}
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	public String getMedicalExamination() {
		return medicalExamination;
	}
	public void setMedicalExamination(String medicalExamination) {
		this.medicalExamination = medicalExamination;
	}
	public String getFamilyTreatment() {
		return familyTreatment;
	}
	public void setFamilyTreatment(String familyTreatment) {
		this.familyTreatment = familyTreatment;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDoctorConsultation() {
		return doctorConsultation;
	}
	public void setDoctorConsultation(String doctorConsultation) {
		this.doctorConsultation = doctorConsultation;
	}
	public String getExpectedInspection() {
		return expectedInspection;
	}
	public void setExpectedInspection(String expectedInspection) {
		this.expectedInspection = expectedInspection;
	}
	public String getExpectedTreatment() {
		return expectedTreatment;
	}
	public void setExpectedTreatment(String expectedTreatment) {
		this.expectedTreatment = expectedTreatment;
	}

	
}
