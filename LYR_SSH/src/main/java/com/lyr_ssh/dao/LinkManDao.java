package com.lyr_ssh.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyr_ssh.entity.LinkMan;

public interface LinkManDao {

	//查找总记录数
	Integer getTotalCount(DetachedCriteria dc);

	//查找分页列表对象
	List<LinkMan> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);

}
