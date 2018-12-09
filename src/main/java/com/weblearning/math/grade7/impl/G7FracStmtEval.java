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

public class G7FracStmtEval extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g6FracStmtEval = new ArrayList<Problem>();

		for (int i = 0; i < 2; i++)
			g6FracStmtEval.add(getProblem1(mathConfig, i));
		for (int i = 0; i < 2; i++)
			g6FracStmtEval.add(getProblem2(mathConfig, i));
		for (int i = 0; i < 2; i++)
			g6FracStmtEval.add(getProblem3(mathConfig, i));
		for (int i = 0; i < 2; i++)
			g6FracStmtEval.add(getProblem4(mathConfig, i));
		for (int i = 0; i < 2; i++)
			g6FracStmtEval.add(getProblem5(mathConfig, i));
		for (int i = 0; i < 3; i++)
			g6FracStmtEval.add(getProblem6(mathConfig, i));
		for (int i = 0; i < 3; i++)
			g6FracStmtEval.add(getProblem7(mathConfig, i));
		for (int i = 0; i < 3; i++)
			g6FracStmtEval.add(getProblem8(mathConfig, i));
		for (int i = 0; i < 3; i++)
			g6FracStmtEval.add(getProblem9(mathConfig, i)); 
		for (int i = 0; i < 3; i++)
			g6FracStmtEval.add(getProblem10(mathConfig, i));

		return g6FracStmtEval;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		Fraction frac1a = new Fraction(MathUtilities.getRandomNumber(2, 20), MathUtilities.getRandomNumber(2, 20));
		Fraction frac1b = new Fraction(MathUtilities.getRandomNumber(2, 20), MathUtilities.getRandomNumber(2, 20));
		
		Fraction frac1c = new Fraction(MathUtilities.getRandomNumber(2, 20), MathUtilities.getRandomNumber(2, 20));
		Fraction frac1d = new Fraction(MathUtilities.getRandomNumber(2, 20), MathUtilities.getRandomNumber(2, 20));
		
		if (frac1a.multiply(frac1b).compareTo(frac1c.multiply(frac1d)) ==1 )
			answer= ">";
		else if (frac1a.multiply(frac1b).compareTo(frac1c.multiply(frac1d)) == -1)
			answer= "<";
		else
			answer = "=";

		question = "$" +"\\frac{" + Integer.toString(frac1a.getNumerator()) + "}{" + Integer.toString(frac1a.getDenominator()) + "} \\times "
				+ "\\frac{"+ Integer.toString(frac1b.getNumerator()) + "}{"+ Integer.toString(frac1b.getDenominator())+ "}" 
				+ "  \\Box  " 
				+"\\frac{" + Integer.toString(frac1c.getNumerator()) + "}{" + Integer.toString(frac1c.getDenominator()) + "} \\times "
				+ "\\frac{"+ Integer.toString(frac1d.getNumerator()) + "}{"+ Integer.toString(frac1d.getDenominator())+ "}" 
				+ "$";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
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
		
		int _1a = 2*MathUtilities.getRandomNumber(2, 20), _1b = 5*MathUtilities.getRandomNumber(2, 20);
		int _1c = 2*MathUtilities.getRandomNumber(2, 20), _1d = 5*MathUtilities.getRandomNumber(2, 20);
		
		int _2a = 5*MathUtilities.getRandomNumber(2, 20), _2b = 2*MathUtilities.getRandomNumber(2, 20);
		int _2c = 2*MathUtilities.getRandomNumber(2, 20), _2d = 5*MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
		

		
		if (frac1a.add(frac1b).compareTo(frac2a.multiply(frac2b)) ==1 )
			answer= ">";
		else if (frac1a.add(frac1b).compareTo(frac2a.multiply(frac2b)) == -1 )
			answer= "<";
		else
			answer = "=";

		question = "$" +"\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} + "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" 
				+ "  \\Box  " 
				+"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\times "
				+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" 
				+ "$";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
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
		
		int _1a = 2*MathUtilities.getRandomNumber(2, 20), _1b = 5*MathUtilities.getRandomNumber(2, 20);
		int _1c = 2*MathUtilities.getRandomNumber(2, 20), _1d = 5*MathUtilities.getRandomNumber(2, 20);
		
		int _2a = 5*MathUtilities.getRandomNumber(2, 20), _2b = 2*MathUtilities.getRandomNumber(2, 20);
		int _2c = 2*MathUtilities.getRandomNumber(2, 20), _2d = 5*MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
		

		
		if (frac1a.multiply(frac1b).compareTo(frac2a.divide(frac2b)) ==1 )
			answer= ">";
		else if (frac1a.multiply(frac1b).compareTo(frac2a.divide(frac2b)) == -1 )
			answer= "<";
		else
			answer = "=";

		question = "$" +"\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\times "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" 
				+ "  \\Box  " 
				+"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\div "
				+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" 
				+ "$";
	
		
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
		
		int _1a = 0, _1b = 5*MathUtilities.getRandomNumber(2, 20);
		int _1c = 2*MathUtilities.getRandomNumber(2, 20), _1d = 5*MathUtilities.getRandomNumber(2, 20);
		
		int _2a = 0, _2b = 2*MathUtilities.getRandomNumber(2, 20);
		int _2c = 2*MathUtilities.getRandomNumber(2, 20), _2d = 5*MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
		
		
		if (frac1a.multiply(frac1b).compareTo(frac2a.divide(frac2b)) ==1 )
			answer= ">";
		else if (frac1a.multiply(frac1b).compareTo(frac2a.divide(frac2b)) == -1 )
			answer= "<";
		else
			answer = "=";

		question = "$" +"\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\times "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" 
				+ "  \\Box  " 
				+"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\div "
				+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" 
				+ "$";
	
		
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
		
		int _1a = 2*MathUtilities.getRandomNumber(2, 20), _1b = 5*MathUtilities.getRandomNumber(2, 20);
		int _1c = 2*MathUtilities.getRandomNumber(2, 20), _1d = 5*MathUtilities.getRandomNumber(2, 20);
		
		int _2a = 5*MathUtilities.getRandomNumber(2, 20), _2b = 2*MathUtilities.getRandomNumber(2, 20);
		int _2c = 2*MathUtilities.getRandomNumber(2, 20), _2d = 5*MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
		
		frac1a = frac1a.multiply(new Fraction(-1));
		frac2a = frac2b.multiply(new Fraction(-1));
		
		if (frac1a.multiply(frac1b).compareTo(frac2a.multiply(frac2b)) ==1 )
			answer= ">";
		else if (frac1a.multiply(frac1b).compareTo(frac2a.multiply(frac2b)) == -1 )
			answer= "<";
		else
			answer = "=";

		question = "$" +"(-\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "}) \\times "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" 
				+ "  \\Box  " 
				+"(-\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "}) \\times "
				+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" 
				+ "$";
	
		
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
		
		int _1a = 2*MathUtilities.getRandomNumber(2, 20), _1b = 5*MathUtilities.getRandomNumber(2, 20);
		int _1c = 2*MathUtilities.getRandomNumber(2, 20), _1d = 5*MathUtilities.getRandomNumber(2, 20);
		
		int _2a = 5*MathUtilities.getRandomNumber(2, 20), _2b = 2*MathUtilities.getRandomNumber(2, 20);
		int _2c = 2*MathUtilities.getRandomNumber(2, 20), _2d = 5*MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
		
		frac2a = frac2b.multiply(new Fraction(-1));
		
		if (frac1a.multiply(frac1b).compareTo(frac2a.multiply(frac2b)) ==1 )
			answer= ">";
		else if (frac1a.multiply(frac1b).compareTo(frac2a.multiply(frac2b)) == -1 )
			answer= "<";
		else
			answer = "=";

		question = "$" +"\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\times "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" 
				+ "  \\Box  " 
				+"(-\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "}) \\times "
				+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" 
				+ "$";
	
		
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
		
		int _1a = 0, _1b = 5*MathUtilities.getRandomNumber(2, 20);
		int _1c = 2*MathUtilities.getRandomNumber(2, 20), _1d = 5*MathUtilities.getRandomNumber(2, 20);
		
		int _2a = 5*MathUtilities.getRandomNumber(2, 20), _2b = 2*MathUtilities.getRandomNumber(2, 20);
		int _2c = 2*MathUtilities.getRandomNumber(2, 20), _2d = 5*MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
		
		
		if (frac1a.multiply(frac1b).compareTo(frac2a.divide(frac2b)) ==1 )
			answer= ">";
		else if (frac1a.multiply(frac1b).compareTo(frac2a.divide(frac2b)) == -1 )
			answer= "<";
		else
			answer = "=";

		question = "$" +"\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\times "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" 
				+ "  \\Box  " 
				+"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\div "
				+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" 
				+ "$";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
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
		
		int _1a = 2*MathUtilities.getRandomNumber(2, 20), _1b = 5*MathUtilities.getRandomNumber(2, 20);
		int _1c = 2*MathUtilities.getRandomNumber(2, 20), _1d = 5*MathUtilities.getRandomNumber(2, 20);
		
		int _2a = 5*MathUtilities.getRandomNumber(2, 20), _2b = 2*MathUtilities.getRandomNumber(2, 20);
		int _2c = 2*MathUtilities.getRandomNumber(2, 20), _2d = 5*MathUtilities.getRandomNumber(2, 20);
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
		

		
		if (frac1a.divide(frac1b).compareTo(frac2a.subtract(frac2b)) ==1 )
			answer= ">";
		else if (frac1a.divide(frac1b).compareTo(frac2a.subtract(frac2b)) == -1 )
			answer= "<";
		else
			answer = "=";

		question = "$" +"\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\div "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" 
				+ "  \\Box  " 
				+"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} - "
				+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" 
				+ "$";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem9(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		int _1a = 2*MathUtilities.getRandomNumber(2, 20), _1b = 5*MathUtilities.getRandomNumber(2, 20);
		int _1c = 2*MathUtilities.getRandomNumber(2, 20), _1d = 5*MathUtilities.getRandomNumber(2, 20);
		
		int factor1 = MathUtilities.getRandomNumber(1, 5);
		int factor2 = MathUtilities.getRandomNumber(1, 5);
		int _2a = _1a*factor1, _2b = _1b*factor1;
		int _2c = _1c*factor2, _2d = _1d*factor2;
		
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
			
		if (frac1a.multiply(frac1b).compareTo(frac2a.multiply(frac2b)) ==1 )
			answer= ">";
		else if (frac1a.multiply(frac1b).compareTo(frac2a.multiply(frac2b)) == -1 )
			answer= "<";
		else
			answer = "=";

		question = "$" +"\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\times "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" 
				+ "  \\Box  " 
				+"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\times "
				+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" 
				+ "$";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem10(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		int a = MathUtilities.getRandomNumber(1, 5);
		int _1a = MathUtilities.getRandomNumber(2, 20), _1b = MathUtilities.getRandomNumber(2, 20);
		int _1c = MathUtilities.getRandomNumber(2, 20), _1d = MathUtilities.getRandomNumber(2, 20);
		
		int b = MathUtilities.getRandomNumber(2, 5);
		int _2a = 5*MathUtilities.getRandomNumber(2, 20), _2b = 2*MathUtilities.getRandomNumber(2, 20);
		int _2c = 2*MathUtilities.getRandomNumber(2, 20), _2d = 5*MathUtilities.getRandomNumber(2, 20);
		
		Fraction fa = new Fraction(a);
		Fraction frac1a = new Fraction(_1a, _1b);
		Fraction frac1b = new Fraction(_1c, _1d);
		
		Fraction fb = new Fraction(b);
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
		
		fa = fa.add(frac1a);
		fb = fb.add(frac2a);
		
		if (frac1a.subtract(frac1b).compareTo(frac2a.subtract(frac2b)) ==1 )
			answer= ">";
		else if (frac1a.subtract(frac1b).compareTo(frac2a.subtract(frac2b)) == -1 )
			answer= "<";
		else
			answer = "=";

		question = "$" + Integer.toString(a)+ "\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} - "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}  " 
				+ "  \\Box   " 
				+ Integer.toString(b) +"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} - "
				+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" 
				+ "$";
	
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EVALUATE_WITH_SIGN, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_OPERATION_EVALUATE, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	

}

