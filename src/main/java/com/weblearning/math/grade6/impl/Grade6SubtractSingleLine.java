package com.weblearning.math.grade6.impl;

import java.text.NumberFormat;
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
import com.weblearning.utilities.CreateProblem;

public class Grade6SubtractSingleLine extends GenericQuestion {
	
	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List <Problem>subtractSingleLine = new  LinkedList<Problem>();
		
		for (int i=0; i<20; i++)
			subtractSingleLine.add(getProblem1());
		
		return subtractSingleLine;
	}
	
	/*
	 * Lesson for adding
	 */
	public Problem getProblem1(){
		
		CreateProblem cProblem = new CreateProblem();
		
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		int result = 0;
		String numberInString = "";
		Answer answ = new Answer();
		
		int numberOfLines = MathUtilities.getRandomNumber(2,3);
		
		//Create the numbers in an array							
		int numbers[] = MathUtilities.getRandomNumbers(numberOfLines, -9999, -1);
		
		for (int i=0; i<numbers.length; i++){
			
			numberInString +=  NumberFormat.getNumberInstance(Locale.US).format(numbers[i]) +" " ;
			result += numbers[i];
		}
		
		questionList.add(new QuestionLine(numberInString, null, null));
		
	//	String answ = NumberFormat.getNumberInstance(Locale.US).format(result);
		String heading = Constants.GRADE_6_CONTENT_SUB_SINGLE_LINE;
		answ.setAnswer(NumberFormat.getNumberInstance(Locale.US).format(result));
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE,  Constants.RIGHT_TO_LEFT);
		problem.setAnswer(answ);
		
		return problem;

	}

}
