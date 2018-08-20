package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

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

public class G8IntEval3 extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8IntEval3.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> g8SqrInteger = new ArrayList<Problem>();
		
		for (int i = 0; i < 4; i++)
			g8SqrInteger.add(getProblem1(mathConfig));
		
		for (int i = 0; i < 2; i++)
			g8SqrInteger.add(getProblem2(mathConfig));
		
		for (int i = 0; i < 3; i++)
			g8SqrInteger.add(getProblem3(mathConfig));
		
		for (int i = 0; i < 4; i++)
			g8SqrInteger.add(getProblem4(mathConfig));
		
		for (int i = 0; i < 4; i++)
			g8SqrInteger.add(getProblem5(mathConfig));
		
		for (int i = 0; i < 3; i++)
			g8SqrInteger.add(getProblem6(mathConfig));
		
		for (int i = 0; i < 4; i++)
			g8SqrInteger.add(getProblem7(mathConfig)); 
		
		for (int i = 0; i < 5; i++)
			g8SqrInteger.add(getProblem8(mathConfig));
		
		return g8SqrInteger;
	}

	
	/*
	 * ((-8-6)/(-7))/4
	 */
	@SuppressWarnings("unchecked")
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-10, -2);
		int x2 = MathUtilities.getRandomNumber(2, 10);
		int x3 = 1;
		
		Map<?, ?> factorMap = MathUtilities.getListOfFactors(Math.abs(x1-x2));
		Iterator<?> it = factorMap.entrySet().iterator();
		Map.Entry<Integer, Integer> result = null;
		while (it.hasNext()) {
			result = (Entry<Integer, Integer>) it.next();
		}
		if (null == result)
			x3 = Math.abs(x1-x2);
		else 
			x3 = result.getKey();
		
		//just make x3 as negative
		x3 = Math.abs(x3) * -1;	
		
		int x4 = MathUtilities.getRandomNumber(2, 8);
		
		Fraction frac = Fraction.getReducedFraction(x1-x2, x4 * x3);
	
		question = "$(" + Integer.toString(x1) + " - "+ Integer.toString(x2) +")\\div(" + Integer.toString(x3) + ")\\over" + Integer.toString(x4) + "$";
		ans.setAnswer("$"+ Integer.toString(frac.getNumerator()) + "\\over" + Integer.toString(frac.getDenominator()) + "$");

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine>answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(ans.getAnswer()));
		answerList.add(new AnswerLine("$"+ Integer.toString(frac.getNumerator()+1) + "\\over" + Integer.toString(frac.getDenominator()) + "$"));
		answerList.add(new AnswerLine("$"+ Integer.toString(frac.getNumerator()+2) + "\\over" + Integer.toString(frac.getDenominator()) + "$"));
		answerList.add(new AnswerLine("$"+ "None of the answers" + "$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
		ans.setAnswerOption(correctAnswerOption);
		ans.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * -4 + (-6)^2 -4^2 / (-4)^0 -7 = -8/3
	 */

	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		String result = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-10, -2);
		int x2 = MathUtilities.getRandomNumber(2, 10);
		int x3 = MathUtilities.getRandomNumber(2, 5);
		
		int n1 = x1 + x2 - x3*x3;
		String numerator =  Integer.toString(x1) + " + " +  Integer.toString(x2) + " - " +    Integer.toString(x3) + "^" + Integer.toString(2) ;
		
		int y1 = MathUtilities.getRandomNumber(-5, -2);
		int yPower = 0;
		int y2= MathUtilities.getRandomNumber(-10, -2);
		int n2 =  -1 + y2;  //(int)Math.pow(y1, yPower) = -1;
		String denominator = Integer.toString(y1) + "^" + Integer.toString(yPower)  + Integer.toString(y2);

		question = "$" + numerator + "\\over" + denominator + "$" ;
		
		result = MathUtilities.fractionConversion(n1, n2, Constants.FRACTION_TYPE_NORMAL);
	

		ans.setAnswer("$"+ result  + "$");

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine>answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(ans.getAnswer()));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 *2 +1, n2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 + 1, n2*2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ "None of the answers" + "$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
		ans.setAnswerOption(correctAnswerOption);
		ans.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(ans);

		return problem;
	}
	
	
	
	/*
	 * -10 + 4 - 2^2 / -3^0 -6 = 10/7
	 */

	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";
		String result = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-10, -2);
		int x2 = MathUtilities.getRandomNumber(-10, -2);
		int x3 = MathUtilities.getRandomNumber(2, 5);
		
		int n1 = x1 + x2*x2 - x3*x3;
		String numerator =  Integer.toString(x1) + " + (" +  Integer.toString(x2) + ")^ " + Integer.toString(2) +  " - " +    Integer.toString(x3) + "^" + Integer.toString(2) ;
		
		int y1 = MathUtilities.getRandomNumber(-5, -2);
		int yPower = 0;
		int y2= MathUtilities.getRandomNumber(-10, -2);
		int n2 =  1 + y2;  //(int)Math.pow(y1, yPower) = -1;
		String denominator = "(" + Integer.toString(y1) + ")^" + Integer.toString(yPower)  + Integer.toString(y2);

		question = "$" + numerator + "\\over" + denominator + "$" ;
		
		result = MathUtilities.fractionConversion(n1, n2, Constants.FRACTION_TYPE_NORMAL);
	

		ans.setAnswer("$"+ result  + "$");

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine>answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(ans.getAnswer()));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 *2 +1, n2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 + 1, n2*2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ "None of the answers" + "$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
		ans.setAnswerOption(correctAnswerOption);
		ans.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(ans);

		return problem;
	}
	
	
	/*
	 * -2 +(-3)^2 -2^2 / (-4)^3 - 10 = -3/74
	 */

	public Problem getProblem4(MathConfiguration mathConfig) {
		
		String question = "";
		String result = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-10, -2);
		int x2 = MathUtilities.getRandomNumber(-10, -2);
		int x3 = MathUtilities.getRandomNumber(2, 5);
		
		int n1 = x1 + x2*x2 - x3*x3;
		String numerator =  Integer.toString(x1) + " + (" +  Integer.toString(x2) + ")^ " + Integer.toString(2) +  " - " +    Integer.toString(x3) + "^" + Integer.toString(2) ;
		
		int y1 = MathUtilities.getRandomNumber(-5, -2);
		int yPower = 3;
		int y2= MathUtilities.getRandomNumber(-10, -2);
		int n2 =  (int)Math.pow(y1, yPower) + y2;  //(int)Math.pow(y1, yPower) = -1;
		String denominator = "(" + Integer.toString(y1) + ")^" + Integer.toString(yPower)  + Integer.toString(y2);

		question = "$" + numerator + "\\over" + denominator + "$" ;
		
		result = MathUtilities.fractionConversion(n1, n2, Constants.FRACTION_TYPE_NORMAL);
	

		ans.setAnswer("$"+ result  + "$");

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine>answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(ans.getAnswer()));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 *2 +1, n2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 + 1, n2*2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ "None of the answers" + "$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
		ans.setAnswerOption(correctAnswerOption);
		ans.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * (7-4)^2 + (-2)^3 / -4 - (-5)^3 = 1/121
	 */

	public Problem getProblem5(MathConfiguration mathConfig) {
		
		String question = "";
		String result = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(2, 10);
		int x2 = MathUtilities.getRandomNumber(-10, -2);
		int x3 = MathUtilities.getRandomNumber(-4, -2);
		
		int n1 = (x1 + x2) * (x1 + x2) +  x3*x3 * x3;
		String numerator =  "(" + Integer.toString(x1)  +  Integer.toString(x2) + ")^ " + Integer.toString(2) + " + " + "(" +    Integer.toString(x3) + ")^" + Integer.toString(3) ;
		
		int y1 = MathUtilities.getRandomNumber(-5, -2);
		int yPower = MathUtilities.getRandomNumber(1, 3);
		int y2= MathUtilities.getRandomNumber(-10, -2);
		int n2 = y2 - (int)Math.pow(y1, yPower);  
		String denominator = Integer.toString(y2) + " - (" + Integer.toString(y1) + ")^" +  Integer.toString(yPower);

		question = "$" + numerator + "\\over" + denominator + "$" ;
		
		result = MathUtilities.fractionConversion(n1, n2, Constants.FRACTION_TYPE_NORMAL);
	

		ans.setAnswer("$"+ result  + "$");

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine>answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(ans.getAnswer()));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 *2 +1, n2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 + 1, n2*2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ "None of the answers" + "$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
		ans.setAnswerOption(correctAnswerOption);
		ans.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * (3-2)^2 + sqrt(81) / -7 -(-2)^1 = -2
	 */

	public Problem getProblem6(MathConfiguration mathConfig) {
		
		String question = "";
		String result = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(2, 10);
		int x2 = MathUtilities.getRandomNumber(-10, -2);
		int x3 = MathUtilities.getRandomNumber(2, 10);
		
		int n1 = (x1 + x2) * (x1 + x2) +  x3;
		String numerator =  "(" + Integer.toString(x1)  +  Integer.toString(x2) + ")^ " + Integer.toString(2) + " + " + "\\sqrt" +    Integer.toString(x3 * x3) ;
		
		int y1 = MathUtilities.getRandomNumber(-5, -2);
		int yPower = MathUtilities.getRandomNumber(1, 3);
		int y2= MathUtilities.getRandomNumber(-10, -2);
		int n2 = y2 - (int)Math.pow(y1, yPower);  
		String denominator = Integer.toString(y2) + " - (" + Integer.toString(y1) + ")^" +  Integer.toString(yPower);

		question = "$" + numerator + "\\over" + denominator + "$" ;
		
		result = MathUtilities.fractionConversion(n1, n2, Constants.FRACTION_TYPE_NORMAL);
	

		ans.setAnswer("$"+ result  + "$");

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine>answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(ans.getAnswer()));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 *2 +1, n2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 + 1, n2*2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ "None of the answers" + "$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
		ans.setAnswerOption(correctAnswerOption);
		ans.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * 8-3 -(-3sqrt(4)) / -9-(-3)^2 = -11/18
	 */

	public Problem getProblem7(MathConfiguration mathConfig) {
		
		String question = "";
		String result = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(2, 10);
		int x2 = MathUtilities.getRandomNumber(-10, -2);
		int x3 = MathUtilities.getRandomNumber(2, 5);
		int x4 = MathUtilities.getRandomNumber(-5, -2);
		
		int n1 = (x1 + x2) - x4 * x3;
		String numerator =  Integer.toString(x1)  +  Integer.toString(x2) + " - ( " + Integer.toString(x4) + "\\sqrt" +    Integer.toString(x3 * x3)  + ")";
		
		int y1 = MathUtilities.getRandomNumber(-5, -2);
		int yPower = MathUtilities.getRandomNumber(1, 3);
		int y2= MathUtilities.getRandomNumber(-10, -2);
		int n2 = y2 - (int)Math.pow(y1, yPower);  
		String denominator = Integer.toString(y2) + " - (" + Integer.toString(y1) + ")^" +  Integer.toString(yPower);

		question = "$" + numerator + "\\over" + denominator + "$" ;
		
		result = MathUtilities.fractionConversion(n1, n2, Constants.FRACTION_TYPE_NORMAL);
	

		ans.setAnswer("$"+ result  + "$");

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine>answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(ans.getAnswer()));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 *2 +1, n2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 + 1, n2*2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ "None of the answers" + "$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
		ans.setAnswerOption(correctAnswerOption);
		ans.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(ans);

		return problem;
	}
	
	/*
	 * 8-3 -(-3sqrt(4)) / -9-(-3)^2 = -11/18
	 */

	public Problem getProblem8(MathConfiguration mathConfig) {
		
		String question = "";
		String result = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(2, 10);
		int x2 = MathUtilities.getRandomNumber(-10, -2);
		int x3 = MathUtilities.getRandomNumber(2, 5);
		int x4 = MathUtilities.getRandomNumber(-5, -2);
		
		int n1 = (x1 + x2) - x4 * x3;
		String numerator =  Integer.toString(x1)  +  Integer.toString(x2) + " - ( " + Integer.toString(x4) + "\\sqrt" +    Integer.toString(x3 * x3)  + ")";
		
		int y1 = MathUtilities.getRandomNumber(-5, -2);
		int y2 = Math.abs(y1);
		String denominator = Integer.toString(y1) + " + " + Integer.toString(y2);
		int n2 = y1 + y2;

		question = "$" + numerator + "\\over" + denominator + "$" ;
		
		result = MathUtilities.fractionConversion(n1, n2, Constants.FRACTION_TYPE_NORMAL);
	

		ans.setAnswer("$"+ result  + "$");

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine>answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(ans.getAnswer()));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 *2 +1, n2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ MathUtilities.fractionConversion(n1 + 1, n2*2 +1, Constants.FRACTION_TYPE_NORMAL) + "$"));
		answerList.add(new AnswerLine("$"+ "None of the answers" + "$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
		ans.setAnswerOption(correctAnswerOption);
		ans.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(ans);

		return problem;
	}
		
}
