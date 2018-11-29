package cn.xben.serviceImpl;

import javax.annotation.Resource;

import cn.xben.dao.AdminDao;
import cn.xben.domain.Admin;
import cn.xben.service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Resource(name = "adminDao")
	private AdminDao adminDao;

	@Override
	public void saveAdmin(Admin admin) {

		adminDao.saveAdmin(admin);
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Admin getAdminByPassword(Admin admin) {
		//1.根据姓名查admin对象
		Admin exitAd = adminDao.getAdminByadm_name(admin.getAdm_name());
		//2.对象如果为空抛异常：用户不存在
		if(exitAd==null){
			throw new RuntimeException("用户名不存在");
		}
		//3.对象密码不正确抛异常：密码不正确
		if (!exitAd.getAdm_password().equals(admin.getAdm_password())){
			throw new RuntimeException("密码不正确");
		}
		//4.返回正确对象
		
		return exitAd;
		
	}

}
