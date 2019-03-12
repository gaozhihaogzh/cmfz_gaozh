package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService{
	Admin login(String name,String password);
	Admin findAdmin(String name);
	void addAdmin(Admin admin);
	Object login1(String name,String password);
}
