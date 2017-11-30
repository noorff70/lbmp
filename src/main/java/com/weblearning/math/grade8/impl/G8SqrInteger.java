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
import com.weblearning.domain.RootObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8SqrInteger extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8SqrInteger.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> g8SqrInteger = new ArrayList<Problem>();
		
		for (int i = 0; i < 10; i++)
			g8SqrInteger.add(getProblem1(mathConfig));
		for (int i=0; i<15; i++)
			g8SqrInteger.add(getProblem2(mathConfig));

		return g8SqrInteger;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		String question = "";

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
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_SELECT_SQUAREROOT, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + question + " " + "answer: " + Integer.toString(squareroot));

		String heading = mSource.getMessage(Constants.GRADE_8_FIND_INTEGER_SQUARE_ROOT, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, Integer.toString(squareroot), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig){
		
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		Answer answer = new Answer();
		String question = "";
		String result;

		Map<Integer, Integer> perfectRoots = new HashMap<Integer, Integer>();
		
		
		//take any number from 2-25
		int factor = MathUtilities.getRandomNumber(2, 25);

		//generate the square roots and multiply that with a factor and put that in a map-perfectroots
		for (int i=1; i< 26; i++){
			perfectRoots.put(i, i*i*factor);
		}
		
		//get any random number from 2-25 as a key
		int squareroot = MathUtilities.getRandomNumber(2, 25);
		//get the value of that number/key from the map
		int value = perfectRoots.get(squareroot);
		//find the square root of that number
		question = "$\\sqrt{"+ value+ "}$";
		
		RootObject rObject = MathUtilities.getRoot(value, 2);

		if (rObject.getRoot() ==1)
			result = Integer.toString(rObject.getWhole());
		else
			result = rObject.getWhole()+"$\\sqrt{"+ rObject.getRoot()+ "}$";
		
		answer.setType(Constants.RADIO_TYPE);
		answer.setAnswer(result);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_SELECT_SQUAREROOT, null, Locale.ENGLISH) + " " + question);
		questionList.add(qLine1);
		questionList.add(new QuestionLine(rObject.getWhole()+"$\\sqrt{"+ rObject.getRoot()+ "}$"));
		questionList.add(new QuestionLine(rObject.getWhole()*2+"$\\sqrt{"+ rObject.getRoot()+ "}$"));
		questionList.add(new QuestionLine(rObject.getWhole()*1+"$\\sqrt{"+ rObject.getRoot()*3+ "}$"));
		questionList.add(new QuestionLine(rObject.getWhole()*1+"$\\sqrt{"+ rObject.getRoot()*2+ "}$"));
		
		//get the questionlist rearranged by passing the list itself and a max number to swap the answers
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);

		String heading = mSource.getMessage(Constants.GRADE_8_FIND_INTEGER_SQUARE_ROOT, null, Locale.ENGLISH);

		
		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);
		
		return problem;
		
	}
	
	

}
