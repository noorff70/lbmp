package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.math3.fraction.Fraction;

import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7DecimalMultiplication extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7DecimalMultiplication = new ArrayList<Problem>();


		for (int i = 0; i < 5; i++)
			g7DecimalMultiplication.add(getProblem1(mathConfig));
		for (int i = 0; i < 5; i++)
			g7DecimalMultiplication.add(getProblem2(mathConfig));
		for (int i = 0; i < 4; i++)
			g7DecimalMultiplication.add(getProblem3(mathConfig));
		
		for (int i = 0; i < 3; i++)
			g7DecimalMultiplication.add(getProblem4(mathConfig));
		for (int i = 0; i < 1; i++)
			g7DecimalMultiplication.add(getProblem5(mathConfig));
		for (int i = 0; i < 5; i++)
			g7DecimalMultiplication.add(getProblem6(mathConfig));
		

		return g7DecimalMultiplication;
	}

	/*
	 * Subtract Decimals
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer = "";
		
		//get a random first and second number
		int firstNumber = MathUtilities.getRandomNumber(100, 10000);
		int secondNumber = MathUtilities.getRandomNumber(100, 10000);
		
		//decimal point 1=10, 2-100, 3=1000
		int firstDecimalPoint = MathUtilities.getRandomNumber(1, 3);
		int secondDecimalPoint = MathUtilities.getRandomNumber(firstDecimalPoint, 3);
		
		//convert that to decimal number if firstnumber = 1234567, firstdecimal =2, then the decimal number will be 1234567/100
		double firstDecimalNumber = (double)firstNumber/(Math.pow(10, firstDecimalPoint));
		double secondDecimalNumber = (double)secondNumber/(Math.pow(10, secondDecimalPoint));
		//get the answer
		double answerDecimal = firstDecimalNumber * secondDecimalNumber;
		
		answer = Double.toString(MathUtilities.getRoundedAnswer(answerDecimal, 2));
		answer = answer.replaceFirst("^0+(?!$)", "");
		
		question = "$" + Double.toString(firstDecimalNumber)+ " \\times " + Double.toString(secondDecimalNumber) + "$";
		
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.MULTIPLY_FOLLOWING_DECIMAL_NUMBERS, null, Locale.ENGLISH) + " " 
				+mSource.getMessage(Constants.ROUND_UPTO_TWO_DECIMAL_POSITION, null, Locale.ENGLISH));
		QuestionLine qLine3 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine3);

		String heading = mSource.getMessage(Constants.GRADE_7_MULTIPLY_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question="";


		Fraction frac1 = new Fraction(MathUtilities.getRandomNumber(2, 9), 10);
		Fraction frac2 = new Fraction(MathUtilities.getRandomNumber(12, 18), 10);
		Fraction frac3 = frac1.multiply(frac2);
		
		BigDecimal bg1 = new BigDecimal((double)frac1.getNumerator()/frac1.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bg2 = new BigDecimal((double)frac2.getNumerator()/ frac2.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bg3 = new BigDecimal((double)frac3.getNumerator()/frac3.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		
		question = "$" + bg1.toPlainString() + "\\times " + bg2.toString() + " = " + "\\Box" + "$";
		
		String heading = mSource.getMessage(Constants.GRADE_7_MULTIPLY_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH) + " " +
				mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine(question));
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		answ.setAnswer(bg3.toString());
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question="";


		Fraction frac1 = new Fraction(MathUtilities.getRandomNumber(-2, -9), 10);
		Fraction frac2 = new Fraction(MathUtilities.getRandomNumber(12, 18), 10);
		Fraction frac3 = frac1.multiply(frac2);
		
		BigDecimal bg1 = new BigDecimal((double)frac1.getNumerator()/frac1.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bg2 = new BigDecimal((double)frac2.getNumerator()/ frac2.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bg3 = new BigDecimal((double)frac3.getNumerator()/frac3.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		
		question = "$" + bg1.toPlainString() + "\\times " + bg2.toString() + " = " + "\\Box" + "$";
		
		String heading = mSource.getMessage(Constants.GRADE_7_MULTIPLY_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH) + " "
				+ mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine(question));
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		answ.setAnswer(bg3.toString());
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question="";


		Fraction frac1 = new Fraction(MathUtilities.getRandomNumber(-2, -9), 10);
		Fraction frac2 = new Fraction(MathUtilities.getRandomNumber(-12, -18), 10);
		Fraction frac3 = frac1.multiply(frac2);
		
		BigDecimal bg1 = new BigDecimal((double)frac1.getNumerator()/frac1.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bg2 = new BigDecimal((double)frac2.getNumerator()/ frac2.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bg3 = new BigDecimal((double)frac3.getNumerator()/frac3.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		
		question = "$(" + bg1.toPlainString() + ")\\times (" + bg2.toString() + " ) = " + "\\Box" + "$";
		
		String heading = mSource.getMessage(Constants.GRADE_7_MULTIPLY_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine(question));
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		answ.setAnswer(bg3.toString());
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * 1.5 * 1.5 = 2.25 (when multiplied by more than 1, will the original number be increased?)
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String question1="", question2="", question3=""; 
		
		Fraction fracOriginal = new Fraction(MathUtilities.getRandomNumber(1, 9), 10);
		BigDecimal fracBg = new BigDecimal((double)fracOriginal.getNumerator()/ fracOriginal.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		
		Fraction frac1 = new Fraction(MathUtilities.getRandomNumber(1, 9), 10);
		BigDecimal bg1 = new BigDecimal((double)frac1.getNumerator()/ frac1.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		
		Fraction frac2 = new Fraction(MathUtilities.getRandomNumber(12, 18), 10);
		BigDecimal bg2 = new BigDecimal((double)frac2.getNumerator()/ frac2.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		
		Fraction frac3 = new Fraction(MathUtilities.getRandomNumber(-12, -18), 10);
		BigDecimal bg3 = new BigDecimal((double)frac3.getNumerator()/ frac3.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		
		
		question1 = "$"+ fracBg.toString() + "\\times" + bg1.toString() + "$";
		question2 = "$"+ fracBg.toString() + "\\times" + bg2.toString() + "$";
		question3 = "$"+ fracBg.toString() + "\\times(" + bg3.toString() + ")$";
	
			
		questionList.add(new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine("Select A or B when: ", null, Constants.DEFAULT));
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GREATER_THAN_ORIGINAL_NUMBER, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine(mSource.getMessage(Constants.LESS_THAN_ORIGINAL_NUMBER, null, Locale.ENGLISH), null, Constants.DEFAULT));
		
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + "B" ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + "A" ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + "B", null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(Constants.GRADE_7_MULTIPLY_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question="";


		Fraction frac1 = new Fraction(MathUtilities.getRandomNumber(2, 9), 10);
		Fraction frac2 = new Fraction(MathUtilities.getRandomNumber(12, 18), 10);
		Fraction frac3 = frac1.multiply(frac2);
		
		BigDecimal bg1 = new BigDecimal((double)frac1.getNumerator()/frac1.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bg2 = new BigDecimal((double)frac2.getNumerator()/ frac2.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bg3 = new BigDecimal((double)frac3.getNumerator()/frac3.getDenominator()).setScale(2, RoundingMode.HALF_UP);
		
		question = "$" + bg1.toPlainString() + "\\times " + "\\Box " + " = " + bg3.toString() + "$";
		
		String heading = mSource.getMessage(Constants.GRADE_7_MULTIPLY_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH) + " " +
				mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine(question));
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		answ.setAnswer(bg2.toString());
		problem.setAnswer(answ);

		return problem;
	}

}
