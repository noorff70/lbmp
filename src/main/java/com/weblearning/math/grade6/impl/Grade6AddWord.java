package com.weblearning.math.grade6.impl;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class Grade6AddWord extends Question {
	
	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List <Problem>addWord = new  LinkedList<Problem>();
		
		for (int i=0; i<5; i++)
			addWord.add(getProblem1());
		
		return addWord;
	}
	
	/*
	 * Lesson for adding
	 */
	public Problem getProblem1(){
		
		CreateProblem cProblem = new CreateProblem();
		
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
		
		String answ = NumberFormat.getNumberInstance(Locale.US).format(result);
		String heading = Constants.GRADE_6_CONTENT_ADD_WORD;
		String subHeading = "Word problem- Convert to numeric and then sum up";
		
		Problem problem = cProblem.constructProblem(questionList, answ, heading, subHeading, Constants.RANK_ONE,  Constants.DEFAULT);
		
		return problem;
	}
	
	
}
