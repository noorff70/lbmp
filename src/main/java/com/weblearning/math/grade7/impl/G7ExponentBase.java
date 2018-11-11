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
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ExponentBase extends GenericQuestion {
	
	Map<Integer, UniqueObjectMap> objectMaps = new ConcurrentHashMap<Integer, UniqueObjectMap>();

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentEvaluation = new ArrayList<Problem>();

	//	for (int i = 0; i <1; i++)
	//		g7ExponentEvaluation.add(getProblem1(mathConfig, i));
		for (int i = 0; i <1; i++)
			g7ExponentEvaluation.add(getProblem2(mathConfig, i));
		for (int i = 0; i <1; i++)
			g7ExponentEvaluation.add(getProblem3(mathConfig, i));
		for (int i = 0; i <1; i++)
			g7ExponentEvaluation.add(getProblem4(mathConfig, i));
		for (int i = 0; i <1; i++)
			g7ExponentEvaluation.add(getProblem5(mathConfig, i));
		for (int i = 0; i <1; i++)
			g7ExponentEvaluation.add(getProblem6(mathConfig, i));
		for (int i = 0; i <1; i++)
			g7ExponentEvaluation.add(getProblem7(mathConfig, i));
		for (int i = 0; i <1; i++)
			g7ExponentEvaluation.add(getProblem8(mathConfig, i));
		

		return g7ExponentEvaluation;
	}

	/*
	 * Exponentiation
	 */
	/* public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
	
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		int answer =0;
		
		//get a random first number
		
		int firstNumber = MathUtilities.getRandomNumber(1, 10);
		int pow = MathUtilities.getRandomNumber(1, 4);
		
		
		//we put the number and value to a map so that it can be compared and we don't get any duplicate value
		//The map wil be (k,v)-> (i,(firstnumber, pow)), where i is the number of iteration 
		if (objectMaps.size()==0){
			UniqueObjectMap objectMap = new UniqueObjectMap();
			objectMap.setNumber(firstNumber);
			objectMap.setPow(pow);
			objectMaps.put(i, objectMap);
			
			question = "$ X ^{" +objectMap.getPow()+"}$" + " = " + (int) Math.pow(objectMap.getNumber(), objectMap.getPow());
			answer = objectMap.getNumber();
		}else{
			//2nd time and so on, we need to compare the value if that is in the map

			while (MathUtilities.isObjectPresent(firstNumber, pow, objectMaps)){
				
				firstNumber = MathUtilities.getRandomNumber(1, 10);
				pow = MathUtilities.getRandomNumber(1, 4);

			}
			UniqueObjectMap objectMap = new UniqueObjectMap();
			objectMap.setNumber(firstNumber);
			objectMap.setPow(pow);
			objectMaps.put(i, objectMap);
			
			//create question and answer sections
			question = "$ X ^{" +objectMap.getPow()+"}$" + " = " + (int) Math.pow(objectMap.getNumber(), objectMap.getPow());
			answer = objectMap.getNumber();
		
		}		
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_VALUE_OF_X, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(answer));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
*/
	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		
		//find the base
		int q1Base = MathUtilities.getRandomNumber(2, 8);
		int q1Pow = MathUtilities.getRandomNumber(2, 4);
		int ans1 = (int) Math.pow((double)q1Base, (double)q1Pow);
		question1 = "$"+ q1Base + "^{" + q1Pow + "}" + " = " + Integer.toString(ans1) + "$";
		answer1 = Integer.toString(q1Base); 
		
		//find the power
		int q2Base = MathUtilities.getRandomNumber(2, 8);
		int q2Pow = MathUtilities.getRandomNumber(2, 4);
		int ans2 = (int) Math.pow((double)q2Base, (double)q2Pow);
		question2 = "$"+ q2Base + "^{" + q2Pow + "}" + " = " + Integer.toString(ans2) + "$";
		answer2 = Integer.toString(q2Pow);
		
		//find the base
		int q3Base = MathUtilities.getRandomNumber(-8, -2);
		int q3Pow = MathUtilities.getRandomNumber(2, 4);
		int ans3 = (int) Math.pow((double)q3Base, (double)q3Pow);
		question3 = "$("+ q3Base + ")^{" + q3Pow + "}" + " = " + Integer.toString(ans3) + "$";
		answer3 = Integer.toString(q3Base);
		
		//find the result
		int q4Base = MathUtilities.getRandomNumber(-8, -2);
		int q4Pow = MathUtilities.getRandomNumber(2, 4);
		int ans4 = (int) Math.pow((double)q4Base, (double)q4Pow);
		question4 = "$("+ q4Base + ")^{" + q4Pow + "}" + " = " + Integer.toString(ans4) + "$";
		answer4 = Integer.toString(ans4);
		
		//find the power
		int q5Base = MathUtilities.getRandomNumber(8, 2);
		int q5Pow = MathUtilities.getRandomNumber(-4, -2);
		int ans5 = (int) Math.pow((double)q5Base, (double)Math.abs(q5Pow));
		question5 = "$"+ q5Base + "^{" + q5Pow + "} = " 
				+ "\\frac{" + Integer.toString(1) + "}{" + Integer.toString((int)ans5) + "}$";
		answer5 = Integer.toString(q5Pow);
		
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 + ". " +mSource.getMessage(GR7_Constants.WRITE_THE_BASE, null, Locale.ENGLISH)+
				Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + ". " +mSource.getMessage(GR7_Constants.WRITE_THE_POWER, null, Locale.ENGLISH)+
				Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + ". " +mSource.getMessage(GR7_Constants.WRITE_THE_BASE, null, Locale.ENGLISH)+
				Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + ". " +mSource.getMessage(GR7_Constants.WRITE_THE_RESULT, null, Locale.ENGLISH)+
				Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + ". " +mSource.getMessage(GR7_Constants.WRITE_THE_POWER, null, Locale.ENGLISH)+
				Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(Constants.GRADE_7_EXPONENT_BASE, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	//3^ 3 = 27
	public Problem getProblem2(MathConfiguration mathConfig, int i) {
		
		
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
	public Problem getProblem3(MathConfiguration mathConfig, int i) {
		
		
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
	public Problem getProblem4(MathConfiguration mathConfig, int i) {
		
		
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
	public Problem getProblem6(MathConfiguration mathConfig, int i) {
		
		
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
	public Problem getProblem8(MathConfiguration mathConfig, int i) {
			
			
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
	

}
