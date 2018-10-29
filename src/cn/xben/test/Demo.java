package cn.xben.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.xben.domain.Customer;
import cn.xben.until.HibernateUntil;

public class Demo {
		
	public static void main(String[] args) {
		
		
		Session session = HibernateUntil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer c= new Customer();
		
        c.setCust_name("xbs");
        
        session.save(c);
        
        tx.commit();
        session.close();
       

	}
}
