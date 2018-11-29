package cn.xben.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.xben.Until.PageBean;
import cn.xben.domain.Shopping;

public interface ShoppingService {

	//获取PageBean对象
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
    //删除消费记录操作
	void delete(Long shop_id);
    //获取消费记录操作
	Shopping getById(Long shop_id);
    //保存或更新消费记录
	void saveOrUpdate(Shopping shopping);



}
