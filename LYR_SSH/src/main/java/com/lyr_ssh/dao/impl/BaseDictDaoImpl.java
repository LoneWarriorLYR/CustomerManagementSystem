package com.lyr_ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.lyr_ssh.dao.BaseDictDao;
import com.lyr_ssh.entity.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		//使用离线查询对象查询
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//装配条件
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		//执行查询并返回
		return (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
	}

}
