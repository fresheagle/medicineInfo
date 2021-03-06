/**
 * 
 */
package com.med.info.service;

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
	public int updateByPrimaryKeySelective(T t);
	public void updateByTaskIdSelective(T t);
	
	public T selectByPrimaryId(Long id);

	public PageObject<T> selectPage(Integer currentPage, Integer pageSize, T t);

	public PageObject<T> selectPageByOperateDto(Integer currentPage, Integer pageSize, T t);
}
