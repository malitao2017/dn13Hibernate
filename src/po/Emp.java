/**   
 * Copyright © 2015 北京恒泰实达科技发展有限公司. All rights reserved.
 * 项目名称：dn13Hibernate
 * 描述信息: 
 * 创建日期：2015年12月28日 下午4:35:04 
 * @author malitao
 * @version 
 */
package po;

import java.util.Date;

/** 
 *  hibernate 会自动与数据库字段做映射
 *   
hibernate的类型： 
   string
 interger
 double
 date 日期，只表示年月日
 datetime 日期，只表示年月日
 timestamp 时间戳，存放年月日时分秒
 yes_no 将在数据库中存一个字符 Y 戒者 N
 true_false 将在数据库中存放一个字符 T 戒者 F，功能同 yes_no 是相同的

mysql数据库中：
   varchar 对应 String
 date 对应年月日
 timestamp 对应年月日时分秒
 通常情况下，使用 char(1)，值为 true/false，来表示 Boolean 类型

 *  
 * 创建日期：2015年12月28日 下午4:35:04 
 * @author malitao
 */
public class Emp {
	private Integer id;
	private String name;
	private double salary;
	private Date hireDate;//入职时间
	private Date lastLogin;//最后登录时间
	private boolean register;//是否注册
	
	//many-to-one 增加部门id
	/**
	 * 每一次我们取出一个员工，同时查看他的信息时，还需要通过 deptId 查找到指定的 Dept 对象，
		当数据量大时，会相当繁琐。
		Hibernate 可以帮劣我们，使用 many-to-one 映射。
		再次注意：并丌是有表关联时，就使用 many-to-one 映射，是当有如上所示 many-to-one 的 需求时，才使用。
	 */
	//private Integer deptId;
	private Dept dept;
	
	
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	//	public Integer getDeptId() {
//		return deptId;
//	}
//	public void setDeptId(Integer deptId) {
//		this.deptId = deptId;
//	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public boolean isRegister() {
		return register;
	}
	public void setRegister(boolean register) {
		this.register = register;
	}
	
}
