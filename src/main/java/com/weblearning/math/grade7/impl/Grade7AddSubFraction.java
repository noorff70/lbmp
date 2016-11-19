package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.math3.fraction.Fraction;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.utility.FractionObject;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class Grade7AddSubFraction extends Question {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> addSubtractFraction = new ArrayList<Problem>();

		for (int j=0; j<5; j++){
			for (int i = 1; i < 6; i++)
				addSubtractFraction.add(getProblem1(i));
		}

		return addSubtractFraction;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(int ruleNumber) {

		CreateProblem cProblem = new CreateProblem();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String result = null;
		String[] questionAnswer = new String[2];
		String question = "";

		questionAnswer = getRule(Integer.toString(ruleNumber));

		question = questionAnswer[0];
		result = questionAnswer[1];

		QuestionLine qLine = new QuestionLine();
		qLine.setQuestionLn(question);
		questionList.add(qLine);

		String heading = Constants.GRADE_7_CONTENT_ADD_FRACTION;
		String subHeading = "Adding two Fractions";

		Problem problem = cProblem.constructProblem(questionList,
				result.toString(), heading, subHeading, Constants.RANK_ONE,
				Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}

	public String[] getRule(String rule) {

		FractionObject obj1 = new FractionObject();
		FractionObject obj2 = new FractionObject();
		FractionObject obj3 = new FractionObject();
		
		int numerratorDenominator1[] = new int[2];
		int numerratorDenominator2[] = new int[2];
		
		List<FractionObject> fractionList = new ArrayList<FractionObject>();
		Fraction f1, f2;

		int numerator1, denominator1, numerator2, denominator2;
		numerator1 = denominator1 = numerator2 = 100;
		denominator2 = -1;
		String result = "";
		String question = "";

		String[] returnedArray = new String[2];

		switch (rule) {
		case ("1"): // Two fractions with a positive result a/b - c/d >0

			numerator1 = MathUtilities.getRandomNumber(2, 10);
			denominator1 = MathUtilities.getRandomNumber(numerator1 + 1, 12);

			numerator2 = MathUtilities.getRandomNumber(1, 8);
			while (numerator2 > numerator1) {
				numerator2 = MathUtilities.getRandomNumber(1, 8);
			}

			denominator2 = MathUtilities.getRandomNumber(denominator1, 15);
			while (denominator2 < denominator1) {
				denominator2 = MathUtilities.getRandomNumber(denominator1 + 1,15);
			}

			numerratorDenominator1 = MathUtilities.getNumeratorDenominator(1, 10, Constants.FRACTION_TYPE_NORMAL);
			numerratorDenominator2 = MathUtilities.getNumeratorDenominator(1, 15, Constants.FRACTION_TYPE_NORMAL);
		
			f1 = new Fraction(numerator1, denominator1);
			f2 = new Fraction(numerator2, denominator2);
			
			/*while (f1.compareTo(f2)<0){
				numerratorDenominator2 = MathUtilities.getNumeratorDenominator(1, 15, Constants.FRACTION_TYPE_NORMAL);
				f2 = new Fraction(numerratorDenominator2[0], numerratorDenominator2[1]);
			}*/

			obj1.setNumerator(numerator1);
			obj1.setDenominator(denominator1);
			obj1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj1.setPrefix("+");
			obj1.setPostFix("-");

			obj2.setNumerator(numerator2);
			obj2.setDenominator(denominator2);
			obj2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj2.setPrefix("-");

			fractionList.add(obj1);
			fractionList.add(obj2);

			result = MathUtilities.getResultAsFraction(fractionList).toString();
			question = MathUtilities.getQuestionAsStringFraction(fractionList);

			returnedArray[1] = result;
			returnedArray[0] = question;

			break;

		case ("2"): // two fractions with a negative result a/b - c/d <0

			numerator1 = MathUtilities.getRandomNumber(2, 10);
			denominator1 = MathUtilities.getRandomNumber(numerator1 + 1, 12);

			numerator2 = MathUtilities.getRandomNumber(1, 8);
			while (numerator2 > numerator1) {
				numerator2 = MathUtilities.getRandomNumber(1, 8);
			}

			denominator2 = MathUtilities.getRandomNumber(denominator1, 15);
			while (denominator2 < denominator1) {
				denominator2 = MathUtilities.getRandomNumber(denominator1 + 1,
						15);
			}
			
			//numerratorDenominator1 = MathUtilities.getNumeratorDenominator(2, 10, Constants.FRACTION_TYPE_NORMAL);
			//numerratorDenominator2 = MathUtilities.getNumeratorDenominator(1, 8, Constants.FRACTION_TYPE_NORMAL);
	
			f1 = new Fraction(numerator1, denominator1);
			f2 = new Fraction(numerator2, denominator2);
			
			//while (f1.compareTo(f2)>0){
			//	numerratorDenominator2 = MathUtilities.getNumeratorDenominator(1, 8, Constants.FRACTION_TYPE_NORMAL);
			//	f2 = new Fraction(numerratorDenominator2[0], numerratorDenominator2[1]);
			//}

			//f1 = new Fraction(numerator1, denominator1);
			//f2 = new Fraction(numerator2, denominator2);

			obj1.setNumerator(numerator2);
			obj1.setDenominator(denominator2);
			obj1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj1.setPrefix("+");
			obj1.setPostFix("-");

			obj2.setNumerator(numerator1);
			obj2.setDenominator(denominator1);
			obj2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj2.setPrefix("-");

			fractionList.add(obj1);
			fractionList.add(obj2);

			result = MathUtilities.getResultAsFraction(fractionList).toString();
			question = MathUtilities.getQuestionAsStringFraction(fractionList);

			returnedArray[1] = result;
			returnedArray[0] = question;

			break;

		case ("3"): // Two fractions with both negative numbers -a/b -c/d

			numerator1 = MathUtilities.getRandomNumber(2, 10);
			denominator1 = MathUtilities.getRandomNumber(numerator1 + 1, 12);

			numerator2 = MathUtilities.getRandomNumber(1, 8);
			while (numerator2 > numerator1) {
				numerator2 = MathUtilities.getRandomNumber(1, 8);
			}

			denominator2 = MathUtilities.getRandomNumber(denominator1, 15);
			while (denominator2 < denominator1) {
				denominator2 = MathUtilities.getRandomNumber(denominator1 + 1,
						15);
			}

			f1 = new Fraction(numerator1, denominator1);
			f2 = new Fraction(numerator2, denominator2);

			obj1.setNumerator(numerator1);
			obj1.setDenominator(denominator1);
			obj1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj1.setPrefix("-");
			obj1.setPostFix("-");

			obj2.setNumerator(numerator2);
			obj2.setDenominator(denominator2);
			obj2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj2.setPrefix("-");

			fractionList.add(obj1);
			fractionList.add(obj2);

			result = MathUtilities.getResultAsFraction(fractionList).toString();
			question = MathUtilities.getQuestionAsStringFraction(fractionList);

			returnedArray[1] = result;
			returnedArray[0] = question;

			break;
			
			
		case ("4"): // Two fractions with both negative numbers -a/b -c/d

			numerator1 = MathUtilities.getRandomNumber(2, 10);
			denominator1 = numerator1;
			
			numerator2 = MathUtilities.getRandomNumber(2, 10);
			denominator2 = MathUtilities.getRandomNumber(denominator1, 15);
			

			f1 = new Fraction(numerator1, denominator1);
			f2 = new Fraction(numerator2, denominator2);

			obj1.setNumerator(numerator1);
			obj1.setDenominator(denominator1);
			obj1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj1.setPrefix("-");
			obj1.setPostFix("-");

			obj2.setNumerator(numerator2);
			obj2.setDenominator(denominator2);
			obj2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj2.setPrefix("-");

			fractionList.add(obj1);
			fractionList.add(obj2);

			result = MathUtilities.getResultAsFraction(fractionList).toString();
			question = MathUtilities.getQuestionAsStringFraction(fractionList);

			returnedArray[1] = result;
			returnedArray[0] = question;

			break;
			
		case ("5"): // Three fractions a/b + c/d - e/f

			numerator1 = MathUtilities.getRandomNumber(2, 10);
			denominator1 = MathUtilities.getRandomNumber(numerator1 + 1, 12);

			numerator2 = MathUtilities.getRandomNumber(1, 8);
			denominator2 = MathUtilities.getRandomNumber(denominator1, 15);
			
			int numerator3 = MathUtilities.getRandomNumber(1, 8);
			int denominator3 = MathUtilities.getRandomNumber(denominator1, 15);
			
			f1 = new Fraction(numerator1, denominator1);
			f2 = new Fraction(numerator2, denominator2);
			Fraction f3 = new Fraction(numerator3, denominator3);

			obj1.setNumerator(numerator1);
			obj1.setDenominator(denominator1);
			obj1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj1.setPrefix("+");
			obj1.setPostFix("+");

			obj2.setNumerator(numerator2);
			obj2.setDenominator(denominator2);
			obj2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj2.setPrefix("+");
			obj2.setPostFix("+");
			
			obj3.setNumerator(numerator3);
			obj3.setDenominator(denominator3);
			obj3.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			obj3.setPrefix("-");
			obj3.setPostFix("+");

			fractionList.add(obj1);
			fractionList.add(obj2);
			fractionList.add(obj3);

			result = MathUtilities.getResultAsFraction(fractionList).toString();
			question = MathUtilities.getQuestionAsStringFraction(fractionList);

			returnedArray[1] = result;
			returnedArray[0] = question;

			break;
			
		}
		
	return returnedArray;
	}

}
