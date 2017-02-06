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

public class G7SolveExponentEquation extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7SolveExponentEquation = new ArrayList<Problem>();


		for (int i = 0; i < 25; i++)
			g7SolveExponentEquation.add(getProblem1(mathConfig));
		

		return g7SolveExponentEquation;
	}

	/*
	 * Exponentiation
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		int answer = 0;
		
		//get a random first number
		int firstNumber = MathUtilities.getRandomNumber(2, 20);
		int pow =0;

		
		if (firstNumber >2 && firstNumber<=5)
			pow = MathUtilities.getRandomNumber(2, 4);
		else if(firstNumber >5 && firstNumber<=10)
			pow = MathUtilities.getRandomNumber(2, 3);
		else 
			pow = MathUtilities.getRandomNumber(2, 2);
		
		
		answer = (int) Math.pow(firstNumber, pow);
		question = "$"+firstNumber +"^{x}$  =" + answer;
				
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_VALUE_OF_X, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, Integer.toString(pow), heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	

	

}
