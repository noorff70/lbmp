package com.weblearning.math.grade7.impl;

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
import com.weblearning.domain.utility.geometry.CircleObject;
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

public class G7Coordinate extends GenericQuestion{
	
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
		
		restMathClient = new RestMathClientServiceImpl();
		problemList = restMathClient.returnGraph(problemList);
	
		return problemList;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		GeometryObject geo = new GeometryObject();
		List<CircleObject> circleList = new ArrayList<CircleObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		
		CircleObject co1= new CircleObject();
		LabelObject lo1 = new LabelObject();
		int _1x = MathUtilities.getRandomNumber(1, 8);
		int _1y = MathUtilities.getRandomNumber(1, 8);
		co1.setxCo(Double.valueOf(_1x));
		co1.setyCo(Double.valueOf(_1y));
		lo1.setxCo(Double.valueOf(_1x+.025));
		lo1.setyCo(Double.valueOf(_1y+.025));
		lo1.setLabelName("A");
		
		CircleObject co2= new CircleObject();
		LabelObject lo2 = new LabelObject();
		int _2x = MathUtilities.getRandomNumber(1, 8);
		int _2y = MathUtilities.getRandomNumber(-8, -1);
		co2.setxCo(Double.valueOf(_2x));
		co2.setyCo(Double.valueOf(_2y));
		lo2.setxCo(Double.valueOf(_2x+.025));
		lo2.setyCo(Double.valueOf(_2y+.025));
		lo2.setLabelName("B");
		
		CircleObject co3= new CircleObject();
		LabelObject lo3 = new LabelObject();
		int _3x = MathUtilities.getRandomNumber(-8, -1);
		int _3y = MathUtilities.getRandomNumber(1, 8);
		co3.setxCo(Double.valueOf(_3x));
		co3.setyCo(Double.valueOf(_3y));
		lo3.setxCo(Double.valueOf(_3x+.025));
		lo3.setyCo(Double.valueOf(_3y+.025));
		lo3.setLabelName("C");
		
		CircleObject co4= new CircleObject();
		LabelObject lo4 = new LabelObject();
		int _4x = MathUtilities.getRandomNumber(-8, -1);
		int _4y = MathUtilities.getRandomNumber(-8,-1);
		co4.setxCo(Double.valueOf(_4x));
		co4.setyCo(Double.valueOf(_4y));
		lo4.setxCo(Double.valueOf(_4x+.025));
		lo4.setyCo(Double.valueOf(_4y+.025));
		lo4.setLabelName("D");
		
		CircleObject co5= new CircleObject();
		LabelObject lo5 = new LabelObject();
		int _5x = 0;
		int _5y = MathUtilities.getRandomNumber(-8,-1);
		co5.setxCo(Double.valueOf(_5x));
		co5.setyCo(Double.valueOf(_5y));
		lo5.setxCo(Double.valueOf(_5x+.025));
		lo5.setyCo(Double.valueOf(_5y+.025));
		lo5.setLabelName("E");
		
		CircleObject co6= new CircleObject();
		LabelObject lo6 = new LabelObject();
		int _6x = MathUtilities.getRandomNumber(1,8);
		int _6y = 0;
		co6.setxCo(Double.valueOf(_6x));
		co6.setyCo(Double.valueOf(_6y));
		lo6.setxCo(Double.valueOf(_6x+.025));
		lo6.setyCo(Double.valueOf(_6y+.025));
		lo6.setLabelName("F");
		
		circleList.add(co1);
		circleList.add(co2);
		circleList.add(co3);
		circleList.add(co4);
		circleList.add(co5);
		circleList.add(co6);
		geo.setCircles(circleList);	
		
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		labelList.add(lo4);
		labelList.add(lo5);
		labelList.add(lo6);
		geo.setLabels(labelList);
		
		String ans1 = Integer.toString(_1x) + "," + Integer.toString(_1y);
		String ans2 = Integer.toString(_2x) + "," + Integer.toString(_2y);
		String ans3 = Integer.toString(_3x) + "," + Integer.toString(_3y);
		String ans4 = Integer.toString(_4x) + "," + Integer.toString(_4y);
		String ans5 = Integer.toString(_5x) + "," + Integer.toString(_5y);
		String ans6 = Integer.toString(_6x) + "," + Integer.toString(_6y);
				
		
		question = "Write the coordinates (put a comma between x and y coordinates)"   ;
		
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "A"+ GR8_Constants.ANSWER_TO_QUESTION + ans1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "B"+ GR8_Constants.ANSWER_TO_QUESTION + ans2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "C"+ GR8_Constants.ANSWER_TO_QUESTION + ans3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "D"+ GR8_Constants.ANSWER_TO_QUESTION + ans4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "E"+ GR8_Constants.ANSWER_TO_QUESTION + ans5  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "F"+ GR8_Constants.ANSWER_TO_QUESTION + ans6  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		GeometryObject geo = new GeometryObject();
		List<CircleObject> circleList = new ArrayList<CircleObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		List<LineObject> lineList = new ArrayList<LineObject>();
		
		CircleObject co1= new CircleObject();
		LabelObject lo1 = new LabelObject();
		int _1x = MathUtilities.getRandomNumber(-5, -1);
		int _1y = MathUtilities.getRandomNumber(-5, -1);
		co1.setxCo(Double.valueOf(_1x));
		co1.setyCo(Double.valueOf(_1y));
		lo1.setxCo(Double.valueOf(_1x+.025));
		lo1.setyCo(Double.valueOf(_1y+.025));
		lo1.setLabelName("A");
		
		CircleObject co2= new CircleObject();
		LabelObject lo2 = new LabelObject();
		int _2x = _1x + 5;
		int _2y = _1y;
		co2.setxCo(Double.valueOf(_2x));
		co2.setyCo(Double.valueOf(_2y));
		lo2.setxCo(Double.valueOf(_2x+.025));
		lo2.setyCo(Double.valueOf(_2y+.025));
		lo2.setLabelName("B");
		
		CircleObject co3= new CircleObject();
		LabelObject lo3 = new LabelObject();
		int _3x = MathUtilities.getRandomNumber(5,10);
		int _3y = MathUtilities.getRandomNumber(5,10);
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
		
		String ans1 = Integer.toString(_1x) + "," + Integer.toString(_1y);
		String ans2 = Integer.toString(_2x) + "," + Integer.toString(_2y);
		String ans3 = Integer.toString(_3x) + "," + Integer.toString(_3y);
				
		
		question = "Write the coordinates (put a comma between x and y coordinates)"   ;
		
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "A"+ GR8_Constants.ANSWER_TO_QUESTION + ans1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "B"+ GR8_Constants.ANSWER_TO_QUESTION + ans2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "C"+ GR8_Constants.ANSWER_TO_QUESTION + ans3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	//draw a rectangle
		public Problem getProblem3(MathConfiguration mathConfig) {
			
			CreateProblem cProblem = new CreateProblem();
			Answer answ = new Answer();
			
			MessageSource mSource = mathConfig.getmSource();
			
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();

			String question="";
			
			GeometryObject geo = new GeometryObject();
			List<LabelObject> labelList = new ArrayList<LabelObject>();
			List<LineObject> lineList = new ArrayList<LineObject>();
			
			LabelObject lo1 = new LabelObject();
			int _1x = MathUtilities.getRandomNumber(-5, -1);
			int _1y = MathUtilities.getRandomNumber(0,5);
			lo1.setxCo(Double.valueOf(_1x+.025));
			lo1.setyCo(Double.valueOf(_1y+.025));
			lo1.setLabelName("A");
			
			LabelObject lo2 = new LabelObject();
			int _2x = _1x + 5;
			int _2y = _1y;
			lo2.setxCo(Double.valueOf(_2x+.025));
			lo2.setyCo(Double.valueOf(_2y+.025));
			lo2.setLabelName("B");
			
			LabelObject lo3 = new LabelObject();
			int _3x = _1x;
			int _3y = _1y+5;
			lo3.setxCo(Double.valueOf(_3x+.025));
			lo3.setyCo(Double.valueOf(_3y+.025));
			lo3.setLabelName("C");
			
			LabelObject lo4 = new LabelObject();
			int _4x = _2x;
			int _4y = _3y;
			lo4.setxCo(Double.valueOf(_4x+.025));
			lo4.setyCo(Double.valueOf(_4y+.025));
			lo4.setLabelName("D");
			
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
			ln3.setX1(Double.valueOf(_3x));
			ln3.setX2(Double.valueOf(_4x));
			ln3.setY1(Double.valueOf(_3y));
			ln3.setY2(Double.valueOf(_4y));
			
			LineObject ln4 = new LineObject();
			ln4.setX1(Double.valueOf(_2x));
			ln4.setX2(Double.valueOf(_4x));
			ln4.setY1(Double.valueOf(_2y));
			ln4.setY2(Double.valueOf(_4y));
			
			lineList.add(ln1);
			lineList.add(ln2);
			lineList.add(ln3);
			lineList.add(ln4);
			geo.setLines(lineList);
					
			labelList.add(lo1);
			labelList.add(lo2);
			labelList.add(lo3);
			labelList.add(lo4);
			geo.setLabels(labelList);
			
			String ans1 = Integer.toString(_1x) + "," + Integer.toString(_1y);
			String ans2 = Integer.toString(_2x) + "," + Integer.toString(_2y);
			String ans3 = Integer.toString(_3x) + "," + Integer.toString(_3y);
			String ans4 = Integer.toString(_4x)	+ "," + Integer.toString(_4y);
			String ans5 = Double.toString((double)(_3x+_4x)/2)	+ "," + Integer.toString(_4y);
			String ans6 = Double.toString(_2x);
			String ans7 = Double.toString(_4y);
			String ans8 = Double.toString(_1x)	+ "," + Double.toString((double)(_1y+_3y)/2);
			
			question = "Write the coordinates (put a comma between x and y coordinates)"   ;
			
			questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			questionList.add(new QuestionLine( "A"+ GR8_Constants.ANSWER_TO_QUESTION + ans1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			questionList.add(new QuestionLine( "B"+ GR8_Constants.ANSWER_TO_QUESTION + ans2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			questionList.add(new QuestionLine( "C"+ GR8_Constants.ANSWER_TO_QUESTION + ans3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			questionList.add(new QuestionLine( "D"+ GR8_Constants.ANSWER_TO_QUESTION + ans4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			questionList.add(new QuestionLine( "Coordinate of midpoint of line CD"+ GR8_Constants.ANSWER_TO_QUESTION + ans5  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			questionList.add(new QuestionLine( "X Coordinate of any point on line BD"+ GR8_Constants.ANSWER_TO_QUESTION + ans6  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			questionList.add(new QuestionLine( "Y Coordinate of any point on line CD"+ GR8_Constants.ANSWER_TO_QUESTION + ans7  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			questionList.add(new QuestionLine( "Coordinate of mid point on line AC"+ GR8_Constants.ANSWER_TO_QUESTION + ans8  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

			String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
			answ.setAnswer("Blank");

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
			problem.setGeometryObject(geo);
			problem.setAnswer(answ);

			return problem;
		}
	
	
		//draw a rectangle
		public Problem getProblem4(MathConfiguration mathConfig) {
			
			CreateProblem cProblem = new CreateProblem();
			Answer answ = new Answer();
			
			MessageSource mSource = mathConfig.getmSource();
			
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();

			String question="";
			
			int _1x = MathUtilities.getRandomNumber(-5, -1);
			int _1y = MathUtilities.getRandomNumber(0,5);

			int _2x = _1x + 5;
			int _2y = _1y;

			int _3x = _1x;
			int _3y = _1y+5;

			int _4x = _2x;
			int _4y = _3y;
			
			String ans1 = Integer.toString(_4x) + "," + Integer.toString(_4y);

			
			question = "You have got three coordinates as: (" + Integer.toString(_1x)+ ", "+Integer.toString(_1y) +"), "
					+ "("+ Integer.toString(_2x)+ ", "+ Integer.toString(_2y) + "), "
					+ "("+ Integer.toString(_3x)+ ", "+ Integer.toString(_3y) + "). What would be the third coordinate to make it a Rectangular? ";
			
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
			answ.setAnswer(ans1);

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			//problem.setGeometryObject(geo);
			problem.setAnswer(answ);

			return problem;
		}
		
		//draw a rectangle
		public Problem getProblem5(MathConfiguration mathConfig) {
			
			CreateProblem cProblem = new CreateProblem();
			Answer answ = new Answer();
			
			MessageSource mSource = mathConfig.getmSource();
			
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();

			String question="";
			
			int _1x = MathUtilities.getRandomNumber(-5, -1);
			int _1y = MathUtilities.getRandomNumber(-5,-1);

			int _2x = _1x + 5;
			int _2y = _1y;

			int _3x = _1x;
			int _3y = _1y + MathUtilities.getRandomNumber(-5,3);

			int _4x = _2x;
			int _4y = _3y;
			
			String ans1 = Integer.toString(_2x) + "," + Integer.toString(_2y);

			
			question = "You have got three coordinates as: (" + Integer.toString(_1x)+ ", "+Integer.toString(_1y) +"), "
					+ "("+ Integer.toString(_4x)+ ", "+ Integer.toString(_4y) + "), "
					+ "("+ Integer.toString(_3x)+ ", "+ Integer.toString(_3y) + "). What would be the third coordinate to make it a Rectangular? ";
			
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
			answ.setAnswer(ans1);

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			//problem.setGeometryObject(geo);
			problem.setAnswer(answ);

			return problem;
		}
		
		//draw a rectangle
		public Problem getProblem6(MathConfiguration mathConfig) {
			
			CreateProblem cProblem = new CreateProblem();
			Answer answ = new Answer();
			
			MessageSource mSource = mathConfig.getmSource();
			
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();

			String question="";
			
			int _1x = MathUtilities.getRandomNumber(1, 5);
			int _1y = MathUtilities.getRandomNumber(1, 5);

			int _2x = _1x - 3;
			int _2y = _1y;

			int _3x = _1x;
			int _3y = _1y+3;

			int _4x = _2x;
			int _4y = _3y;
			
			String ans1 = Integer.toString(_3x) + "," + Integer.toString(_3y);

			
			question = "You have got three coordinates as: (" + Integer.toString(_1x)+ ", "+Integer.toString(_1y) +"), "
					+ "("+ Integer.toString(_4x)+ ", "+ Integer.toString(_4y) + "), "
					+ "("+ Integer.toString(_2x)+ ", "+ Integer.toString(_2y) + "). What would be the third coordinate to make it a Square? ";
			
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
			answ.setAnswer(ans1);

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
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
			List<CircleObject> circleList = new ArrayList<CircleObject>();
			List<LabelObject> labelList = new ArrayList<LabelObject>();
			List<LineObject> lineList = new ArrayList<LineObject>();
			
			CircleObject co1= new CircleObject();
			LabelObject lo1 = new LabelObject();
			int _1x = MathUtilities.getRandomNumber(-10, 20);
			int _1y = MathUtilities.getRandomNumber(-10, 20);
			co1.setxCo(Double.valueOf(_1x));
			co1.setyCo(Double.valueOf(_1y));
			lo1.setxCo(Double.valueOf(_1x+.025));
			lo1.setyCo(Double.valueOf(_1y+.025));
			lo1.setLabelName("A");
			
			CircleObject co2= new CircleObject();
			LabelObject lo2 = new LabelObject();
			int _2x = _1x + MathUtilities.getRandomNumber(-4, 4);
			int _2y = _1y;
			co2.setxCo(Double.valueOf(_2x));
			co2.setyCo(Double.valueOf(_2y));
			lo2.setxCo(Double.valueOf(_2x+.025));
			lo2.setyCo(Double.valueOf(_2y+.025));
			lo2.setLabelName("B");
						
			LineObject ln1 = new LineObject();
			ln1.setX1(Double.valueOf(_1x));
			ln1.setX2(Double.valueOf(_2x));
			ln1.setY1(Double.valueOf(_1y));
			ln1.setY2(Double.valueOf(_2y));
			
		
			lineList.add(ln1);
			geo.setLines(lineList);
			
			circleList.add(co1);
			circleList.add(co2);
			geo.setCircles(circleList);	
			
			labelList.add(lo1);
			labelList.add(lo2);
			geo.setLabels(labelList);
			
			int bRight = MathUtilities.getRandomNumber(1, 5);
			int bLeft = MathUtilities.getRandomNumber(1,5);
			int aUp = MathUtilities.getRandomNumber(1, 5);
			int aDown = MathUtilities.getRandomNumber(1, 5);
			
			String ans1 = Integer.toString(_2x+ bRight) + "," + Integer.toString(_2y);
			String ans2 = Integer.toString(_2x- bLeft) + " ," + Integer.toString(_2y);
			String ans3 = Integer.toString(_1x) + " ," + Integer.toString(_1y + aUp);
			String ans4 = Integer.toString(_1x) + " ," + Integer.toString(_1y - aDown);	
			
			question = "You have got a line AB"   ;
			
			String q1= "New coordinate when move B right by " + Integer.toString(bRight) + " towards x Axis:";
			String q2= "New Coordinate when move B left" + Integer.toString(bLeft) + " towards x Axis:";
			String q3= "Coordinate of new point when move A up" + Integer.toString(aUp) + " towards y Axis:";
			String q4= "Coordinate of new point when move A down" + Integer.toString(aDown) + " towards y Axis:";
			
			questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			questionList.add(new QuestionLine(  q1 + GR8_Constants.ANSWER_TO_QUESTION + ans1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			questionList.add(new QuestionLine(  q2 + GR8_Constants.ANSWER_TO_QUESTION + ans2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			questionList.add(new QuestionLine(  q3 + GR8_Constants.ANSWER_TO_QUESTION+ ans3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			questionList.add(new QuestionLine(  q4 + GR8_Constants.ANSWER_TO_QUESTION + ans4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
	

			String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
			answ.setAnswer("Blank");

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
			problem.setGeometryObject(geo);
			problem.setAnswer(answ);

			return problem;
		}
		
		//draw a rectangle
		public Problem getProblem8(MathConfiguration mathConfig) {
			
			CreateProblem cProblem = new CreateProblem();
			Answer answ = new Answer();
			
			MessageSource mSource = mathConfig.getmSource();
			
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();

			String question="";
			
			int _1x = MathUtilities.getRandomNumber(-5, -1);
			int _1y = MathUtilities.getRandomNumber(-5,-1);

			int _2x = _1x + 5;
			int _2y = _1y;
			
			String ans1 = Double.toString((double)(_1x+_2x)/2) + "," + Integer.toString(_1y);
			
			question = "You have got two coordinates as: (" + Integer.toString(_1x)+ ", "+Integer.toString(_1y) +"), "
					+ "("+ Integer.toString(_2x)+ ", "+ Integer.toString(_2y) + "). What would be the coordinate of mid point of the line? ";
			
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
			answ.setAnswer(ans1);

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			problem.setAnswer(answ);

			return problem;
		}
		
		//draw a rectangle
		public Problem getProblem9(MathConfiguration mathConfig) {
			
			CreateProblem cProblem = new CreateProblem();
			Answer answ = new Answer();
			
			MessageSource mSource = mathConfig.getmSource();
			
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();

			String question="";
			
			int _1x = MathUtilities.getRandomNumber(-5, -1);
			int _1y = MathUtilities.getRandomNumber(-5,-1);

			int _2x = _1x + 5;
			int _2y = _1y;
			
			int _3x= MathUtilities.getRandomNumber(5, 15);
			int _3y= MathUtilities.getRandomNumber(5, 15);
			
			String ans1 = Integer.toString(_3y);
			
			question = "You have a line AB with two coordinates as: (" + Integer.toString(_1x)+ ", "+Integer.toString(_1y) +"), "
					+ "("+ Integer.toString(_2x)+ ", "+ Integer.toString(_2y) + "). You need to draw a line CD parallel to AB. "
							+ "The coordinate of C is (" + Integer.toString(_3x) +","+ Integer.toString(_3y) +"). What should be the y Coordinate of other point?";
			
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
			answ.setAnswer(ans1);

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
			
			int _1x = MathUtilities.getRandomNumber(1,5);
			
			String ans1 = Integer.toString(_1x);
			
			question = "You need to make a line parallel to Y axis. The distance of the line is " + Integer.toString(_1x) + " units from Y Axis and intersects with X Axis."
					+ " What is the X coordinate on any point on the parallel line?";
			
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
			answ.setAnswer(ans1);

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			problem.setAnswer(answ);

			return problem;
		}

	
}
