package com.med.info.utils;

public enum TrialStatusEnum {
	
	CREATING("1","创建中"),
	FIRST_TRIAL("2","待初审"),
	SECOND_TRIAL("3","待二审"),
	FINAL_TRIAL("4","待终审"),
	END_TRIAL("5","审批完成"),
	DELETE_TRIAL("6","草稿箱");
	
	private String id;
	private String desc;
	
	private TrialStatusEnum(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
