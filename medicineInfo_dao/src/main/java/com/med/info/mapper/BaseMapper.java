/**
 * 
 */
package com.med.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author jialin.jiang
 *
 */
public interface BaseMapper<T> {
	public int insert(T t);
	public int deleteByPrimaryKey(Long id);
	public T selectByPrimaryKey(T t);
	public int updateByPrimaryKey(T t);
	public void updateByTaskIdSelective(T t);

	/**
	 * 翻页查询所有数据
	 * @return
	 */
	public List<T> showDataByPage();

	/**
	 * 查询所有结果数据
	 * @return
	 */
	public List<T> showDataAll();

	/**
	 * 根据条件查询结果
	 * @param t
	 * @return
	 */
	public List<T> showDataCondition(T t);
	/**
	 * @author jialin.jiang
	 * Function: TODO ADD FUNCTION. <br/> 
	 * @param t
	 * @return
	 */
	public int updateByPrimaryKeySelective(T t);
	
	public List<T> exportSQL(@Param("taskId")List<String> taskId);
}