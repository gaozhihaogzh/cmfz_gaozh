package com.baizhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDao md;
	//查询所有的菜单
	@Override
	public List<Menu> findAll() {
		List<Menu> list = md.queryAl();
		return list;
	}

	
	//查询所有的二级菜单
	@Override
	public List<Menu> findAllByParentId(String parentId) {
		List<Menu> list = md.queryMenuByParentId(parentId);
		return list;
	}


	//根据Id查询
	@Override
	public Menu findById(String id) {
		Menu menu = md.queryById(id);
		return menu;
	}


	//添加新的菜单功能
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addMenu(Menu menu) {
		md.insertItem(menu);
		
	}

}
