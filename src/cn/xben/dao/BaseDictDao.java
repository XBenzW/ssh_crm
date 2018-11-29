package cn.xben.dao;

import java.util.List;

import cn.xben.domain.BaseDict;

public interface BaseDictDao {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
