package com.weblearning.math.grade7.impl;

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
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7IdentifyFractionType extends GenericQuestion{

	private int noOfMixedFraction;
	
	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7IdentifyFractionType = new ArrayList<Problem>();
		
		
		for (int i=0; i< 25; i++)
			g7IdentifyFractionType.add(getProblem(mathConfig));
		
		return g7IdentifyFractionType;
	}
	
	private Problem getProblem(MathConfiguration mathConfig){
			
		MessageSource mSource = mathConfig.getmSource();
		Answer answer = new Answer();
		
		String result = "";
		
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		
		int numerator = MathUtilities.getRandomNumber(1, 30);
		int denominator = MathUtilities.getRandomNumber(1,30);
		
		//do not want a whole number. in case they are same increase denominator
		if (numerator == denominator)
			denominator++;
		
		int wholeNumber = 0;
		int newNumerator = 0;
		
		//after every i%2==0, we ware going to make the improper fraction a mixed fraction
		if (numerator > denominator){
			noOfMixedFraction++;
			if (noOfMixedFraction%2==0){
				wholeNumber = numerator/denominator;
				newNumerator = numerator% denominator;
				Fraction frac = Fraction.getReducedFraction(newNumerator, denominator);
				newNumerator = frac.getNumerator();
				denominator = frac.getDenominator();
				result = Constants.FRACTION_TYPE_MIXED_ANSWER;
			}
			setNoOfMixedFraction(noOfMixedFraction);
			
		}
		//if it is not a whole mixed number then find out if proper or improper
		if (wholeNumber == 0){
			result = fractionType(numerator, denominator);
		}
		
	//	answer.setType(Constants.RADIO_TYPE);
		answer.setAnswer(result);
		
		//construct question
		QuestionLine qLine1;
		if (wholeNumber > 0){
			//mixed number
			qLine1 = new QuestionLine(mSource.getMessage(Constants.SELECT_PROPER_TYPE_OF_FRACTION, null, Locale.ENGLISH)+ Integer.toString(wholeNumber) +
					MathUtilities.convertSingleFRactionToString(newNumerator, denominator), null, "");
		}
		else
			//proper or improper fraction
			qLine1 = new QuestionLine(mSource.getMessage(Constants.SELECT_PROPER_TYPE_OF_FRACTION, null, Locale.ENGLISH) + MathUtilities.convertSingleFRactionToString(numerator, denominator), null, "");
		 
		
		QuestionLine qLine2 = new QuestionLine(Constants.FRACTION_TYPE_PERFECT_ANSWER + " Perfect Fraction", "", "");
		QuestionLine qLine3 = new QuestionLine(Constants.FRACTION_TYPE_IMPERFECT_ANSWER + " Imperfect Fraction", "", "");
		QuestionLine qLine4 = new QuestionLine(Constants.FRACTION_TYPE_MIXED_ANSWER + " Mixed Fraction", "", "");
		
		questionList.add(qLine1);
		questionList.add(qLine2);
		questionList.add(qLine3);
		questionList.add(qLine4);
		
		String heading = mSource.getMessage(Constants.GRADE_7_TYPE_OF_FRACTION, null, Locale.ENGLISH);
		
		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);
		
		return problem;
		
	}
	
	@SuppressWarnings("unused")
	private String fractionType(int numerator, int denominator){
		
		String fractionType = null;
		
		if (numerator> denominator)
			fractionType = Constants.FRACTION_TYPE_IMPERFECT_ANSWER;
		else if (numerator < denominator)
			fractionType = Constants.FRACTION_TYPE_PERFECT_ANSWER;
		
		return fractionType;
		
	}
	
	@SuppressWarnings("unused")
	private void setNoOfMixedFraction(int fractionNumber){
		noOfMixedFraction = fractionNumber;
		
	}
	

}
