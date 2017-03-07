/**   
 * Copyright © 2015 北京恒泰实达科技发展有限公司. All rights reserved.
 * 项目名称：dn13Hibernate
 * 描述信息: 
 * 创建日期：2015年12月16日 下午2:30:55 
 * @author malitao
 * @version 
 */
package basic.test1helloworld;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import po.User;


/** 
 *  
 * 创建日期：2015年12月16日 下午2:30:55 
 * @author malitao
 */
public class TestHibernate {
	
	@Test
	public void test(){
		//创建对象
		User user = new User();
		user.setLoginName("admin");
		user.setPassword("admin");
		user.setName("administrator");
		//调用hibernate的api，用于装配配置文件
		Configuration con = new Configuration();
		//类路径中，加载配置文件。若是有映射文件则同时加载
		//默认的是 hibernate.cfg.xml
//		con.configure();
		//或可以装载指定的配置文件
//		con.configure("hibernate.cfg.xml");
		//或可以是文件
		con.configure(new File("src\\hibernate.cfg.xml"));
		//构建 session工厂类
		SessionFactory factory = con.buildSessionFactory();
		//构建 session，hibernate提够的访问接口
		Session session = factory.openSession();
		//由session构建事务对象
		Transaction tx =  session.getTransaction();
		//事务开始
		tx.begin();
		//session进行保存
		session.save(user);
		//事务提交
		tx.commit();
		//session关闭
		session.close();
	}

}
