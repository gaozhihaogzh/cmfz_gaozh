package com.baizhi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	@Override
	public Admin login(String name, String password) {
		return adminDao.queryByNameAndPassword(name, password);
	}

	@Override
	public Admin findAdmin(String name) {
		// TODO Auto-generated method stub
		return adminDao.queryByName(name);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void addAdmin(Admin admin) {
		adminDao.insertItem(admin);
	}

	@Override
	public Object login1(String name, String password) {
		Admin admin = adminDao.queryByName(name);
		Map<String, String> map = new  HashMap<String, String>();
		if(admin==null){
			map.put("status", "400");
			map.put("massgin", "账号不存在");
		}else{
			
		}
		return null;
	}

}
