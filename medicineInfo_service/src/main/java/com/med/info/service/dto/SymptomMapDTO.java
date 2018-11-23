package com.med.info.service.dto;

import java.io.Serializable;

/**
 * 症状信息传输实体类
 * @author zhangmin
 */
public class SymptomMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer symptom_id;
	private String symptom_chinese_name;
	private String symptom_english_name;
	
	public Integer getSymptom_id() {
		return symptom_id;
	}
	public void setSymptom_id(Integer symptom_id) {
		this.symptom_id = symptom_id;
	}
	public String getSymptom_chinese_name() {
		return symptom_chinese_name;
	}
	public void setSymptom_chinese_name(String symptom_chinese_name) {
		this.symptom_chinese_name = symptom_chinese_name;
	}
	public String getSymptom_english_name() {
		return symptom_english_name;
	}
	public void setSymptom_english_name(String symptom_english_name) {
		this.symptom_english_name = symptom_english_name;
	}
	
}