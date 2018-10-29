package cn.xben.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.xben.domain.LinkMan;

public interface LinkManDao {

	void save(LinkMan lm);
    //查询全部
	List<LinkMan> getAll();
    //条件查询
	List<LinkMan> getAll(DetachedCriteria dc);

}
