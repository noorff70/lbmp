package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.weblearning.domain.Answer;
import com.weblearning.domain.GraphObject;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.math.utilities.ProblemParser;

import com.weblearning.math.utilities.ReplaceExpressionUtility;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7StatWordProblem extends GenericQuestion{

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private RestMathClientService restMathClient;

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		//PythonExpressionThread pExpress;
		
		resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( "classpath:/locale/math/grade7/problems/statistics/StatWordProblem.xml" );

	    //get all the problems
	    List<Problem> problemList = ProblemParser.getProblems(baseresource);
	    
	    //assign variable values
	    problemList = ReplaceExpressionUtility.replaceStringWithVariableValue(problemList);
	    
	    //PythonExpressionThread pExpress = new PythonExpressionThread();
	    //pExpress.setProblemList(problemList);
	    //pExpress.start();
	    
	    //synchronized(pExpress) {
	    //	try {
	    //		pExpress.wait();
	    //	}catch(Exception e) {
	    		
	    //	}
	    //	problemList = pExpress.getProblemList();
	    //}
	    
	    //get expression value
	    restMathClient = new RestMathClientServiceImpl();
	    problemList = restMathClient.returnExpression(problemList);

	    //replace expression with values
	    problemList = ReplaceExpressionUtility.replaceExpressionWithValue(problemList);
	    
	    problemList.add(getProblem1(mathConfig));
	    problemList.add(getProblem2(mathConfig));
	    problemList.add(getProblem3(mathConfig));
	    problemList.add(getProblem4(mathConfig));
	    problemList.add(getProblem5(mathConfig));
	    
	    //restMathClient = new RestMathClientServiceImpl();
	    problemList = restMathClient.returnGraph(problemList);
	
		return problemList;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		double set1[] = new double[6];
		double set2[] = new double[6];
		double set3[] = new double[6];
		
		for (int i=0; i<5; i++) {
			set1[i] = MathUtilities.getRandomNumber(1, 6);
		}
		
		for (int i=0; i<5; i++) {
			set2[i] = MathUtilities.getRandomNumber(10, 25);
		}
		
		for (int i=0; i<5; i++) {
			set3[i] = MathUtilities.getRandomNumber(-5, 3);
		}
		

		String question="", question1="", question2="", question3="", answer="";
		double a1=0, a2=0, a3=0;
		
		for (int i=0; i< set1.length; i++) {
			question1 = question1 + (int)set1[i] + ", ";
		}
		a1 = median(set1);
		
		for (int i=0; i< set2.length; i++) {
			question2 = question2 + (int)set2[i] + ", ";
		}
		a2 = median(set2);
		
		for (int i=0; i< set3.length; i++) {
			question3 = question3 + (int)set3[i] + ", ";
		}
		a3 = median(set3);
		
		if (a1>a2 && a1>a3) {
			answer = Double.toString(a1);
		}
		else if (a2>a1 && a2> a3) {
			answer = Double.toString(a2);
		}
		else {
			answer = Double.toString(a3);
		}
		question = "You have got three sets of numbers as A= {"+question1 + "}, " + "B = {" + question2 + "}, C={ " + question3 + " }. What is the highest median among all the sets?"   ;
		
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.MEDIAN_WORD_PROBLEM, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		double set1[] = new double[6];
		double set2[] = new double[6];
		double set3[] = new double[6];
		
		for (int i=0; i<5; i++) {
			set1[i] = MathUtilities.getRandomNumber(1, 6);
		}
		
		for (int i=0; i<5; i++) {
			set2[i] = MathUtilities.getRandomNumber(10, 25);
		}
		
		for (int i=0; i<5; i++) {
			set3[i] = MathUtilities.getRandomNumber(-5, 3);
		}
		

		String question="", question1="", question2="", question3="", answer="";
		double a1=0, a2=0, a3=0;
		
		for (int i=0; i< set1.length; i++) {
			question1 = question1 + (int)set1[i] + ", ";
		}
		a1 = median(set1);
		
		for (int i=0; i< set2.length; i++) {
			question2 = question2 + (int)set2[i] + ", ";
		}
		a2 = median(set2);
		
		for (int i=0; i< set3.length; i++) {
			question3 = question3 + (int)set3[i] + ", ";
		}
		a3 = median(set3);
		
		answer = new BigDecimal((double)(a1+a2+a3)/3).setScale(2, RoundingMode.HALF_UP).toString();
		question = "You have got three sets of numbers as A= {"+question1 + "}, " + "B = {" + question2 + "}, C={ " + question3 + " }. What is the average median among all the sets?"   ;
		
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.MEDIAN_WORD_PROBLEM, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="", answer="";
		
		answer = Double.toString((9));
		question = "You have got three sets of numbers as A= {5, 3, 0, 3, 6},  B = {0, -1, 3, 2, 3, -1, 5, -1}, C= {3, 8, 9, 3, 6, 9, -2, 9}. What is the highest mode among all the sets?"   ;
		
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.MEDIAN_WORD_PROBLEM, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="", answer="";
		
		int a1= MathUtilities.getRandomNumber(20, 25);
		int a2= MathUtilities.getRandomNumber(20, 25);
		int a3= MathUtilities.getRandomNumber(20, 25);
		int a4= MathUtilities.getRandomNumber(20, 25);
		int a5= MathUtilities.getRandomNumber(20, 25);
		
		double set1[] = {a1, a2, a3, a4, a5};
		answer =  mean(set1).toString();
		
		GraphObject go = new GraphObject();
		
		List<String> dataRange = new LinkedList<String>();
		List<String> legendRange = new LinkedList<String>();
		
		dataRange.add(Integer.toString(a1));
		dataRange.add(Integer.toString(a2));
		dataRange.add(Integer.toString(a3));
		dataRange.add(Integer.toString(a4));
		dataRange.add(Integer.toString(a5));
		
		legendRange.add("Q-1");
		legendRange.add("Q-2");
		legendRange.add("Q-3");
		legendRange.add("Q-4");
		legendRange.add("Q-5");
		
		
		go.setRowVals(dataRange);
		go.setColVals(legendRange);
		go.setGraphType(Constants.PI_BAR_GRAPH);
		
		question = "Asma got numbers in her 5 quizes as shown in the graph. The quizes are scored out of 25. Teacher said the mean will be added to final. What number will be added?"   ;
		
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add(new QuestionLine( question, null, Constants.DEFAULT));

		String heading = mSource.getMessage(GR7_Constants.MEDIAN_WORD_PROBLEM, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answ);
		problem.setGraphObject(go);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="", answer="";
		
		int a1= MathUtilities.getRandomNumber(20, 25);
		int a2= MathUtilities.getRandomNumber(20, 25);
		int a3= MathUtilities.getRandomNumber(20, 25);
		int a4= MathUtilities.getRandomNumber(20, 25);
		
		double set1[] = {a1, a2, a3, a4};
		answer =  mean(set1).toString();
		
		GraphObject go = new GraphObject();
		
		List<String> rowVals = new LinkedList<String>();
		List<String> colVals = new LinkedList<String>();
		
		rowVals.add(Integer.toString(a1));
		rowVals.add(Integer.toString(a2));
		rowVals.add(Integer.toString(a3));
		rowVals.add(Integer.toString(a4));
		
		colVals.add("Q-1");
		colVals.add("Q-2");
		colVals.add("Q-3");
		colVals.add("Q-4");
		
		
		go.setRowVals(rowVals);
		go.setColVals(colVals);
		go.setGraphType(Constants.PI_BAR_GRAPH);
		
		question = "Asma got numbers in her 4 quizes as shown in the graph. The quizes are scored out of 25. Teacher said the median will be added to final. What number will be added?"   ;
		
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add(new QuestionLine( question, null, Constants.DEFAULT));

		String heading = mSource.getMessage(GR7_Constants.MEDIAN_WORD_PROBLEM, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answ);
		problem.setGraphObject(go);

		return problem;
	}
	
	public static BigDecimal mean(double[] m) {
	    double sum = 0;
	    for (int i = 0; i < m.length; i++) {
	        sum += m[i];
	    }
	    return new BigDecimal( sum / m.length).setScale(2, RoundingMode.HALF_UP);
	}
	
	// the array double[] m MUST BE SORTED
	public static double median(double[] m) {
		
		Arrays.sort(m);
	    int middle = m.length/2;
	    if (m.length%2 == 1) {
	        return m[middle];
	    } else {
	        return (m[middle-1] + m[middle]) / 2.0;
	    }
	}


	public static int mode(int a[]) {
	    int maxValue=0, maxCount=0;

	    for (int i = 0; i < a.length; ++i) {
	        int count = 0;
	        for (int j = 0; j < a.length; ++j) {
	            if (a[j] == a[i]) ++count;
	        }
	        if (count > maxCount) {
	            maxCount = count;
	            maxValue = a[i];
	        }
	    }

	    return maxValue;
	}
	
}
