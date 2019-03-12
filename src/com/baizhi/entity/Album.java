package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Album implements Serializable{
	private String id;
	private String title;
	private String score;
	private String brodcast;
	private String author;
	private String brief;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date publicTime;
	private Integer count;
	private String coverImg;
	private String status;
	private List<Chapter> children;
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getBrodcast() {
		return brodcast;
	}
	public void setBrodcast(String brodcast) {
		this.brodcast = brodcast;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public Date getPublicTime() {
		return publicTime;
	}
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getCoverImg() {
		return coverImg;
	}
	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Chapter> getChildren() {
		return children;
	}
	public void setChildren(List<Chapter> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", score=" + score
				+ ", brodcast=" + brodcast + ", author=" + author + ", brief="
				+ brief + ", publicTime=" + publicTime + ", count=" + count
				+ ", coverImg=" + coverImg + ", status=" + status
				+ ", children=" + children + "]";
	}
	public Album(String id, String title, String score, String brodcast,
			String author, String brief, Date publicTime, Integer count,
			String coverImg, String status, List<Chapter> children) {
		super();
		this.id = id;
		this.title = title;
		this.score = score;
		this.brodcast = brodcast;
		this.author = author;
		this.brief = brief;
		this.publicTime = publicTime;
		this.count = count;
		this.coverImg = coverImg;
		this.status = status;
		this.children = children;
	}
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
