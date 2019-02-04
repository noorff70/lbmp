package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.math.utilities.ProblemParser;
import com.weblearning.math.utilities.ReplaceExpressionUtility;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7PCTDecimal extends GenericQuestion{

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private RestMathClientService restMathClient;

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		//PythonExpressionThread pExpress;
		
		resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( "classpath:/locale/math/grade7/problems/WordProblems/WordProblem.xml" );

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
	    problemList.add(getProblem1(mathConfig));
	    problemList.add(getProblem2(mathConfig));
	    problemList.add(getProblem3(mathConfig));
	    problemList.add(getProblem4(mathConfig));
	    problemList.add(getProblem5(mathConfig));
	
		return problemList;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		double price = MathUtilities.getRandomNumber(120,175)/100;
		int increase  = MathUtilities.getRandomNumber(10, 25);
		BigDecimal bg = new BigDecimal(price + price*increase).setScale(2, RoundingMode.HALF_UP);
			
		question = "The price of a bread is CAD " + Double.toString(price) +" . Recently the price increased by " + 
				Integer.toString(increase) + " . What is the current price of bread?";
		answer = bg.toString();
		
		questionList.add(new QuestionLine(question));

		String heading = "Percentage- Word Problems";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		double price = MathUtilities.getRandomNumber(120,175)/100;
		int increase  = MathUtilities.getRandomNumber(10, 25);
		BigDecimal bg = new BigDecimal(price + price*increase).setScale(2, RoundingMode.HALF_UP);
			
		question = "The price of a bread is CAD " + Double.toString(price) +" . Recently the price increased to " + 
				bg.toString() + " . By what percentage the price of bread increased?";
		answer = Integer.toString(increase);
		
		questionList.add(new QuestionLine(question));

		String heading = "Percentage- Word Problems";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		double price = MathUtilities.getRandomNumber(120,175)/100;
		int decrease  = MathUtilities.getRandomNumber(10, 25);
		BigDecimal bg = new BigDecimal(price - price*decrease).setScale(2, RoundingMode.HALF_UP);
			
		question = "The price of a bread is CAD " + Double.toString(price) +" . Recently the price decreased to " + 
				bg.toString() + " . By what percentage the price of bread decreased?";
		answer = Integer.toString(decrease);
		
		questionList.add(new QuestionLine(question));

		String heading = "Percentage- Word Problems";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		double price = MathUtilities.getRandomNumber(120,175)/100;
		int decrease  = MathUtilities.getRandomNumber(10, 25);
		BigDecimal bg = new BigDecimal(price - price*decrease).setScale(2, RoundingMode.HALF_UP);
			
		question = "The price of a bread is CAD " + Double.toString(price) +" . Recently the price decreased by " + 
				Integer.toString(decrease) + " . What is the current price of bread?";
		answer = bg.toString();
		
		questionList.add(new QuestionLine(question));

		String heading = "Percentage- Word Problems";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		double price = MathUtilities.getRandomNumber(120,175)/100;
		int decrease  = MathUtilities.getRandomNumber(10, 25);
		BigDecimal bg = new BigDecimal(price - price*decrease).setScale(2, RoundingMode.HALF_UP);
			
		question = "The price of a bread is CAD " + Double.toString(price) +" . Recently the price decreased by " + 
				Integer.toString(decrease) + " . What is the current price of bread?";
		answer = bg.toString();
		
		questionList.add(new QuestionLine(question));

		String heading = "Percentage- Word Problems";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
}
