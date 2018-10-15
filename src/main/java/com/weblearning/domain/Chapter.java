package com.weblearning.domain;

import java.util.List;

public class Chapter {
	
	private List<Problem> problemList;
	private List<LessonBody> lessonList;
	
	
	public List<Problem> getProblemList() {
		return problemList;
	}
	public void setProblemList(List<Problem> problemList) {
		this.problemList = problemList;
	}
	public List<LessonBody> getLessonList() {
		return lessonList;
	}
	public void setLessonList(List<LessonBody> ls) {
		this.lessonList = ls;
	}
	
	

}
