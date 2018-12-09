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

public class G7SimplifyFraction extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g6SimplifyFraction = new ArrayList<Problem>();
		
		for (int i=0; i< 2; i++)
			g6SimplifyFraction.add(getProblem1(mathConfig, i));
		for (int i=0; i< 3; i++)
			g6SimplifyFraction.add(getProblem2(mathConfig, i));
		for (int i=0; i< 3; i++)
			g6SimplifyFraction.add(getProblem3(mathConfig, i));
		for (int i=0; i< 3; i++)
			g6SimplifyFraction.add(getProblem4(mathConfig, i));
		for (int i=0; i< 3; i++)
			g6SimplifyFraction.add(getProblem5(mathConfig, i));
		for (int i=0; i< 3; i++)
			g6SimplifyFraction.add(getProblem6(mathConfig, i));
		
		return g6SimplifyFraction;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		
		//find the 1/2 * 2/3 = 
		int _1ai = MathUtilities.getRandomNumber(2, 5);
		int _1a = _1ai * MathUtilities.getRandomNumber(2, 20), _1b = _1ai * MathUtilities.getRandomNumber(_1a + 1, _1a + 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);	
		
		question1 = "$" +"\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "}$";
		answer1 = frac1a.toString();
		
		
		//find the 1/2 + 2/3 = 
		int _2ai = MathUtilities.getRandomNumber(2, 5);
		int _2a = _2ai * MathUtilities.getRandomNumber(12, 20), _2b = _2ai * MathUtilities.getRandomNumber(2, 10);
		
		Fraction frac2a = new Fraction(_2a, _2b);	
		
		question2 = "$" +"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "}$";
		answer2 = frac2a.toString();
		
	
		//find the 1/2 + 2/3 = 
		int _3ai = MathUtilities.getRandomNumber(2, 5);
		int _3b = _3ai * MathUtilities.getRandomNumber(2, 10), _3a = _3ai * 23;
		
		int w3 = _3a / _3b;
		int r3 = _3a % _3b;
		
		Fraction frac3a = new Fraction(_3a, _3b);	
		
		question3 = "$" + Integer.toString(w3) + "\\frac{" + Integer.toString(r3) + "}{" + Integer.toString(_3b) + "}$";
		
		if (r3 == 0)
			answer3 = Integer.toString(w3);
		else
			answer3 = frac3a.toString();
		
		//find the 1/2 + 2/3 = 
		int _4b = MathUtilities.getRandomNumber(2, 10), _4a = _4b * MathUtilities.getRandomNumber(12, 20);
		
		Fraction frac4a = new Fraction(_4a, _4b);	
		
		question4 = "$" +"\\frac{" + Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "}$";
		answer4 = frac4a.toString();
		
		//5
		int _5b = MathUtilities.getRandomNumber(2, 10), _5a = _5b * MathUtilities.getRandomNumber(12, 20);
		
		int w5 = _5a / _5b;
		int r5 = _5a % _5b;
		
		Fraction frac5a = new Fraction(_5a, _5b);	
		
		question5 = "$" + Integer.toString(w5) + "\\frac{" + Integer.toString(r5) + "}{" + Integer.toString(_5b) + "}$";
		
		if (r5 == 0)
			answer5 = Integer.toString(w5);
		else
			answer5 = frac5a.toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.SIMPLIFY_FRACTION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
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

		String question="";
		String answer="";
		
		//find the 1/2 * 2/3 = 
		int _1ai = MathUtilities.getRandomNumber(2, 5);
		int _1a = _1ai * MathUtilities.getRandomNumber(2, 20), _1b = _1ai * MathUtilities.getRandomNumber(_1a + 1, _1a + 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);	
		
		question = "$" +"\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "}$";
		answer = frac1a.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.SIMPLIFY_FRACTION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question ));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
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
		
		int _2ai = MathUtilities.getRandomNumber(2, 5);
		int _2a = _2ai * MathUtilities.getRandomNumber(12, 20), _2b = _2ai * MathUtilities.getRandomNumber(2, 10);
		
		Fraction frac2a = new Fraction(_2a, _2b);	
		
		question = "$" +"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "}$";
		answer = frac2a.toString();
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.SIMPLIFY_FRACTION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question ));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
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
		
		int _3ai = MathUtilities.getRandomNumber(2, 5);
		int _3b = _3ai * MathUtilities.getRandomNumber(2, 10), _3a = _3ai * 23;
		
		int w3 = _3a / _3b;
		int r3 = _3a % _3b;
		
		Fraction frac3a = new Fraction(_3a, _3b);	
		int aw3 = frac3a.getNumerator()/ frac3a.getDenominator();
		int ar3 = frac3a.getNumerator()% frac3a.getDenominator();
		
		question = "$" + Integer.toString(w3) + "\\frac{" + Integer.toString(r3) + "}{" + Integer.toString(_3b) + "}$";
		
		if (r3 == 0)
			answer = Integer.toString(w3);
		else
			answer = Integer.toString(aw3) + Integer.toString(ar3) + "/" + Integer.toString(frac3a.getDenominator());
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.SIMPLIFY_FRACTION, null, Locale.ENGLISH) 
				+ ". " + mSource.getMessage(GR7_Constants.MAKE_MIXED_FRACTION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question ));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
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
		
		int _4b = MathUtilities.getRandomNumber(2, 10), _4a = _4b * MathUtilities.getRandomNumber(12, 20);
		
		Fraction frac4a = new Fraction(_4a, _4b);	
		
		question = "$" +"\\frac{" + Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "}$";
		answer = frac4a.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.SIMPLIFY_FRACTION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question ));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
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
		
		int _5b = MathUtilities.getRandomNumber(2, 10), _5a = _5b * MathUtilities.getRandomNumber(12, 20);
		
		int w5 = _5a / _5b;
		int r5 = _5a % _5b;
		
		Fraction frac5a = new Fraction(_5a, _5b);	
		
		question = "$" + Integer.toString(w5) + "\\frac{" + Integer.toString(r5) + "}{" + Integer.toString(_5b) + "}$";
		
		if (r5 == 0)
			answer = Integer.toString(w5);
		else
			answer = frac5a.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.SIMPLIFY_FRACTION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question ));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
}
