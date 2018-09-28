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
	public void add(T t);
	public void deleteByPrimaryKey(Long id);
	public T select(T t);
	public T selectList(T t);
	public void update(T t);
	
}
