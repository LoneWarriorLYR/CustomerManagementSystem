package com.lyr_ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.lyr_ssh.dao.SaleVisitDao;
import com.lyr_ssh.entity.SaleVisit;
import com.lyr_ssh.service.SaleVisitService;
import com.lyr_ssh.util.PageBean;

@Service
public  class SaleVisitServiceImpl implements SaleVisitService {

	@Resource
	private SaleVisitDao svd;
	
	public void save(SaleVisit saleVisit) {
		//有id进行更新操作
		if(saleVisit.getVisit_id()!=null&&!saleVisit.getVisit_id().equals("")){
			svd.update(saleVisit);
		}else{
			//没有id进行保存操作
			svd.save(saleVisit);
		}
	}
	
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = svd.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		
		List<SaleVisit> list = svd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}


	public SaleVisit getById(String visit_id) {
		return svd.getById(visit_id);
	}
	
	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}

	public void delete(SaleVisit saleVisit) {
		svd.delete(saleVisit);
	}


}
