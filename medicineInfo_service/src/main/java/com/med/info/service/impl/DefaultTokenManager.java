package com.med.info.service.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.med.info.mapper.domain.LoginInfoDTO;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.med.info.service.TokenManager;
import com.med.info.utils.CodecUtil;
import com.med.info.utils.StringUtil;
  
/**        
 * Title: TokenManager的默认实现    
 * Description: 管理 Token
 * @author DELETE       
 *   
 */
@Component("tokenManager")
public class DefaultTokenManager implements TokenManager, CommandLineRunner {
	/** token过期时间，默认10分钟 **/
	@Value("${token.expire.time:40}")
	private static Integer token_expire_time = 40;
	
	/** 将token存储到JVM内存(ConcurrentHashMap)中   (@author: DELETE) */      
	private static Map<LoginInfoDTO, String> tokenMap = new ConcurrentHashMap<>();
	
	private static Map<String, Long> tokenExpire = new ConcurrentHashMap<>();
	
	private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
	
	private static Logger logger = LoggerFactory.getLogger(DefaultTokenManager.class);
	
	private static ThreadLocal<LoginInfoDTO> local = new ThreadLocal<>();
	

	/** 
	 * @description 利用UUID创建Token(用户登录时，创建Token)
	 * @author DELETE       
	 * @param loginInfo
	 * @return     
	 */
	public String createToken(LoginInfoDTO loginInfo) {
		String token = CodecUtil.createUUID();
		tokenMap.put(loginInfo, token);
		tokenExpire.put(token, System.currentTimeMillis() + token_expire_time * 60 * 1000);
		return token;
	}
	  
	/** 
	 * @description Token验证(用户登录验证)
	 * @author DELETE        
	 * @param token
	 * @return     
	 */
	public boolean checkToken(String token) {
//		if(!StringUtil.isEmpty(token) && token.equals("test_token")){
//			LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
//			loginInfoDTO.setRoleCode("001");
//			loginInfoDTO.setUserCode("test1");
//			local.set(loginInfoDTO);
//			return true;
//		}
//		return false;
//
//		先注释掉使用上面写死的token
		if(!StringUtil.isEmpty(token) && tokenMap.containsValue(token)) {
			if(!isTokenExpire(token)) {
				tokenExpire.put(token, System.currentTimeMillis() + token_expire_time * 60 * 1000);
				local.set(getTokenLoginInfo(token));
				return true;
			}
		}
		return false;
	}
	
	private String getTokenUserCode(String token) {
		Set<Entry<LoginInfoDTO, String>> entrySet = tokenMap.entrySet();
		for (Entry<LoginInfoDTO, String> entry : entrySet) {
			if(entry.getValue().equals(token)) {
				return entry.getKey().getUserName();
			}
		}
		return null;
	}

	private LoginInfoDTO getTokenLoginInfo(String token){
		Set<Entry<LoginInfoDTO, String>> entrySet = tokenMap.entrySet();
		for (Entry<LoginInfoDTO, String> entry : entrySet) {
			if(entry.getValue().equals(token)) {
				return entry.getKey();
			}
		}
		return null;
	}


	@Override
	public boolean isTokenExpire(String token) {
		Long long1 = tokenExpire.get(token);
		if(null == long1 || long1 < System.currentTimeMillis()) {
			return true;
		}
		return false;
	}
	  
	/** 
	 * @description Token删除(用户登出时，删除Token)
	 * @author DELETE           
	 * @param token     
	 */
	@Override
	public void deleteToken(String token) {
		Collection<String> col = tokenMap.values();
		while(true == col.contains(token)) {
		    col.remove(token);
		}
	}
	
	@Override
	/**
	 * 定时扫描数据判断token是否过期
	 */
	public void run(String... args) throws Exception {
		executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				try {
					Set<Entry<String, Long>> entrySet = tokenExpire.entrySet();
					Iterator<Entry<String, Long>> iterator = entrySet.iterator();
					while (iterator.hasNext()) {
						Map.Entry<java.lang.String, java.lang.Long> entry = (Map.Entry<java.lang.String, java.lang.Long>) iterator
								.next();
						if(entry.getValue() < System.currentTimeMillis()) {
							iterator.remove();
							deleteToken(entry.getKey());
						}
					}
				} catch (Exception e) {
					logger.error("执行CRM 获取数据定时线程失败",e);
				}
			}
		}, 0, token_expire_time, TimeUnit.MINUTES);
	}

	public static LoginInfoDTO getLocalUserCode() {
		return local.get();
	}
	
	public static Integer getToken_expire_time() {
		return token_expire_time;
	}

	public static void setToken_expire_time(Integer token_expire_time) {
		DefaultTokenManager.token_expire_time = token_expire_time;
	}

	public static Map<LoginInfoDTO, String> getTokenMap() {
		return tokenMap;
	}

	public static void setTokenMap(Map<LoginInfoDTO, String> tokenMap) {
		DefaultTokenManager.tokenMap = tokenMap;
	}

	public static Map<String, Long> getTokenExpire() {
		return tokenExpire;
	}

	public static void setTokenExpire(Map<String, Long> tokenExpire) {
		DefaultTokenManager.tokenExpire = tokenExpire;
	}
}
