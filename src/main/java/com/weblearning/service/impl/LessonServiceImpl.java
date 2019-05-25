package com.weblearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.weblearning.domain.Lesson;
import com.weblearning.math.utilities.ExampleParser;
import com.weblearning.service.LessonService;

@Service("lessonService")
public class LessonServiceImpl implements LessonService{

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Override
	public List<Lesson> getLessonList(String resourcePath) {
		
		resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( resourcePath);

	    List<Lesson> lessonList = ExampleParser.getLessons(baseresource);
	    
	    return lessonList;
	}

}
