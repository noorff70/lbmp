package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.math3.fraction.Fraction;
import org.springframework.context.MessageSource;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.utility.FractionObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7SimplifyFraction extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g6SimplifyFraction = new ArrayList<Problem>();
		
		for (int i=0; i< 20; i++)
			g6SimplifyFraction.add(getProblem(mathConfig));
		
		return g6SimplifyFraction;
	}
	
	private Problem getProblem(MathConfiguration mathConfig){
		
		String fractionType = null;
		int multiplier= 2;
		
		MessageSource mSource = mathConfig.getmSource();
		
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		//get the numerator and denominator
		int numerator = MathUtilities.getRandomNumber(2, 20);
		int denominator = MathUtilities.getRandomNumber(numerator, 50);
		
		//get a list of factors of numerator
		Map numeratorMap = MathUtilities.getFactors();
		List numeratorList = (List) numeratorMap.get(numerator);
		
		//multiply denominator with a factor of numerator except 1 and the numerator itself
		for (int i=0; i<numeratorList.size(); i++ ){
			int number = (int) numeratorList.get(i);
			if (number ==1 || number == numerator)
				continue;
			else{
				multiplier = number;
				break;
			}
		}
		denominator *= multiplier;
		
		//find out what type of fraction this becomes	
		if (numerator> denominator)
			fractionType = Constants.FRACTION_TYPE_MIXED;
		else if (numerator < denominator)
			fractionType = Constants.FRACTION_TYPE_NORMAL;
		else if (numerator == denominator)
			fractionType = Constants.FRACTION_TYPE_WHOLE;
		
		FractionObject questionObject = MathUtilities.getFractionAsString(numerator, denominator, fractionType);
		
		Fraction rFrac = Fraction.getReducedFraction(numerator, denominator);
		
		//create a list of fraction objects
		List<FractionObject> qList = new ArrayList<FractionObject>();
		qList.add(questionObject);
				
		//get the fraction with a string representation
		String question = MathUtilities.getQuestionAsStringFraction(qList);
		
		
		//add the questions
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.SIMPLIFY_FRACTION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		String heading = mSource.getMessage(Constants.GRADE_7_SIMPLIFY_FRACTION, null, Locale.ENGLISH);
		String subHeading = "";
		
		Problem problem = cProblem.constructProblem(questionList, rFrac.toString(), heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		return problem;
		
	}

}
