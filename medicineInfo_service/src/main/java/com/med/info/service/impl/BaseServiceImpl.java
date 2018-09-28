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
	public void add(T t) {
		// TODO Auto-generated method stub
		getMapper().add(t);
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.BaseService#deleteByPrimaryKey(java.lang.Long)
	 */
	@Override
	public void deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		getMapper().deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.BaseService#select(com.med.info.domain.BaseDomain)
	 */
	@Override
	public T select(T t) {
		// TODO Auto-generated method stub
		return (T) getMapper().select(t);
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.BaseService#selectList(com.med.info.domain.BaseDomain)
	 */
	@Override
	public T selectList(T t) {
		// TODO Auto-generated method stub
		return (T) getMapper().selectList(t);
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.BaseService#update(com.med.info.domain.BaseDomain)
	 */
	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getMapper().update(t);
	}

	public abstract BaseMapper getMapper();
}
