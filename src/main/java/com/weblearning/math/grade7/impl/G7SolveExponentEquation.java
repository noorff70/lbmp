package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7SolveExponentEquation extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7SolveExponentEquation = new ArrayList<Problem>();


		for (int i = 0; i < 3; i++)
			g7SolveExponentEquation.add(getProblem1(mathConfig));
		for (int i = 0; i < 3; i++)
			g7SolveExponentEquation.add(getProblem2(mathConfig));
		for (int i = 0; i < 3; i++)
			g7SolveExponentEquation.add(getProblem3(mathConfig));
		for (int i = 0; i < 3; i++)
			g7SolveExponentEquation.add(getProblem4(mathConfig));
		for (int i = 0; i < 3; i++)
			g7SolveExponentEquation.add(getProblem5(mathConfig));
		for (int i = 0; i < 3; i++)
			g7SolveExponentEquation.add(getProblem6(mathConfig));
		for (int i = 0; i < 2; i++)
			g7SolveExponentEquation.add(getProblem7(mathConfig));
		for (int i = 0; i < 2; i++)
			g7SolveExponentEquation.add(getProblem8(mathConfig));
		for (int i = 0; i < 3; i++)
			g7SolveExponentEquation.add(getProblem9(mathConfig));
		

		return g7SolveExponentEquation;
	}

	/*
	 * box + 2^3 = 9, box =1
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		
		int base = MathUtilities.getRandomNumber(2, 8);
		int pow = MathUtilities.getRandomNumber(2, 4);
		int a = MathUtilities.getRandomNumber(2, 10);
		
		int ans = a + (int)Math.pow(base, pow);

		question = "$" + "\\Box + " + Integer.toString(base)  + "^{" + Integer.toString(pow) + "} = "+ Integer.toString(ans)  + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(a));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	

	/*
	 * 1 + box^3 = 9, box =2
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		
		int base = MathUtilities.getRandomNumber(2, 8);
		int pow = MathUtilities.getRandomNumber(2, 4);
		int a = MathUtilities.getRandomNumber(2, 10);
		
		int ans = a + (int)Math.pow(base, pow);

		question = "$" + Integer.toString(a) + " + \\Box"  + "^{" + Integer.toString(pow) + "} = "+ Integer.toString(ans)  + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(base));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	/*
	 * 1 + box^3 = 9, box =2
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		
		int base = MathUtilities.getRandomNumber(2, 8);
		int pow = MathUtilities.getRandomNumber(2, 4);
		int a = MathUtilities.getRandomNumber(2, 10);
		
		int ans = a + (int)Math.pow(base, pow);

		question = "$" +  Integer.toString(ans)  + " = " + Integer.toString(a) + " + \\Box" + "^{"+ Integer.toString(pow) +   "}$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(base));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * box + (-2)^3 = 1, box =9
	 */
	public Problem getProblem4(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		
		int base = MathUtilities.getRandomNumber(-5, -2);
		int pow = 3;
		int a = MathUtilities.getRandomNumber(2, 10);
		
		int ans = a + (int)Math.pow(base, pow);

		question = "$" + "\\Box + ("  + Integer.toString(base) + ")^{" + Integer.toString(pow) + "} = "+ Integer.toString(ans)  + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(a));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * box + (-2)^3 = 1, box =9
	 */
	public Problem getProblem5(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		
		int base = MathUtilities.getRandomNumber(-5, -2);
		int pow = MathUtilities.getRandomNumber(2,  4);
		int a = MathUtilities.getRandomNumber(2, 10);
		
		int ans = a + (int)Math.pow(base, pow);

		question = "$" + "\\Box + ("  + Integer.toString(base) + ")^{" + Integer.toString(pow) + "} = "+ Integer.toString(ans)  + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(a));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * box + (-2)^3 = 1, box =9
	 */
	public Problem getProblem6(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		
		int base = MathUtilities.getRandomNumber(-5, -2);
		int pow = MathUtilities.getRandomNumber(2,  4);
		int a = MathUtilities.getRandomNumber(2, 10);
		
		int ans = a - (int)Math.pow(base, pow);

		question = "$" + Integer.toString(ans)  + " = \\Box - ("  + Integer.toString(base) + ")^{" + Integer.toString(pow) + "}$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(a));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * box + (-2)^3 = 1, box =9
	 */
	public Problem getProblem7(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		
		int base = MathUtilities.getRandomNumber(2, 5);
		int pow = 1;
		int a = MathUtilities.getRandomNumber(2, 10);
		
		int ans = a - (int)Math.pow(base, pow);

		question = "$" + Integer.toString(ans)  + " = " + Integer.toString(a) + "- "  + Integer.toString(base) + "^{\\Box"  + "}$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(pow));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	/*
	 * box + (-2)^3 = 1, box =9
	 */
	public Problem getProblem8(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		
		int base = 0;
		int pow = MathUtilities.getRandomNumber(2, 8);
		int a = MathUtilities.getRandomNumber(2, 10);
		
		int ans = a + (int)Math.pow(base, pow);

		question = "$" + Integer.toString(ans)  + " = " + Integer.toString(a) + " + \\Box"  + "^{" + Integer.toString(pow) + "}$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(base));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	

	/*
	 * box + 2^3 = 9, box =1
	 */
	public Problem getProblem9(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		
		int base = MathUtilities.getRandomNumber(2, 8);
		int pow = MathUtilities.getRandomNumber(2, 4);
		int a = MathUtilities.getRandomNumber(2, 10);
		
		int ans = a * (int)Math.pow(base, pow);

		question = "$" + "\\Box \\times " + Integer.toString(base)  + "^{" + Integer.toString(pow) + "} = "+ Integer.toString(ans)  + "$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(a));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	

}
