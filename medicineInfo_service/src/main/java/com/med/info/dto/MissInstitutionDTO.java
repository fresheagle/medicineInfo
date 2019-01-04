package com.med.info.dto;

import com.med.info.mapper.domain.DepartmentMapDTO;
import com.med.info.mapper.domain.PictureInfoDTO;

import java.io.Serializable;
import java.util.List;

public class MissInstitutionDTO implements Serializable {

    private Long id;

    private String name;

    private String level;

    private String districtCode;

    private String address;

    private String thumbnail;

    private String nature;

    private String category;

    private String insurance;

    private String foundDate;

    private String manageDepartment;

    private String telephone;

    private String website;

    private String publishService;

    private String dean;

    private Long parentId;

    private String emergencyTime;

    private String outpatientTime;

    private String registrationTime;

    private String datastatus;

    private String taskId;

    private String taskStatus;

    private String type;

    private String provinceCode;

    private String cityCode;

    private String picturepath;

    private String advantage;

    private String punishment;

    private String history;

    private List<PictureInfoDTO> environment;

    private String treatGuide;

    private String intro;

    private String researchResult;

    private String academicMonograph;

    private String academicActivity;

    private String honor;

    private String reference;

    private String license;

    private String advertiseReviewCertify;

    private String taskJson;

    private List<PictureInfoDTO> leadteamInfo;

    private String affgroup;

    private String special;

    private String equipment;

    private String emergencyRoom;

    private String appointmentConsultation;

    private String busLines;

    private String clinicalTeaching;

    private List<DepartmentMapDTO> departmentMapDTO;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

    public String getManageDepartment() {
        return manageDepartment;
    }

    public void setManageDepartment(String manageDepartment) {
        this.manageDepartment = manageDepartment;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPublishService() {
        return publishService;
    }

    public void setPublishService(String publishService) {
        this.publishService = publishService;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getEmergencyTime() {
        return emergencyTime;
    }

    public void setEmergencyTime(String emergencyTime) {
        this.emergencyTime = emergencyTime;
    }

    public String getOutpatientTime() {
        return outpatientTime;
    }

    public void setOutpatientTime(String outpatientTime) {
        this.outpatientTime = outpatientTime;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getDatastatus() {
        return datastatus;
    }

    public void setDatastatus(String datastatus) {
        this.datastatus = datastatus;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public  List<PictureInfoDTO> getEnvironment() {
        return environment;
    }

    public void setEnvironment( List<PictureInfoDTO> environment) {
        this.environment = environment;
    }

    public String getTreatGuide() {
        return treatGuide;
    }

    public void setTreatGuide(String treatGuide) {
        this.treatGuide = treatGuide;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getResearchResult() {
        return researchResult;
    }

    public void setResearchResult(String researchResult) {
        this.researchResult = researchResult;
    }

    public String getAcademicMonograph() {
        return academicMonograph;
    }

    public void setAcademicMonograph(String academicMonograph) {
        this.academicMonograph = academicMonograph;
    }

    public String getAcademicActivity() {
        return academicActivity;
    }

    public void setAcademicActivity(String academicActivity) {
        this.academicActivity = academicActivity;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getAdvertiseReviewCertify() {
        return advertiseReviewCertify;
    }

    public void setAdvertiseReviewCertify(String advertiseReviewCertify) {
        this.advertiseReviewCertify = advertiseReviewCertify;
    }

    public String getTaskJson() {
        return taskJson;
    }

    public void setTaskJson(String taskJson) {
        this.taskJson = taskJson;
    }

    public List<PictureInfoDTO> getLeadteamInfo() {
        return leadteamInfo;
    }

    public void setLeadteamInfo(List<PictureInfoDTO> leadteamInfo) {
        this.leadteamInfo = leadteamInfo;
    }

    public String getAffgroup() {
        return affgroup;
    }

    public void setAffgroup(String affgroup) {
        this.affgroup = affgroup;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getEmergencyRoom() {
        return emergencyRoom;
    }

    public void setEmergencyRoom(String emergencyRoom) {
        this.emergencyRoom = emergencyRoom;
    }

    public String getAppointmentConsultation() {
        return appointmentConsultation;
    }

    public void setAppointmentConsultation(String appointmentConsultation) {
        this.appointmentConsultation = appointmentConsultation;
    }

    public String getBusLines() {
        return busLines;
    }

    public void setBusLines(String busLines) {
        this.busLines = busLines;
    }

    public String getClinicalTeaching() {
        return clinicalTeaching;
    }

    public void setClinicalTeaching(String clinicalTeaching) {
        this.clinicalTeaching = clinicalTeaching;
    }

    public List<DepartmentMapDTO> getDepartmentMapDTO() {
        return departmentMapDTO;
    }

    public void setDepartmentMapDTO(List<DepartmentMapDTO> departmentMapDTO) {
        this.departmentMapDTO = departmentMapDTO;
    }
}
