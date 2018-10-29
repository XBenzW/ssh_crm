package cn.xben.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.xben.dao.CustomerDao;
import cn.xben.dao.impl.CustomerDaoImpl;
import cn.xben.domain.Customer;
import cn.xben.service.CustomerService;
import cn.xben.until.HibernateUntil;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public void save(Customer c) {

		Session session = HibernateUntil.getCurrentSession();

		Transaction transaction = session.beginTransaction();

		try {
			customerDao.save(c);
		} catch (Exception e) {
			e.printStackTrace();

			transaction.rollback();
		}
		transaction.commit();
	}

	@Override
	public List<Customer> getAll() {
		Session session = HibernateUntil.getCurrentSession();

		Transaction transaction = session.beginTransaction();

		List<Customer> list = customerDao.getAll();

		transaction.commit();
		return list;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		Session session = HibernateUntil.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		List<Customer> list = customerDao.getAll(dc);
		
		transaction.commit();
		return list;
	}

}
