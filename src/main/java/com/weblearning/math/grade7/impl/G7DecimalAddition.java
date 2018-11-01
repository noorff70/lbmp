package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7DecimalAddition extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7DecimalAddition = new ArrayList<Problem>();


		for (int i = 0; i < 5; i++)
			g7DecimalAddition.add(getProblem2(mathConfig));
		for (int i = 0; i < 5; i++)
			g7DecimalAddition.add(getProblem3(mathConfig));
		for (int i = 0; i < 3; i++)
			g7DecimalAddition.add(getProblem4(mathConfig));

		return g7DecimalAddition;
	}

	/*
	 * Add decimals
	 
	public Problem getProblem1(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		BigDecimal bg = new BigDecimal(0);
		String question = "";
		Double answer = (double) 0;
		
		for (int i=0; i<3; i++){
			int number = MathUtilities.getRandomNumber(10000, 10000000);
			int decimal = MathUtilities.getRandomNumber(1, 3);
			double dNumber = 0;
			
			if (decimal==1) {
				dNumber = (double)number/10;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			else if (decimal==2) {
				dNumber = (double)number/100;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			else if(decimal==3) {
				dNumber = (double)number/1000;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			
			if (StringUtils.isEmpty(question))
				question = Double.toString(dNumber);
			else
				question = question + " + " + Double.toString(dNumber);
			
			answer += dNumber;
			
		}


		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.ADD_FOLLOWING_DECIMAL_NUMBERS, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_ADD_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer(bg.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}*/
	
	/*
	 * Add decimals and then rounding to tenth- 3266.528 = 3266.5
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		BigDecimal bg = new BigDecimal(0);
		String question = "";
		Double answer = (double) 0;
		
		for (int i=0; i<2; i++){
			int number = MathUtilities.getRandomNumber(10000, 10000000);
			int decimal = MathUtilities.getRandomNumber(2, 5);
			double dNumber = 0;
			
			if (decimal==2) {
				dNumber = (double)number/100;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			else if (decimal==3) {
				dNumber = (double)number/1000;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			else if(decimal==4) {
				dNumber = (double)number/10000;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			else if(decimal==5) {
				dNumber = (double)number/100000;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			
			if (StringUtils.isEmpty(question))
				question = Double.toString(dNumber);
			else
				question = question + " + " + Double.toString(dNumber);
			
			answer += dNumber;
			
		}


		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.ADD_FOLLOWING_DECIMAL_NUMBERS , null, Locale.ENGLISH)
				+ mSource.getMessage(Constants.CONVERT_TO_NEAREST_TENTHS, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_ADD_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer(BigDecimal.valueOf(bg.doubleValue()).setScale(1, RoundingMode.HALF_UP).toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Add decimals and then rounding to ten thousandths (4 decimals)- 3266.528987 = 3,266.5290
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		BigDecimal bg = new BigDecimal(0);
		String question = "";
		
		for (int i=0; i<2; i++){
			int number = MathUtilities.getRandomNumber(10000, 10000000);
			int decimal = MathUtilities.getRandomNumber(3, 6);
			double dNumber = 0;
			
			if (decimal==3) {
				dNumber = (double)number/1000;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			else if(decimal==4) {
				dNumber = (double)number/10000;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			else if(decimal==5) {
				dNumber = (double)number/100000;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			else if(decimal==6) {
				dNumber = (double)number/1000000;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			
			if (StringUtils.isEmpty(question))
				question = Double.toString(dNumber);
			else
				question = question + " + " + Double.toString(dNumber);
			
			
		}


		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.ADD_FOLLOWING_DECIMAL_NUMBERS , null, Locale.ENGLISH)
				+ mSource.getMessage(Constants.CONVERT_TO_NEAREST_TENT_THOUSAND, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_ADD_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer(BigDecimal.valueOf(bg.doubleValue()).setScale(4, RoundingMode.HALF_UP).toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * Add decimals and then rounding to ten thousands  125684.4567 = 130,000
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		BigDecimal bg = new BigDecimal(0);

		
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		String question="";
		
		for (int i=0; i<2; i++){
			int number = MathUtilities.getRandomNumber(1000000, 10000000);
			int decimal = MathUtilities.getRandomNumber(3,4);
			double dNumber = 0;
			
			if (decimal==3) {
				dNumber = (double)number/1000;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}
			else if(decimal==4) {
				dNumber = (double)number/10000;
				bg = bg.add(BigDecimal.valueOf(dNumber));
			}

			
			if (StringUtils.isEmpty(question))
				question = Double.toString(dNumber);
			else
				question = question + " + " + Double.toString(dNumber);
			
		}
		//find the sum
		answer1 = bg.toString();
		//convert to nearest tenths
		answer2 = BigDecimal.valueOf(bg.doubleValue()).setScale(1, RoundingMode.HALF_UP).toString();
		//convert to nearest hundredts
		answer3 = BigDecimal.valueOf(bg.doubleValue()).setScale(2, RoundingMode.HALF_UP).toString();
		//convert to nearest 100
		answer4 = Integer.toString(getRoundedValue(bg, 100));
		//convert to nearest 1000
		answer5 = Integer.toString(getRoundedValue(bg, 1000));
		
		
		questionList.add(new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.FIND_THE_SUM, null, Locale.ENGLISH) + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.CONVERT_TO_NEAREST_TENTHS, null, Locale.ENGLISH) + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.CONVERT_TO_NEAREST_HUNDREDTHS , null, Locale.ENGLISH) + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.CONVERT_TO_NEAREST_HUNDRED, null, Locale.ENGLISH) + Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( mSource.getMessage(Constants.CONVERT_TO_NEAREST_THOUSAND, null, Locale.ENGLISH) + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));


		String heading = mSource.getMessage(Constants.GRADE_7_ADD_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	int getRoundedValue(BigDecimal bg, int rounded) {

		int main = bg.intValue() / rounded;
		int remainder = bg.intValue() % rounded;
		if (BigDecimal.valueOf(remainder).divide(BigDecimal.valueOf(rounded/10)).setScale(1, RoundingMode.HALF_UP)
				.intValue() >= 5) {
			main = bg.intValue() / rounded;
			main = main * rounded;
			main = main + rounded;
		} else {
			main = bg.intValue() / rounded;
			main = main * rounded;
		}
		return main;
	}
	

}
