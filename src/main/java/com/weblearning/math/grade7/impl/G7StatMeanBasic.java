package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.GraphObject;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.Variable;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.grade8.impl.GR8_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7StatMeanBasic extends GenericQuestion{
	
	@Autowired
	private RestMathClientService restMathClient;

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7StatBasic = new ArrayList<Problem>();
		
		for (int i=0; i< 2; i++) {
			g7StatBasic.add(getProblem1(mathConfig));
			g7StatBasic.add(getProblem2(mathConfig));
		}
		g7StatBasic.add(getProblem3(mathConfig));
		g7StatBasic.add(getProblem4(mathConfig));
		g7StatBasic.add(getProblem5(mathConfig));
		g7StatBasic.add(getProblem6(mathConfig));
		g7StatBasic.add(getProblem7(mathConfig));
		g7StatBasic.add(getProblem8(mathConfig));
		g7StatBasic.add(getProblem9(mathConfig));
		g7StatBasic.add(getProblem10(mathConfig));
		
		restMathClient = new RestMathClientServiceImpl();
		g7StatBasic = restMathClient.returnGraph(g7StatBasic);
 
		
		return g7StatBasic;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		double set1[] = new double[5];
		double set2[] = new double[5];
		double set3[] = new double[5];
		double set4[] = new double[5];
		double set5[] = new double[5];
		
		for (int i=0; i<5; i++) {
			set1[i] = MathUtilities.getRandomNumber(1, 6);
		}
		
		for (int i=0; i<5; i++) {
			set2[i] = MathUtilities.getRandomNumber(10, 25);
		}
		
		for (int i=0; i<5; i++) {
			set3[i] = MathUtilities.getRandomNumber(-5, 3);
		}
		
		for (int i=0; i<5; i++) {
			set4[i] = (double)MathUtilities.getRandomNumber(12, 19)/10;
		}
		
		for (int i=0; i<5; i++) {
			set5[i] = MathUtilities.getRandomNumber(1, 6);
		}
		

		String question1="", question2="", question3="", question4=""; //, question5="";
		String answer1="", answer2="", answer3="", answer4="";
		
		for (int i=0; i< set1.length; i++) {
			question1 = question1 + (int)set1[i] + ", ";
		}
		answer1 = mean(set1).toString();
		
		for (int i=0; i< set2.length; i++) {
			question2 = question2 + (int)set2[i] + ", ";
		}
		answer2 = mean(set2).toString();
		
		for (int i=0; i< set3.length; i++) {
			question3 = question3 + (int)set3[i] + ", ";
		}
		answer3 = mean(set3).toString();
		
		for (int i=0; i< set4.length; i++) {
			question4 = question4 + set4[i] + ", ";
		}
		answer4 = mean(set4).toString();
		
		//for (int i=0; i< set5.length; i++) {
		//	question5 = question5 + (int)set5[i]+"x" + ", ";
		//}
		//answer5 = mean(set5).toString()+"x";

				
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CALCULATE_MEAN, null, Locale.ENGLISH) , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
	//	questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);
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
		
		double set1[] = new double[5];
		double set2[] = new double[6];
		double set3[] = new double[5];
		double set4[] = new double[5];
		double set5[] = new double[5];
		
		for (int i=0; i<5; i++) {
			set1[i] = MathUtilities.getRandomNumber(1, 6);
		}
		
		for (int i=0; i<6; i++) {
			set2[i] = MathUtilities.getRandomNumber(10, 25);
		}
		
		for (int i=0; i<5; i++) {
			set3[i] = MathUtilities.getRandomNumber(-5, 3);
		}
		
		for (int i=0; i<5; i++) {
			set4[i] = (double)MathUtilities.getRandomNumber(12, 19)/10;
		}
		
		for (int i=0; i<5; i++) {
			set5[i] = MathUtilities.getRandomNumber(1, 6);
		}
		

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="" ; // answer5="";
		
		for (int i=0; i< set1.length; i++) {
			question1 = question1 + (int)set1[i] + ", ";
		}
		answer1 = Double.toString(median(set1));
		
		for (int i=0; i< set2.length; i++) {
			question2 = question2 + (int)set2[i] + ", ";
		}
		answer2 = Double.toString(median(set2));
		
		for (int i=0; i< set3.length; i++) {
			question3 = question3 + (int)set3[i] + ", ";
		}
		answer3 = Double.toString(median(set3));
		
		for (int i=0; i< set4.length; i++) {
			question4 = question4 + set4[i] + ", ";
		}
		answer4 = Double.toString(median(set4));
		
		for (int i=0; i< set5.length; i++) {
			question5 = question5 + (int)set5[i]+"x" + ", ";
		}
		//answer5 = Double.toString(median(set5))+"x";

				
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CALCULATE_MEDIAN, null, Locale.ENGLISH) , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
	//	questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);
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
		
		int set1[] = {5, 1,0,0,10};
		int set2[] = {-5, -3, -1, -2, -2};
		int set3[] = {-10, -5, -5, 0, 15, -3};
		int set4[] = {18, 30, 16, 12, 18, 12, 45, 12 };
		int set5[] = {90, 45, 15, 1, -5, -6, 15, 1, 30, 15, 1, 1, 45, 1 };
		

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="" , answer5="";
		
		for (int i=0; i< set1.length; i++) {
			question1 = question1 + (int)set1[i] + ", ";
		}
		answer1 = Integer.toString(mode(set1));
		
		for (int i=0; i< set2.length; i++) {
			question2 = question2 + (int)set2[i] + ", ";
		}
		answer2 = Integer.toString(mode(set2));
		
		for (int i=0; i< set3.length; i++) {
			question3 = question3 + (int)set3[i] + ", ";
		}
		answer3 = Integer.toString(mode(set3));
		
		for (int i=0; i< set4.length; i++) {
			question4 = question4 + set4[i] + ", ";
		}
		answer4 = Integer.toString(mode(set4));
		
		for (int i=0; i< set5.length; i++) {
			question5 = question5 + (int)set5[i]+"x" + ", ";
		}
		answer5 = Integer.toString(mode(set5));

				
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CALCULATE_MODE, null, Locale.ENGLISH) , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
	//	questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {

		String question = "";
		MessageSource mSource = mathConfig.getmSource();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();
		
		question = "The middle value of a sorted list of numbers is called" ;

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		
		answer.setAnswer("Median");

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answer);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {

		String question = "";
		MessageSource mSource = mathConfig.getmSource();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();
		
		question = "The most number occured in a list of numbers is called" ;

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		
		answer.setAnswer("Mode");

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answer);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig) {

		String question = "";
		MessageSource mSource = mathConfig.getmSource();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();
		
		question = "When there is pair of numbers in the middle among a list of number, then median of that list is the average"
				+ " of the middle pair numbers. True or False" ;

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		
		answer.setAnswer("Average");

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answer);

		return problem;
	}
	
	public Problem getProblem7(MathConfiguration mathConfig) {

		String question = "";
		MessageSource mSource = mathConfig.getmSource();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();
		
		question = "Average of a data set is called" ;

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		
		answer.setAnswer("Mean");

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answer);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig) {

		String question = "";
		MessageSource mSource = mathConfig.getmSource();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();
		
		question = "You need to arrange/sort numbers in a list or set to calculate (mean/median/mode)" ;

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		
		answer.setAnswer("Median");

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answer);

		return problem;
	}
	
	
	public Problem getProblem9(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String q1="", q2="", q3="";
		String a1="", a2="", a3="";
						
		GraphObject go = new GraphObject();
		List<Variable> vList = new LinkedList<Variable>();
		
		Variable antMan = new Variable();
		antMan.setVariableName("English");
		List<String> antManList = new LinkedList<String>();
		antManList.add(Integer.toString(88));
		antManList.add(Integer.toString(90));
		antManList.add(Integer.toString(92));
		antManList.add(Integer.toString(88));
		antManList.add(Integer.toString(86));
		antManList.add(Integer.toString(86));
		antManList.add(Integer.toString(96));
		antManList.add(Integer.toString(92));
		antManList.add(Integer.toString(86));
		antManList.add(Integer.toString(85));
		antMan.setValueList(antManList);
		
		vList.add(antMan);
		
		go.setVariableList(vList);
		go.setGraphType(Constants.TABLE);
		
		q1 = "What is mean score of English?";
		a1 = "88.9";
		
		q2 = "What is the median score of English?";
		a2 = "88";
		
		q3 = "What is the Mode of English Test";
		a3 = "86";
				
		question = "The table shows Grade 7, English Test Scores of 10 Students"  ;
		
		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( q1 + GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q2 + GR8_Constants.ANSWER_TO_QUESTION + a2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q3 + GR8_Constants.ANSWER_TO_QUESTION + a3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
	

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGraphObject(go);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem10(MathConfiguration mathConfig) {

		String question = "";
		MessageSource mSource = mathConfig.getmSource();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();
		
		question = "The most common number in a set of numbers is called (mean/median/mode)" ;

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		
		answer.setAnswer("Mode");

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		problem.setAnswer(answer);

		return problem;
	}

	
	public static BigDecimal mean(double[] m) {
	    double sum = 0;
	    for (int i = 0; i < m.length; i++) {
	        sum += m[i];
	    }
	    return new BigDecimal( sum / m.length).setScale(2, RoundingMode.HALF_UP);
	}
	
	// the array double[] m MUST BE SORTED
	public static double median(double[] m) {
		
		Arrays.sort(m);
	    int middle = m.length/2;
	    if (m.length%2 == 1) {
	        return m[middle];
	    } else {
	        return (m[middle-1] + m[middle]) / 2.0;
	    }
	}


	public static int mode(int a[]) {
	    int maxValue=0, maxCount=0;

	    for (int i = 0; i < a.length; ++i) {
	        int count = 0;
	        for (int j = 0; j < a.length; ++j) {
	            if (a[j] == a[i]) ++count;
	        }
	        if (count > maxCount) {
	            maxCount = count;
	            maxValue = a[i];
	        }
	    }

	    return maxValue;
	}

}
