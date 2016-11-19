package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.utility.FractionObject;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class Grade7FractionMissingNumber extends Question {
	
	private static final Logger logger = Logger.getLogger(Grade7FractionMissingNumber.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> addSubtractFraction = new LinkedList<Problem>();

		for (int i=0; i<20; i++){
			//either three or four items in the statement
			//for (int j = 2; j<=3 ; j++)
			int j=2;//have 2 fractions in the equation
				addSubtractFraction.add(getProblem1(j, mathConfig));
		}
			
		return addSubtractFraction;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(int numberOfFractions, MathConfiguration mathConfig) {

		MessageSource mSource = mathConfig.getmSource();
		
		CreateProblem cProblem = new CreateProblem();
		
		List<FractionObject> fractionList = new ArrayList<FractionObject>();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Fraction result = new Fraction(0, 1);
		String question = "";
		String missingResult = null;

		//fraction type- whole, mixed or normal
		Map<Integer, String> fractionType = new HashMap<Integer, String>();
		//signtype + or -
		Map<Integer, String> signType = new HashMap<Integer, String>();
		
		fractionType.put(1, Constants.FRACTION_TYPE_MIXED);
		fractionType.put(2, Constants.FRACTION_TYPE_NORMAL);
		
		signType.put(1, Constants.SIGN_PLUS);
		signType.put(2, Constants.SIGN_MINUS);
		
		//this number will tell which one of the fraction will be missing
		int missingNumber = MathUtilities.getRandomNumber(1, 2);
		
		//position 0= numerator, 1= denominator
		int numeratorDenominators[] = new int [2];
		
		for (int i=1; i<=numberOfFractions; i++) {
			
			FractionObject fracObject = new FractionObject();
			String fraction = (String)fractionType.get(MathUtilities.getRandomNumber(1, 2));
			//String fraction = Constants.FRACTION_TYPE_NORMAL;
			
			if (fraction.equals(Constants.FRACTION_TYPE_MIXED)){
				numeratorDenominators = MathUtilities.getNumeratorDenominator(2, 10, Constants.FRACTION_TYPE_MIXED);
				fracObject.setFractionType(Constants.FRACTION_TYPE_MIXED);
			}
			else{
				numeratorDenominators = MathUtilities.getNumeratorDenominator(2, 10, Constants.FRACTION_TYPE_NORMAL);
				fracObject.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			}
			
			//i= missing number which is a random number. if this is the missing number then put an X
			if (i== missingNumber){
				fracObject.setMissingFraction(true);
				Fraction missingFraction = new Fraction (numeratorDenominators[0], numeratorDenominators[1]);
				missingResult = missingFraction.toString();
			}
			else
				fracObject.setMissingFraction(false);

			fracObject.setNumerator(numeratorDenominators[0]);
			fracObject.setDenominator(numeratorDenominators[1]);
			fracObject.setPrefix((String) signType.get(MathUtilities.getRandomNumber(1, 2)));
			fracObject.setPostFix((String) signType.get(MathUtilities.getRandomNumber(1, 2)));
			
			fractionList.add(fracObject);
			
		}
		//get the result as a fraction		
		result = MathUtilities.getResultAsFraction(fractionList);

		//pass this result as Fraction to get a FractionObject
		FractionObject resultObject = MathUtilities.getFractionAsString(result);
		
		List<FractionObject> resultList = new ArrayList<FractionObject>();
		resultList.add(resultObject);
		
		//get the formatted result
		String result1 = MathUtilities.getQuestionAsStringFraction(resultList);
		question = MathUtilities.getQuestionAsStringFraction(fractionList) + " = " + result1;
		
		//Set the question
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_VALUE_OF_X, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = Constants.GRADE_7_CONTENT_FIND_MISSING_FRACTION;
		String subHeading = "Adding two Fractions";

		Problem problem = cProblem.constructProblem(questionList, missingResult, heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}

}
