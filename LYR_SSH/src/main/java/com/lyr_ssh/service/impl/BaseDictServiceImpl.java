package com.lyr_ssh.service.impl;

import java.util.List;

import com.lyr_ssh.dao.BaseDictDao;
import com.lyr_ssh.entity.BaseDict;
import com.lyr_ssh.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
     //依赖注入
	private BaseDictDao baseDictDao;
	//根据根据数据字典类型字段获得数据字典对象
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		//调用dao查询数据字典
		return baseDictDao.getListByTypeCode(dict_type_code);
	}
	
	
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

}
