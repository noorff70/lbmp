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
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.RootObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8SqrFrac extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8SqrFrac.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> g8SqrFrac = new ArrayList<Problem>();
		
		for (int i = 0; i < 10; i++)
			g8SqrFrac.add(getProblem1(mathConfig));
		
		for (int i = 0; i < 5; i++)
			g8SqrFrac.add(getProblem2(mathConfig));

//
		return g8SqrFrac;
	}


	
	public Problem getProblem1(MathConfiguration mathConfig){
		
		int UPPER_BOUND=20;
		
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		Answer answer = new Answer();
		String question = "";
		String result;

		Map<Integer, Integer> perfectRoots1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> perfectRoots2= new HashMap<Integer, Integer>();
		
		//take any number from 2-15
		int factor1 = MathUtilities.getRandomNumber(2, 15);
		int factor2 = MathUtilities.getRandomNumber(2, 15);

		//generate the square roots and multiply that with a factor and put that in a map-perfectroots
		for (int i=1; i<= UPPER_BOUND; i++){
			perfectRoots1.put(i, i*i*factor1);
		}
		//generate a second set of roots
		for (int i=1; i<= UPPER_BOUND; i++){
			perfectRoots2.put(i, i*i*factor2);
		}
		
		//get any random number from 2-20 as a key
		int squarerootnumerator = MathUtilities.getRandomNumber(2, UPPER_BOUND);
		int squarerootdenominator = MathUtilities.getRandomNumber(2, UPPER_BOUND);
		
		//create a fraction object from the keys
		Fraction frac = Fraction.getReducedFraction(perfectRoots1.get(squarerootnumerator), perfectRoots2.get(squarerootdenominator));
		//get the value of that number/key from the map
		int valueNumerator = frac.getNumerator();
		int valueDenominator = frac.getDenominator();
		//find the square root of that number
		question = "$\\sqrt{"+ valueNumerator+"\\over" +valueDenominator+ "}$";

		RootObject rObjectNumerator = MathUtilities.getRoot(valueNumerator, 2);
		RootObject rObjectDenominator = MathUtilities.getRoot(valueDenominator, 2);
		
		result = convertSquareRoot2Strings(rObjectNumerator, rObjectDenominator);
		
		answer.setType(Constants.RADIO_TYPE);
		answer.setAnswer(result);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_SELECT_SQUAREROOT, null, Locale.ENGLISH) + " " + question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(result));
		questionList.add(new QuestionLine("$"+rObjectNumerator.getWhole()*2+"\\sqrt{"+ rObjectNumerator.getRoot()*3+ "}\\over" + rObjectDenominator.getWhole()*2+"$"));
		questionList.add(new QuestionLine("$"+rObjectNumerator.getWhole()*3+"\\sqrt{"+ rObjectNumerator.getRoot()*3+ "}\\over" + rObjectDenominator.getWhole()+"$"));
		
		
		//get the questionlist rearranged by passing the list itself and a max number to swap the answers
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);

		String heading = mSource.getMessage(Constants.GRADE_8_FIND_INTEGER_SQUARE_ROOT, null, Locale.ENGLISH);

		
		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);
		
		return problem;
		
	}
	
	public Problem getProblem2(MathConfiguration mathConfig){
		
		int UPPER_BOUND = 20;
		
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		Answer answer = new Answer();
		String question = "";
		String result;

		Map<Integer, Integer> perfectRoots= new HashMap<Integer, Integer>();
		
		//take any number from 2-20
		int factor2 = MathUtilities.getRandomNumber(2, 10);

		//generate a map
		for (int i=1; i<= UPPER_BOUND; i++){
			perfectRoots.put(i, i*i*factor2);
		}
		
		//get any random number from above map
		int squarerootnumerator = MathUtilities.getRandomNumber(2, UPPER_BOUND);
		
		//get a random number as denominator and then its result from the map
		int denominator = MathUtilities.getRandomNumber(2, 15);
		int squarerootdenominator = perfectRoots.get(denominator);
		
		//create a fraction object from the keys
		Fraction frac = Fraction.getReducedFraction(squarerootnumerator * squarerootnumerator, squarerootdenominator);

		//find the square root of that number
		question = "$"+ squarerootnumerator+"\\over\\sqrt{" +squarerootdenominator+ "}$";

		RootObject rObjectNumerator = MathUtilities.getRoot(frac.getNumerator(), 2);
		RootObject rObjectDenominator = MathUtilities.getRoot(frac.getDenominator(), 2);

		
		result = convertSquareRoot2Strings(rObjectNumerator, rObjectDenominator);
		
		answer.setType(Constants.RADIO_TYPE);
		answer.setAnswer(result);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_SELECT_SQUAREROOT, null, Locale.ENGLISH) + " " + question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(result));
		questionList.add(new QuestionLine("$"+rObjectNumerator.getWhole()*2+"\\sqrt{"+ rObjectNumerator.getRoot()*3+ "}\\over" + rObjectDenominator.getWhole()*2+"$"));
		questionList.add(new QuestionLine("$"+rObjectNumerator.getWhole()*3+"\\sqrt{"+ rObjectNumerator.getRoot()*3+ "}\\over" + rObjectDenominator.getWhole()+"$"));
		
		
		//get the questionlist rearranged by passing the list itself and a max number to swap the answers
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);

		String heading = mSource.getMessage(Constants.GRADE_8_FIND_INTEGER_SQUARE_ROOT, null, Locale.ENGLISH);

		
		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
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
