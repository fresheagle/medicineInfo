package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.UserInfo;
import com.med.info.service.UserInfoService;

/**
 * Title: 用户管理 
 * Description: 对用户资源的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserInfoService userInfoService;


	/**
	 * @description 添加指定Id的用户
	 * @author DELETE
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public UserInfo all() {
		UserInfo user = new UserInfo();
		UserInfo select = userInfoService.select(user );
		return select;
	}
}
