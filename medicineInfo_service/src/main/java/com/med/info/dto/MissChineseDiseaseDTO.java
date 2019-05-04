package com.med.info.dto;

import java.io.Serializable;
import java.util.List;

import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.DislocationMapDTO;

public class MissChineseDiseaseDTO implements Serializable{

	private Long id;
	private String introduction;
	private String chineseName;
	private Long diseaseId;
	private String nounInterpretation;
	private String history;
	private String relationshipWestern;
	private String pathogeny;
	private String pathogenesis;
	private String examinationPoints;
	private String clinicalManifestation;
	private String diagnosisBasis;
	private String diseaseIdentification;
	private String relatedExaminations;
	private String dialecticalTreatment;
	private String dialecticalPoints;
	private String syndromeDifferentiation;
	private String treatment;
	private String treatmentPrinciples;
	private String syndromeType;
	private String externalTherapy;
	private String otherTherapies;
	private String preventiveNursing;
	private String clinicalPreparation;
	private String literatureAbstract;
	private String modernResearch;
	private String textDietaryConditioning;
	private String attentionMatter;
	private String dataReference;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String dataStatus;
	private String taskId;
	private String taskStatus;
	private String taskJson;
	private String englishName;
	private String otherName;
	private String latinName;
	private String relatedDiseases;
	private String diseaseType;
	private Long locationPid;
	private Long locationDisease;
	private String mainCauses;
	private String commonSymptom;
	private String multiplePopulation;
	private int infectivity;
	private String seaCharacteristic;
	private String departmentPid;
	private String departmentId;
	private String clinicalTypesClass;
	private String sign;
	private String laboratoryExamination;
	private String diagnosticPoints;
	private String differentialDiagnosis;
	private String preventionTreatment;
	private String treatmentPrognosis;
	private String nursing;
	private String preventionMeasures;
	private String dietaryConditioning;
	private String drugResistance;
	private String picturePath;
	private String thumbnail;
	private Long editDoctor;
	private Long auditDoctor;
	private List<DepartmentMapDTO> departmentMapDTO;
	private List<DislocationMapDTO> dislocationList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(Long diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getNounInterpretation() {
		return nounInterpretation;
	}
	public void setNounInterpretation(String nounInterpretation) {
		this.nounInterpretation = nounInterpretation;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getRelationshipWestern() {
		return relationshipWestern;
	}
	public void setRelationshipWestern(String relationshipWestern) {
		this.relationshipWestern = relationshipWestern;
	}
	public String getPathogeny() {
		return pathogeny;
	}
	public void setPathogeny(String pathogeny) {
		this.pathogeny = pathogeny;
	}
	public String getPathogenesis() {
		return pathogenesis;
	}
	public void setPathogenesis(String pathogenesis) {
		this.pathogenesis = pathogenesis;
	}
	public String getExaminationPoints() {
		return examinationPoints;
	}
	public void setExaminationPoints(String examinationPoints) {
		this.examinationPoints = examinationPoints;
	}
	public String getClinicalManifestation() {
		return clinicalManifestation;
	}
	public void setClinicalManifestation(String clinicalManifestation) {
		this.clinicalManifestation = clinicalManifestation;
	}
	public String getDiagnosisBasis() {
		return diagnosisBasis;
	}
	public void setDiagnosisBasis(String diagnosisBasis) {
		this.diagnosisBasis = diagnosisBasis;
	}
	public String getDiseaseIdentification() {
		return diseaseIdentification;
	}
	public void setDiseaseIdentification(String diseaseIdentification) {
		this.diseaseIdentification = diseaseIdentification;
	}
	public String getRelatedExaminations() {
		return relatedExaminations;
	}
	public void setRelatedExaminations(String relatedExaminations) {
		this.relatedExaminations = relatedExaminations;
	}
	public String getDialecticalTreatment() {
		return dialecticalTreatment;
	}
	public void setDialecticalTreatment(String dialecticalTreatment) {
		this.dialecticalTreatment = dialecticalTreatment;
	}
	public String getDialecticalPoints() {
		return dialecticalPoints;
	}
	public void setDialecticalPoints(String dialecticalPoints) {
		this.dialecticalPoints = dialecticalPoints;
	}
	public String getSyndromeDifferentiation() {
		return syndromeDifferentiation;
	}
	public void setSyndromeDifferentiation(String syndromeDifferentiation) {
		this.syndromeDifferentiation = syndromeDifferentiation;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getTreatmentPrinciples() {
		return treatmentPrinciples;
	}
	public void setTreatmentPrinciples(String treatmentPrinciples) {
		this.treatmentPrinciples = treatmentPrinciples;
	}
	public String getSyndromeType() {
		return syndromeType;
	}
	public void setSyndromeType(String syndromeType) {
		this.syndromeType = syndromeType;
	}
	public String getExternalTherapy() {
		return externalTherapy;
	}
	public void setExternalTherapy(String externalTherapy) {
		this.externalTherapy = externalTherapy;
	}
	public String getOtherTherapies() {
		return otherTherapies;
	}
	public void setOtherTherapies(String otherTherapies) {
		this.otherTherapies = otherTherapies;
	}
	public String getPreventiveNursing() {
		return preventiveNursing;
	}
	public void setPreventiveNursing(String preventiveNursing) {
		this.preventiveNursing = preventiveNursing;
	}
	public String getClinicalPreparation() {
		return clinicalPreparation;
	}
	public void setClinicalPreparation(String clinicalPreparation) {
		this.clinicalPreparation = clinicalPreparation;
	}
	public String getLiteratureAbstract() {
		return literatureAbstract;
	}
	public void setLiteratureAbstract(String literatureAbstract) {
		this.literatureAbstract = literatureAbstract;
	}
	public String getModernResearch() {
		return modernResearch;
	}
	public void setModernResearch(String modernResearch) {
		this.modernResearch = modernResearch;
	}
	public String getTextDietaryConditioning() {
		return textDietaryConditioning;
	}
	public void setTextDietaryConditioning(String textDietaryConditioning) {
		this.textDietaryConditioning = textDietaryConditioning;
	}
	public String getAttentionMatter() {
		return attentionMatter;
	}
	public void setAttentionMatter(String attentionMatter) {
		this.attentionMatter = attentionMatter;
	}
	public String getDataReference() {
		return dataReference;
	}
	public void setDataReference(String dataReference) {
		this.dataReference = dataReference;
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
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	public String getLatinName() {
		return latinName;
	}
	public void setLatinName(String latinName) {
		this.latinName = latinName;
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
	public int getInfectivity() {
		return infectivity;
	}
	public void setInfectivity(int infectivity) {
		this.infectivity = infectivity;
	}
	public String getSeaCharacteristic() {
		return seaCharacteristic;
	}
	public void setSeaCharacteristic(String seaCharacteristic) {
		this.seaCharacteristic = seaCharacteristic;
	}
	public String getDepartmentPid() {
		return departmentPid;
	}
	public void setDepartmentPid(String departmentPid) {
		this.departmentPid = departmentPid;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getClinicalTypesClass() {
		return clinicalTypesClass;
	}
	public void setClinicalTypesClass(String clinicalTypesClass) {
		this.clinicalTypesClass = clinicalTypesClass;
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
	public String getDietaryConditioning() {
		return dietaryConditioning;
	}
	public void setDietaryConditioning(String dietaryConditioning) {
		this.dietaryConditioning = dietaryConditioning;
	}
	public String getDrugResistance() {
		return drugResistance;
	}
	public void setDrugResistance(String drugResistance) {
		this.drugResistance = drugResistance;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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


}
