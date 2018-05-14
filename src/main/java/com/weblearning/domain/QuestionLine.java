package com.weblearning.domain;

public class QuestionLine {
	
	String questionLn;
	String format;
	String latexFormat;
	
	public QuestionLine(){
	}
	
	public QuestionLine(String q, String type, String lFormat) {
		this.questionLn = q;
		this.format = type;
		this.latexFormat = lFormat;
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
	
	public String getLatexFormat() {
		return this.latexFormat;
	}
	public void setLatexFormat(String lf) {
		this.latexFormat = lf;
	}
	

}
