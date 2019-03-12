package com.baizhi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;


@Controller
@RequestMapping(value="menu",method={RequestMethod.GET,RequestMethod.POST})
public class MenuController {
	
	@Autowired
	private MenuService ms;
	
	//查询所有的菜单功能
	@RequestMapping("selectAll")
	@ResponseBody
	public List<Menu> selectAll(){
			List<Menu> list = ms.findAll();
			return list;
	}
}
