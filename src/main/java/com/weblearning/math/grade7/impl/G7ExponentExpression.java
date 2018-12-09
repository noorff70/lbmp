package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ExponentExpression extends GenericQuestion {
	

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentExpression = new ArrayList<Problem>();
		
		for (int i = 0; i <3; i++)
			g7ExponentExpression.add(getProblem1(mathConfig));
		for (int i = 0; i <4; i++)
			g7ExponentExpression.add(getProblem2(mathConfig));
		for (int i = 0; i <3; i++)
			g7ExponentExpression.add(getProblem3(mathConfig));
		for (int i = 0; i <3; i++)
			g7ExponentExpression.add(getProblem4(mathConfig));
		for (int i = 0; i <3; i++)
			g7ExponentExpression.add(getProblem5(mathConfig));
		for (int i = 0; i <2; i++)
			g7ExponentExpression.add(getProblem6(mathConfig));
		for (int i = 0; i <2; i++)
			g7ExponentExpression.add(getProblem7(mathConfig)); 
		for (int i = 0; i <5; i++)
			g7ExponentExpression.add(getProblem8(mathConfig));
		

		return g7ExponentExpression;
	}

	/*
	 * Exponentiation
	 * This will create  a problem as 10 + 2^2 = 14
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		int base = MathUtilities.getRandomNumber(2, 8);
		int pow = MathUtilities.getRandomNumber(2,4);
		
		int a = MathUtilities.getRandomNumber(2, 100);
			
		int ans = a + (int)Math.pow(base, pow);
		String question = "$" + Integer.toString(a) + " + " + Integer.toString(base) + "^{" + Integer.toString(pow)+ "}" + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_EXPRESSION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Exponentiation
	 * This will create  a problem as 10 + 2^2 = 14
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		int base = MathUtilities.getRandomNumber(2, 8);
		int pow = MathUtilities.getRandomNumber(2,4);
		
		int a = MathUtilities.getRandomNumber(-50, -2);
			
		int ans = a + (int)Math.pow(base, pow);
		String question = "$" + Integer.toString(a) + " + " + Integer.toString(base) + "^{" + Integer.toString(pow)+ "}" + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_EXPRESSION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Exponentiation
	 * This will create  a problem as 10 + 2^2 = 14
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		int base = MathUtilities.getRandomNumber(2, 8);
		int pow = MathUtilities.getRandomNumber(2,4);
		
		int base1 = MathUtilities.getRandomNumber(2, 8);
		int pow1 = MathUtilities.getRandomNumber(2,4);
			
		int ans = (int)Math.pow(base1, pow1) + (int)Math.pow(base, pow);
		String question = "$" + Integer.toString(base1) + "^{" + Integer.toString(pow1)+ "}" + " + " + Integer.toString(base) + "^{" + Integer.toString(pow)+ "}" + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_EXPRESSION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Exponentiation
	 * This will create  a problem as 10 + 2^2 = 14
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		int base = MathUtilities.getRandomNumber(2, 8);
		int pow = MathUtilities.getRandomNumber(2,4);
		
		int base1 = MathUtilities.getRandomNumber(2, 8);
		int pow1 = MathUtilities.getRandomNumber(2,4);
			
		int ans = (int)Math.pow(base1, pow1) - (int)Math.pow(base, pow);
		String question = "$" + Integer.toString(base1) + "^{" + Integer.toString(pow1)+ "}" + " - " + Integer.toString(base) + "^{" + Integer.toString(pow)+ "}" + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_EXPRESSION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Exponentiation
	 * This will create  a problem as 10 + 2^2 = 14
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		int base = MathUtilities.getRandomNumber(-5, -2);
		int pow = 3;
		
		int base1 = MathUtilities.getRandomNumber(2, 8);
		int pow1 = MathUtilities.getRandomNumber(2,4);
			
		int ans = (int)Math.pow(base1, pow1) - (int)Math.pow(base, pow);
		String question = "$" + Integer.toString(base1) + "^{" + Integer.toString(pow1)+ "}" + " - (" + Integer.toString(base) + ")^{" + Integer.toString(pow)+ "}" + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_EXPRESSION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Exponentiation
	 * This will create  a problem as 10 + 2^2 = 14
	 */
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		int base = 0;
		int pow = MathUtilities.getRandomNumber(2,  5);
		
		int base1 = MathUtilities.getRandomNumber(2, 8);
		int pow1 = MathUtilities.getRandomNumber(2,4);
			
		int ans = (int)Math.pow(base1, pow1) - (int)Math.pow(base, pow);
		String question = "$" + Integer.toString(base1) + "^{" + Integer.toString(pow1)+ "}" + " - (" + Integer.toString(base) + ")^{" + Integer.toString(pow)+ "}" + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_EXPRESSION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Exponentiation
	 * This will create  a problem as 10 + 2^2 = 14
	 */
	public Problem getProblem7(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		int base = 1;
		int pow = MathUtilities.getRandomNumber(2,  4);
		
		int base1 = MathUtilities.getRandomNumber(2, 8);
		int pow1 = MathUtilities.getRandomNumber(2,4);
			
		int ans = (int)Math.pow(base1, pow1) + (int)Math.pow(base, pow);
		String question = "$" + Integer.toString(base1) + "^{" + Integer.toString(pow1)+ "}" + " + " + Integer.toString(base) + "^{" + Integer.toString(pow)+ "}" + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_EXPRESSION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Exponentiation
	 * This will create  a problem as 10 + 2^2 = 14
	 */
	public Problem getProblem8(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		int pow = MathUtilities.getRandomNumber(2,  4);
		
		
		int a = MathUtilities.getRandomNumber(-2, -5);
		int b = MathUtilities.getRandomNumber(2,  8);
		
		int c = MathUtilities.getRandomNumber(2, 50);
			
		int ans = (int)Math.pow(a+b, pow) + c;
		String question = "$(" + Integer.toString(a) + " + " + Integer.toString(b) +")^{" + Integer.toString(pow) + "} + " + Integer.toString(c) +"$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_EXPRESSION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(ans));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	

}
