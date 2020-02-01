package com.weblearning.math.grade7.impl;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
import com.weblearning.domain.utility.geometry.CircleObject;
import com.weblearning.domain.utility.geometry.GeometryObject;
import com.weblearning.domain.utility.geometry.LabelObject;
import com.weblearning.domain.utility.geometry.LineObject;
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
	
	//draw a triangle
	public Problem getProblem5(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="", q2="", q3="";
			
		GeometryObject geo = new GeometryObject();
		List<CircleObject> circleList = new ArrayList<CircleObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		List<LineObject> lineList = new ArrayList<LineObject>();
			
		CircleObject co1= new CircleObject();
		LabelObject lo1 = new LabelObject();
		int _1x = 3;
		int _1y = 0;
		co1.setxCo(Double.valueOf(_1x));
		co1.setyCo(Double.valueOf(_1y));
		lo1.setxCo(Double.valueOf(_1x+.025));
		lo1.setyCo(Double.valueOf(_1y+.025));
		lo1.setLabelName("A");
			
		CircleObject co2= new CircleObject();
		LabelObject lo2 = new LabelObject();
		int _2x = 7;
		int _2y = 0;
		co2.setxCo(Double.valueOf(_2x));
		co2.setyCo(Double.valueOf(_2y));
		lo2.setxCo(Double.valueOf(_2x+.025));
		lo2.setyCo(Double.valueOf(_2y+.025));
		lo2.setLabelName("B");
			
		CircleObject co3= new CircleObject();
		LabelObject lo3 = new LabelObject();
		double _3x = 3;
		double _3y = -6;
		co3.setxCo(Double.valueOf(_3x));
		co3.setyCo(Double.valueOf(_3y));
		lo3.setxCo(Double.valueOf(_3x+.025));
		lo3.setyCo(Double.valueOf(_3y+.025));
		lo3.setLabelName("C");
			
			
		LineObject ln1 = new LineObject();
		ln1.setX1(Double.valueOf(_1x));
		ln1.setX2(Double.valueOf(_2x));
		ln1.setY1(Double.valueOf(_1y));
		ln1.setY2(Double.valueOf(_2y));
			
		LineObject ln2 = new LineObject();
		ln2.setX1(Double.valueOf(_1x));
		ln2.setX2(Double.valueOf(_3x));
		ln2.setY1(Double.valueOf(_1y));
		ln2.setY2(Double.valueOf(_3y));
			
		LineObject ln3 = new LineObject();
		ln3.setX1(Double.valueOf(_2x));
		ln3.setX2(Double.valueOf(_3x));
		ln3.setY1(Double.valueOf(_2y));
		ln3.setY2(Double.valueOf(_3y));
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		geo.setLines(lineList);
			
		circleList.add(co1);
		circleList.add(co2);
		circleList.add(co3);
		geo.setCircles(circleList);	
			
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		geo.setLabels(labelList);
			
			
		question = "ABC is not what type of triangle (choose among- Acute, Right, Obtuse)?";
		q2 = "BC > AC > AB";
		q3 = "AB parallel to X axis and AC parallel to Y axis";
			
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add( new QuestionLine( q2, null, Constants.DEFAULT));
		questionList.add( new QuestionLine( q3, null, Constants.DEFAULT));
		
		String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
		answ.setAnswer("Obtuse");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	
}
