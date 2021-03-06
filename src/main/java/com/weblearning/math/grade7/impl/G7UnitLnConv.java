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

public class G7UnitLnConv extends GenericQuestion{
	
	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7UnitLnConv = new ArrayList<Problem>();
		
		g7UnitLnConv.add(getProblem1(mathConfig));
		g7UnitLnConv.add(getProblem2(mathConfig));
		g7UnitLnConv.add(getProblem3(mathConfig));
		g7UnitLnConv.add(getProblem4(mathConfig));
		g7UnitLnConv.add(getProblem5(mathConfig));
		g7UnitLnConv.add(getProblem6(mathConfig));
		g7UnitLnConv.add(getProblem7(mathConfig));
	//	g7UnitLnConv.add(getProblem8(mathConfig));
	//	g7UnitLnConv.add(getProblem5(mathConfig));
	//	g7UnitLnConv.add(getProblem7(mathConfig));
		
		return g7UnitLnConv;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		BigDecimal km = new BigDecimal((double)MathUtilities.getRandomNumber(12, 49)/ 100).setScale(2, RoundingMode.HALF_UP);
		
		question1= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.HECTOMETER, null, Locale.ENGLISH);
		question2= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.DECAMETER, null, Locale.ENGLISH);
		question3= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.METER, null, Locale.ENGLISH);
		question4= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.DECIMETER, null, Locale.ENGLISH);
		question5= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.CENTIMETER, null, Locale.ENGLISH);
	//	question6= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.MILIMETER, null, Locale.ENGLISH);
		
		answer1 = km.multiply(new BigDecimal(10)).toString();
		answer2 = km.multiply(new BigDecimal(100)).toString();
		answer3 = km.multiply(new BigDecimal(1000)).toString();
		answer4 = km.multiply(new BigDecimal(10000)).toString();
		answer5 = km.multiply(new BigDecimal(100000)).toString();
	//	answer6 = km.multiply(new BigDecimal(1000000)).toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+" " + km.toString() + " Kilometer " + "to the Following" , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
	//	questionList.add(new QuestionLine( question6 +	Constants.ANSWER_TO_QUESTION + answer6 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		BigDecimal mm = new BigDecimal((double)MathUtilities.getRandomNumber(15000, 45000));
		
		//question6= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.KILOMETER, null, Locale.ENGLISH);
		question5= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.HECTOMETER, null, Locale.ENGLISH);
		question4= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.DECAMETER, null, Locale.ENGLISH);
		question3= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.METER, null, Locale.ENGLISH);
		question2= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.DECIMETER, null, Locale.ENGLISH);
		question1= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.CENTIMETER, null, Locale.ENGLISH);

		answer1 = mm.divide(new BigDecimal(10)).toString();
		answer2 = mm.divide(new BigDecimal(100)).toString();
		answer3 = mm.divide(new BigDecimal(1000)).toString();
		answer4 = mm.divide(new BigDecimal(10000)).toString();
		answer5 = mm.divide(new BigDecimal(100000)).toString();
		//answer6 = mm.divide(new BigDecimal(1000000)).toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+" " + mm.toString() + " Milimeter " + "to the Following" , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		//questionList.add(new QuestionLine( question6 +	Constants.ANSWER_TO_QUESTION + answer6 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		BigDecimal m = new BigDecimal((double)MathUtilities.getRandomNumber(1500, 4500));
		
		question1= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.KILOMETER, null, Locale.ENGLISH);
		question2= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.HECTOMETER, null, Locale.ENGLISH);
		question3= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.DECAMETER, null, Locale.ENGLISH);
		question4= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.DECIMETER, null, Locale.ENGLISH);
		question5= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.CENTIMETER, null, Locale.ENGLISH);
		//question6= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.MILIMETER, null, Locale.ENGLISH);

		
		answer1 = m.divide(new BigDecimal(1000)).toString();
		answer2 = m.divide(new BigDecimal(100)).toString();
		answer3 = m.divide(new BigDecimal(10)).toString();
		answer4 = m.multiply(new BigDecimal(10)).toString();
		answer5 = m.multiply(new BigDecimal(100)).toString();
		//answer6 = m.multiply(new BigDecimal(1000)).toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+" " + m.toString() + " Meter " + "to the Following" , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		//questionList.add(new QuestionLine( question6 +	Constants.ANSWER_TO_QUESTION + answer6 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		int _1m= MathUtilities.getRandomNumber(5, 20);
		int _1cm= MathUtilities.getRandomNumber(1, 10);
		answer1 = Integer.toString(_1m*1000+_1cm*10);
		
		double _2mm = MathUtilities.getRandomNumber(100, 500);
		double _2cm = MathUtilities.getRandomNumber(100, 500);
		double _2decim = MathUtilities.getRandomNumber(100, 500);
		answer2 = new BigDecimal(_2mm/1000 + _2cm/100 + _2decim/10).setScale(2, RoundingMode.HALF_UP).toString();
		
		double _3km = MathUtilities.getRandomNumber(1, 5);
		double _3cm = MathUtilities.getRandomNumber(1000, 5000);
		answer3 = new BigDecimal(_3km*1000 + _3cm/100).setScale(2, RoundingMode.HALF_UP).toString();
		
		double _4deca = MathUtilities.getRandomNumber(1, 5);
		double _4deci = MathUtilities.getRandomNumber(10, 50);
		answer4 = new BigDecimal(_4deca*10 + _4deci/10).setScale(2, RoundingMode.HALF_UP).toString();
		
		double _5cm = MathUtilities.getRandomNumber(10000, 50000);
		double _5m = MathUtilities.getRandomNumber(1000, 5000);
		double _5km = MathUtilities.getRandomNumber(1, 5);
		answer5 = new BigDecimal(_5cm/100000+ _5m/1000+ _5km).setScale(2, RoundingMode.HALF_UP).toString();
		
		question1= "Convert " + Integer.toString(_1m) + " m " + Integer.toString(_1cm) + " cm  to milimeter";
		question2= "Convert " + Double.toString(_2decim) + " decimeter " + Double.toString(_2cm) + " cm " + Double.toString(_2mm) + " mm to meter";
		question3= "Convert " + Double.toString(_3km) + " km " + Double.toString(_3cm) + " cm to meter";
		question4= "Convert " + Double.toString(_4deca) + " decameter " + Double.toString(_4deci) + " decimeter to meter" ;
		question5= "Convert " + Integer.valueOf((int)_5km)+ " km " + Integer.valueOf((int)_5m) + " m " + Integer.toString((int)_5cm) + " cm to km";
		
	
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+" " + "to the Following. Round upto 2 decimals" , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		BigDecimal km = new BigDecimal((double)MathUtilities.getRandomNumber(1, 18)/ 10).setScale(2, RoundingMode.HALF_UP);
		
		question= mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH) + " " + km.toString() + " " 
				+ mSource.getMessage(GR7_Constants.KILOMETER, null, Locale.ENGLISH) + " to " + mSource.getMessage(GR7_Constants.CENTIMETER, null, Locale.ENGLISH);
		answer = km.multiply(new BigDecimal(100000)).toString();
			
		
		questionList.add(new QuestionLine(question));
		
		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		BigDecimal km = new BigDecimal((double)MathUtilities.getRandomNumber(1, 18)/ 10).setScale(2, RoundingMode.HALF_UP);
		
		question= mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH) + " " + km.toString() + " " 
				+ mSource.getMessage(GR7_Constants.KILOMETER, null, Locale.ENGLISH) + " to " + mSource.getMessage(GR7_Constants.DECIMETER, null, Locale.ENGLISH);
		answer = km.multiply(new BigDecimal(10000)).toString();
			
		
		questionList.add(new QuestionLine(question));
		
		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem7(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		BigDecimal cm = new BigDecimal((double)MathUtilities.getRandomNumber(15000, 45000));
		
		question= mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH) + " " + cm.toString() + " " 
				+ mSource.getMessage(GR7_Constants.CENTIMETER, null, Locale.ENGLISH) + " to " + mSource.getMessage(GR7_Constants.HECTOMETER, null, Locale.ENGLISH);
		answer = cm.divide(new BigDecimal(10000)).toString();
			
		
		questionList.add(new QuestionLine(question));
		
		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		BigDecimal hm = new BigDecimal((double)MathUtilities.getRandomNumber(1, 18)/ 10).setScale(2, RoundingMode.HALF_UP);
		
		question= mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH) + " " + hm.toString() + " " 
				+ mSource.getMessage(GR7_Constants.HECTOMETER, null, Locale.ENGLISH) + " to " + mSource.getMessage(GR7_Constants.DECAMETER, null, Locale.ENGLISH);
		answer = hm.divide(new BigDecimal(10)).toString();
			
		
		questionList.add(new QuestionLine(question));
		
		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem9(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		BigDecimal m = new BigDecimal((double)MathUtilities.getRandomNumber(150, 450));
		
		question= mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH) + " " + m.toString() + " " 
				+ mSource.getMessage(GR7_Constants.METER, null, Locale.ENGLISH) + " to " + mSource.getMessage(GR7_Constants.DECIMETER, null, Locale.ENGLISH);
		answer = m.divide(new BigDecimal(10)).toString();
			
		
		questionList.add(new QuestionLine(question));
		
		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	

}
