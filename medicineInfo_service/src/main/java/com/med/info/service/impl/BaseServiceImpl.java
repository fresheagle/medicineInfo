package com.med.info.service.impl;

import com.med.info.domain.BaseDomain;
import com.med.info.mapper.BaseMapper;
import com.med.info.service.BaseService;

/**
 * @author jialin.jiang
 *
 */
public abstract class BaseServiceImpl<T extends BaseDomain> implements BaseService<T>{

	/* (non-Javadoc)
	 * @see com.med.info.service.BaseService#add(com.med.info.domain.BaseDomain)
	 */
	@Override
	public int insert(T t) {
		// TODO Auto-generated method stub
		return getMapper().insert(t);
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.BaseService#deleteByPrimaryKey(java.lang.Long)
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return getMapper().deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.BaseService#select(com.med.info.domain.BaseDomain)
	 */
	@Override
	public T selectByPrimaryKey(T t) {
		// TODO Auto-generated method stub
		return (T) getMapper().selectByPrimaryKey(t);
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.BaseService#update(com.med.info.domain.BaseDomain)
	 */
	@Override
	public int updateByPrimaryKey(T t) {
		// TODO Auto-generated method stub
		return getMapper().updateByPrimaryKey(t);
	}

	public abstract BaseMapper getMapper();
}
