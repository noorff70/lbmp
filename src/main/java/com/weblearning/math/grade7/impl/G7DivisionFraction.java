package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
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

public class G7DivisionFraction extends Question {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> grade6DivisionFraction = new ArrayList<Problem>();

		for (int i = 0; i < 5; i++){
			//j stands for rule. rules can be 1,2 ,3 etc
			for (int j=1; j<=4; j++){
				grade6DivisionFraction.add(getProblem1(mathConfig, j));
			}
		}

		return grade6DivisionFraction;
	}

	/*
	 * Multiply simple fraction
	 */
	public Problem getProblem1(MathConfiguration mathConfig, int rule) {

		CreateProblem cProblem = new CreateProblem();

		List<FractionObject> fractionList = new ArrayList<FractionObject>();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Fraction result = new Fraction(0, 1);
		String question = "";
		

		fractionList = getListOfFRactionObjects(rule, mathConfig);
		question = MathUtilities.getQuestionAsStringFraction(fractionList);
		
		result = MathUtilities.getResultAsFraction(fractionList);

		QuestionLine qLine = new QuestionLine();
		qLine.setQuestionLn(question);
		questionList.add(qLine);

		String heading = Constants.GRADE_7_CONTENT_SIMPLE_MULTIPLICATION;
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, result.toString(), heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
	public List<FractionObject> getListOfFRactionObjects (int rule, MathConfiguration mathConfig){
		
		List<FractionObject> fractionList = new ArrayList<FractionObject>();
		FractionObject fracObject1 = new FractionObject();
		FractionObject fracObject2 = new FractionObject();
		
		int numerator1, denominator1, numerator2, denominator2;
		numerator1=denominator1=numerator2=denominator2=0;
		
		Map mapFactor = mathConfig.getFactors();
		
		
		switch (rule){
		
		//multiplication between two fractions without simplification
		case(1):
			

			//Get the first fraction where numerator <denominator and denominator doesnot have any factor of numerator
			numerator1 = MathUtilities.getRandomNumber(1, 5);
			List numerator1List = (List) mapFactor.get(numerator1);
			denominator1 = MathUtilities.getRandomNumber(6, 10);
			while (containsFactor(numerator1List, (List)mapFactor.get(denominator1))){
				denominator1 = MathUtilities.getRandomNumber(2, 20);
			}			
		
			fracObject1.setNumerator(numerator1);
			fracObject1.setDenominator(denominator1);
			fracObject1.setPrefix(Constants.SIGN_PLUS);
			fracObject1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
		
			//Get the second numerator and denominator
			numerator2 = MathUtilities.getRandomNumber(1, 5);
		
			while (containsFactor((List)mapFactor.get(numerator2), (List)mapFactor.get(denominator1))){
				numerator2 = MathUtilities.getRandomNumber(3, 20);
			}
			
			denominator2 = MathUtilities.getRandomNumber(6,20);
			List numerator1numerator2 = (List) mapFactor.get(numerator1 * numerator2);
			while (containsFactor(numerator1numerator2, (List)mapFactor.get(denominator2)) ){
				denominator2 = MathUtilities.getRandomNumber(3, 20);
			}
			
			fracObject2.setNumerator(numerator2);
			fracObject2.setDenominator(denominator2);
			fracObject2.setPrefix(Constants.SIGN_DIVISION);
			fracObject2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
		
			fractionList.add(fracObject1);
			fractionList.add(fracObject2);
				
			break;
		
		//multiplication between two fractions with a whole number
		case(2):
			
			//construct the first fraction- numerator= whole number and denominator any random number from 1-10
			numerator1 = MathUtilities.getRandomNumber(1, 10);
			fracObject1.setNumerator(numerator1);
			fracObject1.setDenominator(1);
			fracObject1.setPrefix(Constants.SIGN_PLUS);
			fracObject1.setFractionType(Constants.FRACTION_TYPE_WHOLE);
			
			//Get the second numerator from 2-10 inclusive
			numerator2 = MathUtilities.getRandomNumber(2, 10);
			
			//Get the second denominator
			denominator2 = MathUtilities.getRandomNumber(11, 30);
			
			fracObject2.setNumerator(numerator2);
			fracObject2.setDenominator(denominator2);
			fracObject2.setPrefix(Constants.SIGN_DIVISION);
			fracObject2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			fractionList.add(fracObject1);
			fractionList.add(fracObject2);
			
			break;
			
		//multiplication of between a mixed fraction and a real fraction	
		case(3):
			
			numerator1 = MathUtilities.getRandomNumber(11, 20);
			denominator1 = MathUtilities.getRandomNumber(1, 10);
			
			fracObject1.setNumerator(numerator1);
			fracObject1.setDenominator(denominator1);
			fracObject1.setPrefix(Constants.SIGN_PLUS);
			fracObject1.setFractionType(Constants.FRACTION_TYPE_MIXED);
			
			numerator2 = MathUtilities.getRandomNumber(1, 10);
			denominator2 = MathUtilities.getRandomNumber(12, 30);
			
			fracObject2.setNumerator(numerator2);
			fracObject2.setDenominator(denominator2);
			fracObject2.setPrefix(Constants.SIGN_DIVISION);
			fracObject2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			fractionList.add(fracObject1);
			fractionList.add(fracObject2);
			
		
			//multiplication of between a mixed fraction and a real fraction	
		case(4):
						
			numerator1 = MathUtilities.getRandomNumber(11, 20);
			denominator1 = MathUtilities.getRandomNumber(1, 10);
						
			fracObject1.setNumerator(numerator1);
			fracObject1.setDenominator(denominator1);
			fracObject1.setPrefix(Constants.SIGN_PLUS);
			fracObject1.setFractionType(Constants.FRACTION_TYPE_MIXED);
						
			numerator2 = MathUtilities.getRandomNumber(1, 10);
			denominator2 = MathUtilities.getRandomNumber(12, 30);
						
			fracObject2.setNumerator(numerator2);
			fracObject2.setDenominator(denominator2);
			fracObject2.setPrefix(Constants.SIGN_MULTIPLY);
			fracObject2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
					
			fractionList.add(fracObject1);
			fractionList.add(fracObject2);
			break;
			
		}
		
		return fractionList;
	}
	
	/*returns true if the factors of denominator is also common in factors of numerator.
	 * 
	 */
	public boolean containsFactor(List<?> listFactor1, List<?> listFactor2 ){
		
		
		for (int i=0; i< listFactor1.size(); i++){
			int factor1 = (int) listFactor1.get(i);
			for (int j=0; j<listFactor2.size(); j++){
				int factor2 = (int) listFactor2.get(j);
				if (factor1 == factor2 && (factor1 !=1 || factor2 !=1))
					return true;
			}
		}
		return false;
	}
	

}

