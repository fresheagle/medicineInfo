package com.med.info.dto;

import java.util.List;

public class BatchAcountsDTO {
	private List<String> tasks;
    /**
     *传递需要修改的结算状态：
     * 
     */

    private String accounts;
	public String getAccounts() {
		return accounts;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
	public List<String> getTasks() {
		return tasks;
	}
	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}
}
