package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable{
	private String id;
	private String title;
	private String href;
	private String iconCls;
	private String parentId;
	
	private List<Menu> menuList;

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

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", title=" + title + ", href=" + href
				+ ", iconCls=" + iconCls + ", parentId=" + parentId
				+ ", menuList=" + menuList + "]";
	}

	public Menu(String id, String title, String href, String iconCls,
			String parentId, List<Menu> menuList) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.iconCls = iconCls;
		this.parentId = parentId;
		this.menuList = menuList;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
