package com.baizhi.entity;

import java.io.Serializable;

public class Echars implements Serializable{
	private String name;
	private Integer value;
	public Echars() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Echars(String name, Integer value) {
		super();
		this.name = name;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Echars [name=" + name + ", value=" + value + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
