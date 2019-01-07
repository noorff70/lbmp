package com.weblearning.math.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.weblearning.domain.Problem;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;

public class PythonExpressionThread extends Thread{
	
	@Autowired
	private RestMathClientService restMathClient;

	List<Problem> problemList;
	
	public void run() {
		
		List<Problem> returnedList = new ArrayList<Problem>();
	    restMathClient = new RestMathClientServiceImpl();

	    try {
			synchronized(this) {
				while ( returnedList.size() < problemList.size()) {
					returnedList = restMathClient.returnExpression(problemList);
				}
				this.problemList = returnedList;
				problemList = ReplaceExpressionUtility.replaceExpressionWithValue(problemList);
				notify();
			}
			
		}catch(Exception e) {
			
		}
	}
	
	public List<Problem> getProblemList() {
		return this.problemList;
	}
	
	public void setProblemList(List<Problem> pList) {
		this.problemList = pList;
	}
	
}
