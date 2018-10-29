package cn.xben.until;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUntil {
	
	private static SessionFactory  sessionFactory;
	
	static {
		Configuration cnf =new Configuration().configure();
		sessionFactory = cnf.buildSessionFactory();
	}

	public static Session getSession() {
		Session session = sessionFactory.openSession();
		
		return session ;
	}
	
	public static Session getCurrentSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
}
