package com.weblearning.math.grade7.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.ProblemParser;
import com.weblearning.math.utilities.ReplaceExpressionUtility;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;

public class G7AlgExpWrite extends GenericQuestion{
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private RestMathClientService restMathClient;

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		//PythonExpressionThread pExpress;
		
		resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( "classpath:/locale/math/grade7/problems/AlgebricExp/G7AlgExpWrite.xml" );

	    //get all the problems
	    List<Problem> problemList = ProblemParser.getProblems(baseresource);
	    
	    //assign variable values
	    problemList = ReplaceExpressionUtility.replaceStringWithVariableValue(problemList);
	    
/*	    pExpress = new PythonExpressionThread();
	    pExpress.setProblemList(problemList);
	    pExpress.start();
	    
	    synchronized(pExpress) {
	    	try {
	    		pExpress.wait();
	    	}catch(Exception e) {
	    		
	    	}
	    	problemList = pExpress.getProblemList();
	    	return problemList;
	    }*/
	    
	    //get expression value
	    restMathClient = new RestMathClientServiceImpl();
	    problemList = restMathClient.returnExpression(problemList);

	    //replace expression with values
	    problemList = ReplaceExpressionUtility.replaceExpressionWithValue(problemList);
	    
	   // synchronized (this) {
	   // 	problemList = restMathClient.returnAnswerList(problemList);
	   // }
	
		return problemList;
	}
}