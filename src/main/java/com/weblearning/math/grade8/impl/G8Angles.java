package com.weblearning.math.grade8.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8Angles extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8Angles.class);
	private RestMathClientService restMathClient;

	public List<?> getQuestions(MathConfiguration mathConfig) {
		
	
		
		List<Problem> g8P1Peremeter = new ArrayList<Problem>();
		
		for (int i = 0; i < 1; i++)
			g8P1Peremeter.add(getProblem1(mathConfig));
		for (int i = 0; i < 1; i++)
			g8P1Peremeter.add(getProblem2(mathConfig)); 
		for (int i = 0; i < 1; i++)
			g8P1Peremeter.add(getProblem4(mathConfig));
		for (int i = 0; i < 1; i++)
			g8P1Peremeter.add(getProblem3(mathConfig));
		
		restMathClient = new RestMathClientServiceImpl();
		g8P1Peremeter = restMathClient.returnAnswerList(g8P1Peremeter);
		
		return g8P1Peremeter;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();
		
		//first coordinate (x= -2 to 6, y=0)
		int c1X = MathUtilities.getRandomNumber(-2, 6); 
		int c1Y = 0;
		
		//second coordinate 
		int c2X = c1X + MathUtilities.getRandomNumber(2, 5); 
		int c2Y = 6; //MathUtilities.getRandomNumber(4, 6); 
		
		int c3X = c1X + 5;
		int c3Y = 0;
		
		
		//example coordinates- A(1,0), B(6,0), C(6,6)
		String line1 = "[" + c1X + "," + c3X + "], [" + c1Y + "," + c3Y + "]";
		String line2 = "[" + c1X + "," + c2X + "], [" + c1Y + "," + c2Y + "]";
		String line3 = "[" + c2X + "," + c3X + "], [" + c2Y + "," + c3Y + "]";
		
		
		String coordinateLabelA, coordinateLabelB, coordinateLabelC = "";
		String cAngleLabelA, cAngleLabelB, cAngleLabelC = "";

		coordinateLabelA = "[" + getXYLabels(c1X, "Left_X") + "," + getXYLabels(c1Y, "Left_Y") + "]";
		coordinateLabelC = "[" + getXYLabels(c2X, "Right_X") + "," + getXYLabels(c2Y, "Right_Y") + "]";
		coordinateLabelB = "[" + getXYLabels(c3X, "Center_X") + "," + getXYLabels(c3Y, "Upper_Y") + "]";
		
		cAngleLabelA = "[" + getCoordinate(c1X, "Left_X") + "," + getCoordinate(c1Y, "Left_Y") + "]";
		cAngleLabelB = "[" + getCoordinate(c2X, "Right_X") + "," + getCoordinate(c2Y, "Right_Y") + "]";
		cAngleLabelC = "[" + getCoordinate(c3X, "Center_X") + "," + getCoordinate(c3Y, "Upper_Y") + "]";
		
		String noLabel = "'x'";
		
		String angleA = dotProductAngle(c1X, c3X, c1Y, c3Y, c1X, c2X, c1Y, c2Y); //line1, line2
		String angleB = dotProductAngle(c1X, c3X, c1Y, c3Y, c2X, c3X, c2Y, c3Y); //line 1, line3
		String angleC = dotProductAngle(c1X, c2X, c1Y, c2Y, c2X, c3X, c2Y, c3Y); // line2, kine3
		
		/* this will show the angles
		 * first one is a coordinate for angle position represented as [x coordinate][y coordinate],
		 * second parameter is the label to be shown,
		 * third one is the actual angle
		 */
		String angle1 = cAngleLabelA + "," + angleA + "," + angleA  ; //line 1 and line 2
		String angle2 = cAngleLabelB + "," + noLabel + "," + angleC; //line 3 and line 2
		String angle3 = cAngleLabelC + "," + angleB + "," + angleB; //line 1 and line 3
		
		
		String xAxisRange = getAxisRange(c1X, "Left_X") + "," + getAxisRange(c3X, "Right_X") +  "," + getAxisRange(c3Y, "Lower_Y") + "," + getAxisRange(c2Y, "Upper_Y");
		
		// coordinate tells the position of label
		String labelA = coordinateLabelA + "," + "'A'";
		String labelB = coordinateLabelB + "," + "'B'";
		String labelC = coordinateLabelC + "," + "'C'";
		
		// System.out.println(line1 + " " + line2 + " " + line3);;
		question = "<linebeg>" + line1 + "line" + line2 + "line" + line3 + "<lineend>" +
				"<anglesbeg>" + angle1 + "angle" + angle2 + "angle" + angle3 + "<anglesend>" + "" +
				"<vertexbeg>"+ labelA + "vertice" + labelB + "vertice" + labelC + "<vertexend>" +
				"<xyLimitbeg>" + xAxisRange + "<xyLimitend>";
		

		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X , null, Locale.ENGLISH), null, Constants.LATEX_FORMAT));
	
		answer.setAnswer("Blank");

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();
		
		//first coordinate (x= -2 to 6, y=0)
		int c1X = MathUtilities.getRandomNumber(-2, 6); 
		int c1Y = 0;
		
		//second coordinate 
		int c2X = c1X + MathUtilities.getRandomNumber(2, 5); 
		int c2Y = MathUtilities.getRandomNumber(4, 6); 
		
		int c3X = c2X;
		int c3Y = 0;
		
		
		//this is passed to a Python to be used in pyplot. The coordinates work as follows line1= (1,0) and (6,0). line2 =(1,0) and (3,6)
		String line1 = "[" + c1X + "," + c3X + "], [" + c1Y + "," + c3Y + "]";
		//String line1 = "[1,6], [0,0]";
		String line2 = "[" + c1X + "," + c2X + "], [" + c1Y + "," + c2Y + "]";
		//String line2 = "[1,3], [0,6]";
		String line3 = "[" + c2X + "," + c3X + "], [" + c2Y + "," + c3Y + "]";
		//String line3 = "[3,6], [6,0]";
		
		//float xCoordinateA, yCoordinateA, xCoordinateB, yCoordinateB = 0;
		
		String coordinateLabelA, coordinateLabelB, coordinateLabelC = "";
		String cAngleLabelA, cAngleLabelB, cAngleLabelC = "";

		coordinateLabelA = "[" + getXYLabels(c1X, "Left_X") + "," + getXYLabels(c1Y, "Left_Y") + "]";
		coordinateLabelC = "[" + getXYLabels(c2X, "Right_X") + "," + getXYLabels(c2Y, "Right_Y") + "]";
		coordinateLabelB = "[" + getXYLabels(c3X, "Center_X") + "," + getXYLabels(c3Y, "Upper_Y") + "]";
		
		cAngleLabelA = "[" + getCoordinate(c1X, "Left_X") + "," + getCoordinate(c1Y, "Left_Y") + "]";
		cAngleLabelB = "[" + getCoordinate(c2X, "Right_X") + "," + getCoordinate(c2Y, "Right_Y") + "]";
		cAngleLabelC = "[" + getCoordinate(c3X, "Center_X") + "," + getCoordinate(c3Y, "Upper_Y") + "]";
		
		String noLabel = "'x'";
		
		String angleA = dotProductAngle(c1X, c3X, c1Y, c3Y, c1X, c2X, c1Y, c2Y); //line1, line2
		String angleB = dotProductAngle(c1X, c3X, c1Y, c3Y, c2X, c3X, c2Y, c3Y); //line 1, line3
		String angleC = dotProductAngle(c1X, c2X, c1Y, c2Y, c2X, c3X, c2Y, c3Y); // line2, kine3
		
		/* this will show the angles
		 * first one is a coordinate for angle position represented as [x coordinate][y coordinate],
		 * second parameter is the label to be shown,
		 * third one is the actual angle
		 */
		String angle1 = cAngleLabelA + "," + angleA + "," + angleA  ; //line 1 and line 2
		String angle2 = cAngleLabelB + "," + noLabel + "," + angleC; //line 3 and line 2
		String angle3 = cAngleLabelC + "," + angleB + "," + angleB; //line 1 and line 3
		
		
		String xAxisRange = getAxisRange(c1X, "Left_X") + "," + getAxisRange(c3X, "Right_X") +  "," + getAxisRange(c3Y, "Lower_Y") + "," + getAxisRange(c2Y, "Upper_Y");
		
		// coordinate tells the position of label
		String labelA = coordinateLabelA + "," + "'A'";
		String labelB = coordinateLabelB + "," + "'B'";
		String labelC = coordinateLabelC + "," + "'C'";
		
		System.out.println(line1 + " " + line2 + " " + line3);;
		question = "<linebeg>" + line1 + "line" + line2 + "line" + line3 + "<lineend>" +
				"<anglesbeg>" + angle1 + "angle" + angle2 + "angle" + angle3 + "<anglesend>" + "" +
				"<vertexbeg>"+ labelA + "vertice" + labelB + "vertice" + labelC + "<vertexend>" +
				"<xyLimitbeg>" + xAxisRange + "<xyLimitend>";
		

		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X , null, Locale.ENGLISH), null, Constants.LATEX_FORMAT));
	
		answer.setAnswer("Blank");

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();
		

		int aX = -3; 
		int aY = -1;
		
		int bX = 2; 
		int bY = 4; 
		
		int cX = 0;
		int cY = 2;
		
		int dX = 4;
		int dY = 0;
		
		int eX = 1;
		int eY = -2;
		
		
		//this is passed to a Python to be used in pyplot. The coordinates work as follows line1= (1,0) and (6,0). line2 =(1,0) and (3,6)
		String line1 = "[" + aX + "," + bX + "], [" + aY + "," + bY + "]";
		String line2 = "[" + cX + "," + eX + "], [" + cY + "," + eY + "]";
		String line3 = "[" + cX + "," + dX + "], [" + cY + "," + dY + "]";

		
		String coordinateLabelA, coordinateLabelB, coordinateLabelC = "";
		String cAngleLabelA, cAngleLabelB, cAngleLabelC= "";

		coordinateLabelA = "[" + getXYLabels(aX, "Left_X") + "," + getXYLabels(aY, "Left_Y") + "]";
		coordinateLabelB = "[" + getXYLabels(bX, "Right_X") + "," + getXYLabels(bY, "Right_Y") + "]";
		coordinateLabelC = "[" + getXYLabels(cX, "Center_X") + "," + getXYLabels(cY, "Upper_Y") + "]";

		
		cAngleLabelA = "[-1.2" + "," + ".5" + "]";
		cAngleLabelB = "[1" + "," + "2" + "]";
		cAngleLabelC = "[.75" + "," + "1" + "]";

		
		String noLabel = "'x'";
		
		String angleA = "59.04"; 
		String angleB = "71.57";
		String angleC = "49.39";
		
		/* this will show the angles
		 * first one is a coordinate for angle position represented as [x coordinate][y coordinate],
		 * second parameter is the label to be shown,
		 * third one is the actual angle
		 */
		String angle1 = cAngleLabelA + "," + angleA + "," + angleA  ; //line 1 and line 2
		String angle2 = cAngleLabelC + "," + noLabel + "," + angleC; //line 3 and line 2
		String angle3 = cAngleLabelB + "," + angleB + "," + angleB; //line 1 and line 3
		
		
		String xAxisRange = getAxisRange(-5, "Left_X") + "," + getAxisRange(6, "Right_X") +  "," + getAxisRange(-3, "Lower_Y") + "," + getAxisRange(5, "Upper_Y");
		
		// coordinate tells the position of label
		String labelA = coordinateLabelA + "," + "'A'";
		String labelB = coordinateLabelB + "," + "'B'";
		String labelC = coordinateLabelC + "," + "'C'";
		
		System.out.println(line1 + " " + line2 + " " + line3);;
		question = "<linebeg>" + line1 + "line" + line2 + "line" + line3 + "<lineend>" +
				"<anglesbeg>" + angle1 + "angle" + angle2 + "angle" + angle3 + "<anglesend>" + "" +
				"<vertexbeg>"+ labelA + "vertice" + labelB + "vertice" + labelC + "<vertexend>" +
				"<xyLimitbeg>" + xAxisRange + "<xyLimitend>";
		

		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X , null, Locale.ENGLISH), null, Constants.LATEX_FORMAT));
	
		answer.setAnswer("Blank");

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		String question = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();
		

		double aX =  4.42; 
		double aY = 5.04;
		
		double bX = 8.06; 
		double bY = 1.22; 
		
		double cX = 6.24;
		double cY = 3.13;
		
		double dX = 3.0;
		double dY = 3.0;
		
		double eX = 6;
		double eY = 0;
		
		double fX = 2.3;
		double fY = 3.64;
		
		double gX = 7.3;
		double gY = -1.2;
		
		
		//this is passed to a Python to be used in pyplot. The coordinates work as follows line1= (1,0) and (6,0). line2 =(1,0) and (3,6)
		String line1 = "[" + aX + "," + bX + "], [" + aY + "," + bY + "]";
		String line2 = "[" + fX + "," + gX + "], [" + fY + "," + gY + "]";
		String line3 = "[" + cX + "," + dX + "], [" + cY + "," + dY + "]";
		String line4 = "[" + cX + "," + eX + "], [" + cY + "," + eY + "]";

		
		String coordinateLabelA, coordinateLabelB, coordinateLabelC, coordinateLabelD, coordinateLabelE, coordinateLabelF, coordinateLabelG = "";
		String cAngleLabelCDE ="";

		coordinateLabelA = "[" + getXYLabels(aX, "Left_X") + "," + getXYLabels(aY, "Left_Y") + "]";
		coordinateLabelB = "[" + getXYLabels(bX, "Right_X") + "," + getXYLabels(bY, "Right_Y") + "]";
		coordinateLabelC = "[" + getXYLabels(cX, "Center_X") + "," + getXYLabels(cY, "Upper_Y") + "]";
		coordinateLabelD = "[" + getXYLabels(dX, "Left_X") + "," + getXYLabels(dY, "Upper_Y") + "]";
		coordinateLabelE = "[" + getXYLabels(eX, "Right_X") + "," + getXYLabels(eY, "Right_Y") + "]";
		coordinateLabelF = "[" + getXYLabels(fX, "Left_X") + "," + getXYLabels(fY, "Upper_Y") + "]";
		coordinateLabelG = "[" + getXYLabels(gX, "Right_X") + "," + getXYLabels(gY, "Upper_Y") + "]";

		dX = dX + .5;
		dY = dY-.5;
		
		cAngleLabelCDE = "[" + dX +  "," + dY + "]";

		String angleCDE = Double.toString(MathUtilities.convertToDecimal(MathUtilities.getRandomNumber(4800, 5100), 2));
		
		/* this will show the angles
		 * first one is a coordinate for angle position represented as [x coordinate][y coordinate],
		 * second parameter is the label to be shown,
		 * third one is the actual angle
		 */
		
		String angle1 = cAngleLabelCDE + "," + angleCDE + "," + angleCDE  ; //line 1 and line 2
		
		String xAxisRange = getAxisRange(fX-2, "Left_X") + "," + getAxisRange(bX +2, "Right_X") +  "," + getAxisRange(gY-2, "Lower_Y") + "," + getAxisRange(aY+2, "Upper_Y");
		
		// coordinate tells the position of label
		String labelA = coordinateLabelA + "," + "'A'";
		String labelB = coordinateLabelB + "," + "'B'";
		String labelC = coordinateLabelC + "," + "'C'";
		String labelD = coordinateLabelD + "," + "'D'";
		String labelE = coordinateLabelE + "," + "'E'";
		String labelF = coordinateLabelF + "," + "'F'";
		String labelG = coordinateLabelG + "," + "'G'";
		
		System.out.println(line1 + " " + line2 + " " + line3);;
		question = "<linebeg>" + line1 + "line" + line2 + "line" + line3 + "line" + line4 + "<lineend>" +
				"<anglesbeg>" + angle1  + "<anglesend>" +
				"<vertexbeg>"+ labelA + "vertice" + labelB + "vertice" + labelC + "vertice" + labelD + "vertice" + labelE + "vertice" + labelF + "vertice" + labelG +"<vertexend>" +
				"<xyLimitbeg>" + xAxisRange + "<xyLimitend>";
		
		String answerOne = angleCDE;
		String answerTwo = String.valueOf(180 - 2* Double.valueOf(angleCDE));
		String answerThree = String.valueOf(180 - Double.valueOf(angleCDE) );
		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
		questionList.add(new QuestionLine( mSource.getMessage(GR8_Constants.QUESTION_FOUR, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( mSource.getMessage(GR8_Constants.QUESTION_FOUR_ONE, null, Locale.ENGLISH) + GR8_Constants.ANSWER_TO_QUESTION + answerOne ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( mSource.getMessage(GR8_Constants.QUESTION_FOUR_TWO , null, Locale.ENGLISH) + GR8_Constants.ANSWER_TO_QUESTION + answerTwo, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( mSource.getMessage(GR8_Constants.QUESTION_FOUR_THREE, null, Locale.ENGLISH) + GR8_Constants.ANSWER_TO_QUESTION  + answerThree, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
	
		answer.setAnswer("Blank");

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answer);

		return problem;
	}
	
	String getCoordinate(int coordinate, String type) {
		
		float c =0;
		
		if (type.equals("Left_X")) {
			c = (float) (coordinate +.5);
		}
		else if (type.equals("Right_X")) {
			c = (float) (coordinate -.75);
		}
		else if (type.equals("Center_X")) {
			c = (float) (coordinate);
		}
		else if (type.equals("Left_Y")) {
			c = (float) (coordinate + .25);
		}
		else if (type.equals("Right_Y")) {
			c = (float) (coordinate + .25);
		}
		else if (type.equals("Upper_Y")) {
			c = (float)(coordinate - .5);
		}
		else if (type.equals("Lower_Y")) {
			c = (float)(coordinate + .5);
		}
		
		return String.valueOf(c);
	}
	
	
	double getAxisRange(double coordinate, String type) {
		
		if (type.equals("Left_X")) {
			coordinate = coordinate -2;  
		} else if (type.equals("Right_X")) {
			coordinate = coordinate + 2;  
		}else if (type.equals("Lower_Y")) {
			coordinate = coordinate -2;
		} else if (type.equals("Upper_Y")) {
			coordinate = coordinate + 2;
		}
		return coordinate;	
		
	}
	
	String getXYLabels (double coordinate, String type) {
		
		float c =0;
		
		if (type.equals("Left_X")) {
			c = (float) (coordinate -.25);
		}
		else if (type.equals("Right_X")) {
			c = (float) (coordinate +.25);
		}
		else if (type.equals("Center_X")) {
			c = (float) (coordinate);
		}
		else if (type.equals("Left_Y")) {
			c = (float) (coordinate);
		}
		else if (type.equals("Right_Y")) {
			c = (float) (coordinate);
		}
		else if (type.equals("Upper_Y")) {
			c = (float)(coordinate + .25);
		}
		else if (type.equals("Lower_Y")) {
			c = (float)(coordinate - .25);
		}
		
		return String.valueOf(c);
	}
	
	String dotProductAngle (int l1x1, int l1x2, int l1y1, int l1y2, int l2x1, int l2x2, int l2y1, int l2y2) {
		
		double dx1 = l1x2-l1x1;
		double dy1 = l1y2-l1y1;
		double dx2 = l2x2-l2x1;
		double dy2 = l2y2-l2y1;

		double d = dx1*dx2 + dy1*dy2;   // dot product of the 2 vectors
		double l2 = (dx1*dx1+dy1*dy1)*(dx2*dx2+dy2*dy2); // product of the squared lengths

		double angle = Math.acos(d/Math.sqrt(l2));
		angle = angle * 180/Math.PI;
		
		if (angle > 90)
			angle = 180-angle;
		
		BigDecimal bd = new BigDecimal(angle);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
		
		return String.valueOf(bd);
	}
	
}
