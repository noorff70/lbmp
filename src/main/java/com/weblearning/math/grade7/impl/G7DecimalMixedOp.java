package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

public class G7DecimalMixedOp extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7DecimalMixed = new ArrayList<Problem>();


		for (int i = 0; i < 1; i++)
			g7DecimalMixed.add(getProblem1(mathConfig));
		for (int i = 0; i < 2; i++)
			g7DecimalMixed.add(getProblem2(mathConfig));
		for (int i = 0; i < 1; i++)
			g7DecimalMixed.add(getProblem3(mathConfig));
		for (int i = 0; i < 1; i++)
			g7DecimalMixed.add(getProblem4(mathConfig));
		

		return g7DecimalMixed;
	}

	
	public Problem getProblem1(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";

		
		question1 = "$" + Double.toString(4.5) + "\\div" + Double.toString(1.5) + " - " + Double.toString(2.2) + "\\times" + Double.toString(1.1) + "$"; 
		question2 = "$" + Double.toString(4.5) + " - " + Double.toString(1.5) + " - " + Double.toString(2.2) + "\\times" + Double.toString(1.1) + "$";
		question3 = "$" + "-( " + Double.toString(4.5) + " - " + Double.toString(1.5) + " ) " + " - " + Double.toString(2.2) + "\\times" + Double.toString(1.1) + "$" ;
		question4 = "$(- "+ Double.toString(1.5) + " )(-" + Double.toString(1.5) + " )" + " + " + Double.toString(2.5) + "$"; 
		question5 = "$"+ Double.toString(2.5) + "\\div(" + Double.toString(4.5) + " + "+ Double.toString(5.5) + ")$";
		
		answer1 = ".58";
		answer2 = ".58";
		answer3 ="-5.42";
		answer4 = "4.75";
		answer5 = ".25";

		String heading = mSource.getMessage(Constants.GRADE_7_MULTIPLY_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH) + " " +
				mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
		

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		BigDecimal bga = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1, RoundingMode.HALF_UP);
		BigDecimal bgb = new BigDecimal((double)MathUtilities.getRandomNumber(12, 18)/ 10).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bgc = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 100).setScale(2,  RoundingMode.HALF_UP);
		BigDecimal bgd = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		BigDecimal bge = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		BigDecimal bgf = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		BigDecimal bgg = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		
		//(2.5+1.2)/3.2=
		BigDecimal bg1Ans = new BigDecimal(0);
		bg1Ans = bg1Ans.add(bga).add(bgb).setScale(2, RoundingMode.HALF_UP);
		bg1Ans = (bg1Ans.divide(bgc, 2, RoundingMode.HALF_UP)) ;
		question1 = "$(" + bga.toString() + " + " + bgb.toString() + ")\\div " + bgc.toString() + "$"; 
		answer1 = bg1Ans.toString();

		//2.5 + 1.2/ 3.2 =
		BigDecimal bg2Ans = new BigDecimal(1);
		bg2Ans = bg2Ans.multiply(bgb).divide(bgc, 2, RoundingMode.HALF_UP).add(bga).setScale(2, RoundingMode.HALF_UP);
		question2 = "$" + bga.toString() + " + " + bgb.toString() + "\\div" + bgc.toString() + "$";
		answer2 = bg2Ans.toString();
		
		//(2.5+1.12) /3.2 * 1.2
		BigDecimal bg3Ans = new BigDecimal(0);
		bg3Ans = bg3Ans.add(bgd).add(bge).divide(bgf, 2, RoundingMode.HALF_UP).multiply(bgg);
		question3 = "$(" + bgd.toString() + " + " + bge.toString() + ")" + "\\div" + bgf.toString() + "\\times" + bgg.toString() + "$"; 
		answer3 = bg3Ans.toString();
		
		// -(4.5 -1.5) - 2.2 * 1.1
		BigDecimal bg4Ans = new BigDecimal(-1);
		BigDecimal bgAnsPart1 = bgb.subtract(bgc);
		bg4Ans = bgAnsPart1.multiply(bg4Ans);
		BigDecimal bgAnsPart2 = bge.multiply(bgf);
		bg4Ans = bg4Ans.subtract(bgAnsPart2).setScale(2, RoundingMode.HALF_UP);
		question4 = "$-(" + bgb.toString()  +  " - " + bgc.toString() + ")" + " - " + bge.toString() + "\\times" + bgf.toString()  +"$";
		answer4 = bg4Ans.toString();
		
		// -(-4.5 -1.5) - 2.2 * 1.1
		BigDecimal bg5Ans = new BigDecimal(-1);
		BigDecimal bg5nsPart1 = bgb.multiply(BigDecimal.valueOf(-1)).subtract(bga);
		bg5Ans = bg5nsPart1.multiply(bg5Ans);
		BigDecimal bgAns5Part2 = bgd.multiply(bge);
		bg5Ans = bg5Ans.subtract(bgAns5Part2).setScale(2, RoundingMode.HALF_UP);
		question5 = "$-(-" + bgb.toString()  +  " - " + bga.toString() + ")" + " - " + bgd.toString() + "\\times" + bge.toString()  +"$";
		answer5 = bg5Ans.toString();
		String heading = mSource.getMessage(Constants.GRADE_7_MULTIPLY_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		
		
		questionList.add(new QuestionLine( mSource.getMessage(Constants.EVALUATE_THE_FOLLOWING, null, Locale.ENGLISH) + "  " + 
				mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		BigDecimal bga = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1, RoundingMode.HALF_UP);
		BigDecimal bgb = new BigDecimal((double)MathUtilities.getRandomNumber(12, 18)/ 10).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bgc = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 100).setScale(2,  RoundingMode.HALF_UP);
		BigDecimal bgd = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		BigDecimal bge = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		BigDecimal bgf = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		BigDecimal bgg = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		
		BigDecimal bgh = new BigDecimal(3.5);
		BigDecimal bgi = new BigDecimal(2.5);
		BigDecimal bgj = new BigDecimal(.5);
		BigDecimal bgk = new BigDecimal(.05);
		
		//a + box + c = d
		BigDecimal bg1Ans = new BigDecimal(0);
		bg1Ans = bg1Ans.add(bga).add(bgb).add(bgc).setScale(2, RoundingMode.HALF_UP);
		question1 = "$" + bga.toString() + " + \\Box + " + bgc.toString() + " = "+ bg1Ans.toString() + "$"; 
		answer1 = bgb.toString();

		//a - box + c = d
		BigDecimal bg2Ans = new BigDecimal(0);
		bg2Ans = bg2Ans.add(bge).subtract(bgf).add(bgg).setScale(2, RoundingMode.HALF_UP);
		question2 = "$" + bge.toString() + " - \\Box + " + bgg.toString() + " = "+ bg2Ans.toString() + "$"; 
		answer2 = bgf.toString();
		
		// (a- b) * box = d
		BigDecimal bg3Ans = new BigDecimal(0);
		bg3Ans = bg3Ans.add(bgh).subtract(bgi).multiply(bgj).setScale(2, RoundingMode.HALF_UP);
		question3 = "$(" + bgh.toString() + " - " + bgi.toString() + ") \\times \\Box = "+ bg3Ans.toString() + "$"; 
		answer3 = bgj.toString();
		
		// (a- b) / box = d
		BigDecimal bg4Ans = new BigDecimal(0);
		bg4Ans = bg4Ans.add(bgi).subtract(bgj).divide(bgk, 2, RoundingMode.HALF_UP);
		question4 = "$(" + bgi.toString() + " - " + bgj.toString() + ")" + "  \\div"  + " \\Box = "+ bg4Ans.toString() + "$"; 
		answer4 = bgk.toString();
		
		//box + a + c = d
		BigDecimal bg5Ans = new BigDecimal(0);
		bg5Ans = bg5Ans.add(bgb).add(bgd).add(bge).setScale(2, RoundingMode.HALF_UP);
		question5 = "$" + "\\Box  + " + bgd.toString() + " + " + bge.toString() + " = "+ bg5Ans.toString() + "$"; 
		answer5 = bgb.toString();
		
		
		String heading = mSource.getMessage(Constants.GRADE_7_MULTIPLY_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH) + " " +
				mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String  question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		BigDecimal bga = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1, RoundingMode.HALF_UP);
		BigDecimal bgb = new BigDecimal((double)MathUtilities.getRandomNumber(12, 18)/ 10).setScale(2, RoundingMode.HALF_UP);
		BigDecimal bgc = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 100).setScale(2,  RoundingMode.HALF_UP);
		BigDecimal bgd = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		BigDecimal bge = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		BigDecimal bgf = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		BigDecimal bgg = new BigDecimal((double)MathUtilities.getRandomNumber(1, 9)/ 10).setScale(1,  RoundingMode.HALF_UP);
		
		BigDecimal bgh = new BigDecimal(MathUtilities.getRandomNumber(2, 10));
		BigDecimal bgi = new BigDecimal(MathUtilities.getRandomNumber(2, 10));
		BigDecimal bgj = new BigDecimal(MathUtilities.getRandomNumber(2, 10));
		BigDecimal bgk = new BigDecimal(MathUtilities.getRandomNumber(2, 10));
		
		// -(a- b) / box = d
		BigDecimal bg1Ans = new BigDecimal(0);
		bg1Ans = bg1Ans.add(bgc).subtract(bgd).divide(bgk, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(1));
		question1 = "$-(" + bgc.toString() + " - " + bgd.toString() + ")" + "  \\div"  + " \\Box = "+ bg1Ans.toString() + "$"; 
		answer1 = bgk.toString();

		//a - box + c = d
		BigDecimal bg2Ans = new BigDecimal(0);
		bg2Ans = bg2Ans.add(bge).subtract(bgf).add(bgg).setScale(2, RoundingMode.HALF_UP);
		question2 = "$" + bge.toString() + " - \\Box + " + bgg.toString() + " = "+ bg2Ans.toString() + "$"; 
		answer2 = bgf.toString();
		
		// (a- b) * box = d
		BigDecimal bg3Ans = new BigDecimal(0);
		bg3Ans = bg3Ans.add(bga).subtract(bgb).multiply(bgi).setScale(2, RoundingMode.HALF_UP);
		question3 = "$(" + bga.toString() + " - " + bgb.toString() + ") \\times \\Box = "+ bg3Ans.toString() + "$"; 
		answer3 = bgi.toString();
		
		// (a- b) / box = d
		BigDecimal bg4Ans = new BigDecimal(0);
		bg4Ans = bg4Ans.add(bgc).subtract(bgd).divide(bgj, 2, RoundingMode.HALF_UP);
		question4 = "$(" + bgc.toString() + " - " + bgd.toString() + ")" + "  \\div"  + " \\Box = "+ bg4Ans.toString() + "$"; 
		answer4 = bgj.toString();
		
		//box + a + c = d
		BigDecimal bg5Ans = new BigDecimal(0);
		bg5Ans = bg5Ans.add(bgb).add(bgd).add(bge).setScale(2, RoundingMode.HALF_UP);
		question5 = "$" + "\\Box  + " + bgd.toString() + " + " + bge.toString() + " = "+ bg5Ans.toString() + "$"; 
		answer5 = bgb.toString();
		
		
		String heading = mSource.getMessage(Constants.GRADE_7_MULTIPLY_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.FIND_THE_VALUE_OF_THE_BOX, null, Locale.ENGLISH) + " " +
				mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 + Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 + Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 + Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	

}
