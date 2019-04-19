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

public class G7CompareFraction extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7CompareFraction = new ArrayList<Problem>();
		
		for (int i=0; i< 1; i++)
			g7CompareFraction.add(getProblem1(mathConfig, i));
		for (int i=0; i< 1; i++)
			g7CompareFraction.add(getProblem2(mathConfig, i));
		for (int i=0; i< 3; i++)
			g7CompareFraction.add(getProblem3(mathConfig, i));
		for (int i=0; i< 3; i++)
			g7CompareFraction.add(getProblem4(mathConfig, i));
		for (int i=0; i< 3; i++)
			g7CompareFraction.add(getProblem5(mathConfig, i));
		for (int i=0; i< 3; i++)
			g7CompareFraction.add(getProblem6(mathConfig, i));
		for (int i=0; i< 3; i++)
			g7CompareFraction.add(getProblem7(mathConfig, i));
		
		
		return g7CompareFraction;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//find the 1/2 * 2/3 =
		int _1ai = MathUtilities.getRandomNumber(1, 5), _1bi = MathUtilities.getRandomNumber(1,  5); 
		int _1a = MathUtilities.getRandomNumber(2, 20), _1b = MathUtilities.getRandomNumber(2, 20);
		int _1c = MathUtilities.getRandomNumber(2, 20), _1d = MathUtilities.getRandomNumber(2, 20); 
		
		Fraction frac1a = new Fraction(_1ai).add(new Fraction(_1a, _1b));
		Fraction frac1b = new Fraction(_1bi).add(new Fraction(_1c, _1d));
		
		if (frac1a.compareTo(frac1b) == 1)
			answer1 = ">";
		else if (frac1a.compareTo(frac1b) == -1)
			answer1 = "<";
		else
			answer1 = "=";
		
		question1 = "$" + Integer.toString(_1ai) + "\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\Box "
				+ Integer.toString(_1bi) + "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" + "$";
		
		
		
		//find the 1/2 + 2/3 = 
		int _2bi = MathUtilities.getRandomNumber(1,  5); 
		int _2a = MathUtilities.getRandomNumber(2, 20), _2b = MathUtilities.getRandomNumber(2, 20);
		int _2c = MathUtilities.getRandomNumber(2, 20), _2d = MathUtilities.getRandomNumber(2, 20); 
		
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2bi).add(new Fraction(_2c, _2d));
		
		if (frac2a.compareTo(frac2b) == 1)
			answer2 = ">";
		else if (frac2a.compareTo(frac2b) == -1)
			answer2 = "<";
		else
			answer2 = "=";
		
		question2 = "$" + "\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\Box "
				+ Integer.toString(_2bi) + "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" + "$";
		
		
		//find the 1/2 + 2/3 = 
		int _3ai = MathUtilities.getRandomNumber(1, 5), _3bi = MathUtilities.getRandomNumber(1,  5); 
		int _3a = MathUtilities.getRandomNumber(2, 20), _3b = MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac3a = new Fraction(_3ai).add(new Fraction(_3a, _3b));
		Fraction frac3b = new Fraction(_3bi);
		
		question3 = "$" + Integer.toString(_3ai) + "\\frac{" + Integer.toString(_3a) + "}{" + Integer.toString(_3b) + "} \\Box "
				+Integer.toString(_3bi)  + "$";
		
		if (frac3a.compareTo(frac3b) == 1)
			answer3 = ">";
		else if (frac3a.compareTo(frac3b) == -1)
			answer3 = "<";
		else
			answer3 = "=";
		
		//find the 1/2 + 2/3 =
		int _4ai = MathUtilities.getRandomNumber(2, 20), _4bi = MathUtilities.getRandomNumber(1,  5); 
		int _4a = MathUtilities.getRandomNumber(2, 20), _4b = MathUtilities.getRandomNumber(2, 20); 
		int _4c = MathUtilities.getRandomNumber(2, 20), _4d = MathUtilities.getRandomNumber(2, 20); 
		
		Fraction frac4a = new Fraction(_4ai).add(new Fraction(_4a, _4b)).multiply(new Fraction(-1));
		Fraction frac4b = new Fraction(_4bi).add(new Fraction(_4c, _4d).multiply(new Fraction(-1)));
		
		if (frac4a.compareTo(frac4b) == 1)
			answer4 = ">";
		else if (frac4a.compareTo(frac4b) == -1)
			answer4 = "<";
		else
			answer4 = "=";

		
		question4 = "$-(" + Integer.toString(_4ai) + "\\frac{"+ Integer.toString(_4a) + "}{"+ Integer.toString(_4b)+ "})  \\Box "
				+ "-" + Integer.toString(_4bi) + "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "}" + "$";

		
		//5
		int _5ai = MathUtilities.getRandomNumber(1, 5), _5bi = MathUtilities.getRandomNumber(2,  5); 
		int _5a = MathUtilities.getRandomNumber(2, 20), _5b = MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac5a = new Fraction(_5ai).add(new Fraction(_5a, _5b));
		Fraction frac5b = new Fraction(_5bi).multiply(new Fraction(-1));
		
		if (frac5a.compareTo(frac5b) == 1)
			answer5 = ">";
		else if (frac5a.compareTo(frac5b) == -1)
			answer5 = "<";
		else
			answer5 = "=";
			
		question5 = "$" + Integer.toString(_5ai) + "\\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\Box "
				+ "-" + Integer.toString(_5bi) + "$";
		
		
		questionList.add(new QuestionLine( "Fill in the blank with either >, < or =", null, Constants.DEFAULT));
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
		int _1a = MathUtilities.getRandomNumber(1, 5), _1b = MathUtilities.getRandomNumber(6, 10);
		int _1c = MathUtilities.getRandomNumber(1, 5), _1d = MathUtilities.getRandomNumber(6, 10); 
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		if (frac1a.compareTo(frac1b) == 1)
			answer1 = ">";
		else if (frac1a.compareTo(frac1b) == -1)
			answer1 = "<";
		else
			answer1 = "=";
		
		question1 = "$ \\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\Box "
				+  "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" + "$";
		
		
		
		//find the 1/2 + 2/3 = 
		int _2a = MathUtilities.getRandomNumber(6, 10), _2b = MathUtilities.getRandomNumber(2, 5);
		int _2c = MathUtilities.getRandomNumber(6, 10), _2d = MathUtilities.getRandomNumber(2, 5); 
		
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
		
		if (frac2a.compareTo(frac2b) == 1)
			answer2 = ">";
		else if (frac2a.compareTo(frac2b) == -1)
			answer2 = "<";
		else
			answer2 = "=";
		
		question2 = "$" + "\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\Box "
				+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" + "$";
		
		
		//find the 1/2 + 2/3 = 
		int _3a = MathUtilities.getRandomNumber(1, 10), _3b = MathUtilities.getRandomNumber(1,  10);
		int _3 = MathUtilities.getRandomNumber(2, 5);
		int _3c = _3 * MathUtilities.getRandomNumber(1, 10), _3d = _3 * MathUtilities.getRandomNumber(1, 10);
		
		Fraction frac3a = new Fraction(_3a, _3b);
		Fraction frac3b = new Fraction(_3c, _3d);
		
		question3 = "$ \\frac{" + Integer.toString(_3a) + "}{" + Integer.toString(_3b) + "} \\Box "
				+ "\\frac{" + Integer.toString(_3c) + "}{" + Integer.toString(_3d) + "}" + "$";
		
		if (frac3a.compareTo(frac3b) == 1)
			answer3 = ">";
		else if (frac3a.compareTo(frac3b) == -1)
			answer3 = "<";
		else
			answer3 = "=";
		
		//find the 1/2 + 2/3 =
		int _4a = MathUtilities.getRandomNumber(2, 10), _4b = MathUtilities.getRandomNumber(12, 20); 
		int _4 = MathUtilities.getRandomNumber(2, 5);
		int _4c = _4 * _4a, _4d = _4 *_4b; 
		
		Fraction frac4a = new Fraction(_4a, _4b);
		Fraction frac4b = new Fraction(_4c, _4d);
		
		if (frac4a.compareTo(frac4b) == 1)
			answer4 = ">";
		else if (frac3a.compareTo(frac3b) == -1)
			answer4 = "<";
		else
			answer4 = "=";

		
		question4 = "$ \\frac{"+ Integer.toString(_4a) + "}{"+ Integer.toString(_4b)+ "}  \\Box "
				+ "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "}" + "$";

		
		//5
		int _5a = MathUtilities.getRandomNumber(2, 5), _5b = MathUtilities.getRandomNumber(6,  10); 
		int _5 = MathUtilities.getRandomNumber(2, 10);
		int _5c = _5*_5a, _5d = _5*_5b;
		
		Fraction frac5a = new Fraction(_5a, _5b);
		Fraction frac5b = new Fraction(_5c, _5d);
		
		if (frac5a.compareTo(frac5b) == 1)
			answer5 = ">";
		else if (frac5a.compareTo(frac5b) == -1)
			answer5 = "<";
		else
			answer5 = "=";
			
		question5 = "$ \\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\Box "
				 +  "\\frac{" + Integer.toString(_5c) + "}{" + Integer.toString(_5d) + "}" + "$";
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.PERFORM_FRACTION_OPERATION, null, Locale.ENGLISH), null, Constants.DEFAULT));
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

		String question="";
		String answer="";
		
		int _4ai = MathUtilities.getRandomNumber(2, 20), _4bi = MathUtilities.getRandomNumber(1,  5); 
		int _4a = MathUtilities.getRandomNumber(2, 20), _4b = MathUtilities.getRandomNumber(2, 20); 
		int _4c = MathUtilities.getRandomNumber(2, 20), _4d = MathUtilities.getRandomNumber(2, 20); 
		
		Fraction frac4a = new Fraction(_4ai).add(new Fraction(_4a, _4b)).multiply(new Fraction(-1));
		Fraction frac4b = new Fraction(_4bi).add(new Fraction(_4c, _4d).multiply(new Fraction(-1)));
		
		if (frac4a.compareTo(frac4b) == 1)
			answer = ">";
		else if (frac4a.compareTo(frac4b) == -1)
			answer = "<";
		else
			answer = "=";

		
		question = "$-(" + Integer.toString(_4ai) + "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "})  \\Box "
				+ "-" + Integer.toString(_4bi) + "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "}" + "$";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		int _1a = MathUtilities.getRandomNumber(1, 5), _1b = MathUtilities.getRandomNumber(6, 10);
		int _1c = MathUtilities.getRandomNumber(1, 5), _1d = MathUtilities.getRandomNumber(6, 10); 
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		if (frac1a.compareTo(frac1b) == 1)
			answer = ">";
		else if (frac1a.compareTo(frac1b) == -1)
			answer = "<";
		else
			answer = "=";
		
		question = "$ \\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\Box "
				+  "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" + "$";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		int _3a = MathUtilities.getRandomNumber(1, 10), _3b = MathUtilities.getRandomNumber(1,  10);
		int _3 = MathUtilities.getRandomNumber(2, 5);
		int _3c = _3 * MathUtilities.getRandomNumber(1, 10), _3d = _3 * MathUtilities.getRandomNumber(1, 10);
		
		Fraction frac3a = new Fraction(_3a, _3b);
		Fraction frac3b = new Fraction(_3c, _3d);
		
		question = "$ \\frac{" + Integer.toString(_3a) + "}{" + Integer.toString(_3b) + "} \\Box "
				+ "\\frac{" + Integer.toString(_3c) + "}{" + Integer.toString(_3d) + "}" + "$";
		
		if (frac3a.compareTo(frac3b) == 1)
			answer = ">";
		else if (frac3a.compareTo(frac3b) == -1)
			answer = "<";
		else
			answer = "=";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		int _5a = MathUtilities.getRandomNumber(2, 5), _5b = MathUtilities.getRandomNumber(6,  10); 
		int _5 = MathUtilities.getRandomNumber(2, 10);
		int _5c = _5*_5a, _5d = _5*_5b;
		
		Fraction frac5a = new Fraction(_5a, _5b);
		Fraction frac5b = new Fraction(_5c, _5d);
		
		if (frac5a.compareTo(frac5b) == 1)
			answer = ">";
		else if (frac5a.compareTo(frac5b) == -1)
			answer = "<";
		else
			answer = "=";
			
		question = "$ \\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\Box "
				 +  "\\frac{" + Integer.toString(_5c) + "}{" + Integer.toString(_5d) + "}" + "$";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem7(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		int _5a = MathUtilities.getRandomNumber(2, 5), _5b = MathUtilities.getRandomNumber(6,  10); 
		int _5c = MathUtilities.getRandomNumber(2, 5), _5d = MathUtilities.getRandomNumber(6,  10); 
		int _5 = MathUtilities.getRandomNumber(2, 10);
		
		Fraction frac5a = new Fraction(_5a, _5b);
		Fraction frac5b = new Fraction(_5c, _5d);
		
		frac5a = frac5a.add(new Fraction(_5));
		frac5b = frac5b.add(new Fraction(-5));
		
		if (frac5a.compareTo(frac5b) == 1)
			answer = ">";
		else if (frac5a.compareTo(frac5b) == -1)
			answer = "<";
		else
			answer = "=";
			
		question = "$" + Integer.toString(_5)+" \\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\Box "
				 + Integer.toString(_5) +"\\frac{" + Integer.toString(_5c) + "}{" + Integer.toString(_5d) + "}" + "$";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
}