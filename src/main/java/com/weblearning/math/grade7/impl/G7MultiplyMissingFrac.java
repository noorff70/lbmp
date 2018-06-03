package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.fraction.Fraction;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.utility.FractionObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7MultiplyMissingFrac extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> grade6MultiplyFraction = new ArrayList<Problem>();

		for (int i = 0; i < 10; i++) {
			for (int j = 1; j <= 2; j++)
				grade6MultiplyFraction.add(getProblem(mathConfig, j));
		}

		return grade6MultiplyFraction;
	}

	// Find the missing fraction
	public Problem getProblem(MathConfiguration mathConfig, int rule) {

		CreateProblem cProblem = new CreateProblem();
		Problem problem= null;;
		Answer answ = new Answer();
		int numerator1, denominator1, numerator2, denominator2;
		numerator1 = denominator1 = numerator2 = denominator2 = 0;

		List<FractionObject> fractionList = new ArrayList<FractionObject>();
		FractionObject fracObject1 = new FractionObject();
		FractionObject fracObject2 = new FractionObject();
		String question = null;
		Fraction result = new Fraction(0, 1);

		List<QuestionLine> questionList = new ArrayList<QuestionLine>();

		// create the first object numerator/denominator
		numerator1 = MathUtilities.getRandomNumber(1, 10);
		denominator1 = MathUtilities.getRandomNumber(11, 20);

		// create the second fraction object numerator/denominator
		numerator2 = MathUtilities.getRandomNumber(1, 10);
		denominator2 = MathUtilities.getRandomNumber(12, 30);

		switch (rule) {

		case 1:

			// create the first fraction object
			fracObject1.setNumerator(numerator1);
			fracObject1.setDenominator(denominator1);
			fracObject1.setPrefix(Constants.SIGN_PLUS);
			fracObject1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			fracObject1.setMissingFraction(true);

			// create the second fraction object
			fracObject2.setNumerator(numerator2);
			fracObject2.setDenominator(denominator2);
			fracObject2.setPrefix(Constants.SIGN_MULTIPLY);
			fracObject2.setFractionType(Constants.FRACTION_TYPE_NORMAL);

			break;
			
		case 2:
			// create the first fraction object
			fracObject1.setNumerator(numerator1);
			fracObject1.setDenominator(denominator1);
			fracObject1.setPrefix(Constants.SIGN_PLUS);
			fracObject1.setFractionType(Constants.FRACTION_TYPE_NORMAL);


			// create the second fraction object
			fracObject2.setNumerator(numerator2);
			fracObject2.setDenominator(denominator2);
			fracObject2.setPrefix(Constants.SIGN_MULTIPLY);
			fracObject2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			fracObject2.setMissingFraction(true);

			break;
			

		}
		
		// add the fraction objects to list
		fractionList.add(fracObject1);
		fractionList.add(fracObject2);
		
		// get the question back as a string
		question = MathUtilities.getQuestionAsStringFraction(fractionList);
		// get the result of the output
		result = MathUtilities.getResultAsFraction(fractionList);
		// create the string as X * 2/3 = 4/5(result)
		question = question + " = " + result.toString();

		QuestionLine qLine = new QuestionLine(question);
		// qLine.setQuestionLn(question);
		questionList.add(qLine);
		String heading = Constants.GRADE_7_CONTENT_FIND_MISSING_FRACTION_FOR_MULTIPLICATION;

		if (rule ==1) {
			problem = cProblem.constructProblem(questionList, heading,  Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			answ.setAnswer(new Fraction(numerator1, denominator1).toString());
			problem.setAnswer(answ);
		}
		else if (rule ==2) {
			problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			answ.setAnswer(new Fraction(numerator2, denominator2).toString());
			problem.setAnswer(answ);
		}
		
		return problem;

	}
	
}
