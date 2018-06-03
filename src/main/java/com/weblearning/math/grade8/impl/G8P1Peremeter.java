package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.GeometryObject;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.GeometryParser;
import com.weblearning.math.utilities.MathUtilities;
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
		String a1Sign, a2Sign, n1Sign, n2Sign;

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		int a1 = MathUtilities.getRandomNumber(-10, 20);
		if ( a1== 0) a1 = 3;
		int a2 = MathUtilities.getRandomNumber(-10, 20);
		if (a2 ==0) a2 = 5;
		int n1 = MathUtilities.getRandomNumber(-10, 20);
		int n2 = MathUtilities.getRandomNumber(-10, 20);
		
		if (a1 < 0)
			a1Sign = ""; else a1Sign = "-";
		if (a2>=0)
			a2Sign = "+"; else a2Sign = "-";
		if (n1>=0)
			n1Sign = "+"; else n1Sign = "-";
		if (n2>=0)
			n2Sign = "+"; else n2Sign = "-";

		question = a1Sign + Math.abs(a1)+ "x" + a2Sign + Math.abs(a2)+ "x" + n1Sign + Math.abs(n1) + n2Sign + Math.abs(n2);


		ans = a1Sign + Math.abs(a1)+ "*x" + a2Sign + Math.abs(a2)+ "*x" +n1Sign+ Math.abs(n1) + n2Sign + Math.abs(n2) ;

	//	questionList.add( new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH) , null, null));
		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
	
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(ans));
		answerList.add( new AnswerLine(a1Sign + Math.abs(a1)+ "*x" + a2Sign + Math.abs(a2)+ "*x" + n1Sign + Integer.toString(Math.abs(n1+1)) + n2Sign + Math.abs(n2)));
		answerList.add(new AnswerLine(a1Sign + Math.abs(2*a1)+ "*x" + a2Sign+ Math.abs(a2)+ "*x" + n1Sign+ Math.abs(n1) + n2Sign + Integer.toString(Math.abs(n2-1))));
		answer.setAnswerList(answerList);

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answer);

		return problem;
	}
	
}
