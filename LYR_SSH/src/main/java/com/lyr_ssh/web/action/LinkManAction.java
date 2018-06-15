package com.lyr_ssh.web.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import com.lyr_ssh.entity.Customer;
import com.lyr_ssh.entity.LinkMan;
import com.lyr_ssh.service.LinkManService;
import com.lyr_ssh.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller(value="linkManAction")
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
		System.out.println(pb);
		//2.把返回的对象放到request域中
		ActionContext.getContext().put("pageBean", pb);
		//3.转发到list.jsp显示结果
		return "list";
	}
	
	/**
	 * 保存或更新联系人
	 * 
	 * 
	 */
	public String saveOrUpdata(){
		System.out.println(linkMan);
		//调用service方法进行保存操作
		lms.saveOrUpdata(linkMan);
		return "tolist";
	}
	
	
	/**
	 * 修改用户
	 * 
	 * 先通过id查询到用户信息
	 * 
	 * 然后将查到信息放到request域中
	 * 
	 * 
	 * 
	 */
	public String updata(){
		//调用service根据id查询联系人信息
		LinkMan limkMan = lms.getCustomerById(linkMan);
		//将查到的信息放到request域中
		ActionContext.getContext().put("linkMan", limkMan);
		return "toEdit";
	}
	/**
	 * 删除用客户
	 * 
	 */
	public String delete(){
		System.out.println(linkMan);
		//调用service的删除方法
		 lms.delete(linkMan);
		return "tolist";
	}

	
	

	public LinkMan getModel() {
		// TODO 自动生成的方法存根
		return linkMan;
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
