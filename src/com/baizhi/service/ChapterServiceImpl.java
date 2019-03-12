package com.baizhi.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class ChapterServiceImpl implements ChapterService{

	@Autowired
	private ChapterDao cd;
	
	@Override
	public Chapter findById(String id) {
		Chapter chapter = cd.queryById(id);
		return chapter;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addChapter(Chapter chapter) {
		String id = UUID.randomUUID().toString();
		chapter.setId(id);
		cd.insertItem(chapter);
	}

}
