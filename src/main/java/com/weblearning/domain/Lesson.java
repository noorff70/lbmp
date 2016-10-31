package com.weblearning.domain;

import java.io.Serializable;


/*Class to hold the information Lesson object formed from TopicDetail
 * This will return to UI a question with answers, titles and explanation
 * 
 */

public class Lesson implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Problem problem;
	String check;
	int numberOfProblems;
	int remainingProblems;
	int numberOfCorrectAnswers;
		
	public Lesson(){
		
	}
		
		
	public String getCheck(){
		return check;
	}
	
	public void setCheck(String c){
		check = c;
	}
	
	public Problem getProblem(){
		return problem;
	}
	
	public void setProblem(Problem p){
		problem =p;
	}


	public int getNumberOfProblems() {
		return numberOfProblems;
	}


	public void setNumberOfProblems(int problems) {
		this.numberOfProblems = problems;
	}


	public int getRemainingProblems() {
		return remainingProblems;
	}


	public void setRemainingProblems(int remainingProblems) {
		this.remainingProblems = remainingProblems;
	}


	public int getNumberOfCorrectAnswers() {
		return numberOfCorrectAnswers;
	}


	public void setNumberOfCorrectAnswers(int numberOfCorrectAnswers) {
		this.numberOfCorrectAnswers = numberOfCorrectAnswers;
	}
	
}
