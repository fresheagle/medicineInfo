package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_control_user;
import com.med.info.response.Response;
import com.med.info.service.UserInfoService;

/**
 * Title: 用户管理 
 * Description: 对用户资源的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(method = RequestMethod.POST)
	public Response addUser(@RequestBody Miss_control_user controlUser) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteUser(String uuid) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateUser(@RequestBody Miss_control_user controlUser) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Response login(String username, String password) {
		
	}
	
	/**
	 * @description 添加指定Id的用户
	 * @author DELETE
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Miss_control_user all() {
		Miss_control_user user = new Miss_control_user();
//		Miss_control_user select = userInfoService.insert(user );
		return user;
	}
}
