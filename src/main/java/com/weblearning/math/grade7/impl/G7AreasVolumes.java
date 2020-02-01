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

public class G7AreasVolumes extends GenericQuestion{
	
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
		problemList.add(getProblem14(mathConfig)); 
		problemList.add(getProblem15(mathConfig));
		problemList.add(getProblem16(mathConfig));
		problemList.add(getProblem17(mathConfig));
		problemList.add(getProblem18(mathConfig));
		problemList.add(getProblem19(mathConfig)); 
		problemList.add(getProblem20(mathConfig)); 
				
		restMathClient = new RestMathClientServiceImpl();
		problemList = restMathClient.returnGraph(problemList);
	
		return problemList;
	}
	
	//draw a rectangle
	public Problem getProblem1(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
	//	MessageSource mSource = mathConfig.getmSource();
			
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
		
		int h = 10;
		LabelObject lo1 = new LabelObject();
		lo1.setLabelName("h= " + Integer.toString(h) + " cm");
		lo1.setxCo(.025);
		lo1.setyCo(1.0);
		
		int w = 5;
		LabelObject lo2 = new LabelObject();
		lo2.setLabelName("w= " + Integer.toString(w) + " cm");
		lo2.setxCo(1.5);
		lo2.setyCo(1.90);
		// double width = (double)w/10;
		
		int l = 20;
		LabelObject lo3 = new LabelObject();
		lo3.setLabelName("l= " + Integer.toString(l) + " cm");
		lo3.setxCo(5.0);
		lo3.setyCo(.2);
		
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		
		geo.setLines(lineList);
		geo.setLabels(labelList);

		double res = w*h*l;
		
		String result = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP).toString();
		
			
		question = "Find out volume of the picture above";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = "Volumes";
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
			
	//	MessageSource mSource = mathConfig.getmSource();
			
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
		
		double h = MathUtilities.getRandomNumber(5, 10) * 10;
		LabelObject lo1 = new LabelObject();
		lo1.setLabelName("h= " + Double.toString(h) + " cm");
		lo1.setxCo(6.0);
		lo1.setyCo(0.0);
		
		LabelObject lo2 = new LabelObject();
		lo2.setLabelName("a");
		lo2.setxCo(1.95);
		lo2.setyCo(1.0);
		
		labelList.add(lo1);
		labelList.add(lo2);
		
		geo.setLabels(labelList);
		
		double w = 15;
		double a = 13;
		

		double res = ((w*13)/ 2) * h; // (w*h)/ 2 + (w*h)/ 2
		BigDecimal result = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
			
		question = "The height of the prism is " + h + " cm. The prism has an equilateral triangular base with a side of  " + w + " cm. and height of the triangle is a which is " + a + " cm";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = "Volumes";
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
			
	//	MessageSource mSource = mathConfig.getmSource();
			
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
		
		int h = MathUtilities.getRandomNumber(2, 5) * 10;
		LabelObject lo1 = new LabelObject();
		lo1.setxCo(5.0);
		lo1.setyCo(.25);
		lo1.setLabelName("h = " + Integer.toString(h));
		
		int w = 10;
		LabelObject lo2 = new LabelObject();
		lo2.setxCo(1.0);
		lo2.setyCo(-.05);
		lo2.setLabelName("w = " + Integer.toString(w));
		
		labelList.add(lo1);
		labelList.add(lo2);
		
		double result = ((w*w)/2)*h; //((b*h)/2 = (w*w)/ 2 + (w*w)/ 2) + 
		
		geo.setLines(lineList);
		geo.setLabels(labelList);
		
		BigDecimal  rs = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
		
			
		question = "Above is a Isoscele Right Triangular Prism. Find out the volume of the prism";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = "Volumes";
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
			
	//	MessageSource mSource = mathConfig.getmSource();
			
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
		
		LineObject l10 = new LineObject();
		l10.setX1(Double.valueOf(4));
		l10.setY1(Double.valueOf(2));
		l10.setX2(Double.valueOf(4));
		l10.setY2(Double.valueOf(0));
		l10.setColor("grey");

		
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
		
		LabelObject lo1 = new LabelObject();
		lo1.setLabelName("a");
		lo1.setxCo(2.0);
		lo1.setyCo(-.95);
		
		LabelObject lo2 = new LabelObject();
		lo2.setLabelName("b");
		lo2.setxCo(3.0);
		lo2.setyCo(2.1);
		
		LabelObject lo3 = new LabelObject();
		lo3.setLabelName("h");
		lo3.setxCo(3.0);
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
		
		double a = 10;
		double b = 8;
		double h = 5;
		double d = MathUtilities.getRoundedAnswer(3, 5)*10;
		
		double result = ((a+b)/2)*h*d;
		BigDecimal res = new BigDecimal(result).setScale(2,  RoundingMode.HALF_UP);
		
			
		question = "Find the value of trapezoidal prism where a, b d and h are " + a + ", " + b + ", " + d + ", " + h + " cm";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

		String heading = "Volumes";
		answ.setAnswer(res.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	

	//draw a rombus
	public Problem getProblem5(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
	//	MessageSource mSource = mathConfig.getmSource();
			
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
		
		double w = MathUtilities.getRandomNumber(2, 10);
		
		double l = 2* w;
		LabelObject lo3 = new LabelObject();
		lo3.setLabelName("l= " + Double.toString(l) + " cm");
		lo3.setxCo(3.5);
		lo3.setyCo(.2);

		labelList.add(lo3);
		
		geo.setLines(lineList);
		geo.setLabels(labelList);
		
		double area = w*w;
		double result = area*l;		
		
		BigDecimal bg = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
		
			
		question = "The area of the smallest side is " + Double.toString(area) + "cm square and is a square. Find out the volume of the prism.";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = "Volumes";
		answ.setAnswer(bg.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a rectangle
	public Problem getProblem6(MathConfiguration mathConfig) {
					
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
	//	MessageSource mSource = mathConfig.getmSource();
				
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		int m = MathUtilities.getRandomNumber(3, 10);
		int volume= m * m * (2*m);
										
		question = "A rectangular prism has two of the sides as squares. One of the side of the square is " + m + "cm. The length of the rectangular side is twice the side of square side. Find"
				+ " out volume of the prism";

		questionList.add( new QuestionLine( question, null, Constants.PROBLEM_TYPE_FRACTION));

						
		String heading = "Volumes";
		answ.setAnswer(Integer.toString(volume));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}

	public Problem getProblem7(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
	//	MessageSource mSource = mathConfig.getmSource();
				
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		int m = 2;
		int n = 4;
		int o = 6;
		
		int a = 3;
		int b = 2; 
										
		question = "Volume of two rectangular boxes are same. Dimensions of one are " + m + "," + n + ", " + o + " cm. The length and width of the other one are " + a + ", and " + b 
				+ " cm respectively. What is the height of the second box?"; 

		questionList.add( new QuestionLine( question, null, Constants.PROBLEM_TYPE_FRACTION));
						
		String heading = "Volumes";
		answ.setAnswer(Integer.toString(8));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
	//	MessageSource mSource = mathConfig.getmSource();
				
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		int a = MathUtilities.getRandomNumber(1, 3);
		int surfaceArea = 6 * 3* a * a; // 6(a*a + a*a + a*a) = surface area
										
		question = "The surface area of a cube is " + surfaceArea + " square cm. What is the volume of the cube? "; 

		questionList.add( new QuestionLine( question, null, Constants.PROBLEM_TYPE_FRACTION));
						
		String heading = "Volumes";
		answ.setAnswer(Integer.toString(a*a*a));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem9(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
	//	MessageSource mSource = mathConfig.getmSource();
				
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		int a= 10;
		int b= 20;
		int c= 30;
		
		int m = 25;
		int n = 15; 
		int o = 15;
										
		question = "You have two boxes, box A and box b, where you would like to hold water during summer for gardening. The dimensions of A are " + a + ", " + b + ", " + c + " cm and B are"
				+ m + ", " + n + ", " + o + " cm. Which one will hold more water?"; 

		questionList.add( new QuestionLine( question, null, Constants.PROBLEM_TYPE_FRACTION));
						
		String heading = "Volumes";
		answ.setAnswer("A");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a rectangle
	public Problem getProblem10(MathConfiguration mathConfig) {
				
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
			
		int h = 10;
		LabelObject lo1 = new LabelObject();
		lo1.setLabelName("h= " + Integer.toString(h) + " cm");
		lo1.setxCo(.025);
		lo1.setyCo(1.0);
			
		int w = 10;
		LabelObject lo2 = new LabelObject();
		lo2.setLabelName("w= " + Integer.toString(w) + " cm");
		lo2.setxCo(1.5);
		lo2.setyCo(1.90);
			
		int l = 50;
		LabelObject lo3 = new LabelObject();
		lo3.setLabelName("l= " + Integer.toString(l) + " cm");
		lo3.setxCo(5.0);
		lo3.setyCo(.2);
			
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
			
		geo.setLines(lineList);
		geo.setLabels(labelList);
			
		double a1 = (2*(h*w + h*l + w*l)-(w*l))*.25;
		int a3 = MathUtilities.getRandomNumber(3, 5);
		int a2 = l * h* w * a3;
			
				
		question = "Consider the box with its top open and dimensions given in the picture.";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "What would be the cost to paint outside of the whole box if it costs CAD 0.25 for one square centemeter? "+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What would be the cost to fill in the box with hays if hays cost CAD" + a3 + ".00 per cubic cm" + GR8_Constants.ANSWER_TO_QUESTION + a2,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

					
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a trapozoid
	public Problem getProblem11(MathConfiguration mathConfig) {
			
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
		
		double h = MathUtilities.getRandomNumber(2, 3) * 10;
		LabelObject lo1 = new LabelObject();
		lo1.setLabelName("h= " + Double.toString(h) + " cm");
		lo1.setxCo(6.0);
		lo1.setyCo(0.0);
		
		labelList.add(lo1);
		
		geo.setLabels(labelList);
		
		double w = 15;
		double l = 13;
		
		double area = w*l + + 3*w*h; // (w*h)/ 2 + (w*h)/ 2
		double baseArea = (double)(15 *13)/2; 
		

		BigDecimal a1 = new BigDecimal(area * .3).setScale(2, RoundingMode.HALF_UP);
		BigDecimal a2 = new BigDecimal(baseArea*h).setScale(2, RoundingMode.HALF_UP);
			
		question = "Above is a triangular prism. The base of the prism makes an equilateral triangle. The base of the triangle is 15 cm and height is"
				+ " 13 cm. " ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "How much will it cost to wrap the prism with paper if it costs .30 per square cm of paper "+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "How much water you can put in the prism in terms of cubic cm" + GR8_Constants.ANSWER_TO_QUESTION + a2,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

				
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem12(MathConfiguration mathConfig) {
							
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
	//	MessageSource mSource = mathConfig.getmSource();
			
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
		
		geo.setLines(lineList);
		
		question = "Width is 3.5 cm. Length is twice as much as width. Height of the prism is 30 mm. Find out volume of the prism" ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
				
		String heading = "Volumes";
		answ.setAnswer("73.5");

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
			
		List<LineObject> lineList = new ArrayList<LineObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		
		LabelObject lb1 = new LabelObject();
		LabelObject lb2 = new LabelObject();

						
		lb1.setxCo(1.0);
		lb1.setyCo(1.0);
		lb1.setLabelName("a");
		
		lb2.setxCo(4.0);
		lb2.setyCo(5.0);
		lb2.setLabelName("b");
		
		labelList.add(lb1);
		labelList.add(lb2);  
			
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(4));
		l1.setY2(Double.valueOf(0));
			
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(0));
		l2.setY2(Double.valueOf(4));
			
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(0));
		l3.setY1(Double.valueOf(4));
		l3.setX2(Double.valueOf(4));
		l3.setY2(Double.valueOf(4));
			
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(4));
		l4.setY1(Double.valueOf(4));
		l4.setX2(Double.valueOf(4));
		l4.setY2(Double.valueOf(0));
			
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(0));
		l5.setY1(Double.valueOf(2));
		l5.setX2(Double.valueOf(4));
		l5.setY2(Double.valueOf(2));
			
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(4));
		l6.setY1(Double.valueOf(8));
		l6.setX2(Double.valueOf(8));
		l6.setY2(Double.valueOf(8));
		
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(2));
		l7.setY1(Double.valueOf(6));
		l7.setX2(Double.valueOf(6));
		l7.setY2(Double.valueOf(6));
			
		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(4));
		l8.setY1(Double.valueOf(0));
		l8.setX2(Double.valueOf(8));
		l8.setY2(Double.valueOf(4));
			
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(6));
		l9.setY1(Double.valueOf(2));
		l9.setX2(Double.valueOf(6));
		l9.setY2(Double.valueOf(6));
		
		LineObject l10 = new LineObject();
		l10.setX1(Double.valueOf(0));
		l10.setY1(Double.valueOf(4));
		l10.setX2(Double.valueOf(4));
		l10.setY2(Double.valueOf(8));
		
		LineObject l11 = new LineObject();
		l11.setX1(Double.valueOf(4));
		l11.setY1(Double.valueOf(4));
		l11.setX2(Double.valueOf(8));
		l11.setY2(Double.valueOf(8));
		
		LineObject l12 = new LineObject();
		l12.setX1(Double.valueOf(8));
		l12.setY1(Double.valueOf(8));
		l12.setX2(Double.valueOf(8));
		l12.setY2(Double.valueOf(4));
		
		LineObject l13 = new LineObject();
		l13.setX1(Double.valueOf(2));
		l13.setY1(Double.valueOf(4));
		l13.setX2(Double.valueOf(6));
		l13.setY2(Double.valueOf(8));
		
		LineObject l14 = new LineObject();
		l14.setX1(Double.valueOf(2));
		l14.setY1(Double.valueOf(0));
		l14.setX2(Double.valueOf(2));
		l14.setY2(Double.valueOf(4)); 
		
		LineObject l15 = new LineObject();
		l15.setX1(Double.valueOf(4));
		l15.setY1(Double.valueOf(2));
		l15.setX2(Double.valueOf(8));
		l15.setY2(Double.valueOf(6)); 
			
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
		lineList.add(l14);
		lineList.add(l15);
	
		geo.setLines(lineList);
				
		question = "The dimension of the square is 2 cm by 2 cm and dimension of the rectangle is 2 cm by 3 cm. What is the volume of the box?" ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
					
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("96");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
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
				
		List<LineObject> lineList = new ArrayList<LineObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
			
		LabelObject lb1 = new LabelObject();
		LabelObject lb2 = new LabelObject();

							
		lb1.setxCo(1.0);
		lb1.setyCo(1.0);
		lb1.setLabelName("a");
			
		lb2.setxCo(4.0);
		lb2.setyCo(5.0);
		lb2.setLabelName("b");
			
		labelList.add(lb1);
		labelList.add(lb2);  
				
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(4));
		l1.setY2(Double.valueOf(0));
				
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(0));
		l2.setY2(Double.valueOf(4));
				
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(0));
		l3.setY1(Double.valueOf(4));
		l3.setX2(Double.valueOf(4));
		l3.setY2(Double.valueOf(4));
				
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(4));
		l4.setY1(Double.valueOf(4));
		l4.setX2(Double.valueOf(4));
		l4.setY2(Double.valueOf(0));
				
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(0));
		l5.setY1(Double.valueOf(2));
		l5.setX2(Double.valueOf(4));
		l5.setY2(Double.valueOf(2));
				
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(4));
		l6.setY1(Double.valueOf(8));
		l6.setX2(Double.valueOf(8));
		l6.setY2(Double.valueOf(8));
			
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(2));
		l7.setY1(Double.valueOf(6));
		l7.setX2(Double.valueOf(6));
		l7.setY2(Double.valueOf(6));
				
		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(4));
		l8.setY1(Double.valueOf(0));
		l8.setX2(Double.valueOf(8));
		l8.setY2(Double.valueOf(4));
				
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(6));
		l9.setY1(Double.valueOf(2));
		l9.setX2(Double.valueOf(6));
		l9.setY2(Double.valueOf(6));
			
		LineObject l10 = new LineObject();
		l10.setX1(Double.valueOf(0));
		l10.setY1(Double.valueOf(4));
		l10.setX2(Double.valueOf(4));
		l10.setY2(Double.valueOf(8));
			
		LineObject l11 = new LineObject();
		l11.setX1(Double.valueOf(4));
		l11.setY1(Double.valueOf(4));
		l11.setX2(Double.valueOf(8));
		l11.setY2(Double.valueOf(8));
			
		LineObject l12 = new LineObject();
		l12.setX1(Double.valueOf(8));
		l12.setY1(Double.valueOf(8));
		l12.setX2(Double.valueOf(8));
		l12.setY2(Double.valueOf(4));
			
		LineObject l13 = new LineObject();
		l13.setX1(Double.valueOf(2));
		l13.setY1(Double.valueOf(4));
		l13.setX2(Double.valueOf(6));
		l13.setY2(Double.valueOf(8));
			
		LineObject l14 = new LineObject();
		l14.setX1(Double.valueOf(2));
		l14.setY1(Double.valueOf(0));
		l14.setX2(Double.valueOf(2));
		l14.setY2(Double.valueOf(4)); 
		
		LineObject l15 = new LineObject();
		l15.setX1(Double.valueOf(4));
		l15.setY1(Double.valueOf(2));
		l15.setX2(Double.valueOf(8));
		l15.setY2(Double.valueOf(6)); 
				
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
		lineList.add(l14);
		lineList.add(l15);

		
		geo.setLines(lineList);
					
		question = "The dimension of the square is 2 cm by 2 cm and dimension of the rectangle is 2 cm by 3 cm. If you squeeze the length "
				+ "of the rectangle and make it a square with a dimension of 2 cm by 2 cm then what will be the volume of the box?" ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("64");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);
				
		return problem;

	}
	
	public Problem getProblem15(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
	//	MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		question = "You have a box measuring 10 cm by 10 cm by 10 cm. How many dice you can place on the box with dimensions 5 cm by 5 cm by 5 cm?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = "Volumes";
		answ.setAnswer("8");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a rectangle
	public Problem getProblem16(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
	//	MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		question = "You have 3 CD boxes with dimensions 2 cm by 5 cm by 12 cm and 5 cd boxes with 3 cm by 5 cm by 12 cm. "
				+ "What should be the minimum size of the container in terms of cubic centemeter that will hold all the 8 boxes?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = "Volumes";
		answ.setAnswer("1260");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a rectangle
	public Problem getProblem17(MathConfiguration mathConfig) {
					
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
		MessageSource mSource = mathConfig.getmSource();
				
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
					
		GeometryObject geo = new GeometryObject();
				
		List<LineObject> lineList = new ArrayList<LineObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
			
		LabelObject lb1 = new LabelObject();
		LabelObject lb2 = new LabelObject();

							
		lb1.setxCo(1.0);
		lb1.setyCo(1.0);
		lb1.setLabelName("a");
			
		lb2.setxCo(4.0);
		lb2.setyCo(5.0);
		lb2.setLabelName("b");
			
		labelList.add(lb1);
		labelList.add(lb2);  
				
		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(0));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(4));
		l1.setY2(Double.valueOf(0));
				
		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(0));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(0));
		l2.setY2(Double.valueOf(2));
				
		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(4));
		l3.setY1(Double.valueOf(0));
		l3.setX2(Double.valueOf(4));
		l3.setY2(Double.valueOf(2));
				
		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(0));
		l4.setY1(Double.valueOf(2));
		l4.setX2(Double.valueOf(4));
		l4.setY2(Double.valueOf(2));
				
		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(0));
		l5.setY1(Double.valueOf(2));
		l5.setX2(Double.valueOf(2));
		l5.setY2(Double.valueOf(4));
				
		LineObject l6 = new LineObject();
		l6.setX1(Double.valueOf(2));
		l6.setY1(Double.valueOf(4));
		l6.setX2(Double.valueOf(6));
		l6.setY2(Double.valueOf(4));
			
		LineObject l7 = new LineObject();
		l7.setX1(Double.valueOf(2));
		l7.setY1(Double.valueOf(4));
		l7.setX2(Double.valueOf(2));
		l7.setY2(Double.valueOf(6));
				
		LineObject l8 = new LineObject();
		l8.setX1(Double.valueOf(6));
		l8.setY1(Double.valueOf(4));
		l8.setX2(Double.valueOf(6));
		l8.setY2(Double.valueOf(6));
				
		LineObject l9 = new LineObject();
		l9.setX1(Double.valueOf(2));
		l9.setY1(Double.valueOf(6));
		l9.setX2(Double.valueOf(4));
		l9.setY2(Double.valueOf(8));
			
		LineObject l10 = new LineObject();
		l10.setX1(Double.valueOf(4));
		l10.setY1(Double.valueOf(8));
		l10.setX2(Double.valueOf(8));
		l10.setY2(Double.valueOf(8));
			
		LineObject l11 = new LineObject();
		l11.setX1(Double.valueOf(6));
		l11.setY1(Double.valueOf(6));
		l11.setX2(Double.valueOf(8));
		l11.setY2(Double.valueOf(8));
			
		LineObject l12 = new LineObject();
		l12.setX1(Double.valueOf(8));
		l12.setY1(Double.valueOf(8));
		l12.setX2(Double.valueOf(8));
		l12.setY2(Double.valueOf(4));
			
		LineObject l13 = new LineObject();
		l13.setX1(Double.valueOf(4));
		l13.setY1(Double.valueOf(2));
		l13.setX2(Double.valueOf(8));
		l13.setY2(Double.valueOf(6));
			
		LineObject l14 = new LineObject();
		l14.setX1(Double.valueOf(4));
		l14.setY1(Double.valueOf(0));
		l14.setX2(Double.valueOf(8));
		l14.setY2(Double.valueOf(4)); 
		
		LineObject l15 = new LineObject();
		l15.setX1(Double.valueOf(8));
		l15.setY1(Double.valueOf(8));
		l15.setX2(Double.valueOf(8));
		l15.setY2(Double.valueOf(4)); 
		
		LineObject l16 = new LineObject();
		l15.setX1(Double.valueOf(2));
		l15.setY1(Double.valueOf(6));
		l15.setX2(Double.valueOf(6));
		l15.setY2(Double.valueOf(6)); 
				
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
		lineList.add(l14);
		lineList.add(l15);
		lineList.add(l16);
		
		geo.setLines(lineList);
					
		question = "The dimension of all the boxes above is 2 cm by 2 cm by 3 cm. What would be volume of the picture?" ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("36");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);
				
		return problem;
	}
	

	
	public Problem getProblem18(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
	//	MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		question = "Consider a cube with 8 cubic centemeter volume. If you double each side of the cube then answer the following ";
		
		int a1 = 6* 4;
		int a2 = 6 * 16;
		int a3 = 4*4*4;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "What would be the new surface area if the volume is 8? "+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What would be the new surface area" + GR8_Constants.ANSWER_TO_QUESTION + a2,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What would be the new volume" + GR8_Constants.ANSWER_TO_QUESTION + a3,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));


				
		String heading = "Volumes";
		answ.setAnswer("8");
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a rectangle
	public Problem getProblem19(MathConfiguration mathConfig) {
					
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
					
		MessageSource mSource = mathConfig.getmSource();
				
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		int m = MathUtilities.getRandomNumber(3, 10);
		int area = m * m;
		int surfaceArea = 6 * area;
		int volume= m * m * m;
										
		question = "If the surface area of a cube is " + Integer.toString(surfaceArea) + ", the what is the volume of the cube";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(volume));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a rectangle
	public Problem getProblem20(MathConfiguration mathConfig) {
						
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
						
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
											
		question = "You have a cat that needs 12 ml of serving twice a day. You bought a box which is 8/10 full and dimension of the box are"
				+ "10 cm by 8 cm by 6 cm. How many days will it last?";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

							
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_SURFACE_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("16");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answ);

		return problem;
	}
	
	
			
}
