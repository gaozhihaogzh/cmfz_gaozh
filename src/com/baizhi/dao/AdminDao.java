package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Admin;

public interface AdminDao extends BaseDao<Admin>{
	Admin queryByNameAndPassword(@Param("name") String name,@Param("password")String password);
	Admin queryByName(String name);
}
