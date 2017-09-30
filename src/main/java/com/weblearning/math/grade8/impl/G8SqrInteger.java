package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.RootObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8SqrInteger extends GenericQuestion {

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
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_SQUAREROOT, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_8_FIND_INTEGER_SQUARE_ROOT, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, Integer.toString(squareroot), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig){
		
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		String question = "";
		String answer;

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
			answer = Integer.toString(rObject.getSquare());
		else
			answer = rObject.getSquare()+"$\\sqrt{"+ rObject.getRoot()+ "}$";
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_FIND_SQUAREROOT, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_8_FIND_INTEGER_SQUARE_ROOT, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, answer, heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		
		return problem;
		
	}
	
	

}
