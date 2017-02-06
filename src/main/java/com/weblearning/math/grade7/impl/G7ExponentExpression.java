package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ExponentExpression extends GenericQuestion {
	

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentExpression = new ArrayList<Problem>();
		
		for (int i = 0; i <25; i++)
			g7ExponentExpression.add(getProblem1(mathConfig));
		

		return g7ExponentExpression;
	}

	/*
	 * Exponentiation
	 * This will create  a problem as 2^2 -10=-6
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		int answer =0;
		
		//get a random first number
		
		int firstNumber = MathUtilities.getRandomNumber(-10, 10);
		int secondNumber = MathUtilities.getRandomNumber(-1000, 1000);
		int pow = MathUtilities.getRandomNumber(1, 3);
		
		if (secondNumber >=0)
			question = "$"+firstNumber +"^{" +pow+"}$" + " + " + secondNumber;
		else
			question = "$"+firstNumber +"^{" +pow+"}$" + " + " + secondNumber;
		
		answer = (int) Math.pow(firstNumber, pow) + secondNumber;
			
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_EXPRESSION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, Integer.toString(answer), heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	

}
