package cn.xben.web.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xben.domain.Admin;
import cn.xben.service.AdminService;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

	private Admin admin = new Admin();

	@Resource(name = "adminService")
	private AdminService adminService;

	public String login() throws Exception {
		//1.调用service方法获取登录成功的Admin对象
		Admin a = adminService.getAdminByPassword(admin);
		//2.将成功的admin对象加入到session中去
		ActionContext.getContext().getSession().put("admin", a);
		//3.重定向到首页
		return "toHome";
	}

	@Override
	public Admin getModel() {

		return admin;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
