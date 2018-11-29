package cn.xben.service;

import cn.xben.domain.Admin;

public interface AdminService {
	
	void saveAdmin(Admin admin);

	Admin getAdminByPassword(Admin admin);

}
