package com.weblearning.math.grade5.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;

public class Grade5AddSubtractWholeNumber extends GenericQuestion{
	

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		@SuppressWarnings("rawtypes")
		List addSubtractWholeNumber = new ArrayList();
		
		addSubtractWholeNumber.add(getProblem1());
		addSubtractWholeNumber.add(getProblem2());
		addSubtractWholeNumber.add(getProblem3());
		addSubtractWholeNumber.add(getProblem4());
		addSubtractWholeNumber.add(getProblem5());
		addSubtractWholeNumber.add(getProblem6());
		
		return addSubtractWholeNumber;
	}
	
	/*
	 * Lesson for adding
	 */
	public Problem getProblem1(){
		
		//Lesson lesson = new Lesson();
		Problem problem = new Problem();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();
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
		
		problem.setQuestionHeading("Add large numbers");
		problem.setQuestionLines(questionList);
		answer.setAnswer(NumberFormat.getNumberInstance(Locale.US).format(answerToQuestion));
		answer.setType(Constants.RIGHT_TO_LEFT);
		problem.setAnswer(answer);
		
				
		return problem;
	}
	
	/*
	 * Lesson for Subtracting smaller number from bigger number
	 */
	public Problem getProblem2(){
		
		Problem problem = new Problem();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();
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
				
		problem.setQuestionHeading("Subtract large numbers");
		problem.setQuestionLines(questionList);
		answer.setAnswer(NumberFormat.getNumberInstance(Locale.US).format(answerToQuestion));
		answer.setType(Constants.RIGHT_TO_LEFT);
		problem.setAnswer(answer);
		
		return problem;
	}
	
	/*
	 * Lesson for Subtracting bigger number from smaller number
	 */
	public Problem getProblem3(){
		
		Problem problem = new Problem();
		Answer answer = new Answer();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
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
				//smaller number at top
				q2.setQuestionLn(NumberFormat.getNumberInstance(Locale.US).format(numbers[i+1]));
				ql.setQuestionLn(NumberFormat.getNumberInstance(Locale.US).format(numbers[i]));
				answerToQuestion = numbers[i+1]-numbers[i];
			}
			else{
				q2.setQuestionLn(NumberFormat.getNumberInstance(Locale.US).format(numbers[i]));
				ql.setQuestionLn(NumberFormat.getNumberInstance(Locale.US).format(numbers[i+1]));
				answerToQuestion = numbers[i]-numbers[i+1];
			}
		}
		questionList.add(q2);
		questionList.add(ql);
				
		problem.setQuestionHeading("Subtract large number when the result is a negative");
		problem.setQuestionLines(questionList);
		answer.setAnswer(NumberFormat.getNumberInstance(Locale.US).format(answerToQuestion));
		answer.setType(Constants.RIGHT_TO_LEFT);
		problem.setAnswer(answer);
		
		return problem;
	}
	
	/*
	 * Lesson for Adding Word Problems
	 */
	
	public Problem getProblem4(){
		
		Problem problem = new Problem();
		Answer answer = new Answer();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		int result = 0;
		
		//Three lines of addition
		int numberOfLines = MathUtilities.getRandomNumber(2,3);
			
		//There should be atleast two lines
			if (numberOfLines <2)
				numberOfLines = 2;
				
		//Create the numbers in an array							
		int numbers[] = MathUtilities.getRandomNumbers(numberOfLines, 99999, 9999999);
		
		//Get the answer
		for (int i=0; i< numbers.length; i++)
			result = numbers[i] + result;
		
		//Convert the numbers to Words
		String numbersInWordFormat = MathUtilities.getNumberConvertedToWord(numbers);
		
		QuestionLine ql = new QuestionLine();
		ql.setQuestionLn(numbersInWordFormat);
		questionList.add(ql);
		
		problem.setQuestionHeading("Add large numbers in word format");
		problem.setQuestionLines(questionList);
		
		answer.setAnswer(NumberFormat.getNumberInstance(Locale.US).format(result));
		answer.setType(Constants.DEFAULT);
		
		problem.setAnswer(answer);
		
		return problem;
	}
	
	public Problem getProblem5(){
		
		Problem problem = new Problem();
		Answer answer = new Answer();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		int result = 0;
		String numberInString = "";
		
		int numberOfLines = MathUtilities.getRandomNumber(2,3);
		
		//Create the numbers in an array							
		int numbers[] = MathUtilities.getRandomNumbers(numberOfLines, 99999, 9999999);
		
		for (int i=0; i<numbers.length; i++){
			if (i==0)
				numberInString = NumberFormat.getNumberInstance(Locale.US).format(numbers[i]) ;
			else
				numberInString += " + " + NumberFormat.getNumberInstance(Locale.US).format(numbers[i]) ;
			result += numbers[i];
		}
		
		QuestionLine ql = new QuestionLine();
		ql.setQuestionLn(numberInString);
		questionList.add(ql);
		
		problem.setQuestionHeading("Add all positive numbers in one statement");
		problem.setQuestionLines(questionList);
		
		answer.setAnswer(NumberFormat.getNumberInstance(Locale.US).format(result));
		answer.setType(Constants.DEFAULT);
		
		problem.setAnswer(answer);
		
		return problem;
	
	}
	
	public Problem getProblem6(){
		
		Problem problem = new Problem();
		Answer answer = new Answer();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		int result = 0;
		String numberInString = "";
		
		int numberOfLines = MathUtilities.getRandomNumber(2,3);
		
		//Create the numbers in an array							
		int numbers[] = MathUtilities.getRandomNumbers(numberOfLines, -9999999, -1);
		
		for (int i=0; i<numbers.length; i++){
			
			numberInString +=  NumberFormat.getNumberInstance(Locale.US).format(numbers[i]) +" " ;
			result += numbers[i];
		}
		
		QuestionLine ql = new QuestionLine();
		ql.setQuestionLn(numberInString);
		questionList.add(ql);
		
		problem.setQuestionHeading("Add In One Line- All Negative Values");
		problem.setQuestionLines(questionList);
		
		answer.setAnswer(NumberFormat.getNumberInstance(Locale.US).format(result));
		answer.setType(Constants.RIGHT_TO_LEFT);
		
		problem.setAnswer(answer);
		
		return problem;
	
	}


}
