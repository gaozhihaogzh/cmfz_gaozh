package com.baizhi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;


@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumDao ad;
	
	@Override
	public List<Album> findAll(Integer page, Integer rows) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		List<Album> list=ad.queryAll(map);
		return list;
	}

	@Override
	public Album findById(String id) {
		Album album = ad.queryById(id);
		return album;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addAlbum(Album album) {
		String id = UUID.randomUUID().toString();
		album.setId(id);
		album.setStatus("0");
		ad.insertItem(album);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void modifyAlbum(Album album) {
		ad.updateItem(album);
	}

	@Override
	public int count() {
		return ad.count();
	}

}
