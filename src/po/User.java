/**   
 * Copyright © 2015 北京恒泰实达科技发展有限公司. All rights reserved.
 * 项目名称：dn13Hibernate
 * 描述信息: 
 * 创建日期：2015年12月16日 下午2:30:36 
 * @author malitao
 * @version 
 */
package po;

/** 
 *  
 * 创建日期：2015年12月16日 下午2:30:36 
 * @author malitao
 */
public class User {

	private Integer id;
	private String loginName;
	private String password;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
