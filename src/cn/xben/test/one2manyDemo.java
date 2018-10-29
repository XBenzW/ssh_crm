package cn.xben.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.xben.domain.Customer;
import cn.xben.domain.LinkMan;

public class one2manyDemo {

	@Test
	//新增客户，新增联系人
	public void fun1() {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Customer c1 = new Customer();
		c1.setCust_name("百度");
		LinkMan l1 = new LinkMan();
		l1.setLkm_name("李彦宏");
		LinkMan l2 = new LinkMan();
		l2.setLkm_name("许总");
		//表达一对多
		c1.getLinkMens().add(l1);
		c1.getLinkMens().add(l2);
		
		//表达多对一
		l1.setCustomer(c1);
		l2.setCustomer(c1);
		
		session.save(c1);
		session.save(l1);
		session.save(l2);

		transaction.commit();
		session.close();
	}
	
	@Test
	//为客户增加联系人
	public void fun2() {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		//获得客户
		Customer c = session.get(Customer.class, 1l);
		//新建联系人
		LinkMan l= new LinkMan();
		l.setLkm_name("李彦宏2");
		c.getLinkMens().add(l);
		l.setCustomer(c);
		session.save(l);
		
		
		transaction.commit();
		session.close();
	}

	@Test
	//为客户增加联系人
	public void fun3() {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		//获得客户
		Customer c = session.get(Customer.class, 1l);
		//获得联系人
		LinkMan linkMan = session.get(LinkMan.class, 3l);
		
		c.getLinkMens().remove(linkMan);
		
		linkMan.setCustomer(null);
		
		
		transaction.commit();
		session.close();
	}


}
