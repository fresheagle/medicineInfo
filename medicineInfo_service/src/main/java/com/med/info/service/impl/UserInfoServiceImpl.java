/**
 * 
 */
package com.med.info.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.med.info.domain.UserInfo;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.UserInfoMapper;
import com.med.info.service.UserInfoService;

/**
 * @author jialin.jiang
 *
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService{

	@Resource
	UserInfoMapper userInfoMapper;
	/* (non-Javadoc)
	 * @see com.med.info.service.UserInfoService#findUserByUnameAndPasswd(java.lang.String, java.lang.String)
	 */
	@Override
	public UserInfo findUserByUnameAndPasswd(String uname, String passwd) {
		// TODO Auto-generated method stub
		return userInfoMapper.findUserByUnameAndPasswd(uname, passwd);
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.impl.BaseServiceImpl#getMapper()
	 */
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return userInfoMapper;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.UserInfoService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String uname, String passwd) {
		// TODO Auto-generated method stub
		UserInfo findUserByUnameAndPasswd = this.findUserByUnameAndPasswd(uname, passwd);
		if(null == findUserByUnameAndPasswd) {
			return false;
		}
		return true;
	}

}
