package com.lyr_ssh.dao.impl;



import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lyr_ssh.dao.LinkManDao;
import com.lyr_ssh.entity.LinkMan;

@Repository("linkManDao")
public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {

	/**
	 * dao层注入sessionfactory
	 * 需要使用setSessionFactory()方法
	 */
	@Resource(name="sessionFactory")
	 public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    }  

}
