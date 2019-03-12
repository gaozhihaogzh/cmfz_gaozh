package com.baizhi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/login.do")
	public ModelAndView login(String name,String password,String enCode,HttpSession session){
		ModelAndView mv=new ModelAndView();
		String code = (String) session.getAttribute("code");
		if(code.equals(enCode)){
			Admin admin = adminService.login(name, password);
			System.out.println("admin:"+admin);
			if(admin==null){
				System.out.println("admin为null");
				mv.setViewName( "redirect:/login.jsp");
				return mv;
			}else{
				session.setAttribute("ok", "ok");
				mv.setViewName( "redirect:/main.jsp");
				return mv;
			}
		}else{
			System.out.println("验证码不正确");
			mv.setViewName( "redirect:/login.jsp");
			return mv;
		}
		
	}
	
	/*注册*/
	@RequestMapping("/zhuCe.do")
	public ModelAndView zhuCe(Admin admin){
		adminService.addAdmin(admin);
		return new ModelAndView("redirect:/login.jsp");
	}
	/*退出系统*/
	@RequestMapping("/exit.do")
	public ModelAndView exit(HttpSession session){
		/*清除session*/
		session.invalidate();
		return new ModelAndView("redirect:/login.jsp");
	}
}
