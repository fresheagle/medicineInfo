package com.med.info.dto;

import java.io.Serializable;
import java.util.List;

import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.DislocationMapDTO;

public class MissSymptomDTO implements Serializable{
	private Long id;
	private String chineseName;
	private String englishName;
	private String otherName;
	private String symptom;
	private String treatment;
	private String clinicalManifestation;
	private String departmentId;
	private String mainCauses;
	private String commonSymptom;
	private String multiplePopulation;
	private String infectivity;
	private String inspectionItems;
	private String tOtherTherapies;
	private String commonDiseases;
	private String tPreventiveNursing;
	private String syndrome;
	private String dataReference;
	private String chineseMedicine;
	private String pathogeny;
	private String pathogenesis;
	private String dialecticalPoints;
	private String symptomAnalysis;
	private String commonChineseMedicine;
	private String tCommonSyndromeTypes;
	private String symptomOrigin;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String dataStatus;
	private String taskId;
	private String taskStatus;
	private String taskJson;
	private String inspect;
	private String diagnosi;
	private String differentialDiagnosis;
	private String clinicalSignificance;
	private String dailyNursing;
	private String attentionMatter;
	private String influenceFactor;
	private String consultation;
	private String section;
	private String prescription;
	private String syndromeDifferentTreatment;
	private String acupunctureTherapy;
	private String syndromeDifferentiation;
	private String prognosis;
	private String symptomType;
	private String introduction;
	private String thumbnail;
	private String epidemiology;
	private String preventiveMeasure;
	private String picturepath;
	private String commonDiseasesOld;
	private Long editDoctor;
	private Long auditDoctor;

	private List<DepartmentMapDTO> departmentMapDTO;
	private List<DislocationMapDTO> dislocationList;
	private List<Long> chineseDiseaseList;
	private List<Long> westernDiseaseList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getClinicalManifestation() {
		return clinicalManifestation;
	}
	public void setClinicalManifestation(String clinicalManifestation) {
		this.clinicalManifestation = clinicalManifestation;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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
	public String getInspectionItems() {
		return inspectionItems;
	}
	public void setInspectionItems(String inspectionItems) {
		this.inspectionItems = inspectionItems;
	}
	public String gettOtherTherapies() {
		return tOtherTherapies;
	}
	public void settOtherTherapies(String tOtherTherapies) {
		this.tOtherTherapies = tOtherTherapies;
	}
	public String getCommonDiseases() {
		return commonDiseases;
	}
	public void setCommonDiseases(String commonDiseases) {
		this.commonDiseases = commonDiseases;
	}
	public String gettPreventiveNursing() {
		return tPreventiveNursing;
	}
	public void settPreventiveNursing(String tPreventiveNursing) {
		this.tPreventiveNursing = tPreventiveNursing;
	}
	public String getSyndrome() {
		return syndrome;
	}
	public void setSyndrome(String syndrome) {
		this.syndrome = syndrome;
	}
	public String getDataReference() {
		return dataReference;
	}
	public void setDataReference(String dataReference) {
		this.dataReference = dataReference;
	}
	public String getChineseMedicine() {
		return chineseMedicine;
	}
	public void setChineseMedicine(String chineseMedicine) {
		this.chineseMedicine = chineseMedicine;
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
	public String getDialecticalPoints() {
		return dialecticalPoints;
	}
	public void setDialecticalPoints(String dialecticalPoints) {
		this.dialecticalPoints = dialecticalPoints;
	}
	public String getSymptomAnalysis() {
		return symptomAnalysis;
	}
	public void setSymptomAnalysis(String symptomAnalysis) {
		this.symptomAnalysis = symptomAnalysis;
	}
	public String getCommonChineseMedicine() {
		return commonChineseMedicine;
	}
	public void setCommonChineseMedicine(String commonChineseMedicine) {
		this.commonChineseMedicine = commonChineseMedicine;
	}
	public String gettCommonSyndromeTypes() {
		return tCommonSyndromeTypes;
	}
	public void settCommonSyndromeTypes(String tCommonSyndromeTypes) {
		this.tCommonSyndromeTypes = tCommonSyndromeTypes;
	}
	public String getSymptomOrigin() {
		return symptomOrigin;
	}
	public void setSymptomOrigin(String symptomOrigin) {
		this.symptomOrigin = symptomOrigin;
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
	public String getInspect() {
		return inspect;
	}
	public void setInspect(String inspect) {
		this.inspect = inspect;
	}
	public String getDiagnosi() {
		return diagnosi;
	}
	public void setDiagnosi(String diagnosi) {
		this.diagnosi = diagnosi;
	}
	public String getDifferentialDiagnosis() {
		return differentialDiagnosis;
	}
	public void setDifferentialDiagnosis(String differentialDiagnosis) {
		this.differentialDiagnosis = differentialDiagnosis;
	}
	public String getClinicalSignificance() {
		return clinicalSignificance;
	}
	public void setClinicalSignificance(String clinicalSignificance) {
		this.clinicalSignificance = clinicalSignificance;
	}
	public String getDailyNursing() {
		return dailyNursing;
	}
	public void setDailyNursing(String dailyNursing) {
		this.dailyNursing = dailyNursing;
	}
	public String getAttentionMatter() {
		return attentionMatter;
	}
	public void setAttentionMatter(String attentionMatter) {
		this.attentionMatter = attentionMatter;
	}
	public String getInfluenceFactor() {
		return influenceFactor;
	}
	public void setInfluenceFactor(String influenceFactor) {
		this.influenceFactor = influenceFactor;
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
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getSyndromeDifferentTreatment() {
		return syndromeDifferentTreatment;
	}
	public void setSyndromeDifferentTreatment(String syndromeDifferentTreatment) {
		this.syndromeDifferentTreatment = syndromeDifferentTreatment;
	}
	public String getAcupunctureTherapy() {
		return acupunctureTherapy;
	}
	public void setAcupunctureTherapy(String acupunctureTherapy) {
		this.acupunctureTherapy = acupunctureTherapy;
	}
	public String getSyndromeDifferentiation() {
		return syndromeDifferentiation;
	}
	public void setSyndromeDifferentiation(String syndromeDifferentiation) {
		this.syndromeDifferentiation = syndromeDifferentiation;
	}
	public String getPrognosis() {
		return prognosis;
	}
	public void setPrognosis(String prognosis) {
		this.prognosis = prognosis;
	}
	public String getSymptomType() {
		return symptomType;
	}
	public void setSymptomType(String symptomType) {
		this.symptomType = symptomType;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getEpidemiology() {
		return epidemiology;
	}
	public void setEpidemiology(String epidemiology) {
		this.epidemiology = epidemiology;
	}
	public String getPreventiveMeasure() {
		return preventiveMeasure;
	}
	public void setPreventiveMeasure(String preventiveMeasure) {
		this.preventiveMeasure = preventiveMeasure;
	}
	public String getPicturepath() {
		return picturepath;
	}
	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}
	public String getCommonDiseasesOld() {
		return commonDiseasesOld;
	}
	public void setCommonDiseasesOld(String commonDiseasesOld) {
		this.commonDiseasesOld = commonDiseasesOld;
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
	public List<DislocationMapDTO> getDislocationList() {
		return dislocationList;
	}
	public void setDislocationList(List<DislocationMapDTO> dislocationList) {
		this.dislocationList = dislocationList;
	}
	public List<Long> getChineseDiseaseList() {
		return chineseDiseaseList;
	}
	public void setChineseDiseaseList(List<Long> chineseDiseaseList) {
		this.chineseDiseaseList = chineseDiseaseList;
	}
	public List<Long> getWesternDiseaseList() {
		return westernDiseaseList;
	}
	public void setWesternDiseaseList(List<Long> westernDiseaseList) {
		this.westernDiseaseList = westernDiseaseList;
	}
	public List<DepartmentMapDTO> getDepartmentMapDTO() {
		return departmentMapDTO;
	}
	public void setDepartmentMapDTO(List<DepartmentMapDTO> departmentMapDTO) {
		this.departmentMapDTO = departmentMapDTO;
	}
}
