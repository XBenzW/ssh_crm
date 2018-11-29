package cn.xben.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xben.Until.PageBean;
import cn.xben.domain.Customer;
import cn.xben.domain.Staff;
import cn.xben.service.CustomerService;
import net.sf.json.JSONArray;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();

	private CustomerService customerService;

	private Integer currentPage;

	private Integer pageSize;

	public String save() throws Exception {

		customerService.saveOrUpdate(customer);
		return "toList";
	}

	public String toEdit() throws Exception {

		Customer customerbyId = customerService.getById(customer.getCust_id());
		ActionContext.getContext().put("cust", customerbyId);
		return "edit";
	}
	
	public String industryCount() throws Exception {

		List<Object[]> industryCount = customerService.getIndustryCount();
		// 2 将list转换为 json格式
		String json = JSONArray.fromObject(industryCount).toString();
		// 3 将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	public String sourceCount() throws Exception {
    
		List<Object[]> sourceCount = customerService.getSourceCount();
		// 2 将list转换为 json格式
				String json = JSONArray.fromObject(sourceCount).toString();
				// 3 将json发送给浏览器
				ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
				ServletActionContext.getResponse().getWriter().write(json);
		return null;
		
	}

	public String delete() throws Exception {

		customerService.delete(customer.getCust_id());
		return "delete";
	}
	
	public String list() throws Exception {
		// 1.新建离线查询对象，并且封装参数
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		// 2.过去pageBean，发布到request域
		PageBean pb = customerService.getPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pb);
		// 3.转发页面
		return "list";
	}

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

}
