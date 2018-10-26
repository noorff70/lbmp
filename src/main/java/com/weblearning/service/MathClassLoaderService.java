package com.weblearning.service;

import java.util.List;

import org.springframework.context.MessageSource;

import com.weblearning.domain.Lesson;
import com.weblearning.domain.Problem;

public interface MathClassLoaderService {
	
	public List<Problem> getProblemList(String className);
	
	public void setGradeId(String gradeId);
	
	public String  getGradeId();
	
	public MessageSource getMessageResource(String gradeId);
	
	public List<Lesson> getLessonList(String className);

}
