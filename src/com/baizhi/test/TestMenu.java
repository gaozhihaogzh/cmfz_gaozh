/*package com.baizhi.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;

public class TestMenu {
	@Autowired
	private MenuService menuService;
	
	@Test
	public void testInsert(){
		//获取service对象会出错，获取dao对象不会报错
		ApplicationContext as = new ClassPathXmlApplicationContext("/spring.xml");
		MenuDao md = (MenuDao) as.getBean("menuDao");
		for(int i=0;i<6;i++){
			Menu menu=new Menu();
			menu.setId(UUID.randomUUID().toString());
			md.insertItem(menu);
		}
		
	
	}
	
	@Test
	public void testQuery(){
		ApplicationContext as = new ClassPathXmlApplicationContext("/spring.xml");
		MenuDao md = (MenuDao) as.getBean("menuDao");
		System.out.println(md.queryById("3595a5ed-8acc-4324-bd44-a8dc515ddb04"));
		System.out.println(md.queryAll());
	}
	
	@Test
	public void testUpDate(){
		ApplicationContext as=new ClassPathXmlApplicationContext("/spring.xml");
		MenuDao md=(MenuDao) as.getBean("menuDao");
		Menu menu=new Menu();
		menu.setId("3595a5ed-8acc-4324-bd44-a8dc515ddb04");
		menu.setIconCls("icon-remove");
		menu.setTitle("测试的功能");
		menu.setHref("点击那里呢");
	}
	
	@Test
	public void testService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("/spring.xml");	
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}
		MenuService ms=(MenuService)ac.getBean("menuServiceImpl");
		List<Menu> findAll = ms.findAll();
		for (Menu menu : findAll) {
			System.out.println(menu);
		}
	}
	
}
*/