package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8IntEval3 extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8IntEval3.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> g8SqrInteger = new ArrayList<Problem>();
		
		for (int i = 0; i < 5; i++)
			g8SqrInteger.add(getProblem1(mathConfig));
		
	
		return g8SqrInteger;
	}

	
	/*
	 * ((-8-6)/(-7))/4
	 */
	@SuppressWarnings("unchecked")
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";
		Answer ans = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		int x1 = MathUtilities.getRandomNumber(-10, -2);
		int x2 = MathUtilities.getRandomNumber(2, 10);
		int x3 = 1;
		
		Map<?, ?> factorMap = MathUtilities.getListOfFactors(Math.abs(x1-x2));
		Iterator<?> it = factorMap.entrySet().iterator();
		Map.Entry<Integer, Integer> result = null;
		while (it.hasNext()) {
			result = (Entry<Integer, Integer>) it.next();
		}
		if (null == result)
			x3 = Math.abs(x1-x2);
		else 
			x3 = result.getKey();
		
		//just make x3 as negative
		x3 = Math.abs(x3) * -1;	
		
		int x4 = MathUtilities.getRandomNumber(2, 8);
		
		Fraction frac = Fraction.getReducedFraction(x1-x2, x4 * x3);
	
		question = "$(" + Integer.toString(x1) + " - "+ Integer.toString(x2) +")\\div(" + Integer.toString(x3) + ")\\over" + Integer.toString(x4) + "$";
		ans.setAnswer("$"+ Integer.toString(frac.getNumerator()) + "\\over" + Integer.toString(frac.getDenominator()) + "$");

		questionList.add(new QuestionLine(mSource.getMessage(Constants.GRADE_8_SELECT_SQUAREROOT, null, Locale.ENGLISH), null, null));
		questionList.add(new QuestionLine(question, null, null));
		
		List<AnswerLine>answerList = new ArrayList<AnswerLine>();
		answerList.add(new AnswerLine(ans.getAnswer()));
		answerList.add(new AnswerLine("$"+ Integer.toString(frac.getNumerator()+1) + "\\over" + Integer.toString(frac.getDenominator()) + "$"));
		answerList.add(new AnswerLine("$"+ Integer.toString(frac.getNumerator()+2) + "\\over" + Integer.toString(frac.getDenominator()) + "$"));
		
		answerList = MathUtilities.getQuestionList(answerList, answerList.size()-1, 0);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
		ans.setAnswerOption(correctAnswerOption);
	//	ans.setType(Constants.RADIO_TYPE);
		ans.setAnswerList(answerList);
		
		logger.debug("Question: " + question + " " + "answer: " + ans.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, ans.getAnswer(), heading, null, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(ans);

		return problem;
	}
		
}
