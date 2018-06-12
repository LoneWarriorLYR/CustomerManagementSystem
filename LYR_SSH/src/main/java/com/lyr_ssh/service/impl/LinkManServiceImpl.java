package com.lyr_ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.lyr_ssh.dao.LinkManDao;
import com.lyr_ssh.entity.LinkMan;
import com.lyr_ssh.service.LinkManService;
import com.lyr_ssh.util.PageBean;

@Service(value = "linkManService")
public class LinkManServiceImpl implements LinkManService {

	@Resource(name="linkManDao")
	private LinkManDao lmd;
	// 查询分页列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 调用dao查询总记录数
		Integer totalCount = lmd.getTotalCount(dc);
		// 创建pageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 调用dao查询分页列表数据(参数：离线查询对象，起始索引，页面显示条数)
		List<LinkMan> pageList = lmd.getPageList(dc, pb.getStart(), pb.getPageSize());
		// 将返回的分页数据放入PageBean对象中
		pb.setList(pageList);
		// 返回PageBean对象
		return pb;
	}
	public void saveOrUpdata(LinkMan linkMan) {
		//如果对象中没有id，调用保存方法
		if(linkMan.getLkm_id() == null){
			lmd.save(linkMan);
			
		}else{
			//有id，更新操作
			lmd.update(linkMan);
		}
	}

}
