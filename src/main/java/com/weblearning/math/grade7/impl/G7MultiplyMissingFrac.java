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

public class G7MultiplyMissingFrac extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> grade6MultiplyFraction = new ArrayList<Problem>();

		for (int i = 0; i < 1; i++) 
			grade6MultiplyFraction.add(getProblem1(mathConfig, i));
		for (int i = 0; i < 1; i++) 
			grade6MultiplyFraction.add(getProblem2(mathConfig, i));
		for (int i = 0; i < 2; i++) 
			grade6MultiplyFraction.add(getProblem3(mathConfig, i));
		for (int i = 0; i < 2; i++) 
			grade6MultiplyFraction.add(getProblem4(mathConfig, i));
		for (int i = 0; i < 3; i++) 
			grade6MultiplyFraction.add(getProblem5(mathConfig, i));
		for (int i = 0; i < 2; i++) 
			grade6MultiplyFraction.add(getProblem6(mathConfig, i));
		for (int i = 0; i < 3; i++) 
			grade6MultiplyFraction.add(getProblem7(mathConfig, i));
		for (int i = 0; i < 3; i++) 
			grade6MultiplyFraction.add(getProblem8(mathConfig, i));


		return grade6MultiplyFraction;
	}
	
	
	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		
		//find the Box* 2/3 = 
		int _1a= MathUtilities.getRandomNumber(2, 20), _1b = MathUtilities.getRandomNumber(2, 20);
		int _1c= MathUtilities.getRandomNumber(2, 20), _1d = MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction result1 = frac1a.multiply(frac1b);

		question1 = "$ \\Box \\times "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "} = " 
				+ "\\frac{"+ Integer.toString(result1.getNumerator()) + "}{"+ Integer.toString(result1.getDenominator())+ "}" 
				+ "$";
		
		answer1 = frac1a.toString();
		
		
		//find the 1/2 + 2/3 = 
		int _2a = 2* MathUtilities.getRandomNumber(1,20), _2b= 5* MathUtilities.getRandomNumber(1,20);
		int _2c = 5* MathUtilities.getRandomNumber(1,10), _2d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
				
		Fraction result2 = frac2a.multiply(frac2b);

		question2 = "$" +"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\times "
					+ "\\Box = " 
					+ "\\frac{" + Integer.toString(result2.getNumerator()) + "}{" + Integer.toString(result2.getDenominator()) + "}"
					+ "$";
		answer2 = frac2b.toString();
		
		
		//find the 1/2 + 2/3 = 
		int _3a = 5* MathUtilities.getRandomNumber(1,20), _3b = 5* MathUtilities.getRandomNumber(1,20);
		int _3c = 2* MathUtilities.getRandomNumber(1,10), _3d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac3a = new Fraction(_3a, _3b);
		Fraction frac3b = new Fraction(_3c, _3d);
				
		Fraction result3 = frac3a.multiply(frac3b).multiply(new Fraction(-1));

		question3= "$" +"\\Box \\times "
					+ "\\frac{"+ Integer.toString(_3c) + "}{"+ Integer.toString(_3d)+ "} = " 
					+ "\\frac{"+ Integer.toString(result3.getNumerator()) + "}{"+ Integer.toString(result3.getDenominator())+ "}"
					+ "$";
		answer3 = "-" + frac3a.toString();
		
		//find the 1/2 + 2/3 =
		int _4a = 5* MathUtilities.getRandomNumber(1,20), _4b = 2* MathUtilities.getRandomNumber(1,20);
		int _4c = 5* MathUtilities.getRandomNumber(1,10), _4d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac4a = new Fraction(_4a, _4b);
		Fraction frac4b = new Fraction(_4c, _4d);
				
		Fraction result4 = frac4a.divide(frac4b);

		question4= "$" +"\\frac{" + Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "}  \\div "
					+ "\\Box = "
					+ "\\frac{" + Integer.toString(result4.getNumerator()) + "}{" + Integer.toString(result4.getDenominator()) + "}"
					+ "$";
		answer4 = frac4b.toString();
		
		//5
		int _5a = MathUtilities.getRandomNumber(1,20), _5b= MathUtilities.getRandomNumber(1,20);
		int _5c = MathUtilities.getRandomNumber(1,10), _5d= MathUtilities.getRandomNumber(1,20);
		int _5e = MathUtilities.getRandomNumber(1,10), _5f= MathUtilities.getRandomNumber(1,20);
		
		Fraction frac5a = new Fraction(_5a, _5b);
		Fraction frac5b = new Fraction(_5c, _5d);
		Fraction frac5c = new Fraction(_5e, _5f);
				
		Fraction result5 = frac5a.multiply(frac5b).divide(frac5c);

		question5 = "$ \\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\times "
						+ "\\Box  \\div" 
						+ "\\frac{"+ Integer.toString(_5e) + "}{"+ Integer.toString(_5f)+ "} = "  
						+ "\\frac{"+ Integer.toString(result5.getNumerator()) + "}{"+ Integer.toString(result5.getDenominator())+ "}"
						+ "$";
		answer5 = frac5b.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.MULTIPLY_FRACTIONS, null, Locale.ENGLISH);
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
		
		
		//find the 1/2 * 2/3 = 
		int _1a= MathUtilities.getRandomNumber(2, 20), _1b = MathUtilities.getRandomNumber(2, 20);
		int _1c= MathUtilities.getRandomNumber(2, 20), _1d = MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction result1 = frac1a.multiply(frac1b);

		question1 = "$ \\frac{" + Integer.toString(_1a) + "}{\\Box } \\times "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "} = " 
				+ "\\frac{"+ Integer.toString(result1.getNumerator()) + "}{"+ Integer.toString(result1.getDenominator())+ "}" 
				+ "$";
		
		answer1 = Integer.toString(_1b);
		
		
		//find the 1/2 + 2/3 = 
		int _2a = 2* MathUtilities.getRandomNumber(1,20), _2b= 5* MathUtilities.getRandomNumber(1,20);
		int _2c = 5* MathUtilities.getRandomNumber(1,10), _2d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
				
		Fraction result2 = frac2a.multiply(frac2b);

		question2 = "$ \\frac{\\Box}{" + Integer.toString(_2b)+ "} \\times "
					+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "} = " 
					+ "\\frac{" + Integer.toString(result2.getNumerator()) + "}{" + Integer.toString(result2.getDenominator()) + "}"
					+ "$";
		answer2 = Integer.toString(_2a);
		
		
		//find the 1/2 + 2/3 = 
		int _3a = 5* MathUtilities.getRandomNumber(1,20), _3b = 5* MathUtilities.getRandomNumber(1,20);
		int _3c = 2* MathUtilities.getRandomNumber(1,10), _3d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac3a = new Fraction(_3a, _3b);
		Fraction frac3b = new Fraction(_3c, _3d);
				
		Fraction result3 = frac3a.multiply(frac3b).multiply(new Fraction(-1));

		question3= "$ \\frac{\\Box}{" + Integer.toString(_3b)+  "} \\times "
					+ "\\frac{"+ Integer.toString(_3c) + "}{"+ Integer.toString(_3d)+ "} = " 
					+ "\\frac{"+ Integer.toString(result3.getNumerator()) + "}{"+ Integer.toString(result3.getDenominator()) + "}"
					+ "$";
		answer3 = "-" + Integer.toString(_3a);
		
		//find the 1/2 + 2/3 =
		int _4a = 5* MathUtilities.getRandomNumber(1,20), _4b = 2* MathUtilities.getRandomNumber(1,20);
		int _4c = 5* MathUtilities.getRandomNumber(1,10), _4d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac4a = new Fraction(_4a, _4b);
		Fraction frac4b = new Fraction(_4c, _4d);
				
		Fraction result4 = frac4a.divide(frac4b);

		question4= "$" +"\\frac{" + Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "}  \\div "
					+ "\\frac{\\Box}{" + Integer.toString(_4d) + "}  = "
					+ "\\frac{" + Integer.toString(result4.getNumerator()) + "}{" + Integer.toString(result4.getDenominator()) + "}"
					+ "$";
		answer4 = Integer.toString(_4c);
		
		//5
		int _5a = MathUtilities.getRandomNumber(1,20), _5b= MathUtilities.getRandomNumber(1,20);
		int _5c = MathUtilities.getRandomNumber(1,10), _5d= MathUtilities.getRandomNumber(1,20);
		int _5e = MathUtilities.getRandomNumber(1,10), _5f= MathUtilities.getRandomNumber(1,20);
		
		Fraction frac5a = new Fraction(_5a, _5b);
		Fraction frac5b = new Fraction(_5c, _5d);
		Fraction frac5c = new Fraction(_5e, _5f);
				
		Fraction result5 = frac5a.multiply(frac5b).divide(frac5c);

		question5 = "$ \\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\times "
						+ "\\Box  \\div" 
						+ "\\frac{"+ Integer.toString(_5e) + "}{"+ Integer.toString(_5f)+ "} = "  
						+ "\\frac{"+ Integer.toString(result5.getNumerator()) + "}{"+ Integer.toString(result5.getDenominator())+ "}"
						+ "$";
		answer5 = frac5b.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.MULTIPLY_FRACTIONS, null, Locale.ENGLISH);
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
		
		int _1a= MathUtilities.getRandomNumber(2, 20), _1b = MathUtilities.getRandomNumber(2, 20);
		int _1c= MathUtilities.getRandomNumber(2, 20), _1d = MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction result1 = frac1a.multiply(frac1b);

		question1 = "$ \\Box \\times "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "} = " 
				+ "\\frac{"+ Integer.toString(result1.getNumerator()) + "}{"+ Integer.toString(result1.getDenominator())+ "}" 
				+ "$";
		
		answer1 = frac1a.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 ));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
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
		
		int _4a = 5* MathUtilities.getRandomNumber(1,20), _4b = 2* MathUtilities.getRandomNumber(1,20);
		int _4c = 5* MathUtilities.getRandomNumber(1,10), _4d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac4a = new Fraction(_4a, _4b);
		Fraction frac4b = new Fraction(_4c, _4d);
				
		Fraction result4 = frac4a.divide(frac4b);

		question4= "$" +"\\frac{" + Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "}  \\div "
					+ "\\Box = "
					+ "\\frac{" + Integer.toString(result4.getNumerator()) + "}{" + Integer.toString(result4.getDenominator()) + "}"
					+ "$";
		answer4 = frac4b.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
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
		
		int _5a = MathUtilities.getRandomNumber(1,20), _5b= MathUtilities.getRandomNumber(1,20);
		int _5c = MathUtilities.getRandomNumber(1,10), _5d= MathUtilities.getRandomNumber(1,20);
		int _5e = MathUtilities.getRandomNumber(1,10), _5f= MathUtilities.getRandomNumber(1,20);
		
		Fraction frac5a = new Fraction(_5a, _5b);
		Fraction frac5b = new Fraction(_5c, _5d);
		Fraction frac5c = new Fraction(_5e, _5f);
				
		Fraction result5 = frac5a.multiply(frac5b).divide(frac5c);

		question5 = "$ \\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\times "
						+ "\\Box  \\div" 
						+ "\\frac{"+ Integer.toString(_5e) + "}{"+ Integer.toString(_5f)+ "} = "  
						+ "\\frac{"+ Integer.toString(result5.getNumerator()) + "}{"+ Integer.toString(result5.getDenominator())+ "}"
						+ "$";
		answer5 = frac5b.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question5));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
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

		String question1="";
		String answer1="";
		
		int _1a= MathUtilities.getRandomNumber(2, 20), _1b = MathUtilities.getRandomNumber(2, 20);
		int _1c= MathUtilities.getRandomNumber(2, 20), _1d = MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction result1 = frac1a.multiply(frac1b);

		question1 = "$ \\frac{" + Integer.toString(_1a) + "}{\\Box } \\times "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "} = " 
				+ "\\frac{"+ Integer.toString(result1.getNumerator()) + "}{"+ Integer.toString(result1.getDenominator())+ "}" 
				+ "$";
		
		answer1 = Integer.toString(_1b);
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer1);

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
		
		int _4a = 5* MathUtilities.getRandomNumber(1,20), _4b = 2* MathUtilities.getRandomNumber(1,20);
		int _4c = 5* MathUtilities.getRandomNumber(1,10), _4d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac4a = new Fraction(_4a, _4b);
		Fraction frac4b = new Fraction(_4c, _4d);
				
		Fraction result4 = frac4a.divide(frac4b);

		question4= "$" +"\\frac{" + Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "}  \\div "
					+ "\\frac{\\Box}{" + Integer.toString(_4d) + "}  = "
					+ "\\frac{" + Integer.toString(result4.getNumerator()) + "}{" + Integer.toString(result4.getDenominator()) + "}"
					+ "$";
		answer4 = Integer.toString(_4c);
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question5="";
		String answer5="";
		
		int _5a = MathUtilities.getRandomNumber(1,20), _5b= MathUtilities.getRandomNumber(1,20);
		int _5c = MathUtilities.getRandomNumber(1,10), _5d= MathUtilities.getRandomNumber(1,20);
		int _5e = MathUtilities.getRandomNumber(1,10), _5f= MathUtilities.getRandomNumber(1,20);
		
		Fraction frac5a = new Fraction(_5a, _5b);
		Fraction frac5b = new Fraction(_5c, _5d);
		Fraction frac5c = new Fraction(_5e, _5f);
				
		Fraction result5 = frac5a.multiply(frac5b).divide(frac5c);

		question5 = "$ \\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\times "
						+ "\\Box  \\div" 
						+ "\\frac{"+ Integer.toString(_5e) + "}{"+ Integer.toString(_5f)+ "} = "  
						+ "\\frac{"+ Integer.toString(result5.getNumerator()) + "}{"+ Integer.toString(result5.getDenominator())+ "}"
						+ "$";
		answer5 = frac5b.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question5));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer5);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
}
