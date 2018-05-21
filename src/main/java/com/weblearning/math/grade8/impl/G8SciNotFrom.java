package com.weblearning.math.grade8.impl;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8SciNotFrom extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8SciNotFrom.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> gExponentBasics = new ArrayList<Problem>();
		
		for (int i = 0; i < 10; i++)
			gExponentBasics.add(getProblem1(mathConfig));
		
		for (int i = 0; i < 15; i++)
			gExponentBasics.add(getProblem2(mathConfig));


		return gExponentBasics;
	}

	/*
	 * Converts 721.34 to 7.2134 X 10^2
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		// lowest and highest powers are for getting a number within that range
		int lowestPower = MathUtilities.getRandomNumber(1, 3);
		int highestPower = MathUtilities.getRandomNumber(lowestPower + 1, 6);
		
		MessageSource mSource = mathConfig.getmSource();
		
		//get an integer from the range
		int base = MathUtilities.getRandomNumber((int)Math.pow(10, lowestPower), (int)Math.pow(10, highestPower));
		int decimalPower = lowestPower;

		//convert the number to double
		double baseNumber = base/ Math.pow(10, decimalPower);
		//get a formatted number ex- 6723.23 to 6.72323
		String numberFormat = moveDecimalLeft(baseNumber);
		//the decimal moved 2 points
		int pointToMove = findDecimalPoint(baseNumber) -1;
		question = numberFormat + "x" + "${" +10+ "}^" + pointToMove + "$";
		
		//set answer
		answer.setAnswer(Double.toString(baseNumber));
	//	answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_SELECT_PROPER_EXPRESSION, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine(Double.toString(baseNumber*10)));
		answerList.add(new AnswerLine(Integer.toString((int)baseNumber *10)));
		answerList.add(new AnswerLine(Double.toString(baseNumber/10)));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_CONVERT_FROM_SCIENTIFIC_NOTATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	
	/*
	 * Converts 7.2134 X 10^2 to 721.34
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		// lowest and highest powers are for getting a number within that range
		int lowestPower = MathUtilities.getRandomNumber(1, 3);
		int highestPower = MathUtilities.getRandomNumber(lowestPower + 1, 6);
		
		MessageSource mSource = mathConfig.getmSource();
		
		//get an integer from the range
		int base = MathUtilities.getRandomNumber((int)Math.pow(10, lowestPower), (int)Math.pow(10, highestPower));
		int decimalPower = highestPower + MathUtilities.getRandomNumber(1, 4);

		//convert the number to double
		double baseNumber = base/ Math.pow(10, decimalPower);
		
		//get a formatted number ex- .0000234 to 2.34
		String numberFormat = moveDecimalRight(baseNumber);
		//the decimal moved 2 points right
		int pointToMove = decimalMovedToRight(baseNumber);
		
		question = numberFormat + "x" + "${" +10+ "}^{" + pointToMove + "}$" ;
		
		//use decimal format to handle E values
		DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		df.setMaximumFractionDigits(340);
		
		//set answer
		answer.setAnswer(df.format(baseNumber));
	//	answer.setType(Constants.RADIO_TYPE);
		
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_SELECT_PROPER_EXPRESSION, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine(df.format(baseNumber * 10)));
		answerList.add(new AnswerLine(df.format(baseNumber * 100)));
		answerList.add(new AnswerLine(df.format(baseNumber / 10)));
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_CONVERT_FROM_SCIENTIFIC_NOTATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	

	/*
	 * returns index of decimal point
	 */
	public int findDecimalPoint(double number) {
		
		return String.valueOf(number).indexOf('.');
		
	}
	
	/*
	 * Format a number to represent as a scientific number
	 */
	public String moveDecimalLeft(double number) {
		
		//remove decimal
		String numberFormat = String.valueOf(number).replace(".", "");
		//move decimal left after the first number
		numberFormat = numberFormat.substring(0, 1) + "." + numberFormat.substring(1,numberFormat.length());
		
		return numberFormat;
		
	}
	
	/*
	 * Format a number to represent as a scientific number
	 */
	public String moveDecimalRight(double number) {
		
		//use decimal format for handling E values
		DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		df.setMaximumFractionDigits(340);
		
		//remove decimal
		String numberString = String.valueOf(df.format(number)).replace(".", "");
		//convert that to a number
		int numberInInt = Integer.valueOf(numberString);
		//place the decimal after first number
		numberString = Integer.toString(numberInInt).substring(0, 1) + "." + Integer.toString(numberInInt).substring(1,Integer.toString(numberInInt).length());
		
		return numberString;
		
	}
	
	/*
	 * return how many numbers the decimal should move
	 */
	public int decimalMovedToRight(double number) {
		
		int moved=0;
		
		while(number < 1) {
			number = number * 10;
			moved ++;
		}
		return -moved;
	}

}
