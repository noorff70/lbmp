package com.weblearning.domain;

import java.util.List;

/**
 * 
 * @author Faizul
 *
 *This class will hold the information regarding a specific problem/Question
 */

public class Answer {
	
	/*Answer to the question */
	String answer;
	/*Type of the answer, i.e String answerr or something else */
	String answerOption;
	List<AnswerLine> answerList;
	String displayableAnswer;
	String expression;
	String answerType;
	
	int noOfCorrectAnswer;
		
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public void setNoOfCorrectAnswer(int no){
		noOfCorrectAnswer = no;
	}
	
	public int getNoOfCorrectAnswer(){
		return noOfCorrectAnswer;
	}
	
	public String getAnswerOption() {
		return answerOption;
	}
	
	public void setAnswerOption(String ans) {
		answerOption = ans;
	}
	
	public List<AnswerLine> getAnswerList(){
		return this.answerList;
	}
	
	public void setAnswerList(List<AnswerLine> answers) {
		this.answerList = answers;
	}
	
	public String getDisplayableAnswer() {
		return this.displayableAnswer;
	}
	
	public void setDisplayableAsnwer(String ans) {
		this.displayableAnswer = ans;
	}
	
	public String getExpression() {
		return this.expression;
	}
	public void setExpression(String exp) {
		this.expression = exp;
	}
	
	public void setAnswerType(String s) {
		this.answerType = s;
	}
	public String getAnswerType() {
		return this.answerType;
	}

}
