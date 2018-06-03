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

public class G7PCTDecimal extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7pctIntegern = new ArrayList<Problem>();
		
		for (int i=0; i<25; i++)
			g7pctIntegern.add(getProblem(mathConfig));
		
		return g7pctIntegern;
	}
	
	private Problem getProblem(MathConfiguration mathConfig){
		
		String answer = "";
		
		MessageSource mSource = mathConfig.getmSource();
		Answer answ = new Answer();
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		//get the numerator and denominator
		int num1 = MathUtilities.getRandomNumber(1, 19);
		int num2 = MathUtilities.getRandomNumber(2, 100);
		int decimalPoint = 10* MathUtilities.getRandomNumber(1, 2);

		int numerator = num1*5;
				
		//get the fraction with a string representation
		String question = (float)numerator/decimalPoint + " % of " + num2; 
		
		//String answer = MathUtilities.convertSingleFRactionToString(num1*5, 100);
		Fraction rFrac = Fraction.getReducedFraction(numerator*num2 , 100*decimalPoint);
		
		int whole = rFrac.getNumerator()/ rFrac.getDenominator();
		int remainder = rFrac.getNumerator() % rFrac.getDenominator();
		
		if (remainder ==0)
			answer = rFrac.toString();
		else if (rFrac.getNumerator() > rFrac.getDenominator()) {
			answer = whole + MathUtilities.convertSingleFRactionToString(rFrac.getNumerator()-whole * rFrac.getDenominator(), 
					rFrac.getDenominator());
		}
		else{
			answer = MathUtilities.convertSingleFRactionToString(rFrac.getNumerator(), rFrac.getDenominator());
		}
		
		
		//add the questions
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.CALCULATE_PERCENTAGE_OF_FRACTION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		QuestionLine qLine3 = new QuestionLine(mSource.getMessage(Constants.CONVERT_TO_IMPROPER_FRACTION_WHEN_NECESSARY, null, Locale.ENGLISH));
		questionList.add(qLine1);
		questionList.add(qLine2);
		questionList.add(qLine3);
		
		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_PERCENT, null, Locale.ENGLISH);
		answ.setAnswer(answer);
		
		Problem problem = cProblem.constructProblem(questionList, heading,  Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);
		
		return problem;
		
	}

}
