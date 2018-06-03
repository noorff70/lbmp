package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade.UniqueObjectMap;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ExponentNegative extends GenericQuestion {

	Map<Integer, UniqueObjectMap> objectMaps = new ConcurrentHashMap<Integer, UniqueObjectMap>();

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentNegative = new ArrayList<Problem>();

		for (int i = 0; i < 25; i++)
			g7ExponentNegative.add(getProblem1(mathConfig, i));

		return g7ExponentNegative;
	}

	/*
	 * Exponentiation
	 */
	public Problem getProblem1(MathConfiguration mathConfig, int i) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		MessageSource mSource = mathConfig.getmSource();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		int answer = 0;

		// get a random first number

		int firstNumber = MathUtilities.getRandomNumber(1, 10);
		int pow = MathUtilities.getRandomNumber(1, 4);

		firstNumber = -firstNumber;

		// we put the number and value to a map so that it can be compared and
		// we don't get any duplicate value
		// The map wil be (k,v)-> (i,(firstnumber, pow)), where i is the number
		// of iteration
		if (objectMaps.size() == 0) {
			UniqueObjectMap objectMap = new UniqueObjectMap();
			objectMap.setNumber(firstNumber);
			objectMap.setPow(pow);
			objectMaps.put(i, objectMap);

			question = "$" + firstNumber + "^{" + pow + "}$";
			answer = (int) Math.pow(firstNumber, pow);
		} else {
			// 2nd time and so on, we need to compare the value if that is in
			// the map
			// Iterator iterator = objectMaps.entrySet().iterator();
			// while (iterator.hasNext()){
			while (MathUtilities.isObjectPresent(firstNumber, pow, objectMaps)) {

				firstNumber = MathUtilities.getRandomNumber(1, 10);
				pow = MathUtilities.getRandomNumber(1, 4);

			}
			// save the values to the class and put in the map
			UniqueObjectMap objectMap = new UniqueObjectMap();
			objectMap.setNumber(firstNumber);
			objectMap.setPow(pow);
			objectMaps.put(i, objectMap);

			// create question and answer sections
			question = "$" + objectMap.getNumber() + "^{" + objectMap.getPow()
					+ "}$";
			answer = (int) Math.pow(objectMap.getNumber(), objectMap.getPow());
		}

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(
				Constants.INTEGER_EXPONENTIATION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage( Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(answer));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}

}
