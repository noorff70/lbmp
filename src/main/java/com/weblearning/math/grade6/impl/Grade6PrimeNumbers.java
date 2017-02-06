package com.weblearning.math.grade6.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;

public class Grade6PrimeNumbers extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		List <Problem>primeNumbers = new  LinkedList<Problem>();
		
		primeNumbers.add(getProblem1());
		primeNumbers.add(getProblem2());
		primeNumbers.add(getProblem3());
		
		return primeNumbers;
	}
	
	/*
	 * Prime numbers in a range
	 */
	public Problem getProblem1(){
	
		Problem problem = new Problem();
		Answer answer = new Answer();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		//Fraction result = new Fraction(0,1);;
		String question= "How many prime numbers between 1 and 10 inclusive";
		QuestionLine qLine = new QuestionLine();
		
		List primeNumberList = MathUtilities.getPrimeNumberList(1, 10);
				
		qLine.setQuestionLn(question);
		questionList.add(qLine);
		problem.setQuestionHeading("Numbers of Prime in Tenths");
		problem.setQuestionLines(questionList);
		
		answer.setAnswer(Integer.toString(primeNumberList.size()));
		answer.setType(Constants.DEFAULT);
		
		problem.setAnswer(answer);
				
		return problem;
	}
	
	/* Concepts of prime number
	 * 
	 */
	public Problem getProblem2(){
		
		Problem problem = new Problem();
		Answer answer = new Answer();
		
		List<QuestionLine> questionList = new ArrayList<QuestionLine>();

		questionList.add(new QuestionLine("Prime number can be only divided by the number itself"));
		questionList.add(new QuestionLine("True"));
		questionList.add(new QuestionLine("False"));

		
		answer.setType(Constants.RADIO_TYPE);
		
		//problem.setQuestionLines(newQuestionList);
		answer.setAnswer("False");
		problem.setQuestionLines(questionList);
		problem.setAnswer(answer);
		
		return problem;
		
	}
	
	public Problem getProblem3(){
		
		Problem problem = new Problem();
		Answer answer = new Answer();
		
		List<QuestionLine> questionList = new ArrayList<QuestionLine>();
		List primeNumberList = MathUtilities.getPrimeNumberList(20, 100);
		
		//
		int randomPosition = MathUtilities.getRandomNumber(0, primeNumberList.size()-2);
		int nextPrime = (int) primeNumberList.get(randomPosition+1);
		
		questionList.add(new QuestionLine("What is the next prime number of "+ primeNumberList.get(randomPosition)));
		
		problem.setQuestionLines(questionList);
		
		answer.setType(Constants.DEFAULT);
		answer.setAnswer(Integer.toString(nextPrime));
		
		problem.setAnswer(answer);
		
		return problem;
	}

	

}

