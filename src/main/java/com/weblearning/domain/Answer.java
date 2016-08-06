package com.weblearning.domain;

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
	String type;
		
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
