/**
 * 
 */
package com.med.info.service;

import com.med.info.domain.UserInfo;

/**
 * @author jialin.jiang
 *
 */
public interface UserInfoService extends BaseService<UserInfo>{

	
	public UserInfo findUserByUnameAndPasswd( String uname, String passwd);
	
	/**     
	 * @description 用户登录逻辑
	 * @author DELETE        
	 * @param uname
	 * @param passwd
	 * @return     
	 */
	public boolean login(String uname, String passwd);
}
