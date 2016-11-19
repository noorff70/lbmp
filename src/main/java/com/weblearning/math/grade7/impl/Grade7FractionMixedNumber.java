package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.fraction.Fraction;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.utility.FractionObject;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class Grade7FractionMixedNumber extends Question {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> addSubtractFraction = new ArrayList<Problem>();

		for (int i = 0; i < 2; i++)
			addSubtractFraction.add(getProblem1());

		

		return addSubtractFraction;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1() {

		CreateProblem cProblem = new CreateProblem();
		
		List<FractionObject> fractionList = new ArrayList<FractionObject>();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Fraction result = new Fraction(0, 1);
		String question = "";

		Map<Integer, String> fractionType = new HashMap<Integer, String>();
		Map<Integer, String> signType = new HashMap<Integer, String>();
		
		fractionType.put(1, Constants.FRACTION_TYPE_MIXED);
		fractionType.put(2, Constants.FRACTION_TYPE_NORMAL);
		
		signType.put(1, Constants.SIGN_PLUS);
		signType.put(2, Constants.SIGN_MINUS);
		
		int numberOfFractions = MathUtilities.getRandomNumber(2, 4);
		
		for (int i=0; i<numberOfFractions; i++) {
			
			FractionObject fracObject = new FractionObject();
			String fraction = (String)fractionType.get(MathUtilities.getRandomNumber(1, 2));
			
			int numerator=0;
			int denominator= 0;
			
			if (fraction.equals(Constants.FRACTION_TYPE_MIXED)){
				numerator = MathUtilities .getRandomNumber(2, 20);
				denominator = MathUtilities.getRandomNumber(2, numerator-1);
				fracObject.setFractionType(Constants.FRACTION_TYPE_MIXED);
			}
			else{
				numerator = MathUtilities.getRandomNumber(2, 20);
				denominator = MathUtilities.getRandomNumber(numerator+1, 20);
				fracObject.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			}
			
			fracObject.setNumerator(numerator);
			fracObject.setDenominator(denominator);
			fracObject.setPrefix((String) signType.get(MathUtilities.getRandomNumber(1, 2)));
			fracObject.setPostFix((String) signType.get(MathUtilities.getRandomNumber(1, 2)));
			
			fractionList.add(fracObject);
			
		}
				
		result = MathUtilities.getResultAsFraction(fractionList);
		question = MathUtilities.getQuestionAsStringFraction(fractionList);
		

		QuestionLine qLine = new QuestionLine();
		qLine.setQuestionLn(question);
		questionList.add(qLine);

		String heading = Constants.GRADE_7_CONTENT_ADD_FRACTION;
		String subHeading = "Adding two Fractions";

		Problem problem = cProblem.constructProblem(questionList, result.toString(), heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}

}
