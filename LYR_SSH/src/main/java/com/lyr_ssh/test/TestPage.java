package com.lyr_ssh.test;

import org.junit.Test;

public class TestPage {

	//当前页数
	private Integer currentPage;
		//总记录数
	private Integer totalCount = 13;
	//每页显示条数
	private Integer pageSize = 3;
	//总页数
	private Integer totalPage=0;
	@Test
	public void test(){
		//计算总页数  (总记录数/每页显示条数)---》【每页显示条数-1 --》临界值】 -------》(总记录数+每页显示条数-1)/每页显示条数
		this.totalPage =(this.totalCount+this.pageSize-1)/this.pageSize;
		System.out.println("总页数："+totalPage);
	}
}
