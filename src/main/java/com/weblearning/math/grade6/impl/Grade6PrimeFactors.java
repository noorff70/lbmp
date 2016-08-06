package com.weblearning.math.grade6.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import java.util.Map;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;

public class Grade6PrimeFactors extends Question{


	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List <Problem>factors = new  ArrayList<Problem>();
		
		factors.add(getProblem1(mathConfig));
		factors.add(getProblem2(mathConfig));
		factors.add(getProblem3(mathConfig));

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
		
		Map mapPrimeFactor = mConfig.getPrimeFactors();
		List listFactor = (List<?>) mapPrimeFactor.get(randomPosition);
		
		//for a prime number listFactor will have a size of 2. We need something more than a prime number.
		while(listFactor.size()<= 2){
			randomPosition = MathUtilities.getRandomNumber(3,20 );
			listFactor = (List<?>) mapPrimeFactor.get(randomPosition);
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
		
		questionList.add(new QuestionLine("What is the missing prime factor of " + randomPosition));
		questionList.add(new QuestionLine(str.toString()));
	
		heading = "Prime Factor of a complex number";
		subHeading = "Prime Factor of a complex number";
			
		Problem problem = getProblem(questionList, answ, heading, subHeading,   Constants.DEFAULT);
		
		return problem;
	}

	
	/*
	 * Factor of a complex number from 4 to 19
	 */
	public Problem getProblem2(MathConfiguration mConfig){
	
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		String heading = null;
		String subHeading = null;
		String answ = null;
		
		//Take any number from 3 to 20
		int randomPosition = MathUtilities.getRandomNumber(21,50 );
		
		Map mapPrimeFactor = mConfig.getPrimeFactors();
		List listFactor = (List<?>) mapPrimeFactor.get(randomPosition);
		
		//for a prime number listFactor will have a size of 2. We need something more than a prime number.
		while(listFactor.size()<= 2){
			randomPosition = MathUtilities.getRandomNumber(21,50 );
			listFactor = (List<?>) mapPrimeFactor.get(randomPosition);
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
		
		questionList.add(new QuestionLine("What is the missing prime factor of " + randomPosition));
		questionList.add(new QuestionLine(str.toString()));
	
		heading = "Prime Factor of a complex number";
		subHeading = "Prime Factor of a complex number";
			
		Problem problem = getProblem(questionList, answ, heading, subHeading,   Constants.DEFAULT);
		
		return problem;
	}
	
	
	
		
	public Problem getProblem3(MathConfiguration mConfig){
		
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		String heading = null;
		String subHeading = null;
		String answ = null;
		
		//Take any number from 3 to 20
		int randomPosition = MathUtilities.getRandomNumber(3,20 );
		
		Map mapPrimeFactor = mConfig.getPrimeFactors();
		List listFactor = (List<?>) mapPrimeFactor.get(randomPosition);
		
		//for a prime number listFactor will have a size of 2. We need something more than a prime number.
		while(listFactor.size()<= 2){
			randomPosition = MathUtilities.getRandomNumber(3,20 );
			listFactor = (List<?>) mapPrimeFactor.get(randomPosition);
		}
		
		StringBuilder str = new StringBuilder();

		for (int i=0; i< listFactor.size(); i++){
			str.append(listFactor.get(i)) ;
			if (i<listFactor.size()-1){
				str.append(",");
			}
		}
		
		answ = str.toString();
		
		questionList.add(new QuestionLine("What are each of the prime factors for " + randomPosition));
		questionList.add(new QuestionLine("Write each in an ascending order seperated by comma "));
	
		heading = "Prime Factor of a complex number";
		subHeading = "Prime Factor of a complex number";
			
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

