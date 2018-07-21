package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8DecimalMultiDivi extends GenericQuestion {

	private static final Logger logger = Logger.getLogger(G8AgExpression.class);


	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g8AgExpression = new ArrayList<Problem>();

		for (int i = 0; i < 3; i++)
			g8AgExpression.add(getProblem1(mathConfig));
		for (int i = 0; i < 2; i++)
			g8AgExpression.add(getProblem2(mathConfig));
		for (int i = 0; i < 5; i++)
			g8AgExpression.add(getProblem3(mathConfig));
		for (int i = 0; i < 5; i++)
			g8AgExpression.add(getProblem4(mathConfig));
		for (int i = 0; i < 5; i++)
			g8AgExpression.add(getProblem5(mathConfig));
		for (int i = 0; i < 5; i++)
			g8AgExpression.add(getProblem6(mathConfig));

		
		g8AgExpression = assignAnswer(g8AgExpression);

		return g8AgExpression;
	}

	/*
	 * -6.4*1/6 * 2 4/8
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		int a = MathUtilities.getRandomNumber(-100, -2);
		String A = Double.toString(a/10.00);
		
		Fraction fracB = new Fraction(MathUtilities.getRandomNumber(1, 10), MathUtilities.getRandomNumber(11, 20));
		int b1numerator = fracB.getNumerator();
		int b2numerator = fracB.getDenominator();
		String B = "\\frac{" + b1numerator +"}{"+ b2numerator +"}";

		int c1 = MathUtilities.getRandomNumber(11, 20);
		int c2 = MathUtilities.getRandomNumber(2, 10);
		int whole = c1/c2;
		int remainder = c1 % c2;
		
		Fraction f3 = new Fraction(c1, c2);
		Fraction fa = new Fraction(a, 10);
		
		Fraction resultFrac = fa.multiply(fracB).multiply(f3);

		question = "$" + A + "\\times " + B + "\\times " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(c2)+"}$";
		
		if (resultFrac.getDenominator() == 1)
			ans = Integer.toString(resultFrac.getNumerator());
		else
			ans = "$" + "\\frac{"+ resultFrac.getNumerator() + "}{" + resultFrac.getDenominator() + "}$" ;
		answer.setAnswer(ans);
		
		questionList.add( new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH) , null, null));
		questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
	
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(ans));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-1) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-5) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-3) + "}{" + resultFrac.getDenominator() + "}$"));
		answer.setAnswerList(answerList);

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * -6.4*1/6 * 2 4/8
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		int a = MathUtilities.getRandomNumber(-100, -2);
		String A = Double.toString(a/10.00);
		
		Fraction fracB = new Fraction(MathUtilities.getRandomNumber(1, 10), MathUtilities.getRandomNumber(11, 20));
		int b1numerator = fracB.getNumerator();
		int b2numerator = fracB.getDenominator();
		String B = "\\frac{" + b1numerator +"}{"+ b2numerator +"}";

		int c1 = MathUtilities.getRandomNumber(11, 20);
		int c2 = MathUtilities.getRandomNumber(2, 10);
		int whole = c1/c2;
		int remainder = c1 % c2;
		
		Fraction f3 = new Fraction(c1, c2);
		Fraction fa = new Fraction(a, 10);
		
		Fraction resultFrac = fa.multiply(fracB).multiply(f3);

		question = "$" + A + "\\times " + B + "\\times " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(c2)+"}$";
		
		if (resultFrac.getDenominator() == 1)
			ans = Integer.toString(resultFrac.getNumerator());
		else
			ans = "$" + "\\frac{"+ resultFrac.getNumerator() + "}{" + resultFrac.getDenominator() + "}$" ;
		answer.setAnswer(ans);
		
		questionList.add( new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH) , null, null));
		questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
	
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(ans));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-1) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-5) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-3) + "}{" + resultFrac.getDenominator() + "}$"));
		answer.setAnswerList(answerList);

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * *1/6 * ( -6.4 * 2 4/8)
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		int a = MathUtilities.getRandomNumber(-100, -2);
		String A = Double.toString(a/10.00);
		
		Fraction fracB = new Fraction(MathUtilities.getRandomNumber(1, 10), MathUtilities.getRandomNumber(11, 20));
		int b1numerator = fracB.getNumerator();
		int b2numerator = fracB.getDenominator();
		String B = "\\frac{" + b1numerator +"}{"+ b2numerator +"}";

		int c1 = MathUtilities.getRandomNumber(11, 20);
		int c2 = MathUtilities.getRandomNumber(2, 10);
		int whole = c1/c2;
		int remainder = c1 % c2;
		
		Fraction f3 = new Fraction(c1, c2);
		Fraction fa = new Fraction(a, 10);
		
		Fraction resultFrac = fa.multiply(fracB).multiply(f3);

		question = "$" + B + "\\times( " + A + "\\times " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(c2)+"})$";
		
		if (resultFrac.getDenominator() == 1)
			ans = Integer.toString(resultFrac.getNumerator());
		else
			ans = "$" + "\\frac{"+ resultFrac.getNumerator() + "}{" + resultFrac.getDenominator() + "}$" ;
		answer.setAnswer(ans);
		
		questionList.add( new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH) , null, null));
		questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
	
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(ans));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-1) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-5) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-3) + "}{" + resultFrac.getDenominator() + "}$"));
		answer.setAnswerList(answerList);

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * 1/6 % ( -6.4) * 2 4/8
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		int a = MathUtilities.getRandomNumber(-100, -2);
		String A = Double.toString(a/10.00);
		
		Fraction fracB = new Fraction(MathUtilities.getRandomNumber(1, 10), MathUtilities.getRandomNumber(11, 20));
		int b1numerator = fracB.getNumerator();
		int b2numerator = fracB.getDenominator();
		String B = "\\frac{" + b1numerator +"}{"+ b2numerator +"}";

		int c1 = MathUtilities.getRandomNumber(11, 20);
		int c2 = MathUtilities.getRandomNumber(2, 10);
		int whole = c1/c2;
		int remainder = c1 % c2;
		
		Fraction f3 = new Fraction(c1, c2);
		Fraction fa = new Fraction(a, 10);
		
		Fraction resultFrac = fracB.divide(fa).multiply(f3);

		question = "$" + B + "\\div (" + A + ")\\times " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(c2)+"}$";
		if (resultFrac.getDenominator() == 1)
			ans = Integer.toString(resultFrac.getNumerator());
		else 
			ans = "$" + "\\frac{"+ resultFrac.getNumerator() + "}{" + resultFrac.getDenominator() + "}$" ;
		answer.setAnswer(ans);
		
		questionList.add( new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH) , null, null));
		questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
	
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(ans));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-1) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-5) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-3) + "}{" + resultFrac.getDenominator() + "}$"));
		answer.setAnswerList(answerList);

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * 1/6 % ( -6.4 * 2 4/8)
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		// Format A
		Fraction fracA = new Fraction (MathUtilities.getRandomNumber(1, 5), MathUtilities.getRandomNumber(6,  10));
		String A = "\\frac{" + Integer.toString(fracA.getNumerator()) + "}{" + Integer.toString(fracA.getDenominator()) + "}";
		
		//format B
		int b1 = MathUtilities.getRandomNumber(-10, -20);
		int b2 = MathUtilities.getRandomNumber(2, 8);
		int bWhole = b1/b2;
		int bRemainder = b1 % b2;
		String B = "";
		if (bRemainder == 0)
			B = "\\frac{" + Integer.toString(b1) + "}{" + Integer.toString(b2) + "}";
		else
			B = Integer.toString(bWhole) + "\\frac{" + Integer.toString(Math.abs(bRemainder)) + "}{" + Integer.toString(b2) + "}";
		Fraction fracB = new Fraction(b1, b2);

		//format C
		int c1 = MathUtilities.getRandomNumber(11, 20);
		int c2 = MathUtilities.getRandomNumber(2, 10);
		int whole = c1/c2;
		int remainder = c1 % c2;
		String C ="";
		if (remainder == 0)
			C = "\\frac{" + Integer.toString(c1) + "}{" + Integer.toString(c2) + "}";
		else
			C = Integer.toString(whole) + "\\frac{" + Integer.toString(remainder) + "}{" + Integer.toString(c2) + "}";
		Fraction fracC = new Fraction(c1, c2);
		
		Fraction insideBrac = fracB.multiply(fracC);
		Fraction resultFrac = fracA.divide(insideBrac);

		question = "$" + A + "\\div("+ B + "\\times" + C + ")$";
		if (resultFrac.getDenominator() == 1)
			ans = "$"+ Integer.toString(resultFrac.getNumerator()) + "$"; 
		else
			ans = "$" + "\\frac{"+ resultFrac.getNumerator() + "}{" + resultFrac.getDenominator() + "}$" ;
		answer.setAnswer(ans);
		
		questionList.add( new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH) , null, null));
		questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
	
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(ans));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-1) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-5) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-3) + "}{" + resultFrac.getDenominator() + "}$"));
		answer.setAnswerList(answerList);

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * (-1/6 *  -6.4) % 2 4/8
	 */
	public Problem getProblem6(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		// Format A
		Fraction fracA = new Fraction (MathUtilities.getRandomNumber(-5, -1), MathUtilities.getRandomNumber(6,  10));
		String A = "\\frac{" + Integer.toString(fracA.getNumerator()) + "}{" + Integer.toString(fracA.getDenominator()) + "}";
		
		//format B
		int b1 = MathUtilities.getRandomNumber(-10, -20);
		int b2 = MathUtilities.getRandomNumber(2, 8);
		int bWhole = b1/b2;
		int bRemainder = b1 % b2;
		String B = "";
		if (bRemainder == 0)
			B = "\\frac{" + Integer.toString(b1) + "}{" + Integer.toString(b2) + "}";
		else
			B = Integer.toString(bWhole) + "\\frac{" + Integer.toString(Math.abs(bRemainder)) + "}{" + Integer.toString(b2) + "}";
		Fraction fracB = new Fraction(b1, b2);

		//format C
		int c1 = MathUtilities.getRandomNumber(11, 20);
		int c2 = MathUtilities.getRandomNumber(2, 10);
		int whole = c1/c2;
		int remainder = c1 % c2;
		String C ="";
		if (remainder == 0)
			C = "\\frac{" + Integer.toString(c1) + "}{" + Integer.toString(c2) + "}";
		else
			C = Integer.toString(whole) + "\\frac{" + Integer.toString(remainder) + "}{" + Integer.toString(c2) + "}";
		Fraction fracC = new Fraction(c1, c2);
		
		Fraction insideBrac = fracA.multiply(fracB);
		Fraction resultFrac = insideBrac.divide(fracC);

		question = "$(" + A + "\\times"+ B + ")\\div" + C + "$";
		if (resultFrac.getDenominator() == 1)
			ans = "$"+ Integer.toString(resultFrac.getNumerator()) + "$"; 
		else
			ans = "$" + "\\frac{"+ resultFrac.getNumerator() + "}{" + resultFrac.getDenominator() + "}$" ;
		answer.setAnswer(ans);
		
		questionList.add( new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH) , null, null));
		questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
	
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(ans));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-1) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-5) + "}{" + resultFrac.getDenominator() + "}$"));
		answerList.add( new AnswerLine("$" + "\\frac{"+ Integer.toString(resultFrac.getNumerator()-3) + "}{" + resultFrac.getDenominator() + "}$"));
		answer.setAnswerList(answerList);

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
		
	public List<Problem> assignAnswer (List<Problem> problemList) {
		
		for (int i=0; i< problemList.size(); i++) {
			Problem prb = problemList.get(i);
			Answer ans = prb.getAnswer();
			//set the first one as correct answer
			ans.setAnswer(ans.getAnswerList().get(0).getAnswerLn().replaceAll("$", ""));
			//rearrange answers
			List<?>answerList = MathUtilities.getQuestionList(ans.getAnswerList(), ans.getAnswerList().size() - 1, 0);
			
			String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
			ans.setAnswerOption(correctAnswerOption);
		}
		
		return problemList;
	}
	

}
