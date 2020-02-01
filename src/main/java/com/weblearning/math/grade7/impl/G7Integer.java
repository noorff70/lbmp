package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7Integer extends GenericQuestion {
	


	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7Integer = new ArrayList<Problem>();

		g7Integer.add(getProblem1(mathConfig));
		g7Integer.add(getProblem2(mathConfig));
		g7Integer.add(getProblem3(mathConfig));
		g7Integer.add(getProblem4(mathConfig));
		g7Integer.add(getProblem5(mathConfig));
		g7Integer.add(getProblem6(mathConfig));
		g7Integer.add(getProblem7(mathConfig));
		g7Integer.add(getProblem8(mathConfig));
		g7Integer.add(getProblem9(mathConfig));
		
		for (int i=0; i< 2; i++) {
			g7Integer.add(getProblem10(mathConfig));
			g7Integer.add(getProblem11(mathConfig));
			g7Integer.add(getProblem12(mathConfig));
			g7Integer.add(getProblem13(mathConfig));
			g7Integer.add(getProblem14(mathConfig));
			g7Integer.add(getProblem15(mathConfig));
			g7Integer.add(getProblem16(mathConfig));
			g7Integer.add(getProblem17(mathConfig));
		}


		return g7Integer;
	}

	/*
	 * Exponentiation
	 */
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Write the Integer from the list"));
		
		String s1 = "12.56";
		String s2 = "$\\frac{1}{5}$" ;
		String s3 = Integer.toString(MathUtilities.getRandomNumber(1, 10));
		String s4 = 5 + "$\\frac{2}{10}$" ;
		
		String s = s1 + ", " + s2 + ", " + s3 + ", " + s4;
		answer = s3;
		answ.setAnswer(answer);
		
		questionList.add( new QuestionLine( s, null, Constants.DEFAULT));		

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Write the Integer from the list"));
		
		String s3 = Integer.toString(MathUtilities.getRandomNumber(-20, -1));
		String s2 = "$\\frac{24}{96}$" ;
		String s4 = 1 + "$\\frac{1}{10}$" ;
		String s1 = ".56";
		
		String s = s1 + ", " + s2 + ", " + s3 + ", " + s4;
		answer = s3;
		answ.setAnswer(answer);
		
		questionList.add( new QuestionLine( s, null, Constants.DEFAULT));		

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Write the Integer from the list"));
		
		String s3 = "0";
		String s2 = "$\\frac{4}{17}$" ;
		String s4 = 3 + "$\\frac{2}{4}$" ;
		String s1 = "0.04";
		
		String s = s1 + ", " + s2 + ", " + s3 + ", " + s4;
		answer = s3;
		answ.setAnswer(answer);
		
		questionList.add( new QuestionLine( s, null, Constants.DEFAULT));		

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Write the Integer from the list"));
		
		String s3 = Integer.toString(MathUtilities.getRandomNumber(-20, 20));
		String s2 = "$\\frac{8}{9}$" ;
		String s4 = 5 + "$\\frac{1}{4}$" ;
		String s1 = "2.10";
		
		String s = s1 + ", " + s2 + ", " + s3 + ", " + s4;
		answer = s3;
		answ.setAnswer(answer);
		
		questionList.add( new QuestionLine( s, null, Constants.DEFAULT));		

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Write the Integer from the list"));
		
		String s1 = "0.010";
		String s3 = "45.0";
		String s4 = 7 + "$\\frac{2}{3}$" ;
		String s2 = "$\\frac{5}{7}$" ;
			
		String s = s1 + ", " + s3 + ", " + s4 + ", " + s2;
		answer = s3;
		answ.setAnswer(answer);
		
		questionList.add( new QuestionLine( s, null, Constants.DEFAULT));		

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Arrange Integers from lowest to highest seperated by a comma"));
		
		String s1 = Integer.toString(MathUtilities.getRandomNumber(-20, -10));
		String s2 = Integer.toString(MathUtilities.getRandomNumber(-9, -5));
		String s3 = Integer.toString(MathUtilities.getRandomNumber(0, 5));
		String s4 = Integer.toString(MathUtilities.getRandomNumber(6, 10));
		
		String s = s2 + ", " + s4 + ", " + s1 + ", " + s3;
		answer = s1 + "," + s2 + "," + s3 + ", " + s4;
		answ.setAnswer(answer);
		
		questionList.add( new QuestionLine( s, null, Constants.DEFAULT));		

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem7(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Arrange Integers from lowest to highest seperated by a comma"));
		
		String s1 = Integer.toString(MathUtilities.getRandomNumber(-20, -10));
		String s2 = Integer.toString(MathUtilities.getRandomNumber(-9, -5));
		String s3 = Integer.toString(0);
		String s4 = Integer.toString(MathUtilities.getRandomNumber(0, 5));
		String s5 = Integer.toString(MathUtilities.getRandomNumber(6, 10));
		
		String s = s2 + ", " + s4 + ", " + s1 + ", " + s3 + ", " + s5;
		answer = s1 + "," + s2 + "," + s3 + "," + s4 + ", " + s5;
		answ.setAnswer(answer);
		
		questionList.add( new QuestionLine( s, null, Constants.DEFAULT));		

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("What is the next integer after -1"));

		answer = "0";
		answ.setAnswer(answer);	

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem9(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Express the following expression. Put a sign before the integer (either + or minus)."));
		int n1 = MathUtilities.getRandomNumber(1, 5);
		
		String s1 = "Gained " + n1 + " lbs";
		questionList.add( new QuestionLine( s1, null, Constants.DEFAULT));	

		answer = "+" + Integer.toString(n1);
		answ.setAnswer(answer);	

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem10(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Express the following expression. Put a sign before the integer (either + or minus)."));
		int n1 = MathUtilities.getRandomNumber(1, 5);
		
		String s1 = "Lost " + n1 + " lbs";
		questionList.add( new QuestionLine( s1, null, Constants.DEFAULT));	

		answer = "-" + Integer.toString(n1);
		answ.setAnswer(answer);	

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem11(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Express the following expression. Put a sign before the integer (either + or minus)."));
		int n1 = MathUtilities.getRandomNumber(6, 10);
		int n2 = MathUtilities.getRandomNumber(100, 500);
		
		String s1 = "Saved " + n1*n2 + " in " + n1 + " Months. How much money saved in a  month";
		questionList.add( new QuestionLine( s1, null, Constants.DEFAULT));	

		answer = "+" + Integer.toString(n2);
		answ.setAnswer(answer);	

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem12(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Express the following expression. Put a sign before the integer (either + or minus)."));
		int n1 = MathUtilities.getRandomNumber(1000, 5000);
		
		String s1 = "Withdrew " + n1 + " amount";
		questionList.add( new QuestionLine( s1, null, Constants.DEFAULT));	

		answer = "-" + Integer.toString(n1);
		answ.setAnswer(answer);	

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem13(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
						
		questionList.add(new QuestionLine("Express the following expression. Put a sign before the integer (either + or minus)."));
		int n1 = MathUtilities.getRandomNumber(5, 10);
		
		String s1 = Integer.toString(n1) + " Moved to another school.";
		questionList.add( new QuestionLine( s1, null, Constants.DEFAULT));	

		answer = "-" + Integer.toString(n1);
		answ.setAnswer(answer);	

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem14(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
		
		int n1 = MathUtilities.getRandomNumber(-10, -5);
		int n2 = n1 -2;
		int n3 = n1 + 2;
		int n4 = n1 - 10;
		int n5 = n1 + 5;
						
		questionList.add(new QuestionLine("Write all the integers smaller than " + n1 + " order by smaller to larger number and separated by comma."));	
		String s1 = n1 + ", " + n5 + ", " + n3 + "," + n2 + ", " + n4;
		questionList.add( new QuestionLine( s1, null, Constants.DEFAULT));	

		answer = n4 + ", " + n2;
		answ.setAnswer(answer);	

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem15(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
		
		int n1 = MathUtilities.getRandomNumber(-10, -5);
		int n2 = n1 -2;
		int n3 = n1 + 2;
		int n4 = n1 - 10;
		int n5 = n1 + 5;
						
		questionList.add(new QuestionLine("Write all the integers greater than " + n1 + " order by smaller to larger number and separated by comma."));	
		String s1 = n1 + ", " + n5 + ", " + n3 + "," + n2 + ", " + n4;
		questionList.add( new QuestionLine( s1, null, Constants.DEFAULT));	

		answer = n2 + ", " + n5;
		answ.setAnswer(answer);	

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem16(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
		
		int n1 = MathUtilities.getRandomNumber(-10, -5);
		int n2 = MathUtilities.getRandomNumber(10, 20);
		
		int n3 = n1 -2;
		int n4 = n2 + 2;
		int n5 = n2- 2;
		int n6 = n1 + 2;
		
						
		questionList.add(new QuestionLine("Write all the integers that are not between " + n1 + " and " + n2 + " order by smaller to larger number and separated by comma."));	
		String s1 = n4 + ", " + n3 + "," + n5 + ", " + n6;
		questionList.add( new QuestionLine( s1, null, Constants.DEFAULT));	

		answer = n3 + ", " + n4;
		answ.setAnswer(answer);	

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem17(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
		
		int n1 = MathUtilities.getRandomNumber(-10, -5);
		int n2 = MathUtilities.getRandomNumber(10, 20);
		
		int n3 = n1 -2;
		int n4 = n2 + 2;
		int n5 = n2- 2;
		int n6 = n1 + 2;
		
						
		questionList.add(new QuestionLine("Write all the integers that are not between " + n1 + " and " + n2 + " order by smaller to larger number and separated by comma."));	
		String s1 = n6 + ", " + n5 + "," + n3 + ", " + n4;
		questionList.add( new QuestionLine( s1, null, Constants.DEFAULT));	

		answer = n3 + ", " + n4;
		answ.setAnswer(answer);	

		String heading = "Understanding Integers";
	
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answ);

		return problem;
	}
}
