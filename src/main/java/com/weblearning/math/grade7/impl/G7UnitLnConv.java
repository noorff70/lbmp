package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.enums.LengthEnum;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7UnitLnConv extends GenericQuestion{

	private Map<Integer, String> unitLengthMap;
	
	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> g7UnitLnConv = new ArrayList<Problem>();
		
		setLengthUnitMap();
		
		for (int i=0; i< 25; i++)
			g7UnitLnConv.add(getProblem(mathConfig));
		
		return g7UnitLnConv;
	}
	
	private Problem getProblem(MathConfiguration mathConfig){
		
		MessageSource mSource = mathConfig.getmSource();
		
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answ = new Answer();
		
		//random key will be used to get a value i.e MILI, CENTI etc from the map
		int num1 = MathUtilities.getRandomNumber(1, 4);
		int num2 = num1;
		
		do {
			num2 = MathUtilities.getRandomNumber(1, 4);
		}
		while (num2 == num1);
		
		//get the associated value with the key from map
		String firstUnit = unitLengthMap.get(num1);
		String secondUnit = unitLengthMap.get(num2);
		
		//Get the value of Unit from Enum
		int firstUnitValue = getEnumValue(firstUnit);
		int secondUnitValue = getEnumValue(secondUnit);

		int convertFrom = MathUtilities.getRandomNumber(1, 1000);
				
		//get the fraction with a string representation
		String question = "Convert " + convertFrom + " " + firstUnit + " to " + secondUnit; 
		
		double answer = getAnswer(convertFrom, firstUnitValue, secondUnitValue);
		
	
		//add the questions
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.CONVERT_UNIT_LENGTH, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(question);
		questionList.add(qLine1);
		questionList.add(qLine2);

		
		String heading = mSource.getMessage(Constants.GRADE_7_CONVERSION_OF_UNITS_LENGTH, null, Locale.ENGLISH);
		answ.setAnswer(Double.toString(answer));
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);
		
		return problem;
		
	}
	
	public void setLengthUnitMap(){
		
		unitLengthMap = new HashMap<Integer, String>();
		
		unitLengthMap.put(1, Constants.UNIT_MILI_METER);
		unitLengthMap.put(2, Constants.UNIT_CENTI_METER);
		unitLengthMap.put(3, Constants.UNIT_DECI_METER);
		unitLengthMap.put(4, Constants.UNIT_METER);
	}
	
	public int getEnumValue(String value){
		
		LengthEnum lengthEnum =null;
		
		switch(value){
			case Constants.UNIT_MILI_METER: 
				lengthEnum = LengthEnum.MILI;
				break;
			case Constants.UNIT_CENTI_METER:
				lengthEnum = LengthEnum.CENTI;
				break;
			case Constants.UNIT_DECI_METER: 
				lengthEnum = LengthEnum.DECI;
				break;
			case Constants.UNIT_METER: 
				lengthEnum = LengthEnum.METER;
				break;
		}
		return lengthEnum.getUnit();
	}
	
	/*takes a number that will be converted to another unit
	 * convertFrom- the number to be converted 
	 * firstUnit- the unit to be converted from
	 * secondUnit- the number to be converted to
	 * ex- convert 50 cm to meter 50*cm/meter 
	 * 
	 */
	public double getAnswer(int convertFrom, int firstUnit, int secondUnit){
		
			return (double)(convertFrom * firstUnit)/secondUnit;
	}

}
