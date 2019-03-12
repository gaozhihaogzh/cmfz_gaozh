package com.baizhi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<T> {
	void insertItem(T t);
	void deleteItem(String id);
	void updateItem(T t);
	List<T> queryAll(Map<String, Integer> map);
	T queryById(String id);
}
