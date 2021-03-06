package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.math3.fraction.Fraction;
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

public class G7DivideSimpleFraction extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> gr7DivideFraction = new ArrayList<Problem>();

		for (int i = 0; i < 1; i++)
			gr7DivideFraction.add(getProblem1(mathConfig, i));
		for (int i = 0; i < 1; i++)
			gr7DivideFraction.add(getProblem2(mathConfig, i));
		for (int i = 0; i < 3; i++)
			gr7DivideFraction.add(getProblem3(mathConfig, i));
		for (int i = 0; i < 3; i++)
			gr7DivideFraction.add(getProblem4(mathConfig, i));
		for (int i = 0; i < 3; i++)
			gr7DivideFraction.add(getProblem5(mathConfig, i));
		for (int i = 0; i < 3; i++)
			gr7DivideFraction.add(getProblem6(mathConfig, i));
		for (int i = 0; i < 3; i++)
			gr7DivideFraction.add(getProblem7(mathConfig, i));

		return gr7DivideFraction;
	}
	/* little tough for grade seven, may be for grade 8
	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//find the 1/2 * 2/3 = 
		int _1a= 2* MathUtilities.getRandomNumber(2, 20), _1b = MathUtilities.getRandomNumber(2, 20);
		int _1c= 2* MathUtilities.getRandomNumber(2, 20), _1d = MathUtilities.getRandomNumber(2, 20);

		question1 = "$" +"\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "} \\div "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" 
				+ " = " + "\\frac{" + Integer.toString(_1a) + "}{" + Integer.toString(_1b) + "}" + " \\times \\Box"  + "$";
		answer1 = Integer.toString(_1d) + "/" + Integer.toString(_1c) ;
		
		//find the 1/2 + 2/3 = 
		int _2a = 5* MathUtilities.getRandomNumber(1,20), _2b= 2* MathUtilities.getRandomNumber(1,20);
		int _2c = 5* MathUtilities.getRandomNumber(1,10), _2d= 2* MathUtilities.getRandomNumber(1,20);
				
		question2 = "$" +"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\div "
					+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" 
					+ " = " + "\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "}" + " \\times \\Box"  + "$";
		answer2 = Integer.toString(_2d) + "/" + Integer.toString(_2c) ;
		
	
		
		//find the 1/2 + 2/3 = 
		int _3a = 2* MathUtilities.getRandomNumber(1,20), _3b = 5* MathUtilities.getRandomNumber(1,20);
		int _3c = 2* MathUtilities.getRandomNumber(1,10), _3d= 5* MathUtilities.getRandomNumber(1,20);
				
		question3= "$" +"(-\\Box ) \\div "
					+ "\\frac{"+ Integer.toString(_3c) + "}{"+ Integer.toString(_3d)+ "}" 
					+ " = " + "\\frac{" + Integer.toString(_3a) + "}{" + Integer.toString(_3b) + "}" + " \\times" 
					+ "\\frac{"+ Integer.toString(_3d) + "}{"+ Integer.toString(_3c)+ "}"   + "$";
		answer3 = Integer.toString(_3a) + "/" + Integer.toString(_3b) ;
		
		//find the 1/2 + 2/3 =
		int _4a = 5* MathUtilities.getRandomNumber(1,20), _4b = 2* MathUtilities.getRandomNumber(1,20);
		int _4c = 5* MathUtilities.getRandomNumber(1,10), _4d= 2* MathUtilities.getRandomNumber(1,20);


		question4= "$" +"(-\\frac{" + Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "} ) \\div "
					+ "(-\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "})" 
					+ " = " + "-\\frac{" + Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "}" + " \\times \\Box"  + "$";
		answer4 = "-" +Integer.toString(_4d) + "/" + Integer.toString(_4c) ;
		
		//5
		int _5a = 2* MathUtilities.getRandomNumber(1,20), _5b= 5* MathUtilities.getRandomNumber(1,20);
		int _5c = 5* MathUtilities.getRandomNumber(1,10), _5d= 2* MathUtilities.getRandomNumber(1,20);
		int _5e = 5* MathUtilities.getRandomNumber(1,10), _5f= 2* MathUtilities.getRandomNumber(1,20);

		question5 = "$" +"\\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\times "
						+ "\\frac{"+ Integer.toString(_5c) + "}{"+ Integer.toString(_5d)+ "} \\div" 
						+ "\\frac{"+ Integer.toString(_5e) + "}{"+ Integer.toString(_5f)+ "}"  
						+ " = " + "\\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\times "
						+ "\\frac{"+ Integer.toString(_5c) + "}{"+ Integer.toString(_5d)+ "} \\times" 
						+ "\\Box"  
						+ "$";
		answer5 = Integer.toString(_5f) + "/" + Integer.toString(_5e) ;
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.DIVIDE_FRACTIONS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
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
		
		//find the 1/2 * 2/3 = 
		int _1a= 2* MathUtilities.getRandomNumber(2, 20);
		int _1c= 2* MathUtilities.getRandomNumber(2, 20), _1d = MathUtilities.getRandomNumber(2, 20);
		
		Fraction result1 = new Fraction(_1a, 1).divide(new Fraction(_1c, _1d));

		question1 = "$" + Integer.toString(_1a) + "\\div "
				+ "\\frac{"+ Integer.toString(_1c) + "}{"+ Integer.toString(_1d)+ "}" 
				+ " = " + "\\Box"  + "$";
		answer1 = result1.getNumerator() + "/" + result1.getDenominator() ;
		
		//find the 1/2 + 2/3 = 
		int _2a = 5* MathUtilities.getRandomNumber(1,20), _2b= 2* MathUtilities.getRandomNumber(1,20);
		int _2c = 5* MathUtilities.getRandomNumber(1,10);
		Fraction frac2 = new Fraction(_2a, _2b).divide(new Fraction(_2c, 1));
				
		question2 = "$" +"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\div "
					+ Integer.toString(_2c)   
					+ " = " + "\\Box"  + "$";
		answer2 = Integer.toString(frac2.getNumerator()) + "/" + Integer.toString(frac2.getDenominator()) ;
		
	
		
		//find the 1/2 + 2/3 = 
		int _3a = 2* MathUtilities.getRandomNumber(1,5), _3b = 5* MathUtilities.getRandomNumber(6, 10);
		int _3c = 2* MathUtilities.getRandomNumber(1,10), _3d= 5* _3c;
		int _3e = MathUtilities.getRandomNumber(2, 5);
		Fraction _3frac = new Fraction(_3a, _3b).divide(new Fraction(_3e, 1).add(new Fraction(_3c, _3d)));
				
		question3= "$" + "\\frac{"+ Integer.toString(_3a) + "}{"+ Integer.toString(_3b)+ "}" 
					+ " \\div" 
					+ Integer.toString(_3e) + "\\frac{"+ Integer.toString(_3c) + "}{"+ Integer.toString(_3d)+ "}"
					+ " = \\Box $";
		answer3 = Integer.toString(_3frac.getNumerator()) + "/" + Integer.toString(_3frac.getDenominator()) ;
		
		//find the 1/2 + 2/3 =
		int _4a = MathUtilities.getRandomNumber(1,5);
		int _4b = 2* MathUtilities.getRandomNumber(1,5), _4c = 5* _4b;
		int _4d= 2* MathUtilities.getRandomNumber(1,10),  _4e = 2* MathUtilities.getRandomNumber(12,20);
		Fraction _4frac1 = new Fraction(_4a, 1).add(new Fraction(_4b, _4c));
		Fraction _4result = _4frac1.divide(new Fraction(_4d, _4e));

		question4= "$" + Integer.toString(_4a)+ "\\frac{" + Integer.toString(_4b) + "}{" + Integer.toString(_4c) + "}  \\div "
					+ "\\frac{"+ Integer.toString(_4d) + "}{"+ Integer.toString(_4e)+ "}" 
					+ " =  \\Box"  + "$";
		answer4 = Integer.toString(_4result.getNumerator()) + "/" + Integer.toString(_4result.getDenominator()) ;
		
		//1 / (3 1/2)
		int _5a = 2* MathUtilities.getRandomNumber(1,20);
		int _5b= 2* MathUtilities.getRandomNumber(1,5);
		int _5c = MathUtilities.getRandomNumber(1,10), _5d= _5c*MathUtilities.getRandomNumber(2, 4);
		Fraction _result5 = new Fraction(_5a, 1).divide(new Fraction(_5b, 1).add(new Fraction(_5c, _5d)));

		question5 = "$" + Integer.toString(_5a)+ " \\div "
						+ Integer.toString(_5b) + "\\frac{"+ Integer.toString(_5c) + "}{"+ Integer.toString(_5d)+ "}" 
						+ " = " + "\\Box"+ "$";
		answer5 = Integer.toString(_result5.getNumerator()) + "/" + Integer.toString(_result5.getDenominator()) ;
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.DIVIDE_FRACTIONS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem2(MathConfiguration mathConfig, int i) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		//find the 1/2 * 2/3 = 
		Fraction frac1a = new Fraction(2* MathUtilities.getRandomNumber(2, 20), MathUtilities.getRandomNumber(2, 20));
		Fraction frac1b = new Fraction(2* MathUtilities.getRandomNumber(2, 20), MathUtilities.getRandomNumber(2, 20));
		
		Fraction result1 = frac1a.divide(frac1b);

		question1 = "$" +"\\frac{" + Integer.toString(frac1a.getNumerator()) + "}{" + Integer.toString(frac1a.getDenominator()) + "} \\over "
				+ "\\frac{"+ Integer.toString(frac1b.getNumerator()) + "}{"+ Integer.toString(frac1b.getDenominator())+ "}" + "$";
		answer1 = result1.toString();
		
		//find the 1/2 + 2/3 = 
		int _2a = 5* MathUtilities.getRandomNumber(1,20), _2b= 2* MathUtilities.getRandomNumber(1,20);
		int _2c = 5* MathUtilities.getRandomNumber(1,10), _2d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac2a = new Fraction(_2a, _2b);
		Fraction frac2b = new Fraction(_2c, _2d);
				
		Fraction result2 = frac2a.divide(frac2b);

		question2 = "$" +"\\frac{" + Integer.toString(_2a) + "}{" + Integer.toString(_2b) + "} \\div "
						+ "\\frac{"+ Integer.toString(_2c) + "}{"+ Integer.toString(_2d)+ "}" + "$";
		answer2 = result2.toString();
		
	
		
		//find the 1/2 + 2/3 = 
		int _3a = 2* MathUtilities.getRandomNumber(1,20), _3b = 5* MathUtilities.getRandomNumber(1,20);
		int _3c = 2* MathUtilities.getRandomNumber(1,10), _3d= 5* MathUtilities.getRandomNumber(1,20);
		Fraction frac3a = new Fraction(_3a, _3b);
		Fraction frac3b = new Fraction(_3c, _3d);
				
		Fraction result3 = frac3a.divide(frac3b).multiply(new Fraction(-1));

		question3= "$" +"(-\\frac{" + Integer.toString(_3a) + "}{" + Integer.toString(_3b) + "} ) \\div "
						+ "\\frac{"+ Integer.toString(_3c) + "}{"+ Integer.toString(_3d)+ "}" + "$";
		answer3 = result3.toString();
		
		//find the 1/2 + 2/3 =
		int _4a = 5* MathUtilities.getRandomNumber(1,20), _4b = 2* MathUtilities.getRandomNumber(1,20);
		int _4c = 5* MathUtilities.getRandomNumber(1,10), _4d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac4a = new Fraction(_4a, _4b);
		Fraction frac4b = new Fraction(_4c, _4d);
				
		Fraction result4 = frac4a.divide(frac4b);

		question4= "$" +"(-\\frac{" + Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "} ) \\div "
						+ "(-\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "})" + "$";
		answer4 = result4.toString();
		
		//5
		int _5a = 2* MathUtilities.getRandomNumber(1,20), _5b= 5* MathUtilities.getRandomNumber(1,20);
		int _5c = 5* MathUtilities.getRandomNumber(1,10), _5d= 2* MathUtilities.getRandomNumber(1,20);
		int _5e = 5* MathUtilities.getRandomNumber(1,10), _5f= 2* MathUtilities.getRandomNumber(1,20);
		
		Fraction frac5a = new Fraction(_5a, _5b);
		Fraction frac5b = new Fraction(_5c, _5d);
		Fraction frac5c = new Fraction(_5e, _5f);
				
		Fraction result5 = frac5a.multiply(frac5b).divide(frac5c);

		question5 = "$" +"\\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} \\times "
						+ "\\frac{"+ Integer.toString(_5c) + "}{"+ Integer.toString(_5d)+ "} \\div" 
						+ "\\frac{"+ Integer.toString(_5e) + "}{"+ Integer.toString(_5f)+ "}"  + "$";
		answer5 = result5.toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.DIVIDE__FOLLOWING_FRACTIONS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.DIVIDE_FRACTIONS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}


	public Problem getProblem3(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="";
		String answer1="";
		
		Fraction frac1a = new Fraction(MathUtilities.getRandomNumber(2, 20), 2 * MathUtilities.getRandomNumber(2, 20));
		Fraction frac1b = new Fraction(MathUtilities.getRandomNumber(2, 20), 2 * MathUtilities.getRandomNumber(2, 20));
		
		Fraction result1 = frac1a.divide(frac1b);

		question1 = "$" +"\\frac{" + Integer.toString(frac1a.getNumerator()) + "}{" + Integer.toString(frac1a.getDenominator()) + "} \\div "
				+ "\\frac{"+ Integer.toString(frac1b.getNumerator()) + "}{"+ Integer.toString(frac1b.getDenominator())+ "}" + "$";
		answer1 = result1.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.DIVIDE__FOLLOWING_FRACTIONS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 ));

		String heading = mSource.getMessage(GR7_Constants.DIVIDE_FRACTIONS, null, Locale.ENGLISH);
		answ.setAnswer(answer1);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer3="";
		
		int _3a = 2* MathUtilities.getRandomNumber(1,20), _3b= 5* MathUtilities.getRandomNumber(1,20);
		int _3c = 2* MathUtilities.getRandomNumber(1,10), _3d= 5* MathUtilities.getRandomNumber(1,20);
		Fraction frac3a = new Fraction(_3a, _3b);
		Fraction frac3b = new Fraction(_3c, _3d);
				
		Fraction result3 = frac3a.divide(frac3b);

		String question3 = "$" +"\\frac{" + Integer.toString(_3a) + "}{" + Integer.toString(_3b) + "} \\div "
						+ "\\frac{"+ Integer.toString(_3c) + "}{"+ Integer.toString(_3d)+ "}" + "$";
		answer3 = result3.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.DIVIDE__FOLLOWING_FRACTIONS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question3));

		String heading = mSource.getMessage(GR7_Constants.DIVIDE_FRACTIONS, null, Locale.ENGLISH);
		answ.setAnswer(answer3);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question4="";
		String answer4="";
		
		int _4a = 5* MathUtilities.getRandomNumber(1,20), _4b = 2* MathUtilities.getRandomNumber(1,20);
		int _4c = 5* MathUtilities.getRandomNumber(1,10), _4d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac4a = new Fraction(_4a, _4b);
		Fraction frac4b = new Fraction(_4c, _4d);
				
		Fraction result4 = frac4a.divide(frac4b).multiply(new Fraction(-1));

		question4= "$" +"(-\\frac{" + Integer.toString(_4a) + "}{" + Integer.toString(_4b) + "} ) \\div "
						+ "\\frac{"+ Integer.toString(_4c) + "}{"+ Integer.toString(_4d)+ "}" + "$";
		answer4 = result4.toString();

		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.DIVIDE__FOLLOWING_FRACTIONS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question4 ));

		String heading = mSource.getMessage(GR7_Constants.DIVIDE_FRACTIONS, null, Locale.ENGLISH);
		answ.setAnswer(answer4);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question5="";
		String answer5="";
		
		int _5a = 5* MathUtilities.getRandomNumber(1,20), _5b = 2* MathUtilities.getRandomNumber(1,20);
		int _5c = 5* MathUtilities.getRandomNumber(1,10), _5d= 2* MathUtilities.getRandomNumber(1,20);
		Fraction frac5a = new Fraction(_5a, _5b);
		Fraction frac5b = new Fraction(_5c, _5d);
				
		Fraction result5 = frac5a.divide(frac5b);

		question5= "$" +"(-\\frac{" + Integer.toString(_5a) + "}{" + Integer.toString(_5b) + "} ) \\div "
						+ "(-\\frac{"+ Integer.toString(_5c) + "}{"+ Integer.toString(_5d)+ "})" + "$";
		answer5 = result5.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.DIVIDE__FOLLOWING_FRACTIONS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question5));
		
		String heading = mSource.getMessage(GR7_Constants.DIVIDE_FRACTIONS, null, Locale.ENGLISH);
		answ.setAnswer(answer5);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem7(MathConfiguration mathConfig, int i) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question6="";
		String answer6="";
		
		int _6a = 2* MathUtilities.getRandomNumber(1,20), _6b= 5* MathUtilities.getRandomNumber(1,20);
		int _6c = 5* MathUtilities.getRandomNumber(1,10), _6d= 2* MathUtilities.getRandomNumber(1,20);
		int _6e = 5* MathUtilities.getRandomNumber(1,10), _6f= 2* MathUtilities.getRandomNumber(1,20);
		
		Fraction frac6a = new Fraction(_6a, _6b);
		Fraction frac6b = new Fraction(_6c, _6d);
		Fraction frac6c = new Fraction(_6e, _6f);
				
		Fraction result6 = frac6a.divide(frac6b).multiply(frac6c);

		question6 = "$" +"\\frac{" + Integer.toString(_6a) + "}{" + Integer.toString(_6b) + "} \\div "
						+ "\\frac{"+ Integer.toString(_6c) + "}{"+ Integer.toString(_6d)+ "} \\times" 
						+ "\\frac{"+ Integer.toString(_6e) + "}{"+ Integer.toString(_6f)+ "}"  + "$";
		answer6 = result6.toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.DIVIDE__FOLLOWING_FRACTIONS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question6));

		String heading = mSource.getMessage(GR7_Constants.DIVIDE_FRACTIONS, null, Locale.ENGLISH);
		answ.setAnswer(answer6);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}

}