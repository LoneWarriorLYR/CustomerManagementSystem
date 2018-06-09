package com.lyr_ssh.service;

import org.hibernate.criterion.DetachedCriteria;

import com.lyr_ssh.util.PageBean;

public interface CustomerService {

	/**
	 * 查找分页数据
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
