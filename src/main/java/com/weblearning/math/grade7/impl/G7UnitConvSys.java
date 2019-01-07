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

public class G7UnitConvSys extends GenericQuestion{
	
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
		g7UnitLnConv.add(getProblem8(mathConfig));
		g7UnitLnConv.add(getProblem9(mathConfig));
		g7UnitLnConv.add(getProblem10(mathConfig));
		g7UnitLnConv.add(getProblem11(mathConfig));
		g7UnitLnConv.add(getProblem6(mathConfig));
		g7UnitLnConv.add(getProblem7(mathConfig));

		
		return g7UnitLnConv;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		int mile = MathUtilities.getRandomNumber(1,10);
		int inch = mile*1760*3*12;
		BigDecimal cm = new BigDecimal((double)inch*2.54).setScale(2, RoundingMode.HALF_UP);
		
		question1= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.YARD, null, Locale.ENGLISH);
		question2= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.FEET, null, Locale.ENGLISH);
		question3= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.KILOMETER, null, Locale.ENGLISH);
		question4= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.METER, null, Locale.ENGLISH);
		question5= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.MILIMETER, null, Locale.ENGLISH);
		
		answer1 = Integer.toString(mile*1760);
		answer2 = Integer.toString(mile*1760*3);
		answer3 = cm.divide(new BigDecimal(100000)).setScale(2, RoundingMode.HALF_UP).toString();
		answer4 = cm.divide(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP).toString();
		answer5 = cm.multiply(new BigDecimal(10)).setScale(2, RoundingMode.HALF_UP).toString();

		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+" " + Integer.toString(mile) + " Miles " + "to the Following" , null, Constants.DEFAULT
				+ mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH)));
		
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));


		String heading = mSource.getMessage(GR7_Constants.CONVERSION_OF_UNITS, null, Locale.ENGLISH);
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
		
		int cm = MathUtilities.getRandomNumber(15000, 45000);
		BigDecimal inch = new BigDecimal((double)cm/2.54).setScale(2, RoundingMode.HALF_UP);
		
		question1= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.INCH, null, Locale.ENGLISH);
		question2= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.FEET, null, Locale.ENGLISH);
		question3= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.YARD, null, Locale.ENGLISH);
		question4= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.MILE, null, Locale.ENGLISH);
		question5= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.METER, null, Locale.ENGLISH);
		
		answer1 = inch.setScale(2, RoundingMode.HALF_UP).toString();
		answer2 = new BigDecimal((double)cm /(2.54*12)).setScale(2, RoundingMode.HALF_UP).toString();
		answer3 = new BigDecimal((double)cm /(2.54*12*3)).setScale(2, RoundingMode.HALF_UP).toString();
		answer4 = new BigDecimal((double)cm /(2.54*12*3*1760)).setScale(2, RoundingMode.HALF_UP).toString();
		answer5 = new BigDecimal((double)cm/100).setScale(2, RoundingMode.HALF_UP).toString();

		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+" " + Integer.toString(cm) + " Centemeter " + "to the Following" , null, Constants.DEFAULT
				+ " " +mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH)));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));


		String heading = mSource.getMessage(GR7_Constants.CONVERSION_OF_UNITS, null, Locale.ENGLISH);
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

		String question1="", question2="", question3="";
		String answer1="", answer2="", answer3="";
		
		int kg = MathUtilities.getRandomNumber(150, 450);
		int gm = kg*1000;
		
		question1= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.GRAM, null, Locale.ENGLISH);
		question2= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.OUNCE, null, Locale.ENGLISH);
		question3= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.POUND, null, Locale.ENGLISH);
		
		answer1 = Integer.toString(gm);
		answer2 = new BigDecimal((double)gm/23.35).setScale(2, RoundingMode.HALF_UP).toString(); // 1 ounce = 23.35 gms
		answer3 = new BigDecimal(kg*2.2).setScale(2, RoundingMode.HALF_UP).toString(); // 1 kg = 2.2 pounds
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+" " + Integer.toString(kg) + " Kilo Gram " + "to the Following. (1 ounce = 23.35 gms, 1 kg = 2.2 lbs)" , null, Constants.DEFAULT
				+ " " + mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH)));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.CONVERSION_OF_UNITS, null, Locale.ENGLISH);
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

		String question1="", question2="", question3="";
		String answer1="", answer2="", answer3="";
		
		int lbs = MathUtilities.getRandomNumber(150, 450);
		BigDecimal kg = new BigDecimal((double)lbs/2.2).setScale(2, RoundingMode.HALF_UP);
		BigDecimal g = new BigDecimal((double)(lbs*1000)/2.2).setScale(2, RoundingMode.HALF_UP);
		BigDecimal ounce = new BigDecimal((double)16*lbs).setScale(2,  RoundingMode.HALF_UP);
		
		question1= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.GRAM, null, Locale.ENGLISH);
		question2= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.OUNCE, null, Locale.ENGLISH);
		question3= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.KILOGRAM, null, Locale.ENGLISH);
		
		answer1 = g.toString();
		answer2 = ounce.toString(); // 16 ounce = 1 lbs
		answer3 = kg.toString(); // 1 kg = 2.2 pounds
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+" " + Integer.toString(lbs) + " Pound " + "to the Following (16 ounce = 1 lbs, 1 kg = 2.2 lbs)" , null, Constants.DEFAULT
				+ " " + mSource.getMessage(GR7_Constants.CONVERT_TWO_DECIMALS, null, Locale.ENGLISH)));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.CONVERSION_OF_UNITS, null, Locale.ENGLISH);
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
		
		int celcius = MathUtilities.getRandomNumber(10, 25);
		
		BigDecimal farenhite = new BigDecimal(33.8*celcius).setScale(2, RoundingMode.HALF_UP);
		
		question= "If 1 Celcius = 33.8 Farenhite. What would be the temperature for " + Integer.toString(celcius)+ " Celcius in Farenhite? (Round upto 2 Decimals)";
		answer = farenhite.toString();
			
		
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
		
		int gallon = MathUtilities.getRandomNumber(5, 25);
		
		BigDecimal litre = new BigDecimal(gallon*3.78541).setScale(2, RoundingMode.HALF_UP);
		
		question= "If 1 Gallon = 3.78541 Litre. What is equivalent of " + Integer.toString(gallon)+ " in Litre (Round upto 2 Decimals)?";
		answer = litre.toString();
			
		
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
		
		int km = MathUtilities.getRandomNumber(90, 120);
		
		BigDecimal mile = new BigDecimal((double)km/1.62).setScale(2, RoundingMode.HALF_UP);
		
		question= "If 1 Mile = 1.62 Kilometer, then what is the speed in Miles of a car travelling at " + Integer.toString(km)+ " Kilometer (Round upto 2 Decimals)?";
		answer = mile.toString();
			
		
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
		
		int km = MathUtilities.getRandomNumber(90, 120);
		
		BigDecimal meter = new BigDecimal(km*1000);
		
		question= "If a car is travelling at " + Integer.toString(km)+ " km/hour then what is its speed in Meter/Hour (m/h). (Round upto 2 Decimals)";
		answer = meter.toString();
			
		
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
		
		int km = MathUtilities.getRandomNumber(90, 120);
		
		BigDecimal meter = new BigDecimal((double)km*1000/3600).setScale(2, RoundingMode.HALF_UP);
		
		question= "If a car is travelling at " + Integer.toString(km)+ " km/hour then what is its speed in Meter/Second (m/s). Upto 2 decimal points";
		answer = meter.toString();
		
		questionList.add(new QuestionLine(question));
		
		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem10(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		int lbs = MathUtilities.getRandomNumber(20, 90);
		
		BigDecimal kg = new BigDecimal((double)lbs/2.2).setScale(2, RoundingMode.HALF_UP);
		
		question= "If the weight of a box is "+ Integer.toString(lbs) + " lbs, what would be the weight in Kgs? Upto 2 decimal points";
		answer = kg.toString();
		
		questionList.add(new QuestionLine(question));
		
		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem11(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String answer="";
		
		double price = (double)MathUtilities.getRandomNumber(180, 210)/100;
		int gallon = MathUtilities.getRandomNumber(15, 25);
		
		double litre = gallon*3.78541;
		
		price = price*gallon;
		BigDecimal perLitre = new BigDecimal(price/litre).setScale(2, RoundingMode.HALF_UP);
		
		question= "If you refill your car with "+ Integer.toString(gallon) + " Gallon and the price per Gallon is CAD" 
				+ Double.toString(price)+ ". Then what is the price per/litres? Round upto 2 decimal points";
		answer = perLitre.toString();
		
		questionList.add(new QuestionLine(question));
		
		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	

}
