package com.lyr_ssh.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.lyr_ssh.dao.SaleVisitDao;
import com.lyr_ssh.entity.SaleVisit;

@Repository
public class SaleVisitDaoImpl extends BaseDaoImpl<SaleVisit> implements SaleVisitDao {
	
	/**
	 * dao层注入sessionfactory
	 * 需要使用setSessionFactory()方法
	 */
	@Resource(name="sessionFactory")
	 public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    }  
	
	
}
