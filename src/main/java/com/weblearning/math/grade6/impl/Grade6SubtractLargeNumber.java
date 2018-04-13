package com.weblearning.math.grade6.impl;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class Grade6SubtractLargeNumber extends GenericQuestion {
	
	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List <Problem>subtractLargeNumber = new  LinkedList<Problem>();
		
		for (int i=0; i<20; i++)
			subtractLargeNumber.add(getProblem1());
		
		return subtractLargeNumber;
	}
	
	/*
	 * Lesson for adding
	 */
	public Problem getProblem1(){
		
		CreateProblem cProblem = new CreateProblem();
		
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		//Answer answer = new Answer();
		int answerToQuestion =0;
		
		//four lines of addition
		int numberOfLines = 2;
				
		//Create an empty array for the numbers
		
		int[] numbers= MathUtilities.getRandomNumbers(numberOfLines, 99999, 9999999);
						
		QuestionLine ql = new QuestionLine("", Constants.PROBLEM_TYPE_FRACTION);
		QuestionLine q2 = new QuestionLine("", Constants.PROBLEM_TYPE_FRACTION);
		//Set the numbers in QuestineLine Object
		for (int i=0; i<numberOfLines-1; i++){
			
			if(numbers[i]>numbers[i+1]){
				ql.setQuestionLn(NumberFormat.getNumberInstance(Locale.US).format(numbers[i]));
				q2.setQuestionLn(NumberFormat.getNumberInstance(Locale.US).format(numbers[i+1]));
				answerToQuestion = numbers[i]-numbers[i+1];
			}
			else{
				ql.setQuestionLn(NumberFormat.getNumberInstance(Locale.US).format(numbers[i+1]));
				q2.setQuestionLn(NumberFormat.getNumberInstance(Locale.US).format(numbers[i]));
				answerToQuestion = numbers[i+1]-numbers[i];
			}
		}
		questionList.add(ql);
		questionList.add(q2);
				
		String answ = NumberFormat.getNumberInstance(Locale.US).format(answerToQuestion);
		String heading = Constants.GRADE_6_CONTENT_SUB_LARGE_NUMBER;
		String subHeading = "Subtract smaller from bigger number";
		
		Problem problem = cProblem.constructProblem(questionList, answ, heading, subHeading, Constants.RANK_ONE,  Constants.RIGHT_TO_LEFT);
		
		return problem;

	}
	

}
