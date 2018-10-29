package cn.xben.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import cn.xben.dao.LinkManDao;
import cn.xben.domain.Customer;
import cn.xben.domain.LinkMan;
import cn.xben.until.HibernateUntil;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void save(LinkMan lm) {
		// 1.获取用户
		Session session = HibernateUntil.getCurrentSession();
		Customer c = session.get(Customer.class, lm.getCust_id());
		
		// 2.增加关系
		lm.setCustomer(c);
		session.save(lm);

	}

	@Override
	public List<LinkMan> getAll() {
		Session session = HibernateUntil.getCurrentSession();
		Criteria criteria = session.createCriteria(LinkMan.class);
		List<LinkMan> list = criteria.list();
		return list;
	}

	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		Session session = HibernateUntil.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		
		return criteria.list();
	}

}
