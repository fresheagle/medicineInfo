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
//	public static String withOutHtml(String str) {
//		String regEx = "(?!<(sup|p|sub).*?>)<.*?>";
//		Pattern p_html = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
//		Matcher m_html = p_html.matcher(str);
//		str = m_html.replaceAll("");
//		return str;
//	}
	
	/**
	 * @description 把字符串中的html标签去掉
	 * @author DELETE         
	 * @param str
	 * @return  strWithoutHTML  
	 */
	public static String withOutHtml(String htmlStr){ 
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

        htmlStr = htmlStr.replaceAll("<p .*?>", "\r\n"); 
        // <br><br/>替换为换行 
        htmlStr = htmlStr.replaceAll("<br\\s*/?>", "\r\n"); 
        // 去掉其它的<>之间的东西 
        htmlStr = htmlStr.replaceAll("\\<.*?>", ""); 
        
        return htmlStr.trim(); //返回文本字符串 
    } 
}
