package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8IntEval2 extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8IntEval2.class);

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
	 * 4/2 * (2-4) % 6 + 2
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(2, 5);
		int x2 = x1 * MathUtilities.getRandomNumber(2, 5);
		
		int x3 = MathUtilities.getRandomNumber(2, 10) *2;
		int x4 = MathUtilities.getRandomNumber(x3+ 1, 20) *2;
		int x5 = x3- x4;
		
		
		Map<?, ?> factorMap = MathUtilities.getListOfFactors(Math.abs(x5));
		int x6;
		Iterator<?> it = factorMap.entrySet().iterator();
		Map.Entry<Integer, Integer> result = null;
		while (it.hasNext()) {
			result = (Entry<Integer, Integer>) it.next();
		}
		x6 = result.getKey();
		
		int x7 = MathUtilities.getRandomNumber(1, 10);

		question = Integer.toString(x2) + "$\\div" +  Integer.toString(Math.abs(x1)) + "\\times(" + Integer.toString(x3) + "-" + 
				Integer.toString(x4) + ")\\div" + Integer.toString(x6) + " + " + Integer.toString(x7) + "$";
		int ans = x2/x1 * (x3-x4)/x6 + x7;
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(ans));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, Integer.toString(ans), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
	
	/*
	 * 4/2 * (2-4) % 6 + 2
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-5, -1);
		int x2 = x1 * MathUtilities.getRandomNumber(-3, -2);
		int x3 = MathUtilities.getRandomNumber(-10, -2);
		
		Map<?, ?> factorMap = MathUtilities.getListOfFactors(Math.abs(x1*x2*x3));
		int x4;
		Iterator<?> it = factorMap.entrySet().iterator();
		Map.Entry<Integer, Integer> result = null;
		while (it.hasNext()) {
			result = (Entry<Integer, Integer>) it.next();
		}
		x4 = result.getKey();
		
		int x5 = MathUtilities.getRandomNumber(-10, -1);

		question = "$(" + Integer.toString(x1) + ")(" + Integer.toString(x2) + ")(" + Integer.toString(x3) + ")\\div" + Integer.toString(x4) + Integer.toString(x5) + "$";

		int ans = x1 * x2* x3 / x4 + x5;
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(ans));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, Integer.toString(ans), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
	/*
	 * 4/2 * (2-4) % 6 + 2
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";
		

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-5, -1);
		int x2 = x1 * MathUtilities.getRandomNumber(-3, -2);
		int x3 = MathUtilities.getRandomNumber(-10, -2);
		
		Map<?, ?> factorMap = MathUtilities.getListOfFactors(Math.abs(x1*x2*x3));
		int x4;
		Iterator<?> it = factorMap.entrySet().iterator();
		Map.Entry<Integer, Integer> result = null;
		while (it.hasNext()) {
			result = (Entry<Integer, Integer>) it.next();
		}
		x4 = result.getKey();
		x4 = -1 * x4;
		
		int x5 = MathUtilities.getRandomNumber(-10, -1);

		question = "$(" + Integer.toString(x1) + ")(" + Integer.toString(x2) + ")(" + Integer.toString(x3) + ")\\div(" + Integer.toString(x4) + ")" + Integer.toString(x5) + "$";

		int ans = x1 * x2* x3 / x4 + x5;
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(ans));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, Integer.toString(ans), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
	/*
	 * (-5)(-5)(-3)/(-5)^2 -10 = -13
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		String question = "";
		

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-5, -1);
		int x2 = x1;
		int x3 = MathUtilities.getRandomNumber(-10, -2);
		
		int x4 = x1;
		
		int x5 = MathUtilities.getRandomNumber(-10, -1);

		question = "$(" + Integer.toString(x1) + ")(" + Integer.toString(x2) + ")(" + Integer.toString(x3) + ")\\div(" + Integer.toString(x4) + ")^{2}" + Integer.toString(x5) + "$";

		int ans = x1 * x2* x3 / (x4*x4) + x5;
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(ans));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, Integer.toString(ans), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
	/*
	 * -4 + ((-5)(-10)^2)/(-5)^2 = -24
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		String question = "";
		

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-5, -1);
		int x2 = MathUtilities.getRandomNumber(-5, -2);
		
		int x3 = 0;
		int x4 = MathUtilities.getRandomNumber(-10, -1);
		
		
		Map<?, ?> factorMap = MathUtilities.getListOfFactors(Math.abs(x1*x2));
		Iterator<?> it = factorMap.entrySet().iterator();
		Map.Entry<Integer, Integer> result = null;
		while (it.hasNext()) {
			result = (Entry<Integer, Integer>) it.next();
		}
		
		x2 = x2 * Math.abs(x1);
		x3 = result.getKey() * -1;
		

		question = "$" + Integer.toString(x4) + " + ((" + Integer.toString(x1) + ")(" + Integer.toString(x2) + ")^{2} )\\div(" + Integer.toString(x3) + ")^{2}" + "$";

		int ans = x4 + x1 * x2* x2 / (x3 * x3);
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(ans));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, Integer.toString(ans), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
}
