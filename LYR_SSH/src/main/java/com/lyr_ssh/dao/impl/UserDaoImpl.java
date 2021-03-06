package com.lyr_ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.lyr_ssh.dao.UserDao;
import com.lyr_ssh.entity.User;

//dao�����̳�HibernateDaoSupport(�ṩHibernateTemplate�������ݿ��ģ��)    SpringΪdao ע��sessionFactory
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	//ʹ��HibernateTemplateģ��������ݿ�:getHibernateTemplate()
	public User getByUserCode(String userCode) {
		//����Criteria���߲�ѯ���� DetachedCriteria
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		//װ������
		criteria.add(Restrictions.eq("user_code", userCode));
		//����
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		//�жϷǿ�
		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	
	

}
