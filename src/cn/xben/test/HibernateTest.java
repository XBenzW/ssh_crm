package cn.xben.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xben.dao.AdminDao;
import cn.xben.domain.Admin;
import cn.xben.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Test
	public void fun1() {
		// Configuration cfg = new Configuration().configure();
		// SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// ----------------------------------
		Admin ad = new Admin();

		ad.setAdm_name("zxw");
		ad.setAdm_password("123");

		session.save(ad);

		// ----------------------------------
		tx.commit();
		session.close();
	}

	@Resource(name = "adminDao")
	private AdminDao adminDao;

	@Test
	public void fun2() {
		// Configuration cfg = new Configuration().configure();
		// SessionFactory sessionFactory = cfg.buildSessionFactory();

		// ----------------------------------
           Admin admin = adminDao.getAdminByadm_name("xben");
           
           System.out.println(admin);
		// ----------------------------------
	}
	
	@Resource(name="adminService")
	private AdminService adminService;
	@Test
	public void fun3() {
		// ----------------------------------
		Admin ad = new Admin();

		ad.setAdm_name("xxx");
		ad.setAdm_password("123");
       adminService.saveAdmin(ad);
           
        
		// ----------------------------------
	}

	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
