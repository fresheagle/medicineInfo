package cn.com.med.info.authorization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



import cn.com.med.info.utils.CodecUtil;
import cn.com.med.info.utils.StringUtil;
  
/**        
 * Title: TokenManager的默认实现    
 * Description: 管理 Token
 * @author DELETE       
 *   
 */      
public class DefaultTokenManager implements TokenManager {

	/** 将token存储到JVM内存(ConcurrentHashMap)中   (@author: DELETE) */      
	private static Map<String, String> tokenMap = new ConcurrentHashMap<String, String>();

	/** 
	 * @description 利用UUID创建Token(用户登录时，创建Token)
	 * @author DELETE       
	 * @param username
	 * @return     
	 * @see cn.com.med.info.authorization.TokenManager#createToken(java.lang.String)     
	 */  
	public String createToken(String username) {
		String token = CodecUtil.createUUID();
		tokenMap.put(token, username);
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
		return !StringUtil.isEmpty(token) && tokenMap.containsKey(token);
	}

	  
	/** 
	 * @description Token删除(用户登出时，删除Token)
	 * @author DELETE           
	 * @param token     
	 * @see cn.com.med.info.authorization.TokenManager#deleteToken(java.lang.String)     
	 */  
	@Override
	public void deleteToken(String token) {
		// TODO Auto-generated method stub
		tokenMap.remove(token);
	}
}
