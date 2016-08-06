package com.weblearning.math.grade6.impl;

import java.text.NumberFormat;
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

public class Grade6SubtractLargeNumber extends Question {
	
	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List <Problem>subtractLargeNumber = new  LinkedList<Problem>();
		
		for (int i=0; i<5; i++)
			subtractLargeNumber.add(getProblem1());
		
		return subtractLargeNumber;
	}
	
	/*
	 * Lesson for adding
	 */
	public Problem getProblem1(){
		
		//Problem problem = new Problem();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		//Answer answer = new Answer();
		int answerToQuestion =0;
		
		//four lines of addition
		int numberOfLines = 2;
				
		//Create an empty array for the numbers
		
		int[] numbers= MathUtilities.getRandomNumbers(numberOfLines, 99999, 9999999);
						
		QuestionLine ql = new QuestionLine();
		QuestionLine q2 = new QuestionLine();
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
		String heading = "Subtract large numbers";
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
