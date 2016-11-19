package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.fraction.Fraction;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.utility.FractionObject;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7FracStmtEval extends Question {

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g6FracStmtEval = new ArrayList<Problem>();

		for (int i = 0; i < 5; i++){
			//j stands for rule. rules can be 1,2 ,3 etc
			for (int j=1; j<=4; j++){
				g6FracStmtEval.add(getProblem(j, mathConfig));
			}
		}

		return g6FracStmtEval;
	}


	/*Find the statement if the first statement is is geater than, less than or equal to the second statement
	 * 
	 */
	public Problem getProblem (int rule, MathConfiguration mathConfig){
		
		CreateProblem cProblem = new CreateProblem();
		
		int numerator1, denominator1, numerator2, denominator2, numerator3, denominator3, numerator4, denominator4;
		numerator1=denominator1=numerator2=denominator2=numerator3=denominator3=numerator4=denominator4=0;
		
		List<FractionObject> fractionList1 = new ArrayList<FractionObject>();
		List<FractionObject> fractionList3 = new ArrayList<FractionObject>();
		
		FractionObject fracObject1 = new FractionObject();
		FractionObject fracObject2 = new FractionObject();
		FractionObject fracObject3 = new FractionObject();
		FractionObject fracObject4 = new FractionObject();
		
		String result = null;
		Fraction result1 = new Fraction(0, 1);
		Fraction result3 = new Fraction(0, 1); 
		
		List <QuestionLine>questionList = new ArrayList<QuestionLine>();
		
		//ceate the first fractions numeator/denominator
		numerator1 = MathUtilities.getRandomNumber(11, 20);
		denominator1 = MathUtilities.getRandomNumber(1, 10);
		
		// create the second fraction numerator/denominator
		numerator2 = MathUtilities.getRandomNumber(1, 10);
		denominator2 = MathUtilities.getRandomNumber(12, 30);
		
		//create the third fraction numerator/denominator
		numerator3 = MathUtilities.getRandomNumber(11, 20);
		denominator3 = MathUtilities.getRandomNumber(1, 10);
		
		//create the fourth numerator/denominator
		numerator4 = MathUtilities.getRandomNumber(1, 10);
		denominator4 = MathUtilities.getRandomNumber(12, 30);
		
		switch (rule){
		
		//Evaluste f1* f2 AND f3*f4
		case(1):
	
			//create the first fraction object
			fracObject1.setNumerator(numerator1);
			fracObject1.setDenominator(denominator1);
			fracObject1.setPrefix(Constants.SIGN_PLUS);
			fracObject1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
					
			fracObject2.setNumerator(numerator2);
			fracObject2.setDenominator(denominator2);
			fracObject2.setPrefix(Constants.SIGN_MULTIPLY);
			fracObject2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			//add the fraction objects to list
			fractionList1.add(fracObject1);
			fractionList1.add(fracObject2);
				
			//create the third fraction object
			fracObject3.setNumerator(numerator3);
			fracObject3.setDenominator(denominator3);
			fracObject3.setPrefix(Constants.SIGN_PLUS);
			fracObject3.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			// create the fourth fraction object
			fracObject4.setNumerator(numerator4);
			fracObject4.setDenominator(denominator4);
			fracObject4.setPrefix(Constants.SIGN_MULTIPLY);
			fracObject4.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			//add the fraction objects to list
			fractionList3.add(fracObject3);
			fractionList3.add(fracObject4);
			
			break;
		

			//Evaluate f1/f2 AND f3*f4
		case(2):
			//create the first fraction object
			fracObject1.setNumerator(numerator1);
			fracObject1.setDenominator(denominator1);
			fracObject1.setPrefix(Constants.SIGN_PLUS);
			fracObject1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
					
			fracObject2.setNumerator(numerator2);
			fracObject2.setDenominator(denominator2);
			fracObject2.setPrefix(Constants.SIGN_DIVISION);
			fracObject2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			//add the fraction objects to list
			fractionList1.add(fracObject1);
			fractionList1.add(fracObject2);
				
			//create the third fraction object
			fracObject3.setNumerator(numerator3);
			fracObject3.setDenominator(denominator3);
			fracObject3.setPrefix(Constants.SIGN_PLUS);
			fracObject3.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			// create the fourth fraction object
			fracObject4.setNumerator(numerator4);
			fracObject4.setDenominator(denominator4);
			fracObject4.setPrefix(Constants.SIGN_MULTIPLY);
			fracObject4.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			//add the fraction objects to list
			fractionList3.add(fracObject3);
			fractionList3.add(fracObject4);
			break;
			

			//Evaluate f1/f2 and f3/f4
		case(3):
			//create the first fraction object
			fracObject1.setNumerator(numerator1);
			fracObject1.setDenominator(denominator1);
			fracObject1.setPrefix(Constants.SIGN_PLUS);
			fracObject1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
					
			fracObject2.setNumerator(numerator2);
			fracObject2.setDenominator(denominator2);
			fracObject2.setPrefix(Constants.SIGN_DIVISION);
			fracObject2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			//add the fraction objects to list
			fractionList1.add(fracObject1);
			fractionList1.add(fracObject2);
				
			//create the third fraction object
			fracObject3.setNumerator(numerator3);
			fracObject3.setDenominator(denominator3);
			fracObject3.setPrefix(Constants.SIGN_PLUS);
			fracObject3.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			// create the fourth fraction object
			fracObject4.setNumerator(numerator4);
			fracObject4.setDenominator(denominator4);
			fracObject4.setPrefix(Constants.SIGN_DIVISION);
			fracObject4.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			//add the fraction objects to list
			fractionList3.add(fracObject3);
			fractionList3.add(fracObject4);
			break;
	
			//evaluate f1*f2 and f3/f4
		case(4):
			//create the first fraction object
			fracObject1.setNumerator(numerator1);
			fracObject1.setDenominator(denominator1);
			fracObject1.setPrefix(Constants.SIGN_PLUS);
			fracObject1.setFractionType(Constants.FRACTION_TYPE_NORMAL);
					
			fracObject2.setNumerator(numerator2);
			fracObject2.setDenominator(denominator2);
			fracObject2.setPrefix(Constants.SIGN_MULTIPLY);
			fracObject2.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			//add the fraction objects to list
			fractionList1.add(fracObject1);
			fractionList1.add(fracObject2);
				
			//create the third fraction object
			fracObject3.setNumerator(numerator3);
			fracObject3.setDenominator(denominator3);
			fracObject3.setPrefix(Constants.SIGN_PLUS);
			fracObject3.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			// create the fourth fraction object
			fracObject4.setNumerator(numerator4);
			fracObject4.setDenominator(denominator4);
			fracObject4.setPrefix(Constants.SIGN_DIVISION);
			fracObject4.setFractionType(Constants.FRACTION_TYPE_NORMAL);
			
			//add the fraction objects to list
			fractionList3.add(fracObject3);
			fractionList3.add(fracObject4);
			break;		

			
		}
		
		result1 = MathUtilities.getResultAsFraction(fractionList1);
		result3 = MathUtilities.getResultAsFraction(fractionList3);
		
		questionList.add(new QuestionLine("A " + MathUtilities.getQuestionAsStringFraction(fractionList1) + " > " + MathUtilities.getQuestionAsStringFraction(fractionList3)));
		questionList.add(new QuestionLine("B " + MathUtilities.getQuestionAsStringFraction(fractionList1) + " < " + MathUtilities.getQuestionAsStringFraction(fractionList3)));
		questionList.add(new QuestionLine("C " + MathUtilities.getQuestionAsStringFraction(fractionList1) + " = " + MathUtilities.getQuestionAsStringFraction(fractionList3)));
	
		result = getResult(result1, result3);
		
		String heading = Constants.GRADE_7_CONTENT_FIND_MISSING_FRACTION_FOR_MULTIPLICATION;
		String subHeading = "";
		
		Problem problem = cProblem.constructProblem(questionList, result, heading, subHeading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		
		return problem;
	}
	
	/*
	 * Get the result
	 */
	public String getResult (Fraction result1, Fraction result3){
		
		String result = null;
		
		if (result1.getNumerator()/result1.getDenominator()> result3.getNumerator()/result3.getDenominator())
			result = "A";
		else if (result1.getNumerator()/result1.getDenominator()< result3.getNumerator()/result3.getDenominator())
			result = "B";
		else if (result1.getNumerator()/result1.getDenominator()== result3.getNumerator()/result3.getDenominator())
			result = "C";
		
		return result;
	}
	


}

