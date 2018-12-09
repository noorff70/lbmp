package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade.UniqueObjectMap;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ExponentBase extends GenericQuestion {
	
	Map<Integer, UniqueObjectMap> objectMaps = new ConcurrentHashMap<Integer, UniqueObjectMap>();

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentEvaluation = new ArrayList<Problem>();
		
		for (int i = 0; i <2; i++)
			g7ExponentEvaluation.add(getProblem1(mathConfig, i));
		for (int i = 0; i <4; i++)
			g7ExponentEvaluation.add(getProblem2(mathConfig, i));
		for (int i = 0; i <4; i++)
			g7ExponentEvaluation.add(getProblem3(mathConfig, i));
		for (int i = 0; i <3; i++)
			g7ExponentEvaluation.add(getProblem4(mathConfig, i));
		for (int i = 0; i <4; i++)
			g7ExponentEvaluation.add(getProblem5(mathConfig, i));
		
		

		return g7ExponentEvaluation;
	}

	/*
	 * Exponentiation
	 */

	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		
		//find the base
		int q1Base = MathUtilities.getRandomNumber(2, 8);
		int q1Pow = MathUtilities.getRandomNumber(2, 4);
		int ans1 = (int) Math.pow((double)q1Base, (double)q1Pow);
		question1 = "$"+ q1Base + "^{" + q1Pow + "}" + " = " + Integer.toString(ans1) + "$";
		answer1 = Integer.toString(q1Base); 
		
		//find the power
		int q2Base = MathUtilities.getRandomNumber(2, 8);
		int q2Pow = MathUtilities.getRandomNumber(2, 4);
		int ans2 = (int) Math.pow((double)q2Base, (double)q2Pow);
		question2 = "$"+ q2Base + "^{" + q2Pow + "}" + " = " + Integer.toString(ans2) + "$";
		answer2 = Integer.toString(q2Pow);
		
		//find the base
		int q3Base = MathUtilities.getRandomNumber(-8, -2);
		int q3Pow = MathUtilities.getRandomNumber(2, 4);
		int ans3 = (int) Math.pow((double)q3Base, (double)q3Pow);
		question3 = "$("+ q3Base + ")^{" + q3Pow + "}" + " = " + Integer.toString(ans3) + "$";
		answer3 = Integer.toString(q3Base);
		
		//find the result
		int q4Base = MathUtilities.getRandomNumber(-8, -2);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
		int ans4 = (int) Math.pow((double)q4Base, (double)q4Pow);
		question4 = "$("+ q4Base + ")^{" + q4Pow + "}" + " = " + Integer.toString(ans4) + "$";
		answer4 = Integer.toString(ans4);
		
		//find the power
		int q5Base = MathUtilities.getRandomNumber(8, 2);
		int q5Pow = MathUtilities.getRandomNumber(-4, -2);
		int ans5 = (int) Math.pow((double)q5Base, (double)Math.abs(q5Pow));
		question5 = "$("+ "\\frac{" + Integer.toString(1) + "}{" + Integer.toString((int)q5Base) + "})" + "^{" + Math.abs(q5Pow) + "} = " 
				+ "\\frac{" + Integer.toString(1) + "}{" + Integer.toString((int)ans5) + "}$";
		answer5 = Integer.toString(Math.abs(q5Pow));
		
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 + ". " +mSource.getMessage(GR7_Constants.WRITE_THE_BASE, null, Locale.ENGLISH)+
				Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + ". " +mSource.getMessage(GR7_Constants.WRITE_THE_POWER, null, Locale.ENGLISH)+
				Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + ". " +mSource.getMessage(GR7_Constants.WRITE_THE_BASE, null, Locale.ENGLISH)+
				Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + ". " +mSource.getMessage(GR7_Constants.WRITE_THE_RESULT, null, Locale.ENGLISH)+
				Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + ". " +mSource.getMessage(GR7_Constants.WRITE_THE_POWER, null, Locale.ENGLISH)+
				Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	// 2 * 2 * 2 can be written as 2^3
	public Problem getProblem2(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		String fAnswer1 = "";
		String fAnswer2 = "";
		String fAnswer3 = "";
		String fAnswer4 = "";
		
		//find the result
		int q4Base = MathUtilities.getRandomNumber(2, 8);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
		
		question4 = "$" + q4Base + "^{" + q4Pow + "} = " + Math.pow((double)q4Base, (double)q4Pow) + "$";
		
		answer4 = removeLastSign(Integer.toString(q4Base), q4Pow);
		fAnswer1 = removeLastSign(Integer.toString(q4Base), q4Pow+1);
		fAnswer2 = removeLastSign(Integer.toString(q4Pow), q4Pow+1);
		fAnswer3 = removeLastSign(Integer.toString(q4Base-1), q4Pow);
		fAnswer4 = removeLastSign(Integer.toString(q4Base), q4Pow-1);
		
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(answer4));
		answerList.add(new AnswerLine(fAnswer1));
		answerList.add(new AnswerLine(fAnswer2));
		answerList.add(new AnswerLine(fAnswer3));
		answerList.add(new AnswerLine(fAnswer4));
			
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer4);
		answ.setAnswerOption(correctAnswerOption);
		answ.setAnswerList(answerList);
				
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FOLLOWING_EXPONENT_REPRESENTS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(GR7_Constants.BASICS_OF_EXPONENTS, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answ);

		return problem;
	}
	
	// 2 * 2 * 2 can be written as 2^3
	public Problem getProblem3(MathConfiguration mathConfig, int i) {
			
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		String fAnswer1 = "";
		String fAnswer2 = "";
		String fAnswer3 = "";
		String fAnswer4 = "";
			
		//find the result
		int q4Base = MathUtilities.getRandomNumber(2, 8);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
		
		question4 = removeLastSign(Integer.toString(q4Base), q4Pow);
			
		//question4 = "$" + q4Base + "^{" + q4Pow + "} = " + Math.pow((double)q4Base, (double)q4Pow) + "$";
			
		answer4 = "$" + q4Base + "^{" + q4Pow + "}" + "$";
		fAnswer1 = "$" + q4Base + "^{" + Integer.toString(q4Pow-1) + "}" + "$";
		fAnswer2 = "$" + q4Base + "^{" + Integer.toString(q4Pow+1) + "}" + "$";
		fAnswer3 = "$" + q4Pow + "^{" + Integer.toString(q4Base) + "}" + "$";
		fAnswer4 = "$" + q4Pow + "^{" + Integer.toString(q4Base) + "}" + "$";
			
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(answer4));
		answerList.add(new AnswerLine(fAnswer1));
		answerList.add(new AnswerLine(fAnswer2));
		answerList.add(new AnswerLine(fAnswer3));
		answerList.add(new AnswerLine(fAnswer4));
				
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
			
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer4);
		answ.setAnswerOption(correctAnswerOption);
		answ.setAnswerList(answerList);
					
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FOLLOWING_EXPONENT_REPRESENTS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(GR7_Constants.BASICS_OF_EXPONENTS, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answ);

		return problem;
	}
	
	// 1/2 * 1/2 * 1/2 can be written as (1/2)^3
	public Problem getProblem4(MathConfiguration mathConfig, int i) {
			
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4 = "";
		String fAnswer1 = "";
		String fAnswer2 = "";
		String fAnswer3 = "";
			
		//find the result
		int q4Base = MathUtilities.getRandomNumber(2, 8);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
			
		question4 = "$("+ "\\frac{" + Integer.toString(1) + "}{" + Integer.toString(q4Base) + "})" + "^{" + Math.abs(q4Pow) + "}$" ;
		
		String q4baseQ ="\\frac{1}{" + Integer.toString(q4Base) + "}";
		
		answer4 = removeLastSign(q4baseQ, q4Pow);
		fAnswer1 = removeLastSign(q4baseQ, q4Pow+1);
		fAnswer2 = removeLastSign(q4baseQ, q4Pow-1);
		fAnswer3 = removeLastSign(q4baseQ, 1);
			
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(answer4));
		answerList.add(new AnswerLine(fAnswer1));
		answerList.add(new AnswerLine(fAnswer2));
		answerList.add(new AnswerLine(fAnswer3));

			
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
			
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer4);
		answ.setAnswerOption(correctAnswerOption);
		answ.setAnswerList(answerList);
					
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FOLLOWING_EXPONENT_REPRESENTS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(GR7_Constants.BASICS_OF_EXPONENTS, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answ);

		return problem;
	}
	
	// -2 * -2 * -2 can be written as 2^3
	public Problem getProblem5(MathConfiguration mathConfig, int i) {
				
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
				

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		String fAnswer1 = "";
		String fAnswer2 = "";
		String fAnswer3 = "";
		String fAnswer4 = "";
				
		//find the result
		int q4Base = MathUtilities.getRandomNumber(-8, -2);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
			
		question4 = removeLastSign("(" + Integer.toString(q4Base) + ")", q4Pow);
				
		//question4 = "$" + q4Base + "^{" + q4Pow + "} = " + Math.pow((double)q4Base, (double)q4Pow) + "$";
				
		answer4 = "$(" + q4Base + ")^{" + q4Pow + "}" + "$";
		fAnswer1 = "$" + q4Base + "^{" + q4Pow + "}" + "$";
		fAnswer2 = "$" + q4Base + "^{" + Integer.toString(q4Pow+1) + "}" + "$";
		fAnswer3 = "$" + q4Pow + "^{" + Integer.toString(q4Base) + "}" + "$";
		fAnswer4 = "$" + q4Pow + "^{" + Integer.toString(q4Base) + "}" + "$";
				
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(answer4));
		answerList.add(new AnswerLine(fAnswer1));
		answerList.add(new AnswerLine(fAnswer2));
		answerList.add(new AnswerLine(fAnswer3));
		answerList.add(new AnswerLine(fAnswer4));
					
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
				
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, answer4);
		answ.setAnswerOption(correctAnswerOption);
		answ.setAnswerList(answerList);
						
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FOLLOWING_EXPONENT_REPRESENTS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(GR7_Constants.BASICS_OF_EXPONENTS, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answ);

		return problem;
	}
	
	private String removeLastSign(String str, int pow) {
		
		String output = "";
		for (int i=0; i< pow; i++) {
			if (pow-i == 1) {
				output = output + str;
			}else {
				output = output + str + "\\times " ;
			}
			
		}
		
	    return "$" + output + "$";
	}
	
}
