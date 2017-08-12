package com.mongospringmysql.servercenter.page;

import java.util.List;

public class Page<T> {

	// 当前页
	private long thispage;
	// 下一页
	private long nextpage;
	// 总页数
	private long countpage;
	// 上一页
	private long prepage;
	// 首页
	private long firstpage = 1;
	// 末页
	private long lastpage;
	// 一页显示多少行（客户）
	private long rowperpage;
	// 总行数（总数）
	private long countrow;
	// bean信息
	private List<T> list;

	public Page() {
	}
	public Page(long thispage, long rowperpage,long countrow) {
		this.countrow = countrow;
		this.rowperpage = rowperpage;
		this.thispage = thispage <= getCountpage() ? thispage : getCountpage();
		if(0 == this.thispage){
			this.thispage = 1 ;
		}
		//firstpage = 1;
		//lastpage = countpage;
		//prepage = thispage==1?1:thispage-1;
		//nextpage = thispage == countpage ? countpage : thispage+1;
	}
	
	
	public long getThispage() {
		return thispage;
	}
	public void setThispage(long thispage) {
		this.thispage = thispage;
	}
	public long getRowperpage() {
		return rowperpage;
	}
	public void setRowperpage(long rowperpage) {
		this.rowperpage = rowperpage;
	}
	public long getCountrow() {
		return countrow;
	}
	public void setCountrow(long countrow) {
		this.countrow = countrow;
	}
	public long getFirstpage() {
		return firstpage;
	}
	public long getNextpage() {
		return thispage == getCountpage() ? getCountpage() : thispage+1;
	}
	public long getCountpage() {
		return countrow/rowperpage+(countrow%rowperpage==0?0:1);
	}
	public long getPrepage() {
		return thispage==1?1:thispage-1;
	}
	public long getLastpage() {
		return countrow/rowperpage+(countrow%rowperpage==0?0:1);
	}
	public void setLastpage(long lastpage) {
		this.lastpage = lastpage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
