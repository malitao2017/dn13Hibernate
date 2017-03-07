/**   
 * Copyright © 2015 北京恒泰实达科技发展有限公司. All rights reserved.
 * 项目名称：dn13Hibernate
 * 描述信息: 
 * 创建日期：2015年12月28日 下午3:45:36 
 * @author malitao
 * @version 
 */
package h1firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 这个今后是标配
 * 此为线程安全的方式，每个线程有自己的session
 * 注意：关闭的时候必须使用这里的close方法，而不是自己手动的关闭（session.close()）
 * @author malitao
 *
 */
public class HibernateUtilsByThreadLocal {
	//多线程备份变量
	private static ThreadLocal<Session> tl = new ThreadLocal<Session>(); 
	private static Configuration con ;
	private static SessionFactory factory;
	static{
		con = new Configuration();
		con.configure();
		factory = con.buildSessionFactory();
	}
	
	public static Session getSession(){
		Session session = tl.get();
		if(session == null){//可能需要再次开启
			session = factory.openSession();
			tl.set(session);
		}
		return session;
	}
	public static void closeSession(){
		Session session = tl.get();
		if(session != null){
			session.close();
			tl.set(null);
		}
	}
}
