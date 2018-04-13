package com.weblearning.domain;

public class QuestionLine {
	
	String questionLn;
	String format;
	
//	public QuestionLine(){
//	}
	
	public QuestionLine(String q, String type) {
		this.questionLn = q;
		this.format = type;
	}
	
	public QuestionLine(String question){
		questionLn = question;
	}
	
	public String getQuestionLn() {
		return questionLn;
	}
	public void setQuestionLn(String questionLn) {
		this.questionLn = questionLn;
	}
	
	public String getFormat() {
		return this.format;
	}
	public void setFormat(String f) {
		this.format = f;
	}
	

}
