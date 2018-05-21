package com.weblearning.domain;

public class AnswerLine {
	
	String answerLn;
	String format;
	
	public AnswerLine() {
		
	}
	
	public AnswerLine(String ans) {
		this.answerLn = ans;
	}
	
	public String getAnswerLn() {
		return answerLn;
	}
	public void setAnswerLn(String answerLn) {
		this.answerLn = answerLn;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}

}
