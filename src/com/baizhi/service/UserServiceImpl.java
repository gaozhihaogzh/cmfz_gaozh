package com.baizhi.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Echars;
import com.baizhi.entity.User;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userdao;

	@Override
	public List<User> findAll(int page, int rows) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		List<User> list = userdao.queryAl(map);
		return list;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return userdao.count();
	}

	@Override
	public Map<String, Object> findCount() {
		Map<String, Object> map =new HashMap<String, Object>();
		ArrayList<String> list=new ArrayList<String>();
		ArrayList<Integer> list1=new ArrayList<Integer>();
		ArrayList<Integer> list2=new ArrayList<Integer>();
		for(int i=0;i<12;i++){
			list.add(i+1+"月");
			list1.add(userdao.findBySex("男",1+i));
			list2.add(userdao.findBySex("女",1+i));
		}
		System.out.println(list);
		System.out.println(list1);
		System.out.println(list2);
		map.put("mm", list);
		map.put("man", list1);
		map.put("woman", list2);
		return map;
	}

	@Override
	public List<Object> findD() {
		List<String> list = userdao.findD();
		List<Object> cha=new ArrayList<Object>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (int i = 0; i < list.size(); i++) {
			if(map.get(list.get(i))!=null){
				int abc = (Integer)map.get(list.get(i));
				map.put(list.get(i),abc+1);
			}else{
				map.put(list.get(i),1);
			 }
		  }
		
		for (Map.Entry<String,Integer> entry:map.entrySet()) {
			cha.add(new Echars(entry.getKey(),entry.getValue()));
		}
		return cha;
	}

	@Override
	public void addUser(User user) {
		userdao.insertItem(user);
	}

	@Override
	public void fingUser(){
		List<User> list = userdao.findUser();
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息统计","用户"),User.class, list);
		try {
			workbook.write(new FileOutputStream("e:/用户信息统计.xls"));
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
