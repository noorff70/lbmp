package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7SquareAndRoots extends GenericQuestion {
	


	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentDecimalFraction = new ArrayList<Problem>();

		for (int i=0; i< 5; i++)
			g7ExponentDecimalFraction.add(getProblem1(mathConfig));
		for (int i=0; i< 5; i++)
			g7ExponentDecimalFraction.add(getProblem2(mathConfig));
		for (int i=0; i< 5; i++)
			g7ExponentDecimalFraction.add(getProblem3(mathConfig));
		for (int i=0; i< 3; i++)
			g7ExponentDecimalFraction.add(getProblem4(mathConfig));
		for (int i=0; i< 2; i++)
			g7ExponentDecimalFraction.add(getProblem5(mathConfig));

		return g7ExponentDecimalFraction;
	}

	/*
	 * Exponentiation
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		int randomNumber = MathUtilities.getRandomNumber(2, 10);
		Integer bg = new Integer(randomNumber * randomNumber);
		
		//create question and answer sections
		question = "$("+randomNumber +")^{" +2+"}$";

		answer = bg.toString();
	
		QuestionLine qLine1 = new QuestionLine("Find Square of the Following");
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = "Square and Square Roots";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		int randomNumber = MathUtilities.getRandomNumber(2,20);
		Integer bg = new Integer(randomNumber * randomNumber );
		
		//create question and answer sections
		question = "$\\sqrt"+bg +"$";

		answer = Integer.toString(randomNumber);
	
		QuestionLine qLine1 = new QuestionLine("Find Square Root of the following number");
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = "Square and Square Roots";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
	//	MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		int num1 = MathUtilities.getRandomNumber(1, 10);
		int num2 = MathUtilities.getRandomNumber(1, 10);
		
		int sqtNum1 = num1* num1;

		
		
		//create question and answer sections
		question = "$\\sqrt"+ Integer.toString(sqtNum1) +"\\Box" + Integer.toString(num2) + "$";
		
		if (num1> num2)
			answer = ">";
		else if (num1<num2)
			answer = "<";
		else 
			answer = "=";

	
		QuestionLine qLine1 = new QuestionLine("Compare left and right side and put either >, < or =");
		QuestionLine qLine3 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine3);

		String heading = "Square and Square Roots";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		int randomNumber = MathUtilities.getRandomNumber(101, 300);
		BigDecimal sqrt = new BigDecimal(Math.sqrt(randomNumber)).setScale(2, RoundingMode.HALF_UP); //get the square root with two decimal
		int upperVal=0;
		int lowerVal = (int)Math.sqrt(randomNumber);
		
		if (sqrt.doubleValue()> lowerVal)
			upperVal = lowerVal +1;
		else if  (sqrt.doubleValue() == lowerVal)
			upperVal = lowerVal;
			
		if (upperVal == lowerVal)
			question = "$\\sqrt" +  Integer.toString(randomNumber) + "$ of is $\\Box$";
		else
			question = "$ \\sqrt" + Integer.toString(randomNumber) + "$ is between " + Integer.toString(lowerVal) + " and $\\Box  $";

		answer = Integer.toString(upperVal);
	
		QuestionLine qLine1 = new QuestionLine(question);

		questionList.add(qLine1);

		String heading = "Square and Square Roots";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		int randomNumber = MathUtilities.getRandomNumber(101, 300);
		BigDecimal sqrt = new BigDecimal(Math.sqrt(randomNumber)).setScale(2, RoundingMode.HALF_UP); //get the square root with two decimal
		int upperVal=0;
		int lowerVal = (int)Math.sqrt(randomNumber);
		
		if (sqrt.doubleValue()> lowerVal)
			upperVal = lowerVal +1;
		else if  (sqrt.doubleValue() == lowerVal)
			upperVal = lowerVal;
			
		if (upperVal == lowerVal)
			question = "$\\sqrt" +  Integer.toString(randomNumber) + "$ of is $\\Box$";
		else 		
			question = "$\\sqrt " + Integer.toString(randomNumber) + "$"+ " is between " +"$\\Box $" +" and"  + Integer.toString(upperVal);

		answer = Integer.toString(lowerVal);
	
		QuestionLine qLine1 = new QuestionLine(question);

		questionList.add(qLine1);

		String heading = "Square and Square Roots";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	
}
