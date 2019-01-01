package com.med.info.service;

import com.med.info.mapper.domain.LoginInfoDTO;

/**
 * Title: REST 鉴权   
 * Description: 登录用户的身份鉴权
 * @author DELETE       
 *     
 */      
public interface TokenManager {

	String createToken(LoginInfoDTO userCode);

    boolean checkToken(String token); 
    
    void deleteToken(String token);
    
   boolean isTokenExpire(String token);
}
