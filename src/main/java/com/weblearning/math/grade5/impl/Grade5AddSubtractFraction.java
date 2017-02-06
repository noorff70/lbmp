package com.weblearning.math.grade5.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.math3.fraction.Fraction;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;

public class Grade5AddSubtractFraction extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List <Problem>addSubtractFraction = new  ArrayList<Problem>();
		
		addSubtractFraction.add(getProblem1());
		addSubtractFraction.add(getProblem2());
		addSubtractFraction.add(getProblem3());
		
		return addSubtractFraction;
	}
	
	
	/* Add simple fraction for two fractions. Add + Add
	 * 
	 */
	public Problem getProblem1(){
	
		Problem problem = new Problem();
		Answer answer = new Answer();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		Fraction result = new Fraction(0,1);;
		String question= "";
		QuestionLine qLine = new QuestionLine();
		
		for (int i=0; i<2; i++){
			int numerator = MathUtilities.getRandomNumber(1, 8);
			int denominator = MathUtilities.getRandomNumber(numerator+1, 9);
			
			Fraction fi = new Fraction(numerator, denominator);
			result = result.add(fi);
			
			if (i==0)
				question = "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
			else
				question = question + " + " + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
		}
		
		qLine.setQuestionLn(question);
		questionList.add(qLine);
		problem.setQuestionHeading("Add two fraction numbers");
		problem.setQuestionLines(questionList);
		
		answer.setAnswer(result.toString());
		answer.setType("FRACTION");
		
		problem.setAnswer(answer);
				
		return problem;
	}
	
	/* Add simple fractions for three fractions. Add + Add + Add
	 * 
	 */
	public Problem getProblem2(){
		
		Problem problem = new Problem();
		Answer answer = new Answer();
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		Fraction result = new Fraction (0,1);;
		String question= "";
		QuestionLine qLine = new QuestionLine();
		
		for (int i=0; i<3; i++){
			int numerator = MathUtilities.getRandomNumber(1, 8);
			int denominator = MathUtilities.getRandomNumber(numerator+1, 9);
			
			Fraction fi = new Fraction(numerator, denominator);
			result = result.add(fi);
			
			if (i==0)
				question = "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
			else
				question = question + " + " + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
		}
		
		qLine.setQuestionLn(question);
		questionList.add(qLine);
		problem.setQuestionHeading("Add three fraction numbers");
		problem.setQuestionLines(questionList);
		
		answer.setAnswer(result.toString());
		answer.setType("FRACTION");
		
		problem.setAnswer(answer);
				
		return problem;
	}
	
	/*Add and subtract in same statement. Add-subtract+add
	 * 
	 */
	public Problem getProblem3(){
		
		Problem problem = new Problem();
		Answer answer = new Answer();
		
		List <QuestionLine>questionList = new LinkedList<QuestionLine>();
		Fraction result = new Fraction(0,1);
		String question= "";
		QuestionLine qLine = new QuestionLine();
		
		for (int i=0; i<3; i++){
			int numerator = MathUtilities.getRandomNumber(1, 8);
			int denominator = MathUtilities.getRandomNumber(numerator+1, 9);
			
			Fraction fi = new Fraction(numerator, denominator);
			
			
			if (i==0){
				question = "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				result = result.add(fi);
			}
			else if (i==1){
				question = question + " - " + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				result = result.subtract(fi);
			}
			else{
				question = question + " + " + "$\\frac{"+Integer.toString(numerator)+ "}{"+Integer.toString(denominator)+"}$";
				result = result.add(fi);
			}
		}
		
		qLine.setQuestionLn(question);
		questionList.add(qLine);
		problem.setQuestionHeading("Add and Subtract in Same Statement");
		problem.setQuestionLines(questionList);
		
		answer.setAnswer(result.toString());
		answer.setType("FRACTION");
		
		problem.setAnswer(answer);
				
		return problem;
	}


}
