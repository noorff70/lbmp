package com.weblearning.domain;

public class LessonBody {
	
	String lessonHeader;
	String lessonBody;
	String picturePath;
	
	public String getLessonHeader() {
		return lessonHeader;
	}
	public void setLessonHeader(String lessonHeader) {
		this.lessonHeader = lessonHeader;
	}
	public String getLessonBody() {
		return lessonBody;
	}
	public void setLessonBody(String lessonBody) {
		this.lessonBody = lessonBody;
	}
	
	public void setPicturePath(String path) {
		this.picturePath = path;
	}
	public String getPicturePath() {
		return this.picturePath;
	}

}
