package cn.xben.dao;

import cn.xben.domain.Admin;

public interface AdminDao {
	//根据管理员姓名查询管理员
	Admin getAdminByadm_name(String adm_name);
	
	//保存管理员对象
	void saveAdmin(Admin admin);

}
