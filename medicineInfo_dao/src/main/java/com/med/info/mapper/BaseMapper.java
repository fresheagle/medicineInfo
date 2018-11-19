/**
 * 
 */
package com.med.info.mapper;

import com.med.info.domain.BaseDomain;

/**
 * @author jialin.jiang
 *
 */
public interface BaseMapper<T extends BaseDomain> {
	public int insert(T t);
	public int deleteByPrimaryKey(Long id);
	public T selectByPrimaryKey(T t);
	public int updateByPrimaryKey(T t);
	
}
