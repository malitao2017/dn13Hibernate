/**   
 * Copyright © 2015 北京恒泰实达科技发展有限公司. All rights reserved.
 * 项目名称：dn13Hibernate
 * 描述信息: 
 * 创建日期：2015年12月28日 下午4:36:26 
 * @author malitao
 * @version 
 */
package basic.test3DataType;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import basic.HibernateUtils;
import po.Dept;
import po.Emp;

/** 
 *  
 * 创建日期：2015年12月28日 下午4:36:26 
 * @author malitao
 */
public class TestPersistence {

	@Test
	public static void testType(){
		Emp emp = new Emp();
		emp.setName("BigYellow");
		emp.setSalary(15000.90);
		emp.setHireDate(new Date());
		emp.setLastLogin(new Date());
		emp.setRegister(true);

		//many-to-one 增加部门id
//		emp.setDeptId(1);
		Dept dept = new Dept();
		dept.setId(1);
//		设置Emp对象的Dept属性，
//		emp对象dept属性的id将存入t_emp表中的t_dept_id
//		自解： 这里对象Dept的属性值id叫什么名字 Demp.hbm.xml中自动解答映射解析。
		emp.setDept(dept);
		
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();
		session.close();
	}
}
