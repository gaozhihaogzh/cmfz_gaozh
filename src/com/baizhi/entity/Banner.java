package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Banner implements Serializable{
	private String id;
	private String title;
	private String img_path;
	private String description;
	private String status;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Banner [id=" + id + ", title=" + title + ", img_path="
				+ img_path + ", description=" + description + ", status="
				+ status + ", createTime=" + createTime + "]";
	}
	public Banner(String id, String title, String img_path, String description,
			String status, Date createTime) {
		super();
		this.id = id;
		this.title = title;
		this.img_path = img_path;
		this.description = description;
		this.status = status;
		this.createTime = createTime;
	}
	public Banner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
