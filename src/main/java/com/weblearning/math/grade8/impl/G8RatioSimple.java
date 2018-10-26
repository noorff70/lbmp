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

public class G8RatioSimple extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8RatioSimple.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> gRatioSample = new ArrayList<Problem>();
		
		for (int i = 0; i < 4; i++)
			gRatioSample.add(getProblem1(mathConfig));
		for (int i = 0; i < 4; i++)
			gRatioSample.add(getProblem2(mathConfig));
		for (int i = 0; i < 2; i++)
			gRatioSample.add(getProblem3(mathConfig));
		for (int i = 0; i < 2; i++)
			gRatioSample.add(getProblem4(mathConfig));
		for (int i = 0; i < 4; i++)
			gRatioSample.add(getProblem5(mathConfig));
		for (int i = 0; i < 4; i++)
			gRatioSample.add(getProblem6(mathConfig));
		for (int i = 0; i < 5; i++)
			gRatioSample.add(getProblem7(mathConfig));
		

		gRatioSample = MathUtilities.assignAnswer(gRatioSample);
		
		return gRatioSample;
	}

	/*
	 * x1: x = n1: n2; x =  (x1 * n2)/ n1
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		int n1 = MathUtilities.getRandomNumber( -10, 10);
		if (n1 == 0)
			n1 = 3;
		int n2 = MathUtilities.getRandomNumber(1, 10);
		int x1 = MathUtilities.getRandomNumber(2, 20);
		double x = (double)(x1 * n2) / n1 ;
		x = MathUtilities.getRoundedAnswer(x, 2);
			
		MessageSource mSource = mathConfig.getmSource();
		question = Integer.toString(x1) + " : " + " x = " + Integer.toString(n1) + " : " + Integer.toString(n2); 
		
		//set answer
		answer.setAnswer(Double.toString(x));
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine(Double.toString(MathUtilities.getRoundedAnswer((x *10), 2))));
		answerList.add(new AnswerLine(Double.toString(MathUtilities.getRoundedAnswer((x *1.5), 2))));
		answerList.add(new AnswerLine(Double.toString(MathUtilities.getRoundedAnswer((x *.75), 2))));

		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_UNDERSTAND_RATIOS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * x: 2 = 4: 5; x = 1 3/5
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		int b = MathUtilities.getRandomNumber(1, 10);
		int c = MathUtilities.getRandomNumber(2, 20);
		int d = MathUtilities.getRandomNumber(5, 20);
		
		int numerator = b*c;
		int denominator = d;
		
		MessageSource mSource = mathConfig.getmSource();
		question =  "x : " + Integer.toString(b) + " = " + Integer.toString(c) + " : " + Integer.toString(d); 
		String ans = "$" + MathUtilities.fractionConversion(numerator, denominator, Constants.FRACTION_TYPE_MIXED) + "$";
		
		//set answer
		answer.setAnswer(ans);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine("$" +MathUtilities.fractionConversion(numerator*2, denominator, Constants.FRACTION_TYPE_MIXED) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(numerator+ 4, denominator, Constants.FRACTION_TYPE_MIXED) + "$"));;
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(numerator+2, denominator+2, Constants.FRACTION_TYPE_MIXED) + "$"));

		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_UNDERSTAND_RATIOS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * 5 / (1/2) = x / .25 = 2 1/2
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		//format a
		int a = MathUtilities.getRandomNumber(-2, -10);
		
		//format b
		Fraction b = new Fraction (MathUtilities.getRandomNumber(1, 5), MathUtilities.getRandomNumber(6, 10));
		
		//format d
		int dInt = MathUtilities.getRandomNumber(1, 20);
		double d = (double) dInt/100;
		Fraction fracD = new Fraction(dInt , 100);
		
		String left = "$" + Integer.toString(a) + "\\over" + MathUtilities.fractionConversion(b.getNumerator(), b.getDenominator(), null) + "$";
		String right = "$" + " x " + "\\over" + Double.toString(MathUtilities.getRoundedAnswer(d, 2)) + "$";
		question = left + " = " + right;
		
		MessageSource mSource = mathConfig.getmSource();
		Fraction resultFrac = fracD.multiply(a).divide(b);
		
		//set answer
		answer.setAnswer("$" + MathUtilities.fractionConversion(resultFrac.getNumerator(), resultFrac.getDenominator(), null) + "$");
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator(), resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()+2, resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()*5, resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()+3, resultFrac.getDenominator(), null) + "$"));

		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_UNDERSTAND_RATIOS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * 5 / (1/2) = x / .25 = 2 1/2
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		//format a
		int a = MathUtilities.getRandomNumber(2, 5);
		
		//format b
		Fraction b = new Fraction (MathUtilities.getRandomNumber(1, 5), MathUtilities.getRandomNumber(6, 10));
		
		//format d
		int dInt = MathUtilities.getRandomNumber(1, 10);
		double d = (double) dInt/100;
		Fraction fracD = new Fraction(dInt , 100);
		
		String left = "$" + Integer.toString(a) + "\\over" + MathUtilities.fractionConversion(b.getNumerator(), b.getDenominator(), null) + "$";
		String right = "$" + " x " + "\\over" + Double.toString(MathUtilities.getRoundedAnswer(d, 2)) + "$";
		question = left + " = " + right;
		
		MessageSource mSource = mathConfig.getmSource();
		Fraction resultFrac = fracD.multiply(a).divide(b);
		
		//set answer
		answer.setAnswer("$" + MathUtilities.fractionConversion(resultFrac.getNumerator(), resultFrac.getDenominator(), null) + "$");
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator(), resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()+2, resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()*5, resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()+3, resultFrac.getDenominator(), null) + "$"));

		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_UNDERSTAND_RATIOS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * x/(3 1/2) = 2 1/2 / .2 
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		//format b
		Fraction b = new Fraction (MathUtilities.getRandomNumber(6, 10), MathUtilities.getRandomNumber(2, 5));
		
		// format C
		Fraction c = new Fraction (MathUtilities.getRandomNumber(6, 10), MathUtilities.getRandomNumber(2, 5));
		
		//format d
		int dInt = MathUtilities.getRandomNumber(1, 20);
		double d = (double) dInt/100;
		Fraction fracD = new Fraction(dInt , 100);
		
		String left = "$" + " x " + "\\over" + MathUtilities.fractionConversion(b.getNumerator(), b.getDenominator(), null) + "$";
		String right = "$" + MathUtilities.fractionConversion(c.getNumerator(), c.getDenominator(), null)  + "\\over" + Double.toString(MathUtilities.getRoundedAnswer(d, 2)) + "$";
		question = left + " = " + right;
		
		MessageSource mSource = mathConfig.getmSource();
		Fraction resultFrac = c.multiply(b).divide(fracD);
		
		//set answer
		answer.setAnswer("$" + MathUtilities.fractionConversion(resultFrac.getNumerator(), resultFrac.getDenominator(), null) + "$");
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator(), resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()+2, resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()*5, resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()+3, resultFrac.getDenominator(), null) + "$"));

		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_UNDERSTAND_RATIOS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * .x/(3 1/2) = 2 1/2 / .2 
	 */
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		//format b
		Fraction b = new Fraction (MathUtilities.getRandomNumber(5, 10), MathUtilities.getRandomNumber(2, 5));
		
		// format C
		Fraction c = new Fraction (MathUtilities.getRandomNumber(5, 10), MathUtilities.getRandomNumber(2, 5));
		
		//format d
		int dInt = MathUtilities.getRandomNumber(1, 20);
		double d = (double) dInt/100;
		Fraction fracD = new Fraction(dInt , 100);
		
		String left = "$" + " .x " + "\\over" + MathUtilities.fractionConversion(b.getNumerator(), b.getDenominator(), null) + "$";
		String right = "$" + MathUtilities.fractionConversion(c.getNumerator(), c.getDenominator(), null)  + "\\over" + Double.toString(MathUtilities.getRoundedAnswer(d, 2)) + "$";
		question = left + " = " + right;
		
		MessageSource mSource = mathConfig.getmSource();
		Fraction resultFrac = c.multiply(b).divide(fracD).multiply(10);
		
		//set answer
		answer.setAnswer("$" + MathUtilities.fractionConversion(resultFrac.getNumerator(), resultFrac.getDenominator(), null) + "$");
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator(), resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()+2, resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()*5, resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()+3, resultFrac.getDenominator(), null) + "$"));

		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_UNDERSTAND_RATIOS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * (3 1/2)/.x = 2 1/2 / .2 
	 */
	public Problem getProblem7(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		
		//format b
		Fraction b = new Fraction (MathUtilities.getRandomNumber(11, 25), MathUtilities.getRandomNumber(2, 10));
		
		// format C
		Fraction c = new Fraction (MathUtilities.getRandomNumber(11, 25), MathUtilities.getRandomNumber(2, 10));
		
		//format d
		int dInt = MathUtilities.getRandomNumber(1, 20);
		double d = (double) dInt/10;
		Fraction fracD = new Fraction(dInt , 10);
		
		String left = "$" + MathUtilities.fractionConversion(b.getNumerator(), b.getDenominator(), null) + "\\over" + " .x "  + "$";
		String right = "$" + MathUtilities.fractionConversion(c.getNumerator(), c.getDenominator(), null)  + "\\over" + Double.toString(MathUtilities.getRoundedAnswer(d, 2)) + "$";
		question = left + " = " + right;
		
		MessageSource mSource = mathConfig.getmSource();
		Fraction resultFrac = b.multiply(fracD).divide(c).multiply(10);
		
		//set answer
		answer.setAnswer("$" + MathUtilities.fractionConversion(resultFrac.getNumerator(), resultFrac.getDenominator(), null) + "$");
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_VALUE_OF_X, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator(), resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()+2, resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()*5, resultFrac.getDenominator(), null) + "$"));
		answerList.add(new AnswerLine("$" + MathUtilities.fractionConversion(resultFrac.getNumerator()+3, resultFrac.getDenominator(), null) + "$"));

		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_EIGHT_UNDERSTAND_RATIOS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}

}
