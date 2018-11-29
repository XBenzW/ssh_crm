package cn.xben.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xben.dao.CustomerDao;
import cn.xben.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	@Override
	public List<Object[]> getIndustryCount() {
		@SuppressWarnings("unchecked")
		List<Object []> list = getHibernateTemplate().execute(new HibernateCallback<List>() {

			String sql = "SELECT bd.dict_item_name , COUNT(*) total from crm_customer c , base_dict bd WHERE c.cust_industry=bd.dict_id GROUP BY c.cust_industry";

			@Override
			public List doInHibernate(Session session) throws HibernateException {
				SQLQuery sqlQuery = session.createSQLQuery(sql);
				return sqlQuery.list();
			}
		});
		return list;
	}

	@Override
	public List<Object[]> getSourceCount() {
		@SuppressWarnings("unchecked")
		List<Object []> list = getHibernateTemplate().execute(new HibernateCallback<List>() {

			String sql = "SELECT bd.dict_item_name , COUNT(*) total from crm_customer c , base_dict bd WHERE c.cust_source=bd.dict_id GROUP BY c.cust_source";

			@Override
			public List doInHibernate(Session session) throws HibernateException {
				SQLQuery sqlQuery = session.createSQLQuery(sql);
				return sqlQuery.list();
			}
		});
		return list;
	}

}
