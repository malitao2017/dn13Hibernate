package h3manytoone;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import h1firstlevelcache.HibernateUtilsByThreadLocal;
import po.Dept;
import po.Emp;

public class TestManyToOne {
//	@Test
	public void testMTO(){
		/**
		 * 1.查询
		 */
		Session session = HibernateUtilsByThreadLocal.getSession();
		Emp emp = (Emp) session.get(Emp.class, 1);
		System.out.println("emp: " + emp.getName() + " | emp.dept: " + emp.getDept().getClass().getName());
		Dept dept = emp.getDept();
		System.out.println("dept: "+ dept.getName());
		//HibernateUtilsByThreadLocal.closeSession();
		/**
		 * 2.增加部分请参见：
		 * basic.test3DataType.TestPersistence
		 */
//		emp对象dept属性的id将存入t_emp表中的t_dept_id
		/**
		 * 3.Hibernate 关联映射<many-to-one>默讣为延缓加载，所以打印的 Dept 对象为代理对象。
		 * 后果：打印两条数据库操作记录
		 * 属性：lazy="false" 
		 */
		
		/**
		 * 4.两个sql合并成一条
		 * 注意：此属性，只对session.get()起作用，对session.createQuery()不起作用
		 * 属性：lazy="false" fetch="join"
		 * 而默认不写的情况等同于 ：　lazy="proxy" fetch="join"
		 */
		//不起作用：
//		emp = (Emp) session.createQuery("from Emp").list().get(0);
		//手动改写hql合并成一条sql：
//		emp = (Emp) session.createQuery("from Emp e left outer join fetch e.dept").list().get(0);
		
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testHQL(){
		Session session = HibernateUtilsByThreadLocal.getSession();
		
		/**
		 * 1.查员工(many)情况
		 * 注意：区别于jdbc ,参数是从0开始计数的
		 * 使用：fetch
		 */
//		List<Emp> emps = session.createQuery("from Emp e where e.name=?").setParameter(0, "BigYellow").list();
		//2条合并成1条sql
		List<Emp> emps = session.createQuery("from Emp e left outer join fetch e.dept where e.name=?").setParameter(0, "BigYellow").list();
		for(Emp emp:emps){
			System.out.println("emp: " + emp.getName() + " dept: " + emp.getDept().getName());
		}
		
		/**
		 * 2.部门的所有员工
		 */
//		List<Emp> emps2 = session.createQuery("from Emp e where e.dept.name=? ").setParameter(0, "r&d").list();
		//2条合并成1条sql
		List<Emp> emps2 = session.createQuery("from Emp e left outer join fetch e.dept where e.dept.name=? ").setParameter(0, "r&d").list();
		for(Emp emp:emps2){
			System.out.println("emp: " + emp.getName() + " dept: " + emp.getDept().getName());
		}
		HibernateUtilsByThreadLocal.closeSession();
	}
	
}
