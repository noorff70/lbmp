package com.weblearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weblearning.domain.Lesson;

@Service
public interface LessonService {
	
	public List<Lesson> getLessonList();

}
