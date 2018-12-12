package com.med.info.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.domain.Miss_control_user;
import com.med.info.mapper.domain.UserAndRoleDTO;
import com.med.info.response.PageObject;
import com.med.info.response.Response;
import com.med.info.service.MissControlUserAndRoleService;
import com.med.info.service.UserInfoService;

/**
 * Title: 用户管理 
 * Description: 对用户资源的增删改查
 * 
 * @author DELETE
 * 
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private MissControlUserAndRoleService missControlUserAndRoleService;

	@RequestMapping(method = RequestMethod.POST)
	public Response addUser(@RequestBody Miss_control_user missControlUser) {
		userInfoService.insert(missControlUser);
		return new Response().success();
	}
	
	@RequestMapping(path="/addRole", method = RequestMethod.POST)
	public Response addUserAndRole(@RequestBody UserAndRoleDTO userAndRoleDTO) {
		missControlUserAndRoleService.insertUserAndRole(userAndRoleDTO);
		return new Response().success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public Response deleteUser(String usercode) {
		return new Response().success();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateUser(@RequestBody Miss_control_user controlUser) {
		userInfoService.updateByPrimaryKey(controlUser);
		return new Response().success();
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
	
	@RequestMapping(path="/page", method = RequestMethod.GET)
	public Response selectPage(@RequestParam("currentPage") Integer currentPage, 
			@RequestParam(value="pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value="userName", required = false) String userName) {
		Miss_control_user miss_control_user = new Miss_control_user();
		if(userName != null) {
			miss_control_user.setUserName(userName);
		}
		PageObject<Miss_control_user> selectPage = userInfoService.selectPageByOperateDto(currentPage, pageSize, miss_control_user);
		return new Response().success(selectPage);
	}
}
