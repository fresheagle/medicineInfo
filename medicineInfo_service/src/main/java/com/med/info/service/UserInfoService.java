/**
 * 
 */
package com.med.info.service;

import com.med.info.domain.Miss_control_user;
import com.med.info.mapper.domain.LoginInfoDTO;

/**
 * @author jialin.jiang
 *
 */
public interface UserInfoService extends BaseService<Miss_control_user>{

	
	public Miss_control_user findUserByUnameAndPasswd( String userCode, String userPassWord);
	
	public LoginInfoDTO getLoginInfo( String userCode, String userPassWord) throws Exception;
	
	/**     
	 * @description 用户登录逻辑
	 * @author DELETE        
	 * @param userCode
	 * @param passwd
	 * @return     
	 */
	public boolean login(String userCode, String userPassWord);

	public int deleteUserByCode(String userCode);
}
