/**
 * 
 */
package com.med.info.domain;

/**
 * @author jialin.jiang
 *
 */
public class UserInfo extends BaseDomain{
	
	private String uname;    
	private String passwd;
	private String gentle;
	private String email;
	private String city;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getGentle() {
		return gentle;
	}
	public void setGentle(String gentle) {
		this.gentle = gentle;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
