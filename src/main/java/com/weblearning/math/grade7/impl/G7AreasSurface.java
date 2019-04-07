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
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.grade8.impl.GR8_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7AreasSurface extends GenericQuestion{
	
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
				
		restMathClient = new RestMathClientServiceImpl();
		problemList = restMathClient.returnGraph(problemList);
	
		return problemList;
	}
	
	//draw a rectangle
	public Problem getProblem1(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		
		List<LineObject> lineList = new ArrayList<LineObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(0));
		l1.setY2(Double.valueOf(2));
		
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(3));
		l2.setY2(Double.valueOf(0));
		
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(0));
		l3.setY1(Double.valueOf(2));
		l3.setX2(Double.valueOf(3));
		l3.setY2(Double.valueOf(2));
		
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(3));
		l4.setY1(Double.valueOf(2));
		l4.setX2(Double.valueOf(3));
		l4.setY2(Double.valueOf(0));
		
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(3));
		l5.setY1(Double.valueOf(0));
		l5.setX2(Double.valueOf(7));
		l5.setY2(Double.valueOf(2));
		
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(3));
		l6.setY1(Double.valueOf(2));
		l6.setX2(Double.valueOf(7));
		l6.setY2(Double.valueOf(4));
		
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(7));
		l7.setY1(Double.valueOf(2));
		l7.setX2(Double.valueOf(7));
		l7.setY2(Double.valueOf(4));
		
		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(4));
		l8.setY1(Double.valueOf(4));
		l8.setX2(Double.valueOf(7));
		l8.setY2(Double.valueOf(4));
		
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(0));
		l9.setY1(Double.valueOf(2));
		l9.setX2(Double.valueOf(4));
		l9.setY2(Double.valueOf(4));
		
		lineList.add(l1);
		lineList.add(l2);
		lineList.add(l3);
		lineList.add(l4);
		lineList.add(l5);
		lineList.add(l6);
		lineList.add(l7);
		lineList.add(l8);
		lineList.add(l9);
		
		int h = MathUtilities.getRandomNumber(50, 100);
		LabelObject lo1 = new LabelObject();
		lo1.setLabelName("h= " + Integer.toString(h) + " cm");
		lo1.setxCo(.025);
		lo1.setyCo(1.0);
		
		int w = MathUtilities.getRandomNumber(1500, 250);
		LabelObject lo2 = new LabelObject();
		lo2.setLabelName("w= " + Integer.toString(w) + " mm");
		lo2.setxCo(1.5);
		lo2.setyCo(1.90);
		double width = (double)w/10;
		
		int l = MathUtilities.getRandomNumber(400, 500);
		LabelObject lo3 = new LabelObject();
		lo3.setLabelName("l= " + Integer.toString(l) + " cm");
		lo3.setxCo(5.0);
		lo3.setyCo(.2);
		
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		
		geo.setLines(lineList);
		geo.setLabels(labelList);
		
		double res = 2*(h*width + h*l + width*l);
		
		String result = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP).toString();
		
			
		question = "Find out the surface area of the picture above in cm square";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a trapozoid
	public Problem getProblem2(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		
		List<LineObject> lineList = new ArrayList<LineObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(4));
		l1.setY2(Double.valueOf(0));
		
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(2));
		l2.setY2(Double.valueOf(2));
		
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(2));
		l3.setY1(Double.valueOf(2));
		l3.setX2(Double.valueOf(4));
		l3.setY2(Double.valueOf(0));
		
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(2));
		l4.setY1(Double.valueOf(2));
		l4.setX2(Double.valueOf(7));
		l4.setY2(Double.valueOf(4));
		
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(4));
		l5.setY1(Double.valueOf(0));
		l5.setX2(Double.valueOf(9));
		l5.setY2(Double.valueOf(2));
		
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(7));
		l6.setY1(Double.valueOf(4));
		l6.setX2(Double.valueOf(9));
		l6.setY2(Double.valueOf(2));
		
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(0));
		l7.setY1(Double.valueOf(0));
		l7.setX2(Double.valueOf(6));
		l7.setY2(Double.valueOf(2));
		l7.setColor("grey");
		
		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(6));
		l8.setY1(Double.valueOf(2));
		l8.setX2(Double.valueOf(7));
		l8.setY2(Double.valueOf(4));
		l8.setColor("grey");
		
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(6));
		l9.setY1(Double.valueOf(2));
		l9.setX2(Double.valueOf(9));
		l9.setY2(Double.valueOf(2));
		l9.setColor("grey");
		
		LineObject l10 = new LineObject();
		l10.setX1(Double.valueOf(9));
		l10.setY1(Double.valueOf(2));
		l10.setX2(Double.valueOf(6));
		l10.setY2(Double.valueOf(2));
		l10.setColor("grey");
		
		LineObject l11 = new LineObject();
		l11.setX1(Double.valueOf(2));
		l11.setY1(Double.valueOf(2));
		l11.setX2(Double.valueOf(2));
		l11.setY2(Double.valueOf(0));
		l11.setColor("red");
		
		lineList.add(l1);
		lineList.add(l2);
		lineList.add(l3);
		lineList.add(l4);
		lineList.add(l5);
		lineList.add(l6);
		lineList.add(l7);
		lineList.add(l8);
		lineList.add(l9);
		lineList.add(l10);
		lineList.add(l11);
		
		geo.setLines(lineList);
		
		double l = MathUtilities.getRandomNumber(500, 600);
		LabelObject lo1 = new LabelObject();
		lo1.setLabelName("l= " + Double.toString(l) + " mm");
		lo1.setxCo(6.0);
		lo1.setyCo(0.0);
		double length = l/10;
		
		LabelObject lo2 = new LabelObject();
		lo2.setLabelName("h");
		lo2.setxCo(1.95);
		lo2.setyCo(1.0);
		
		labelList.add(lo1);
		labelList.add(lo2);
		
		geo.setLabels(labelList);
		
		double w = MathUtilities.getRandomNumber(30, 40) ;
		double h = MathUtilities.getRandomNumber(10, 15);
		
		double res = w*h + 3*w*length;
		BigDecimal result = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
			
		question = "The triangle is an equilateral triangle with one side: " + Double.toString(w) + " cm and h = " + Double.toString(h) + " cm. Find out the surface Area in cm square";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a trapozoid
	public Problem getProblem3(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		
		List<LineObject> lineList = new ArrayList<LineObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(3));
		l1.setY2(Double.valueOf(0));
		
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(0));
		l2.setY2(Double.valueOf(3));
		
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(3));
		l3.setY1(Double.valueOf(0));
		l3.setX2(Double.valueOf(0));
		l3.setY2(Double.valueOf(3));
		
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(3));
		l4.setY1(Double.valueOf(0));
		l4.setX2(Double.valueOf(8));
		l4.setY2(Double.valueOf(3));
		
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(0));
		l5.setY1(Double.valueOf(3));
		l5.setX2(Double.valueOf(5));
		l5.setY2(Double.valueOf(6));
		
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(5));
		l6.setY1(Double.valueOf(6));
		l6.setX2(Double.valueOf(8));
		l6.setY2(Double.valueOf(3));
		
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(0));
		l7.setY1(Double.valueOf(0));
		l7.setX2(Double.valueOf(5));
		l7.setY2(Double.valueOf(3));
		l7.setColor("grey");
		
		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(5));
		l8.setY1(Double.valueOf(6));
		l8.setX2(Double.valueOf(5));
		l8.setY2(Double.valueOf(3));
		l8.setColor("grey");
		
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(5));
		l9.setY1(Double.valueOf(3));
		l9.setX2(Double.valueOf(8));
		l9.setY2(Double.valueOf(3));
		l9.setColor("grey"); 
		
		lineList.add(l1);
		lineList.add(l2);
		lineList.add(l3);
		lineList.add(l4);
		lineList.add(l5);
		lineList.add(l6);
		lineList.add(l7);
		lineList.add(l8);
		lineList.add(l9);
		
		int l = MathUtilities.getRandomNumber(50, 75);
		LabelObject lo1 = new LabelObject();
		lo1.setxCo(5.0);
		lo1.setyCo(.25);
		lo1.setLabelName("l = " + Integer.toString(l));
		
		int w = MathUtilities.getRandomNumber(25, 30);
		LabelObject lo2 = new LabelObject();
		lo2.setxCo(1.9);
		lo2.setyCo(-.05);
		lo2.setLabelName("w = " + Integer.toString(w));
		
		labelList.add(lo1);
		labelList.add(lo2);
		
		BigDecimal h = new BigDecimal(Math.sqrt(w*w + w*w)).setScale(2, RoundingMode.HALF_UP);
		
		double result = w*w + 2* w*l + h.doubleValue()*l;
		
		geo.setLines(lineList);
		geo.setLabels(labelList);
		
		BigDecimal  rs = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
		
			
		question = "Find out the surface area of the above picture when the triangle is a Isosceles Right Triangle and the hypotenuse is " + h.toString();

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(rs.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a rombus
	public Problem getProblem4(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		
		List<LineObject> lineList = new ArrayList<LineObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(1));
		l1.setY2(Double.valueOf(2));
		
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(5));
		l2.setY2(Double.valueOf(0));
		
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(1));
		l3.setY1(Double.valueOf(2));
		l3.setX2(Double.valueOf(4));
		l3.setY2(Double.valueOf(2));
		
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(4));
		l4.setY1(Double.valueOf(2));
		l4.setX2(Double.valueOf(5));
		l4.setY2(Double.valueOf(0));
		
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(1));
		l5.setY1(Double.valueOf(2));
		l5.setX2(Double.valueOf(6));
		l5.setY2(Double.valueOf(5));
		
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(4));
		l6.setY1(Double.valueOf(2));
		l6.setX2(Double.valueOf(9));
		l6.setY2(Double.valueOf(5));
		
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(6));
		l7.setY1(Double.valueOf(5));
		l7.setX2(Double.valueOf(9));
		l7.setY2(Double.valueOf(5));

		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(9));
		l8.setY1(Double.valueOf(5));
		l8.setX2(Double.valueOf(10));
		l8.setY2(Double.valueOf(3));
		
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(5));
		l9.setY1(Double.valueOf(0));
		l9.setX2(Double.valueOf(10));
		l9.setY2(Double.valueOf(3));

		
		lineList.add(l1);
		lineList.add(l2);
		lineList.add(l3);
		lineList.add(l4);
		lineList.add(l5);
		lineList.add(l6);
		lineList.add(l7);
		lineList.add(l8);
		lineList.add(l9);
		
		LabelObject lo1 = new LabelObject();
		lo1.setLabelName("a");
		lo1.setxCo(2.0);
		lo1.setyCo(-.95);
		
		LabelObject lo2 = new LabelObject();
		lo2.setLabelName("b");
		lo2.setxCo(3.0);
		lo2.setyCo(2.1);
		
		LabelObject lo3 = new LabelObject();
		lo3.setLabelName("c");
		lo3.setxCo(5.0);
		lo3.setyCo(1.0);
		
		LabelObject lo4 = new LabelObject();
		lo4.setLabelName("d");
		lo4.setxCo(8.0);
		lo4.setyCo(1.0);
		
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		labelList.add(lo4);
		
		geo.setLines(lineList);
		geo.setLabels(labelList);
		
		double a = MathUtilities.getRandomNumber(20, 25);
		double b = MathUtilities.getRandomNumber(12, 15);
		double c = MathUtilities.getRandomNumber(8, 10);
		double d = MathUtilities.getRandomNumber(30, 50);
		double h = MathUtilities.getRandomNumber(2, 5);
		
		double result = ((a+b)/2)*h +  ((a+b)/2)*h + 2*c*d + b*d + a*d;
		BigDecimal res = new BigDecimal(result).setScale(2,  RoundingMode.HALF_UP);
		
			
		question = "Find out the surface area of the trapozoid where a= " + Double.toString(a) + ", b= " + Double.toString(b) + ", c= " 
				+ Double.toString(c) + ", d= " + Double.toString(d) + ", and height is " + Double.toString(h);

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(res.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		
		List<LineObject> lineList = new ArrayList<LineObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(-2));
		l1.setY2(Double.valueOf(2));
		
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(0));
		l2.setY2(Double.valueOf(3));
		
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(-2));
		l3.setY1(Double.valueOf(2));
		l3.setX2(Double.valueOf(-2));
		l3.setY2(Double.valueOf(5));
		
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(-2));
		l4.setY1(Double.valueOf(5));
		l4.setX2(Double.valueOf(0));
		l4.setY2(Double.valueOf(3));
		
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(-2));
		l5.setY1(Double.valueOf(5));
		l5.setX2(Double.valueOf(1));
		l5.setY2(Double.valueOf(5));
		
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(0));
		l6.setY1(Double.valueOf(3));
		l6.setX2(Double.valueOf(3));
		l6.setY2(Double.valueOf(3));
		
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(1));
		l7.setY1(Double.valueOf(5));
		l7.setX2(Double.valueOf(3));
		l7.setY2(Double.valueOf(3));

		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(1));
		l8.setY1(Double.valueOf(5));
		l8.setX2(Double.valueOf(5));
		l8.setY2(Double.valueOf(3));
		
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(3));
		l9.setY1(Double.valueOf(3));
		l9.setX2(Double.valueOf(7));
		l9.setY2(Double.valueOf(1));
		
		LineObject l10 = new LineObject();
		l10.setX1(Double.valueOf(5));
		l10.setY1(Double.valueOf(3));
		l10.setX2(Double.valueOf(7));
		l10.setY2(Double.valueOf(1));
		
		LineObject l11 = new LineObject();
		l11.setX1(Double.valueOf(0));
		l11.setY1(Double.valueOf(0));
		l11.setX2(Double.valueOf(7));
		l11.setY2(Double.valueOf(0));
		
		LineObject l12 = new LineObject();
		l12.setX1(Double.valueOf(7));
		l12.setY1(Double.valueOf(0));
		l12.setX2(Double.valueOf(7));
		l12.setY2(Double.valueOf(1));

		
		lineList.add(l1);
		lineList.add(l2);
		lineList.add(l3);
		lineList.add(l4);
		lineList.add(l5);
		lineList.add(l6);
		lineList.add(l7);
		lineList.add(l8);
		lineList.add(l9);
		lineList.add(l10);
		lineList.add(l11);
		lineList.add(l12);
		
		LabelObject lo1 = new LabelObject();
		lo1.setLabelName("a");
		lo1.setxCo(-1.0);
		lo1.setyCo(.75);
		
		LabelObject lo2 = new LabelObject();
		lo2.setLabelName("b");
		lo2.setxCo(-1.75);
		lo2.setyCo(3.0);
		
		LabelObject lo3 = new LabelObject();
		lo3.setLabelName("c");
		lo3.setxCo(.1);
		lo3.setyCo(1.75);
		
		LabelObject lo4 = new LabelObject();
		lo4.setLabelName("d");
		lo4.setxCo(-1.0);
		lo4.setyCo(3.9);
		
		LabelObject lo5 = new LabelObject();
		lo5.setLabelName("e");
		lo5.setxCo(1.95);
		lo5.setyCo(2.55);
		
		LabelObject lo6 = new LabelObject();
		lo6.setLabelName("f");
		lo6.setxCo(0.0);
		lo6.setyCo(5.1);
		
		LabelObject lo7 = new LabelObject();
		lo7.setLabelName("g");
		lo7.setxCo(2.0);
		lo7.setyCo(3.9);
		
		LabelObject lo8 = new LabelObject();
		lo8.setLabelName("h");
		lo8.setxCo(4.0);
		lo8.setyCo(2.5);
		
		LabelObject lo9 = new LabelObject();
		lo9.setLabelName("l");
		lo9.setxCo(4.0);
		lo9.setyCo(4.1);
		
		LabelObject lo10 = new LabelObject();
		lo10.setLabelName("i");
		lo10.setxCo(6.0);
		lo10.setyCo(2.1);
		
		LabelObject lo11 = new LabelObject();
		lo11.setLabelName("j");
		lo11.setxCo(3.0);
		lo11.setyCo(-.95);
		
		LabelObject lo12 = new LabelObject();
		lo12.setLabelName("k");
		lo12.setxCo(7.0);
		lo12.setyCo(.75);
		
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		labelList.add(lo4);
		labelList.add(lo5);
		labelList.add(lo6);
		labelList.add(lo7);
		labelList.add(lo8);
		labelList.add(lo9);
		labelList.add(lo10);
		labelList.add(lo11);
		labelList.add(lo12);
		
		geo.setLines(lineList);
		geo.setLabels(labelList);
		
		double a = MathUtilities.getRandomNumber(6, 10);
		double j = 2*a;
		double h = a*1.5;
		BigDecimal hg = new BigDecimal(h).setScale(2, RoundingMode.HALF_UP);
		question = "a= b= c= d= e= f= g= i= " + Double.toString(a) + " , j = twice of a" 
				+ " ,k = " + Integer.toString(2) + ", h= " + hg.toString()
				+ ". Find the surface area of the picture.";
		//
		double result = a*a + a*a +a*h+ 2*(((a+j)*(a-2)/2)) + 2*2*j+ 2*a + a*j;
		BigDecimal bg = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(bg.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a rombus
	public Problem getProblem6(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		
		List<LineObject> lineList = new ArrayList<LineObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(0));
		l1.setY2(Double.valueOf(3));
		
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(7));
		l2.setY2(Double.valueOf(0));
		
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(0));
		l3.setY1(Double.valueOf(3));
		l3.setX2(Double.valueOf(7));
		l3.setY2(Double.valueOf(3));
		
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(7));
		l4.setY1(Double.valueOf(0));
		l4.setX2(Double.valueOf(7));
		l4.setY2(Double.valueOf(3));
		
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(0));
		l5.setY1(Double.valueOf(3));
		l5.setX2(Double.valueOf(2));
		l5.setY2(Double.valueOf(5));
		
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(2));
		l6.setY1(Double.valueOf(5));
		l6.setX2(Double.valueOf(9));
		l6.setY2(Double.valueOf(5));
		
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(7));
		l7.setY1(Double.valueOf(3));
		l7.setX2(Double.valueOf(9));
		l7.setY2(Double.valueOf(5));
		
		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(7));
		l8.setY1(Double.valueOf(0));
		l8.setX2(Double.valueOf(9));
		l8.setY2(Double.valueOf(2));
		
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(9));
		l9.setY1(Double.valueOf(2));
		l9.setX2(Double.valueOf(9));
		l9.setY2(Double.valueOf(5));
		
		lineList.add(l1);
		lineList.add(l2);
		lineList.add(l3);
		lineList.add(l4);
		lineList.add(l5);
		lineList.add(l6);
		lineList.add(l7);
		lineList.add(l8);
		lineList.add(l9);
		
		double w = MathUtilities.getRoundedAnswer(2, 10);
		
		double l = 2* w;
		LabelObject lo3 = new LabelObject();
		lo3.setLabelName("l= " + Double.toString(l) + " cm");
		lo3.setxCo(5.0);
		lo3.setyCo(.2);

		labelList.add(lo3);
		
		geo.setLines(lineList);
		geo.setLabels(labelList);
		
		double area = w*w;
		double result = 2*w*w + 2*l*w + 2*l*w;		
		
		BigDecimal bg = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
		
			
		question = "The area of the smallest side is " + Double.toString(area) + "cm square and is a square. Find out the total surface area of the prism.";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(bg.toString());

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
		
		List<LineObject> lineList = new ArrayList<LineObject>();
		
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(0));
		l1.setY2(Double.valueOf(3));
		
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(7));
		l2.setY2(Double.valueOf(0));
		
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(0));
		l3.setY1(Double.valueOf(3));
		l3.setX2(Double.valueOf(7));
		l3.setY2(Double.valueOf(3));
		
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(7));
		l4.setY1(Double.valueOf(0));
		l4.setX2(Double.valueOf(7));
		l4.setY2(Double.valueOf(3));
		
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(0));
		l5.setY1(Double.valueOf(3));
		l5.setX2(Double.valueOf(2));
		l5.setY2(Double.valueOf(5));
		
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(2));
		l6.setY1(Double.valueOf(5));
		l6.setX2(Double.valueOf(9));
		l6.setY2(Double.valueOf(5));
		
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(7));
		l7.setY1(Double.valueOf(3));
		l7.setX2(Double.valueOf(9));
		l7.setY2(Double.valueOf(5));
		
		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(7));
		l8.setY1(Double.valueOf(0));
		l8.setX2(Double.valueOf(9));
		l8.setY2(Double.valueOf(2));
		
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(9));
		l9.setY1(Double.valueOf(2));
		l9.setX2(Double.valueOf(9));
		l9.setY2(Double.valueOf(5));
		
		lineList.add(l1);
		lineList.add(l2);
		lineList.add(l3);
		lineList.add(l4);
		lineList.add(l5);
		lineList.add(l6);
		lineList.add(l7);
		lineList.add(l8);
		lineList.add(l9);
		
		double w = MathUtilities.getRoundedAnswer(2, 10);
		
		double l = 2* w;
		LabelObject lo3 = new LabelObject();
		lo3.setLabelName("l= " + Double.toString(l) + " cm");
		lo3.setxCo(5.0);
		lo3.setyCo(.2);
		
		geo.setLines(lineList);
		
		String a1 = Integer.toString(6);
		String a2 = Integer.toString(8);
		String a3 = Integer.toString(12);
			
		question = "Look at the above picture and answer the following" ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "Number of the surfaces:"+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Number of vertices :"+ GR8_Constants.ANSWER_TO_QUESTION + a2,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Number of edges :"+ GR8_Constants.ANSWER_TO_QUESTION + a3,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("");

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
			
		List<LineObject> lineList = new ArrayList<LineObject>();
			
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(3));
		l1.setY2(Double.valueOf(-2));
			
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(0));
		l2.setY2(Double.valueOf(6));
			
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(3));
		l3.setY1(Double.valueOf(-2));
		l3.setX2(Double.valueOf(3));
		l3.setY2(Double.valueOf(3));
			
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(3));
		l4.setY1(Double.valueOf(-2));
		l4.setX2(Double.valueOf(4));
		l4.setY2(Double.valueOf(0));
			
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(4));
		l5.setY1(Double.valueOf(0));
		l5.setX2(Double.valueOf(4));
		l5.setY2(Double.valueOf(6));
			
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(0));
		l6.setY1(Double.valueOf(6));
		l6.setX2(Double.valueOf(3));
		l6.setY2(Double.valueOf(3));
			
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(0));
		l7.setY1(Double.valueOf(6));
		l7.setX2(Double.valueOf(4));
		l7.setY2(Double.valueOf(6));
		
		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(3));
		l8.setY1(Double.valueOf(3));
		l8.setX2(Double.valueOf(4));
		l8.setY2(Double.valueOf(6));
			
		lineList.add(l1);
		lineList.add(l2);
		lineList.add(l3);
		lineList.add(l4);
		lineList.add(l5);
		lineList.add(l6);
		lineList.add(l7);
		lineList.add(l8);
			
		geo.setLines(lineList);
			
		String a1 = Integer.toString(5);
		String a2 = Integer.toString(6);
		String a3 = Integer.toString(9);
				
		question = "Look at the above picture and answer the following" ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "Number of the surfaces:"+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Number of vertices :"+ GR8_Constants.ANSWER_TO_QUESTION + a2,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Number of edges :"+ GR8_Constants.ANSWER_TO_QUESTION + a3,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
				
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("");

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
				
		GeometryObject geo = new GeometryObject();
			
		List<LineObject> lineList = new ArrayList<LineObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>(); 
			
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(0));
		l1.setY2(Double.valueOf(10));
			
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(1.95));
		l2.setY2(Double.valueOf(-5.0));
			
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(1.95));
		l3.setY1(Double.valueOf(-5));
		l3.setX2(Double.valueOf(1.95));
		l3.setY2(Double.valueOf(5));
			
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(1.95));
		l4.setY1(Double.valueOf(5));
		l4.setX2(Double.valueOf(0));
		l4.setY2(Double.valueOf(10));
			
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(1.95));
		l5.setY1(Double.valueOf(-5));
		l5.setX2(Double.valueOf(6.95));
		l5.setY2(Double.valueOf(-5));
			
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(6.95));
		l6.setY1(Double.valueOf(-5));
		l6.setX2(Double.valueOf(6.95));
		l6.setY2(Double.valueOf(5));
			
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(6.95));
		l7.setY1(Double.valueOf(-5));
		l7.setX2(Double.valueOf(8));
		l7.setY2(Double.valueOf(0));
		
		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(8));
		l8.setY1(Double.valueOf(0));
		l8.setX2(Double.valueOf(8));
		l8.setY2(Double.valueOf(10));
		
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(1.95));
		l9.setY1(Double.valueOf(5));
		l9.setX2(Double.valueOf(6.95));
		l9.setY2(Double.valueOf(5));
		
		LineObject l10 = new LineObject();
		l10.setX1(Double.valueOf(6.95));
		l10.setY1(Double.valueOf(5));
		l10.setX2(Double.valueOf(8));
		l10.setY2(Double.valueOf(10));
		
		LineObject l11 = new LineObject();
		l11.setX1(Double.valueOf(0));
		l11.setY1(Double.valueOf(10));
		l11.setX2(Double.valueOf(4));
		l11.setY2(Double.valueOf(13));
		
		LineObject l12 = new LineObject();
		l12.setX1(Double.valueOf(4));
		l12.setY1(Double.valueOf(13));
		l12.setX2(Double.valueOf(8));
		l12.setY2(Double.valueOf(10));
		
		LineObject l13 = new LineObject();
		l13.setX1(Double.valueOf(4.2));
		l13.setY1(Double.valueOf(5));
		l13.setX2(Double.valueOf(4.2));
		l13.setY2(Double.valueOf(8.75));
			
		lineList.add(l1);
		lineList.add(l2);
		lineList.add(l3);
		lineList.add(l4);
		lineList.add(l5);
		lineList.add(l6);
		lineList.add(l7);
		lineList.add(l8);
		lineList.add(l9);
		lineList.add(l10);
		lineList.add(l11);
		lineList.add(l12);
		lineList.add(l13);
		
		double base = MathUtilities.getRandomNumber(2, 10);
		double height = base * 2.5;
		double apothem = base * 1.1;
		
		LabelObject lo1 = new LabelObject();
		lo1.setLabelName(new BigDecimal(base).setScale(2, RoundingMode.HALF_UP).toString());
		lo1.setxCo(4.0);
		lo1.setyCo(-4.95);
		
		LabelObject lo2 = new LabelObject();
		lo2.setLabelName(new BigDecimal(height).setScale(2, RoundingMode.HALF_UP).toString());
		lo2.setxCo(2.0);
		lo2.setyCo(0.0);
		
		LabelObject lo3 = new LabelObject();
		BigDecimal log = new BigDecimal(apothem).setScale(2, RoundingMode.HALF_UP);
		lo3.setLabelName(new BigDecimal(apothem).setScale(2, RoundingMode.HALF_UP).toString());
		lo3.setxCo(4.3);
		lo3.setyCo(6.0);
		
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
			
		geo.setLines(lineList);
		geo.setLabels(labelList);
		
		String a1 = Integer.toString(7);
		String a2 = Integer.toString(10);
		String a3 = Integer.toString(15);
		BigDecimal a4 = new BigDecimal(5*apothem*base + 5*base*height).setScale(2, RoundingMode.HALF_UP);
				
		question = "The Apothem of the pentagonal prism is " + log.toString() + ". Answer the following:";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "Number of the surfaces:"+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Number of vertices :"+ GR8_Constants.ANSWER_TO_QUESTION + a2,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Number of edges :"+ GR8_Constants.ANSWER_TO_QUESTION + a3,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Surface area of the Pentagonal Prism :"+ GR8_Constants.ANSWER_TO_QUESTION + a4.toString(),  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
				
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);
		return problem;
	}
	
			
}
