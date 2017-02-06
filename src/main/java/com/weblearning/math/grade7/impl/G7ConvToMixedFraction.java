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
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ConvToMixedFraction extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7ConvToMixed = new ArrayList<Problem>();
		
		for (int i=0; i< 25; i++)
			g7ConvToMixed.add(getProblem(mathConfig));
		
		return g7ConvToMixed;
	}
	
	private Problem getProblem(MathConfiguration mathConfig){
		
		String answer = null;
		
		MessageSource mSource = mathConfig.getmSource();
		
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		
		int denominator = MathUtilities.getRandomNumber(2, 20);
		int numerator = MathUtilities.getRandomNumber(denominator+1, 50);
		
		int whole = numerator/denominator;
		//remainder is now the new numerator ex 35%15= whole=2, newnumerator = 5, denominator =15
		int newNumerator = numerator % denominator;
		
		String question = MathUtilities.convertSingleFRactionToString(numerator, denominator);
		
		Fraction frac = Fraction.getReducedFraction(newNumerator, denominator);
		
		//this is a whole number
		if (newNumerator==0)
			answer = Integer.toString(whole);
		else
			answer = whole + MathUtilities.convertSingleFRactionToString(frac.getNumerator(), frac.getDenominator());
		
		//add the questions
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.CONVERT_THE_FOLLOWING_TO_MIXED_FRACTION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		String heading = mSource.getMessage(Constants.GRADE_7_CONVERT_TO_MIXED_FRACTION, null, Locale.ENGLISH);
		
		Problem problem = cProblem.constructProblem(questionList, answer, heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		return problem;
		
	}
	
}
