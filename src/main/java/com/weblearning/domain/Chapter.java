package com.weblearning.domain;

import java.util.List;

public class Chapter {
	
	private List<Problem> problemList;
	private List<Lesson> lessonList;
	
	
	public List<Problem> getProblemList() {
		return problemList;
	}
	public void setProblemList(List<Problem> problemList) {
		this.problemList = problemList;
	}
	public List<Lesson> getLessonList() {
		return lessonList;
	}
	public void setLessonList(List<Lesson> ls) {
		this.lessonList = ls;
	}
	
	

}
