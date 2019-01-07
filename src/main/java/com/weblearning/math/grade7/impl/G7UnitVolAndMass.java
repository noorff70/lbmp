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

public class G7UnitVolAndMass extends GenericQuestion{
	
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
		
		return g7UnitLnConv;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		BigDecimal kg = new BigDecimal((double)MathUtilities.getRandomNumber(12, 49)/ 100).setScale(2, RoundingMode.HALF_UP);
		
		
		question1= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.DECAGRAM, null, Locale.ENGLISH);
		question2= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.GRAM, null, Locale.ENGLISH);
		question3= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.DECIGRAM, null, Locale.ENGLISH);
		question4= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.CENTIGRAM, null, Locale.ENGLISH);
		question5= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.MILIGRAM, null, Locale.ENGLISH);
		
		answer1 = kg.multiply(new BigDecimal(100)).toString();
		answer2 = kg.multiply(new BigDecimal(1000)).toString();
		answer3 = kg.multiply(new BigDecimal(10000)).toString();
		answer4 = kg.multiply(new BigDecimal(100000)).toString();
		answer5 = kg.multiply(new BigDecimal(1000000)).toString();
		
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+" " + kg.toString() + " Kilogram " + "to the Following. Rounding to 2 decimal." , null, Constants.DEFAULT));
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
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		BigDecimal ml = new BigDecimal((double)MathUtilities.getRandomNumber(15000, 45000));
		
		question1= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.CENTILITER, null, Locale.ENGLISH);
		question2= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.DECILITER, null, Locale.ENGLISH);
		question3= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.LITER, null, Locale.ENGLISH);
		question4= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.DECALITER, null, Locale.ENGLISH);
		question5= mSource.getMessage(GR7_Constants.CONVERT_TO, null, Locale.ENGLISH) +" " + mSource.getMessage(GR7_Constants.KILOMETER, null, Locale.ENGLISH);
		
		answer1 = ml.divide(new BigDecimal(10)).toString();
		answer2 = ml.divide(new BigDecimal(100)).toString();
		answer3 = ml.divide(new BigDecimal(1000)).toString();
		answer4 = ml.divide(new BigDecimal(10000)).toString();
		answer5 = ml.divide(new BigDecimal(1000000)).toString();
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+" " + ml.toString() + " Mililiter " + "to the Following. Rounding to 2 decimal" , null, Constants.DEFAULT));
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
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		int _1gm = MathUtilities.getRandomNumber(1, 50);
		int _1mg = MathUtilities.getRandomNumber(100, 500);
		int _1kg= MathUtilities.getRandomNumber(1, 15);
		answer1 = new BigDecimal(_1kg*1000+_1gm+(double)_1mg/1000).setScale(2, RoundingMode.HALF_UP).toString();

		int _2gm = MathUtilities.getRandomNumber(1000, 5000);
		int _2mg = MathUtilities.getRandomNumber(100000, 500000);
		answer2 = new BigDecimal((double)_2mg/100000 + (double)_2gm/1000).setScale(2, RoundingMode.HALF_UP).toString();
		
		int _3gm = MathUtilities.getRandomNumber(10, 50);
		int _3decigm = MathUtilities.getRandomNumber(10, 50);
		int _3cgm = MathUtilities.getRandomNumber(10, 50);
		int _3mg = MathUtilities.getRandomNumber(100, 500);
		answer3 = new BigDecimal(_3gm + (double)_3decigm/10 + (double)_3cgm/100 + (double)_3mg/1000).setScale(2, RoundingMode.HALF_UP).toString();
		
		int _4gm = MathUtilities.getRandomNumber(10, 50);
		int _4kg = MathUtilities.getRandomNumber(10, 50);
		answer4 = new BigDecimal(_4gm + _4kg*1000).setScale(2, RoundingMode.HALF_UP).toString();
		
		int _5gm = MathUtilities.getRandomNumber(10, 50);
		int _5cg = MathUtilities.getRandomNumber(10, 50);
		int _5mg = MathUtilities.getRandomNumber(10, 50);
		answer5 = new BigDecimal(_5gm*1000+_5cg*10+_5mg).setScale(2, RoundingMode.HALF_UP).toString();
		
		question1= "Convert " + Integer.toString(_1kg) + " kg " + Integer.toString(_1gm) + " gm " + Integer.toString(_1mg) + " mg to gm";
		question2= "Convert " + Integer.toString(_2gm) + " gm " + Integer.toString(_2mg) + " mg to gm";
		question3= "Convert " + Integer.toString(_3gm) + " gm " + Integer.toString(_3decigm) + " decigram " + Integer.toString(_3cgm) + " centigram " + Integer.toString(_3mg) + " mg to gram";
		question4= "Convert " + Integer.toString(_4kg) + " kg " + Integer.toString(_4gm) + " gm to kg" ;		
		question5= "Convert " + Integer.toString(_5gm) + " gm " + Integer.toString(_5cg) + " centigram " + Integer.toString(_5mg) + " mg to mg.";
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+ "to the Following. Round to 2 decimal" , null, Constants.DEFAULT));
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
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		int _1lt = MathUtilities.getRandomNumber(1, 50);
		int _1ml = MathUtilities.getRandomNumber(100, 500);
		int _1kl= MathUtilities.getRandomNumber(1, 15);
		answer1 = new BigDecimal(_1kl*1000+_1lt+(double)_1ml/1000).setScale(2, RoundingMode.HALF_UP).toString();

		int _2lt = MathUtilities.getRandomNumber(1000, 5000);
		int _2ml = MathUtilities.getRandomNumber(100000, 500000);
		answer2 = new BigDecimal((double)_2ml/100000 + (double)_2lt/1000).setScale(2, RoundingMode.HALF_UP).toString();
		
		int _3lt = MathUtilities.getRandomNumber(10, 50);
		int _3decilt = MathUtilities.getRandomNumber(10, 50);
		int _3cl = MathUtilities.getRandomNumber(10, 50);
		int _3ml = MathUtilities.getRandomNumber(100, 500);
		answer3 = new BigDecimal(_3lt + (double) _3decilt/10 + (double)_3cl/100 + (double)_3ml/1000).setScale(2, RoundingMode.HALF_UP).toString();
		
		int _4lt = MathUtilities.getRandomNumber(10, 50);
		int _4kl = MathUtilities.getRandomNumber(10, 50);
		answer4 = new BigDecimal(_4lt + _4kl*1000).setScale(2, RoundingMode.HALF_UP).toString();
		
		int _5lt = MathUtilities.getRandomNumber(10, 50);
		int _5cl = MathUtilities.getRandomNumber(10, 50);
		int _5ml = MathUtilities.getRandomNumber(10, 50);
		answer5 = new BigDecimal(_5lt*1000+_5cl*10+_5ml).setScale(2, RoundingMode.HALF_UP).toString();
		
		question1= "Convert " + Integer.toString(_1kl) + " kl " + Integer.toString(_1lt) + " liter " + Integer.toString(_1ml) + " ml to liter";
		question2= "Convert " + Integer.toString(_2lt) + " liter " + Integer.toString(_2ml) + " ml to liter";
		question3= "Convert " + Integer.toString(_3lt) + " liter " + Integer.toString(_3decilt) + " deciliter " + Integer.toString(_3cl) + " centiliter " + Integer.toString(_3ml) + " ml to liter";
		question4= "Convert " + Integer.toString(_4kl) + " kl " + Integer.toString(_4lt) + " liter to kl" ;		
		question5= "Convert " + Integer.toString(_5lt) + " liter " + Integer.toString(_5cl) + " centiliter " + Integer.toString(_5ml) + " ml to ml.";
		
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CONVERT, null, Locale.ENGLISH)
				+ "to the Following. Convert to 2 decimal" , null, Constants.DEFAULT));
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
		
		BigDecimal price = new BigDecimal((double)MathUtilities.getRandomNumber(1500, 2500)/100).setScale(2, RoundingMode.HALF_UP);
		double priceIndouble = price.doubleValue();
		
		question= "The price of certain product is CAD " + price.toString() + " per kg. What would be the price of that product in per gram? ";
		answer = new BigDecimal(priceIndouble/1000).setScale(2, RoundingMode.HALF_UP).toString();
		
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
		
		BigDecimal price = new BigDecimal(MathUtilities.getRandomNumber(15000, 25000)).setScale(2, RoundingMode.HALF_UP);
		int kg = MathUtilities.getRandomNumber(1, 10);
		int gm = MathUtilities.getRandomNumber(200, 500);
		int mg = MathUtilities.getRandomNumber(1000, 5000);
		
		double convertedgm = (double)kg*1000 + gm + (double)mg/1000;
		
		question= "You bought a certain product that weighs " + Integer.toString(kg) + " kg, " + Integer.toString(gm) + " gm, and " + Integer.toString(mg) 
			+ " mg. The price of the product is " + price.toString()+" What whould be the price per gm for that product?" ;
		answer = new BigDecimal(price.doubleValue()/convertedgm).setScale(2, RoundingMode.HALF_UP).toString();
		
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
		
		int kl = MathUtilities.getRandomNumber(1, 5);
		int lt = 5*MathUtilities.getRandomNumber(10, 50);
		
		int convLt = kl + 1000*lt;
		
		
		question= "You have a big jar which contains " + Integer.toString(kl) + " kl and " + Integer.toString(lt) + " of liquid. If you would like to replace that whole jar with small "
				+ "jars of 5 litre each, then how many small jars you need? ";
		answer = Integer.toString(convLt/5);
		
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
		
		double price = (double)MathUtilities.getRandomNumber(1000, 5000)/100;
		
		question= "Price of a litre of certain liquid is " + Double.toString(price) + " . What would be the price per ml?";
		answer = new BigDecimal(price/1000).setScale(2, RoundingMode.HALF_UP).toString();
		
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
		
		BigDecimal price = new BigDecimal((double)MathUtilities.getRandomNumber(150, 250)/100).setScale(2, RoundingMode.HALF_UP);
		double priceIndouble = price.doubleValue();
		
		question= "The price of certain product is CAD " + price.toString() + " per gm. What would be the price of that product in per kg? ";
		answer = new BigDecimal(priceIndouble*1000).setScale(2, RoundingMode.HALF_UP).toString();
		
		questionList.add(new QuestionLine(question));
		
		String heading = mSource.getMessage(GR7_Constants.FRACTION_SIMPLIFICATION, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	

}
