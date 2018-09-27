package cn.com.med.info.service;

import cn.com.med.info.model.entity.User;

/**        
 * Title: UserService.java    
 * Description: 对用户相关的业务逻辑的抽象(面向接口编程)
 * @author DELETE       
 *     
 */      
public interface UserService {
	
	  
	/**     
	 * @description 用户登录逻辑
	 * @author DELETE        
	 * @param uname
	 * @param passwd
	 * @return     
	 */
	public boolean login(String uname, String passwd);
	
	/**     
	 * @description 用户注册逻辑
	 * @author DELETE           
	 * @param userDto
	 * @return     
	 */
	public void addUser(User user);
	
	/**     
	 * @description  用户获取逻辑
	 * @author DELETE         
	 * @param id
	 * @return     
	 */
	public Object getUser(int id); 
}

