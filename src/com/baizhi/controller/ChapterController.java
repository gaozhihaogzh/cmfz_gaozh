package com.baizhi.controller;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;

@Controller
@RequestMapping(value="chapter",method={RequestMethod.GET,RequestMethod.POST})
public class ChapterController {
	
	@Autowired
	private ChapterService cs;
	@Autowired
	private AlbumService as;
	
	/**
	 * 添加章节
	 * 上传对应的音频文件
	 * 添加进对应的专辑
	 * 专辑中章节的数量加一
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @throws EncoderException 
	 * @throws InputFormatException 
	 */
	@RequestMapping("saveChapter")
	@ResponseBody
	public void saveChapter(MultipartFile upFile,HttpSession session,Chapter chapter,String id) throws IllegalStateException, IOException, InputFormatException, EncoderException{
		//对应专辑中章节的数量加一
		Album album = as.findById(id);
		album.setCount(album.getCount()+1);
		as.modifyAlbum(album);
		//上传对应的音频文件
		//得到上传时的文件名
		String fileName = upFile.getOriginalFilename();
		//获得文件名的扩展名
		String extension = FilenameUtils.getExtension(fileName);
		//计算上传文件的大小
		byte[] bytes = upFile.getBytes();
		//System.out.println("bytes="+bytes.length);
		//在此我用BigDecimal将其保留两位小数
		BigDecimal size = new BigDecimal(bytes.length);
		BigDecimal mod = new BigDecimal(1024);
		//除两个1024，保留两位小数，进行四舍五入
		size = size.divide(mod).divide(mod).setScale(2, BigDecimal.ROUND_HALF_UP);
		//进行拼接，得到完整文件名
		fileName=UUID.randomUUID()+"."+extension;
		String realPath = session.getServletContext().getRealPath("/album_chapter");
		File file=new File(realPath);
		if(!file.exists()){
			file.mkdir();
		}
		String url="album_chapter/"+fileName;
		chapter.setUrl(url);
		upFile.transferTo(new File(realPath,fileName));
		//计算文件的时长
		long length = 0l;
		Encoder encoder = new Encoder();
		//getInfo()的参数是一个File,不能用MultipartFile
		//getDuration()获取得到的文件时长是一个以毫秒为单位的long类型的数值
		length = encoder.getInfo(new File(realPath,fileName)).getDuration();
		//System.out.println(length/1000/60+"分"+length/1000%60+"秒");
		String duration=length/1000/60+"分"+length/1000%60+"秒";
		//添加章节，添加进对应的章节
		chapter.setAlbum(album);
		chapter.setSize(size.toString()+"MB");
		chapter.setDuration(duration);
		cs.addChapter(chapter);
	}
	
	
	/**
	 * 下载音频
	 * 首先获取音频下载路径
	 * @throws IOException 
	 */
	@RequestMapping("download")
	public String download(String id,HttpServletResponse response,HttpSession session) throws IOException{
		//获取路径
		Chapter chapter = cs.findById(id);
		String url = chapter.getUrl();
		String realPath = session.getServletContext().getRealPath(url);
		System.out.println(realPath+"下载文件位置");
		System.out.println(url+"-----url");
		//创建下载文件名
		String extension = FilenameUtils.getExtension(url);
		String filename=UUID.randomUUID()+"."+extension;
		//准备输入流
		InputStream is=new FileInputStream(realPath);
		//设置下载文件的类型以及下载的方式
		OutputStream os=response.getOutputStream();
		response.setHeader("content-type", "audio/mp4");
		response.setHeader("content-disposition", "attachment;filename="+filename);
		//使用io流下载到客户端
		IOUtils.copy(is, os);
		return null;
	}
	
	
}
