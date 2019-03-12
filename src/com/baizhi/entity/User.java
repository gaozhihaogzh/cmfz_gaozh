package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class User implements Serializable {
	@Excel(name="编号")
	private String id;
	@Excel(name="头像")
	private String photo;
	@Excel(name="法名")
	private String dharmaName;
	@Excel(name="真实姓名")
	private String realname;
	@Excel(name="性别")
	private String sex;
	@Excel(name="省份")
	private String privoince;
	@Excel(name="城市")
	private String city;
	@Excel(name="签名")
	private String sign;
	@Excel(name="手机号")
	private String phoneNum;
	private String password;
	private String salt;
	@Excel(name="注册时间")
	private Date creatTime;
	@Excel(name="账号状态")
	private String status;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", photo=" + photo + ", dharmaName="
				+ dharmaName + ", realname=" + realname + ", sex=" + sex
				+ ", privoince=" + privoince + ", city=" + city + ", sign="
				+ sign + ", phoneNum=" + phoneNum + ", password=" + password
				+ ", salt=" + salt + ", creatTime=" + creatTime + ", status="
				+ status + "]";
	}
	public User(String id, String photo, String dharmaName, String realname,
			String sex, String privoince, String city, String sign,
			String phoneNum, String password, String salt, Date creatTime,
			String status) {
		super();
		this.id = id;
		this.photo = photo;
		this.dharmaName = dharmaName;
		this.realname = realname;
		this.sex = sex;
		this.privoince = privoince;
		this.city = city;
		this.sign = sign;
		this.phoneNum = phoneNum;
		this.password = password;
		this.salt = salt;
		this.creatTime = creatTime;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDharmaName() {
		return dharmaName;
	}
	public void setDharmaName(String dharmaName) {
		this.dharmaName = dharmaName;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPrivoince() {
		return privoince;
	}
	public void setPrivoince(String privoince) {
		this.privoince = privoince;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
