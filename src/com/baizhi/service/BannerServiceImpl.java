package com.baizhi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class BannerServiceImpl implements BannerService{
	
	@Autowired
	private BannerDao bd;
	
	@Override
	public void addBanner(Banner b) {
		String id = UUID.randomUUID().toString();
		b.setId(id);
		b.setStatus("0");
		bd.insertItem(b);
		
	}

	@Override
	public void removeBanner(String id) {
		bd.deleteItem(id);
	}

	@Override
	public void modifyBanner(Banner b) {
		bd.updateItem(b);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Banner> findAll(Integer page,Integer rows) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		List<Banner> list = bd.queryAll(map);
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Banner findById(String id) {
		Banner ban = bd.queryById(id);
		return ban;
	}

	@Override
	public void modifyStatusYes(String id) {
		bd.updateStatusYes(id);
		
	}

	@Override
	public void modifyStatusNo(String id) {
		bd.updateStatusNo(id);
	}

	@Override
	public void removeSome(List<String> list) {
		bd.deleteSome(list);
	}

	@Override
	public int count() {
		return bd.count();
	}

}
