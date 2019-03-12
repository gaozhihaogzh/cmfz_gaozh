package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Album;

public interface AlbumService {
	List<Album> findAll(Integer page,Integer rows);
	Album findById(String id);
	void addAlbum(Album album);
	void modifyAlbum(Album album);
	int count();
}
