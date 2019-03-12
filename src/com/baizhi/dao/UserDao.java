package com.baizhi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.User;

public interface UserDao extends BaseDao<User>{
	List<User> queryAl(Map<String, Integer> map);
	int count();
	int findBySex(@Param("sex")String sex,@Param("creatTime")Integer creatTime);
	List<String> findD();
	List<User> findUser();
}
