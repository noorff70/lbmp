package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class Grade7LCM extends GenericQuestion{

	@Override
	//Generate the questions
	public List<?> getQuestions(MathConfiguration mathConfig) {
		List <Problem>lcms = new  LinkedList<Problem>();
		
		lcms.add(getProblem1());
		lcms.add(getProblem2());
		lcms.add(getProblem3());
		lcms.add(getProblem4());
		lcms.add(getProblem5());
		return lcms;
	}
	
	/*
	 * Take a number from 2 to 9 and not a prime number
	 */
	public Problem getProblem1(){
		Problem problem = getProblem(2,9, false,1);
		return problem;
	}
	
	/*
	 * take a number from 11 to 19 and not a prime number
	 */
	public Problem getProblem2(){
		Problem problem = getProblem(2,19, false,1);
		return problem;
	}
	
	/*
	 * take a number from 11 to 19 and a prime number
	 */
	public Problem getProblem3(){
		Problem problem = getProblem(2,19, true,1);
		return problem;
	}
	
	/*
	 * take a number from 11 to 19 and not a prime number
	 */
	public Problem getProblem4(){
		Problem problem = getProblem(2,19, false,2);
		return problem;
	}
	
	/*
	 * take a number from 11 to 19 and not a prime number
	 */
	public Problem getProblem5(){
		Problem problem = getProblem(2,19, false,4);
		return problem;
	}
	
	/*take a number from 3 to 9, increment the number by a random number and then multiply that
	 * with another random number. Do it untill the numberofitems.
	 * 
	 */
	public Problem getProblem9(){
		
		int numberOfItems = MathUtilities.getRandomNumber(3, 4);
		
		Problem problem = getProblem(2,9,true, numberOfItems);
		return problem;
	}
	
	/*
	 * Build the logic of the problem
	 */
	public Problem getProblem(int min, int max, boolean primeNumber, int numberOfItems){
		
		CreateProblem cProblem = new CreateProblem();
		
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		
		List<?> primeNumberList = MathUtilities.getPrimeNumberList(2, 100);
				
		int lcmNumber1=0;
		int lcmNumber2=0;
		int lcmNumber3=0;
		int lcmNumber4 =4;
		
		//Generate two random numbers
		if (!primeNumber && numberOfItems ==1 ){
			lcmNumber1 = MathUtilities.getRandomNumber(min, max);
			//increment the number by a random number
			lcmNumber2 = lcmNumber1* MathUtilities.getRandomNumber(2, 5);
		}
		else if (primeNumber && numberOfItems ==1){
			
			lcmNumber1 = (int) primeNumberList.get(MathUtilities.getRandomNumber(2, 10));
			lcmNumber2 = lcmNumber1* MathUtilities.getRandomNumber(2, 5);
		}
		else if (!primeNumber && numberOfItems ==2){
			
			lcmNumber1 = (int) primeNumberList.get(MathUtilities.getRandomNumber(min, max));
			lcmNumber2 = (int) primeNumberList.get(MathUtilities.getRandomNumber(min, max * MathUtilities.getRandomNumber(2, 5)));
		}
		else if (!primeNumber && numberOfItems ==4){
			lcmNumber1 = (int) primeNumberList.get(MathUtilities.getRandomNumber(min, max));
			lcmNumber2 = lcmNumber1* MathUtilities.getRandomNumber(2, 5);
			lcmNumber3 = (int) primeNumberList.get(MathUtilities.getRandomNumber(min, max));
			lcmNumber4 = lcmNumber1* MathUtilities.getRandomNumber(2, 5);
		}
		
		//Add the numbers to list
		List<Integer> numberList = new ArrayList<Integer>();
		List<Integer> lcmList = new ArrayList<Integer>();
		
		
		numberList.add(lcmNumber1);
		numberList.add(lcmNumber2);
		if (lcmNumber3 !=0) numberList.add(lcmNumber3);
		if (lcmNumber4 !=0) numberList.add(lcmNumber4);
		
		
		Collections.sort(numberList);
		lcmList = MathUtilities.getLCM(numberList, lcmList);
				
		//Add the questions		
		questionList.add(new QuestionLine("Find the LCM of the following"));
		String questionLn2 = formattedString(numberList, Constants.STRING_CONCAT);
		questionList.add(new QuestionLine(questionLn2));
				
		String answ = formattedString(lcmList, Constants.STRING_MULTIPLY);
		Answer answer = new Answer();
		answer.setAnswer(answ);
				
		String heading = "Find LCM";
				
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION) ;
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

