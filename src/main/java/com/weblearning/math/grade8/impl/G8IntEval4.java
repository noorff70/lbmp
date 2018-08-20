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

public class G8IntEval4 extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8IntEval3.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> g8SqrInteger = new ArrayList<Problem>();
		
		

		for (int i = 0; i < 2; i++)
			g8SqrInteger.add(getProblem4(mathConfig));
		for (int i = 0; i < 2; i++)
			g8SqrInteger.add(getProblem5(mathConfig));
		for (int i = 0; i < 2; i++)
			g8SqrInteger.add(getProblem6(mathConfig));
		for (int i = 0; i < 2; i++)
			g8SqrInteger.add(getProblem7(mathConfig));
		for (int i = 0; i < 2; i++)
			g8SqrInteger.add(getProblem8(mathConfig));
		for (int i = 0; i < 3; i++)
			g8SqrInteger.add(getProblem9(mathConfig));
		for (int i = 0; i < 3; i++)
			g8SqrInteger.add(getProblem10(mathConfig));
		for (int i = 0; i < 3; i++)
			g8SqrInteger.add(getProblem11(mathConfig));
		
		for (int i = 0; i < 2; i++)
			g8SqrInteger.add(getProblem1(mathConfig));
		for (int i = 0; i < 2; i++)
			g8SqrInteger.add(getProblem2(mathConfig));
		for (int i = 0; i < 2; i++)
			g8SqrInteger.add(getProblem3(mathConfig));
		
		return g8SqrInteger;
	}

	
	/*
	 * 3x^2 + 9 = 201
	 */

	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x = MathUtilities.getRandomNumber(2, 10);
		int y = MathUtilities.getRandomNumber(2, 5);
		int m = MathUtilities.getRandomNumber(2, 20);
		
		int z = y* (int)Math.pow(x, 2) + m;
		
		
		question = "$" + Integer.toString(y) + "x^" + Integer.toString(2) + " + " + Integer.toString(m) + " = " + Integer.toString(z) + "$";

		ans.setAnswer(Integer.toString(x));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * 5x^2 -8 = 37
	 */

	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x = MathUtilities.getRandomNumber(2, 10);
		int y = MathUtilities.getRandomNumber(2, 5);
		int m = MathUtilities.getRandomNumber(-20, -2);
		
		int z = y* (int)Math.pow(x, 2) + m;
		
		
		question = "$" + Integer.toString(y) + "x^" + Integer.toString(2)  + Integer.toString(m) + " = " + Integer.toString(z) + "$";

		ans.setAnswer(Integer.toString(x));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * -17 -2x^2 = =49; x = 4
	 */

	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x = MathUtilities.getRandomNumber(2, 10);
		int y = MathUtilities.getRandomNumber(-5, -2);
		int m = MathUtilities.getRandomNumber(-20, -1);
		
		int z = y* (int)Math.pow(x, 2) + m;
		
		
		question = "$" + Integer.toString(m) + Integer.toString(y) + "x^" + Integer.toString(2)  + " = " + Integer.toString(z) + "$";

		ans.setAnswer(Integer.toString(x));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * -11 + 4x = 17
	 */

	public Problem getProblem4(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x = MathUtilities.getRandomNumber(2, 8);
		int y = MathUtilities.getRandomNumber(2, 6);
		int m = MathUtilities.getRandomNumber(-20, -1);
		
		int z = m + x * y;
		
		
		question = "$" + Integer.toString(m) + " + " + "x" + "\\times "+ Integer.toString(y) +" = " + Integer.toString(z) + "$";

		ans.setAnswer(Integer.toString(x));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * -10 + 3x + 49 = 60; x = 7
	 */

	public Problem getProblem5(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x = MathUtilities.getRandomNumber(2, 8);
		int y = MathUtilities.getRandomNumber(2, 6);
		int c = MathUtilities.getRandomNumber(20, 50);
		int m = MathUtilities.getRandomNumber(-20, -1);
		
		int z = m + x * y + c;
		
		
		question = "$" + Integer.toString(m) + " + "+ Integer.toString(y) + "\\times "+ " x + " + Integer.toString(c) +" = " + Integer.toString(z) + "$";

		ans.setAnswer(Integer.toString(x));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * -16 -5x + 34 = 3; x = 3
	 */

	public Problem getProblem6(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x = MathUtilities.getRandomNumber(2, 5);
		int y = MathUtilities.getRandomNumber(-6, -2);
		int c = MathUtilities.getRandomNumber(20, 50);
		int m = MathUtilities.getRandomNumber(-20, -1);
		
		int z = m + x * y + c;
		
		
		question = "$" + Integer.toString(m) + "  " +Integer.toString(y) + "\\times" + " x + " + Integer.toString(c) +" = " + Integer.toString(z) + "$";

		ans.setAnswer(Integer.toString(x));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * -17 + x * (-6) + 43 = 44; x = -3 
	 */

	public Problem getProblem7(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x = MathUtilities.getRandomNumber(-8, -1);
		int y = MathUtilities.getRandomNumber(-6, -2);
		int c = MathUtilities.getRandomNumber(20, 50);
		int m = MathUtilities.getRandomNumber(-20, -1);
		
		int z = m + x * y + c;
		
		
		question = "$" + Integer.toString(m) + " + " + "x" + "\\times(" + Integer.toString(y) +") + " + Integer.toString(c) + " = " + Integer.toString(z) + "$";

		ans.setAnswer(Integer.toString(x));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * -17 + x * (-6) + 43 = 44; x = -3 
	 */

	public Problem getProblem8(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x = MathUtilities.getRandomNumber(1, 8);
		int y = MathUtilities.getRandomNumber(-6, -2);
		int c = MathUtilities.getRandomNumber(20, 50);
		int m = MathUtilities.getRandomNumber(-20, -1);
		
		int z = m + (-x) * y + c;
		
		
		question = "$" + Integer.toString(z)+  "=" + Integer.toString(m) + " + " + "(-x)" + "\\times(" + Integer.toString(y) +") + " + Integer.toString(c) +  "$";

		ans.setAnswer(Integer.toString(x));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 *14 = -19 + 6 / (x) + 30; x = 2 
	 */

	public Problem getProblem9(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x = MathUtilities.getRandomNumber(1, 8);
		int y = x * MathUtilities.getRandomNumber(2, 6);
		int c = MathUtilities.getRandomNumber(20, 50);
		int m = MathUtilities.getRandomNumber(-20, -1);
		
		int z = m + y/x + c;
		
		
		question = "$" + Integer.toString(z)+  "=" + Integer.toString(m) + " + " + Integer.toString(y) + "\\div(" + "x) +" + Integer.toString(c) +  "$";

		ans.setAnswer(Integer.toString(x));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 *8 = -17 + (-8) / (-x) + 23; x = 4
	 */

	public Problem getProblem10(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x = MathUtilities.getRandomNumber(-8, -2);
		int y = x * MathUtilities.getRandomNumber(2, 6);
		int c = MathUtilities.getRandomNumber(20, 50);
		int m = MathUtilities.getRandomNumber(-20, -1);
		
		int z = m + y/x + c;
		
		
		question = "$" + Integer.toString(z)+  "=" + Integer.toString(m) + " + (" + Integer.toString(y) + ")\\div(" + "-x) +" + Integer.toString(c) +  "$";

		ans.setAnswer(Integer.toString(Math.abs(x)));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 *8 = -17 + (-8) / (-x) + 23; x = 4
	 */

	public Problem getProblem11(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int y = MathUtilities.getRandomNumber(-6, -2);
		int x = y * MathUtilities.getRandomNumber(2, 4); 
		int c = MathUtilities.getRandomNumber(20, 50);
		int m = MathUtilities.getRandomNumber(10, 50);
		
		int z = m + x/y + c;
		
		
		question = "$"  + Integer.toString(m) + " + (x)" + "\\div(" + Integer.toString(y) + ") +" + Integer.toString(c) + " = " + Integer.toString(z)+ "$";

		ans.setAnswer(Integer.toString(x));

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(ans);

		return problem;
	}
	
		
}
