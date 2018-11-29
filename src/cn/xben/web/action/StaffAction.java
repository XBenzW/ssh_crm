package cn.xben.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xben.Until.PageBean;
import cn.xben.domain.Staff;
import cn.xben.service.StaffService;

public class StaffAction extends ActionSupport implements ModelDriven<Staff> {

	private Staff staff = new Staff();

	private StaffService staffService;

	private Integer currentPage;
	private Integer pageSize;

	public String save() throws Exception {
		staffService.saveOrUpdate(staff);
		return "toList";
	}
	
	public String toEdit() throws Exception {
		Staff staffbyId = staffService.getById(staff.getStaff_id());
		ActionContext.getContext().put("staff",staffbyId );
		return "edit";
	}
	
	public String delete() throws Exception {
		staffService.delete(staff.getStaff_id());
		return "delete";
	}
	public String list() throws Exception {
		// 1.获取离线查询对象并且封装参数
		DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
		
		if(StringUtils.isNotBlank(staff.getStaff_name())){
			dc.add(Restrictions.like("staff_name", "%"+staff.getStaff_name()+"%"));
		}
		// 2.调用service 方法 返回PageBean，并接收
		PageBean pb = staffService.getPageBean(dc,currentPage,pageSize);
		// 3.添加到request 域
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}

	@Override
	public Staff getModel() {
		// TODO Auto-generated method stub
		return staff;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	
}
