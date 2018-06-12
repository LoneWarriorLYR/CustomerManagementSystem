package com.lyr_ssh.web.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.lyr_ssh.entity.Customer;
import com.lyr_ssh.entity.LinkMan;
import com.lyr_ssh.service.LinkManService;
import com.lyr_ssh.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction implements ModelDriven<LinkMan> {

	private LinkMan linkMan = new LinkMan();
	// 依赖注入
	@Resource(name="linkManService")
	private LinkManService lms;
	
	//接收页面数据
	private Integer currentPage;
	private Integer pageSize;

	/**
	 * 查询联系列表
	 * @return
	 */
	public String list(){
		System.out.println("当前页数："+currentPage+"每页显示条数："+pageSize);
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		//判断页面的搜索参数条件非空，将离线查询对象封装查询条件
		/*if(StringUtils.isNotBlank(lms.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}*/
		//调用serveice处理分页逻辑，会返回业务逻辑处理结果 --pageBean
		PageBean pb = lms.getPageBean(dc,currentPage,pageSize);
		//2.把返回的对象放到request域中
		ActionContext.getContext().put("pageBean", pb);
		//3.转发到list.jsp显示结果
		return "list";
	}

	public LinkMan getModel() {
		// TODO 自动生成的方法存根
		return null;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
