package com.med.info.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.med.info.utils.CollectionUtil;
import com.med.info.utils.StringUtil;

  
/**        
 * Title: 跨域访问处理(跨域资源共享)    
 * Description: 解决前后端分离架构中的跨域问题
 * @author DELETE       
 *    
 */
@Order(1)
@WebFilter(filterName="corsFilter", urlPatterns="/*")
public class CorsFilter implements Filter {

	/** Log4j日志处理(@author: DELETE) */
	private static final Logger log = Logger.getLogger(CorsFilter.class);
	
	@Value("${cors.filter.allowOrigin}")
	private String allowOrigin;
	@Value("${cors.filter.allowMethods}")
	private String allowMethods;
	@Value("${cors.filter.allowCredentials}")
	private String allowCredentials;
	@Value("${cors.filter.allowHeaders}")
	private String allowHeaders;
	@Value("${cors.filter.exposeHeaders}")
	private String exposeHeaders;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("allowOrigin="+allowOrigin);
		log.debug("allowMethods="+allowMethods);
		log.debug("allowCredentials="+allowCredentials);
		log.debug("allowHeaders="+allowHeaders);
		log.debug("exposeHeaders="+exposeHeaders);
		
	}

	  
	/** 
	 * @description 通过CORS技术实现AJAX跨域访问,只要将CORS响应头写入response对象中即可
	 * @author DELETE            
	 * @param req
	 * @param res
	 * @param chain
	 * @throws IOException
	 * @throws ServletException     
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)     
	 */  
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String currentOrigin = request.getHeader("Origin");
		log.debug("currentOrigin : " + currentOrigin);
		if (StringUtil.isNotEmpty(allowOrigin)) {
			List<String> allowOriginList = Arrays
					.asList(allowOrigin.split(","));
			log.debug("allowOriginList : " + allowOrigin);
			if (CollectionUtil.isNotEmpty(allowOriginList)) {
				if (allowOriginList.contains(currentOrigin)) {
					response.setHeader("Access-Control-Allow-Origin",
							currentOrigin);
				}
			}
		}
		if (StringUtil.isNotEmpty(allowMethods)) {
			response.setHeader("Access-Control-Allow-Methods", allowMethods);
		}
		if (StringUtil.isNotEmpty(allowCredentials)) {
			response.setHeader("Access-Control-Allow-Credentials",
					allowCredentials);
		}
		if (StringUtil.isNotEmpty(allowHeaders)) {
			response.setHeader("Access-Control-Allow-Headers", allowHeaders);
		}
		if (StringUtil.isNotEmpty(exposeHeaders)) {
			response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
		}
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
	}
}