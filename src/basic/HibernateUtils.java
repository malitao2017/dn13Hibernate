/**   
 * Copyright © 2015 北京恒泰实达科技发展有限公司. All rights reserved.
 * 项目名称：dn13Hibernate
 * 描述信息: 
 * 创建日期：2015年12月28日 下午3:45:36 
 * @author malitao
 * @version 
 */
package basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/** 
 * 请多使用：　HibernateUtilsByThreadLocal
 *  factory 是只有一份，session 是每一个用户都有
 * 创建日期：2015年12月28日 下午3:45:36 
 * @author malitao
 */
public class HibernateUtils {
	private static Configuration con ;
	private static SessionFactory factory;
	//conf 只要加载一次就行了
	//放到 openSession中效率会低
	static{
		con = new Configuration();
		con.configure();
		factory = con.buildSessionFactory();
		System.out.println("初始化 configuration 、 factory");
	}
	public static Session openSession(){
		Session session = factory.openSession();
		return session;
	}
	
}
