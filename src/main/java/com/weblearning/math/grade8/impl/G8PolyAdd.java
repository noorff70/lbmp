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

public class G8PolyAdd extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8PolyAdd.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> gExponentBasics = new ArrayList<Problem>();
		
		for (int i = 0; i < 2; i++)
			gExponentBasics.add(getProblem1(mathConfig));
		
		for (int i = 0; i < 2; i++)
			gExponentBasics.add(getProblem2(mathConfig));
		
		for (int i = 0; i < 2; i++)
			gExponentBasics.add(getProblem3(mathConfig));
		
		for (int i = 0; i < 3; i++)
			gExponentBasics.add(getProblem4(mathConfig));
		
		for (int i = 0; i < 4; i++)
			gExponentBasics.add(getProblem5(mathConfig));

		for (int i = 0; i < 4; i++)
			gExponentBasics.add(getProblem6(mathConfig));
		
		for (int i = 0; i < 4; i++)
			gExponentBasics.add(getProblem7(mathConfig));
		
		for (int i = 0; i < 4; i++)
			gExponentBasics.add(getProblem8(mathConfig));
		
		return gExponentBasics;
	}

	/*
	 * Converts x^2y + 2x^2y = 3x^2y
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower = MathUtilities.getRandomNumber(1, 8);
		int yPower = MathUtilities.getRandomNumber(1, 5);
		
		int val2 = MathUtilities.getRandomNumber(2, 10);
		int result = val2 +1;
		int fakeVal1= val2 +1;
		int fakeVal2= val2 -1;
		
		question = "$" + "x{^"+ xPower+ "}" + "y{^"+ yPower+ "}" + "+" + val2+"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+  "$";
		
		answer.setAnswer("$" + result +"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$");
		
		answer.setType(Constants.RADIO_TYPE);
		

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH) + "  " +question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(answer.getAnswer(), Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val2 +"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + fakeVal1 +"x{^"+ yPower+ "}" + "y{^"+ xPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + fakeVal2 +"x{^"+ xPower+ "}" + "y{^"+ xPower+ "}"+"$", Constants.RADIO_TYPE));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Converts 2x^0y^2 + 2y^3x^2 = 2y^2 + 2x^2y^3
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower1 = 0;
		int xPower2 = MathUtilities.getRandomNumber(2, 8);
		int yPower = MathUtilities.getRandomNumber(0, 5);
		
		int val1 = MathUtilities.getRandomNumber(2, 10);
		int val2 = MathUtilities.getRandomNumber(2, 10);
		
		int result = val2 + val1;

		
		question = "$" + val1 + "x{^"+ xPower1+ "}" + "y{^"+ yPower+ "}" + "+" + +val2 + "y{^"+ yPower+ "}" + "x{^"+ xPower2+ "}"+  "$";
		
		answer.setAnswer("$" + val1 + "y{^"+ yPower+ "}"+ "+" + val2 + "y{^"+ yPower+ "}" + "x{^"+ xPower2+ "}"+ "$");
		
		answer.setType(Constants.RADIO_TYPE);
		

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH) + "  " + question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(answer.getAnswer(), Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + result +"x{^"+ xPower1+ "}" + "+"+ "y{^"+ yPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val1 +"x{^"+ xPower1+ "}" + "+" + val2 +"y{^"+ yPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val1 + "x{^"+ xPower1+ "}" + "y{^"+ yPower+ "}" + "+" + val2 + "y{^"+ yPower+ "}" + "x{^"+ xPower2+ "}"+  "$", Constants.RADIO_TYPE));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Converts x^0y^2 + 2x^0y^2 = 3y^2
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower = 0;
		int yPower = MathUtilities.getRandomNumber(0, 5);
		
		int val1 = MathUtilities.getRandomNumber(2, 10);
		int val2 = MathUtilities.getRandomNumber(2, 10);
		int result = val2 + val1;
		int fakeVal1= val2 +1;
		
		question = "$" + val1 + "x{^"+ xPower+ "}" + "y{^"+ yPower+ "}" + "+" + val2 +"y{^"+ yPower+ "}" + "x{^"+ xPower+ "}"+  "$";
		
		answer.setAnswer("$" + result + "y{^"+ yPower+ "}"+"$");
		
		answer.setType(Constants.RADIO_TYPE);

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH) + "  " + question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(answer.getAnswer(), Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val2 +"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + fakeVal1 +"x{^"+ yPower+ "}" + "y{^"+ xPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + result +"x{^"+ xPower+ "}" + "y{^"+ xPower+ "}"+"$", Constants.RADIO_TYPE));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Converts 2x^2y + 2yx^2 = 4x^2y
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower = MathUtilities.getRandomNumber(0, 8);
		int yPower = MathUtilities.getRandomNumber(0, 5);
		
		int val1 = MathUtilities.getRandomNumber(2, 10);
		int val2 = MathUtilities.getRandomNumber(2, 10);
		
		int result = val2 + val1;
		int fakeResult1 = val2 + val1 +1;
		
		question = "$" + val1 + "x{^"+ xPower+ "}" + "y{^"+ yPower+ "}" + "+" + val2 + "y{^"+ yPower+ "}" + "x{^"+ xPower+ "}"+  "$";
		
		answer.setAnswer("$" + result +"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$");
		
		answer.setType(Constants.RADIO_TYPE);
		

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH) + "  " + question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(answer.getAnswer(), Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val2 +"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + fakeResult1 +"x{^"+ yPower+ "}" + "y{^"+ xPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val1 + "x{^"+ xPower+ "}" + "y{^"+ yPower+ "}" + "+" + val2 + "y{^"+ yPower+ "}" + "x{^"+ xPower+ "}"+  "$", Constants.RADIO_TYPE));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Converts 2x^2y^-1 + 2y^-1x^2 - 3z^0x^2y^-1 = x^2y^-1 
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower = MathUtilities.getRandomNumber(0, 8);
		int yPower = MathUtilities.getRandomNumber(-4, -1);
		int zPower = 0;
		
		int val1 = MathUtilities.getRandomNumber(2, 10);
		int val2 = MathUtilities.getRandomNumber(2, 10);
		int val3 = MathUtilities.getRandomNumber(-10, -2);
		
		int result = val1 + val2 + val3;
		int fakeResult1 = val1 + val2;
		
		question = "$" + val1 + "x{^"+ xPower+ "}" + "y^{"+ yPower+ "}" + "+" + val2 + "x{^"+ xPower+ "}" + "y^{"+ yPower+ "}"+  
				 + val3 + "x{^"+ xPower+ "}" + "y^{"+ yPower+ "}" + "z{^"+ zPower+ "}" + "$";

		if (result == 0)
			answer.setAnswer(Integer.toString(0));
		else if (result == 1)
			answer.setAnswer("$"+"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$");
		else
			answer.setAnswer("$" + result +"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$");
		
		
		answer.setType(Constants.RADIO_TYPE);
		

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH) + "  " + question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(answer.getAnswer(), Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val2 +"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + fakeResult1 +"x{^"+ yPower+ "}" + "y{^"+ xPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val1 + "x{^"+ xPower+ "}" + "y{^"+ yPower+ "}" + "+" + val2 + "y{^"+ yPower+ "}" + "x{^"+ xPower+ "}"+  "$", Constants.RADIO_TYPE));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Converts -2x^2y + 3yx^2 = x^2y
	 */
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower = MathUtilities.getRandomNumber(-5, -1);
		int yPower = MathUtilities.getRandomNumber(1, 5);
		
		int val1 = MathUtilities.getRandomNumber(-10, -2);
		int val2 = MathUtilities.getRandomNumber(2, 10);
		
		int result = val2 + val1;
		int fakeResult1 = val2 + val1 +1;
		
		question = "$" + val1 + "x^{"+ xPower+ "}" + "y{^"+ yPower+ "}" + "+" + val2 + "y{^"+ yPower+ "}" + "x^{"+ xPower+ "}"+  "$";
			
		if (result == 1)
			answer.setAnswer("$" +"x^{"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$");
		else if (result == 0 )
			answer.setAnswer(Integer.toString(0));
		else
			answer.setAnswer("$" + result +"x^{"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$");
		
		answer.setType(Constants.RADIO_TYPE);
		

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH) + "  " + question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(answer.getAnswer(), Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val2 +"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + fakeResult1 +"x{^"+ yPower+ "}" + "y{^"+ xPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val1 + "x{^"+ xPower+ "}" + "y{^"+ yPower+ "}" + "+" + val2 + "y{^"+ yPower+ "}" + "x{^"+ xPower+ "}"+  "$", Constants.RADIO_TYPE));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Converts -2x^2y + 2yx^2 = 0
	 */
	
	public Problem getProblem7(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower = MathUtilities.getRandomNumber(-5, -1);
		int yPower = MathUtilities.getRandomNumber(1, 5);
		
		int val1 = MathUtilities.getRandomNumber(-10, -2);
		int val2 = Math.abs(val1); // need a result 0
		
		int fakeResult1 = val2 + val1 + 1;
		
		question = "$" + val1 + "x^{"+ xPower+ "}" + "y{^"+ yPower+ "}"  + "+"+val2 + "y{^"+ yPower+ "}" + "x^{"+ xPower+ "}"+  "$";

		answer.setAnswer(Integer.toString(0));
		
		answer.setType(Constants.RADIO_TYPE);

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH) + "  " + question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(answer.getAnswer(), Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val2 +"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + fakeResult1 +"x{^"+ yPower+ "}" + "y{^"+ xPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val1 + "x{^"+ xPower+ "}" + "y{^"+ yPower+ "}" + "+" + val2 + "y{^"+ yPower+ "}" + "x{^"+ xPower+ "}"+  "$", Constants.RADIO_TYPE));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Converts -2x^2y + 3yx^2 = x^2y
	 */
	public Problem getProblem8(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower = MathUtilities.getRandomNumber(-5, -1);
		int yPower = MathUtilities.getRandomNumber(1, 5);
		
		int val1 = MathUtilities.getRandomNumber(-10, -2);
		int val2 = MathUtilities.getRandomNumber(2, 10);
		int val3 = MathUtilities.getRandomNumber(2, 10);
		int val4 = MathUtilities.getRandomNumber(-10, -2);
		
		int result = val1 + val2 -( val3 + val4);
		int fakeResult1 = val2 + val1 +1;
		
		question = "$" + val1 + "x^{"+ xPower+ "}" + "y{^"+ yPower+ "}" + "+" + val2 + "y{^"+ yPower+ "}" + "x^{"+ xPower+ "}"+ "-" +
				"("+ val3 + "x^{"+ xPower+ "}" + "y{^"+ yPower+ "}" + val4 + "y{^"+ yPower+ "}" + "x^{"+ xPower+ "}" + ")$";
			
		if (result == 1)
			answer.setAnswer("$" +"x^{"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$");
		else if (result == 0 )
			answer.setAnswer(Integer.toString(0));
		else
			answer.setAnswer("$" + result +"x^{"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$");
		
		answer.setType(Constants.RADIO_TYPE);
		

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH) + "  " + question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(answer.getAnswer(), Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val2 +"x{^"+ xPower+ "}" + "y{^"+ yPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + fakeResult1 +"x{^"+ yPower+ "}" + "y{^"+ xPower+ "}"+"$", Constants.RADIO_TYPE));
		questionList.add(new QuestionLine("$" + val1 + "x{^"+ xPower+ "}" + "y{^"+ yPower+ "}" + "+" + val2 + "y{^"+ yPower+ "}" + "x{^"+ xPower+ "}"+  "$", Constants.RADIO_TYPE));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
}
