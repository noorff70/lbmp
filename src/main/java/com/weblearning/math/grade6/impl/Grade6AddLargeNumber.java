package com.weblearning.math.grade6.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;

public class Grade6AddLargeNumber extends Question {
	
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
		
		//Lesson lesson = new Lesson();
		//Problem problem = new Problem();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		//Answer answer = new Answer();
		int answerToQuestion =0;
		
		//four lines of addition
		int numberOfLines = MathUtilities.getRandomNumber(2, 4);
		
		//There should be atleast two lines
			if (numberOfLines <2)
				numberOfLines = 2;
		
		//Create an empty array for the numbers
					
		int numbers[] = MathUtilities.getRandomNumbers(numberOfLines, 99999, 9999999);
						
		//Set the numbers in QuestineLine Object
		for (int i=0; i<numberOfLines; i++){
			QuestionLine ql = new QuestionLine();
			ql.setQuestionLn(NumberFormat.getNumberInstance(Locale.US).format(numbers[i]));
			questionList.add(ql);
		}
		
		//Get the answer
		for (int i=0; i<numberOfLines; i++)
			answerToQuestion += numbers[i];
		
		String answ = NumberFormat.getNumberInstance(Locale.US).format(answerToQuestion);
		String heading = "Add large numbers";
		String subHeading = "What is the sum";
		
		Problem problem = constructProblem(questionList, answ, heading, subHeading,   Constants.RIGHT_TO_LEFT);
		
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

}
