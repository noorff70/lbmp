package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import java.util.Map;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;

public class Grade7Factors extends GenericQuestion{


	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List <Problem>factors = new  ArrayList<Problem>();
		
		for (int i=0; i< 5; i++){
			factors.add(getProblem1(mathConfig));
			factors.add(getProblem2(mathConfig));
			factors.add(getProblem3(mathConfig));
			factors.add(getProblem4(mathConfig));
			factors.add(getProblem5(mathConfig));
		}
		//factors.add(getProblem6(mathConfig));
		
		return factors;
	}
	
	/*
	 * Factor of a complex number from 4 to 19
	 */
	public Problem getProblem1(MathConfiguration mConfig){
	
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		String heading = null;
		String subHeading = null;
		String answ = null;
		
		//Take any number from 3 to 20
		int randomPosition = MathUtilities.getRandomNumber(3,20 );
		
		Map mapFactor = mConfig.getFactors();
		List listFactor = (List<?>) mapFactor.get(randomPosition);
		
		//for a prime number listFactor will have a size of 2. We need something more than a prime number.
		while(listFactor.size()<= 2){
			randomPosition = MathUtilities.getRandomNumber(20,80 );
			listFactor = (List<?>) mapFactor.get(randomPosition);
		}
		
		StringBuilder str = new StringBuilder();

		for (int i=0; i< listFactor.size(); i++){
			
			if (i== listFactor.size()/2){
				answ = listFactor.get(i).toString();
			}
			else{
				str.append(listFactor.get(i)) ;
				str.append(" ");
			}
		}
		
		questionList.add(new QuestionLine("What is the missing factor of " + randomPosition));
		questionList.add(new QuestionLine(str.toString()));
	
		heading = "Factor of a complex number";
		subHeading = "Factor of a complex number";
			
		Problem problem = getProblem(questionList, answ, heading, subHeading,   Constants.DEFAULT);
		
		return problem;
	}

	
	/*
	 * Factor of a complex number from 21 to 80
	 */
	public Problem getProblem2(MathConfiguration mConfig){
	
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		String subHeading = null;
		String answ = null;
		
		//Take any number from 3 to 20
		int randomPosition = MathUtilities.getRandomNumber(20,80 );
		
		Map mapFactor = mConfig.getFactors();
		List listFactor = (List<?>) mapFactor.get(randomPosition);
		
		//for a prime number listFactor will have a size of 2. We need something more than a prime number.
		while(listFactor.size()<= 2){
			randomPosition = MathUtilities.getRandomNumber(20,80 );
			listFactor = (List<?>) mapFactor.get(randomPosition);
		}
		
		StringBuilder str = new StringBuilder();

		for (int i=0; i< listFactor.size(); i++){
			
			if (i== listFactor.size()/2){
				answ = listFactor.get(i).toString();
			}
			else{
				str.append(listFactor.get(i)) ;
				str.append(" ");
			}
		}
		
		questionList.add(new QuestionLine("What is the missing factor of " + randomPosition));
		questionList.add(new QuestionLine(str.toString()));
	
		subHeading = "Factor of a complex number";
			
		Problem problem = getProblem(questionList, answ,"", subHeading,   Constants.DEFAULT);
		
		return problem;
	}
	
	/*
	 * Factor of a complex number from 81 to 200
	 */
	public Problem getProblem3(MathConfiguration mConfig){
	
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		String subHeading = null;
		String answ = null;
		
		//Take any number from 3 to 20
		int randomPosition = MathUtilities.getRandomNumber(80,200 );
		
		Map mapFactor = mConfig.getFactors();
		List listFactor = (List<?>) mapFactor.get(randomPosition);
		
		//for a prime number listFactor will have a size of 2. We need something more than a prime number.
		while(listFactor.size()<= 2){
			randomPosition = MathUtilities.getRandomNumber(20,80 );
			listFactor = (List<?>) mapFactor.get(randomPosition);
		}
		
		StringBuilder str = new StringBuilder();

		for (int i=0; i< listFactor.size(); i++){
			
			if (i== listFactor.size()/2){
				answ = listFactor.get(i).toString();
			}
			else{
				str.append(listFactor.get(i)) ;
				str.append(" ");
			}
		}
		
		questionList.add(new QuestionLine("What is the missing factor of " + randomPosition));
		questionList.add(new QuestionLine(str.toString()));
	
		subHeading = "Factor of a complex number";
			
		Problem problem = getProblem(questionList, answ,"", subHeading,   Constants.DEFAULT);
		
		return problem;
	}
	
	
	/*
	 * Factor of a complex number from 201 to 500
	 */
	public Problem getProblem4(MathConfiguration mConfig){
	
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		String subHeading = null;
		String answ = null;
		
		//Take any number from 3 to 20
		int randomPosition = MathUtilities.getRandomNumber(201,500 );
		
		Map mapFactor = mConfig.getFactors();
		List listFactor = (List<?>) mapFactor.get(randomPosition);
		
		//for a prime number listFactor will have a size of 2. We need something more than a prime number.
		while(listFactor.size()<= 2){
			randomPosition = MathUtilities.getRandomNumber(20,80 );
			listFactor = (List<?>) mapFactor.get(randomPosition);
		}
		
		StringBuilder str = new StringBuilder();

		for (int i=0; i< listFactor.size(); i++){
			
			if (i== listFactor.size()/2){
				answ = listFactor.get(i).toString();
			}
			else{
				str.append(listFactor.get(i)) ;
				str.append(" ");
			}
		}
		
		questionList.add(new QuestionLine("What is the missing factor of " + randomPosition));
		questionList.add(new QuestionLine(str.toString()));
	
		subHeading = "Factor of a complex number";
			
		Problem problem = getProblem(questionList, answ,"", subHeading,   Constants.DEFAULT);
		
		return problem;
	}
	
	/*
	 * Factor of a complex number from 501 to 950
	 */
	public Problem getProblem5(MathConfiguration mConfig){
	

		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		String subHeading = null;
		String answ = null;
		
		//Take any number from 3 to 20
		int randomPosition = MathUtilities.getRandomNumber(501,950 );
		
		Map mapFactor = mConfig.getFactors();
		List listFactor = (List<?>) mapFactor.get(randomPosition);
		
		//for a prime number listFactor will have a size of 2. We need something more than a prime number.
		while(listFactor.size()<= 2){
			randomPosition = MathUtilities.getRandomNumber(20,80 );
			listFactor = (List<?>) mapFactor.get(randomPosition);
		}
		
		StringBuilder str = new StringBuilder();

		for (int i=0; i< listFactor.size(); i++){
			
			if (i== listFactor.size()/2){
				answ = listFactor.get(i).toString();
			}
			else{
				str.append(listFactor.get(i)) ;
				str.append(" ");
			}
		}
		
		questionList.add(new QuestionLine("What is the missing factor of " + randomPosition));
		questionList.add(new QuestionLine(str.toString()));
	
		subHeading = "Factor of a complex number";
			
		Problem problem = getProblem(questionList, answ,"", subHeading,   Constants.DEFAULT);
		
		return problem;
	}
	
	
	public Problem getProblem6(MathConfiguration mConfig){
		
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		String heading = null;
		String subHeading = null;
		String answ = null;
		
		//Take any number from 3 to 20
		int randomPosition = MathUtilities.getRandomNumber(3,20 );
		
		Map mapFactor = mConfig.getFactors();
		List listFactor = (List<?>) mapFactor.get(randomPosition);
		
		//for a prime number listFactor will have a size of 2. We need something more than a prime number.
		while(listFactor.size()<= 2){
			randomPosition = MathUtilities.getRandomNumber(20,80 );
			listFactor = (List<?>) mapFactor.get(randomPosition);
		}
		
		StringBuilder str = new StringBuilder();

		for (int i=0; i< listFactor.size(); i++){
			str.append(listFactor.get(i)) ;
			if (i<listFactor.size()-1){
				str.append(",");
			}
		}
		
		answ = str.toString();
		
		questionList.add(new QuestionLine("What are each of the factors for " + randomPosition));
		questionList.add(new QuestionLine("Write each in an ascending order seperated by comma "));
	
		heading = "Factor of a complex number";
		subHeading = "Factor of a complex number";
			
		Problem problem = getProblem(questionList, answ, heading, subHeading,   Constants.DEFAULT);
		
		return problem;
	}
	
	
	public Problem getProblem(List<QuestionLine> questionList, String answ, String questionHeading,  String subHeading, String type  ){
		
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

