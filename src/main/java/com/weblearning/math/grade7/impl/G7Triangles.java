package com.weblearning.math.grade7.impl;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
//import java.util.Locale;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
//import org.springframework.context.MessageSource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.grade8.impl.GR8_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.math.utilities.ProblemParser;

import com.weblearning.math.utilities.ReplaceExpressionUtility;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7Triangles extends GenericQuestion{

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private RestMathClientService restMathClient;

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		//PythonExpressionThread pExpress;
		
		resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( "classpath:/locale/math/grade7/problems/geometry/Triangles_1.xml" );

	    //get all the problems
	    List<Problem> problemList = ProblemParser.getProblems(baseresource);
	    
	    //assign variable values
	    problemList = ReplaceExpressionUtility.replaceStringWithVariableValue(problemList);
	    
	    //get expression value
	    restMathClient = new RestMathClientServiceImpl();
	    problemList = restMathClient.returnExpression(problemList);

	    //replace expression with values
	    problemList = ReplaceExpressionUtility.replaceExpressionWithValue(problemList);
	    
	    //restMathClient = new RestMathClientServiceImpl();
	    problemList = restMathClient.returnGraph(problemList);
	    
	    problemList.add(getProblem1(mathConfig));
	    problemList.add(getProblem2(mathConfig));
	    problemList.add(getProblem3(mathConfig));
	    problemList.add(getProblem4(mathConfig));
	
		return problemList;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
						
		int _1a = MathUtilities.getRandomNumber(30, 60);
		int _1b = MathUtilities.getRandomNumber(30, 60);
		int _1c = 180- _1a-_1b;
		
		int _2a = MathUtilities.getRandomNumber(30, 60);
		int _2b = MathUtilities.getRandomNumber(60, 90);
		int _2c = 190- _2a-_2b;
		
		int _3a = MathUtilities.getRandomNumber(30, 60);
		int _3b = MathUtilities.getRandomNumber(60, 90);
		int _3c = 181 - _3a-_3b;
		
		int _4a = MathUtilities.getRandomNumber(30, 60);
		int _4b = MathUtilities.getRandomNumber(60, 90);
		int _4c = 180 - _4a-_4b;
		
		String q1= Integer.toString(_1a) + " , " + Integer.toString(_1b) + " , " + Integer.toString(_1c);
		String q2= Integer.toString(_2a) + " , " + Integer.toString(_2b) + " , " + Integer.toString(_2c);
		String q3= Integer.toString(_3a) + " , " + Integer.toString(_3b) + " , " + Integer.toString(_3c);
		String q4= Integer.toString(_4a) + " , " + Integer.toString(_4b) + " , " + Integer.toString(_4c);
		
		String ans1 = "True";
		String ans2 = "False";
		String ans3 = "False";
		String ans4 = "True";
		
		
		question = "Write True/ False if the Angles make a Triangle"   ;
		
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( q1 + GR8_Constants.ANSWER_TO_QUESTION + ans1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q2 + GR8_Constants.ANSWER_TO_QUESTION + ans2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q3+ GR8_Constants.ANSWER_TO_QUESTION + ans3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q4+ GR8_Constants.ANSWER_TO_QUESTION + ans4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.TRIANGLES, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="", ans3="";
						
		int _1a = 5;
		int _1b = 6;
		int _1c = 12;
		String ans1 = "False";
		
		int _2a = 8;
		int _2b = 7;
		int _2c = 9;
		String ans2 = "True";
		
		int _3a = MathUtilities.getRandomNumber(5,10);
		int _3b = MathUtilities.getRandomNumber(5,10);
		int _3c = MathUtilities.getRandomNumber(10,20);
		if (_3a + +_3b < _3c)
			ans3 = "False";
		else 
			ans3 ="True";

		
		String q1= Integer.toString(_1a) + " , " + Integer.toString(_1b) + " , " + Integer.toString(_1c);
		String q2= Integer.toString(_2a) + " , " + Integer.toString(_2b) + " , " + Integer.toString(_2c);
		String q3= Integer.toString(_3a) + " , " + Integer.toString(_3b) + " , " + Integer.toString(_3c);
		
		
		question = "All three sides of a triangle are given. Write if True/False if they make a triangle"   ;
		
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( q1 + GR8_Constants.ANSWER_TO_QUESTION + ans1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q2 + GR8_Constants.ANSWER_TO_QUESTION + ans2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q3+ GR8_Constants.ANSWER_TO_QUESTION + ans3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.TRIANGLES, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		MessageSource mSource = mathConfig.getmSource();
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		double a = MathUtilities.getRandomNumber(10, 20);
		BigDecimal b = new BigDecimal((double)a/10).setScale(2, RoundingMode.HALF_UP);
		double c = MathUtilities.getRandomNumber(5, 9);
			
		question = "The three sides of a Triangle are " + Double.toString(a) + " mm, " + b.toString() + " cm and " + Double.toString(c) + " mm . What type of Triangle is this?";
		answer = "Isosceles";
		
		questionList.add(new QuestionLine(question));

		String heading = mSource.getMessage(GR7_Constants.TRIANGLES, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		MessageSource mSource = mathConfig.getmSource();
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		double a = MathUtilities.getRandomNumber(10, 20);
		BigDecimal b = new BigDecimal((double)a/10).setScale(2, RoundingMode.HALF_UP);
		BigDecimal c = new BigDecimal(b.doubleValue()).setScale(2, RoundingMode.HALF_UP);
			
		question = "The three sides of a Triangle are " + Double.toString(a) + " mm, " + b.toString() + " cm and " + c.toString() + " cm . What type of Triangle is this?";
		answer = "Equilateral";
		
		questionList.add(new QuestionLine(question));

		String heading = mSource.getMessage(GR7_Constants.TRIANGLES, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
}
