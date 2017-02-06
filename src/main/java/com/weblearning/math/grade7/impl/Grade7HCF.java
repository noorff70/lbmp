package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.weblearning.controller.UserLoginController;
import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;

public class Grade7HCF extends GenericQuestion{
	
	private static final Logger logger = Logger.getLogger(UserLoginController.class);

	@Override
	//Generate the questions
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		logger.info("Entering from Grade6HCF");
		
		List <Problem>hcfs = new  LinkedList<Problem>();
		
		for (int i=0; i<5; i++)
			hcfs.add(getProblem1());
		
		for (int i=0; i<5; i++)
			hcfs.add(getProblem2());
		
		for (int i=0; i<10; i++){
			hcfs.add(getProblem3());
		}
		
		logger.info("Returning from Grade6HCF");
		return hcfs;
	}
	
	/*
	 * Take a number from 2 to 9
	 */
	public Problem getProblem1(){
		Problem problem = getProblem(2,20, false, 0,0,0);
		return problem;
	}
	
	/*
	 * take a number from 11 to 19
	 */
	public Problem getProblem2(){
		Problem problem = getProblem(10,40, false, 0,0,0);
		return problem;
	}
	
	/*take a number from 3 to 9, increment the number by a random number and then multiply that
	 * with another random number. Do it untill the numberofitems.
	 * 
	 */
	public Problem getProblem3(){
		int incrementBy = MathUtilities.getRandomNumber(3, 5);
		int multipliedBy = MathUtilities.getRandomNumber(2, 6);
		int numberOfItems = MathUtilities.getRandomNumber(2, 3);
		
		Problem problem = getProblem(2,9,true, incrementBy, multipliedBy, numberOfItems);
		return problem;
	}
	
	/*
	 * Build the logic of the problem
	 */
	@SuppressWarnings("unchecked")
	public Problem getProblem(int min, int max, boolean autoIncrement, int incrementBy, int multipliedBy, int numberOfItems){
		
		String answ =null;
		
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
						
		//Generate two random numbers
		int hcfNumber1 = MathUtilities.getRandomNumber(min, max);
		int hcfNumber2 = hcfNumber1* MathUtilities.getRandomNumber(2, 5);
		
		//Add the numbers to list
		List<Integer> numberList = new ArrayList<Integer>();
		List<Integer> primeList = new ArrayList<Integer>();
		
		if (!autoIncrement){
			numberList.add(hcfNumber1);
			numberList.add(hcfNumber2);
		}
		else{
			for (int i=0; i<numberOfItems; i++){
				int numberToBeAdded = hcfNumber1*  multipliedBy;
				hcfNumber1+= incrementBy;
				numberList.add(numberToBeAdded);
			}
		}
		
		Collections.sort(numberList);
		//this will give a list of prime factors for the number in numberList 
		primeList = MathUtilities.getHCF(numberList, primeList);
				
		//Add the questions		
		questionList.add(new QuestionLine("Find the HCF of the following"));
		String questionLn2 = formattedString(numberList, Constants.STRING_CONCAT);
		questionList.add(new QuestionLine(questionLn2));
		
		//numberList returned contains the prime factors which now need to be multiplied
		if (primeList.size()==0)
			answ = Integer.toString(1);
		else 	
			answ = formattedString(primeList, Constants.STRING_MULTIPLY);
				
		String heading = "Find HCF";
		String subHeading = "Find HCF of two integers";
				
				
		Problem problem = constructProblem(questionList, answ, heading, subHeading,   Constants.DEFAULT);
				
		return problem;
	}
	
	
	public Problem constructProblem(List<QuestionLine> questionList, String answ, String questionHeading,  String subHeading, String type  ){
		
		Problem problem = new Problem();
		
		Answer answer = new Answer();
		answer.setAnswer(answ);
		answer.setType(type);
		
		problem.setQuestionLines(questionList);
		problem.setQuestionHeading(questionHeading);
		problem.setQuestionSubHeading(subHeading);
		problem.setAnswer(answer);
		
		return problem;
	}
	
	
	public String formattedString(List<Integer> numberList, String operation){
		
		StringBuilder sb = new StringBuilder();
		int multiply=1;
		
		if (operation.equals(Constants.STRING_CONCAT)){
			for (int i=0; i<numberList.size(); i++){
				int j = (int)numberList.get(i);
				sb = sb.append(Integer.toString(j));
				sb.append("  ");
			}
		}
		else if (operation.equals(Constants.STRING_MULTIPLY)){
			for (int i=0; i<numberList.size(); i++){
				multiply = multiply*(int)numberList.get(i);
			}
			sb = sb.append(Integer.toString(multiply));
		}
		
		return sb.toString();
		
	}

	

}

