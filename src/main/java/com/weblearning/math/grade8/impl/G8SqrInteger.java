package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8SqrInteger extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8SqrInteger.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> g8SqrInteger = new ArrayList<Problem>();
		
		for (int i = 0; i < 25; i++)
			g8SqrInteger.add(getProblem1(mathConfig));

		return g8SqrInteger;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answ = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		Map<Integer, Integer> perfectRoots = new HashMap<Integer, Integer>();
		//generate the square roots
		for (int i=1; i< 26; i++){
			perfectRoots.put(i, i*i);
		}
		
		int squareroot = MathUtilities.getRandomNumber(2, 25);
		int value = perfectRoots.get(squareroot);
		question = "$\\sqrt{"+ value+ "}$";
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(squareroot));

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(squareroot));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
}
