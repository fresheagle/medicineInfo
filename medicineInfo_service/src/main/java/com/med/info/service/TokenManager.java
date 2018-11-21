package com.med.info.service;

/**        
 * Title: REST 鉴权   
 * Description: 登录用户的身份鉴权
 * @author DELETE       
 *     
 */      
public interface TokenManager {

	String createToken(String userCode);  

    boolean checkToken(String token); 
    
    void deleteToken(String token);
    
   boolean isTokenExpire(String token);
}
