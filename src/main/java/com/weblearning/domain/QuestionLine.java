package com.weblearning.domain;

public class QuestionLine {
	
	String questionLn;
	String format;
	
	public QuestionLine(){
		
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
	

}
