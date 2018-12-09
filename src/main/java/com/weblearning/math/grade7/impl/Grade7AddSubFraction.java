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

public class Grade7AddSubFraction extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> addSubtractFraction = new ArrayList<Problem>();

		for (int i=0; i< 1; i++)
			addSubtractFraction.add(getProblem1(mathConfig, i));
		for (int i=0; i< 3; i++)
			addSubtractFraction.add(getProblem2(mathConfig, i));
		for (int i=0; i< 3; i++)
			addSubtractFraction.add(getProblem3(mathConfig, i));
		for (int i=0; i< 4; i++)
			addSubtractFraction.add(getProblem4(mathConfig, i));
		for (int i=0; i< 3; i++)
			addSubtractFraction.add(getProblem5(mathConfig, i));
		for (int i=0; i< 3; i++)
			addSubtractFraction.add(getProblem6(mathConfig, i));
		for (int i=0; i< 4; i++)
			addSubtractFraction.add(getProblem7(mathConfig, i));

		return addSubtractFraction;
	}

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
		result1 = Fraction.getReducedFraction(result1.getNumerator(), result1.getDenominator());
		question1 = "$" +"\\frac{" + Integer.toString(frac1a.getNumerator()) + "}{" + Integer.toString(frac1a.getDenominator()) + "} - "
				+ "\\frac{"+ Integer.toString(frac1b.getNumerator()) + "}{"+ Integer.toString(frac1b.getDenominator())+ "}" + "$";
		answer1 = result1.toString();
		
		
		//find the 1/2 + 2/3 = 
		int a21 = 2* MathUtilities.getRandomNumber(1, 3), a22= 2* MathUtilities.getRandomNumber(4, 8);
		int b21 = 2* MathUtilities.getRandomNumber(1, 3), b22= 2* MathUtilities.getRandomNumber(4, 8);
		Fraction frac2a = new Fraction(a21, a22);
		Fraction frac2b = new Fraction(b21, b22);
				
		Fraction result2 = frac2a.subtract(frac2b);
		//result2 = Fraction.getReducedFraction(result2.getNumerator(), result2.getDenominator());
		question2 = "$" +"\\frac{" + Integer.toString(a21) + "}{" + Integer.toString(a22) + "} - "
						+ "\\frac{"+ Integer.toString(b21) + "}{"+ Integer.toString(b22)+ "}" + "$";
		answer2 = result2.toString();
		
		//find the 1/2 + 2/3 =
		int a31= 5* MathUtilities.getRandomNumber(1,3), a32= 5* MathUtilities.getRandomNumber(4, 8);
		int b31 = 5*MathUtilities.getRandomNumber(1, 3), b32= 5*MathUtilities.getRandomNumber(4, 8);
		Fraction frac3a = new Fraction(a31, a32);
		Fraction frac3b = new Fraction(b31, b32);
						
		Fraction result3 = new Fraction(0);
		result3 = result3.subtract(frac3a).subtract(frac3b);
		result3 = Fraction.getReducedFraction(result3.getNumerator(), result3.getDenominator());
		question3 = "$" +"-\\frac{" + Integer.toString(a31) + "}{" + Integer.toString(a32) + "} - "
						+ "\\frac{"+ Integer.toString(b31) + "}{"+ Integer.toString(b32)+ "}" + "$";
		answer3 = result3.toString();
		
		
		//find the 1/2 + 2/3 = 
		int a41= 2, a42= MathUtilities.getRandomNumber(4, 5);
		int b41= MathUtilities.getRandomNumber(1, 3), b42 = MathUtilities.getRandomNumber(4, 8);
		int c41= MathUtilities.getRandomNumber(4, 8), c42= MathUtilities.getRandomNumber(9, 12);
		Fraction frac4a = new Fraction(a41, a42);
		Fraction frac4b = new Fraction(b41, b42);
		Fraction frac4c =  new Fraction(c41, c42);
		
		Fraction result4 = frac4a.subtract(frac4b).add(frac4c);
		//result4 = Fraction.getReducedFraction(result4.getNumerator(), result4.getDenominator());
		question4 = "$" +"\\frac{" + Integer.toString(a41) + "}{" + Integer.toString(a42) + "} - "
				+ "\\frac{"+ Integer.toString(Math.abs(b41)) + "}{"+ Integer.toString(b42)+ "} + " 
				+ "\\frac{"+ Integer.toString(c41) + "}{"+ Integer.toString(c42)+ "}" + 
				"$";
		answer4 = result4.toString();
		
		//find the 1/2 + 2/3 =
		int a51= MathUtilities.getRandomNumber(1, 5);
		int b51 = MathUtilities.getRandomNumber(1, 3), b52= MathUtilities.getRandomNumber(4, 8);
		Fraction frac5a = new Fraction(a51);
		Fraction frac5b = new Fraction(b51, b52);
						
		Fraction result5 = frac5a.subtract(frac5b);
		//result3 = Fraction.getReducedFraction(result3.getNumerator(), result3.getDenominator());
		question5 = "$" +   Integer.toString(a51) + " - " +
						"\\frac{"+ Integer.toString(b51) + "}{"+ Integer.toString(b52)+ "}" + "$";
		answer5 = result5.toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH), null, Constants.DEFAULT));
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

		String question1="";
		String answer1="";
		
		//find the 1/2 + 2/3 = 
		Fraction frac1a = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		Fraction frac1b = new Fraction(MathUtilities.getRandomNumber(1, 3), MathUtilities.getRandomNumber(4, 8));
		
		Fraction result1 = frac1a.subtract(frac1b);
		question1 = "$" +"\\frac{" + Integer.toString(frac1a.getNumerator()) + "}{" + Integer.toString(frac1a.getDenominator()) + "} - "
				+ "\\frac{"+ Integer.toString(frac1b.getNumerator()) + "}{"+ Integer.toString(frac1b.getDenominator())+ "}" + "$";
		answer1 = result1.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 ));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem3(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question2 ="";
		String answer2 = "";
		
		//find the 1/2 + 2/3 = 
		int a21 = 2* MathUtilities.getRandomNumber(1, 3), a22= 2* MathUtilities.getRandomNumber(4, 8);
		int b21 = 3* MathUtilities.getRandomNumber(1, 3), b22= 6* MathUtilities.getRandomNumber(4, 8);
		Fraction frac2a = new Fraction(a21, a22);
		Fraction frac2b = new Fraction(b21, b22);
				
		Fraction result2 = frac2a.subtract(frac2b);

		question2 = "$" +"\\frac{" + Integer.toString(a21) + "}{" + Integer.toString(a22) + "} - "
						+ "\\frac{"+ Integer.toString(b21) + "}{"+ Integer.toString(b22)+ "}" + "$";
		answer2 = result2.toString();
		answ.setAnswer(answer2);
			
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question2));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question4="";
		String answer4="";
	
		//find the 1/2 + 2/3 = 
		int a41= 2, a42= 2* MathUtilities.getRandomNumber(4, 5);
		int b41= MathUtilities.getRandomNumber(1, 3), b42 = MathUtilities.getRandomNumber(4, 8);
		int c41= 2* MathUtilities.getRandomNumber(4, 8), c42= 2* MathUtilities.getRandomNumber(9, 12);
		Fraction frac4a = new Fraction(a41, a42);
		Fraction frac4b = new Fraction(b41, b42);
		Fraction frac4c =  new Fraction(c41, c42);
		
		Fraction result4 = frac4a.add(frac4b).subtract(frac4c);
		//result4 = Fraction.getReducedFraction(result4.getNumerator(), result4.getDenominator());
		question4 = "$" +"\\frac{" + Integer.toString(a41) + "}{" + Integer.toString(a42) + "} + "
				+ "\\frac{"+ Integer.toString(b41) + "}{"+ Integer.toString(b42)+ "} - " 
				+ "\\frac{"+ Integer.toString(c41) + "}{"+ Integer.toString(c42)+ "}" + 
				"$";
		answer4 = result4.toString();
			
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
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
				
		//find the 1/2 + 2/3 =
		int a51= MathUtilities.getRandomNumber(1, 5);
		int b51 = MathUtilities.getRandomNumber(1, 3), b52= MathUtilities.getRandomNumber(4, 8);
		Fraction frac5a = new Fraction(a51);
		Fraction frac5b = new Fraction(b51, b52);
						
		Fraction result5 = frac5b.subtract(frac5a);

		question5 = "$" +	"\\frac{"+ Integer.toString(b51) + "}{"+ Integer.toString(b52)+ "}" + " - " +  Integer.toString(a51) + "$";
		answer5 = result5.toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question5));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
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
				
		//find the 1/2 + 2/3 =
		int a51= MathUtilities.getRandomNumber(-5, -1);
		int b51 = MathUtilities.getRandomNumber(1, 3), b52= MathUtilities.getRandomNumber(4, 8);
		Fraction frac5a = new Fraction(a51);
		Fraction frac5b = new Fraction(b51, b52);
						
		Fraction result5 = frac5b.subtract(frac5a);

		question5 = "$" +	"\\frac{"+ Integer.toString(b51) + "}{"+ Integer.toString(b52)+ "}" + " - (" +  Integer.toString(a51) + ")$";
		answer5 = result5.toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question5));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
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

		String  question4="";
		String answer4="";
	
		//find the 1/2 + 2/3 = 
		int a41= 2, a42= 2* MathUtilities.getRandomNumber(4, 5);
		int b41= MathUtilities.getRandomNumber(1, 3), b42 = MathUtilities.getRandomNumber(4, 8);
		int c41= 5* MathUtilities.getRandomNumber(4, 8), c42= 5* MathUtilities.getRandomNumber(9, 12);
		Fraction frac4a = new Fraction(a41, a42);
		Fraction frac4b = new Fraction(b41, b42);
		Fraction frac4c =  new Fraction(c41, c42);
		
		Fraction result4 = new Fraction(0);
		
		result4 = result4.subtract(frac4a).add(frac4b).add(frac4c);
		//result4 = Fraction.getReducedFraction(result4.getNumerator(), result4.getDenominator());
		question4 = "$" +"-\\frac{" + Integer.toString(a41) + "}{" + Integer.toString(a42) + "} + "
				+ "\\frac{"+ Integer.toString(b41) + "}{"+ Integer.toString(b42)+ "} - " 
				+ "(-\\frac{"+ Integer.toString(c41) + "}{"+ Integer.toString(c42)+ "})" + 
				"$";
		answer4 = result4.toString();
			
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_ADDITION, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}

}
