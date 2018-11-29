package cn.xben.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.xben.Until.PageBean;
import cn.xben.domain.Staff;

public interface StaffService {

	// 分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	// 保存工作人员方法
	void saveOrUpdate(Staff staff);

	// 根据id获得工作人员对象
	Staff getById(Long staff_id);
	//删除工作人员对象
	void delete(Long staff_id);
}
