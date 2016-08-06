package com.weblearning.domain;

import java.io.Serializable;
import java.util.List;


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
	
}
