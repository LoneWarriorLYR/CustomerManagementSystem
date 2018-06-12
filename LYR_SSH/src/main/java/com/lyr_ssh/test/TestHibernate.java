package com.lyr_ssh.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyr_ssh.dao.LinkManDao;
import com.lyr_ssh.dao.UserDao;
import com.lyr_ssh.entity.Customer;
import com.lyr_ssh.entity.LinkMan;
import com.lyr_ssh.entity.User;
import com.lyr_ssh.service.CustomerService;
import com.lyr_ssh.service.LinkManService;
import com.lyr_ssh.service.UserService;
import com.lyr_ssh.util.PageBean;
import com.lyr_ssh.web.action.UserAction;

/**
 * 
 * 
 * @author Administrator
 *
 */
// Hibernata ��Spring���ϲ�����Ҫ����Spring�����ļ�
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestHibernate { // hibernate ��������
	// ע����Spring�����sessionFactory
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	// ע��userDao
	@Resource(name = "userDao")
	private UserDao userdao;

	// ע��UserService
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "customerService")
	private CustomerService cs;

	@Test
	public void testHibernate() {// hibernate ��������
		// ���������ļ�
		Configuration cg = new Configuration().configure();
		// ��ȡsessionFactory
		SessionFactory sessionFactory = cg.buildSessionFactory();
		// ��ȡsession
		Session session = sessionFactory.openSession();
		// ������
		Transaction beginTransaction = session.beginTransaction();
		// ��ʼ���Ӳ���
		User u = new User();
		u.setUser_code("����");
		u.setUser_password("1234");
		session.save(u);
		// �ύ����
		beginTransaction.commit();
		// �ر�session
		session.close();
		// �ر�sessionFactory
		sessionFactory.close();
	}

	@Test // hibernate��Spring����
	public void testHibernateAndSpring() {
		// ʹ��Spring�����SessionFactory ��ȡsession
		Session session = sessionFactory.openSession();
		// ������
		Transaction beginTransaction = session.beginTransaction();
		// ��ʼ���Ӳ���
		User u = new User();
		u.setUser_code("��������");
		u.setUser_password("1234");
		session.save(u);
		// �ύ����
		beginTransaction.commit();
		// �ر�session
		session.close();
		// �ر�sessionFactory
		sessionFactory.close();
	}

	@Test // Spring��c3p0���ӳ����ϲ���
	public void testHibernateAndSpring_C3P0() {
		// ʹ��Spring�����SessionFactory ��ȡsession
		Session session = sessionFactory.openSession();
		// ������
		Transaction beginTransaction = session.beginTransaction();
		// ��ʼ���Ӳ���
		User u = new User();
		u.setUser_code("��С��");
		u.setUser_password("123456");
		u.setUser_name("С����");
		session.save(u);
		// �ύ����
		beginTransaction.commit();
		// �ر�session
		session.close();
		// �ر�sessionFactory
		// sessionFactory.close(); //sessionFactory��Spring��������Ҫ�ֶ��ر�
	}

	@Test // ����HibernateTemplateģ��������ݿ�--->ok
	public void testHibernateTemplate() {
		User u = userdao.getByUserCode("��С��");
		System.out.println(u);
	}

	@Test // ����Aop����--->ok
	public void testAOPTransaction() {
		User u = userService.getByUserCode("��������");
		System.out.println(u);
	}

	@Test // ����Aop����--->ok
	public void testAOPTransaction2() {
		User user = new User();
		user.setUser_code("��С��");
		user.setUser_password("123456");
		user.setUser_name("С����");
		User u2 = new User();
		u2.setUser_code("·С·");
		u2.setUser_password("12121");
		u2.setUser_name("·С·");
		try {
			// userdao.saveUser(user, u2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test // ����Aop����--->ok
	public void testAction() {
		User user = new User();
		user.setUser_code("��С��");
		user.setUser_password("123456");
		user.setUser_name("С����");

		try {
			User uu = userService.getByUserByCodePassword(user);
			System.out.println(uu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test // ����Aop����--->ok
	public void testCustomerAction() {
		Customer c = new Customer();
		c.setCust_name("你大爷");
		try {
			cs.saveOrUpdata(c);
			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test // 测试删除
	public void testDelete() {
		Customer c = new Customer();
		c.setCust_id(9l);
		try {
			cs.delete(c);
			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Resource(name ="linkManDao")
	private LinkManDao linkMandao;

	@Test // 测试dAO
	public void testDAO() {
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		try {
			List<LinkMan> pageList = linkMandao.getPageList(dc, 1, 1);
			System.out.println(pageList);
			Integer totalCount = linkMandao.getTotalCount(dc);
			System.out.println(totalCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Resource(name="linkManService")
	private LinkManService servcie;
	@Test // 测试service
	public void testService() {
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		try {
			PageBean pageBean = servcie.getPageBean(dc, 1, 1);
			System.out.println(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Resource(name = "userAction")
	private UserAction action;

	@Test // ����Aop����--->ok
	public void testAction2() {
		action.test();
	}
}
