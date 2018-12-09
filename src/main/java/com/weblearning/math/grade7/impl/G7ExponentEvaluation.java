package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade.UniqueObjectMap;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ExponentEvaluation extends GenericQuestion {

	Map<Integer, UniqueObjectMap> objectMaps = new ConcurrentHashMap<Integer, UniqueObjectMap>();

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentEvaluation = new ArrayList<Problem>();

		for (int i = 0; i < 4; i++)
			g7ExponentEvaluation.add(getProblem1(mathConfig, i));
		for (int i = 0; i < 4; i++)
			g7ExponentEvaluation.add(getProblem2(mathConfig, i));
		for (int i = 0; i < 3; i++)
			g7ExponentEvaluation.add(getProblem3(mathConfig, i));
		for (int i = 0; i < 3; i++)
			g7ExponentEvaluation.add(getProblem4(mathConfig, i));
		for (int i = 0; i < 4; i++)
			g7ExponentEvaluation.add(getProblem5(mathConfig, i));
		for (int i = 0; i < 3; i++)
			g7ExponentEvaluation.add(getProblem6(mathConfig, i));
		for (int i = 0; i < 2; i++)
			g7ExponentEvaluation.add(getProblem7(mathConfig, i));
		for (int i = 0; i < 2; i++)
			g7ExponentEvaluation.add(getProblem8(mathConfig, i));

		return g7ExponentEvaluation;
	}


	
	//3^ 3 = 27
	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		
		//find the result
		int q4Base = MathUtilities.getRandomNumber(2, 8);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
		int ans4 = (int) Math.pow((double)q4Base, (double)q4Pow);
		question4 = "$"+ q4Base + "^{" + q4Pow + "}" + " = " + "\\Box" + "$";
		answer4 = Integer.toString(ans4);
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//(1)^ 0 = 1
	public Problem getProblem2(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		
		//find the result
		int q4Base = MathUtilities.getRandomNumber(2, 8);
		int q4Pow = 0;
		int ans4 = (int) Math.pow((double)q4Base, (double)q4Pow);
		question4 = "$"+ q4Base + "^{" + q4Pow + "}" + " = " + "\\Box" + "$";
		answer4 = Integer.toString(ans4);
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//(5)^ 1 = 5
	public Problem getProblem3(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		
		//find the result
		int q4Base = MathUtilities.getRandomNumber(2, 8);
		int q4Pow = 1;
		int ans4 = (int) Math.pow((double)q4Base, (double)q4Pow);
		question4 = "$"+ q4Base + "^{" + q4Pow + "}" + " = " + "\\Box" + "$";
		answer4 = Integer.toString(ans4);
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//(-3)^ 3 = -27
	public Problem getProblem4(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		
		//find the result
		int q4Base = MathUtilities.getRandomNumber(-8, -2);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
		int ans4 = (int) Math.pow((double)q4Base, (double)q4Pow);
		question4 = "$("+ q4Base + ")^{" + q4Pow + "}" + " = " + "\\Box" + "$";
		answer4 = Integer.toString(ans4);
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//-(-3)^ 3 = 27
	public Problem getProblem5(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		
		//find the result
		int q4Base = MathUtilities.getRandomNumber(-8, -2);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
		int ans4 = (int) Math.pow((double)q4Base, (double)q4Pow);
		ans4 = ans4 * -1;
		question4 = "$-("+ q4Base + ")^{" + q4Pow + "}" + " = " + "\\Box" + "$";
		answer4 = Integer.toString(ans4);
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//box^ 3 = 27
	public Problem getProblem6(MathConfiguration mathConfig, int i) {
			
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
			
		//find the result
		int q4Base = MathUtilities.getRandomNumber(2, 8);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
		int ans4 = (int) Math.pow((double)q4Base, (double)q4Pow);
		question4 = "$\\Box^{" + q4Pow + "}" + " = " + ans4 + "$";
		answer4 = Integer.toString(q4Base);
			
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//3^x = 27
	public Problem getProblem7(MathConfiguration mathConfig, int i) {
			
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
			
		//find the result
		int q4Base = MathUtilities.getRandomNumber(2, 8);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
		int ans4 = (int) Math.pow((double)q4Base, (double)q4Pow);
		question4 = "$" + Integer.toString(q4Base) +"^{x}" + " = " + ans4 + "$";
		answer4 = Integer.toString(q4Pow);
			
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	//3^x = 27
	public Problem getProblem8(MathConfiguration mathConfig, int i) {
			
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
			
		//find the result
		int q4Base = MathUtilities.getRandomNumber(2, 5);
		int q4Pow = MathUtilities.getRandomNumber(-3, -2);
		int ans4 = (int) Math.pow((double)q4Base, (double)Math.abs(q4Pow));
		question4 = "$" + Integer.toString(q4Base) +"^{" + q4Pow + "}" + " =  \\Box $";
		answer4 = "$" +"\\frac{" + Integer.toString(1) + "}{" + Integer.toString(ans4) + "}$";
			
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4));

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}


}
