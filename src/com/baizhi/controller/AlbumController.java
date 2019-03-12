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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Album;
import com.baizhi.entity.Page;
import com.baizhi.service.AlbumService;

@RestController
@RequestMapping(value="album",method={RequestMethod.GET,RequestMethod.POST})
public class AlbumController {
	
	@Autowired
	private AlbumService as;
	
	//查询所有专辑（包括章节）
	@RequestMapping("selectAll")
	public Map<String, Object> selectAll(Integer page,Integer rows){
		List<Album> list = as.findAll(page, rows);
		int count = as.count();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 添加专辑需要上传对应的图片
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("saveAlbum")
	public void saveAlbum(MultipartFile upFile,HttpSession session,Album album) throws IllegalStateException, IOException{
		//获取文件名
		String fileName = upFile.getOriginalFilename();
		String extension = FilenameUtils.getExtension(fileName);
		fileName=UUID.randomUUID()+"."+extension;
		String realPath=session.getServletContext().getRealPath("/album_img");
		File file=new File(realPath);
		if(!file.exists()){
			file.mkdir();
		}
		String coverImg="album_img/"+fileName;
		album.setCoverImg(coverImg);
		upFile.transferTo(new File(realPath+"/"+fileName));
		as.addAlbum(album);
	}
	
	/**
	 * 专辑详情
	 * 根据Id进行查询
	 */
	@RequestMapping("selectById")
	public Album selectById(String id){
		Album album = as.findById(id);
		return album;
	}
	
}
