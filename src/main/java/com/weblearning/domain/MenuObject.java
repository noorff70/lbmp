package com.weblearning.domain;

import java.util.List;

public class MenuObject {
	
	String gradeName;
	int gradeId;
	List<MenuSubject> subjects;
	
	public List<MenuSubject> getSubjects () {
		return this.subjects;
	}
	
	public void setSubjects (List<MenuSubject> sub) {
		this.subjects = sub;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	
}
