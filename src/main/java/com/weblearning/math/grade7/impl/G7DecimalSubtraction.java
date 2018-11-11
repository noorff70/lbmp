package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.apache.commons.math3.fraction.Fraction;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7DecimalSubtraction extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7DecimalSubtraction = new ArrayList<Problem>();


		for (int i = 0; i < 3; i++)
			g7DecimalSubtraction.add(getProblem1(mathConfig));
		for (int i = 0; i < 3; i++)
			g7DecimalSubtraction.add(getProblem2(mathConfig));
		for (int i = 0; i < 3; i++)
			g7DecimalSubtraction.add(getProblem3(mathConfig));
		for (int i = 0; i < 2; i++)
			g7DecimalSubtraction.add(getProblem4(mathConfig));
		for (int i = 0; i < 3; i++)
			g7DecimalSubtraction.add(getProblem5(mathConfig)); 
		for (int i = 0; i < 3; i++)
			g7DecimalSubtraction.add(getProblem6(mathConfig));
		//for (int i = 0; i < 3; i++)
		//	g7DecimalSubtraction.add(getProblem7(mathConfig));

		return g7DecimalSubtraction;
	}

	/*
	 * Subtract Decimals
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		BigDecimal bg = new BigDecimal(0);
		
		String question = "";
		String answer = "";
		//Double answer = (double) 0;
		
		//get a random first and second number
		int firstNumber = MathUtilities.getRandomNumber(10000, 10000000);
		int secondNumber = MathUtilities.getRandomNumber(10000, firstNumber-1);
		
		//decimal point 1=10, 2-100, 3=1000
		int firstDecimalPoint = MathUtilities.getRandomNumber(1, 3);
		int secondDecimalPoint = MathUtilities.getRandomNumber(firstDecimalPoint, 3);
		
		//convert that to decimal number if firstnumber = 1234567, firstdecimal =2, then the decimal number will be 1234567/100
		double firstDecimalNumber = (double)firstNumber/(Math.pow(10, firstDecimalPoint));
		double secondDecimalNumber = (double)secondNumber/(Math.pow(10, secondDecimalPoint));
		//get the answer
		bg = bg.add(BigDecimal.valueOf(firstDecimalNumber)).subtract(BigDecimal.valueOf(secondDecimalNumber));
		//double answerDecimal = firstDecimalNumber - secondDecimalNumber;
		
		//find highest decimal position of the two decimal numbers if two numbers are 1234.56 & 456.3456, then decimal position will be 3
		//int decimalPosition = getDecimalPosition(firstDecimalNumber, secondDecimalNumber, Constants.HIGHEST_VALUE);
		
		//answer = firstDecimalNumber - secondDecimalNumber;
		//answer = MathUtilities.getRoundedAnswer(answerDecimal, decimalPosition);
		answer = bg.toString();
		
		question = Double.toString(firstDecimalNumber)+ " - " + Double.toString(secondDecimalNumber);
		
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.SUBTRACT_FOLLOWING_DECIMAL_NUMBERS, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_SUBTRACT_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer(answer);
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Subtract Decimals 7183.14 - 93267.3 = -86084.16
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		BigDecimal bg = new BigDecimal(0);

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		//Double answer = (double) 0;
		String answer;
		
		//get a random first and second number
		int firstNumber = MathUtilities.getRandomNumber(100, 1000000);
		int secondNumber = MathUtilities.getRandomNumber(firstNumber +1, 1000000);
		
		//decimal point 1=10, 2-100, 3=1000
		int firstDecimalPoint = MathUtilities.getRandomNumber(2, 3);
		int secondDecimalPoint = MathUtilities.getRandomNumber(1, 1);
		
		//convert that to decimal number if firstnumber = 1234567, firstdecimal =2, then the decimal number will be 1234567/100
		double firstDecimalNumber = (double)firstNumber/(Math.pow(10, firstDecimalPoint));
		double secondDecimalNumber = (double)secondNumber/(Math.pow(10, secondDecimalPoint));
		//get the answer
		bg = bg.add(BigDecimal.valueOf(firstDecimalNumber));
		bg = bg.subtract(BigDecimal.valueOf(secondDecimalNumber));
		
		answer = bg.toString();
		
		question = Double.toString(firstDecimalNumber)+ " - " + Double.toString(secondDecimalNumber);
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.SUBTRACT_FOLLOWING_DECIMAL_NUMBERS, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_SUBTRACT_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer(answer);
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Subtract Decimals -(7183.14 - 93267.3) = 86084.16
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		BigDecimal bg = new BigDecimal(0);

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		//Double answer = (double) 0;
		String answer;
		
		//get a random first and second number
		int firstNumber = MathUtilities.getRandomNumber(100, 1000000);
		int secondNumber = MathUtilities.getRandomNumber(firstNumber +1, 1000000);
		
		//decimal point 1=10, 2-100, 3=1000
		int firstDecimalPoint = MathUtilities.getRandomNumber(2, 3);
		int secondDecimalPoint = MathUtilities.getRandomNumber(1, 1);
		
		//convert that to decimal number if firstnumber = 1234567, firstdecimal =2, then the decimal number will be 1234567/100
		double firstDecimalNumber = (double)firstNumber/(Math.pow(10, firstDecimalPoint));
		double secondDecimalNumber = (double)secondNumber/(Math.pow(10, secondDecimalPoint));
		//get the answer
		bg = bg.subtract(BigDecimal.valueOf(firstDecimalNumber));
		bg = bg.add(BigDecimal.valueOf(secondDecimalNumber));
		
		answer = bg.toString();
		
		question = "-( " +Double.toString(firstDecimalNumber)+ " - " + Double.toString(secondDecimalNumber) + " )";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.SUBTRACT_FOLLOWING_DECIMAL_NUMBERS, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_SUBTRACT_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer(answer);
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Subtract Decimals -(93267.3 - 7183.14) = -86084.16
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		BigDecimal bg = new BigDecimal(0);

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		//Double answer = (double) 0;
		String answer;
		
		//get a random first and second number
		int firstNumber = MathUtilities.getRandomNumber(100, 1000000);
		int secondNumber = MathUtilities.getRandomNumber(firstNumber +1, 1000000);
		
		//decimal point 1=10, 2-100, 3=1000
		int firstDecimalPoint = MathUtilities.getRandomNumber(2, 3);
		int secondDecimalPoint = MathUtilities.getRandomNumber(1, 1);
		
		//convert that to decimal number if firstnumber = 1234567, firstdecimal =2, then the decimal number will be 1234567/100
		double firstDecimalNumber = (double)firstNumber/(Math.pow(10, firstDecimalPoint));
		double secondDecimalNumber = (double)secondNumber/(Math.pow(10, secondDecimalPoint));
		//get the answer
		bg = bg.subtract(BigDecimal.valueOf(secondDecimalNumber));
		bg = bg.add(BigDecimal.valueOf(firstDecimalNumber));
		
		answer = bg.toString();
		
		question = "-( " + Double.toString(secondDecimalNumber) + " - "  +Double.toString(firstDecimalNumber) + " )";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.SUBTRACT_FOLLOWING_DECIMAL_NUMBERS, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_SUBTRACT_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer(answer);
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem4(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		BigDecimal bg = new BigDecimal(0);

		
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		String question="";
		
		//get a random first and second number
		int firstNumber = MathUtilities.getRandomNumber(100, 1000000);
		int secondNumber = MathUtilities.getRandomNumber(10000000, 100000000);
		
		//decimal point 1=10, 2-100, 3=1000
		int firstDecimalPoint = MathUtilities.getRandomNumber(1, 3);
		int secondDecimalPoint = MathUtilities.getRandomNumber(4, 5);
	
		double firstDecimalNumber = (double)firstNumber/(Math.pow(10, firstDecimalPoint));
		double secondDecimalNumber = (double)secondNumber/(Math.pow(10, secondDecimalPoint));
		
		question = Double.toString(firstDecimalNumber) +" - "+ Double.toString(secondDecimalNumber);

		bg = bg.add(BigDecimal.valueOf(firstDecimalNumber)).subtract(BigDecimal.valueOf(secondDecimalNumber));
		//find the subtraction
		answer1 = bg.toString();
		//Get the tenth position
		answer2 = Integer.toString(getDecimalPosition(bg, 1));
		//convert to nearest hundredts
		answer3 = Integer.toString(getDecimalPosition(bg, 3));
		//convert to nearest 100th
		answer4 = bg.setScale(2, RoundingMode.HALF_UP).toString();
		//convert to nearest 1000th
		answer5 = bg.setScale(3, RoundingMode.HALF_UP).toString();
		
		
		questionList.add(new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.GRADE_7_FIND_THE_RESULT, null, Locale.ENGLISH) + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.GET_TENTH_POSITION, null, Locale.ENGLISH) + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.GET_THOUSANDTH_POSITION , null, Locale.ENGLISH) + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.CONVERT_TO_NEAREST_HUNDREDTHS, null, Locale.ENGLISH) + Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.CONVERT_TO_NEAREST_THOUSANDTHS, null, Locale.ENGLISH) + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));


		String heading = mSource.getMessage(Constants.GRADE_7_ADD_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * .8- box = .75, box = .05
	 */
	public Problem getProblem6(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		BigDecimal bg = new BigDecimal(0);

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		//Double answer = (double) 0;
		String answer;
		
		//get a random first and second number
		Fraction frac1 = new Fraction(MathUtilities.getRandomNumber(2, 9), 10);
		Fraction frac2 = new Fraction(MathUtilities.getRandomNumber(2,  10), 100);
		
		BigDecimal bg1 = new BigDecimal((double)frac1.getNumerator()/ frac1.getDenominator()).setScale(1, RoundingMode.HALF_UP);
		BigDecimal bg2 = new BigDecimal((double)frac2.getNumerator()/ frac2.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		
		bg = bg.add(BigDecimal.valueOf((double)frac1.getNumerator()/ frac1.getDenominator())).
				subtract(BigDecimal.valueOf((double)frac2.getNumerator()/frac2.getDenominator()).setScale(2, RoundingMode.HALF_UP));
		
		question = "$" + bg1.toString() +" - "+  "\\Box " + " = " + bg.toString()+  "$";
		
		answer = bg2.toString();
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_SUBTRACT_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer(answer);
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * .8- box = .75, box = .05
	 */
	public Problem getProblem7(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		BigDecimal bg = new BigDecimal(0);

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		//Double answer = (double) 0;
		String answer;
		
		//get a random first and second number
		Fraction frac1 = new Fraction(MathUtilities.getRandomNumber(2, 9), 10);
		Fraction frac2 = new Fraction(MathUtilities.getRandomNumber(2,  10), 100);
		
		BigDecimal bg1 = new BigDecimal((double)frac1.getNumerator()/ frac1.getDenominator()).setScale(1, RoundingMode.HALF_UP);
		BigDecimal bg2 = new BigDecimal((double)frac2.getNumerator()/ frac2.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		
		bg = bg.add(BigDecimal.valueOf((double)frac1.getNumerator()/ frac1.getDenominator())).
				subtract(BigDecimal.valueOf((double)frac2.getNumerator()/frac2.getDenominator()).setScale(2, RoundingMode.HALF_UP));
		
		question = "$" + bg1.toString() +" - "+  "\\Box " + " = " + bg.toString()+  "$";
		
		answer = bg2.toString();
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_SUBTRACT_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer(answer);
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	
	public int getDecimalPosition(BigDecimal bg, int position){
		
		int decimalPoint= String.valueOf(bg.abs()).indexOf('.');
		String s = String.valueOf(bg.abs().doubleValue());
		
		String sub = s.substring(decimalPoint+position, decimalPoint + position + 1);
		int ans = Integer.parseInt(sub);
		return ans;
	}
	

}
