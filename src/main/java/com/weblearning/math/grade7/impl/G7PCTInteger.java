package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

public class G7PCTInteger extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7pctIntegern = new ArrayList<Problem>();
		
		g7pctIntegern.add(getProblem1(mathConfig));
		g7pctIntegern.add(getProblem2(mathConfig));
		g7pctIntegern.add(getProblem3(mathConfig));
		g7pctIntegern.add(getProblem4(mathConfig));
		
		return g7pctIntegern;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="";
		String answer1="", answer2="", answer3="";
		
		//
		int _1a= 5*MathUtilities.getRandomNumber(2, 50);
		//Fraction _1f = new Fraction(_1a, 100);
		answer1 = Integer.toString(_1a) + "/" + Integer.toString(100) ;
		
		////
		int _2a= 5*MathUtilities.getRandomNumber(2, 50);
		Fraction _2f = new Fraction(_2a, 100);
		if (_2f.getDenominator() ==1)
			answer2 = Integer.toString(_2f.getNumerator());
		else
			answer2 = Integer.toString(_2f.getNumerator()) + "/" + Integer.toString(_2f.getDenominator());
		
		///
		int _3a= 100*MathUtilities.getRandomNumber(1, 5);
		Fraction _3f = new Fraction(_3a, 100);
		answer3 = Integer.toString(_3f.getNumerator());
		
		question1= "Do not simplify " + Integer.toString(_1a) + "$\\% $";
		question2= "Simplify when possible " + Integer.toString(_2a) + "$\\%$";
		question3= "Find the result. " + Integer.toString(_3a) + "$\\%$";
				
		questionList.add(new QuestionLine( "Calculate Percentage on the Following" , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.PERCENTAGE_BASICS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="";
		String answer1="", answer2="", answer3="";
		////
		int _1a=MathUtilities.getRandomNumber(1, 5);
		int _1b=5*MathUtilities.getRandomNumber(15, 50);
		Fraction _1f = new Fraction(_1a*_1b, 100);
		if (_1f.getDenominator() == 1)
			answer1 = _1f.toString();
		else
			answer1 = Integer.toString(_1f.getNumerator()) + "/" + Integer.toString(_1f.getDenominator());
		
		///
		int _2a=MathUtilities.getRandomNumber(1, 5);
		int _2b=5*MathUtilities.getRandomNumber(15, 50);
		BigDecimal _2bg = new BigDecimal((double)_2a*_2b/100).setScale(2, RoundingMode.HALF_UP);
		answer2 = _2bg.toString();
		
		////
		double _3a=(double)MathUtilities.getRandomNumber(10, 50)/100;
		int _3b=5*MathUtilities.getRandomNumber(15, 50);
		BigDecimal _3bg = new BigDecimal((double)_3a*_3b/100).setScale(2, RoundingMode.HALF_UP);
		answer3 = _3bg.toString();
		
		question1= Integer.toString(_1a) + "% of " + Integer.toString(_1b) + " . Write in fraction if possible.";
		question2= Integer.toString(_2a) + "% of " + Integer.toString(_2b) + " . Round upto 2 decimals.";
		question3= Double.toString(_3a) + "% of " + Integer.toString(_3b) + " . Round upto 2 decimals.";
		
		
		questionList.add(new QuestionLine( "Calculate Percentage on the Following" , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.PERCENTAGE_BASICS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="",question3="";
		String answer1="", answer2="", answer3="";
		////
		int _1a=MathUtilities.getRandomNumber(1, 5);
		int _1b=5*MathUtilities.getRandomNumber(15, 50);
		Fraction _1f = new Fraction(_1a*_1b, 100);
		answer1 = Integer.toString(_1a);
		
		///
		int _2a=MathUtilities.getRandomNumber(1, 5);
		int _2b=5*MathUtilities.getRandomNumber(15, 50);
		BigDecimal _2bg = new BigDecimal((double)_2a*_2b/100).setScale(2, RoundingMode.HALF_UP);
		answer2 = Integer.toString(_2a);
		
		//
		int _3a=MathUtilities.getRandomNumber(2, 10);
		int _3b=5*MathUtilities.getRandomNumber(15, 50);
		BigDecimal _3bg = new BigDecimal((double)_3a*_3b/100).setScale(2, RoundingMode.HALF_UP);
		answer3 = Integer.toString(_3b);
		
		if (_1f.getDenominator() == 1)
			question1= "$\\Box \\%" + " . " + " of " + Integer.toString(_1b) + " = " + Integer.toString(_1f.getNumerator())+ "$";
		else
			question1= "$\\Box \\%" + " . " + " of " + Integer.toString(_1b) + " = \\frac{" + Integer.toString(_1f.getNumerator()) +"}{"+ Integer.toString(_1f.getDenominator()) + "}$";
		question2= "$\\Box \\% . of " + Integer.toString(_2b) + " = " + _2bg.toString() + "$";
		question3= "$" + Integer.toString(_3a)  + "\\% of \\Box" + " = " + _3bg.toString() + "$";
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.PERCENTAGE_BASICS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		question= "Write in fraction x" + " $\\%$";
		answer = "x" + "/" + Integer.toString(100);
			
		questionList.add(new QuestionLine(question));
		
		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}

}
