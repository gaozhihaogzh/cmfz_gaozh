package com.baizhi.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.context.annotation.Primary;

import com.baizhi.service.MenuService;
import com.baizhi.service.MenuServiceImpl;

//@Configuration
//public class Conf {
//	@Primary
//	@Bean(name="menuService")
//	public MenuService getMenuService(){
//		return new MenuServiceImpl();
//	}
//这个类使用来给MenuService强制手动注入，当这个类存在时，在Controller层自动注入时，由于无法选择使用SpringMVC的自动注入还是本类的自动注入，因此会报错
//}
