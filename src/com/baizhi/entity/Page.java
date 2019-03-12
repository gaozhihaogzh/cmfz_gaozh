package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{
	private Integer total;
	private List<?> rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Page [total=" + total + ", rows=" + rows + "]";
	}
	public Page(Integer total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
