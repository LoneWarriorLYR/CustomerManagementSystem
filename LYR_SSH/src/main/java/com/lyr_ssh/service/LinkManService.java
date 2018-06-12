package com.lyr_ssh.service;

import org.hibernate.criterion.DetachedCriteria;

import com.lyr_ssh.entity.LinkMan;
import com.lyr_ssh.util.PageBean;

public interface LinkManService {

	//分页查询
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	//保存或更新联系人
	void saveOrUpdata(LinkMan linkMan);

}
