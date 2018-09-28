package com.med.info.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

  
/**        
 * Title: Web上下文工具类
 * @author DELETE       
 *     
 */      
public class WebContextUtil {
	  
	/**     
	 * @description 获取HTTP请求    
	 * @author DELETE           
	 * @return     
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		
		return request;
	}
}
