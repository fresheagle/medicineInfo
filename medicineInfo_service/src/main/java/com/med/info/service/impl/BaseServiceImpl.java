package com.med.info.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.med.info.domain.BaseDomain;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.domain.DiseaseDTO;
import com.med.info.mapper.domain.OperateDTO;
import com.med.info.response.PageObject;
import com.med.info.service.BaseService;

/**
 * @author jialin.jiang
 *
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{

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

	@Override
	public T selectByPrimaryId(Long id) {
		// TODO Auto-generated method stub
		return (T)getMapper().selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.BaseService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(T t) {
		// TODO Auto-generated method stub
		return getMapper().updateByPrimaryKeySelective(t);
	}
	
	@Override
	public void updateByTaskIdSelective(T t) {
		getMapper().updateByTaskIdSelective(t);
	}
	
	@Override
	public PageObject<T> selectPage(Integer currentPage, Integer pageSize, T t) {
		PageHelper.startPage(currentPage, pageSize);
		Page<T> showDataCondition = (Page<T>) getMapper().showDataCondition(t);
		PageObject object = new PageObject<T>();
		object.setCurrentPage(showDataCondition.getPageNum());
		object.setParams(showDataCondition);
		object.setTotal(showDataCondition.getTotal());
		return object;
	}
	@Override
	public PageObject<T> selectPageByOperateDto(Integer currentPage, Integer pageSize, T t){
		PageHelper.startPage(currentPage, pageSize);
		Page<T> showDataCondition = (Page<T>) getMapper().showDataCondition(t);
		List<OperateDTO> listOp = new ArrayList<>();
		for ( int i=0;i<showDataCondition.size();i++) {
			OperateDTO operateDTO = new OperateDTO();
			JSONObject json = new JSONObject();
			json.put(getKeyName(), JSONObject.parseObject(JSONObject.toJSONString(showDataCondition.get(i))));
			operateDTO.setJsonStr(json );
			operateDTO.setTaskMenuType(getKeyName());
			listOp.add(operateDTO);
		}
		PageObject object = new PageObject<T>();
		object.setCurrentPage(showDataCondition.getPageNum());
		object.setParams(listOp);
		object.setTotal(showDataCondition.getTotal());
		return object;
	}
	
	public abstract BaseMapper getMapper();

	public String getKeyName(){
		return "key";
	}

	
	public OperateDTO converseToOperataDTO(Object o) {
		OperateDTO operateDTO = new OperateDTO();
		JSONObject json =  JSONObject.parseObject(JSONObject.toJSONString(o));
		operateDTO.setJsonStr(json);
		operateDTO.setTaskMenuType(getKeyName());
		return operateDTO;
	}
}
