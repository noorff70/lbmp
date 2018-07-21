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

public class G8DecimalMixed extends GenericQuestion {

	private static final Logger logger = Logger.getLogger(G8AgExpression.class);


	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g8AgExpression = new ArrayList<Problem>();

		for (int i = 0; i < 6; i++)
			g8AgExpression.add(getProblem1(mathConfig));
		for (int i = 0; i < 6; i++)
			g8AgExpression.add(getProblem2(mathConfig));
		for (int i = 0; i < 6; i++)
			g8AgExpression.add(getProblem3(mathConfig));
		for (int i = 0; i < 7; i++)
			g8AgExpression.add(getProblem4(mathConfig));

		
		g8AgExpression = assignAnswer(g8AgExpression);

		return g8AgExpression;
	}

	/*
	 * -.6/.12 * 1/2 -7
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		//format A
		int a = MathUtilities.getRandomNumber(-9, -2);
		String A = Double.toString(a/10.00);
		Fraction fracA = new Fraction(a, 10);
		
		// format B
		Fraction fracB = new Fraction(MathUtilities.getRandomNumber(1, 10), MathUtilities.getRandomNumber(11, 20));
		int b1numerator = fracB.getNumerator();
		int b2numerator = fracB.getDenominator();
		String B = "\\frac{" + b1numerator +"}{"+ b2numerator +"}";

		//format C
		int c1Numerator = MathUtilities.getRandomNumber(-11, -20);
		int c2Denominator = MathUtilities.getRandomNumber(2, 10);
		int wholeC = c1Numerator/c2Denominator;
		int remainderC = c1Numerator % c2Denominator;
		String C= "";
		if (remainderC == 0)
			C = Integer.toString(c1Numerator/ c2Denominator);
		else
			C =   Integer.toString(wholeC) + "\\frac{"+Integer.toString(Math.abs(remainderC))+ "}{"+Integer.toString(c2Denominator)+"}";
		Fraction fracC = new Fraction(c1Numerator, c2Denominator );
			

		//format D
		int d = MathUtilities.getRandomNumber(2, 20);
		String D = Double.toString(d/100.00);
		Fraction fracD = new Fraction(d, 100);
		
		String X = "\\frac{" + Double.parseDouble(A) +  "}{" + Double.parseDouble(D) + "}";
		
		question = "$" + X + "\\times " + B + C + "$";
		
		
		Fraction resultFrac = fracA.divide(fracD).multiply(fracB).add(fracC);

		//question = "$" + A + "\\times " + B + "\\times " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(c2)+"}$";
		
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
	 * 2 + (-.2/.05) * (-3 1/2)
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		//format A
		int a = MathUtilities.getRandomNumber(-9, -2);
		String A = Double.toString(a/10.00);
		Fraction fracA = new Fraction(a, 10);
		
		// format B
		int b = MathUtilities.getRandomNumber(2, 9);
		String B = Integer.toString(b);

		//format C
		int c1Numerator = MathUtilities.getRandomNumber(-11, -20);
		int c2Denominator = MathUtilities.getRandomNumber(2, 10);
		int wholeC = c1Numerator/c2Denominator;
		int remainderC = c1Numerator % c2Denominator;
		String C= "";
		if (remainderC == 0)
			C = Integer.toString(c1Numerator/ c2Denominator);
		else
			C =   Integer.toString(wholeC) + "\\frac{"+Integer.toString(Math.abs(remainderC))+ "}{"+Integer.toString(c2Denominator)+"}";
		Fraction fracC = new Fraction(c1Numerator, c2Denominator );
			

		//format D
		int d = MathUtilities.getRandomNumber(2, 20);
		String D = Double.toString(d/100.00);
		Fraction fracD = new Fraction(d, 100);
		
		String X = "\\frac{" + Double.parseDouble(A) +  "}{" + Double.parseDouble(D) + "}";
		
		question = "$" + B + " + " + X + "\\times (" + C + ")$";
		
		
		Fraction resultFrac = fracA.divide(fracD).multiply(fracC).add(b);

		//question = "$" + A + "\\times " + B + "\\times " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(c2)+"}$";
		
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
	 * 2 + (-.2/.05) % 3 1/2
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		//format A
		int a = MathUtilities.getRandomNumber(-9, -2);
		String A = Double.toString(a/10.00);
		Fraction fracA = new Fraction(a, 10);
		
		// format B
		int b = MathUtilities.getRandomNumber(2, 9);
		String B = Integer.toString(b);

		//format C
		int c1Numerator = MathUtilities.getRandomNumber(11, 20);
		int c2Denominator = MathUtilities.getRandomNumber(2, 10);
		int wholeC = c1Numerator/c2Denominator;
		int remainderC = c1Numerator % c2Denominator;
		String C= "";
		if (remainderC == 0)
			C = Integer.toString(c1Numerator/ c2Denominator);
		else
			C =   Integer.toString(wholeC) + "\\frac{"+Integer.toString(Math.abs(remainderC))+ "}{"+Integer.toString(c2Denominator)+"}";
		Fraction fracC = new Fraction(c1Numerator, c2Denominator );
			

		//format D
		int d = MathUtilities.getRandomNumber(2, 20);
		String D = Double.toString(d/100.00);
		Fraction fracD = new Fraction(d, 100);
		
		String X = "\\frac{" + Double.parseDouble(A) +  "}{" + Double.parseDouble(D) + "}";
		
		question = "$" + B + " +( " + X + ")\\div " + C + "$";
		
		
		Fraction resultFrac = fracA.divide(fracD).divide(fracC).add(b);

		//question = "$" + A + "\\times " + B + "\\times " + whole + "\\frac{"+Integer.toString(remainder)+ "}{"+Integer.toString(c2)+"}$";
		
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
	 * (2 + (-.2/.05)) * 3 1/2
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		//format A
		int a = MathUtilities.getRandomNumber(-9, -2);
		String A = Double.toString(a/10.00);
		Fraction fracA = new Fraction(a, 10);
		
		// format B
		int b = MathUtilities.getRandomNumber(2, 9);
		String B = Integer.toString(b);

		//format C
		int c1Numerator = MathUtilities.getRandomNumber(11, 20);
		int c2Denominator = MathUtilities.getRandomNumber(2, 10);
		int wholeC = c1Numerator/c2Denominator;
		int remainderC = c1Numerator % c2Denominator;
		String C= "";
		if (remainderC == 0)
			C = Integer.toString(c1Numerator/ c2Denominator);
		else
			C =   Integer.toString(wholeC) + "\\frac{"+Integer.toString(Math.abs(remainderC))+ "}{"+Integer.toString(c2Denominator)+"}";
		Fraction fracC = new Fraction(c1Numerator, c2Denominator );
			

		//format D
		int d = MathUtilities.getRandomNumber(2, 20);
		String D = Double.toString(d/100.00);
		Fraction fracD = new Fraction(d, 100);
		
		String X = "\\frac{" + Double.parseDouble(A) +  "}{" + Double.parseDouble(D) + "}";
		
		question = "$(" + B + " +( " + X + "))\\times " + C + "$";
				
		Fraction resultFrac = fracA.divide(fracD).add(b).multiply(fracC);
		
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
