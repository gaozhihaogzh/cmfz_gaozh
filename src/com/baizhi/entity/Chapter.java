package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Chapter implements Serializable{
	private String id;
	private String title;
	private String url;
	private String size;
	private String duration;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date createTime;
	//关系属性
	private Album album;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	@Override
	public String toString() {
		return "Chapter [id=" + id + ", title=" + title + ", url=" + url
				+ ", size=" + size + ", duration=" + duration + ", createTime="
				+ createTime + ", album=" + album + "]";
	}
	public Chapter(String id, String title, String url, String size,
			String duration, Date createTime, Album album) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.size = size;
		this.duration = duration;
		this.createTime = createTime;
		this.album = album;
	}
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
