package cn.xben.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.xben.dao.LinkManDao;
import cn.xben.dao.impl.LinkManDaoImpl;
import cn.xben.domain.LinkMan;
import cn.xben.service.LinkManService;
import cn.xben.until.HibernateUntil;

public class LinkManServiceImpl implements LinkManService {
	LinkManDao lmd = new LinkManDaoImpl();

	@Override
	public void save(LinkMan lm) {

		Session session = HibernateUntil.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			lmd.save(lm);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		transaction.commit();

	}

	@Override
	public List<LinkMan> getAll() {
		Session session = HibernateUntil.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<LinkMan> list = lmd.getAll();
		transaction.commit();
		return list;
	}

	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		Session session = HibernateUntil.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		List<LinkMan> list = lmd.getAll(dc);
		
		transaction.commit();
		return list;
	}

}
