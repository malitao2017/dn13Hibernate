/**   
 * Copyright © 2015 北京恒泰实达科技发展有限公司. All rights reserved.
 * 项目名称：dn13Hibernate
 * 描述信息: 
 * 创建日期：2015年12月28日 下午3:41:54 
 * @author malitao
 * @version 
 */
package basic.test2CRUD;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import basic.HibernateUtils;
import po.User;


/** 
 *  hibernate 构建成工具类，并简写事务提交方式
 *  
 * 创建日期：2015年12月28日 下午3:41:54 
 * @author malitao
 */
public class TestHibernate {

	@Test
	public void test(){
		System.out.println("前提是数据库中必须有数，添加功能在 helloworld中");
		find();
		update();
		delete();
	}
	public void delete(){
		User user = find();
		System.out.println("删除的数据为："+user.getId()+":"+user.getName());
		Session session = HibernateUtils.openSession();
		//等价
		/*Transaction tx = session.getTransaction();
		tx.begin();*/
		//简写
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}
	public void update(){
		User user = find();
		System.out.println("更新"+user.getId()+":"+user.getName()+"为 update");
		user.setName("update");
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	public User find(){
		Session session = HibernateUtils.openSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		System.out.println("全部数据为：");
		for(User user : list )
			System.out.println(user.getId()+":"+user.getName());
		session.close();
		return list.get(0);
	}
	
	
	
}
