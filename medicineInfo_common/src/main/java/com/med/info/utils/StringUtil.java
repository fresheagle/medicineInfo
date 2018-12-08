package com.med.info.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**        
 * Title: 字符串工具类    
 * @author DELETE       
 *     
 */      
public class StringUtil {
	  
	/**     
	 * @description 给定字符串是否为空或空串
	 * @author DELETE        
	 * @param str
	 * @return     
	 */
	public static boolean isNotEmpty(String str) {
		if (str != null && str.length() != 0) {
			return true;
		}
		return false;
	}

	/**     
	 * @description 给定字符串是否为空或空串
	 * @author DELETE         
	 * @param str
	 * @return     
	 */
	public static boolean isEmpty(String str) {
		if (str != null && str.length() != 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description 把字符串中的html标签去掉
	 * @author DELETE         
	 * @param str
	 * @return  strWithoutHTML  
	 */
	public static String withOutHtml(String str) {
		String regEx = "(?!<(sup|p|sub).*?>)<.*?>";
		Pattern p_html = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(str);
		str = m_html.replaceAll("");
		return str;
	}
}
