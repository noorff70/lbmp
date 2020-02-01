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
import com.weblearning.domain.utility.geometry.RangeXY;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.grade8.impl.GR8_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7AreasPolygons extends GenericQuestion{
	
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
		List <PatchObject> patches = new ArrayList<PatchObject>();
		
		PatchObject po = new PatchObject();
		int x= MathUtilities.getRandomNumber(1, 5);
		int xDistance = x + MathUtilities.getRandomNumber(10, 20);
		int y= MathUtilities.getRandomNumber(2, 15);
		int yDistance = y + MathUtilities.getRandomNumber(5, 20);
		
		List<String> xcos = new ArrayList<String>();
		xcos.add(Integer.toString(x));
		xcos.add(Integer.toString(x));
		xcos.add(Integer.toString(xDistance));
		xcos.add(Integer.toString(xDistance));
		
		List<String> ycos = new ArrayList<String>();
		ycos.add(Integer.toString(y));
		ycos.add(Integer.toString(yDistance));
		ycos.add(Integer.toString(yDistance));
		ycos.add(Integer.toString(y));
		
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);	
		
		geo.setPatches(patches);
		
		BigDecimal result = new BigDecimal(((double)(xDistance-x)*(yDistance-y))).setScale(2, RoundingMode.HALF_UP);
		
			
		question = "Find out the area of the rectangle: x distance = " + Integer.toString(xDistance-x) + ", y distance = " + Integer.toString(yDistance-y);

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
	public Problem getProblem2(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		List <PatchObject> patches = new ArrayList<PatchObject>();
		RangeXY xy = new RangeXY();
		
		PatchObject po = new PatchObject();
		
		List<String> xcos = new ArrayList<String>();
		xcos.add(Integer.toString(2));
		xcos.add(Integer.toString(4));
		xcos.add(Integer.toString(8));
		xcos.add(Integer.toString(10));
		
		List<String> ycos = new ArrayList<String>();
		ycos.add(Integer.toString(2));
		ycos.add(Integer.toString(5));
		ycos.add(Integer.toString(5));
		ycos.add(Integer.toString(2));
		
		xy.setLowerX(1);
		xy.setUpperX(10);
		xy.setLowerY(1);
		xy.setUpperY(6);
		
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);	
		
		geo.setPatches(patches);
		geo.setRangeXY(xy);
		
		BigDecimal a1 = new BigDecimal((double)(4-2)*(5-2)/2).setScale(2, RoundingMode.HALF_UP);
		BigDecimal a2 = new BigDecimal((double)(10-8)*(5-2)/2).setScale(2, RoundingMode.HALF_UP);
		BigDecimal a3 = new BigDecimal((double)4*3).setScale(2, RoundingMode.HALF_UP);
		
		BigDecimal result = a1.add(a2).add(a3);
		
			
		question = "Find out the area of the Trapozoid";

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
		
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
		RangeXY xy = new RangeXY();
			
		PatchObject po = new PatchObject();
		
		int x1 = MathUtilities.getRandomNumber(10, 15);
		int y1 = MathUtilities.getRandomNumber(2, 10);
		
		int x2 = x1 + MathUtilities.getRandomNumber(10, 20); 
		int y2 = y1 + MathUtilities.getRandomNumber(10, 15);
		
		int x3 = x2 + MathUtilities.getRandomNumber(10, 15);
		int y3 = y2;
		
		int x4 = x3 + MathUtilities.getRandomNumber(10, 20);
		int y4 = y1;
			
		List<String> xcos = new ArrayList<String>();
		xcos.add(Integer.toString(x1));
		xcos.add(Integer.toString(x2));
		xcos.add(Integer.toString(x3));
		xcos.add(Integer.toString(x4));
			
		List<String> ycos = new ArrayList<String>();
		ycos.add(Integer.toString(y1));
		ycos.add(Integer.toString(y2));
		ycos.add(Integer.toString(y3));
		ycos.add(Integer.toString(y4));
		
		//set ranges
		xy.setLowerX(x1-1);
		xy.setUpperX(x4+1);
		xy.setLowerY(y1);
		xy.setUpperY(y2);
			
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
		
		//set labels
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		
		l1.setLabelName("A");
		l1.setxCo(Double.valueOf(x1+.025));
		l1.setyCo(Double.valueOf(y1+.025));
		
		l2.setLabelName("B");
		l2.setxCo(Double.valueOf(x2+.025));
		l2.setyCo(y1+ .025);
		
		l3.setLabelName("C");
		l3.setxCo(Double.valueOf(x3+.025));
		l3.setyCo(y1+ .025);
		
		l4.setLabelName("D");
		l4.setxCo(Double.valueOf(x4-.025));
		l4.setyCo(y1+ .025);
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		
		//set lineobjects
		LineObject line1 = new LineObject();
		line1.setX1(Double.valueOf(x2));
		line1.setY1(Double.valueOf(y2));
		line1.setX2(Double.valueOf(x2));
		line1.setY2(Double.valueOf(y1));
		line1.setColor("purple");
		
		LineObject line2 = new LineObject();
		line2.setX1(Double.valueOf(x3));
		line2.setY1(Double.valueOf(y2));
		line2.setX2(Double.valueOf(x3));
		line2.setY2(Double.valueOf(y1));
		line2.setColor("purple");
		
		lineList.add(line1);
		lineList.add(line2);
			
		geo.setPatches(patches);
		geo.setRangeXY(xy);
		geo.setLabels(labelList);
		geo.setLines(lineList);
			
		BigDecimal a1 = new BigDecimal((double)(x2-x1)*(y2-y1)/2).setScale(2, RoundingMode.HALF_UP);
		BigDecimal a2 = new BigDecimal((double)(x4-x3)*(y2-y1)/2).setScale(2, RoundingMode.HALF_UP);
		BigDecimal a3 = new BigDecimal((double)(x3-x2)*(y2-y1)).setScale(2, RoundingMode.HALF_UP);
			
		BigDecimal result = a1.add(a2).add(a3);
			
				
		question = "Find out the area of the Trapozoid when AB= " + Integer.toString(x2-x1) + " BC = " + Integer.toString(x3-x2) 
			+ " CD = " + Integer.toString(x4-x3) + "and the height is: " + Integer.toString(y2-y1) ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

					
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

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
		
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
		RangeXY xy = new RangeXY();
			
		PatchObject po = new PatchObject();
		
		int x1 = MathUtilities.getRandomNumber(10, 15);
		int y1 = x1;
		
		int x2 = x1; 
		int y2 = MathUtilities.getRandomNumber(10, 15);
		
		int xDistance = MathUtilities.getRandomNumber(20, 50);
		int x3 = x1 + xDistance;
		int y3 = y2;
		
		int x4 = x3;
		int y4 = y1;
		
		LineObject line1 = new LineObject();
		line1.setX1(Double.valueOf(x1));
		line1.setY1(Double.valueOf(y1));
		line1.setX2(Double.valueOf(x2));
		line1.setY2(Double.valueOf(y2));
		line1.setColor("purple");
		
		LineObject line2 = new LineObject();
		line2.setX1(Double.valueOf(x2));
		line2.setY1(Double.valueOf(y2));
		line2.setX2(Double.valueOf(x3));
		line2.setY2(Double.valueOf(y3));
		line2.setColor("purple");
		
		LineObject line3 = new LineObject();
		line3.setX1(Double.valueOf(x3));
		line3.setY1(Double.valueOf(y3));
		line3.setX2(Double.valueOf(x4));
		line3.setY2(Double.valueOf(y4));
		line3.setColor("purple");
		
		LineObject line4 = new LineObject();
		line4.setX1(Double.valueOf(x1));
		line4.setY1(Double.valueOf(y1));
		line4.setX2(Double.valueOf(x4));
		line4.setY2(Double.valueOf(y4));
		line4.setColor("purple");
		
		lineList.add(line1);
		lineList.add(line2);
		lineList.add(line3);
		lineList.add(line4);
		
		//create patch
		int x5 = (x1+x3)/2; 
		List<String> xcos = new ArrayList<String>();
		xcos.add(Integer.toString(x1));
		xcos.add(Integer.toString(x5));
		xcos.add(Integer.toString(x4));
			
		List<String> ycos = new ArrayList<String>();
		ycos.add(Integer.toString(y1));
		ycos.add(Integer.toString(y2));
		ycos.add(Integer.toString(y4));
		
		//set ranges
		xy.setLowerX(x1-1);
		xy.setUpperX(x4+1);
		xy.setLowerY(y1);
		xy.setUpperY(y2);
			
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
				
			
		geo.setPatches(patches);
		geo.setRangeXY(xy);
		geo.setLines(lineList);
			
		double height = x4-x1;
		double width = y2-y1;
		
		BigDecimal recArea = new BigDecimal(height*width).setScale(2, RoundingMode.HALF_UP);
		BigDecimal trianArea = new BigDecimal(height*width/2).setScale(2, RoundingMode.HALF_UP);
			
		BigDecimal result = recArea.subtract(trianArea);
				
		question = "Find area of the white area inside the box. The height and width of the box are, height: " + Double.toString(height) + " and width = " + Double.toString(width) ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

					
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

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
		
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
		RangeXY xy = new RangeXY();
			
		PatchObject po = new PatchObject();
		
		int x1 = MathUtilities.getRandomNumber(10, 15);
		int y1 = MathUtilities.getRandomNumber(10,15);
		
		int sideX = MathUtilities.getRandomNumber(5, 10);
		int sideY = MathUtilities.getRandomNumber(5, 10);
		
		int x2 = x1 + sideX; 
		int y2 = y1 + sideY;
		
		int xLength = MathUtilities.getRandomNumber(20, 50);
		
		int x3 = x2 + xLength;
		int y3 = y2;
		
		int x4 = x1+xLength;
		int y4 = y1;
			
		List<String> xcos = new ArrayList<String>();
		xcos.add(Integer.toString(x1));
		xcos.add(Integer.toString(x2));
		xcos.add(Integer.toString(x3));
		xcos.add(Integer.toString(x4));
			
		List<String> ycos = new ArrayList<String>();
		ycos.add(Integer.toString(y1));
		ycos.add(Integer.toString(y2));
		ycos.add(Integer.toString(y3));
		ycos.add(Integer.toString(y4));
		
		//set ranges
		xy.setLowerX(x1-1);
		xy.setUpperX(x3+1);
		xy.setLowerY(y1-1);
		xy.setUpperY(y2+1);
			
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
		
		//set labels
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		LabelObject l5 = new LabelObject();
		LabelObject l6 = new LabelObject();
		
		l1.setLabelName("A");
		l1.setxCo(Double.valueOf(x1+.025));
		l1.setyCo(Double.valueOf(y1+.025));
		
		l2.setLabelName("B");
		l2.setxCo(Double.valueOf(x2+.025));
		l2.setyCo(y2+ .025);
		
		l3.setLabelName("C");
		l3.setxCo(Double.valueOf(x3+.025));
		l3.setyCo(y3+ .025);
		
		l4.setLabelName("D");
		l4.setxCo(Double.valueOf(x4-.025));
		l4.setyCo(y4+ .025);
		
		l5.setLabelName("E");
		l5.setxCo(Double.valueOf(x2-.025));
		l5.setyCo(y1+ .025);
		
		l6.setLabelName("F");
		l6.setxCo(Double.valueOf(x4-.025));
		l6.setyCo(y2+ .025);
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		labelList.add(l6);
		
		//create lines
		LineObject line1 = new LineObject();
		LineObject line2 = new LineObject();
		
		line1.setX1(Double.valueOf(x2));
		line1.setY1(Double.valueOf(y2));
		line1.setX2(Double.valueOf(x2));
		line1.setY2(Double.valueOf(y1));
		line1.setColor("purple");
		
		line2.setX1(Double.valueOf(x4));
		line2.setY1(Double.valueOf(y2));
		line2.setX2(Double.valueOf(x4));
		line2.setY2(Double.valueOf(y1));
		line2.setColor("purple");
		
		lineList.add(line1);
		lineList.add(line2);
			
		geo.setPatches(patches);
		geo.setRangeXY(xy);
		geo.setLabels(labelList);
		geo.setLines(lineList);
		
		int AE = MathUtilities.getRandomNumber(10, 20);
		int BF = MathUtilities.getRandomNumber(30, 75);
		int BE = MathUtilities.getRandomNumber(40, 60);
			
		BigDecimal a1 = new BigDecimal((double)(AE*BE/2)).setScale(2, RoundingMode.HALF_UP);
		BigDecimal a2 = new BigDecimal((double)(AE*BE/2)).setScale(2, RoundingMode.HALF_UP);
		BigDecimal a3 = new BigDecimal((double)(BF*BE)).setScale(2, RoundingMode.HALF_UP);
			
		BigDecimal result = a1.add(a2).add(a3);
		BigDecimal a4 = a3.add(a2);
			
		question = "AE= CF = " + Integer.toString(AE) + ", BF = " + Integer.toString(BF) +" , BE = " + Integer.toString(BE)  ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "Area of ABE :"+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Area of ABCD :"+ GR8_Constants.ANSWER_TO_QUESTION + result.toString(),  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Area of BFED :"+ GR8_Constants.ANSWER_TO_QUESTION + a3,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Area of BCDE :"+ GR8_Constants.ANSWER_TO_QUESTION + a4.toString(),  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

					
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(result.toString());

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
		
		List <PatchObject> patches = new ArrayList<PatchObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
		RangeXY xy = new RangeXY();
			
		PatchObject po = new PatchObject();
		
		int x1 = 2;
		int y1 = x1;
		
		int x2 = x1; 
		int y2 = MathUtilities.getRandomNumber(15, 30);
		
		int xDistance = MathUtilities.getRandomNumber(30, 60);
		int x3 = x1 + xDistance;
		int y3 = y2;
		
		int x4 = x3;
		int y4 = y1;
		
		LineObject line1 = new LineObject();
		line1.setX1(Double.valueOf(x1));
		line1.setY1(Double.valueOf(y1));
		line1.setX2(Double.valueOf(x2));
		line1.setY2(Double.valueOf(y2));
		line1.setColor("purple");
		
		LineObject line2 = new LineObject();
		line2.setX1(Double.valueOf(x2));
		line2.setY1(Double.valueOf(y2));
		line2.setX2(Double.valueOf(x3));
		line2.setY2(Double.valueOf(y3));
		line2.setColor("purple");
		
		LineObject line3 = new LineObject();
		line3.setX1(Double.valueOf(x3));
		line3.setY1(Double.valueOf(y3));
		line3.setX2(Double.valueOf(x4));
		line3.setY2(Double.valueOf(y4));
		line3.setColor("purple");
		
		LineObject line4 = new LineObject();
		line4.setX1(Double.valueOf(x1));
		line4.setY1(Double.valueOf(y1));
		line4.setX2(Double.valueOf(x4));
		line4.setY2(Double.valueOf(y4));
		line4.setColor("purple");
		
		lineList.add(line1);
		lineList.add(line2);
		lineList.add(line3);
		lineList.add(line4);
		
		//create patch
		List<String> xcos = new ArrayList<String>();
		xcos.add(Integer.toString(x1+2));
		xcos.add(Integer.toString(x1+2));
		xcos.add(Integer.toString(x4-2));
		xcos.add(Integer.toString(x4-2));
			
		List<String> ycos = new ArrayList<String>();
		ycos.add(Integer.toString(y1+2));
		ycos.add(Integer.toString(y2-2));
		ycos.add(Integer.toString(y2-2));
		ycos.add(Integer.toString(y1+2));
		
		//set ranges
		xy.setLowerX(x1-1);
		xy.setUpperX(x4+1);
		xy.setLowerY(y1);
		xy.setUpperY(y2);
			
		po.setCoX(xcos);
		po.setCoY(ycos);
		patches.add(po);
		
		int walkway = MathUtilities.getRandomNumber(2, 5);
			
		geo.setPatches(patches);
		geo.setRangeXY(xy);
		geo.setLines(lineList);
			
		double heightBigger = x4-x1;
		double widthBigger = y2-y1;
		double bigger = heightBigger* widthBigger;
		
		double heightSmaller = heightBigger-2*walkway;
		double widthSmaller = widthBigger- 2*walkway;
		double smaller = heightSmaller*widthSmaller;
		
		double walkwayArea = bigger-smaller;
				
		question = "The purple area has a width of " + Double.toString(widthBigger) + ", and length " + Double.toString(heightBigger) + "Inside that has a walkway of: " 
				+ Integer.toString(walkway) + " on all sides. Both the blocks are rectangular. What is the area of the walkway?" ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

					
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(Double.toString(walkwayArea));

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
	public Problem getProblem8(MathConfiguration mathConfig) {
								
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
	public Problem getProblem9(MathConfiguration mathConfig) {
								
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
							
		MessageSource mSource = mathConfig.getmSource();
								
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="", question1="", question2="";	
		String answer1="", answer2= "";
									
		int a = MathUtilities.getRandomNumber(10, 15);
		double b = a * 2;
												
		question = "The height of a rectangle is " + Integer.toString(a) + " meter. Length of the rectangle is twice that of the height";
		
		question1 = "Length of the rectangle in cm";
		answer1 = Double.toString(b*100);
		
		question2 = "Area of the rectangle in square cm";
		answer2 = Double.toString(a*b*100*100);

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
									
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

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
									
		int a = MathUtilities.getRandomNumber(10, 15);
		int b = MathUtilities.getRandomNumber(20, 30);
								
		BigDecimal area = new BigDecimal(a*b*1.1).setScale(2, RoundingMode.HALF_UP);
												
		question = "The width and length of a rectangle are width: " + Integer.toString(a) + ", and height: " + Integer.toString(b) 
			+ " If the width increasses by 10%, then what will be the new area of the rectangle?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
									
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(area.toString());

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
		String question="";							
									
		int a = MathUtilities.getRandomNumber(10, 15);
		int b = MathUtilities.getRandomNumber(20, 30);
		double newA = a * 1.1;
								
		BigDecimal area = new BigDecimal(newA*b).setScale(2, RoundingMode.HALF_UP);
												
		question = "The width and length of a rectangle are width: " + Integer.toString(a) + ", and height: " + Integer.toString(b) 
			+ " If the width increasses by 10%, then what will be the new area of the rectangle?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
									
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(area.toString());

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
									
		int a = MathUtilities.getRandomNumber(10, 15);
		int b = MathUtilities.getRandomNumber(20, 30);
		
		int increase = MathUtilities.getRandomNumber(2, 5);
								
		BigDecimal area = new BigDecimal((a+increase)*(b+increase)).setScale(2, RoundingMode.HALF_UP);
												
		question = "The width and length of a rectangle are width: " + Integer.toString(a) + ", and height: " + Integer.toString(b) 
			+ " If the both the length and width are increased by ," + Integer.toString(increase) +" then what will be the new area of the rectangle?";

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
								
		BigDecimal area = new BigDecimal((a*a)).setScale(2, RoundingMode.HALF_UP);
		int costs = MathUtilities.getRandomNumber(5, 10);
		int result = 4*a*costs;
												
		question = "The area of a square is " + area.toString() + " . If it costs " + Integer.toString(costs) + " per unit, then what would be the cost for making a fence that covers the whole area?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
									
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(result));

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
									
								
		int size = MathUtilities.getRandomNumber(2, 5);
		if (size == 3)
			size = 4;
		
		double ans = (100 * 100)/ (size * size);
		
		question = "You have got a square of 1 meter each side. You are going to fill that up with square boxes of " + Integer.toString(size) 
			+ " cm of each side. How many boxes you need to fully cover up the bigger box?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
									
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(Double.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem15(MathConfiguration mathConfig) {
								
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
							
		MessageSource mSource = mathConfig.getmSource();
								
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";							
									
								
		int size = MathUtilities.getRandomNumber(2, 5);
		if (size == 3)
			size = 4;
		
		int price = MathUtilities.getRandomNumber(4, 10);
		double ans = (100 * 100)/ (size * size)*price;
		
		question = "You have got a square of 100 cm each side. You are going to fill that up with square boxes of " + Integer.toString(size) 
			+ " cm of each side. Each box costs " + Integer.toString(price) + " . What would be the total cost of covering the big box with smaller boxes?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
									
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(Double.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem16(MathConfiguration mathConfig) {
								
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
							
		MessageSource mSource = mathConfig.getmSource();
								
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";							
									
								
		int size = MathUtilities.getRandomNumber(10, 25);
		int reduce = MathUtilities.getRandomNumber(5, 10);
		

		double ans = (size-reduce) * (size-reduce);
		
		question = "The side of a square is " + Integer.toString(size) + " . If the side reduces by  " + Integer.toString(reduce) + " , then what will be the new area of the square?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
									
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer(Double.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}


	
		
}
