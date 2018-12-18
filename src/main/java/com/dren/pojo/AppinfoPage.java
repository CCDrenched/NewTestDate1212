package com.dren.pojo;

public class AppinfoPage extends Appinfo{
	private int startIndex;
	private int rows=5;
	private int pageNow=1;//当前页码
	public int getStartIndex() {
		return (pageNow-1)*rows;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
}
