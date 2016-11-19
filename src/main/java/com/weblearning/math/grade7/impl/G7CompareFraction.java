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
import com.weblearning.domain.utility.FractionObject;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7CompareFraction extends Question{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7CompareFraction = new ArrayList<Problem>();
		
		for (int i=0; i< 25; i++)
			g7CompareFraction.add(getProblem(mathConfig));
		
		return g7CompareFraction;
	}
	
	private Problem getProblem(MathConfiguration mathConfig){
		
		String answer = null;
		
		MessageSource mSource = mathConfig.getmSource();
		
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		
		int numerator1 = MathUtilities.getRandomNumber(2, 50);
		int denominator1 = MathUtilities.getRandomNumber(numerator1, 50);
		double result1 = numerator1/(double)denominator1;
		String question1 = "A " + " " + MathUtilities.convertSingleFRactionToString(numerator1, denominator1);
		
		int numerator2 = MathUtilities.getRandomNumber(2, 50);
		int denominator2 = MathUtilities.getRandomNumber(numerator2, 50);
		double result2 = numerator2/(double)denominator2;
		String question2 = "B " + " " + MathUtilities.convertSingleFRactionToString(numerator2, denominator2);
		
		Fraction frac1 = Fraction.getReducedFraction(numerator1, denominator1);
		Fraction frac2 = Fraction.getReducedFraction(numerator2, denominator2);
		
		if (result1>result2)
			answer = "A";
		else if (result1<result2)
			answer = "B";
		
		
		//add the questions
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_OUT_LARGER_FRACTION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question1);
		QuestionLine qLine3 = new QuestionLine(question2);
		
		questionList.add(qLine1);
		questionList.add(qLine2);
		questionList.add(qLine3);
		
		String heading = mSource.getMessage(Constants.GRADE_7_COMPARE_FRACTION, null, Locale.ENGLISH);
		
		Problem problem = cProblem.constructProblem(questionList, answer, heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		return problem;
		
	}
	
	@SuppressWarnings("unused")
	private String fractionType(int numerator, int denominator){
		
		String fractionType = null;
		
		if (numerator> denominator)
			fractionType = Constants.FRACTION_TYPE_MIXED;
		else if (numerator < denominator)
			fractionType = Constants.FRACTION_TYPE_NORMAL;
		else if (numerator == denominator)
			fractionType = Constants.FRACTION_TYPE_WHOLE;
		
		return fractionType;
		
	}

}
