/**
 * 
 */
package com.med.info.domain;

import java.util.Date;

/**
 * @author jialin.jiang
 *
 */
public abstract class BaseDomain {

	private Integer id;
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	
}
