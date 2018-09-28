package com.med.info.utils;

import java.util.UUID;

  
/**        
 * Title: 生成UUID    
 * @author DELETE       
 *     
 */      
public class CodecUtil {
	
	public static String createUUID(){
		return UUID.randomUUID().toString();
	}
}
