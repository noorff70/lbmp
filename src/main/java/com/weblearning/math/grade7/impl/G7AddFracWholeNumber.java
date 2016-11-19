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
import com.weblearning.domain.utility.FractionObject;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7AddFracWholeNumber extends Question {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> addSubtractFraction = new ArrayList<Problem>();


		for (int i = 0; i < 15; i++)
			addSubtractFraction.add(getProblem1(mathConfig));
		
		for (int i = 0; i < 10; i++)
			addSubtractFraction.add(getProblem2(mathConfig));

		return addSubtractFraction;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		
		MessageSource mSource = mathConfig.getmSource();

		List<FractionObject> fractionList = new ArrayList<FractionObject>();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Fraction result = new Fraction(0, 1);
		String question = "";
		String answer = "";
		
		int wholeNumber = MathUtilities.getRandomNumber(1, 10);

		int numerator = MathUtilities.getRandomNumber(1, 5);
		int denominator = MathUtilities.getRandomNumber(numerator + 1, 20);

		//whle number construction
		FractionObject fo1 = new FractionObject();
		fo1.setDenominator(1);
		fo1.setNumerator(wholeNumber);
		fo1.setFractionType(Constants.FRACTION_TYPE_WHOLE);
		fo1.setPrefix("+");
		fo1.setPostFix("+");
		
		//mixed number construction
		FractionObject fo = new FractionObject();
		fo.setNumerator(numerator);
		fo.setDenominator(denominator);
		fo.setFractionType(Constants.FRACTION_TYPE_NORMAL);
		fo.setPrefix("+");
		fo.setPostFix("+");
		
		fractionList.add(fo1);
		fractionList.add(fo);
		

		question = MathUtilities.getQuestionAsStringFraction(fractionList);
		result = MathUtilities.getResultAsFraction(fractionList);
		answer = MathUtilities.convertSingleFRactionToString(result.getNumerator(), result.getDenominator());

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.ADD_THE_FOLLOWING_IMPROPER_FRACTION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_ADD_FRACTION_WITH_WHOLE_NUMBER, null, Locale.ENGLISH);
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, result.toString(), heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		
		MessageSource mSource = mathConfig.getmSource();

		List<FractionObject> fractionList = new ArrayList<FractionObject>();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Fraction result = new Fraction(0, 1);
		String question = "";
		String answer = null;
		
		int wholeNumber = MathUtilities.getRandomNumber(1, 10);

		int numerator = MathUtilities.getRandomNumber(1, 5);
		int denominator = MathUtilities.getRandomNumber(numerator + 1, 20);

		FractionObject fo1 = new FractionObject();
		fo1.setDenominator(1);
		fo1.setNumerator(wholeNumber);
		fo1.setFractionType(Constants.FRACTION_TYPE_WHOLE);
		fo1.setPrefix("+");
		fo1.setPostFix("+");
		
		FractionObject fo = new FractionObject();
		fo.setNumerator(numerator);
		fo.setDenominator(denominator);
		fo.setFractionType(Constants.FRACTION_TYPE_NORMAL);
		fo.setPrefix("+");
		fo.setPostFix("+");
		
		fractionList.add(fo1);
		fractionList.add(fo);
		

		question = MathUtilities.getQuestionAsStringFraction(fractionList);
		result = MathUtilities.getResultAsFraction(fractionList);
		
		int numeratorResult = result.getNumerator();
		int denominatorResult = result.getDenominator();
		int wholeResult =0;
		
		if (numeratorResult>denominatorResult){
			wholeResult = numeratorResult/denominatorResult;
			numeratorResult = numeratorResult%denominatorResult;
		}
		result = Fraction.getReducedFraction(numeratorResult, denominatorResult);
		answer = Integer.toString(wholeResult) + MathUtilities.convertSingleFRactionToString(result.getNumerator(), result.getDenominator());
		

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.ADD_THE_FOLLOWING_MIXED_FRACTION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_ADD_FRACTION_WITH_WHOLE_NUMBER, null, Locale.ENGLISH);
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, answer, heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}

}
