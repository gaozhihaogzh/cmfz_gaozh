package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Menu;

public interface MenuService {
	List<Menu> findAll();
	List<Menu> findAllByParentId(String parentId);
	Menu findById(String id);
	void addMenu(Menu menu);
}
