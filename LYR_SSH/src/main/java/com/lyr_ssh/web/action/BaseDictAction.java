package com.lyr_ssh.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lyr_ssh.entity.BaseDict;
import com.lyr_ssh.service.BaseDictService;
import com.lyr_ssh.util.JsonUtil;
import com.mchange.v2.c3p0.stmt.GooGooStatementCache;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 数据字典Action
 * 
 * 封装了查询数据字典对象数据的操作
 * 
 * @author Administrator
 *
 */
public class BaseDictAction extends ActionSupport {
	
	//接收页面传递的数据字典类型码
	private String dict_type_code;
     //依赖注入baseDictService
	private BaseDictService baseDictService;
	
	

	@Override
	//查找数据字典数据对象
	public String execute() throws Exception {
		//调用servic根据typecode获得数据字典对象list
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//将list转换成json格式字符串
		String json = JsonUtil.toJson(list);
		//设置返回编码格式
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		//将json发送给浏览器
		ServletActionContext.getResponse().getWriter().write(json);
		return null;//返回空，告诉struts2不需要结果处理
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	
}
