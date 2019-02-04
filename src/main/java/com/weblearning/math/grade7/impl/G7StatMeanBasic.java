package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
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

public class G7StatMeanBasic extends GenericQuestion{

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7StatBasic = new ArrayList<Problem>();
		
		g7StatBasic.add(getProblem1(mathConfig));
		g7StatBasic.add(getProblem2(mathConfig));

		
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
		

		String question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="" , answer5="";
		
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
		
		for (int i=0; i< set5.length; i++) {
			question5 = question5 + (int)set5[i]+"x" + ", ";
		}
		answer5 = mean(set5).toString()+"x";

				
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CALCULATE_MEAN, null, Locale.ENGLISH) , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

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
		String answer1="", answer2="", answer3="", answer4="" , answer5="";
		
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
		answer5 = Double.toString(median(set5))+"x";

				
		questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.CALCULATE_MEDIAN, null, Locale.ENGLISH) , null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 +	Constants.ANSWER_TO_QUESTION + answer4 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

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
		questionList.add(new QuestionLine( question5 +	Constants.ANSWER_TO_QUESTION + answer5 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.MEAN_MEDIAN_MODE_BASICS, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

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
