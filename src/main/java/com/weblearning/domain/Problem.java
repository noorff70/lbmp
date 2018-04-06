package com.weblearning.domain;

import java.util.List;

/**
 * 
 * @author Faizul
 *
 *This is the POJO that defines a problem 
 */
public class Problem {
	
	int rank;
	/*Question heading */
	String questionHeading;
	/*Question subheading */
	String questionSubHeading;
	String picturePath;
	/*Question lines in the question */
	List<QuestionLine> questionLines;
	/*Answer to the question */
	Answer answer;
	GeometryObject  geometryObject;
	
	public String getQuestionSubHeading() {
		return questionSubHeading;
	}

	public void setQuestionSubHeading(String questionSubHeading) {
		this.questionSubHeading = questionSubHeading;
	}

	public int getRank() {
		return rank;
	}

	public Problem(){
		
	}
		
	public int getPRank() {
		return rank;
	}
	public void setRank(int r) {
		this.rank = r;
	}
	
	
	public String getQuestionHeading() {
		return questionHeading;
	}
	public void setQuestionHeading(String questionHeading) {
		this.questionHeading = questionHeading;
	}
	
		
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	public List getQuestionLines(){
		return questionLines;
	}
	
	public void setQuestionLines(List questions){
		questionLines= questions;
	}
	
	public GeometryObject getGeometryObject(){
		return geometryObject;
	}
	
	public void setGeometryObject(GeometryObject geoObject){
		geometryObject= geoObject;
	}
	
	public String getPicturePath() {
		return this.picturePath;
	}
	
	public void setPicturePath(String pic) {
		this.picturePath = pic;
	}

}
