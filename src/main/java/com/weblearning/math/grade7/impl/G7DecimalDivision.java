package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.Locale;

//import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
//import com.weblearning.math.grade7.utilities.GR7_Constants;
//import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7DecimalDivision extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7DecimalDivision = new ArrayList<Problem>();
		
		g7DecimalDivision.add(getProblem1(mathConfig));
		g7DecimalDivision.add(getProblem2(mathConfig));
		g7DecimalDivision.add(getProblem3(mathConfig));
		g7DecimalDivision.add(getProblem4(mathConfig));
		g7DecimalDivision.add(getProblem5(mathConfig));
		g7DecimalDivision.add(getProblem6(mathConfig));
		g7DecimalDivision.add(getProblem7(mathConfig));
		g7DecimalDivision.add(getProblem8(mathConfig));
		g7DecimalDivision.add(getProblem9(mathConfig));
		g7DecimalDivision.add(getProblem10(mathConfig));

		return g7DecimalDivision;
	}

	/*
	 * Subtract Decimals
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="";
		String answer1="", answer2="", answer3="", answer4="";
		
		double randomnumber = 32.18;
		
		//find the base
		double _1a = randomnumber;
		int _1b = 10;
	//	BigDecimal _1c = new BigDecimal((double)_1a/_1b).setScale(2, RoundingMode.HALF_UP);
		
		question1 = "$" + Double.toString(_1a) + "\\div" + Integer.toString(_1b) + "$" ;
		answer1 = "3.218"; 
		
		//find the power
		double _2a = randomnumber;
		int _2b = 100;
	//	BigDecimal _2c = new BigDecimal((double)_2a/_2b).setScale(2, RoundingMode.HALF_UP);
		
		question2 = "$" + Double.toString(_2a) + "\\div" + Integer.toString(_2b) + "$" ;
		answer2 = ".3218";
		
		//find the power
		double _3a = randomnumber;
		double _3b = 1000;
	//	BigDecimal _3c = new BigDecimal((double)_3a/_3b).setScale(3, RoundingMode.HALF_UP);
		
		question3 = "$" + Double.toString(_3a) + "\\div" + Double.toString(_3b) + "$" ;
		answer3 = ".03218";	
		
		double _4a = randomnumber;
		int _4b = 10000;
	//	BigDecimal _4c = new BigDecimal((double)_4a/_4b).setScale(4, RoundingMode.HALF_UP);
		
		question4 = "$" + Double.toString(_4a) + "\\div" + Integer.toString(_4b) + "$" ;
		answer4 = ".003218";
		
		questionList.add(new QuestionLine( "Divide decimals and no rounding"));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = "Learn and review decimal Divisions";
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

		String question1="", question2="", question3="", question4="";
		String answer1="", answer2="", answer3="", answer4="";
		
		double randomnumber = 32.18;
		
		//find the base
		double _1a = randomnumber;
		int _1b = 10;
		BigDecimal _1c = new BigDecimal((double)_1a/_1b).setScale(2, RoundingMode.HALF_UP);
		
		question1 = "$" + Double.toString(_1a) + "\\div" + Integer.toString(_1b) + "$" ;
		answer1 = _1c.toString(); 
		
		//find the power
		double _2a = randomnumber;
		int _2b = 100;
		BigDecimal _2c = new BigDecimal((double)_2a/_2b).setScale(2, RoundingMode.HALF_UP);
		
		question2 = "$" + Double.toString(_2a) + "\\div" + Integer.toString(_2b) + "$" ;
		answer2 = _2c.toString();
		
		//find the power
		double _3a = randomnumber;
		double _3b = 1000;
		BigDecimal _3c = new BigDecimal((double)_3a/_3b).setScale(2, RoundingMode.HALF_UP);
		
		question3 = "$" + Double.toString(_3a) + "\\div" + Double.toString(_3b) + "$" ;
		answer3 = _3c.toString();	
		
		double _4a = randomnumber;
		int _4b = 10000;
		BigDecimal _4c = new BigDecimal((double)_4a/_4b).setScale(2, RoundingMode.HALF_UP);
		
		question4 = "$" + Double.toString(_4a) + "\\div" + Integer.toString(_4b) + "$" ;
		answer4 = _4c.toString();
		
		questionList.add(new QuestionLine( "Divide decimals and two decimals rounding"));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = "Learn and review decimal Divisions";
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

		String question1="", question2="", question3="", question4="";
		String answer1="", answer2="", answer3="", answer4="";
		
		//double randomnumber = 32.18;
		
		//find the base
		double _1a = .2;
		int _1b = 5;
		BigDecimal _1c = new BigDecimal((double)_1a/_1b).setScale(2, RoundingMode.HALF_UP);
		
		question1 = "$" + Double.toString(_1a) + "\\div" + Integer.toString(_1b) + "$" ;
		answer1 = _1c.toString(); 
		
		//find the power
		double _2a = 1.05;
		int _2b = 15;
		BigDecimal _2c = new BigDecimal((double)_2a/_2b).setScale(2, RoundingMode.HALF_UP);
		
		question2 = "$" + Double.toString(_2a) + "\\div" + Integer.toString(_2b) + "$" ;
		answer2 = _2c.toString();
		
		//find the power
		double _3a = .64;
		double _3b = 8;
		BigDecimal _3c = new BigDecimal((double)_3a/_3b).setScale(2, RoundingMode.HALF_UP);
		
		question3 = "$" + Double.toString(_3a) + "\\div" + Double.toString(_3b) + "$" ;
		answer3 = _3c.toString();	
		
		double _4a = .56;
		int _4b = 14;
		BigDecimal _4c = new BigDecimal((double)_4a/_4b).setScale(2, RoundingMode.HALF_UP);
		
		question4 = "$" + Double.toString(_4a) + "\\div" + Integer.toString(_4b) + "$" ;
		answer4 = _4c.toString();
		
		questionList.add(new QuestionLine( "Divide decimals and two decimals rounding"));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = "Learn and review decimal Divisions";
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

		String question1="", question2="", question3="", question4="";
		String answer1="", answer2="", answer3="", answer4="";
		
		//double randomnumber = 32.18;
		
		//find the base
		int _1a = 5;
		double _1b = .2;
		BigDecimal _1c = new BigDecimal((double)_1a/_1b).setScale(2, RoundingMode.HALF_UP);
		
		question1 = "$" + Integer.toString(_1a) + "\\div" + Double.toString(_1b) + "$" ;
		answer1 = _1c.toString(); 
		
		//find the power
		int _2a = 15;
		double _2b = .03;
		BigDecimal _2c = new BigDecimal((double)_2a/_2b).setScale(2, RoundingMode.HALF_UP);
		
		question2 = "$" + Integer.toString(_2a) + "\\div" + Double.toString(_2b) + "$" ;
		answer2 = _2c.toString();
		
		//find the power
		int _3a = 64;
		double _3b = .8;
		BigDecimal _3c = new BigDecimal((double)_3a/_3b).setScale(2, RoundingMode.HALF_UP);
		
		question3 = "$" + Integer.toString(_3a) + "\\div" + Double.toString(_3b) + "$" ;
		answer3 = _3c.toString();	
		
		int _4a = 125;
		double _4b = .05;
		BigDecimal _4c = new BigDecimal((double)_4a/_4b).setScale(2, RoundingMode.HALF_UP);
		
		question4 = "$" + Integer.toString(_4a) + "\\div" + Double.toString(_4b) + "$" ;
		answer4 = _4c.toString();
		
		questionList.add(new QuestionLine( "Divide decimals and two decimals rounding"));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = "Learn and review decimal Divisions";
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="";
		String answer1="", answer2="", answer3="", answer4="";
		
		//double randomnumber = 32.18;
		
		//find the base
		double _1a = .05;
		double _1b = .2;
		BigDecimal _1c = new BigDecimal((double)_1a/_1b).setScale(2, RoundingMode.HALF_UP);
		
		question1 = "$" + Double.toString(_1a) + "\\div" + Double.toString(_1b) + "$" ;
		answer1 = _1c.toString(); 
		
		//find the power
		double _2a = 1.5;
		double _2b = .03;
		BigDecimal _2c = new BigDecimal((double)_2a/_2b).setScale(2, RoundingMode.HALF_UP);
		
		question2 = "$" + Double.toString(_2a) + "\\div" + Double.toString(_2b) + "$" ;
		answer2 = _2c.toString();
		
		//find the power
		double _3a = 6.4;
		double _3b = .8;
		BigDecimal _3c = new BigDecimal((double)_3a/_3b).setScale(2, RoundingMode.HALF_UP);
		
		question3 = "$" + Double.toString(_3a) + "\\div" + Double.toString(_3b) + "$" ;
		answer3 = _3c.toString();	
		
		double _4a = .125;
		double _4b = .05;
		BigDecimal _4c = new BigDecimal((double)_4a/_4b).setScale(2, RoundingMode.HALF_UP);
		
		question4 = "$" + Double.toString(_4a) + "\\div" + Double.toString(_4b) + "$" ;
		answer4 = _4c.toString();
		
		questionList.add(new QuestionLine( "Divide decimals and two decimals rounding"));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = "Learn and review decimal Divisions";
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		//double randomnumber = 32.18;
		
		//find the base
		double a = .05;
		double b = .06;
		double c = .6;
		
		
		question = "$" + Double.toString(a) + "\\times" + Double.toString(b) + "\\over" + Double.toString(c) +  "$" ;
		String answer = ".005"; 
		
				
		questionList.add(new QuestionLine( "Divide decimals"));
		questionList.add(new QuestionLine(question, null, Constants.DEFAULT));
		
		String heading = "Learn and review decimal Divisions";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem7(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		//double randomnumber = 32.18;
		
		//find the base
		double a = -.2;
		double b = .3;
		double c = 5;
		double d = 1.5;
		
		
		question = "$" + Double.toString(b) + "\\times(" + Double.toString(a) + ") \\times" + Double.toString(c) + "\\over" + Double.toString(d) +  "$" ;
		String answer = "-.2"; 
		
				
		questionList.add(new QuestionLine( "Divide decimals"));
		questionList.add(new QuestionLine(question, null, Constants.DEFAULT));
		
		String heading = "Learn and review decimal Divisions";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		//double randomnumber = 32.18;
		
		//find the base
		double a = -.4;
		double b = -.3;
		double c = 5;
		double d = 1.5;
		
		
		question = "$" + Double.toString(b) + "\\times(" + Double.toString(a) + ") \\times" + Double.toString(c) + "\\over" + Double.toString(d) +  "$" ;
		String answer = ".4"; 
		
				
		questionList.add(new QuestionLine( "Divide decimals"));
		questionList.add(new QuestionLine(question, null, Constants.DEFAULT));
		
		String heading = "Learn and review decimal Divisions";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	
	public Problem getProblem9(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		//double randomnumber = 32.18;
		
		//find the base
		double a = 1.2;
		double b = 3.6;
		double c = .6;
		double d = .4;
		
		
		question = "$" + Double.toString(a) + "\\times" + Double.toString(b) +  
				"\\over" + Double.toString(c) + "\\times"+ Double.toString(d)+ "$" ;
		String answer = "18"; 
		
				
		questionList.add(new QuestionLine( "Divide decimals"));
		questionList.add(new QuestionLine(question, null, Constants.DEFAULT));
		
		String heading = "Learn and review decimal Divisions";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem10(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
	//	MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		//double randomnumber = 32.18;
		
		//find the base
		double a = 1.2;
		double b = 1.2*5;
		double c = .6;
		double d = .2;
		
		
		question = "$" + Double.toString(a) + "\\times" + Double.toString(b) +  
				"\\over" + Double.toString(c) + "\\times"+ Double.toString(d)+ "$" ;
		String answer = "60"; 
		
				
		questionList.add(new QuestionLine( "Divide decimals"));
		questionList.add(new QuestionLine(question, null, Constants.DEFAULT));
		
		String heading = "Learn and review decimal Divisions";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	
	

}
