/**
 * 
 */
package com.med.info.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.med.info.domain.Miss_control_user;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_userMapper;
import com.med.info.service.UserInfoService;

/**
 * @author jialin.jiang
 *
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<Miss_control_user> implements UserInfoService{

	@Resource
	Miss_control_userMapper miss_control_userMapper;
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

}
