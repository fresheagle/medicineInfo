package com.med.info.utils;

public enum TrialStatusEnum {
	
	DRAFTS("drafts","草稿"),
	RECYCLE("recycle","回收站"),
	TO_FIRST_AUDITED("toFirAudited","待初审"),
	FIRST_AUDITEDING("firAuditeding","初审中"),
	FIRST_AUDITED_FAILED("firAuditedFailed","初审未通过"),
	FIRST_AUDITED_SUCCESS("firAuditedSuccess","初审通过"),

	TO_SECOND_AUDITED("toSecAudited","待二审"),
	SECOND_AUDITEDING("secAuditeding","二审中"),
	SECOND_AUDITED_FAILED("secAuditedFailed","二审未通过"),
	SECOND_AUDITED_SUCCESS("secAuditedSuccess","二审通过"),

	TO_FINAL_AUDITED("toFinalAudited","待终审"),
	FINAL_AUDITEDING("finalAuditeding","终审中"),
	FINAL_AUDITED_FAILED("finalAuditedFailed","终审未通过"),
	FINAL_AUDITED_SUCCESS("finished","终审通过"),
	OFFLINE("offline","下线"),
	ONLINE("online","上线");

	
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

	public static TrialStatusEnum getTrialStatusEnum(String id){
		for (TrialStatusEnum value : TrialStatusEnum.values()) {
			if(value.getId().equals(id)){
				return value;
			}
		}
		return null;
	}
	
}
