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

public class Grade6AddSingleLine extends Question {
	
	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List <Problem>addSingleLine= new  LinkedList<Problem>();
		
		for (int i=0; i<5; i++)
			addSingleLine.add(getProblem1());
		
		return addSingleLine;
	}
	
	/*
	 * Lesson for adding
	 */
	public Problem getProblem1(){
		
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
		
		String answ = NumberFormat.getNumberInstance(Locale.US).format(result);
		String heading = "Add Single Line Numbers";
		String subHeading = "What is the sum";
		
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

}
