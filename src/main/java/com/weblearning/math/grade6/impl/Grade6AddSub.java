package com.weblearning.math.grade6.impl;

import java.util.LinkedList;
import java.util.List;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class Grade6AddSub extends Question {
	
	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List <Problem>addSubtractFraction = new  LinkedList<Problem>();
		
		for (int i=0; i<5; i++)
			addSubtractFraction.add(getProblem1());
		
		return addSubtractFraction;
	}
	
	/*
	 * Lesson for adding
	 */
	public Problem getProblem1(){
		
		CreateProblem createProbmem = new CreateProblem();;
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		
		int answerToQuestion =0;
		
		//four lines of addition
		int numbersInArray = 3;
		
		//Create an empty array for the numbers
		int numbers[] = MathUtilities.getRandomNumbers(numbersInArray, 1000, 10000);
		
		StringBuilder stb =new StringBuilder();
		stb.append(numbers[0]);
		stb.append(" + ");
		stb.append(numbers[1]);
		stb.append(" - ");
		stb.append(numbers[2]);
		
		questionList.add(new QuestionLine(stb.toString()));
		
		answerToQuestion = rule1(numbers);//numbers[0] + numbers[1]- numbers[2];
		
		String answ = Integer.toString(answerToQuestion);
		String heading = Constants.GRADE_6_CONTENT_ADD_SUB;
		String subHeading = "Sum of numbers with different signs";
		
		Problem problem = createProbmem.constructProblem (questionList, answ, heading, subHeading, Constants.RANK_ONE,   Constants.DEFAULT);
		
		return problem;
	}
	
	/*the result should be number[0]+number[1]-number[2]
	 * 
	 */
	public int rule1(int numbers[]){
		
		return numbers[0] + numbers[1]- numbers[2];
	}
	
}
