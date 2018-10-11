package com.weblearning.domain;

import java.util.List;


/*Class to hold the information Lesson object formed from TopicDetail
 * This will return to UI a question with answers, titles and explanation
 * 
 */

public class Lesson {
	
	
	List<Problem> problemList;
	
	
	public Lesson(){
		
	}
		
	
	public List<Problem> getProblem(){
		return problemList;
	}
	
	public void setProblemList(List<Problem> problem){
		problemList = problem;
	}

	
}
