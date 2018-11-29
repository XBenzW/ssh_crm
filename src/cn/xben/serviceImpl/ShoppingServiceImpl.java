package cn.xben.serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.xben.Until.PageBean;
import cn.xben.dao.ShoppingDao;
import cn.xben.domain.Customer;
import cn.xben.domain.Shopping;
import cn.xben.service.ShoppingService;

public class ShoppingServiceImpl implements ShoppingService {

	private ShoppingDao shoppingDao;
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		 //1.获取总记录数
		Integer totalCount = shoppingDao.getTotalCount(dc);
	    //2.创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
	    //3.获取list
		List<Shopping> list = shoppingDao.getPageList(dc, pb.getStart(), pb.getPageSize());
	    //4.将list加入PageBean对象中 
		pb.setList(list);
		return pb;
	}

	@Override
	public void delete(Long shop_id) {
		shoppingDao.delete(shop_id);
	}

	@Override
	public Shopping getById(Long shop_id) {
		return shoppingDao.getById(shop_id);
	}

	@Override
	public void saveOrUpdate(Shopping shopping) {
		
		shoppingDao.saveOrUpdate(shopping);

	}

	public void setShoppingDao(ShoppingDao shoppingDao) {
		this.shoppingDao = shoppingDao;
	}
	

}
