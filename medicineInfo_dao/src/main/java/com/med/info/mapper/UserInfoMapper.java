/**
 * 
 */
package com.med.info.mapper;

import org.apache.ibatis.annotations.Param;

import com.med.info.domain.UserInfo;

/**
 * @author jialin.jiang
 *
 */
public interface UserInfoMapper extends BaseMapper<UserInfo>{

	public UserInfo findUserByUnameAndPasswd(@Param("uname")String uname, @Param("passwd")String passwd);
}
