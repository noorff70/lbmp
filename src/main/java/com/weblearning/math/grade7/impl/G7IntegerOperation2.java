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
import org.apache.commons.math3.fraction.Fraction;

public class G7IntegerOperation2 extends GenericQuestion {
	


	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentDecimalFraction = new ArrayList<Problem>();

		g7ExponentDecimalFraction.add(getProblem1(mathConfig));
		g7ExponentDecimalFraction.add(getProblem2(mathConfig));
		g7ExponentDecimalFraction.add(getProblem3(mathConfig));
		g7ExponentDecimalFraction.add(getProblem4(mathConfig));
		g7ExponentDecimalFraction.add(getProblem5(mathConfig));
		g7ExponentDecimalFraction.add(getProblem6(mathConfig));
		g7ExponentDecimalFraction.add(getProblem7(mathConfig));
		g7ExponentDecimalFraction.add(getProblem8(mathConfig));
		g7ExponentDecimalFraction.add(getProblem9(mathConfig));


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
		int _1c = _1a * _1b;
		
		question1 = "(+"+ Integer.toString(_1a)+ ") $\\times $(+" + Integer.toString(_1b) + ")";
		answer1 = Integer.toString(_1c);
		
		
		// 4 * (+5)=
		int _2a = MathUtilities.getRandomNumber(1, 5);
		int _2b = MathUtilities.getRandomNumber(5, 10);
		int _2c = _2a * _2b;
		
		question2 = Integer.toString(_2a)  + "$\\times $(+" + Integer.toString(_2b) + ")";
		answer2 = Integer.toString(_2c);
		
		 
		// (+4) * (-5)=
		int _3a = MathUtilities.getRandomNumber(1, 20);
		int _3b = MathUtilities.getRandomNumber(-10, -2);
		int _3c = _3a * _3b;
		
		question3 = "(+" + Integer.toString(_3a) + ") $\\times$ (" + Integer.toString(_3b) + ")";
		answer3 = Integer.toString(_3c);
		
		
		// (-4) * (-5)=
		int _4a = MathUtilities.getRandomNumber(-20, -5);
		int _4b = MathUtilities.getRandomNumber(-10, -1);
		int _4c = _4a * _4b;
		
		question4 = "(" + Integer.toString(_4a) + ") $\\times $(" + Integer.toString(_4b) + ")";
		answer4 = Integer.toString(_4c);
		
		
		// (-4) * (-5) * (-3)=
		int _5a = MathUtilities.getRandomNumber(-5, -1);
		int _5b = MathUtilities.getRandomNumber(-5, -1);
		int _5c = MathUtilities.getRandomNumber(-5, -1);
		int _5d = _5b * _5a* _5c*-1;
		
		question5 = "-(" + Integer.toString(_5a) + ") $\\times$ (" + Integer.toString(_5b) + ")$\\times$(" + Integer.toString(_5c) + ")";
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
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//(+3) + (+4) = 
		int _1a = MathUtilities.getRandomNumber(1, 5);
		int _1b = MathUtilities.getRandomNumber(2,5) * _1a;
		int _1c = _1b / _1a;
		
		question1 = "(+"+ Integer.toString(_1b)+ ") $\\div $(" + Integer.toString(_1a) + ")";
		answer1 = Integer.toString(_1c);
		
		
		// 4 * (+5)=
		int _2a = MathUtilities.getRandomNumber(-5, -1);
		int _2b = MathUtilities.getRandomNumber(2, 6) * _2a*-1;
		int _2c = _2b / _2a;
		
		question2 = Integer.toString(_2b)  + "$\\div $(" + Integer.toString(_2a) + ")";
		answer2 = Integer.toString(_2c);
		
		 
		// (+4) * (-5)=
		int _3a = MathUtilities.getRandomNumber(-10, -1);
		int _3b = MathUtilities.getRandomNumber(2, 5) * _3a;
		int _3c = _3b / _3a;
		
		question3 = "(" + Integer.toString(_3b) + ") $\\div$ (" + Integer.toString(_3a) + ")";
		answer3 = Integer.toString(_3c);
		
		
		// (-4) * (5)=
		int _4a = MathUtilities.getRandomNumber(-20, -5);
		int _4b = MathUtilities.getRandomNumber(1, 5) * _4a;
		int _4c = _4b / _4a;
		
		question4 = "$(" + Integer.toString(_4b) + ")" + "\\over (" + Integer.toString(_4a) + ")$";
		answer4 = Integer.toString(_4c);
		
		
		// (-4) * (-5) * (-3)=
		int _5a = MathUtilities.getRandomNumber(-5, -1);
		int _5b = MathUtilities.getRandomNumber(2, 8)* _5a;
		
		int _5c = -1*_5b/_5a;
		
		question5 = "$-(" + Integer.toString(_5b) + ") \\over (" + Integer.toString(_5a) + ") $";
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
		
		//(+3) + (+4) = 
		int _1a = MathUtilities.getRandomNumber(-5, -1);
		int _1b = MathUtilities.getRandomNumber(-5, -1);
		int _1c = MathUtilities.getRandomNumber(-5, -1);
		int _1d = _1a-_1b*_1c;
		
		question1 = "(" + Integer.toString(_1a) + ") - (" + Integer.toString(_1b) + ") $\\times $(" + Integer.toString(_1c)+ ")";
		answer1 = Integer.toString(_1d);
		
		
		// 4 * (+5)=
		int _2a = MathUtilities.getRandomNumber(-5, -1);
		int _2b = MathUtilities.getRandomNumber(1, 5);
		int _2c = MathUtilities.getRandomNumber(1,  5)* _2b * -1;
		int _2d = _2a + _2c / _2b;
		
		question2 = "(" + Integer.toString(_2a) + ") +" + "("+ Integer.toString(_2c) + ") $\\div (+ " + Integer.toString(_2b)  + ")$";
		answer2 = Integer.toString(_2d);
		
		 
		// (+4) * (-5)=
		int _3b = MathUtilities.getRandomNumber(-5, -1);
		int _3a = MathUtilities.getRandomNumber(1, 5) * _3b;
		int _3c = MathUtilities.getRandomNumber(-10,-1);
		int _3d = _3a/_3b + _3c;
		
		question3 = "(" + Integer.toString(_3a) + ") $\\div$(" + Integer.toString(_3b) + ") + ("+ Integer.toString(_3c) + ")";
		answer3 = Integer.toString(_3d);
		
		
		// (-4) * (-5)=
		int _4b = MathUtilities.getRandomNumber(-5, -1);
		int _4a = MathUtilities.getRandomNumber(1, 10)* _4b;
		int _4c = MathUtilities.getRandomNumber(-5, -1);
		int _4d = _4a/_4b + _4c;
		
		question4 = "(" + Integer.toString(_4a) + ") $\\div$(" + Integer.toString(_4b)+ ") + (" + Integer.toString(_4c) + ")";
		answer4 = Integer.toString(_4d);
		
		
		// (-4) * (-5) * (-3)=
		int _5a = MathUtilities.getRandomNumber(-5, -1);
		int _5b = MathUtilities.getRandomNumber(-5, -1);
		int _5c = MathUtilities.getRandomNumber(-5, -1);
		int _5d = _5a+_5b * _5c;
		
		question5 = "(" + Integer.toString(_5a) + ") + (" + Integer.toString(_5b) + ")$\\times$(" + Integer.toString(_5c) + ")";
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

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//(+3) + (+4) = 
		int _1a = MathUtilities.getRandomNumber(-5, -1);
		int _1c = MathUtilities.getRandomNumber(-5, -1);
		int _1b = MathUtilities.getRandomNumber(2, 10) * _1c;
		int _1d = _1a *_1b/_1c;
		
		question1 = "(" + Integer.toString(_1a) + ") $\\times$(" + Integer.toString(_1b)+ ")$\\div$(" + Integer.toString(_1c) + ")" ;
		answer1 = Integer.toString(_1d);
		
		
		// 4 * (+5)=
		int _2a = MathUtilities.getRandomNumber(-5, -1);
		int _2b = MathUtilities.getRandomNumber(-5, -1);
		int _2c = MathUtilities.getRandomNumber(-5, -1);
		int _2d = _2a + _2b * _2c;
		
		question2 = "("+ Integer.toString(_2a) + ") + (" + Integer.toString(_2b) + ")$\\times$(" + Integer.toString(_2c) + ")" ;
		answer2 = Integer.toString(_2d);
		
		 
		// (+4) * (-5)=
		int _3b = MathUtilities.getRandomNumber(-5, -1);
		int _3a = MathUtilities.getRandomNumber(1, 5) * _3b;
		int _3c = MathUtilities.getRandomNumber(-10,-1);
		int _3d = _3a/_3b + _3c;
		
		question3 = "(" + Integer.toString(_3a) + ") $\\div$(" + Integer.toString(_3b) + ") + ("+ Integer.toString(_3c) + ")";
		answer3 = Integer.toString(_3d);
		
		
		// (-4) * (-5)=
		int _4b = MathUtilities.getRandomNumber(-1, -5);
		int _4a = MathUtilities.getRandomNumber(1, 10)* _4b;
		int _4c = MathUtilities.getRandomNumber(-10, -1);
		int _4d = _4a/_4b*_4c;
		
		question4 = "(" + Integer.toString(_4a) + ")$\\div$(" + Integer.toString(_4b) + ")$\\times$(" + Integer.toString(_4c)+ ")";
		answer4 = Integer.toString(_4d);
		
		
		// (-4) * (-5) * (-3)=
		int _5a = MathUtilities.getRandomNumber(-5, -1);
		int _5b = MathUtilities.getRandomNumber(-5, -1);
		int _5c = MathUtilities.getRandomNumber(-5, -1);
		int _5d = _5a+_5b * _5c;
		
		question5 = "(" + Integer.toString(_5a) + ") + (" + Integer.toString(_5b) + ")$\\times$(" + Integer.toString(_5c) + ")";
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
	
	//(a+b)/c*d
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		//(a+b)/ (c*d)
		int _1a = MathUtilities.getRandomNumber(-5, -1);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = MathUtilities.getRandomNumber(-5, -1);
		int _1d = MathUtilities.getRandomNumber(5, 10);
		
		int _1e = _1a + _1b;
		int _1f = _1c * _1d;
		
		Fraction f1 = new Fraction(_1e, _1f);
		
		question1 = "$\\frac{(" + Integer.toString(_1a) + ") + " + Integer.toString(_1b) + "}{(" + Integer.toString(_1c) + ")\\times (" + Integer.toString(_1d) + ")}$";
		answer1 = f1.toString();
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	
	//(-a+b-c)/d-e
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		int _1a = MathUtilities.getRandomNumber(-10, 10);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = MathUtilities.getRandomNumber(10, 1);
		int _1d = MathUtilities.getRandomNumber(1,5);
		int _1e = MathUtilities.getRandomNumber(-10, -1);
		
		int _1f = -_1a+_1b-_1c;
		int _1g = _1d -_1e;
		
		if (_1g == 0)
			_1g = 5;
		
		Fraction f1 = new Fraction(_1f, _1g);
		
		question1 = "$\\frac{-(" + Integer.toString(_1a) + ") + " + Integer.toString(_1b) + "-("+ Integer.toString(_1c) +")}{(" + Integer.toString(_1d) + ")- (" + Integer.toString(_1e) + ")}$";
		answer1 = f1.toString();
		
		
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
		
		//(a+b)/ (c*d)
		int _1a = MathUtilities.getRandomNumber(-5, 5);
		int _1b = MathUtilities.getRandomNumber(-5, 10);
		int _1d = MathUtilities.getRandomNumber(-5, -1);
		int _1c = MathUtilities.getRandomNumber(1,5) * _1d;
		
		int _1e = _1a + _1b;
		int _1f = _1c / _1d;
		
		Fraction f1 = new Fraction(_1e, _1f);
		
		question1 = "$\\frac{(" + Integer.toString(_1a) + ") + (" + Integer.toString(_1b) + ")}{(" + Integer.toString(_1c) + ")\\div (" + Integer.toString(_1d) + ")}$";
		answer1 = f1.toString();
		
		
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
		
		//(a+b)/ (c*d)
		int _1a = MathUtilities.getRandomNumber(-5, -1);
		int _1b = _1a * -1;
		int _1c = MathUtilities.getRandomNumber(-5, -1);
		int _1d = MathUtilities.getRandomNumber(1,5) ;
		
	//	Fraction f1 = new Fraction(_1e, _1f);
		
		question1 = "$\\frac{(" + Integer.toString(_1a) + ") + " + Integer.toString(_1b) + "}{(" + Integer.toString(_1c) + ")\\div (" + Integer.toString(_1d) + ")}$";
		answer1 = Integer.toString(0);
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem9(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		int _1a = MathUtilities.getRandomNumber(-10, 10);
		int _1b = MathUtilities.getRandomNumber(5, 10);
		int _1c = MathUtilities.getRandomNumber(10, 1);
		int _1d = MathUtilities.getRandomNumber(1,5);
		int _1e = MathUtilities.getRandomNumber(-10, -1);
		int _1f = MathUtilities.getRandomNumber(-10, -1)*_1e;
		
		int _1g = -_1a-_1b-_1c;
		int _1h = _1d *_1f /_1e;
		
		if (_1h == 0)
			_1h = 5;
		
		Fraction f1 = new Fraction(_1g, _1h);
		
		question1 = "$\\frac{-(" + Integer.toString(_1a) + ") - " + Integer.toString(_1b) + "-("+ Integer.toString(_1c) +")}"
						+ "{(" + Integer.toString(_1d) + ")\\times (" + Integer.toString(_1f) + ")\\div(" +Integer.toString(_1e) + ")}$";
		answer1 = f1.toString();
		
		
		questionList.add(new QuestionLine("Perform Integer Operation"));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		

		String heading = "Integer Operation- Addition and Subtraction";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
}
