package cn.xben.dao;

import java.util.List;

import cn.xben.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{

	//获取客户行业统计
	List <Object []>  getIndustryCount();
	//获取客户来源统计
	List <Object []>  getSourceCount();

}
