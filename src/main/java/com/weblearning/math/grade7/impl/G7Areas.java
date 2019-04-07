package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.utility.geometry.GeometryObject;
import com.weblearning.domain.utility.geometry.LabelObject;
import com.weblearning.domain.utility.geometry.LineObject;
import com.weblearning.domain.utility.geometry.PatchObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7Areas extends GenericQuestion{
	
	//@Autowired
	//private ResourceLoader resourceLoader;
	
	@Autowired
	private RestMathClientService restMathClient;

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		

		List<Problem> problemList = new ArrayList<Problem>();
		
		problemList.add(getProblem1(mathConfig));
		problemList.add(getProblem2(mathConfig));
		problemList.add(getProblem3(mathConfig));
		problemList.add(getProblem4(mathConfig));
		problemList.add(getProblem5(mathConfig));
		problemList.add(getProblem6(mathConfig));
		problemList.add(getProblem7(mathConfig));
		problemList.add(getProblem8(mathConfig));
		problemList.add(getProblem9(mathConfig));
		problemList.add(getProblem10(mathConfig));
		problemList.add(getProblem11(mathConfig));
		problemList.add(getProblem12(mathConfig));
		problemList.add(getProblem13(mathConfig));
		problemList.add(getProblem12(mathConfig));
		problemList.add(getProblem13(mathConfig));
				
		restMathClient = new RestMathClientServiceImpl();
		problemList = restMathClient.returnGraph(problemList);
	
		return problemList;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//find the base
		int _1b = MathUtilities.getRandomNumber(5, 15);
		int _1h = MathUtilities.getRandomNumber(5, 10);
		BigDecimal _1a = new BigDecimal((double)_1b*_1h/2).setScale(2, RoundingMode.HALF_UP);
		
		question1 = "The base of a triangle is " + Integer.toString(_1b) + " meter, and the height is " + Integer.toString(_1h) 
			+ "meter. What is the area of the triangle in meter square?" ;
		answer1 = _1a.toString(); 
		
		//find the power
		int _2b = MathUtilities.getRandomNumber(5, 15);
		int _2h = MathUtilities.getRandomNumber(5, 10);
		BigDecimal _2a = new BigDecimal((double)_2b*_2h/2).setScale(2, RoundingMode.HALF_UP);
		
		question2 = "The base of a triangle is " + Integer.toString(_2b) + " cm, and the height is " + Integer.toString(_2h) 
			+ " cm. What is the area of the triangle in cm square?" ;
		answer2 = _2a.toString();
		
		//find the power
		int _3b = MathUtilities.getRandomNumber(5, 15);
		int _3h = MathUtilities.getRandomNumber(250, 1000);
		BigDecimal _3a = new BigDecimal((double)_3b*_3h/(2*100)).setScale(2, RoundingMode.HALF_UP);
		
		question3 = "The base of a triangle is " + Integer.toString(_3b) + " meter, and the height is " + Integer.toString(_3h) 
			+ " cm. What is the area of the triangle in meter square?" ;
		answer3 = _3a.toString();
		
		//find the power
		int _4b = MathUtilities.getRandomNumber(500, 2500);
		int _4h = MathUtilities.getRandomNumber(250, 500);
		
		double _4bMeter = (double)_4b/100;
		double _4hMeter = (double)_4h/1000;
		
		BigDecimal _4a = new BigDecimal((double)_4bMeter*_4hMeter/2).setScale(2, RoundingMode.HALF_UP);
		
		question4 = "The base of a triangle is " + Integer.toString(_4b) + " cm, and the height is " + Integer.toString(_4h) 
			+ " mm. What is the area of the triangle in meter square?" ;
		answer4 = _4a.toString();

		//find the power
		int _5b = MathUtilities.getRandomNumber(10, 15);
		int _5h = MathUtilities.getRandomNumber(5, 8);
		
		BigDecimal _5a = new BigDecimal((double)_5b*_5h*100*100/2).setScale(2, RoundingMode.HALF_UP);
		
		question5 = "The base of a triangle is " + Integer.toString(_5b) + " meter, and the height is " + Integer.toString(_5h) 
			+ " meter. What is the area of the triangle in cm square?" ;
		answer5 = _5a.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//find the base
		int _1b = MathUtilities.getRandomNumber(5, 15);
		int _1h = MathUtilities.getRandomNumber(5, 10);
		BigDecimal _1a = new BigDecimal((double)_1b*_1h/2).setScale(2, RoundingMode.HALF_UP);
		
		question1 = "The base of a triangle is " + Integer.toString(_1b) + " meter, and the area is " + _1a.toString()
			+ "meter square. What is the height of the triangle in meter?" ;
		answer1 = Integer.toString(_1h);
		
		//find the power
		int _2b = MathUtilities.getRandomNumber(5, 15);
		int _2h = MathUtilities.getRandomNumber(5, 10);
		BigDecimal _2a = new BigDecimal((double)_2b*_2h/2).setScale(2, RoundingMode.HALF_UP);
		
		question2 = "The base of a triangle is " + Integer.toString(_2b) + " cm, and the area is " + _2a.toString() 
			+ " square cm. What is the height of the triangle in cm?" ;
		answer2 = Integer.toString(_2h);
		
		//find the power
		int _3b = MathUtilities.getRandomNumber(5, 15);
		int _3h = MathUtilities.getRandomNumber(3, 8);
		BigDecimal _3a = new BigDecimal((double)_3b*_3h/2).setScale(2, RoundingMode.HALF_UP);
		
		int _3bCM = _3b*100;
		
		question3 = "The base of a triangle is " + Integer.toString(_3bCM) + " cm, and the area is " + _3a.toString() 
			+ " square meter. What is the height of the triangle in meter?" ;
		answer3 = Integer.toString(_3h);
		
		//find the power
		int _4b = MathUtilities.getRandomNumber(500, 1000);
		int _4h = MathUtilities.getRandomNumber(250, 500);
		
		double _4bMeter = (double) _4b/100;
		BigDecimal _4bg = new BigDecimal(_4bMeter).setScale(2, RoundingMode.HALF_UP);
		
		BigDecimal _4a = new BigDecimal((double)_4b*_4h/2).setScale(2, RoundingMode.HALF_UP);
		
		question4 = "The base of a triangle is " + _4bg.toString() + " meter, and the area is " + _4a.toString() 
			+ " cm square. What is the height of the triangle in cm ?" ;
		answer4 = Integer.toString(_4h);

		//find the power
		int _5b = MathUtilities.getRandomNumber(500, 1000); //mm
		int _5h = MathUtilities.getRandomNumber(250, 500);  //mm
		
		BigDecimal _5bM = new BigDecimal((double)_5b/1000).setScale(3, RoundingMode.HALF_UP);
		
		BigDecimal _5aM = new BigDecimal((double)_5b*_5h/(2*10*10)).setScale(3, RoundingMode.HALF_UP);
		
		question5 = "The base of a triangle is " + _5bM.toString() + " meter, and the area is " + _5aM.toString() 
			+ " cm square. What is the height of the triangle in mm ?" ;
		answer5 = Integer.toString(_5h);
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="";
		String answer1="", answer2="", answer3="";
		
		//find the base
		int _1b = MathUtilities.getRandomNumber(5, 15);
		int _1h = MathUtilities.getRandomNumber(5, 10);
		BigDecimal _1a = new BigDecimal((double)_1b*_1h/2).setScale(2, RoundingMode.HALF_UP);
		
		question1 = "The height of a triangle is " + Integer.toString(_1h) + " meter, and the area is " + _1a.toString()
			+ "meter square. What is the base of the triangle in meter?" ;
		answer1 = Integer.toString(_1b);
		
		//find the power
		int _2b = MathUtilities.getRandomNumber(5, 15);
		int _2h = MathUtilities.getRandomNumber(5, 10);
		BigDecimal _2a = new BigDecimal((double)_2b*_2h/2).setScale(2, RoundingMode.HALF_UP);
		
		question2 = "The height of a triangle is " + Integer.toString(_2h) + " cm, and the area is " + _2a.toString() 
			+ " square cm. What is the base of the triangle in cm?" ;
		answer2 = Integer.toString(_2b);
		
		//find the power
		int _3b = MathUtilities.getRandomNumber(5, 15);
		int _3h = MathUtilities.getRandomNumber(3, 8);
		BigDecimal _3a = new BigDecimal((double)_3b*_3h/2).setScale(2, RoundingMode.HALF_UP);
		
		int _3hCM = _3h*100;
		
		question3 = "The height of a triangle is " + Integer.toString(_3hCM) + " cm, and the area is " + _3a.toString() 
			+ " square meter. What is the height of the base in meter?" ;
		answer3 = Integer.toString(_3b);
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	
	//draw a triangle
	public Problem getProblem4(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		
		PatchObject po = new PatchObject();
		List<String> xcos = new ArrayList<String>();
		xcos.add("1");
		xcos.add("4");
		xcos.add("4");
		
		List<String> ycos = new ArrayList<String>();
		ycos.add("1");
		ycos.add("1");
		ycos.add("3");
		
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
		
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		
		l1.setxCo(1.0);
		l1.setyCo(1.1);
		l1.setLabelName("A");
		
		l2.setxCo(4.05);
		l2.setyCo(1.0);
		l2.setLabelName("B");
		
		l3.setxCo(4.0);
		l3.setyCo(3.05);
		l3.setLabelName("C");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		
		geo.setPatches(patches);
		geo.setLabels(labelList);
		
		int ab = MathUtilities.getRandomNumber(10, 20);
		int bc = MathUtilities.getRandomNumber(5, 9);
		
		BigDecimal result = new BigDecimal(((double)ab*bc)/2).setScale(2, RoundingMode.HALF_UP);
		
			
		question = "ABC is a right triangle. AB is the base and AC is the hypotenuse. AB is " + Integer.toString(ab) + "cm and BC is " 
				+ Integer.toString(bc) + "cm. What is the area of triangle ABC in terms of cm?";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem5(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
				
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
				
		GeometryObject geo = new GeometryObject();
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
			
		PatchObject po = new PatchObject();
		List<String> xcos = new ArrayList<String>();
		xcos.add("1");
		xcos.add("-3");
		xcos.add("1");
			
		List<String> ycos = new ArrayList<String>();
		ycos.add("1");
		ycos.add("1");
		ycos.add("3");
			
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
			
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
			
		l1.setxCo(1.0);
		l1.setyCo(1.1);
		l1.setLabelName("A");
			
		l2.setxCo(-2.75);
		l2.setyCo(1.0);
		l2.setLabelName("B");
			
		l3.setxCo(1.0);
		l3.setyCo(3.01);
		l3.setLabelName("C");
			
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
			
		geo.setPatches(patches);
		geo.setLabels(labelList);
			
		int ab = MathUtilities.getRandomNumber(10, 20);
		int bc = MathUtilities.getRandomNumber(50, 90);
			
		BigDecimal result = new BigDecimal(((double)ab*bc)/(2*10)).setScale(2, RoundingMode.HALF_UP);
			
				
		question = "ABC is a right triangle. AB is the base and AC is the perpendicular to AB. AB is " + Integer.toString(ab) + "cm and AC is " 
				+ Integer.toString(bc) + "mm. What is the area of triangle ABC in terms of cm?";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

					
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem6(MathConfiguration mathConfig) {
					
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
		PatchObject po = new PatchObject();
		List<String> xcos = new ArrayList<String>();
		xcos.add("-3");
		xcos.add("1");
		xcos.add("3");
				
		List<String> ycos = new ArrayList<String>();
		ycos.add("1");
		ycos.add("1");
		ycos.add("3");
				
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
				
		l1.setxCo(-3.0);
		l1.setyCo(1.1);
		l1.setLabelName("A");
				
		l2.setxCo(1.0);
		l2.setyCo(1.1);
		l2.setLabelName("B");
			
		l3.setxCo(3.0);
		l3.setyCo(3.01);
		l3.setLabelName("C");
		
		l4.setxCo(2.95);
		l4.setyCo(1.01);
		l4.setLabelName("D");
				
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(3.0);
		ln1.setX2(3.0);
		ln1.setY1(3.0);
		ln1.setY2(1.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(3.0);
		ln2.setX2(1.0);
		ln2.setY1(1.0);
		ln2.setY2(1.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
				
		geo.setPatches(patches);
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
		int ab = MathUtilities.getRandomNumber(10, 20);
		int bc = MathUtilities.getRandomNumber(50, 90);
				
		BigDecimal result = new BigDecimal(((double)ab*bc)/(2*10*10)).setScale(2, RoundingMode.HALF_UP);
				
					
		question = "AB is the base of triangle ABC. Length of AB is: " + Integer.toString(ab) + "mm. CD is perpendicular to the base. " 
				+ "Length of CD is: " + Integer.toString(bc) + "mm. What is the area of triangle ABC in terms of cm?";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
		
	//draw a triangle
	public Problem getProblem7(MathConfiguration mathConfig) {
						
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
		MessageSource mSource = mathConfig.getmSource();
						
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
						
		GeometryObject geo = new GeometryObject();
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
					
		PatchObject po = new PatchObject();
		List<String> xcos = new ArrayList<String>();
		xcos.add("-2");
		xcos.add("2");
		xcos.add("0");
					
		List<String> ycos = new ArrayList<String>();
		ycos.add("0");
		ycos.add("0");
		ycos.add("3");
					
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
					
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
					
		l1.setxCo(0.0);
		l1.setyCo(3.01);
		l1.setLabelName("A");
					
		l2.setxCo(-2.0);
		l2.setyCo(0.05);
		l2.setLabelName("B");
				
		l3.setxCo(2.0);
		l3.setyCo(0.05);
		l3.setLabelName("C");
			
		l4.setxCo(0.01);
		l4.setyCo(0.01);
		l4.setLabelName("D");
					
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
			
		geo.setPatches(patches);
		geo.setLabels(labelList);
					
		int bc = MathUtilities.getRandomNumber(500, 1000);
		int ad = MathUtilities.getRandomNumber(300, 400);
				
		BigDecimal result = new BigDecimal(((double)bc*ad)/(2*100)).setScale(2, RoundingMode.HALF_UP);
					
						
		question = "BC is the base of triangle ABC. Length of BC is: " + Integer.toString(bc) + "mm. AD is the height of triangle ABC. " 
				+ "Length of AD is: " + Integer.toString(ad) + "mm. What is the area of triangle ABC in terms of cm?";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

							
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	

	//draw a triangle
	public Problem getProblem8(MathConfiguration mathConfig) {
					
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
		PatchObject po = new PatchObject();
		List<String> xcos = new ArrayList<String>();
		xcos.add("-3");
		xcos.add("1");
		xcos.add("-5");
				
		List<String> ycos = new ArrayList<String>();
		ycos.add("1");
		ycos.add("1");
		ycos.add("4");
				
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
				
		l1.setxCo(-3.0);
		l1.setyCo(1.01);
		l1.setLabelName("A");
				
		l2.setxCo(1.0);
		l2.setyCo(1.01);
		l2.setLabelName("B");
			
		l3.setxCo(-5.0);
		l3.setyCo(4.01);
		l3.setLabelName("C");
		
		l4.setxCo(-5.0);
		l4.setyCo(.975);
		l4.setLabelName("D");
				
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-3.0);
		ln1.setX2(-5.0);
		ln1.setY1(1.0);
		ln1.setY2(1.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-5.0);
		ln2.setX2(-5.0);
		ln2.setY1(4.0);
		ln2.setY2(1.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
				
		geo.setPatches(patches);
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
		int ab = MathUtilities.getRandomNumber(10, 20);
		int bc = MathUtilities.getRandomNumber(50, 90);
				
		BigDecimal result = new BigDecimal(((double)ab*bc*100)/(2)).setScale(2, RoundingMode.HALF_UP);
				
					
		question = "AB is the base of triangle ABC. Length of AB is: " + Integer.toString(ab) + "cm. CD is the height. " 
				+ "Length of CD is: " + Integer.toString(bc) + "cm. What is the area of triangle ABC in terms of mm?";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem9(MathConfiguration mathConfig) {
						
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
		MessageSource mSource = mathConfig.getmSource();
						
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
						
							
		int ab = 3* MathUtilities.getRandomNumber(25, 40);
		int h = MathUtilities.getRandomNumber(10, 15);
	
					
		BigDecimal result = new BigDecimal(((double)ab*h/3)/2).setScale(2, RoundingMode.HALF_UP);
					
						
		question = "ABC is an Equilateral Triangle and the perimeter of ABC is: " + Integer.toString(ab) + "cm. Its height is " 
				+ Integer.toString(h) + "cm. What is the area of triangle ABC in terms of cm?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

							
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	//draw a triangle
	public Problem getProblem10(MathConfiguration mathConfig) {
						
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
		MessageSource mSource = mathConfig.getmSource();
						
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";			
							
		int h = MathUtilities.getRandomNumber(10, 15);
		
		BigDecimal result = new BigDecimal((double)h*h/2).setScale(2, RoundingMode.HALF_UP);
					
						
		question = "ABC is an Isosceles Right Triangle and one of the two equal sides is: " + Integer.toString(h) + "cm." 
				+ "What is the area of triangle ABC in terms of cm?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

							
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem11(MathConfiguration mathConfig) {
						
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
		MessageSource mSource = mathConfig.getmSource();
						
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="", question1="", question2="";
						
							
		int b = MathUtilities.getRandomNumber(25, 40);
		int h = MathUtilities.getRandomNumber(10, 15);
						
		BigDecimal area = new BigDecimal(((double)b*h)/2).setScale(2, RoundingMode.HALF_UP);
											
		question = "Find out the height of Triangle ABC";
		question1= "Area = $" + area.toString() + "cm^{2} $";
		question2 = "base = " + Integer.toString(b) + " cm";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add( new QuestionLine( question1, null, Constants.DEFAULT));
		questionList.add( new QuestionLine( question2, null, Constants.DEFAULT));
							
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(h));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem12(MathConfiguration mathConfig) {
						
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
						
		GeometryObject geo = new GeometryObject();
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
					
		PatchObject po = new PatchObject();
		List<String> xcos = new ArrayList<String>();
		xcos.add("-3");
		xcos.add("1");
		xcos.add("3");
					
		List<String> ycos = new ArrayList<String>();
		ycos.add("1");
		ycos.add("1");
		ycos.add("3");
					
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
					
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
					
		l1.setxCo(-3.0);
		l1.setyCo(1.1);
		l1.setLabelName("A");
					
		l2.setxCo(1.0);
		l2.setyCo(1.1);
		l2.setLabelName("B");
			
		l3.setxCo(3.0);
		l3.setyCo(3.01);
		l3.setLabelName("C");
			
		l4.setxCo(2.95);
		l4.setyCo(1.01);
		l4.setLabelName("D");
				
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
			
		LineObject ln1 = new LineObject();
		ln1.setX1(3.0);
		ln1.setX2(3.0);
		ln1.setY1(3.0);
		ln1.setY2(1.0);
			
		LineObject ln2 = new LineObject();
		ln2.setX1(3.0);
		ln2.setX2(1.0);
		ln2.setY1(1.0);
		ln2.setY2(1.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
				
		geo.setPatches(patches);
		geo.setLabels(labelList);
		geo.setLines(lineList);
		
		int rnd = MathUtilities.getRandomNumber(5, 10);		
		int ad = 6* rnd;
		int bc = MathUtilities.getRandomNumber(50, 90);
		int bd = 2* rnd;
					
		BigDecimal result = new BigDecimal(((double)(ad-bd)*bc)/(2*10*10)).setScale(2, RoundingMode.HALF_UP);
					
						
		question = "AB is the base of triangle ABC. Length of AD is: " + Integer.toString(ad) + "mm and BD is." + Integer.toString(bd) + " mm. CD is perpendicular to the base. " 
					+ "Length of CD is: " + Integer.toString(bc) + "mm. What is the area of triangle ABC in terms of cm?";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

							
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem13(MathConfiguration mathConfig) {
							
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
						
		MessageSource mSource = mathConfig.getmSource();
						
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
							
		GeometryObject geo = new GeometryObject();
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
						
		PatchObject po = new PatchObject();
		List<String> xcos = new ArrayList<String>();
		xcos.add("-3");
		xcos.add("0");
		xcos.add("3");
						
		List<String> ycos = new ArrayList<String>();
		ycos.add("1");
		ycos.add("1");
		ycos.add("3");
						
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
						
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
						
		l1.setxCo(-3.0);
		l1.setyCo(1.1);
		l1.setLabelName("A");
						
		l2.setxCo(0.0);
		l2.setyCo(1.1);
		l2.setLabelName("B");
				
		l3.setxCo(3.0);
		l3.setyCo(3.01);
		l3.setLabelName("C");
				
		l4.setxCo(2.95);
		l4.setyCo(1.01);
		l4.setLabelName("D");
					
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
				
		LineObject ln1 = new LineObject();
		ln1.setX1(3.0);
		ln1.setX2(3.0);
		ln1.setY1(3.0);
		ln1.setY2(1.0);
				
		LineObject ln2 = new LineObject();
		ln2.setX1(3.0);
		ln2.setX2(0.0);
		ln2.setY1(1.0);
		ln2.setY2(1.0);
			
		lineList.add(ln1);
		lineList.add(ln2);
					
		geo.setPatches(patches);
		geo.setLabels(labelList);
		geo.setLines(lineList);
			
		int rnd = MathUtilities.getRandomNumber(5, 10);		
		int ad = 6* rnd;
		int bc = MathUtilities.getRandomNumber(50, 90);
		int bd = 3* rnd;
						
		BigDecimal result = new BigDecimal(((double)(ad-bd)*bc)/(2*10*10)).setScale(2, RoundingMode.HALF_UP);
						
							
		question = "AB is the base of triangle ABC. Length of AD is: " + Integer.toString(ad) + "mm and B is the mid point. CD is perpendicular to the base. " 
					+ "Length of CD is: " + Integer.toString(bc) + "mm. What is the area of triangle CDB in terms of cm?";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

								
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
/*	
	//draw a triangle
	public Problem getProblem12(MathConfiguration mathConfig) {
							
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
						
		MessageSource mSource = mathConfig.getmSource();
							
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";							
								
		int b = MathUtilities.getRandomNumber(10, 30);
		int p = 4*b;
							
		BigDecimal area = new BigDecimal(((double)b*b)/100).setScale(2, RoundingMode.HALF_UP);
												
		question = "The perimtere of a square is: " + Integer.toString(p) + "mm. What would be its area in cm?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
								
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(area.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem13(MathConfiguration mathConfig) {
								
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
							
		MessageSource mSource = mathConfig.getmSource();
								
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";							
									
		int a = MathUtilities.getRandomNumber(10, 15);
		int b = MathUtilities.getRandomNumber(20, 30);
								
		BigDecimal area = new BigDecimal(a*b).setScale(2, RoundingMode.HALF_UP);
												
		question = "The area of rectangle is: " + area.toString() + "meter and one of the side is: " + Integer.toString(a) + " meter. "
				+ "What is the length of other side?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
									
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(b));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}

	//draw a triangle
	public Problem getProblem14(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		List <PatchObject> patches = new ArrayList<PatchObject>();
		
		PatchObject po = new PatchObject();
		List<String> xcos = new ArrayList<String>();
		xcos.add("1");
		xcos.add("2");
		xcos.add("4");
		xcos.add("3");
		
		List<String> ycos = new ArrayList<String>();
		ycos.add("0");
		ycos.add("2");
		ycos.add("2");
		ycos.add("0");
		
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
		
		geo.setPatches(patches);
		
		String a1 = "Parallel";
		String a2 = "Traversal";
		String a3 = "Corresponding";
		String a4 = "Interior";
		String a5 = "Exterior";
			
		question = "See the picture and answer the following:" ;
			
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

		questionList.add(new QuestionLine( "AB and CD are:"+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Line EF is called"+ GR8_Constants.ANSWER_TO_QUESTION + a2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle AGE and Angle CHG are called ____ Angles:"+ GR8_Constants.ANSWER_TO_QUESTION + a3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle AGH and Angle GHD are called Alternate ____ Angles:"+ GR8_Constants.ANSWER_TO_QUESTION + a4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle CHF and Angle EGB are called Alternate ____ Angles:"+ GR8_Constants.ANSWER_TO_QUESTION + a5  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
		String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	*/
		
}
