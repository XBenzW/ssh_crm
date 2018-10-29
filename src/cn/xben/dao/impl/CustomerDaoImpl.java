package cn.xben.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.xben.dao.CustomerDao;
import cn.xben.domain.Customer;
import cn.xben.until.HibernateUntil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save(Customer c) {
		Session session = HibernateUntil.getCurrentSession();
		session.save(c);
		
		
	
		
		
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUntil.getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		
		return list;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		Session session = HibernateUntil.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		return criteria.list();
	}

}
