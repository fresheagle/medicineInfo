/**
 * 
 */
package com.med.info.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

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
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
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
		// TODO Auto-generated method stub
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String uri = servletRequest.getRequestURI();
		if(null != uriPrivileges && !uriPrivileges.isEmpty()) {
			String string = (String) uriPrivileges.get(uri);
			logger.info("uri={},对应需要的权限码为 {}",uri,string);
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
