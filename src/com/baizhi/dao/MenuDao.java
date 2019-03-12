package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Menu;

public interface MenuDao extends BaseDao<Menu>{
	List<Menu> queryMenuByParentId(String id);
	List<Menu> queryAl();
}
