package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ExponentDecimalFraction extends GenericQuestion {
	


	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentDecimalFraction = new ArrayList<Problem>();

		for (int i=0; i< 5; i++)
			g7ExponentDecimalFraction.add(getProblem1(mathConfig));
		for (int i=0; i< 5; i++)
			g7ExponentDecimalFraction.add(getProblem2(mathConfig));
		for (int i=0; i< 5; i++)
			g7ExponentDecimalFraction.add(getProblem3(mathConfig));
		for (int i=0; i< 5; i++)
			g7ExponentDecimalFraction.add(getProblem4(mathConfig));
		for (int i=0; i< 5; i++)
			g7ExponentDecimalFraction.add(getProblem5(mathConfig));

		return g7ExponentDecimalFraction;
	}

	/*
	 * Exponentiation
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		double randomNumber = (double)MathUtilities.getRandomNumber(11, 15)/10;
		BigDecimal bg = new BigDecimal(randomNumber * randomNumber).setScale(2, RoundingMode.HALF_UP);
		
		//create question and answer sections
		question = "$("+randomNumber +")^{" +2+"}$";

		answer = bg.toString();
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.INTEGER_EXPONENTIATION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine("Round upto 2 Decimals");
		QuestionLine qLine3 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);
		questionList.add(qLine3);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		double randomNumber = (double)MathUtilities.getRandomNumber(11, 15)/10;
		BigDecimal bg = new BigDecimal(randomNumber * randomNumber * randomNumber).setScale(3, RoundingMode.HALF_UP);
		
		//create question and answer sections
		question = "$("+randomNumber +")^{" +3+"}$";

		answer = bg.toString();
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.INTEGER_EXPONENTIATION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine("Round upto 3 Decimals");
		QuestionLine qLine3 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);
		questionList.add(qLine3);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		double randomNumber = (double)MathUtilities.getRandomNumber(1, 9)/10;
		BigDecimal bg = new BigDecimal(randomNumber * randomNumber ).setScale(2, RoundingMode.HALF_UP);
		
		//create question and answer sections
		question = "$("+randomNumber +")^{" +2+"}$";

		answer = bg.toString();
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.INTEGER_EXPONENTIATION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine("Round upto 2 Decimals");
		QuestionLine qLine3 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);
		questionList.add(qLine3);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		double randomNumber = (double)MathUtilities.getRandomNumber(1, 9)/10;
		BigDecimal bg = new BigDecimal(randomNumber * randomNumber).setScale(2, RoundingMode.HALF_UP);
		
		//create question and answer sections
		question = "-$("+randomNumber +")^{" +2+"}$";

		answer = "-" + bg.toString();
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.INTEGER_EXPONENTIATION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine("Round upto 2 Decimals");
		QuestionLine qLine3 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);
		questionList.add(qLine3);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		String answer ="";
		
		//get a random first number
		
		double randomNumber = (double)MathUtilities.getRandomNumber(1, 9)/10;
		BigDecimal bg = new BigDecimal(randomNumber * randomNumber).setScale(2, RoundingMode.HALF_UP);
		
		//create question and answer sections
		question = "$(-"+randomNumber +")^{" +2+"}$";

		answer = bg.toString();
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.INTEGER_EXPONENTIATION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine("Round upto 2 Decimals");
		QuestionLine qLine3 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);
		questionList.add(qLine3);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	
}
