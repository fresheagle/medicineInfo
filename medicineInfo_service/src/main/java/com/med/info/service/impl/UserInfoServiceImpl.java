/**
 * 
 */
package com.med.info.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.med.info.domain.Miss_control_action;
import com.med.info.domain.Miss_control_user;
import com.med.info.mapper.BaseMapper;
import com.med.info.mapper.Miss_control_userMapper;
import com.med.info.mapper.domain.LoginInfoDTO;
import com.med.info.mapper.domain.UserPrivilegeDTO;
import com.med.info.response.PageObject;
import com.med.info.service.MissControlActionService;
import com.med.info.service.UserInfoService;
import com.med.info.utils.StringUtil;

/**
 * @author jialin.jiang
 *
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<Miss_control_user> implements UserInfoService {

	@Resource
	Miss_control_userMapper miss_control_userMapper;
	@Autowired
	private MissControlActionService controlActionService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.med.info.service.UserInfoService#findUserByUnameAndPasswd(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public Miss_control_user findUserByUnameAndPasswd(String userCode, String userPassWord) {
		// TODO Auto-generated method stub
		return miss_control_userMapper.findUserByUnameAndPasswd(userCode, userPassWord);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.med.info.service.impl.BaseServiceImpl#getMapper()
	 */
	@Override
	public BaseMapper getMapper() {
		// TODO Auto-generated method stub
		return miss_control_userMapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.med.info.service.UserInfoService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean login(String userCode, String userPassWord) {
		// TODO Auto-generated method stub
		Miss_control_user findUserByUnameAndPasswd = this.findUserByUnameAndPasswd(userCode, userPassWord);
		if (null == findUserByUnameAndPasswd) {
			return false;
		}
		return true;
	}

	@Override
	public int deleteUserByCode(String userCode) {
		return miss_control_userMapper.deleteUserByCode(userCode);
	}

	@Override
	public LoginInfoDTO getLoginInfo(String userCode, String userPassWord) throws Exception {
		LoginInfoDTO result = new LoginInfoDTO();
		Miss_control_user findUserByUnameAndPasswd = this.findUserByUnameAndPasswd(userCode, userPassWord);
		result.setUserCode(findUserByUnameAndPasswd.getUserCode());
		result.setUserName(findUserByUnameAndPasswd.getUserName());
		result.setUserUuid(findUserByUnameAndPasswd.getUserUuid());
		List<UserPrivilegeDTO> userPrivilege = new ArrayList<>();
		result.setUserPrivilege(userPrivilege );
		if (null != findUserByUnameAndPasswd) {
			List<Miss_control_action> controlActionsByUserCode = controlActionService
					.getControlActionsByUserCode(userCode);

			Stream<Miss_control_action> miss_control_actionStream = controlActionsByUserCode.stream()
					.filter(action -> null != action && StringUtil.isEmpty(action.getActionparentcode()));
			List<Miss_control_action> firstLevel = miss_control_actionStream.collect(Collectors.toList());
			for (Miss_control_action miss_control_action : firstLevel) {
				UserPrivilegeDTO firstPrivilege = new UserPrivilegeDTO();
				firstPrivilege.setName(miss_control_action.getActionname());
				firstPrivilege.setPath(miss_control_action.getActioncode());
				List<UserPrivilegeDTO> children = new ArrayList<>();
				firstPrivilege.setChildren(children );
				List<Miss_control_action> secondLevel = controlActionsByUserCode.stream()
						.filter(action -> (null != action && null != action.getActionparentcode() && action.getActionparentcode().equals(miss_control_action.getActioncode())))
						.collect(Collectors.toList());
				for (Miss_control_action miss_control_action2 : secondLevel) {
					UserPrivilegeDTO secondPrivilege = new UserPrivilegeDTO();
					secondPrivilege.setName(miss_control_action2.getActionname());
					secondPrivilege.setPath(miss_control_action2.getActioncode());
					children.add(secondPrivilege);
				}
				userPrivilege.add(firstPrivilege);
			}
			result.setRoleCodes(miss_control_userMapper.getUserRoleCode(result.getUserCode() == null ? "":result.getUserCode()));
//			result.setRoleCode("001");
			return result;
		}
		throw new Exception("登录失败，获取用户为空");
	}

	@Override
	public PageObject<String> selectByCode(String userCode, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		Page<String> codeList = (Page<String>)miss_control_userMapper.selectCode(userCode);
		PageObject object = new PageObject<String>();
		object.setCurrentPage(codeList.getPageNum());
		object.setParams(codeList);
		object.setTotal(codeList.getTotal());
		return object;
	}


}
