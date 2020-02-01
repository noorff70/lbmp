package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.Locale;

import org.apache.commons.math3.fraction.Fraction;
//import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
//import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7SimpleEquations extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7simpleEquations= new ArrayList<Problem>();
		
		g7simpleEquations.add(getProblem1(mathConfig));
		g7simpleEquations.add(getProblem2(mathConfig));
		g7simpleEquations.add(getProblem3(mathConfig));
		g7simpleEquations.add(getProblem4(mathConfig));
		g7simpleEquations.add(getProblem5(mathConfig));
		g7simpleEquations.add(getProblem6(mathConfig));
		g7simpleEquations.add(getProblem7(mathConfig));
		g7simpleEquations.add(getProblem8(mathConfig));
		
		return g7simpleEquations;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		// MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		// x + 2 = 7
		int _1a = MathUtilities.getRandomNumber(2, 10);
		int _1b = MathUtilities.getRandomNumber(11, 20);
			
		
		question1 = "$ x + " + Integer.toString(_1a)  + "= "+ Integer.toString(_1b) + "$" ;
		answer1 = Integer.toString(_1b - _1a);
		
		// x + 2 = 7
		int _2a = MathUtilities.getRandomNumber(11, 20);
		int _2b = MathUtilities.getRandomNumber(2, 10);
			
		question2 = "$" + Integer.toString(_2a)  + " + a = "+ Integer.toString(_2b) + "$" ;
		answer2 = Integer.toString(_2b - _2a);
		
	
		// m - 2 = 7
		int _3a = MathUtilities.getRandomNumber(2, 5);
		int _3b = MathUtilities.getRandomNumber(5, 10);
			
		question3 = "$ m - " + Integer.toString(_3a)  + "= "+ Integer.toString(_3b) + "$" ;
		answer3 = Integer.toString(_3b + _3a);
		
		// m - 2 = -7
		int _4a = MathUtilities.getRandomNumber(-10, -5);
		int _4b = MathUtilities.getRandomNumber(-5, -2);
			
		question4 = "$ i  " + Integer.toString(_4a)  + "= "+ Integer.toString(_4b) + "$" ;
		answer4 = Integer.toString(_4b - _4a);
		
		//5
		// m + 2 = -7
		int _5a = MathUtilities.getRandomNumber(2, 10);
		int _5b = MathUtilities.getRandomNumber(-10, -2);
			
		question5 = "$ k  + " + Integer.toString(_5a)  + "= "+ Integer.toString(_5b) + "$" ;
		answer5 = Integer.toString(_5b - _5a);
		
		
		questionList.add(new QuestionLine( "Find the value", null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = "Simple Equations";
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		// MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		// _1a - _1b = x - _1c
		int _1a = MathUtilities.getRandomNumber(2, 10);
		int _1b = MathUtilities.getRandomNumber(11, 20);
		int _1c = MathUtilities.getRandomNumber(-5,  -2);
			
		
		question1 = "$" + Integer.toString(_1a) + " - " + Integer.toString(_1b) + " = x - (" + Integer.toString(_1c) +   ")$" ;
		answer1 = Integer.toString(_1a - _1b + _1c);
		
		// 2x + 3x = _2a + _2b
		int _2a = MathUtilities.getRandomNumber(11, 20);
		int _2b = MathUtilities.getRandomNumber(2, 10);
		int _2c = MathUtilities.getRandomNumber(2, 5);
		int _2d = MathUtilities.getRandomNumber(2, 5);
			
		question2 = "$" + Integer.toString(_2c) + "x + " + Integer.toString(_2d)+ "x =" + Integer.toString(_2a) + " + " + Integer.toString(_2b) + "$" ;
		Fraction frac2 = new Fraction(_2a+_2b, _2c+_2d);
		answer2 = frac2.toString();
		
	
		// m - 2 = 7
		int _3a = MathUtilities.getRandomNumber(2, 5);
		int _3b = MathUtilities.getRandomNumber(5, 10);
		int _3c = MathUtilities.getRandomNumber(2, 10);
		int _3d = MathUtilities.getRandomNumber(2, 5);
		int _3e = MathUtilities.getRandomNumber(2,  5);
			
		question3 = "$" + Integer.toString(_3c) + " + " + Integer.toString(_3d)+  "x + " + Integer.toString(_3e) + "x" +
				" = " + Integer.toString(_3a) + " + " + Integer.toString(_3b) +"$"  ;
		Fraction frac3 = new Fraction(_3a+_3b-_3c, _3d+_3e);
		answer3 = frac3.toString();
		
		// m - 2 = -7
		int _4a = MathUtilities.getRandomNumber(10, 15);
		int _4b = MathUtilities.getRandomNumber(-2, -5);
		int _4c = MathUtilities.getRandomNumber(2,  5);
		int _4d = MathUtilities.getRandomNumber(5,  10);
			
		question4 = "$" + Integer.toString(_4a) + "x - (" + Integer.toString(_4b) + "x ) + " + Integer.toString(_4c) + 
				" = " + Integer.toString(_4d) + "$" ;
		Fraction frac4 = new Fraction(_4d-_4c, _4a-_4b);
		answer4 = frac4.toString();
		
		//5
		int _5a = MathUtilities.getRandomNumber(2, 10);
		int _5b = MathUtilities.getRandomNumber(11, 20);
		int _5c = MathUtilities.getRandomNumber(-5,  -2);
			
		
		question5 = "$" + Integer.toString(_5a) + " - " + Integer.toString(_5b) + " = x - (" + Integer.toString(_5c) +   ")$" ;
		answer5 = Integer.toString(_5a - _5b + _5c);
		
		
		questionList.add(new QuestionLine( "Find the value. (Exppress in terms of Fraction when needed)", null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = "Simple Equations";
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		// MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		// _1a - _1b = x - _1c
		int _1a = MathUtilities.getRandomNumber(2, 5);
		int _1b = _1a* MathUtilities.getRandomNumber(2, 10);
					
		question1 = "$" + Integer.toString(_1a) + "x = "+ Integer.toString(_1b) + "$" ;
		answer1 = Integer.toString(_1b/_1a);
		
		// 2x + 3x = _2a + _2b
		int _2a = MathUtilities.getRandomNumber(2, 5);
		int _2b = _2a* MathUtilities.getRandomNumber(2, 10);
		
		question2 = "$" + Integer.toString(_2b) + "x = "+ Integer.toString(_2a) + "$" ;
		Fraction frac2 = new Fraction(_2a, _2b);
		answer2 = frac2.toString();
	
		// 2x + 3x = _2a + _2b
		int _3a = MathUtilities.getRandomNumber(2, 5);
		int _3b = _3a* MathUtilities.getRandomNumber(2, 10);
		
		question3 = "$\\frac{" + Integer.toString(_3a) + "}{ x } = "+ Integer.toString(_3b) + "$" ;
		Fraction frac3 = new Fraction(_3a, _3b);
		answer3 = frac3.toString();
		
		// 2x + 3x = _2a + _2b
		int _4a = MathUtilities.getRandomNumber(2, 5);
		int _4b = _4a* MathUtilities.getRandomNumber(2, 10);
		int _4c = MathUtilities.getRandomNumber(2, 5)* _4a;
		int _4d = MathUtilities.getRandomNumber(2,5)*_4a;
		
		question4 = "$\\frac{"+ Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "} = "
				 + "\\frac{" + Integer.toString(_4c) + "}{" + Integer.toString(_4d) + "x}" + "$" ;

		Fraction frac4 = new Fraction(_4c*_4b, _4a*_4d);
		answer4 = frac4.toString();
		
		//5
		// 2x + 3x = _2a + _2b
		int _5a = MathUtilities.getRandomNumber(2, 5);
		int _5b = _5a* MathUtilities.getRandomNumber(2, 10);
		int _5c = MathUtilities.getRandomNumber(2, 5)* _5a;
		int _5d = MathUtilities.getRandomNumber(2,5)*_5a;
		
		question5 = "$\\frac{"+ Integer.toString(_5a) + "x}{" + Integer.toString(_5b) + "} = "
				 + "\\frac{" + Integer.toString(_5c) + "}{" + Integer.toString(_5d) + "}" + "$" ;

		Fraction frac5 = new Fraction(_5b*_5c, _5a*_5d);
		answer5 = frac5.toString();
		
		
		questionList.add(new QuestionLine( "Find the value. (Express in Fraction)"  , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = "Simple Equations";
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		// MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		// _1a - _1b = x - _1c
		int _1a = MathUtilities.getRandomNumber(2, 5);
		int _1b = MathUtilities.getRandomNumber(2, 5);
		int _1c = MathUtilities.getRandomNumber(2,  5);
					
		question1 = "$\\frac{"+ Integer.toString(_1a)+ "}{x}" + " + " + "\\frac{" + Integer.toString(_1b) + "}{x} = " + Integer.toString(_1c) +   "$" ;
		Fraction frac1 = new Fraction(_1a+_1b, _1c);
		answer1= frac1.toString();
		
		// 2x + 3x = _2a + _2b
		int _2a = MathUtilities.getRandomNumber(2, 5);
		int _2b = MathUtilities.getRandomNumber(2, 10);
		
		question2 = "$\\frac{x}{" + Integer.toString(_2a) + "} + \\frac{x}{" + Integer.toString(_2a)+"} = " + Integer.toString(_2b)+ "$";
		Fraction frac2 = new Fraction(_2b*_2a, 2);
		answer2 = frac2.toString();
	
		// 2x + 3x = _2a + _2b
		int _3a = MathUtilities.getRandomNumber(2, 5);
		int _3b = MathUtilities.getRandomNumber(2, 5);
		int _3c = MathUtilities.getRandomNumber(2, 5);
		int _3d = MathUtilities.getRandomNumber(2, 5);
	//	int _3e = MathUtilities.getRandomNumber(2, 5);
		
		question3 = "$\\frac{" + Integer.toString(_3a) + "}{" + Integer.toString(_3b)+ "} + " + Integer.toString(_3c)+"x = " + Integer.toString(_3d) + "$";
		Fraction _3fa = new Fraction(_3d, 1).subtract(new Fraction(_3a, _3b));
		Fraction _3fb = _3fa.divide(new Fraction(_3c, 1));
		
		answer3 = _3fb.toString();
		
		// 2x + 3x = _2a + _2b
		int _4a = MathUtilities.getRandomNumber(2, 5);
		int _4b = MathUtilities.getRandomNumber(2, 5);
		int _4c = MathUtilities.getRandomNumber(2, 5);
		int _4d = MathUtilities.getRandomNumber(2, 5);
		int _4e = MathUtilities.getRandomNumber(2, 5);
		
		question4 = "$\\frac{" + Integer.toString(_4a)+ "x}{" + Integer.toString(_4b) + "} + \\frac{" + Integer.toString(_4c)+ "x}{" + Integer.toString(_4d) +
				"} = " + Integer.toString(_4e) + "$";

		Fraction _4f1 = new Fraction(_4a, _4b).add(new Fraction(_4c, _4d));
		Fraction _4f2 = new Fraction(_4e, 1).divide(_4f1);
		answer4 = _4f2.toString();
		

		// 2x + 3x = _2a + _2b
		int _5a = MathUtilities.getRandomNumber(2, 5);
		int _5b = MathUtilities.getRandomNumber(2, 5);
		int _5c = MathUtilities.getRandomNumber(2, 5);
		int _5d = MathUtilities.getRandomNumber(2, 5);
		int _5e = MathUtilities.getRandomNumber(2, 5);
		
		question5 = "$\\frac{" + Integer.toString(_5a)+ "x}{" + Integer.toString(_5b) + "} + \\frac{" + Integer.toString(_5c)+ "x}{" + Integer.toString(_5d) +
				"} = " + Integer.toString(_5e) + "$";

		Fraction _5f1 = new Fraction(_5a, _5b).add(new Fraction(_5c, _5d));
		Fraction _5f2 = new Fraction(_5e, 1).divide(_5f1);
		answer5 = _5f2.toString();
		
		
		questionList.add(new QuestionLine( "Find the value. (Express in Fraction)", null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = "Simple Equations";
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		// MessageSource mSource = mathConfig.getmSource();		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		int _1a = MathUtilities.getRandomNumber(6, 10);
		int _1b = MathUtilities.getRandomNumber(2, 5);
		int _1c = MathUtilities.getRandomNumber(2, 5);
		int _1d = MathUtilities.getRandomNumber(6, 10);
					
		question1 = "$" + Integer.toString(_1a) + "x + " + Integer.toString(_1c) + " = " + Integer.toString(_1c) + "x + " + Integer.toString(_1d) + "$" ;
		Fraction frac = new Fraction(_1d-_1b, _1a-_1c);
		answer1 = frac.toString();
				
		questionList.add(new QuestionLine( "Find the value. (Express in Fraction)"  , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		
		String heading = "Simple Equations";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		// MessageSource mSource = mathConfig.getmSource();		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		int _1a = MathUtilities.getRandomNumber(16, 20);
		int _1b = MathUtilities.getRandomNumber(2, 5);
		int _1c = MathUtilities.getRandomNumber(2, 3);
		int _1d = MathUtilities.getRandomNumber(2,5);
		int _1e = MathUtilities.getRandomNumber(2, 5);
		int _1f = MathUtilities.getRandomNumber(2, 5);
					
		question1 = "$" + Integer.toString(_1a) + "x + " + Integer.toString(_1b) + " = " 
				+ Integer.toString(_1c)+ "(" + Integer.toString(_1d) + "x + " + Integer.toString(_1e) + ") + "+ Integer.toString(_1f) + "$" ;
		
		Fraction frac = new Fraction(_1c*_1e+_1f-_1b, _1a -_1c*_1d );
		answer1 = frac.toString();
				
		questionList.add(new QuestionLine( "Find the value. (Express in Fraction)"  , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		
		String heading = "Simple Equations";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem7(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		// MessageSource mSource = mathConfig.getmSource();		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		

		question1 = "$ \\frac{2(2x + 3)}{3} = x + 3" +  "$" ;
		
		answer1 = "3";
				
		questionList.add(new QuestionLine( "Find the value."  , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		
		String heading = "Simple Equations";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		// MessageSource mSource = mathConfig.getmSource();		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		

		question1 = "$ \\frac{2x + 2}{3} = \\frac{x+3}{2}" +  "$" ;
		
		answer1 = "5";
				
		questionList.add(new QuestionLine( "Find the value."  , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 ,  null, Constants.PROBLEM_TYPE_FRACTION));
		
		String heading = "Simple Equations";
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
}
