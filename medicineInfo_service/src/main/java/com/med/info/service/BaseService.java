/**
 * 
 */
package com.med.info.service;

import com.med.info.domain.BaseDomain;

/**
 * @author jialin.jiang
 *
 */
public interface BaseService<T extends BaseDomain> {
	
	public void add(T t);
	public void deleteByPrimaryKey(Long id);
	public T select(T t);
	public T selectList(T t);
	public void update(T t);

}
