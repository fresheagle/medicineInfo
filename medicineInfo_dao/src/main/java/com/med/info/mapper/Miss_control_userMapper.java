/**
 * 
 */
package com.med.info.mapper;

import org.apache.ibatis.annotations.Param;

import com.med.info.domain.Miss_control_user;

import java.util.List;

/**
 * @author jialin.jiang
 *
 */
public interface Miss_control_userMapper extends BaseMapper<Miss_control_user>{

	public Miss_control_user findUserByUnameAndPasswd(@Param("userCode")String userCode, @Param("userPassWord")String userPassWord);

	public int deleteUserByCode(String userCode);
	
	public Miss_control_user selectByCode(String userCode);

    List<String> selectUserCodeByNames(List<String> names);

    public String getUserRoleCode(String userCode);
}
