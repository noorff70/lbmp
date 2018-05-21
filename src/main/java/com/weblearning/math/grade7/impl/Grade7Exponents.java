package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class Grade7Exponents extends GenericQuestion{

	@Override
	//Generate the questions
	public List<?> getQuestions(MathConfiguration mathConfig) {
		List <Problem>exponents = new  LinkedList<Problem>();
		
		for (int i=0; i< 8; i++){
			exponents.add(getProblem1());
			exponents.add(getProblem2());
			exponents.add(getProblem3());
		}
		exponents.add(getProblem1());
		
		return exponents;
	}
	
	/*
	 * Exponents of integers/whole numbers
	 */
	public Problem getProblem1(){
		Problem problem = getProblem(Constants.EXPONENTS_WHOLE_NUMBER);
		return problem;
	}
	
	/*
	 * Exponents of integers/whole numbers
	 */
	public Problem getProblem2(){
		Problem problem = getProblem(Constants.EXPONENTS_DECIMALS);
		return problem;
	}
	
	public Problem getProblem3(){
		Problem problem = getProblem(Constants.EXPONENTS_FRACTION);
		return problem;
	}
	
	
	/*
	 * Build the logic of the problem
	 */
	public Problem getProblem(String exponentType){
		
		CreateProblem cProblem = new CreateProblem();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		String result =null;
		
		int numerator =0;
		int denominator=0;
		int exponentialNumber = 0;
		
		numerator = MathUtilities.getRandomNumber(2, 15);
		
		if (Constants.EXPONENTS_WHOLE_NUMBER.equals(exponentType)){
			
			exponentialNumber = MathUtilities.getRandomNumber(2, 5);
			result = MathUtilities.getExponential(Integer.toString(numerator), null, exponentialNumber, Constants.EXPONENTS_WHOLE_NUMBER);
			//Add the questions
			questionList.add(new QuestionLine("What is  " + numerator+"^"+exponentialNumber));
		}
		else if(Constants.EXPONENTS_DECIMALS.equals(exponentType)){
			
			//denominator is any number morethan one to 10 from the numerator
			exponentialNumber = MathUtilities.getRandomNumber(2, 3);
			denominator = MathUtilities.getRandomNumber(numerator+1, numerator+MathUtilities.getRandomNumber(2, 10));

			BigDecimal bg1 = new BigDecimal(numerator);
			BigDecimal bg2 = new BigDecimal (denominator);
			BigDecimal roundOff = bg1.divide(bg2, 2, BigDecimal.ROUND_DOWN);
			result = roundOff.toString();
					
			result = MathUtilities.getExponential(roundOff.toString(),null, exponentialNumber, Constants.EXPONENTS_DECIMALS);
			
			//Add the questions
			questionList.add(new QuestionLine("What is  " + roundOff+"^"+exponentialNumber));
			
		}
		else if (Constants.EXPONENTS_FRACTION.equals(exponentType)){
			
			exponentialNumber = MathUtilities.getRandomNumber(2, 3);
			denominator = MathUtilities.getRandomNumber(numerator+1, numerator+MathUtilities.getRandomNumber(2, 10));
			
			//Fraction f1 = new Fraction(numerator, denominator);
			
			result = MathUtilities.getExponential(Integer.toString(numerator), Integer.toString(denominator), exponentialNumber, Constants.EXPONENTS_FRACTION);
			
			String question = "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
			questionList.add(new QuestionLine("What is  " + question+"^"+exponentialNumber));
			
		}
		
		String answ = result;
				
		String heading = "Find Exponentials";
		String subHeading = "Find Exponentials";
				
		Problem problem = cProblem.constructProblem(questionList, answ, heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);		

				
		return problem;
	}
	
	
	/*
	 * Formats String
	 */
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

