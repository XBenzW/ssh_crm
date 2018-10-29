package cn.xben.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.xben.domain.Customer;

public interface CustomerDao {
    
	//添加用户
	void save(Customer c);
    //获取用户
	List<Customer> getAll();
	//条件查询
	List<Customer> getAll(DetachedCriteria dc);

}
