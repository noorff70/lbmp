package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7DecimalSubtraction extends Question {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7DecimalSubtraction = new ArrayList<Problem>();


		for (int i = 0; i < 15; i++)
			g7DecimalSubtraction.add(getProblem1(mathConfig));
		
		for (int i = 0; i < 10; i++)
			g7DecimalSubtraction.add(getProblem2(mathConfig));

		return g7DecimalSubtraction;
	}

	/*
	 * Subtract Decimals
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		Double answer = (double) 0;
		
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
		double answerDecimal = firstDecimalNumber - secondDecimalNumber;
		
		//find highest decimal position of the two decimal numbers if two numbers are 1234.56 & 456.3456, then decimal position will be 3
		int decimalPosition = getDecimalPosition(firstDecimalNumber, secondDecimalNumber, Constants.HIGHEST_VALUE);
		
		answer = firstDecimalNumber - secondDecimalNumber;
		answer = MathUtilities.getRoundedAnswer(answerDecimal, decimalPosition);
		
		question = Double.toString(firstDecimalNumber)+ " - " + Double.toString(secondDecimalNumber);
		
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.SUBTRACT_FOLLOWING_DECIMAL_NUMBERS, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_SUBTRACT_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, Double.toString(answer), heading, subHeading, Constants.RANK_ONE, Constants.DEFAULT);

		return problem;
	}
	
	
	public Problem getProblem2(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		Double answer = (double) 0;
		
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
		double answerDecimal = firstDecimalNumber - secondDecimalNumber;
		
		//find highest decimal position of the two decimal numbers if two numbers are 1234.56 & 456.3456, then decimal position will be 3
		int decimalPosition = 2;
		
		answer = firstDecimalNumber - secondDecimalNumber;
		answer = MathUtilities.getRoundedAnswer(answerDecimal, decimalPosition);
		
		question = Double.toString(firstDecimalNumber)+ " - " + Double.toString(secondDecimalNumber);
		
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.SUBTRACT_FOLLOWING_DECIMAL_NUMBERS, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(mSource.getMessage(Constants.ROUND_UPTO_TWO_DECIMAL_POSITION, null, Locale.ENGLISH));
		QuestionLine qLine3 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);
		questionList.add(qLine3);

		String heading = mSource.getMessage(Constants.GRADE_7_SUBTRACT_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, Double.toString(answer), heading, subHeading, Constants.RANK_ONE, Constants.DEFAULT);

		return problem;
	}
	
	
	
	public int getDecimalPosition(double firstDecimal, double secondDecimal, String type){
		
		int first= Double.toString(firstDecimal).length()- Double.toString(firstDecimal).indexOf('.')-1;
		int second= Double.toString(secondDecimal).length()- Double.toString(secondDecimal).indexOf('.')-1;
		
		if (type.equals(Constants.LOWEST_VALUE))
			return Math.min(first, second);
		else 
			return Math.max(first, second);
		
	}
	

}
