package com.weblearning.math.grade8.impl;

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
		
		for (int i = 0; i < 5; i++)
			g8P1Peremeter.add(getProblem1(mathConfig));
		
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
		
		int c1X = MathUtilities.getRandomNumber(1, 6);
		int c1Y = 0;
		
		int c2X = c1X + MathUtilities.getRandomNumber(2, 5);
		int c2Y = MathUtilities.getRandomNumber(4, 6);
		
		int c3X = c1X + 5;
		int c3Y = 0;
		
		
		//this is passed to a Python to be used in pyplot. The coordinates work as follows line1= (1,0) and (6,0). line2 =(1,0) and (3,6)
		//String line1 = "[" + c1X + "," + c2X + "], [" + c1Y + "," + c2Y + "]";
		String line1 = "[1,6], [0,0]";
		//String line2 = "[" + c1X + "," + c2X + "], [" + c1Y + "," + c2Y + "]";
		String line2 = "[1,3], [0,6]";
		//String line3 = "[" + c2X + "," + c3X + "], [" + c2Y + "," + c3Y + "]";
		String line3 = "[3,6], [6,0]";
		
		/* first four coordinates make two lines that make up the angles, fourth one tells the position of the angle
			where it will be displayed, fifth one tells if the angle to be show on UI. If there is 1 then show the angle
		 */
		String angle1 = "[1,6], [0,0], [1,3], [0,6], [1.5,.25], [1]"; //line 1 and line 2
		String angle2 = "[3,6], [6,0], [1,6], [0,0], [5.5,.25], [1]"; //line 3 and line 1
		String angle3 = "[3,6], [6,0], [1,3], [0,6], [3,5.5], 'x'"; //line 2 and line 3
		
		// coordinate tells the position of label
		String labelA = "[.75,.25], 'A'";
		String labelB = "[3,6.5], 'B'";
		String labelC = "[6.25,.25],'C'";
		
		
		question = "<linebeg>" + line1 + "line" + line2 + "line" + line3 + "<lineend>" +
				"<anglesbeg>" + angle1 + "angle" + angle2 + "angle" + angle3 + "<anglesend>" + "" +
				"<vertexbeg>"+ labelA + "vertice" + labelB + "vertice" + labelC + "<vertexend>";
		

		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X , null, Locale.ENGLISH), null, Constants.LATEX_FORMAT));
	
		answer.setAnswer("Blank");

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answer);

		return problem;
	}
	
}
