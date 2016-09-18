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
		
		CreateProblem cProblem = new CreateProblem();
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
		}
		
		result = rule1Ans(numbers);
		
		QuestionLine ql = new QuestionLine();
		ql.setQuestionLn(numberInString);
		questionList.add(ql);
		
		String answ = NumberFormat.getNumberInstance(Locale.US).format(result);
		String heading = Constants.GRADE_6_CONTENT_ADD_SINGLE_LINE;
		String subHeading = "Sum of numbers";
		
		Problem problem = cProblem.constructProblem(questionList, answ, heading, subHeading, Constants.RANK_ONE,  Constants.DEFAULT);
		
		return problem;
	}
	
	/*
	 * Get the results
	 */
	public int rule1Ans(int numbers[]){
		int result =0;
		
		for (int i=0; i< numbers.length; i++){
			result += numbers[i];
		}
		return result;
		
	}

}
