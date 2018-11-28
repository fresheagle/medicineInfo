package com.med.info.utils;

public enum TrialStatusEnum {
	
	DRAFTS("drafts","草稿箱"),
	TO_FIRST_AUDITED("toFirAudited","待初审"),
	TO_SECOND_AUDITED("toSecAudited","待二审"),
	TO_FINAL_AUDITED("toFinalAudited","待终审"),
	FINISHED("finished","已完成任务"),
	DISCARDED("discarded","已废止任务");
	
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
