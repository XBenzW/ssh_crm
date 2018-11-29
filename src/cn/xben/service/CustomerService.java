package cn.xben.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.xben.Until.PageBean;
import cn.xben.domain.Customer;
import cn.xben.domain.Staff;

public interface CustomerService {
	// 分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	// 保存客户方法
	void save(Customer customer);

	// 保存或修改客户方法
	void saveOrUpdate(Customer customer);

	// 根据id获得工作人员对象
	Customer getById(Long cust_id);

	// 根据id身处客户
	void delete(Long cust_id);

	// 获取客户行业统计
	List<Object[]> getIndustryCount();

	// 获取客户来源统计
	List<Object[]> getSourceCount();

}
