package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7DecimalAddition extends GenericQuestion {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7DecimalAddition = new ArrayList<Problem>();


		for (int i = 0; i < 25; i++)
			g7DecimalAddition.add(getProblem1(mathConfig));

		return g7DecimalAddition;
	}

	/*
	 * Add decimals
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		Double answer = (double) 0;
		
		for (int i=0; i<3; i++){
			int number = MathUtilities.getRandomNumber(10000, 10000000);
			int decimal = MathUtilities.getRandomNumber(1, 3);
			double dNumber = 0;
			
			if (decimal==1)
				dNumber = (double)number/10;
			else if (decimal==2)
				dNumber = (double)number/100;
			else if(decimal==3)
				dNumber = (double)number/1000;
			
			if (StringUtils.isEmpty(question))
				question = Double.toString(dNumber);
			else
				question = question + " + " + Double.toString(dNumber);
			
			answer += dNumber;
			
		}


		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.ADD_FOLLOWING_DECIMAL_NUMBERS, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_ADD_DECIMAL_NUMBERS, null, Locale.ENGLISH);
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, Double.toString(answer), heading, subHeading, Constants.RANK_ONE, Constants.DEFAULT);

		return problem;
	}
	

}
