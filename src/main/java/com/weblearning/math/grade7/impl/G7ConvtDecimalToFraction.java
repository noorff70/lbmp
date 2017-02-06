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

public class G7ConvtDecimalToFraction extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7ConvtDecimalToFraction = new ArrayList<Problem>();
		
		for (int i=0; i< 25; i++)
			g7ConvtDecimalToFraction.add(getProblem(mathConfig));
		
		return g7ConvtDecimalToFraction;
	}
	
	private Problem getProblem(MathConfiguration mathConfig){
		
		String question = null;
		String answer = null;
		
		MessageSource mSource = mathConfig.getmSource();
		
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		//generate a random number from 1-50
		int randomNumber = MathUtilities.getRandomNumber(1, 50);
		int numerator=0;

		double decimalNumber =0;
		Fraction frac = new Fraction(0,1);

		//get 1 for 10 and 2 for 100 to divide
		int divisible = MathUtilities.getRandomNumber(1,2);
		
		//if 1 then divide by 10
		if (divisible==1){
			decimalNumber = (double)randomNumber/10;
			//get original value again
			Double dValue = new Double(decimalNumber*10);
			//convert to int value to be used for fraction
			numerator = dValue.intValue();
			frac = Fraction.getReducedFraction(numerator, 10);
			
		}
		else if (divisible==2){
			decimalNumber = (double)randomNumber/100;
			Double dValue = new Double(decimalNumber*100);
			numerator = dValue.intValue();
			frac = Fraction.getReducedFraction(numerator, 100);
		}

		
		question = Double.toString(decimalNumber);
		answer = MathUtilities.convertSingleFRactionToString(frac.getNumerator(), frac.getDenominator());
		
		
		//add the questions
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_7_CONVERT_DECIMAL_TO_FRACTION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		String heading = mSource.getMessage(Constants.GRADE_7_CONVERT_DECIMAL_TO_FRACTION, null, Locale.ENGLISH);
		
		Problem problem = cProblem.constructProblem(questionList, answer, heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		return problem;
		
	}
	
}
