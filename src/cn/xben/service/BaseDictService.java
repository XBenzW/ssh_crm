package cn.xben.service;

import java.util.List;

import cn.xben.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
