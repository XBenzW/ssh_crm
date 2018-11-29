package cn.xben.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.xben.dao.AdminDao;
import cn.xben.domain.Admin;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	@Override
	public Admin getAdminByadm_name(final String adm_name) {
		
		// return getHibernateTemplate().execute(new HibernateCallback<Admin>()
		// {
		//
		// @Override
		// public Admin doInHibernate(Session session) throws HibernateException
		// {
		// String hql= "from Admin where adm_name = ?";
		// Query query = session.createQuery(hql);
		// query.setParameter(0, adm_name);
		// Admin adm = (Admin) query.uniqueResult();
		// return adm;
		// }
		// });
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Admin.class);
		criteria.add(Restrictions.eq("adm_name",adm_name));
		List<Admin> list = (List<Admin>) getHibernateTemplate().findByCriteria(criteria );
		if(list != null && list.size()>0){
			return list.get(0);
		}else {
			return null;
		}
}

	@Override
	public void saveAdmin(Admin admin) {
		getHibernateTemplate().save(admin);
		
	}
}
