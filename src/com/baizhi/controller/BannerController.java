package com.baizhi.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Page;
import com.baizhi.service.BannerService;

@Controller
@RequestMapping(value="banner",method={RequestMethod.GET,RequestMethod.POST})
public class BannerController {
	
	@Autowired
	private BannerService bs;
	
	
	
	//查询展示所有轮播图信息
	@RequestMapping("selectAll")
	@ResponseBody
	public Map<String, Object> selectAll(Integer page,Integer rows){
		List<Banner> list = bs.findAll(page,rows);
		int count = bs.count();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", list);
		return map;
	}
	
	//添加一条数据信息,把图片上传到服务器上
	@RequestMapping("saveBanner")
	@ResponseBody
	public String saveBanner(MultipartFile upFile,HttpSession session,Banner b){
		try {
			String name=upFile.getOriginalFilename();
			String extension = FilenameUtils.getExtension(name);
			name=UUID.randomUUID()+"."+extension;
			String img_path="image/"+name;
			b.setImg_path(img_path);
			String realPath=session.getServletContext().getRealPath("/image");
			upFile.transferTo(new File(realPath+"/"+name));
			bs.addBanner(b);
			return "ok";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return "error";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	//删除一条数据
	@RequestMapping("deleteBanner")
	@ResponseBody
	public String deleteBanner(String id){
		try {
			bs.removeBanner(id);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//修改轮播图信息
	@RequestMapping("modifyBanner")
	@ResponseBody
	public String modifyBanner(Banner b){
		try {
			bs.modifyBanner(b);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//修改轮播图为轮播状态
	@RequestMapping("modifyStatusYes")
	@ResponseBody
	public String modifyStatusYes(String id){
		try {
			bs.modifyStatusYes(id);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	//修改轮播图为未轮播状态
	@RequestMapping("modifyStatusNo")
	@ResponseBody
	public String modifyStatusNo(String id){
		try {
			bs.modifyStatusNo(id);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//批量删除
	@RequestMapping("deleteSome")
	@ResponseBody
	public String deleteSome(@RequestBody List<String> list){
		try {
			bs.removeSome(list);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
