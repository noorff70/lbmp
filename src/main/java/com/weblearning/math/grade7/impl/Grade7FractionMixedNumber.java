package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.math3.fraction.Fraction;
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

public class Grade7FractionMixedNumber extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> addSubtractFraction = new ArrayList<Problem>();

		for (int i = 0; i < 1; i++)
			addSubtractFraction.add(getProblem1(mathConfig, i));
		for (int i = 0; i < 2; i++)
			addSubtractFraction.add(getProblem2(mathConfig, i));
		for (int i = 0; i < 2; i++)
			addSubtractFraction.add(getProblem3(mathConfig, i));
		for (int i = 0; i < 2; i++)
			addSubtractFraction.add(getProblem4(mathConfig, i)); 
		for (int i = 0; i < 2; i++)
			addSubtractFraction.add(getProblem5(mathConfig, i)); 
		for (int i = 0; i < 4; i++)
			addSubtractFraction.add(getProblem6(mathConfig, i));

		

		return addSubtractFraction;
	}
	
	
	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		Fraction _1a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _1b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		
		Fraction _1c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));			
		Fraction _1d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question1 = "$" + Integer.toString(_1a.getNumerator()) + "\\frac{" + Integer.toString(_1c.getNumerator())+ "}{"+ Integer.toString(_1c.getDenominator()) + "}"
				+ " + " +  Integer.toString(_1b.getNumerator()) + "\\frac{" + Integer.toString(_1d.getNumerator())+ "}{"+ Integer.toString(_1d.getDenominator()) + "}"
				+ "$";
		
		_1c = _1a.add(_1c);
		_1d = _1b.add(_1d);
		
		Fraction result1 = _1c.add(_1d);
		answer1 = result1.toString();
		
		//find the 1/2 + 2/3 = 
		Fraction _2b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		Fraction _2c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));			
		
		Fraction _2d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question2 = "$" + "\\frac{" + Integer.toString(_2c.getNumerator())+ "}{"+ Integer.toString(_2c.getDenominator()) + "}"
				+ " + " +  Integer.toString(_2b.getNumerator()) + "\\frac{" + Integer.toString(_2d.getNumerator())+ "}{"+ Integer.toString(_2d.getDenominator()) + "}"
				+ " = $";
		
		_2d = _2b.add(_2d);
		
		Fraction result2 = _2c.add(_2d);
		answer2 = result2.toString();
		
		//find the 1/2 + 2/3 =
		Fraction _3a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _3b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		
		Fraction _3c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));			
		Fraction _3d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question3 = "$" + Integer.toString(_3a.getNumerator()) + "\\frac{" + Integer.toString(_3c.getNumerator())+ "}{"+ Integer.toString(_3c.getDenominator()) + "}"
				+ " + " +  Integer.toString(_3b.getNumerator()) + "\\frac{" + Integer.toString(_3d.getNumerator())+ "}{"+ Integer.toString(_3d.getDenominator()) + "}"
				+ " = $";
		
		_3c = _3a.add(_3c);
		_3d = _3b.add(_3d);
		
		Fraction result3 = _3c.add(_3d);
		answer3 = result3.toString();
		
		//find the 1/2 + 2/3 =
		Fraction _4a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _4b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		
		Fraction _4c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));			
		Fraction _4d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question4 = "$" + Integer.toString(_4a.getNumerator()) + "\\frac{" + Integer.toString(_4c.getNumerator())+ "}{"+ Integer.toString(_4c.getDenominator()) + "}"
				+ " - " +  Integer.toString(_4b.getNumerator()) + "\\frac{" + Integer.toString(_4d.getNumerator())+ "}{"+ Integer.toString(_4d.getDenominator()) + "}"
				+ " = $";
		
		_4c = _4a.add(_4c);
		_4d = _4b.add(_4d);
		
		Fraction result4 = _4c.subtract(_4d);
		answer4 = result4.toString();
		
		//find the 2 - 2 2/3 =
		Fraction _5a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _5b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		
		//Fraction _5c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));			
		Fraction _5d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question5 = "$" + Integer.toString(_5a.getNumerator()) 
				+ " - " +  Integer.toString(_5b.getNumerator()) + "\\frac{" + Integer.toString(_5d.getNumerator())+ "}{"+ Integer.toString(_5d.getDenominator()) + "}"
				+ " = $";
		
		//_5c = _5a.add(_5c);
		_5d = _5b.add(_5d);
		
		Fraction result5 = _5a.subtract(_5d);
		answer5 = result5.toString();
				
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH) + ". "+
				mSource.getMessage(GR7_Constants.MAKE_IMPERFECT_FRACTION, null, Locale.ENGLISH), null, Constants.DEFAULT  ));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
				

		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION , null, Locale.ENGLISH);
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
		
		Fraction _1a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _1b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		
		Fraction _1c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));			
		Fraction _1d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question1 = "$" + Integer.toString(_1a.getNumerator()) + "\\frac{" + Integer.toString(_1c.getNumerator())+ "}{"+ Integer.toString(_1c.getDenominator()) + "}"
				+ " + " +  Integer.toString(_1b.getNumerator()) + "\\frac{" + Integer.toString(_1d.getNumerator())+ "}{"+ Integer.toString(_1d.getDenominator()) + "}"
				+ " = $";
		
		_1c = _1a.add(_1c);
		_1d = _1b.add(_1d);
		
		Fraction result1 = _1c.add(_1d);
		int resultWhole1 = result1.getNumerator() / result1.getDenominator();
		
		answer1 = Integer.toString(resultWhole1) + getFraction(result1);
		
		//find the 1/2 + 2/3 = 
		Fraction _2b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		Fraction _2c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));			
		
		Fraction _2d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question2 = "$" + "\\frac{" + Integer.toString(_2c.getNumerator())+ "}{"+ Integer.toString(_2c.getDenominator()) + "}"
				+ " + " +  Integer.toString(_2b.getNumerator()) + "\\frac{" + Integer.toString(_2d.getNumerator())+ "}{"+ Integer.toString(_2d.getDenominator()) + "}"
				+ " = $";
		
		_2d = _2b.add(_2d);
		
		Fraction result2 = _2c.add(_2d);
		int resultWhole2 = result2.getNumerator() / result2.getDenominator();
		answer2 = Integer.toString(resultWhole2) + getFraction( result2);
		
		//find the 1/2 + 2/3 =
		Fraction _3a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _3b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		
		Fraction _3c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));			
		Fraction _3d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question3 = "$" + Integer.toString(_3a.getNumerator()) + "\\frac{" + Integer.toString(_3c.getNumerator())+ "}{"+ Integer.toString(_3c.getDenominator()) + "}"
				+ " + " +  Integer.toString(_3b.getNumerator()) + "\\frac{" + Integer.toString(_3d.getNumerator())+ "}{"+ Integer.toString(_3d.getDenominator()) + "}"
				+ " = $";
		
		_3c = _3a.add(_3c);
		_3d = _3b.add(_3d);
		
		Fraction result3 = _3c.add(_3d);
		int resultWhole3 = result3.getNumerator() / result3.getDenominator();
		answer3 = Integer.toString(resultWhole3) + getFraction(result3);
		
		//find the 1/2 + 2/3 =
		Fraction _4a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _4b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		
		Fraction _4c = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));			
		Fraction _4d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question4 = "$" + Integer.toString(_4a.getNumerator()) + "\\frac{" + Integer.toString(_4c.getNumerator())+ "}{"+ Integer.toString(_4c.getDenominator()) + "}"
				+ " - " +  Integer.toString(_4b.getNumerator()) + "\\frac{" + Integer.toString(_4d.getNumerator())+ "}{"+ Integer.toString(_4d.getDenominator()) + "}"
				+ " = $";
		
		_4c = _4a.add(_4c);
		_4d = _4b.add(_4d);
		
		Fraction result4 = _4c.subtract(_4d);
		int result4Whole = result4.getNumerator()/ result4.getDenominator();
		if (Math.abs(result4Whole) == 0)
			answer4 =  getFraction(result4).toString();
		else
			answer4 = Integer.toString(result4Whole) + getFraction(result4);
		
		//find the 2 - 2 2/3 =
		Fraction _5a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _5b = new Fraction(MathUtilities.getRandomNumber(3, 5));
				
		Fraction _5d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question5 = "$" + Integer.toString(_5a.getNumerator()) 
				+ " - " +  Integer.toString(_5b.getNumerator()) + "\\frac{" + Integer.toString(_5d.getNumerator())+ "}{"+ Integer.toString(_5d.getDenominator()) + "}"
				+ " = $";
		
		//_5c = _5a.add(_5c);
		_5d = _5b.add(_5d);
		
		Fraction result5 = _5a.subtract(_5d);
		
		int resultWhole5 = result5.getNumerator()/ result5.getDenominator();
		if (Math.abs(resultWhole5) == 0)
			answer5 = getFraction(result5).toString();
		else 
			answer5 = Integer.toString(resultWhole5) + getFraction(result5);
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH) + ". "+
				mSource.getMessage(GR7_Constants.MAKE_MIXED_FRACTION, null, Locale.ENGLISH), null, Constants.DEFAULT  ));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
				

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

		String  question5="";
		String answer5="";
		
				
		Fraction _5a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		Fraction _5b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		Fraction _5c = new Fraction(MathUtilities.getRandomNumber(2, 5));
				
		Fraction _5d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction _5e = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question5 = "$" + Integer.toString(_5a.getNumerator()) 
				+ " - " +  Integer.toString(_5b.getNumerator()) + "\\frac{" + Integer.toString(_5d.getNumerator())+ "}{"+ Integer.toString(_5d.getDenominator()) + "}"
				+ " + " +  Integer.toString(_5c.getNumerator()) + "\\frac{" + Integer.toString(_5e.getNumerator())+ "}{"+ Integer.toString(_5e.getDenominator()) + "}"
				+ "$";

		_5d = _5b.add(_5d);
		_5e = _5c.add(_5e);
		
		Fraction result5 = _5a.subtract(_5d).add(_5e);
		
		int resultWhole5 = result5.getNumerator()/ result5.getDenominator();
		if (Math.abs(resultWhole5) == 0)
			answer5 = getFraction(result5).toString();
		else 
			answer5 = Integer.toString(resultWhole5) + getFraction(result5);
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH) + ". "+
				mSource.getMessage(GR7_Constants.MAKE_MIXED_FRACTION, null, Locale.ENGLISH), null, Constants.DEFAULT  ));
		questionList.add(new QuestionLine( question5 , null, Constants.DEFAULT));
				
		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
		answ.setAnswer(answer5);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question5="";
		String answer5="";
		
				
		Fraction _5a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		
		Fraction _5b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		Fraction _5d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		Fraction _5c = new Fraction(MathUtilities.getRandomNumber(2, 5));	
		Fraction _5e = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question5 = "$"
				+ " - " +  Integer.toString(_5c.getNumerator()) + "\\frac{" + Integer.toString(_5e.getNumerator())+ "}{"+ Integer.toString(_5e.getDenominator()) + "}"
				+ " - " +  Integer.toString(_5b.getNumerator()) + "\\frac{" + Integer.toString(_5d.getNumerator())+ "}{"+ Integer.toString(_5d.getDenominator()) + "}"
				+ " + " +  Integer.toString(_5a.getNumerator()) 
				+ "$";

		_5d = _5b.add(_5d);
		_5e = _5c.add(_5e);
		
		Fraction result5 = _5a.subtract(_5d).subtract(_5e);
		
		int resultWhole5 = result5.getNumerator()/ result5.getDenominator();
		if (Math.abs(resultWhole5) == 0)
			answer5 = getFraction(result5).toString();
		else 
			answer5 = Integer.toString(resultWhole5) + getFraction(result5).toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH) + ". "+
				mSource.getMessage(GR7_Constants.MAKE_MIXED_FRACTION, null, Locale.ENGLISH), null, Constants.DEFAULT  ));
		questionList.add(new QuestionLine( question5 , null, Constants.DEFAULT));
				
		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
		answ.setAnswer(answer5);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question5="";
				
		Fraction _5a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		
		Fraction _5b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		Fraction _5d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		Fraction _5c = new Fraction(MathUtilities.getRandomNumber(2, 5));	
		Fraction _5e = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question5 = "$"
				+ " - " +  Integer.toString(_5c.getNumerator()) + "\\frac{" + Integer.toString(_5e.getNumerator())+ "}{"+ Integer.toString(_5e.getDenominator()) + "}"
				+ " - (" +  Integer.toString(_5b.getNumerator()) + "\\frac{" + Integer.toString(_5d.getNumerator())+ "}{"+ Integer.toString(_5d.getDenominator()) + "}"
				+ " - " +  Integer.toString(_5a.getNumerator()) 
				+ ")$";

		_5d = _5b.add(_5d);
		_5e = _5c.add(_5e);
		
		Fraction result5 = new Fraction(0); 
		result5 = result5.subtract(_5e).subtract(_5d).add(_5a);
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH) + ". ", null, Constants.DEFAULT  ));
		questionList.add(new QuestionLine( question5 , null, Constants.DEFAULT));
				
		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
		answ.setAnswer(result5.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question5="";
				
		Fraction _5a = new Fraction(MathUtilities.getRandomNumber(1, 5));
		
		Fraction _5b = new Fraction(MathUtilities.getRandomNumber(3, 5));
		Fraction _5d = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		Fraction _5c = new Fraction(MathUtilities.getRandomNumber(2, 5));	
		Fraction _5e = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		question5 = "$"
				+ " - (" +  Integer.toString(_5b.getNumerator()) + "\\frac{" + Integer.toString(_5d.getNumerator())+ "}{"+ Integer.toString(_5d.getDenominator()) + "}"
				+ " - " +  Integer.toString(_5a.getNumerator())
				+ ") + " +  Integer.toString(_5c.getNumerator()) + "\\frac{" + Integer.toString(_5e.getNumerator())+ "}{"+ Integer.toString(_5e.getDenominator()) + "}"
				+ "$";

		_5d = _5b.add(_5d);
		_5e = _5c.add(_5e);
		
		Fraction result5 = new Fraction(0); 
		result5 = result5.subtract(_5d).add(_5a).add(_5e);
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH) + ". ", null, Constants.DEFAULT  ));
		questionList.add(new QuestionLine( question5 , null, Constants.DEFAULT));
				
		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
		answ.setAnswer(result5.toString());

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	
	private String getFraction(Fraction f) {
		
		int numerator = f.getNumerator();
		int denominator = f.getDenominator();
		
		int remainder = Math.abs(numerator % denominator);
		Fraction frac = new Fraction(remainder, denominator);
		
		if (remainder > 0)
			return frac.toString();
		
		return "";
		

		
	}

}
