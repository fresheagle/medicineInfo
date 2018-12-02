package com.med.info.mapper.domain;

import java.io.Serializable;

/**
 * 症状信息传输实体类
 * @author zhangmin
 */
public class SymptomMapDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String chineseName;
	private String englishName;
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
	
	
}