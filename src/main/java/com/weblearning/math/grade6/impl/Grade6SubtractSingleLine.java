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

public class Grade6SubtractSingleLine extends Question {
	
	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List <Problem>subtractSingleLine = new  LinkedList<Problem>();
		
		for (int i=0; i<5; i++)
			subtractSingleLine.add(getProblem1());
		
		return subtractSingleLine;
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
		int numbers[] = MathUtilities.getRandomNumbers(numberOfLines, -9999999, -1);
		
		for (int i=0; i<numbers.length; i++){
			
			numberInString +=  NumberFormat.getNumberInstance(Locale.US).format(numbers[i]) +" " ;
			result += numbers[i];
		}
		
		QuestionLine ql = new QuestionLine();
		ql.setQuestionLn(numberInString);
		questionList.add(ql);
		
		String answ = NumberFormat.getNumberInstance(Locale.US).format(result);
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
