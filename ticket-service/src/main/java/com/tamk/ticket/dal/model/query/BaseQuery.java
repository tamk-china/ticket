package com.tamk.ticket.dal.model.query;

public class BaseQuery {
	private Integer pageNum;
	private Integer pageSize;

	public Integer getPageNum() {
		if(null == this.pageNum){
			return 1;
		}
		
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		if(null == this.pageSize){
			return Integer.MAX_VALUE;
		}
		
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getStart(){
		return (getPageNum() - 1) * getPageSize();
	}

}
