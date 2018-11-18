/**
 * 
 */
package com.med.info.mapper;

import org.apache.ibatis.annotations.Param;

import com.med.info.domain.Miss_control_user;

/**
 * @author jialin.jiang
 *
 */
public interface Miss_control_userMapper extends BaseMapper<Miss_control_user>{

	public Miss_control_user findUserByUnameAndPasswd(@Param("userCode")String userCode, @Param("userPassWord")String userPassWord);
}
