package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8PolyMultiply extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8PolyMultiply.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> gExponentBasics = new ArrayList<Problem>();
		
		for (int i = 0; i < 5; i++)
			gExponentBasics.add(getProblem1(mathConfig));
		
		for (int i = 0; i < 5; i++)
			gExponentBasics.add(getProblem2(mathConfig));
		
		for (int i = 0; i < 7; i++)
			gExponentBasics.add(getProblem3(mathConfig));

		for (int i = 0; i < 8; i++)
			gExponentBasics.add(getProblem4(mathConfig));
		
		return gExponentBasics;
	}

	/*
	 * Converts x^2y * 2x^2y = 4x^4y2
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower1 = MathUtilities.getRandomNumber(-5, 8);
		int yPower1= MathUtilities.getRandomNumber(-3, 5);
		int xPower2 = MathUtilities.getRandomNumber(-5, 8);
		int yPower2= MathUtilities.getRandomNumber(-3, 5);
		
		int val1 = MathUtilities.getRandomNumber(-3, 10);
		int val2 = MathUtilities.getRandomNumber(-2, 10);
		
		int result = val1 * val2;
		int fakeVal1= val2 +1;
		int fakeVal2= val2 -1;
		
		question = handleZero(val1, val2, xPower1, xPower2, yPower1, yPower2, "X");
	 	
		
		int ansXPower = xPower1 + xPower2;
		int ansYPower = yPower1 + yPower2;

		if (result == 0)
			answer.setAnswer("$" + Integer.toString(0)+"$");
		else
			answer.setAnswer("$" + result +"x^{"+ ansXPower+ "}" + "y^{"+ ansYPower+ "}"+"$");
		
	//	answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine("$" + val2 +"x{^"+ xPower1+ "}" + "y{^"+ yPower1+ "}"+"$"));
		answerList.add(new AnswerLine("$" + fakeVal1 +"x{^"+ ansYPower+ "}" + "y{^"+ xPower1+ "}"+"$"));
		answerList.add(new AnswerLine("$" + fakeVal2 +"x{^"+ xPower1+ "}" + "y{^"+ yPower2+ "}"+"$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Converts x^2y^-2 * 2x^2y^-1 = 4x^4/y^3
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower1 = MathUtilities.getRandomNumber(0, 8);
		int yPower1= MathUtilities.getRandomNumber(-5, -3);
		int xPower2 = MathUtilities.getRandomNumber(3, 5);
		int yPower2= MathUtilities.getRandomNumber(-3, -1);
		
		int val1 = MathUtilities.getRandomNumber(-3, 10);
		int val2 = MathUtilities.getRandomNumber(-2, 10);
		
		int result = val1 * val2;
		int fakeVal1= val2 +1;
		int fakeVal2= val2 -1;
		
		question = handleZero(val1, val2, xPower1, xPower2, yPower1, yPower2, "X");
	 	
		
		int ansXPower = xPower1 + xPower2;
		int ansYPower = yPower1 + yPower2;

		if (result == 0)
			answer.setAnswer("$" + Integer.toString(0)+"$");
		else
			answer.setAnswer("$" + result + "x^{"+ ansXPower+ "}" + "\\over y^{"+ Math.abs(ansYPower)+ "}$");
		
	//	answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH),null,  null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine("$" + val2 +"x{^"+ xPower1+ "}" + "y{^"+ yPower1+ "}"+"$"));
		answerList.add(new AnswerLine("$" + fakeVal1 +"x{^"+ ansYPower+ "}" + "y{^"+ xPower1+ "}"+"$"));
		answerList.add(new AnswerLine("$" + fakeVal2 +"x{^"+ xPower1+ "}" + "y{^"+ yPower2+ "}"+"$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Converts 4x^2y^-2 / 2x^2y^-1 = 2x^0/y^1
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();
		String ans= "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower1 = MathUtilities.getRandomNumber(0, 8);
		int yPower1= MathUtilities.getRandomNumber(-5, -3);
		int xPower2 = MathUtilities.getRandomNumber(3, 5);
		int yPower2 = MathUtilities.getRandomNumber(-3, -1);
		
		int val1 = MathUtilities.getRandomNumber(-10, 10);
		int val2 = MathUtilities.getRandomNumber(-10, 10);
		
		if (val1 == 0)
			val1 = 5;
		if (val2 ==0)
			val2 = 5;
		
		
		Fraction f1 = Fraction.getReducedFraction(val1, val2);
		
		//int result = val1 * val2;
		int fakeVal1= val2 +1;
		int fakeVal2= val2 -1;
		
		question = handleZero(val1, val2, xPower1, xPower2, yPower1, yPower2, "/");
	 	
		
		int ansXPower = xPower1 - xPower2;
		int ansYPower = yPower1 - yPower2;

		ans = formatAnswerForOnes(ansXPower, ansYPower, f1);
		

		ans = formatAnswer(ans);
		answer.setAnswer(ans);
		
	//	answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH),null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine("$" + val2 +"x{^"+ xPower1+ "}" + "y{^"+ yPower1+ "}"+"$"));
		answerList.add(new AnswerLine("$" + fakeVal1 +"x{^"+ ansYPower+ "}" + "y{^"+ xPower1+ "}"+"$"));
		answerList.add(new AnswerLine("$" + fakeVal2 +"x{^"+ xPower1+ "}" + "y{^"+ yPower2+ "}"+"$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	
	/*
	 * Converts 4x^2y^-2 / 2x^2y^-1 = 2x^0/y^1
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();
		String ans= "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int xPower1 = MathUtilities.getRandomNumber(0, 8);
		int yPower1= MathUtilities.getRandomNumber(-5, -3);
		int xPower2 = MathUtilities.getRandomNumber(3, 5);
		int yPower2 = MathUtilities.getRandomNumber(-3, -1);
		
		int val1 = MathUtilities.getRandomNumber(-10, 10);
		int val2 = MathUtilities.getRandomNumber(-10, 10);
		
		if (val1 == 0)
			val1 = 5;
		if (val2 ==0)
			val2 = 5;
		
		
		Fraction f1 = Fraction.getReducedFraction(val1, val2);
		
		//int result = val1 * val2;
		int fakeVal1= val2 +1;
		int fakeVal2= val2 -1;
		
		question = handleZero(val1, val2, xPower1, xPower2, yPower1, yPower2, "/");
	 	
		
		int ansXPower = xPower1 - xPower2;
		int ansYPower = yPower1 - yPower2;

		ans = formatAnswerForOnesAndPower(ansXPower, ansYPower, f1);
		

		ans = formatAnswer(ans);
		answer.setAnswer(ans);
	//	answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION_EXPRESSION, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine("$" + val2 +"x{^"+ xPower1+ "}" + "y{^"+ yPower1+ "}"+"$"));
		answerList.add(new AnswerLine("$" + fakeVal1 +"x{^"+ ansYPower+ "}" + "y{^"+ xPower1+ "}"+"$"));
		answerList.add(new AnswerLine("$" + fakeVal2 +"x{^"+ xPower1+ "}" + "y{^"+ yPower2+ "}"+"$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_POLYNOMIAL_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	
	public String handleZero(int val1, int val2, int xPower1, int xPower2, int yPower1, int yPower2, String sign) {
		String question = "";
		
		if (val1 ==1 || val2 ==1) {
			if (val1 ==1)
				question = "$" + "x^{"+ xPower1+ "}" + "y^{"+ yPower1+ "}" + sign + val2 +"x^{"+ xPower2+ "}" + "y^{"+ yPower2+ "}"+  "$";
			if(val2 ==1)
				question = "$" + val1 +  "x^{"+ xPower1+ "}" + "y^{"+ yPower1+ "}" + sign +"x^{"+ xPower2+ "}" + "y^{"+ yPower2+ "}"+  "$";
		}
		else if (val1 == 0 || val2 == 0) {
			if (val1 ==0)
				question = "$" + 0 + sign + val2 +"x^{"+ xPower2+ "}" + "y^{"+ yPower2+ "}"+  "$";
			if(val2 ==0)
				question = "$" + val1 +  "x^{"+ xPower1+ "}" + "y^{"+ yPower1+ "}" + sign + 0 +  "$";
		}
		else if ((val1 == -1 || val2 == -1) ) {
			if (val1 == -1)
				question = "$" +"-"+ "x^{"+ xPower1+ "}" + "y^{"+ yPower1+ "}" + sign + val2 +"x^{"+ xPower2+ "}" + "y^{"+ yPower2+ "}"+  "$";
			if(val2 == -1)
				question = "$" +val1+ "x^{"+ xPower1+ "}" + "y^{"+ yPower1+ "}" + sign + "-" +"x^{"+ xPower2+ "}" + "y^{"+ yPower2+ "}"+  "$";
		}
		else {
			question = "$" + val1 + "x^{"+ xPower1+ "}" + "y^{"+ yPower1+ "}" + sign + val2 +"x^{"+ xPower2+ "}" + "y^{"+ yPower2+ "}"+  "$";
		}
		
		return question;
	}
	
	public String formatAnswer(String s) {
		
		StringBuffer sb = new StringBuffer(s);
		
		//make x^{0} = null. Find the index for this and find for both x and y
		int index = 0;
		for (int i=0; i< 1; i++) {
			index = s.indexOf("^{0}");
			{
				if (index >=0)
					sb.replace(index-1, index+4, "");
			}
		}
		
		//make y^{1} = y
		index =0;
		for (int i=0; i< 1; i++) {
			index = s.indexOf("^{1}");
			if (index >=0) {
				sb.replace(index, index+4, "");
			}
		}
		return sb.toString();
	}
	
	public String formatAnswerForOnes(int ansXPower, int ansYPower, Fraction f1) {
		
		String ans ="";
		
		if (f1.getNumerator() == 1 && f1.getDenominator() ==1) {
			ans = "$" + "x^{"+ ansXPower+ "} \\over" +  "y^{"+ Math.abs(ansYPower)+ "}$";
		}
		else if (f1.getNumerator() == 1) {
			ans = "$" + "x^{"+ ansXPower+ "}" + "\\over" + f1.getDenominator() + "y^{"+ Math.abs(ansYPower)+ "}$";
		}
		else if (f1.getDenominator() == 1) {
			ans = "$" + f1.getNumerator() + "x^{"+ ansXPower+ "}\\over y^{"+ Math.abs(ansYPower)+ "}$";
		}
		else {
			ans = "$" + f1.getNumerator() + "x^{"+ ansXPower+ "}" + "\\over" + f1.getDenominator() + "y^{"+ Math.abs(ansYPower)+ "}$";
		}
		
		return ans;
		
	}
	
	public String formatAnswerForOnesAndPower(int ansXPower, int ansYPower, Fraction f1) {
		
		String ans ="";
		
		if (f1.getNumerator() == 1 && f1.getDenominator() ==1) {
			ans = "$" + "x^{"+ ansXPower+ "}y^{"+ ansYPower+"}$";
		}
		else if (f1.getNumerator() == 1) {
			ans = "$" + "x^{"+ ansXPower+ "}y^{"+ansYPower+ "}\\over" + f1.getDenominator() +  "$";
		}
		else if (f1.getDenominator() == 1) {
			ans = "$" + f1.getNumerator() + "x^{"+ ansXPower+ "} y^{"+ ansYPower+ "}$";
		}
		else {
			ans = "$" + f1.getNumerator() + "x^{"+ ansXPower+ "}y^{"+ ansYPower + "}\\over" + f1.getDenominator() +  "$";
		}
		
		return ans;
		
	}
	
	
}
