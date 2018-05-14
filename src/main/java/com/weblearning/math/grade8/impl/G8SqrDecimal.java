package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.RootObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8SqrDecimal extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8SqrDecimal.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> g8SqrDecimal = new ArrayList<Problem>();
		
		for (int i = 0; i < 10; i++)
			g8SqrDecimal.add(getProblem1(mathConfig));

		for (int i = 0; i < 10; i++)
			g8SqrDecimal.add(getProblem2(mathConfig));
		
		for (int i = 0; i < 5; i++)
			g8SqrDecimal.add(getProblem2(mathConfig));

		return g8SqrDecimal;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		String result= "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		Map<Integer, Integer> perfectRoots = new HashMap<Integer, Integer>();
		//generate the square roots
		for (int i=1; i< 26; i++){
			perfectRoots.put(i, i*i);
		}
		
		int decimalPoint = MathUtilities.getRandomNumber(2, 4);
		
		int squareroot = MathUtilities.getRandomNumber(2, 25);
		int value = perfectRoots.get(squareroot);

		double decimalValue = MathUtilities.convertToDecimal(value, decimalPoint);
		question = "$\\sqrt{"+ decimalValue+ "}$";
		
		
		Fraction frac = Fraction.getReducedFraction(value, (int)Math.pow(10, decimalPoint));
		
		RootObject rObjectNumerator = MathUtilities.getRoot(frac.getNumerator(), 2);
		RootObject rObjectDenominator = MathUtilities.getRoot(frac.getDenominator(),2);
				
	
		result = convertSquareRoot2Strings(rObjectNumerator, rObjectDenominator);
		
		answer.setType(Constants.RADIO_TYPE);
		answer.setAnswer(result);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(squareroot));
		
		//add the random answers as random

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_SQUARE_ROOT_OF, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine>answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(result, Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$"+rObjectNumerator.getWhole()*2+"\\sqrt{"+ rObjectNumerator.getRoot()*3+ "}\\over" + rObjectDenominator.getWhole()*2+"$", Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$"+rObjectNumerator.getWhole()*3+"\\sqrt{"+ rObjectNumerator.getRoot()*3+ "}\\over" + rObjectDenominator.getWhole()+"$", Constants.RADIO_TYPE));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		String heading = mSource.getMessage(Constants.GRADE_8_SQUARE_ROOT_OF_DECIMALS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, Integer.toString(squareroot), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);
		
		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		String result= "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		Map<Integer, Integer> perfectRoots = new HashMap<Integer, Integer>();
		//generate the square roots
		for (int i=1; i< 26; i++){
			perfectRoots.put(i, i*i);
		}
		
		int decimalPoint = MathUtilities.getRandomNumber(2, 4);
		
		int squareroot = MathUtilities.getRandomNumber(2, 15);
		int value = perfectRoots.get(squareroot);
		
		//take a numerator
		int anotherValue = MathUtilities.getRandomNumber(2, 12);

		double decimalValue = MathUtilities.convertToDecimal(value, decimalPoint);
		question = "$" + anotherValue +"\\over \\sqrt{"+ decimalValue+ "}$";
		
		//make the square of the value, say value = 16 and the value is 4
		anotherValue = anotherValue* anotherValue; 
		
		//convert the decimal value to a fraction ex- .25 = 25/100. the fraction becomes 16*100/25
		Fraction fracDecimal = Fraction.getReducedFraction((int)Math.pow(10, decimalPoint) * anotherValue, value );
		
		
		//get the root and square portions from the decimal
		RootObject rObjectNumerator = MathUtilities.getRoot(fracDecimal.getNumerator(), 2);
		RootObject rObjectDenominator = MathUtilities.getRoot(fracDecimal.getDenominator(),2);
	
		result = convertSquareRoot2Strings(rObjectNumerator, rObjectDenominator);
		
		answer.setType(Constants.RADIO_TYPE);
		answer.setAnswer(result);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(squareroot));
		
		//add the answers as random

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_SQUARE_ROOT_OF, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null ));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer(), Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$"+rObjectNumerator.getWhole()*2+"\\sqrt{"+ rObjectNumerator.getRoot()*3+ "}\\over" + rObjectDenominator.getWhole()*2+"$", Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$"+rObjectNumerator.getWhole()*3+"\\sqrt{"+ rObjectNumerator.getRoot()*3+ "}\\over" + rObjectDenominator.getWhole()+"$", Constants.RADIO_TYPE));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		String heading = mSource.getMessage(Constants.GRADE_8_SQUARE_ROOT_OF_DECIMALS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, Integer.toString(squareroot), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);
		
		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";
		String result= "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		Map<Integer, Integer> perfectRoots = new HashMap<Integer, Integer>();
		//generate the square roots
		for (int i=1; i< 26; i++){
			perfectRoots.put(i, i*i);
		}
		
		int decimalPoint = MathUtilities.getRandomNumber(2, 4);
		
		int squareroot = MathUtilities.getRandomNumber(2, 15);
		int value = perfectRoots.get(squareroot);
		
		//take a numerator
		int anotherValue = MathUtilities.getRandomNumber(2, 12);

		double decimalValue = MathUtilities.convertToDecimal(value, decimalPoint);
		question = "$ \\sqrt{" +  decimalValue +"\\over" + anotherValue + "$";
		
		//make the square of the value, say anothervalue= 16, value =4
		anotherValue = anotherValue* anotherValue; 
		
		//convert the decimal value to a fraction ex- .25 = 25/100
		Fraction fracDecimal = Fraction.getReducedFraction(value, (int)Math.pow(10, decimalPoint) * anotherValue);
		
		//get the root and square portions from the decimal
		RootObject rObjectNumerator = MathUtilities.getRoot(fracDecimal.getNumerator(), 2);
		RootObject rObjectDenominator = MathUtilities.getRoot(fracDecimal.getDenominator(),2);
	
		result = convertSquareRoot2Strings(rObjectNumerator, rObjectDenominator);
		
		answer.setType(Constants.RADIO_TYPE);
		answer.setAnswer(result);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(squareroot));
		
		//add the random answers as random

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_SQUARE_ROOT_OF, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(result, Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$"+rObjectNumerator.getWhole()*2+"\\sqrt{"+ rObjectNumerator.getRoot()*3+ "}\\over" + rObjectDenominator.getWhole()*2+"$", Constants.RADIO_TYPE));
		answerList.add(new AnswerLine("$"+rObjectNumerator.getWhole()*3+"\\sqrt{"+ rObjectNumerator.getRoot()*3+ "}\\over" + rObjectDenominator.getWhole()+"$", Constants.RADIO_TYPE));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		String heading = mSource.getMessage(Constants.GRADE_8_SQUARE_ROOT_OF_DECIMALS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, Integer.toString(squareroot), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);
		
		return problem;
	}
	
	
	
	public String convertSquareRoot2Strings(RootObject numerator, RootObject denominator){
		
		
		String result= "";
		List<String> resultList = new LinkedList<String>();

		String openingDelimiter = "$";
		String numeratorSquare =  null;
		String numeratorRoot=null;
		String over = "\\over";
		String denominatorSquare=null;
		String denominatorRoot= null;
		String closingDelimiter= "$";;
		
		if (numerator.getWhole()!=1){
			numeratorSquare = Integer.toString(numerator.getWhole());
		}
		
		if (numerator.getRoot()!=1){
			numeratorRoot = "\\sqrt{" +numerator.getRoot() + "}";
		}
		
		if (numerator.getWhole()==1 && numerator.getRoot() ==1){
			numeratorSquare =Integer.toString(1);
		}
			
		if (denominator.getWhole()!= 1){
			denominatorSquare = Integer.toString(denominator.getWhole());
		}
		
		if (denominator.getRoot()!=1){
			denominatorRoot = "\\sqrt{" +denominator.getRoot() + "}";
		}
		
		if (null == denominatorSquare && null ==denominatorRoot ){
			over = null;
		}
		
		resultList.add(openingDelimiter);
		resultList.add(numeratorSquare);
		resultList.add(numeratorRoot);
		resultList.add(over);
		resultList.add(denominatorSquare);
		resultList.add(denominatorRoot);
		resultList.add(closingDelimiter);
		
		for (int i=0; i < resultList.size(); i++){
			if (null != (String)resultList.get(i) ){
				result = result + (String)resultList.get(i) ;
			}
		}
		
		
		return result;
	}
	
}
