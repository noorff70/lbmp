package com.weblearning.math.grade7.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class Grade7FractionMissingNumber extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(Grade7FractionMissingNumber.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> missingFraction = new LinkedList<Problem>();

		for (int i=0; i< 1; i++)
			missingFraction.add(getProblem1(mathConfig, i));
		for (int i=0; i< 1; i++)
			missingFraction.add(getProblem2(mathConfig, i));
		for (int i=0; i< 3; i++)
			missingFraction.add(getProblem3(mathConfig, i));
		for (int i=0; i< 3; i++)
			missingFraction.add(getProblem4(mathConfig, i));
		for (int i=0; i< 3; i++)
			missingFraction.add(getProblem5(mathConfig, i));
		for (int i=0; i< 3; i++)
			missingFraction.add(getProblem6(mathConfig, i));
		for (int i=0; i< 3; i++)
			missingFraction.add(getProblem7(mathConfig, i));
			
		return missingFraction;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		
		//find the 1/2 + 2/3 = 
		Fraction frac1a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction frac1b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		Fraction result1 = frac1a.subtract(frac1b);

		question1 = "$" +"\\Box - "
				+ "\\frac{"+ Integer.toString(frac1b.getNumerator()) + "}{"+ Integer.toString(frac1b.getDenominator())+ "} = " 
				+ "\\frac{" + Integer.toString(result1.getNumerator())+ "}{" + Integer.toString(result1.getDenominator()) + "}"
				+ "$";
		answer1 = frac1a.toString();
		
		
		//find the 1/2 + 2/3 = 
		Fraction _2a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _2b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 6));
		
		Fraction _2c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question2 = "$" +Integer.toString(_2a.getNumerator()) + "\\frac{" + Integer.toString(_2b.getNumerator()) + "}{" + Integer.toString(_2b.getDenominator()) + "} + "
				+ "\\Box = " ;
		
		_2b = _2a.add(_2b);
		Fraction _2Result = _2b.add(_2c);
		question2 = question2 +  "\\frac{" + Integer.toString(_2Result.getNumerator()) + "}{" + Integer.toString(_2Result.getDenominator()) + "}$";
		
		answer2 = _2c.toString();
		
		//find the 1/2 + 2/3 =
		Fraction _3a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _3b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 6));
		
		Fraction _3c = new Fraction(MathUtilities.getRandomNumber(1, 3));
		
		question3 = "$" +Integer.toString(_3a.getNumerator()) + "\\frac{" + Integer.toString(_3b.getNumerator()) + "}{" + Integer.toString(_3b.getDenominator()) + "} - "
				+ "\\Box = " ;
		
		_3b = _3a.add(_3b);
		Fraction _3Result = _3b.subtract(_3c);
		question3 = question3 +  "\\frac{" + Integer.toString(_3Result.getNumerator()) + "}{" + Integer.toString(_3Result.getDenominator()) + "}$";
		answer3 = _3c.toString();
		
		//find the 1/2 + 2/3 =
		Fraction _4a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _4b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 6));
				
		Fraction _4c = new Fraction(MathUtilities.getRandomNumber(1, 3));
				
		question4 = "$ \\Box + " +Integer.toString(_4a.getNumerator()) + "\\frac{" + Integer.toString(_4b.getNumerator()) + "}{" + Integer.toString(_4b.getDenominator()) + "}  "
						+ " = " ;
				
		_4b = _4a.add(_4b);
		Fraction _4Result = _4b.add(_4c);
		question4 = question4 +  "\\frac{" + Integer.toString(_4Result.getNumerator()) + "}{" + Integer.toString(_4Result.getDenominator()) + "}$";
		answer4 = _4c.toString();
		
		//find the 1/2 + 2/3 =
		Fraction _5a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _5b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		Fraction result5 = _5a.subtract(_5b);

		question5 = "$" +"\\Box - "
				+ "\\frac{"+ Integer.toString(_5b.getNumerator()) + "}{"+ Integer.toString(_5b.getDenominator())+ "} = " 
				+ "\\frac{" + Integer.toString(result5.getNumerator())+ "}{" + Integer.toString(result5.getDenominator()) + "}"
				+ "$";
		answer5 = _5a.toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		
		//find the 1/2 + 2/3 = 
		Fraction frac1a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction frac1b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction frac1c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 5));
		
		Fraction result1 = frac1a.subtract(frac1b).add(frac1c);

		question1 = "$" +"\\Box - "
				+ "\\frac{"+ Integer.toString(frac1b.getNumerator()) + "}{"+ Integer.toString(frac1b.getDenominator())+ "} +" 
				+ "\\frac{" + Integer.toString(frac1c.getNumerator())+ "}{" + Integer.toString(frac1c.getDenominator()) + "} = "
				+ "\\frac{" + Integer.toString(result1.getNumerator())+ "}{" + Integer.toString(result1.getDenominator()) + "}"
				+ "$";
		answer1 = frac1a.toString();
		
		
		//find the 1/2 + 2/3 = 
		Fraction _2a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _2b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _2c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(6, 8));
		
		Fraction result2 = _2a.add(_2b).add(_2c);

		question2 = "$" + "\\frac{"+ Integer.toString(_2a.getNumerator()) + "}{"+ Integer.toString(_2a.getDenominator())+ "} + "
				+ "\\frac{"+ Integer.toString(_2b.getNumerator()) + "}{"+ Integer.toString(_2b.getDenominator())+ "} +" 
				+ "\\Box = "
				+ "\\frac{" + Integer.toString(result2.getNumerator())+ "}{" + Integer.toString(result2.getDenominator()) + "}"
				+ "$";
		answer2 = _2c.toString();
		
		//find the 1/2 + 2/3 =
		Fraction _3a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _3b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _3c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(6, 8));
		
		Fraction result3 = _3a.subtract(_3b).subtract(_3c);

		question3 = "$" + "\\frac{"+ Integer.toString(_3a.getNumerator()) + "}{"+ Integer.toString(_3a.getDenominator())+ "} - "
				+ "(\\frac{"+ Integer.toString(_3b.getNumerator()) + "}{"+ Integer.toString(_3b.getDenominator())+ "} + " 
				+ "\\Box ) = "
				+ "\\frac{" + Integer.toString(result3.getNumerator())+ "}{" + Integer.toString(result3.getDenominator()) + "}"
				+ "$";
		answer3 = _3c.toString();
		
		//find the 1/2 + 2/3 =
		Fraction _4a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _4b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _4c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(6, 8));
		
		Fraction result4 = _4a.subtract(_4b).add(_4c);

		question4 = "$" + "\\frac{"+ Integer.toString(_4a.getNumerator()) + "}{"+ Integer.toString(_4a.getDenominator())+ "} - "
				+ "(\\frac{"+ Integer.toString(_4b.getNumerator()) + "}{"+ Integer.toString(_4b.getDenominator())+ "} - " 
				+ "\\Box ) = "
				+ "\\frac{" + Integer.toString(result4.getNumerator())+ "}{" + Integer.toString(result4.getDenominator()) + "}"
				+ "$";
		answer4 = _4c.toString();
		
		//find the 1/2 + 2/3 =
		Fraction _5a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _5b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _5c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(6, 8));
		
		Fraction result5 = _5a.add(_5b).subtract(_5c);

		question5 = "$" + "\\frac{"+ Integer.toString(_5a.getNumerator()) + "}{"+ Integer.toString(_5a.getDenominator())+ "} + "
				+ "(\\frac{"+ Integer.toString(_5b.getNumerator()) + "}{"+ Integer.toString(_5b.getDenominator())+ "} - " 
				+ "\\Box ) = "
				+ "\\frac{" + Integer.toString(result5.getNumerator())+ "}{" + Integer.toString(result5.getDenominator()) + "}"
				+ "$";
		answer5 = _5c.toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		Fraction _3a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _3b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 6));
		
		Fraction _3c = new Fraction(MathUtilities.getRandomNumber(1, 3));
		
		question1 = "$" +Integer.toString(_3a.getNumerator()) + "\\frac{" + Integer.toString(_3b.getNumerator()) + "}{" + Integer.toString(_3b.getDenominator()) + "} - "
				+ "\\Box = " ;
		
		_3b = _3a.add(_3b);
		
		Fraction _3Result = _3b.subtract(_3c);
		question1 = question1 +  "\\frac{" + Integer.toString(_3Result.getNumerator()) + "}{" + Integer.toString(_3Result.getDenominator()) + "}$";
		
		answer1 = _3c.toString();

		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1));
		
		String heading = mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH);
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		
		Fraction _4a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _4b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 6));
				
		Fraction _4c = new Fraction(MathUtilities.getRandomNumber(1, 3));
				
		question4 = "$ \\Box + " +Integer.toString(_4a.getNumerator()) + "\\frac{" + Integer.toString(_4b.getNumerator()) + "}{" + Integer.toString(_4b.getDenominator()) + "}  "
						+ " = " ;
				
		_4b = _4a.add(_4b);
		Fraction _4Result = _4b.add(_4c);
		question4 = question4 +  "\\frac{" + Integer.toString(_4Result.getNumerator()) + "}{" + Integer.toString(_4Result.getDenominator()) + "}$";
		answer4 = _4c.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4 ));

		String heading = mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question5="";
		String answer5="";
		
		Fraction _5a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _5b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		Fraction result5 = _5a.subtract(_5b);

		question5 = "$" +"\\Box - "
				+ "\\frac{"+ Integer.toString(_5b.getNumerator()) + "}{"+ Integer.toString(_5b.getDenominator())+ "} = " 
				+ "\\frac{" + Integer.toString(result5.getNumerator())+ "}{" + Integer.toString(result5.getDenominator()) + "}"
				+ "$";
		answer5 = _5a.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question5 ));

		String heading = mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH);
		answ.setAnswer(answer5);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question5="";
		String answer5="";
		
		Fraction _5a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _5b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _5c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(6, 8));
		
		Fraction result5 = _5a.add(_5b).subtract(_5c);

		question5 = "$" + "\\frac{"+ Integer.toString(_5a.getNumerator()) + "}{"+ Integer.toString(_5a.getDenominator())+ "} + "
				+ "(\\frac{"+ Integer.toString(_5b.getNumerator()) + "}{"+ Integer.toString(_5b.getDenominator())+ "} - " 
				+ "\\Box ) = "
				+ "\\frac{" + Integer.toString(result5.getNumerator())+ "}{" + Integer.toString(result5.getDenominator()) + "}"
				+ "$";
		answer5 = _5c.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question5));

		String heading = mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH);
		answ.setAnswer(answer5);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem7(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		
		Fraction _4a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _4b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _4c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(6, 8));
		
		Fraction result4 = _4a.subtract(_4b).add(_4c);

		question4 = "$" + "\\frac{"+ Integer.toString(_4a.getNumerator()) + "}{"+ Integer.toString(_4a.getDenominator())+ "} - "
				+ "(\\frac{"+ Integer.toString(_4b.getNumerator()) + "}{"+ Integer.toString(_4b.getDenominator())+ "} - " 
				+ "\\Box ) = "
				+ "\\frac{" + Integer.toString(result4.getNumerator())+ "}{" + Integer.toString(result4.getDenominator()) + "}"
				+ "$";
		answer4 = _4c.toString();

		String heading = mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH);
		answ.setAnswer(answer4);
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	

}
