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
	@Value("${token.expire.time:10}")
	private static Integer token_expire_time = 10;
	
	/** 将token存储到JVM内存(ConcurrentHashMap)中   (@author: DELETE) */      
	private static Map<String, String> tokenMap = new ConcurrentHashMap<>();
	
	private static Map<String, Long> tokenExpire = new ConcurrentHashMap<>();
	
	private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
	
	private static Logger logger = LoggerFactory.getLogger(DefaultTokenManager.class);

	/** 
	 * @description 利用UUID创建Token(用户登录时，创建Token)
	 * @author DELETE       
	 * @param username
	 * @return     
	 * @see cn.com.med.info.authorization.TokenManager#createToken(java.lang.String)     
	 */  
	public String createToken(String userCode) {
		String token = CodecUtil.createUUID();
		tokenMap.put(userCode, token);
		tokenExpire.put(token, System.currentTimeMillis() + token_expire_time * 60 * 1000);
		return token;
	}
	  
	/** 
	 * @description Token验证(用户登录验证)
	 * @author DELETE        
	 * @param token
	 * @return     
	 * @see cn.com.med.info.authorization.TokenManager#checkToken(java.lang.String)     
	 */  
	public boolean checkToken(String token) {
		if(!StringUtil.isEmpty(token) && tokenMap.containsValue(token)) {
			if(!isTokenExpire(token)) {
				tokenExpire.put(token, System.currentTimeMillis() + token_expire_time * 60 * 1000);
				return true;
			}
		}
		return false;
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
	 * @see cn.com.med.info.authorization.TokenManager#deleteToken(java.lang.String)     
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

	public static Integer getToken_expire_time() {
		return token_expire_time;
	}

	public static void setToken_expire_time(Integer token_expire_time) {
		DefaultTokenManager.token_expire_time = token_expire_time;
	}

	public static Map<String, String> getTokenMap() {
		return tokenMap;
	}

	public static void setTokenMap(Map<String, String> tokenMap) {
		DefaultTokenManager.tokenMap = tokenMap;
	}

	public static Map<String, Long> getTokenExpire() {
		return tokenExpire;
	}

	public static void setTokenExpire(Map<String, Long> tokenExpire) {
		DefaultTokenManager.tokenExpire = tokenExpire;
	}
}
