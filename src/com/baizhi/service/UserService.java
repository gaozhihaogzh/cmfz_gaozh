package com.baizhi.service;

import java.util.List;
import java.util.Map;

import com.baizhi.entity.User;

public interface UserService {
	List<User> findAll(int page,int rows);
	int count();
	Map<String, Object> findCount();
	List<Object> findD();
	void addUser(User user);
	void fingUser();
}
