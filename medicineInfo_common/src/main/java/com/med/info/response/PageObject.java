package com.med.info.response;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long total;
	private Integer currentPage;
	private List<T> params;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<T> getParams() {
		return params;
	}
	public void setParams(List<T> params) {
		this.params = params;
	}
	
	
}
