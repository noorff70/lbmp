package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.MessageSource;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ExponentNegative extends Question {
	
	Map<Integer, UniqueObjectMap> objectMaps = new HashMap<Integer, UniqueObjectMap>();

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g7ExponentNegative = new ArrayList<Problem>();
		
		for (int i = 0; i <25; i++)
			g7ExponentNegative.add(getProblem1(mathConfig, i));
		

		return g7ExponentNegative;
	}

	/*
	 * Exponentiation
	 */
	public Problem getProblem1(MathConfiguration mathConfig, int i) {
		
		

		CreateProblem cProblem = new CreateProblem();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question = "";
		int answer =0;
		
		//get a random first number
		
		int firstNumber = MathUtilities.getRandomNumber(1, 10);
		int pow = MathUtilities.getRandomNumber(1, 4);
		
		firstNumber = -firstNumber;
		
		//we put the number and value to a map so that it can be compared and we don't get any duplicate value
		//The map wil be (k,v)-> (i,(firstnumber, pow)), where i is the number of iteration 
		if (objectMaps.size()==0){
			UniqueObjectMap objectMap = new UniqueObjectMap();
			objectMap.setNumber(firstNumber);
			objectMap.setPow(pow);
			objectMaps.put(i, objectMap);
			
			question = "$"+firstNumber +"^{" +pow+"}$";
			answer = (int) Math.pow(firstNumber, pow);
		}else{
			//2nd time and so on, we need to compare the value if that is in the map
			Iterator iterator = objectMaps.entrySet().iterator();
			while (iterator.hasNext()){
				Map.Entry<Integer, UniqueObjectMap> entry = (Entry<Integer, UniqueObjectMap>) iterator.next();
				UniqueObjectMap  mapObject = entry.getValue();
				
				//iterate until we get a distinct value of (firstnumber, pow)
				while(firstNumber == (int)mapObject.getNumber() && pow == (int)mapObject.getPow()){
					firstNumber = MathUtilities.getRandomNumber(1, 10);
					pow = MathUtilities.getRandomNumber(1, 4);
				}
				//save the values to the class and put in the map
				UniqueObjectMap objectMap = new UniqueObjectMap();
				objectMap.setNumber(firstNumber);
				objectMap.setPow(pow);
				objectMaps.put(i, objectMap);
				
				//create question and answer sections
				question = "$"+objectMap.getNumber() +"^{" +objectMap.getPow()+"}$";
				answer = (int) Math.pow(objectMap.getNumber(), objectMap.getPow());
			}
		
		}		
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.INTEGER_EXPONENTIATION, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);

		questionList.add(qLine1);
		questionList.add(qLine2);

		String heading = mSource.getMessage(Constants.GRADE_7_INTEGER_EXPONENTIATION, null, Locale.ENGLISH);
		String subHeading = "";

		Problem problem = cProblem.constructProblem(questionList, Integer.toString(answer), heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);

		return problem;
	}
	
	/*
	 * a class to hold the data structure of a number and pow
	 */
	class UniqueObjectMap{
		
		int number;
		int pow;
		
		public int getPow() {
			return pow;
		}

		public void setPow(int pow) {
			this.pow = pow;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int n){
			number= n;
		}
		
	}
		

}
