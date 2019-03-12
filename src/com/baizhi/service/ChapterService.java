package com.baizhi.service;

import com.baizhi.entity.Chapter;

public interface ChapterService {
	Chapter findById(String id);
	void addChapter(Chapter chapter);
}
