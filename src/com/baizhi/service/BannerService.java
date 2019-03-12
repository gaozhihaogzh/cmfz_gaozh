package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Banner;

public interface BannerService {
	void addBanner(Banner b);
	void removeBanner(String id);
	void modifyBanner(Banner b);
	List<Banner> findAll(Integer page,Integer rows);
	Banner findById(String id);
	void modifyStatusYes(String id);
	void modifyStatusNo(String id);
	void removeSome(List<String> list);
	int count();
}
