package cn.com.med.info.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.med.info.model.entity.User;
import cn.com.med.info.service.UserService;

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

	private UserService userService;
	/** Log4j日志处理(@author: rico) */
	private static final Logger log = Logger.getLogger(UserController.class);
	
	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @description 获取指定Id的用户
	 * @author DELETE
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getUser(@PathVariable("id") int id) {
		User user = (User) userService.getUser(id);
		log.debug("查询用户 :" + user);
		return user;
	}

	/**
	 * @description 添加指定Id的用户
	 * @author DELETE
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json", 
			consumes = "application/json")
	public User addUser(@RequestBody @Valid User user) {
		userService.addUser(user);
		log.debug("添加用户 :" + user);
		return user;
	}
}
