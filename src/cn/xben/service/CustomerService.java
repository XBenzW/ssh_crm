package cn.xben.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.xben.domain.Customer;

public interface CustomerService {
    //添加用户
	void save(Customer c);
   //查询用户
	
	List<Customer> getAll();
    //条件查询
	List<Customer> getAll(DetachedCriteria dc);

}
