package cn.xben.serviceImpl;

import java.util.List;

import cn.xben.dao.BaseDictDao;
import cn.xben.domain.BaseDict;
import cn.xben.service.BaseDictService;


public class BaseDictServiceImpl implements BaseDictService {
	
	private BaseDictDao baseDictDao;
	
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return baseDictDao.getListByTypeCode(dict_type_code);
	}

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	

	
}
