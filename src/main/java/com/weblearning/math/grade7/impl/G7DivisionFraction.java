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

public class G7DivisionFraction extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> grade6DivisionFraction = new ArrayList<Problem>();

		for (int i = 0; i < 1; i++)
			grade6DivisionFraction.add(getProblem1(mathConfig, i));
		for (int i = 0; i < 1; i++)
			grade6DivisionFraction.add(getProblem2(mathConfig, i));
		for (int i = 0; i < 3; i++)
			grade6DivisionFraction.add(getProblem3(mathConfig, i));
		for (int i = 0; i < 3; i++)
			grade6DivisionFraction.add(getProblem4(mathConfig, i));
		for (int i = 0; i < 4; i++)
			grade6DivisionFraction.add(getProblem5(mathConfig, i));
		for (int i = 0; i < 4; i++)
			grade6DivisionFraction.add(getProblem6(mathConfig, i));
		for (int i = 0; i < 3; i++)
			grade6DivisionFraction.add(getProblem7(mathConfig, i));
		for (int i = 0; i < 3; i++)
			grade6DivisionFraction.add(getProblem8(mathConfig, i));
		

		return grade6DivisionFraction;
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
		int _1a = MathUtilities.getRandomNumber(1, 10), _1b = MathUtilities.getRandomNumber(2, 5)*_1a;
		int _1c = MathUtilities.getRandomNumber(2, 10), _1d = MathUtilities.getRandomNumber(2, 5)*_1c; 
		
		Fraction frac1a = new Fraction(_1ai).add(new Fraction(_1a, _1b));
		Fraction frac1b = new Fraction(_1bi).add(new Fraction(_1c, _1d));
		
		Fraction result1 = frac1a.multiply(frac1b);
		
		question1 = "$" + Integer.toString(_1ai) + "\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\times "
				+ Integer.toString(_1bi) + "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" + "$";
		answer1 = result1.toString();
		
		
		//find the 1/2 + 2/3 = 
		int _2ai = MathUtilities.getRandomNumber(1, 5), _2bi = MathUtilities.getRandomNumber(1,  5); 
		int _2a = MathUtilities.getRandomNumber(1, 5), _2b = MathUtilities.getRandomNumber(2, 5)*_2a;
		int _2c = MathUtilities.getRandomNumber(2, 10), _2d = MathUtilities.getRandomNumber(2, 5)*_2c; 
		
		Fraction frac2a = new Fraction(_2ai).add(new Fraction(_2a, _2b));
		Fraction frac2b = new Fraction(_2bi).add(new Fraction(_2c, _2d));
		
		Fraction result2 = frac2a.divide(frac2b);
		
		question2 = "$" + Integer.toString(_2ai) + "\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\div "
				+ Integer.toString(_2bi) + "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" + "$";
		answer2 = result2.toString();
		
		
		//find the 1/2 + 2/3 = 
		int _3ai = MathUtilities.getRandomNumber(1, 5), _3bi = MathUtilities.getRandomNumber(1,  5); 
		int _3a = MathUtilities.getRandomNumber(1, 10), _3b = MathUtilities.getRandomNumber(2, 5)*_3a;
		int _3c = MathUtilities.getRandomNumber(1, 5), _3d = MathUtilities.getRandomNumber(2, 10)*_3c; 
		
		Fraction frac3a = new Fraction(_3ai).add(new Fraction(_3a, _3b));
		Fraction frac3b = new Fraction(_3bi).add(new Fraction(_3c, _3d));
		
		Fraction result3 = frac3a.divide(frac3b).multiply(new Fraction(-1));
		
		question3 = "$" + Integer.toString(_3ai) + "\\frac{" + Integer.toString(_3a) + "}{" + Integer.toString(_3b) + "} \\div "
				+ "(-" +Integer.toString(_3bi) + "\\frac{"+ Integer.toString(_3c) + "}{"+ Integer.toString(_3d)+ "})" + "$";
		answer3 = result3.toString();
		
		//find the 1/2 + 2/3 =
		int _4ai = MathUtilities.getRandomNumber(2, 20), _4bi = MathUtilities.getRandomNumber(1,  5); 
		int _4c = MathUtilities.getRandomNumber(2, 10), _4d = MathUtilities.getRandomNumber(2, 5)*_4c; 
		
		Fraction frac4a = new Fraction(_4ai);
		Fraction frac4b = new Fraction(_4bi).add(new Fraction(_4c, _4d));
		
		Fraction result4 = frac4a.multiply(frac4b);
		
		question4 = "$" + Integer.toString(_4ai) + " \\times "
				+ Integer.toString(_4bi) + "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "}" + "$";
		answer4 = result4.toString();
		
		
		//5
		int _5ai = MathUtilities.getRandomNumber(1, 5), _5bi = MathUtilities.getRandomNumber(2,  5); 
		int _5a = MathUtilities.getRandomNumber(2, 20), _5b = MathUtilities.getRandomNumber(2, 5)*_5a;
		
		Fraction frac5a = new Fraction(_5ai).add(new Fraction(_5a, _5b));
		Fraction frac5b = new Fraction(_5bi);
		
		Fraction result5 = frac5a.divide(frac5b);
		
		question5 = "$" + Integer.toString(_5ai) + "\\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\div "
				+ Integer.toString(_5bi) + "$";
		answer5 = result5.toString();
		
		
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


	public Problem getProblem2(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//find the 1/2 * 2/3 =
		int _1ai = MathUtilities.getRandomNumber(2, 20), _1bi = MathUtilities.getRandomNumber(2, 20); 
		int _1c = MathUtilities.getRandomNumber(1, 10), _1d = MathUtilities.getRandomNumber(2, 10)*_1c; 
		
		Fraction frac1a = new Fraction(_1ai);
		Fraction frac1b = new Fraction(_1bi).add(new Fraction(_1c, _1d));
		
		Fraction result1 = frac1a.divide(frac1b);
		
		question1 = "$" + Integer.toString(_1ai)  + " \\div "
				+ Integer.toString(_1bi) + "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" + "$";
		answer1 = result1.toString();
		
		
		//find the 1/2 + 2/3 = 
		int _2ai = MathUtilities.getRandomNumber(1, 5), _2bi = MathUtilities.getRandomNumber(1,  5); 
		int _2a = MathUtilities.getRandomNumber(1, 5), _2b = MathUtilities.getRandomNumber(2, 5)*_2a;
		int _2c = MathUtilities.getRandomNumber(1, 10), _2d = MathUtilities.getRandomNumber(2, 5)*_2c; 
		
		Fraction frac2a = new Fraction(_2ai).add(new Fraction(_2a, _2b));
		Fraction frac2b = new Fraction(_2bi).add(new Fraction(_2c, _2d));
		
		Fraction result2 = frac2a.divide(frac2b);
		
		question2 = "$(-" + Integer.toString(_2ai) + "\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "}) \\div "
				+"(-" +Integer.toString(_2bi) + "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "})" + "$";
		answer2 = result2.toString();
		
		
		//find the 1/2 + 2/3 = 
		int _3ai = MathUtilities.getRandomNumber(1, 5), _3bi = MathUtilities.getRandomNumber(1,  5), _3ci= MathUtilities.getRandomNumber(2, 20); 
		int _3a = MathUtilities.getRandomNumber(1, 5), _3b = MathUtilities.getRandomNumber(2, 10)*_3a;
		int _3c = MathUtilities.getRandomNumber(2, 10), _3d = MathUtilities.getRandomNumber(2, 5)*_3c;
		int _3e = MathUtilities.getRandomNumber(1, 5), _3f = MathUtilities.getRandomNumber(2, 10)*_3e; 
		
		Fraction frac3a = new Fraction(_3ai).add(new Fraction(_3a, _3b));
		Fraction frac3b = new Fraction(_3bi).add(new Fraction(_3c, _3d));
		Fraction frac3c = new Fraction(_3ci).add(new Fraction(_3e, _3f));
		
		Fraction result3 = frac3a.divide(frac3b).divide(frac3c);
		
		question3 = "$" + Integer.toString(_3ai) + "\\frac{" + Integer.toString(_3a) + "}{" + Integer.toString(_3b) + "} \\div "
				+ "(" +Integer.toString(_3bi) + "\\frac{"+ Integer.toString(_3c) + "}{"+ Integer.toString(_3d)+ "}) \\div "
				+ "(" +Integer.toString(_3ci) + "\\frac{"+ Integer.toString(_3e) + "}{"+ Integer.toString(_3f)+ "})"
				+ "$";
		answer3 = result3.toString();
		
		//find the 1/2 + 2/3 =
		int _4ai = MathUtilities.getRandomNumber(2, 20), _4bi = MathUtilities.getRandomNumber(1,  5), _4ci= MathUtilities.getRandomNumber(1, 5); 
		int _4c = MathUtilities.getRandomNumber(2, 10), _4d = MathUtilities.getRandomNumber(2, 5)*_4c; 
		int _4e = MathUtilities.getRandomNumber(1, 5), _4f = MathUtilities.getRandomNumber(2, 10)*_4e; 
		
		Fraction frac4a = new Fraction(_4ai);
		Fraction frac4b = new Fraction(_4bi).add(new Fraction(_4c, _4d));
		Fraction frac4c = new Fraction(_4ci).add(new Fraction(_4e, _4f));
		
		Fraction result4 = frac4a.multiply(frac4b).divide(frac4c);
		
		question4 = "$" + Integer.toString(_4ai) + " \\times "
				+ Integer.toString(_4bi) + "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "} \\div"
				+ Integer.toString(_4ci) + "\\frac{"+ Integer.toString(_4e) + "}{"+ Integer.toString(_4f)+ "}"
				+ "$";
		answer4 = result4.toString();
		
		
		//5
		int _5ai = MathUtilities.getRandomNumber(1, 5), _5bi = MathUtilities.getRandomNumber(2,  5), _5ci= MathUtilities.getRandomNumber(2, 5); 
		int _5a = MathUtilities.getRandomNumber(2, 10), _5b = MathUtilities.getRandomNumber(2, 5)*_5a;
		
		Fraction frac5a = new Fraction(_5ai).add(new Fraction(_5a, _5b));
		Fraction frac5b = new Fraction(_5bi);
		Fraction frac5c = new Fraction(_5ci);
		
		Fraction result5 = frac5a.divide(frac5b).divide(frac5c);
		
		question5 = "$" + Integer.toString(_5ai) + "\\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\div "
				+ Integer.toString(_5bi) + "\\div"
				+ Integer.toString(_5ci)
				+ "$";
		answer5 = result5.toString();
		
		
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
		
		int _4ai = MathUtilities.getRandomNumber(2, 20), _4bi = MathUtilities.getRandomNumber(1,  5), _4ci= MathUtilities.getRandomNumber(1, 5); 
		int _4c = MathUtilities.getRandomNumber(2, 5), _4d = MathUtilities.getRandomNumber(2, 10)*_4c; 
		int _4e = MathUtilities.getRandomNumber(2, 5), _4f = MathUtilities.getRandomNumber(2, 20)*_4e; 
		
		Fraction frac4a = new Fraction(_4ai);
		Fraction frac4b = new Fraction(_4bi).add(new Fraction(_4c, _4d));
		Fraction frac4c = new Fraction(_4ci).add(new Fraction(_4e, _4f));
		
		Fraction result4 = frac4a.multiply(frac4b).divide(frac4c);
		
		question = "$" + Integer.toString(_4ai) + " \\times "
				+ Integer.toString(_4bi) + "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "} \\div"
				+ Integer.toString(_4ci) + "\\frac{"+ Integer.toString(_4e) + "}{"+ Integer.toString(_4f)+ "}"
				+ "$";
		answer = result4.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.PERFORM_FRACTION_OPERATION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.MULTIPLY_FRACTIONS, null, Locale.ENGLISH);
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
		
		int _4ai = MathUtilities.getRandomNumber(2, 20), _4bi = MathUtilities.getRandomNumber(1,  5), _4ci= MathUtilities.getRandomNumber(1, 5); 
		int _4a = MathUtilities.getRandomNumber(2, 5), _4b = MathUtilities.getRandomNumber(2, 10)*_4a; 
		int _4e = MathUtilities.getRandomNumber(2, 10), _4f = MathUtilities.getRandomNumber(2, 5)*_4e; 
		
		Fraction frac4a = new Fraction(_4ai).add(new Fraction(_4a, _4b));
		Fraction frac4b = new Fraction(_4bi);
		Fraction frac4c = new Fraction(_4ci).add(new Fraction(_4e, _4f));
		
		Fraction result4 = frac4a.divide(frac4b).multiply(frac4c);
		
		question = "$" + Integer.toString(_4ai) + "\\frac{"+ Integer.toString(_4a) + "}{"+ Integer.toString(_4b)+ "}  \\div "
				+ Integer.toString(_4bi) + " \\times"
				+ Integer.toString(_4ci) + "\\frac{"+ Integer.toString(_4e) + "}{"+ Integer.toString(_4f)+ "}"
				+ "$";
		answer = result4.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.PERFORM_FRACTION_OPERATION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.MULTIPLY_FRACTIONS, null, Locale.ENGLISH);
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
		
		int _4ai = MathUtilities.getRandomNumber(2, 20), _4bi = MathUtilities.getRandomNumber(1,  5), _4ci= MathUtilities.getRandomNumber(1, 5); 
		int _4a = MathUtilities.getRandomNumber(2, 5), _4b = MathUtilities.getRandomNumber(2, 10)*_4a; 
		int _4c = MathUtilities.getRandomNumber(2, 10), _4d = MathUtilities.getRandomNumber(2, 10)*_4c; 
		int _4e = MathUtilities.getRandomNumber(2, 5), _4f = MathUtilities.getRandomNumber(2, 15)*_4e; 
		
		Fraction frac4a = new Fraction(_4ai).add(new Fraction(_4a, _4b));
		Fraction frac4b = new Fraction(_4bi).add(new Fraction(_4c, _4d));
		Fraction frac4c = new Fraction(_4ci).add(new Fraction(_4e, _4f));
		
		Fraction result4 = frac4a.multiply(frac4b).multiply(frac4c);
		
		question = "$-" + Integer.toString(_4ai) + "\\frac{"+ Integer.toString(_4a) + "}{"+ Integer.toString(_4b)+ "} \\times"
				+ Integer.toString(_4bi) + "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "} \\times"
				+ "-(" + Integer.toString(_4ci) + "\\frac{"+ Integer.toString(_4e) + "}{"+ Integer.toString(_4f)+ "})"
				+ "$";
		answer = result4.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.PERFORM_FRACTION_OPERATION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.MULTIPLY_FRACTIONS, null, Locale.ENGLISH);
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
		
		int _4ai = MathUtilities.getRandomNumber(2, 20), _4bi = MathUtilities.getRandomNumber(1,  5), _4ci= MathUtilities.getRandomNumber(1, 5); 
		int _4a = MathUtilities.getRandomNumber(2, 10), _4b = MathUtilities.getRandomNumber(2, 5)*_4a; 
		int _4e = MathUtilities.getRandomNumber(2, 5), _4f = MathUtilities.getRandomNumber(2, 10)*_4e; 
		
		Fraction frac4a = new Fraction(_4ai).add(new Fraction(_4a, _4b));
		Fraction frac4b = new Fraction(_4bi);
		Fraction frac4c = new Fraction(_4ci).add(new Fraction(_4e, _4f));
		
		Fraction result4 = frac4a.divide(frac4b).divide(frac4c);
		
		question = "$-" + Integer.toString(_4ai) + "\\frac{"+ Integer.toString(_4a) + "}{"+ Integer.toString(_4b)+ "} \\div"
				+ "-(" +Integer.toString(_4bi) + ") \\div"
				+ "-(" + Integer.toString(_4ci) + "\\frac{"+ Integer.toString(_4e) + "}{"+ Integer.toString(_4f)+ "})"
				+ "$";
		answer = "-" +result4.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.PERFORM_FRACTION_OPERATION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.MULTIPLY_FRACTIONS, null, Locale.ENGLISH);
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
		
		int _4ai = 0, _4bi = MathUtilities.getRandomNumber(1,  5), _4ci= MathUtilities.getRandomNumber(1, 5); 
		int _4a = MathUtilities.getRandomNumber(2, 10), _4b = MathUtilities.getRandomNumber(2, 5)*_4a; 
		int _4c = MathUtilities.getRandomNumber(2, 10), _4d = MathUtilities.getRandomNumber(2, 5)*_4c; 
		int _4e = MathUtilities.getRandomNumber(2, 5), _4f = MathUtilities.getRandomNumber(2, 10)*_4e; 
		
		Fraction frac4a = new Fraction(_4ai).add(new Fraction(_4a, _4b));
		Fraction frac4b = new Fraction(_4bi).add(new Fraction(_4c, _4d));
		Fraction frac4c = new Fraction(_4ci).add(new Fraction(_4e, _4f));
		
		Fraction result4 = frac4a.multiply(frac4b).multiply(frac4c);
		
		question = "$-" + Integer.toString(_4ai) + "\\frac{"+ Integer.toString(_4a) + "}{"+ Integer.toString(_4b)+ "} \\times"
				+ Integer.toString(_4bi) + "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "} \\times"
				+ "-(" + Integer.toString(_4ci) + "\\frac{"+ Integer.toString(_4e) + "}{"+ Integer.toString(_4f)+ "})"
				+ "$";
		answer = result4.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.PERFORM_FRACTION_OPERATION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.MULTIPLY_FRACTIONS, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		int _4ai = MathUtilities.getRandomNumber(1,  5), _4bi = MathUtilities.getRandomNumber(1,  5), _4ci= MathUtilities.getRandomNumber(1, 5); 
		int _4a = MathUtilities.getRandomNumber(2, 20), _4b = MathUtilities.getRandomNumber(2, 5)*_4a; 
		int _4c = 0, _4d = MathUtilities.getRandomNumber(2, 20); 
		int _4e = MathUtilities.getRandomNumber(1, 10), _4f = MathUtilities.getRandomNumber(2, 5)*_4e; 
		
		Fraction frac4a = new Fraction(_4ai).add(new Fraction(_4a, _4b));
		Fraction frac4b = new Fraction(_4bi).add(new Fraction(_4c, _4d));
		Fraction frac4c = new Fraction(_4ci).add(new Fraction(_4e, _4f));
		
		Fraction result4 = frac4a.multiply(frac4b).multiply(frac4c);
		
		question = "$-" + Integer.toString(_4ai) + "\\frac{"+ Integer.toString(_4a) + "}{"+ Integer.toString(_4b)+ "} \\times"
				+ Integer.toString(_4bi) + "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "} \\times"
				+ "-(" + Integer.toString(_4ci) + "\\frac{"+ Integer.toString(_4e) + "}{"+ Integer.toString(_4f)+ "})"
				+ "$";
		answer = result4.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.PERFORM_FRACTION_OPERATION, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.MULTIPLY_FRACTIONS, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
		

}

