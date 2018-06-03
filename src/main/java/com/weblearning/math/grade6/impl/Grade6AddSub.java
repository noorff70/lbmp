package com.weblearning.math.grade6.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.controller.UserLoginController;
import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class Grade6AddSub extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(UserLoginController.class);
	
	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List <Problem>addSubtractFraction = new  LinkedList<Problem>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		for (int j=0; j< 5; j++){
			for (int i=1; i<5; i++)
				addSubtractFraction.add(getProblem1(i, mSource));
		}
		
		logger.info("Returning from Grade6AddSub");
		
		return addSubtractFraction;
	}
	
	/*
	 * Lesson for adding
	 */
	public Problem getProblem1(int i, MessageSource mSource){
		
		Answer answ = new Answer();
		CreateProblem createProbmem = new CreateProblem();;
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		
		String questionAndAnswer[];
		
		//four lines of addition
		int numbersInArray = 3;
		
		//Create an empty array for the numbers
		int numbers[] = MathUtilities.getRandomNumbers(numbersInArray, 999, 9999);
		
		questionAndAnswer = rule(numbers, i);

		questionList.add(new QuestionLine(questionAndAnswer[0]));

		//String answ = ;
		String heading = mSource.getMessage(Constants.GRADE_6_CONTENT_ADD_SUB, null, Locale.ENGLISH);
		answ.setAnswer(questionAndAnswer[1]);
		
		Problem problem = createProbmem.constructProblem (questionList, heading, Constants.RANK_ONE,   Constants.DEFAULT);
		problem.setAnswer(answ);
		
		return problem;
	}
	
	/*the result should be number[0]+number[1]-number[2]
	 * 
	 */
	
	public String [] rule(int numbers[], int rule){
		
		int answer=0;
		
		String questionAndAnswer[]=new String [2];;
		if (rule ==1){
			
			questionAndAnswer[0]= numbers[0] + " + " +  numbers[1] + " - " + numbers[2];
			answer = numbers[0] + numbers[1]- numbers[2];
			questionAndAnswer[1]= Integer.toString(answer);
			
		}
		else if (rule ==2){
			
			questionAndAnswer[0]= numbers[0] + " - " +  numbers[1] + " + " + numbers[2];
			answer = numbers[0] - numbers[1] + numbers[2];
			questionAndAnswer[1]= Integer.toString(answer);
			
		}
		else if (rule ==3){
			
			questionAndAnswer[0]= " - " + numbers[0] + " - " +  numbers[1] + " + " + numbers[2];
			answer = -numbers[0] - numbers[1]+ numbers[2];
			questionAndAnswer[1]= Integer.toString(answer);
			
		}
		else{
			
			questionAndAnswer[0]= " - " + numbers[0] + " + " +  numbers[1] + " - " + numbers[2];
			answer = -numbers[0] + numbers[1]- numbers[2];
			questionAndAnswer[1]= Integer.toString(answer);
			
		}
			return questionAndAnswer;
		
	}
	
}
