package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8P1Peremeter extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8P1Peremeter.class);
	private RestMathClientService restMathClient;

	public List<?> getQuestions(MathConfiguration mathConfig) {
		
	
		
		List<Problem> g8P1Peremeter = new ArrayList<Problem>();
		
		g8P1Peremeter.add(getProblem1(mathConfig));
		
		restMathClient = new RestMathClientServiceImpl();
		g8P1Peremeter = restMathClient.returnAnswerList(g8P1Peremeter);
		
		return g8P1Peremeter;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		

		String question = "";
		String ans = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();


		question = "[1,2,3,4]";


		ans = null ;

	//	questionList.add( new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH) , null, null));
		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
	
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(ans));
	//	answerList.add( new AnswerLine(a1Sign + Math.abs(a1)+ "*x" + a2Sign + Math.abs(a2)+ "*x" + n1Sign + Integer.toString(Math.abs(n1+1)) + n2Sign + Math.abs(n2)));
	//	answerList.add(new AnswerLine(a1Sign + Math.abs(2*a1)+ "*x" + a2Sign+ Math.abs(a2)+ "*x" + n1Sign+ Math.abs(n1) + n2Sign + Integer.toString(Math.abs(n2-1))));
		answer.setAnswerList(answerList);

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answer);

		return problem;
	}
	
}
