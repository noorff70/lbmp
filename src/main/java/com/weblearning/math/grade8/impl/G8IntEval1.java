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
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8IntEval1 extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8IntEval1.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> g8SqrInteger = new ArrayList<Problem>();
		
		for (int i = 0; i < 5; i++)
			g8SqrInteger.add(getProblem1(mathConfig));
		
		for (int i = 0; i < 5; i++)
			g8SqrInteger.add(getProblem2(mathConfig));
		
		for (int i = 0; i < 5; i++)
			g8SqrInteger.add(getProblem3(mathConfig));
		
		for (int i = 0; i < 5; i++)
			g8SqrInteger.add(getProblem4(mathConfig));
		
		for (int i = 0; i < 5; i++)
			g8SqrInteger.add(getProblem5(mathConfig));


		return g8SqrInteger;
	}

	
	/*
	 * -4/2 + 4/2 = 0
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answ = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-10, -2);
		int x2 = x1 * MathUtilities.getRandomNumber(2, 5);
		
		int x3 = MathUtilities.getRandomNumber(10, 10);
		int x4 = x3 * MathUtilities.getRandomNumber(2, 5);
		
		

		question = Integer.toString(x2) + "$\\div" +  Integer.toString(Math.abs(x1)) + " + " + Integer.toString(x4) + "\\div" + Integer.toString(x3) + "$";
		int ans = x2/Math.abs(x1) + x4/x3;
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(ans));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 *  -4/(-2) - 2* 4 = -6
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answ = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-10, -2);
		int x2 = x1 * MathUtilities.getRandomNumber(10, 2);
		
		int x3 = MathUtilities.getRandomNumber(10, 10);
		int x4 = x3 * MathUtilities.getRandomNumber(2, 5);

		question = Integer.toString(x2) + "$\\div(" +  Integer.toString(x1) + ") - " + Integer.toString(x4) + "\\times" + Integer.toString(x3) + "$";
		int ans = x2/x1 - x4*x3;
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(ans));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));;

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * 9*10 + 20/10 = 92
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answ = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(2, 10);
		int x2 = MathUtilities.getRandomNumber(5, 15);
		
		int x3 = MathUtilities.getRandomNumber(3, 10);
		int x4 = x3 * MathUtilities.getRandomNumber(2, 5);
		

		question = Integer.toString(x2) + "$\\times" +  Integer.toString(x1) + " + " + Integer.toString(x4) + "\\div" + Integer.toString(x3) + "$";
		int ans = x2*x1 + x4/x3;
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(ans));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * 15*10 + 10/(-5) = 145
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answ = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(2, 10);
		int x2 = MathUtilities.getRandomNumber(5, 15);
		
		int x3 = MathUtilities.getRandomNumber(-10, -3);
		int x4 = Math.abs(x3 * MathUtilities.getRandomNumber(2, 5));
	
		question = Integer.toString(x2) + "$\\times" +  Integer.toString(x1) + " + " + Integer.toString(x4) + "\\div(" + Integer.toString(x3) + ")$";
		int ans = x2*x1 + x4/x3;
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(ans));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * 6*7 - 32/(-8) = 46
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answ = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(2, 10);
		int x2 = MathUtilities.getRandomNumber(5, 15);
		
		int x3 = MathUtilities.getRandomNumber(-10, -3);
		int x4 = Math.abs(x3 * MathUtilities.getRandomNumber(2, 5));

		question = Integer.toString(x2) + "$\\times" +  Integer.toString(x1) + " - " + Integer.toString(x4) + "\\div(" + Integer.toString(x3) + ")$";
		int ans = x2*x1 - x4/x3;
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(ans));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	

}
