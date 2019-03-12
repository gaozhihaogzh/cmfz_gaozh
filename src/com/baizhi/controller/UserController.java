package com.baizhi.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/findAll.do")
	public Map<String, Object> findAll(int page,int rows){
		List<User> list = userService.findAll(page, rows);
		int count = userService.count();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping("/registTime.do")
	public Map<String , Object> registTime(){
		return userService.findCount();
	}
	@RequestMapping("/diTu.do")
	public List< Object> diTu(){
		return userService.findD();
	}
	
	@RequestMapping("/findUser.do")
	public ModelAndView findUser(){
		System.out.println("1212");
		userService.fingUser();
		return new ModelAndView("redirect:/main.jsp");
	}
}
