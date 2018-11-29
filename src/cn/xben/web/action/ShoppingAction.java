package cn.xben.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xben.Until.PageBean;
import cn.xben.domain.Customer;
import cn.xben.domain.Shopping;
import cn.xben.service.ShoppingService;

public class ShoppingAction extends ActionSupport implements ModelDriven<Shopping> {

	private Shopping shopping = new Shopping();

	private ShoppingService shoppingService;

	private Integer currentPage;

	private Integer pageSize;

	public String add() throws Exception {

		shoppingService.saveOrUpdate(shopping);
		return "toList";
	}

	public String toEdit() throws Exception {

		Shopping shoppingrbyId = shoppingService.getById(shopping.getShop_id());
		ActionContext.getContext().put("shopping", shoppingrbyId);
		return "edit";
	}

	public String delete() throws Exception {

		shoppingService.delete(shopping.getShop_id());
		return "delete";
	}

	public String list() throws Exception {
		// 1.新建离线查询对象，并且封装参数
		DetachedCriteria dc = DetachedCriteria.forClass(Shopping.class);
		
		 if(shopping.getCustomer()!=null&&shopping.getCustomer().getCust_id()!=null){
			 dc.add(Restrictions.eq("customer.cust_id", shopping.getCustomer().getCust_id()));
		 }
		 
		// 2.获去pageBean，发布到request域
		PageBean pb = shoppingService.getPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pb);
		// 3.转发页面
		return "list";
	}

	@Override
	public Shopping getModel() {

		return shopping;
	}

	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
