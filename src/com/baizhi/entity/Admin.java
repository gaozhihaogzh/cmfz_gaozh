package com.baizhi.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	private String id;
	private String name;
	private String password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}
	public Admin(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
