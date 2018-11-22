/**
 * 
 */
package com.med.info.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import com.alibaba.fastjson.JSON;
import com.med.info.response.Response;
import com.med.info.service.TokenManager;
import com.med.info.utils.Constants;

/**
 * @author jialin.jiang
 *
 */
@Order(2)
@WebFilter(filterName="userPrivilegeFilter", urlPatterns="/*")
public class UserPrivilegeFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(UserPrivilegeFilter.class);
	
	@Autowired
	private HashMap uriPrivileges;
	@Value("${web.filter.no.token.urls}")
	private List<String> noTokenUrls;
	@Autowired
	private TokenManager tokenManager;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String uri = servletRequest.getRequestURI();
		if(!noTokenUrls.contains(uri)) {
			if(null != uriPrivileges && !uriPrivileges.isEmpty()) {
				String string = (String) uriPrivileges.get(uri);
				HttpServletRequest httpServletRequest = (HttpServletRequest) request;
				Cookie[] cookies = httpServletRequest.getCookies();
				String token = null;
				for (Cookie cookie : cookies) {
					if(cookie.getName().equals(Constants.DEFAULT_TOKEN_NAME)) {
						token = cookie.getValue();
					}
				}
				if(null == token || !tokenManager.checkToken(token)) {
					response.getWriter().write(JSON.toJSONString(new Response().failure("未登录或登录已过期，请重新登录")));
					return;
				}
				logger.info("uri={},对应需要的权限码为 {}",uri,string);
			}
		}else {
			logger.info("当前请求为{}，跳过token认证",uri);
		}
		chain.doFilter(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
