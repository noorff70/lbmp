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

public class G8ExponentBasics extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8SqrInteger.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> gExponentBasics = new ArrayList<Problem>();
		
		for (int i = 0; i < 2; i++)
			gExponentBasics.add(getProblem1(mathConfig));
		
		for (int i = 0; i < 3; i++)
			gExponentBasics.add(getProblem2(mathConfig));
		
		for (int i = 0; i < 5; i++)
			gExponentBasics.add(getProblem3(mathConfig));
		
		for (int i = 0; i < 5; i++)
			gExponentBasics.add(getProblem4(mathConfig));
		
		for (int i = 0; i < 5; i++)
			gExponentBasics.add(getProblem5(mathConfig));
		
		for (int i = 0; i < 5; i++)
			gExponentBasics.add(getProblem6(mathConfig));


		return gExponentBasics;
	}

	/*
	 * Converts 2 *2*2 = 2^3
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(2, 10);
		int power = MathUtilities.getRandomNumber(1, 3);
		

		for (int i = 1; i <= power; i++) {
			if (i < power) {
				question = question + Integer.toString(base) + " x ";
			} else if (i == power) {
				question = question + Integer.toString(base);
			}
		}
		answer.setAnswer("$" + base + "^" + power + "$");
		
		answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH) , null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer(), Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$" + base*2 +"^"+power/2 +"$", Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$" + base +"^"+power*2 +"$", Constants.RADIO_TYPE));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	

	/*
	 * ex- converts 2^3 = 8
	 */
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();
		int result = 1;

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(2, 10);
		int power = MathUtilities.getRandomNumber(0, 4);
		
		if (power==0) {
			result = 1;
		}
		else {
				result = (int)Math.pow(base, power);
		}
		question = ("$" + base + "^" + power + "$");
	
		answer.setAnswer(Integer.toString(result));
		answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(Integer.toString(result), Constants.RADIO_TYPE));
		answerList.add(new AnswerLine(Integer.toString(result+1), Constants.RADIO_TYPE));
		answerList.add(new AnswerLine(Integer.toString(result-1), Constants.RADIO_TYPE));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * ex- converts -2^3 = -8
	 */
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();
		int result = 1;

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(-10, -2);
		int power = MathUtilities.getRandomNumber(0, 4);
		
		if (power==0) {
			result = 1;
		}
		else {
			result = (int)Math.pow(base, power);
		}
		question = ("$(" + base + ")^" + "{" +power + "}" +"$");
	
		answer.setAnswer(Integer.toString(result));
		answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(Integer.toString(result), Constants.RADIO_TYPE));
		answerList.add(new AnswerLine(Integer.toString(result+1), Constants.RADIO_TYPE));
		answerList.add(new AnswerLine(Integer.toString(result-1), Constants.RADIO_TYPE));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * ex Converts 16 = 2^4
	 */
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();
		int result = 1;
		int power=0;

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(2, 10);
		
		
		if (base <= 5) {
			power = MathUtilities.getRandomNumber(0, 5);
			result = (int)Math.pow(base, power );
		}
		else {
			power = MathUtilities.getRandomNumber(0, 3);
			result = (int)Math.pow(base, power );
		}
		

		question = (Integer.toString(base));
	
		answer.setAnswer("$" + base + "^" + power + "$");
		answer.setType(Constants.RADIO_TYPE);
		

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_CONVERT , null, Locale.ENGLISH)+ " " +Integer.toString(result) + " "+ mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_CONVERT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine("$" + base + "^" + power + "$", Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$" + base + "^" + Integer.toString(power-1) + "$", Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$" + base + "^" + Integer.toString(power+1) + "$", Constants.RADIO_TYPE));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Converts 2^-1 = 1/2
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();
		int power=0;
		Fraction frac = new Fraction(1, 1);

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(2, 10);
		
		if (base <= 5) {
			power = MathUtilities.getRandomNumber(-4, 0);
		}
		else {
			power = MathUtilities.getRandomNumber(-3, 0);
		}
		
		if (power == 0) {
			question = "$" + base + "^" + power + "$";
			answer.setAnswer(Integer.toString(base));
		}
		else {
			question = "$" + base + "^" +"{" + power + "}" + "$";
			power = -power;
			frac = Fraction.getReducedFraction(1, (int)Math.pow(base, power));
			answer.setAnswer("$"+ frac.getNumerator()+"\\over" +frac.getDenominator()+ "$");
		}
	
		answer.setType(Constants.RADIO_TYPE);	

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer(), Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$"+ frac.getNumerator()+"\\over" +frac.getDenominator()+1+ "$", Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$"+ frac.getNumerator()+"\\over" +frac.getDenominator()+2+ "$", Constants.RADIO_TYPE));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * ex Converts 1.6^2 = 16 *16/ 10*10
	 */
	
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();
		String result = "";
		int power=0;
		Fraction frac = new Fraction(1, 1);
		int numerator =0;
		int denominator= 0;

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		//take only multiple of 5
		int baseNumber = 5* MathUtilities.getRandomNumber(2, 8);
		int decimalPoint = MathUtilities.getRandomNumber(1, 2);
		
		double base = MathUtilities.convertToDecimal(baseNumber, decimalPoint);
		power = MathUtilities.getRandomNumber(0, 3);
		
		if (power ==1)
			power = 2;
		
		question = "$" + base + "^" +"{" + power + "}" + "$";
		numerator = (int)Math.pow(baseNumber, power);
		denominator = (int) Math.pow((int)Math.pow(10, decimalPoint), power);
		
		frac = Fraction.getReducedFraction(numerator, denominator);
		
		if (frac.getNumerator() ==1 && frac.getDenominator() ==1)
			result = Integer.toString(1);
		else
			result = "$"+ frac.getNumerator() + "\\over" + frac.getDenominator() +"$";
		
		answer.setAnswer(result);
		answer.setType(Constants.RADIO_TYPE);
		
		int fakeNumerator1 = frac.getNumerator() +1;
		int fakeDenominator1 = frac.getDenominator() +1;
		
		int fakeNumerator2 = frac.getNumerator()+ 2;
		int fakeDenominator2 = frac.getDenominator() +2;

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_CONVERT , null, Locale.ENGLISH)+ " " + " "+ mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_CONVERT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer(), Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$"+ fakeNumerator1 + "\\over" + fakeDenominator1 +"$", Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$"+ fakeNumerator2 + "\\over" + fakeDenominator2 +"$", Constants.RADIO_TYPE));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	

}
