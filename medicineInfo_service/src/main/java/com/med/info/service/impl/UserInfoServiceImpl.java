/**
 * 
 */
package com.med.info.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_control_action;
import com.med.info.domain.Miss_control_user;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_userMapper;
import com.med.info.service.MissControlActionService;
import com.med.info.service.UserInfoService;
import com.med.info.service.dto.LoginInfoDTO;
import com.med.info.service.dto.UserPrivilegeDTO;

/**
 * @author jialin.jiang
 *
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<Miss_control_user> implements UserInfoService{

	@Resource
	Miss_control_userMapper miss_control_userMapper;
	@Autowired
	private MissControlActionService controlActionService;
	
	
	/* (non-Javadoc)
	 * @see com.med.info.service.UserInfoService#findUserByUnameAndPasswd(java.lang.String, java.lang.String)
	 */
	@Override
	public Miss_control_user findUserByUnameAndPasswd(String userCode, String userPassWord) {
		// TODO Auto-generated method stub
		return miss_control_userMapper.findUserByUnameAndPasswd(userCode, userPassWord);
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.impl.BaseServiceImpl#getMapper()
	 */
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return miss_control_userMapper;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.UserInfoService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String userCode, String userPassWord) {
		// TODO Auto-generated method stub
		Miss_control_user findUserByUnameAndPasswd = this.findUserByUnameAndPasswd(userCode, userPassWord);
		if(null == findUserByUnameAndPasswd) {
			return false;
		}
		return true;
	}

	@Override
	public LoginInfoDTO getLoginInfo(String userCode, String userPassWord) throws Exception {
		LoginInfoDTO result = new LoginInfoDTO();
		Miss_control_user findUserByUnameAndPasswd = this.findUserByUnameAndPasswd(userCode, userPassWord);
		if(null != findUserByUnameAndPasswd) {
			List<Miss_control_action> controlActionsByUserCode = controlActionService.getControlActionsByUserCode(userCode);
			UserPrivilegeDTO userPrivilege = new UserPrivilegeDTO();
			result.setUserPrivilege(userPrivilege );
			return result;
		}
		throw new Exception("登录失败，获取用户为空");
	}

}
