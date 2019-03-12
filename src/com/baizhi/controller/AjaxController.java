package com.baizhi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/Captcha.do")
	public void Captcha(HttpServletResponse response,HttpSession session) throws IOException {
		String code=SecurityCode.getSecurityCode();
		session.setAttribute("code",code);
		BufferedImage image = SecurityImage.createImage(code);
		OutputStream out = response.getOutputStream();
		ImageIO.write(image, "png", out);
	}
	@RequestMapping("/findByName.do")
	public @ResponseBody void findByName(HttpServletResponse response,String name) throws IOException{
		Admin admin = adminService.findAdmin(name);
		System.out.println("admin+++"+admin);
		if(admin==null){
			response.getWriter().print("The account can be used.");
		}else{
			response.getWriter().print("The account is occupied");
		}
	}
	/*验证码表单验证*/
	@RequestMapping("/findByCode.do")
	public @ResponseBody void findByCode(HttpServletResponse response,String enCode,HttpSession session) throws IOException{
		String code=(String) session.getAttribute("code");
		if(code.equals(enCode)){
			response.getWriter().print("Validation Successful");
		}else{
			response.getWriter().print("Validation Failed");
		}
	}
}
