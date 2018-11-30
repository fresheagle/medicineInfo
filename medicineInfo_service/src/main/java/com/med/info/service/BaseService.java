/**
 * 
 */
package com.med.info.service;

import com.med.info.domain.BaseDomain;
import com.med.info.response.PageObject;

/**
 * @author jialin.jiang
 *
 */
public interface BaseService<T> {
	
	public int insert(T t);
	public int deleteByPrimaryKey(Long id);
	public T selectByPrimaryKey(T t);
	public int updateByPrimaryKey(T t);
	public void updateByTaskIdSelective(T t);

	public PageObject<T> selctPage(Integer currentPage, Integer pageSize, T t);
}
