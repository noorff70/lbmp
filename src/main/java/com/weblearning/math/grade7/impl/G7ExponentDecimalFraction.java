package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.math3.fraction.Fraction;
import org.springframework.context.MessageSource;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ExponentDecimalFraction extends Question {
	


	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentDecimalFraction = new ArrayList<Problem>();

		for (int i = 0; i <15; i++)
			g7ExponentDecimalFraction.add(getProblem1(mathConfig));
		
		for (int i = 0; i <10; i++)
			g7ExponentDecimalFraction.add(getProblem2(mathConfig));
		

		return g7ExponentDecimalFraction;
	}

	/*
	 * Exponentiation
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		double randomNumber = (double)MathUtilities.getRandomNumber(-100, 100);
		int decimalPoint = MathUtilities.getRandomNumber(1, 2);
		randomNumber = (double)randomNumber/(Math.pow(10, decimalPoint));

		int pow = MathUtilities.getRandomNumber(1, 3);
		
		//create question and answer sections
		question = "$"+randomNumber +"^{" +pow+"}$";
		answer = Double.toString(MathUtilities.getRoundedAnswer((double) Math.pow(randomNumber, pow), 4));

		//remove leading zeros
		answer = answer.replaceFirst("^0+(?!$)", "");
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.INTEGER_EXPONENTIATION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(mSource.getMessage(Constants.ROUND_UPTO_FOUR_DECIMAL_POSITION, null, Locale.ENGLISH));
		QuestionLine qLine3 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);
		questionList.add(qLine3);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, answer, heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";;
		
		//get a random first number
		
		int numerator=0;
		int denominator =0;
		
		numerator = MathUtilities.getRandomNumber(1, 10);
		denominator = MathUtilities.getRandomNumber(numerator+1, 20);
		
		Fraction originalFraction = new Fraction(numerator, denominator);
		Fraction resultFraction = new Fraction(numerator, denominator);
		
		question = MathUtilities.convertSingleFRactionToString(numerator, denominator);

		int pow = MathUtilities.getRandomNumber(0, 3);
		
		question = "$\\left("+numerator+"\\over" +denominator+"\\right)^{" +pow+"}$";
		
		//when power =0; answer =1
		if (pow ==0)
			answer = Integer.toString(1);
		else if (pow ==1) //when power =1; answer = same result
			answer = MathUtilities.convertSingleFRactionToString(originalFraction.getNumerator(), originalFraction.getDenominator());
		else {
			for (int i = 1; i < pow; i++) {
				resultFraction = resultFraction.multiply(originalFraction);
			}
			answer = MathUtilities.convertSingleFRactionToString(resultFraction.getNumerator(), resultFraction.getDenominator());
		}
		
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.INTEGER_EXPONENTIATION, null, Locale.ENGLISH));
		QuestionLine qLine3 = new QuestionLine(question);

		questionList.add(qLine1);;
		questionList.add(qLine3);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, answer, heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
}
