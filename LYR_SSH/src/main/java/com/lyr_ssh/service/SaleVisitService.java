package com.lyr_ssh.service;

import org.hibernate.criterion.DetachedCriteria;

import com.lyr_ssh.entity.SaleVisit;
import com.lyr_ssh.util.PageBean;


public interface SaleVisitService {
	//保存客户拜访记录
	void save(SaleVisit saleVisit);
	//客户拜访记录的分页列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//根据id获得客户对象
	SaleVisit getById(String visit_id);
	
	void delete(SaleVisit saleVisit);

}
