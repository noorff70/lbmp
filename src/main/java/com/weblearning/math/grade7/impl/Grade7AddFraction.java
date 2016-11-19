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

public class Grade7AddFraction extends Question {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> addSubtractFraction = new ArrayList<Problem>();

		for (int i = 0; i < 2; i++)
			addSubtractFraction.add(getProblem1(2, false));

		for (int i = 0; i < 2; i++)
			addSubtractFraction.add(getProblem1(3, false));

		for (int i = 0; i < 2; i++)
			addSubtractFraction.add(getProblem1(4, false));

		//this will create a whole number and a fraction ex (1 + 5/7)
		for (int i = 0; i < 2; i++)
			addSubtractFraction.add(getProblem1(2, true));

		return addSubtractFraction;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(int numberofFractions, boolean wholeNumber) {

		CreateProblem cProblem = new CreateProblem();

		List<FractionObject> fractionList = new ArrayList<FractionObject>();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Fraction result = new Fraction(0, 1);
		String question = "";
		int numerator=0;
		int denominator= 0;

		for (int i = 0; i < numberofFractions; i++) {
			numerator = MathUtilities.getRandomNumber(1, 8);
			
			if (wholeNumber && i==0){
				denominator = numerator;
			}
			else 
				denominator = MathUtilities.getRandomNumber(numerator + 1,9);

			FractionObject fo = new FractionObject();
			fo.setNumerator(numerator);
			fo.setDenominator(denominator);
			fo.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			fo.setPrefix("+");
			fo.setPostFix("+");
			fractionList.add(fo);
		}

		question = MathUtilities.getQuestionAsStringFraction(fractionList);
		result = MathUtilities.getResultAsFraction(fractionList);

		QuestionLine qLine = new QuestionLine();
		qLine.setQuestionLn(question);
		questionList.add(qLine);

		String heading = Constants.GRADE_7_CONTENT_ADD_FRACTION;
		String subHeading = "Adding two Fractions";

		Problem problem = cProblem.constructProblem(questionList, result.toString(), heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}

}
