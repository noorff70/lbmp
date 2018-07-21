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

public class G8DecimalFractionAdd extends GenericQuestion {

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
	 * -.3 + 3/19 + 1 4/8 = 
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

		int n1 = MathUtilities.getRandomNumber(11, 20);
		int n2 = MathUtilities.getRandomNumber(2, 10);
		int whole = n1/n2;
		int remainder = n1 % n2;
		
		Fraction f3 = new Fraction(n1, n2);
		Fraction fa = new Fraction(a, 10);
		
		Fraction resultFrac = fa.add(fracB).add(f3);

		question = "$" + A + " + " + B + " + " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(n2)+"}$";
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
	 * -.3 + (-3/19) + 1 4/8 = 
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
		
		Fraction fracB = new Fraction(MathUtilities.getRandomNumber(-10, -1), MathUtilities.getRandomNumber(11, 20));
		int b1numerator = fracB.getNumerator();
		int b2numerator = fracB.getDenominator();
		String B = "(\\frac{" + b1numerator +"}{"+ b2numerator +"})";

		int n1 = MathUtilities.getRandomNumber(11, 20);
		int n2 = MathUtilities.getRandomNumber(2, 10);
		int whole = n1/n2;
		int remainder = n1 % n2;
		
		Fraction f3 = new Fraction(n1, n2);
		Fraction fa = new Fraction(a, 10);
		
		Fraction resultFrac = fa.add(fracB).add(f3);

		question = "$" + A + " + " + B + " + " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(n2)+"}$";
		
		if (resultFrac.getDenominator() == 1)
			ans = Integer.toString(resultFrac.getNumerator()) ;
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
	 * -.3 - (-3/19) + 1 4/8 = 
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
		
		Fraction fracB = new Fraction(MathUtilities.getRandomNumber(-10, -1), MathUtilities.getRandomNumber(11, 20));
		int b1numerator = fracB.getNumerator();
		int b2numerator = fracB.getDenominator();
		String B = "(\\frac{" + b1numerator +"}{"+ b2numerator +"})";

		int n1 = MathUtilities.getRandomNumber(11, 20);
		int n2 = MathUtilities.getRandomNumber(2, 10);
		int whole = n1/n2;
		int remainder = n1 % n2;
		
		Fraction f3 = new Fraction(n1, n2);
		Fraction fa = new Fraction(a, 10);
		
		Fraction resultFrac = fa.subtract(fracB).add(f3);

		question = "$" + A + " - " + B + " + " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(n2)+"}$";
		
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
	 * .3 - (-3/19)^2 + 1 4/8 = 
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		int a = MathUtilities.getRandomNumber(2, 10);
		String A = Double.toString(a/10.00);
		
		Fraction fracB = new Fraction(MathUtilities.getRandomNumber(-5, -1), MathUtilities.getRandomNumber(2, 5));
		int b1numerator = fracB.getNumerator();
		int b2numerator = fracB.getDenominator();
		String B = "(\\frac{" + b1numerator +"}{"+ b2numerator +"})^2";

		int n1 = MathUtilities.getRandomNumber(11, 20);
		int n2 = MathUtilities.getRandomNumber(2, 10);
		int whole = n1/n2;
		int remainder = n1 % n2;
		
		Fraction f3 = new Fraction(n1, n2);
		Fraction fa = new Fraction(a, 10);
		
		Fraction frac1 = fracB.multiply(fracB);
		Fraction resultFrac = fa.subtract(frac1).add(f3);

		if (remainder != 0) {
			question = "$" + A + " - " + B + " + " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(n2)+"}$";
		}
		else {
			question = "$" + A + " - " + B + " + " + whole + "$";
		}
		
		if(resultFrac.getDenominator() == 1)
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
	 * .3 - (-3/19) + 1 4/8 = 
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		int a = MathUtilities.getRandomNumber(2, 10);
		String A = Double.toString(a/10.00);
		
		Fraction fracB = new Fraction(MathUtilities.getRandomNumber(-5, -1), MathUtilities.getRandomNumber(2, 5));
		int b1numerator = fracB.getNumerator();
		int b2numerator = fracB.getDenominator();
		String B = "(\\frac{" + b1numerator +"}{"+ b2numerator +"})";

		int n1 = MathUtilities.getRandomNumber(11, 20);
		int n2 = MathUtilities.getRandomNumber(2, 10);
		int whole = n1/n2;
		int remainder = n1 % n2;
		
		Fraction f3 = new Fraction(n1, n2);
		Fraction fa = new Fraction(a, 10);
		
		Fraction resultFrac = fa.subtract(fracB).add(f3);


		if (remainder != 0) {
			question = "$" + A + " - " + B + " + " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(n2)+"}$";
		}
		else {
			question = "$" + A + " - " + B + " + " + whole + "$";
		}
		
		if (resultFrac.getDenominator() ==1)
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
	 * 1 4/8 + 1 1/2 - 3 = 
	 */
	public Problem getProblem6(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();
		
		//format first number
		int n1= MathUtilities.getRandomNumber(-5, -10);
		int n2 = MathUtilities.getRandomNumber(2, 4);
		int whole1 = n1/n2;
		int remainder1 = n1 % n2;
		String A1 = "";
		if (remainder1 !=0)
			A1 = Integer.toString(whole1) + "\\frac{" + Integer.toString(Math.abs(remainder1)) +"}{" + Integer.toString(Math.abs(n2)) + "}";
		else
			A1 = Integer.toString(whole1) ;
		Fraction frac1 = new Fraction(n1, n2);
		
		//format second number
		int f1= MathUtilities.getRandomNumber(5, 10);
		int f2 = MathUtilities.getRandomNumber(2, 4);
		int wholef1 = f1/f2;
		int remainderf1 = f1 % f2;
		String A2 = "";
		if (remainderf1 !=0)
			A2 = Integer.toString(wholef1) + "\\frac{" + Integer.toString(remainderf1) +"}{" + Integer.toString(f2) + "}";
		else
			A2 = Integer.toString(wholef1) ;
		Fraction frac2 = new Fraction(f1, f2);
		
		//format third number
		int x1 = MathUtilities.getRandomNumber(-5, 5);
		if (x1 == 0)
			x1 = -1;
		String A3 = Integer.toString(x1);
		Fraction frac3 = new Fraction(x1, 1);
		
		if (x1 <0 )
			question = "$" + A1 + " + " +A2 + " " + A3 + "$";
		else
			question = "$" + A1 + " + " +A2 + " + " + A3 + "$";
		
		Fraction resultFrac = (frac1).add(frac2).add(frac3);
		if (resultFrac.getDenominator() == 1)
			ans = Integer.toString(resultFrac.getNumerator()) ;
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
