package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Banner;

public interface BannerDao extends BaseDao<Banner>{
	void updateStatusYes(String id);
	void updateStatusNo(String id);
	void deleteSome(List<String> l);
	int count();
}
