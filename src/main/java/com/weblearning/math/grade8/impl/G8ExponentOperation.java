package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

public class G8ExponentOperation extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8SqrInteger.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> g8ExponentOperation = new ArrayList<Problem>();
		
		for (int i = 0; i < 2; i++)
			g8ExponentOperation.add(getProblem1(mathConfig));
		
		for (int i = 0; i < 3; i++)
			g8ExponentOperation.add(getProblem2(mathConfig));
		
		for (int i = 0; i < 6; i++)
			g8ExponentOperation.add(getProblem3(mathConfig));

		for (int i = 0; i < 6; i++)
			g8ExponentOperation.add(getProblem4(mathConfig));
		
		for (int i = 0; i < 6; i++)
			g8ExponentOperation.add(getProblem5(mathConfig));
		
		for (int i = 0; i < 6; i++)
			g8ExponentOperation.add(getProblem6(mathConfig));
			
		return g8ExponentOperation;
	}

	/*
	 * Converts 2^2 * 2^3 = 2^5
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(2, 10);
		int power1 = MathUtilities.getRandomNumber(0, 3);
		int power2 = MathUtilities.getRandomNumber(0, 3); 
		
		int power = power1 + power2;
		
		question = "$" + base + "^" + "{" +power1+ "}" +  "\\times "  + base + "^" + "{" + power2 + "}" + "$";

		answer.setAnswer("$" + base + "^" + power + "$");
		
	//	answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine("$" + base*2 +"^"+power/2 +"$"));
		answerList.add(new AnswerLine("$" + base +"^"+power*2 +"$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * 8 * 2^3 = 2 ^6
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(2, 10);
		int power1 = MathUtilities.getRandomNumber(0, 3);
		int power2 = MathUtilities.getRandomNumber(0, 3);
		int base1 = (int)Math.pow(base, power1) ;
		
		int power = power1 + power2;
		
		question = "$" + base1 +  " \\times  "  + base + "^" + "{" + power2 + "}" + "$";

		answer.setAnswer("$" + base + "^" + power + "$");
		
	//	answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine("$" + base*2 +"^"+power/2 +"$"));
		answerList.add(new AnswerLine("$" + base +"^"+power*2 +"$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Power of exponents ex:-
	 * (2^2)^3 = 2^6
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(2, 10);
		int power1 = MathUtilities.getRandomNumber(1, 3);
		int power2 = MathUtilities.getRandomNumber(1, 5); 
		
		question = "$\\left(" + base + "^" + "{" +power1+ "}" + "\\right)" + "^" + "{" +power2+ "}" + "$";
		
		int power = power1 * power2;
		String result = "$" + base + "^" + power + "$";
		
		int fakePower1 = power1 + power2;
		if (power1 + power2 == power1 * power2) {
			fakePower1 = power+ 3;
		}
		
		int fakePower2 = power2 - power1;
		if (power2 - power1 == power1 * power2) {
			fakePower2 = power-2;
		}
		
		String fakeResult1 = "$" + base + "^" + fakePower1 + "$";
		String fakeResult2 = "$" + base + "^" + fakePower2 + "$";

		answer.setAnswer(result);
		
	//	answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine(fakeResult1));
		answerList.add(new AnswerLine(fakeResult2));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Power of exponents ex:-
	 * (2^2)^-3 = 1/2^6
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {

		String question = "";
		String result ="";
		Answer answer = new Answer();
		Fraction frac = new Fraction(1, 1);

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(2, 10);
		int power1 = MathUtilities.getRandomNumber(-2, 5);
		int power2 = MathUtilities.getRandomNumber(-5, -1); 
		//answer.setAnswer("$"+ frac.getNumerator()+"\\over" +frac.getDenominator()+ "$");
		question = "$\\left(" + base + "^" + "{" +power1+ "}" + "\\right)" + "^" + "{" +power2+ "}" + "$";
		
		int power = power1 * power2;
		
		if (power > 0)
			result = "$" + base + "^" + power + "$";
		else if (power < 0) {
			power = -power;
			result = "$"+frac.getNumerator()+ "\\over"+ base + "^" + "{" +power+ "}" +"$";
		}
		else
			result = Integer.toString(1);
		
		int fakePower1 = power1 + power2;
		if (power1 + power2 == power1 * power2) {
			fakePower1 = power+ 3;
		}
		
		int fakePower2 = power2 - power1;
		if (power2 - power1 == power1 * power2) {
			fakePower2 = power-2;
		}
		
		String fakeResult1 = "$" + base + "^" + "{" + fakePower1 + "}"+ "$";
		String fakeResult2 = "$" + base + "^" + "{" + fakePower2 + "}"+ "$";

		answer.setAnswer(result);
		
	//	answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine(fakeResult1));
		answerList.add(new AnswerLine(fakeResult2));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * Power of exponents ex:-
	 * (2^2)^3 = 2^6 = 64
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(2, 10);
		int power1 = MathUtilities.getRandomNumber(0, 2);
		int power2 = MathUtilities.getRandomNumber(1, 3); 
		
		question = "$\\left(" + base + "^" + "{" +power1+ "}" + "\\right)" + "^" + "{" +power2+ "}" + "$";
		
		int result = (int) Math.pow( (int)Math.pow(base, power1), power2);
		int fakeResult1 = result +1;
		int fakeResult2 = result -1;

		answer.setAnswer(Integer.toString(result));
		
	//	answer.setType(Constants.RADIO_TYPE);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));

		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(answer.getAnswer()));
		answerList.add(new AnswerLine(Integer.toString(fakeResult1)));
		answerList.add(new AnswerLine(Integer.toString(fakeResult2)));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * 8 * 4^2 = 2 ^6 convert to exponent of base
	 */
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();
		String result = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int base = MathUtilities.getRandomNumber(2, 10);
		int power = MathUtilities.getRandomNumber(0, 3);
		int base1 = MathUtilities.getRandomNumber(2, 10) ;
		
		
		question = "$" + base1 +  " X "  + base + "^" + "{" + power + "}" + "$";
		
		int multiplication = base1 * (int)Math.pow(base, power);
		
		Map<Integer, Integer> factorMap = MathUtilities.getListOfFactors(multiplication);
		String fakeResult1= "";
		String fakeResult2 = "";
		
		for (Map.Entry<Integer, Integer> entry: factorMap.entrySet()) {
			
			int baseAnswer = entry.getKey();
			int basePower = entry.getValue();
			
			int fakeBasePw1 = basePower - 1;
			int fakeBasePw2 = basePower + 1;
			
			if (basePower ==1 ) {
				result = result + "$"+ baseAnswer + "." + "$";
				fakeResult1 = fakeResult1 + "$"+ baseAnswer + "." + "$";
				fakeResult2 = fakeResult2 + "$"+ baseAnswer + "." + "$";
			}
			else {
				result = result + "$"+ baseAnswer +  "^" + "{" + basePower + "}" + "."  + "$";
				fakeResult1 = fakeResult1 + "$"+ baseAnswer +  "^" + "{" + fakeBasePw1 + "}" + "."  + "$";
				fakeResult2 = fakeResult2 + "$"+ baseAnswer +  "^" + "{" + fakeBasePw2 + "}" + "."  + "$";
			}
		}
		
		//remove trailing .
		if (result.endsWith("."))
			result = result.substring(0,  result.length()-1);
		
		answer.setAnswer(result);
		
		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine> answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(result));
		answerList.add(new AnswerLine(fakeResult1));
		answerList.add(new AnswerLine(fakeResult2));
	
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		answer.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}
	
}
