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

public class G7IntegerOperation1 extends GenericQuestion {
	


	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentDecimalFraction = new ArrayList<Problem>();

		g7ExponentDecimalFraction.add(getProblem1(mathConfig));
		g7ExponentDecimalFraction.add(getProblem2(mathConfig));
		g7ExponentDecimalFraction.add(getProblem3(mathConfig));
		
		for (int i=0; i< 2; i++) {
			g7ExponentDecimalFraction.add(getProblem4(mathConfig));
			g7ExponentDecimalFraction.add(getProblem5(mathConfig));
			g7ExponentDecimalFraction.add(getProblem6(mathConfig));
			g7ExponentDecimalFraction.add(getProblem7(mathConfig));
			g7ExponentDecimalFraction.add(getProblem8(mathConfig));
		}

		return g7ExponentDecimalFraction;
	}

	/*
	 * Exponentiation
	 */
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//(+3) + (+4) = 
		int _1a = MathUtilities.getRandomNumber(1, 5);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = _1a + _1b;
		
		question1 = "(+"+ Integer.toString(_1a)+ ") + (+" + Integer.toString(_1b) + ")";
		answer1 = Integer.toString(_1c);
		
		
		// 4 + (+5)=
		int _2a = MathUtilities.getRandomNumber(1, 5);
		int _2b = MathUtilities.getRandomNumber(5, 10);
		int _2c = _2a+ _2b;
		
		question2 = Integer.toString(_2a)  + " + (+" + Integer.toString(_2b) + ")";
		answer2 = Integer.toString(_2c);
		
		 
		// (+4) + (-5)=
		int _3a = MathUtilities.getRandomNumber(11, 20);
		int _3b = MathUtilities.getRandomNumber(1, 10);
		int _3c = _3a - _3b;
		
		question3 = "(+" + Integer.toString(_3a) + ") + (-" + Integer.toString(_3b) + ")";
		answer3 = Integer.toString(_3c);
		
		
		// (+4) - (+5)=
		int _4a = MathUtilities.getRandomNumber(11, 20);
		int _4b = MathUtilities.getRandomNumber(1, 10);
		int _4c = _4a - _4b;
		
		question4 = "(+" + Integer.toString(_4a) + ") - (+" + Integer.toString(_4b) + ")";
		answer4 = Integer.toString(_4c);
		
		
		//- (+4) + (+5)=
		int _5a = MathUtilities.getRandomNumber(11, 20);
		int _5b = MathUtilities.getRandomNumber(1, 10);
		int _5c = -_5b + _5a;
		
		question5 = "-(+" + Integer.toString(_5b) + ") + (+" + Integer.toString(_5a) + ")";
		answer5 = Integer.toString(_5c);
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//(-3) + (-4) = 
		int _1a = MathUtilities.getRandomNumber(1, 5);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = -_1a - _1b;
		
		question1 = "(-"+ Integer.toString(_1a)+ ") + (-" + Integer.toString(_1b) + ")";
		answer1 = Integer.toString(_1c);
		
		
		// -4 - (+5)=
		int _2a = MathUtilities.getRandomNumber(1, 5);
		int _2b = MathUtilities.getRandomNumber(5, 10);
		int _2c = -_2a- _2b;
		
		question2 = "-" + Integer.toString(_2a)  + " - (+" + Integer.toString(_2b) + ")";
		answer2 = Integer.toString(_2c);
		
		 
		// (-4) - (-5)=
		int _3a = MathUtilities.getRandomNumber(11, 20);
		int _3b = MathUtilities.getRandomNumber(1, 10);
		int _3c = -_3a + _3b;
		
		question3 = "(-" + Integer.toString(_3a) + ") - (-" + Integer.toString(_3b) + ")";
		answer3 = Integer.toString(_3c);
		
		
		// -(+4) - (+5)=
		int _4a = MathUtilities.getRandomNumber(11, 20);
		int _4b = MathUtilities.getRandomNumber(1, 10);
		int _4c = -_4a - _4b;
		
		question4 = "-(+" + Integer.toString(_4a) + ") - (+" + Integer.toString(_4b) + ")";
		answer4 = Integer.toString(_4c);
		
		
		//- (-4) - (-5)=
		int _5a = MathUtilities.getRandomNumber(11, 20);
		int _5b = MathUtilities.getRandomNumber(1, 10);
		int _5c = _5b + _5a;
		
		question5 = "-(-" + Integer.toString(_5b) + ") - (-" + Integer.toString(_5a) + ")";
		answer5 = Integer.toString(_5c);
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//(-3) + (-4) = 
		int _1a = MathUtilities.getRandomNumber(1, 5);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = MathUtilities.getRandomNumber(10, 20);
		int _1d = -_1a - _1b + _1c;
		
		question1 = "(-"+ Integer.toString(_1a)+ ") + (-" + Integer.toString(_1b) + ") + " + Integer.toString(_1c);
		answer1 = Integer.toString(_1d);
		
		
		//+(+10) -4 - (+5)=
		int _2a = MathUtilities.getRandomNumber(1, 5);
		int _2b = MathUtilities.getRandomNumber(5, 10);
		int _2c = MathUtilities.getRandomNumber(1, 10);
		int _2d = _2a -_2b - _2c;
		
		question2 = "+(+"+ Integer.toString(_2a) + ")" + "-" + Integer.toString(_2b)  + " - (+" + Integer.toString(_2c) + ")";
		answer2 = Integer.toString(_2d);
		
		 
		// - (-3) + (-4) - (-5)=
		int _3a = MathUtilities.getRandomNumber(11, 20);
		int _3b = MathUtilities.getRandomNumber(1, 10);
		int _3c = MathUtilities.getRandomNumber(5, 10);
		int _3d = _3a -_3b + _3c;
		
		question3 = "-(-" + Integer.toString(_3a) +  ") + (-" + Integer.toString(_3b) + ") - (-" + Integer.toString(_3c) + ")";
		answer3 = Integer.toString(_3d);
		
		
		// -(+4) - (+5) + (-6)=
		int _4a = MathUtilities.getRandomNumber(11, 20);
		int _4b = MathUtilities.getRandomNumber(1, 10);
		int _4c = MathUtilities.getRandomNumber(5, 10);
		int _4d = -_4a - _4b - _4c;
		
		question4 = "-(+" + Integer.toString(_4a) + ") - (+" + Integer.toString(_4b) + ") + ( -" + Integer.toString(_4c) + ")";
		answer4 = Integer.toString(_4d);
		
		
		//- (-4) - (-5) - (+5)=
		int _5a = MathUtilities.getRandomNumber(11, 20);
		int _5b = MathUtilities.getRandomNumber(1, 10);
		int _5c = MathUtilities.getRandomNumber(5, 10);
		int _5d = _5a + _5b - _5c;
		
		question5 = "-(-" + Integer.toString(_5a) + ") - (-" + Integer.toString(_5b) + ") - (+" + Integer.toString(_5c) + ")";
		answer5 = Integer.toString(_5d);
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		//(-3) + (-4) = 
		int _1a = MathUtilities.getRandomNumber(1, 5);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = _1a +_1b;
		
		question1 = "(+"+ Integer.toString(_1a)+ ") + (+$\\Box $)" + " = " + Integer.toString(_1c);
		answer1 = Integer.toString(_1b);
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		//(3) + (-4) = -1
		int _1a = MathUtilities.getRandomNumber(1, 5);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = _1a -_1b;
		
		question1 = "(+"+ Integer.toString(_1a)+ ") + (?$\\Box $)" + " = " + Integer.toString(_1c);
		answer1 = Integer.toString(-_1b);
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		//(3) + (4) = 7
		int _1a = MathUtilities.getRandomNumber(1, 5);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = _1a +_1b;
		
		question1 = "(+$\\Box $) +"+ Integer.toString(_1b)+ ")  = " + Integer.toString(_1c);
		answer1 = Integer.toString(_1a);
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem7(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		//(3) + (4) = 7
		int _1a = MathUtilities.getRandomNumber(1, 5);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = _1a +_1b;
		
		question1 = Integer.toString(_1a) + "-(?$\\Box$)  = " + Integer.toString(_1c);
		answer1 = Integer.toString(-_1b);
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		//(3) + (4) = 7
		int _1a = MathUtilities.getRandomNumber(1, 5);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = MathUtilities.getRandomNumber(1, 5);
		int _1d = _1a+_1b+_1c;
		
		question1 = "(+$\\Box$)" + "-(-" + Integer.toString(_1b) + ")" + "(+"+ Integer.toString(_1c) + ") = " + Integer.toString(_1d);
		answer1 = Integer.toString(_1a);
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
}
