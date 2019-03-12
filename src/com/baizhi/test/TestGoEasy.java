package com.baizhi.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.goeasy.GoEasy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
public class TestGoEasy {
		@Autowired
		private UserDao userDao;
		@Autowired
		private UserService userService;
	@Test
	public void testGoEasy(){
		GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-afb5d4858ff74c5abc85b7bbeeb067fc");
		for(int i=0;i<50;i++){
		User user=new User(null,"1","勾陈上宫天皇大帝","1","女","山东","1","1","1","1","1",null,"1");
		userDao.insertItem(user);
		}
		Map<String, Object> map = userService.findCount();
		String json=JSON.toJSONString(map);
		goEasy.publish("demo_channel", json);
	}
}
