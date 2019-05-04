package com.med.info.dto;

import java.io.Serializable;
import java.util.List;

import com.med.info.mapper.domain.InstitutionDepartMapDTO;

public class MissDoctorDTO implements Serializable{
	private Long id;
	private String name;
	private String sex;
	private String origin;
	private String nation;
	private String birthday;
	private String dieday;
	private String intro;
	private String picturepath;
	private String thumbnail;
	private String honorary;
	private String clinicProfessional;
	private String eduProfessional;
	private String graduate;
	private String profession;
	private String inauguralInstitution;
	private String education;
	private String workExperience;
	private String expertsTime;
	private String treatArea;
	private String researchArea;
	private String academic;
	private String production;
	private String awards;
	private String science;
	private String socialization;
	private String thesis;
	private String bookmaking;
	private String heritageMap;
	private String referenceMaterial;
	private String birthplaceDistrictCode;
	private String dataStatus;
	private String taskId;
	private String taskStatus;
	private String taskJson;
	private Long editDoctor;
	private Long auditDoctor;
	private List<InstitutionDepartMapDTO> institutionList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDieday() {
		return dieday;
	}
	public void setDieday(String dieday) {
		this.dieday = dieday;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getPicturepath() {
		return picturepath;
	}
	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getHonorary() {
		return honorary;
	}
	public void setHonorary(String honorary) {
		this.honorary = honorary;
	}
	public String getClinicProfessional() {
		return clinicProfessional;
	}
	public void setClinicProfessional(String clinicProfessional) {
		this.clinicProfessional = clinicProfessional;
	}
	public String getEduProfessional() {
		return eduProfessional;
	}
	public void setEduProfessional(String eduProfessional) {
		this.eduProfessional = eduProfessional;
	}
	public String getGraduate() {
		return graduate;
	}
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getInauguralInstitution() {
		return inauguralInstitution;
	}
	public void setInauguralInstitution(String inauguralInstitution) {
		this.inauguralInstitution = inauguralInstitution;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getExpertsTime() {
		return expertsTime;
	}
	public void setExpertsTime(String expertsTime) {
		this.expertsTime = expertsTime;
	}
	public String getTreatArea() {
		return treatArea;
	}
	public void setTreatArea(String treatArea) {
		this.treatArea = treatArea;
	}
	public String getResearchArea() {
		return researchArea;
	}
	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}
	public String getAcademic() {
		return academic;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getScience() {
		return science;
	}
	public void setScience(String science) {
		this.science = science;
	}
	public String getSocialization() {
		return socialization;
	}
	public void setSocialization(String socialization) {
		this.socialization = socialization;
	}
	public String getThesis() {
		return thesis;
	}
	public void setThesis(String thesis) {
		this.thesis = thesis;
	}
	public String getBookmaking() {
		return bookmaking;
	}
	public void setBookmaking(String bookmaking) {
		this.bookmaking = bookmaking;
	}
	public String getHeritageMap() {
		return heritageMap;
	}
	public void setHeritageMap(String heritageMap) {
		this.heritageMap = heritageMap;
	}
	public String getReferenceMaterial() {
		return referenceMaterial;
	}
	public void setReferenceMaterial(String referenceMaterial) {
		this.referenceMaterial = referenceMaterial;
	}
	public String getBirthplaceDistrictCode() {
		return birthplaceDistrictCode;
	}
	public void setBirthplaceDistrictCode(String birthplaceDistrictCode) {
		this.birthplaceDistrictCode = birthplaceDistrictCode;
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
	public List<InstitutionDepartMapDTO> getInstitutionList() {
		return institutionList;
	}
	public void setInstitutionList(List<InstitutionDepartMapDTO> institutionList) {
		this.institutionList = institutionList;
	}

	
}
