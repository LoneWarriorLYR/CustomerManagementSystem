package com.lyr_ssh.service;

import java.util.List;

import com.lyr_ssh.entity.BaseDict;

public interface BaseDictService {

	//ajax请求==== 根据根据数据字典类型字段获得数据字典对象
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
