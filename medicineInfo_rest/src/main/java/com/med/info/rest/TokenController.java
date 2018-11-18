package com.med.info.rest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.annotation.IgnoreSecurity;
import com.med.info.response.Response;
import com.med.info.service.TokenManager;
import com.med.info.service.UserInfoService;
import com.med.info.utils.Constants;
  
/**        
 * Title: Token的管理    
 * Description: 处理用户的登录、登出操作
 * @author DELETE       
 *   
 */      
@RestController
@RequestMapping("/tokens")
public class TokenController {

	@Autowired
	private UserInfoService userService;
	@Autowired
	private TokenManager tokenManager;
	
	private static final Logger log = Logger.getLogger(TokenController.class);

	/**     
	 * @description 登录处理
	 * @author DELETE       
	 */
	@RequestMapping(method = RequestMethod.POST)
	@IgnoreSecurity
	public Response login(@RequestParam("userCode") String userCode,
			@RequestParam("userPassWord") String userPassWord, HttpServletResponse response) {
		boolean flag = userService.login(userCode, userPassWord);
		if (flag) {
			String token = tokenManager.createToken(userCode);
			log.debug("**** Generate Token **** : " + token);
			Cookie cookie = new Cookie(Constants.DEFAULT_TOKEN_NAME, token);
			log.debug("Write Token to Cookie and return to the Client : " + cookie.toString());
			response.addCookie(cookie);
			return new Response().success("Login Success...");
		}
		return new Response().failure("Login Failure...");
	}

	/**     
	 * @description 登出处理
	 * @author DELETE       
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	@IgnoreSecurity
	public Response logout(HttpServletRequest request) {
		String token = request.getHeader(Constants.DEFAULT_TOKEN_NAME);
		tokenManager.deleteToken(token);
		log.debug("Logout Success...");
		return new Response().success("Logout Success...");
	}
}
