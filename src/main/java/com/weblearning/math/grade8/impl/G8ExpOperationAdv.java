package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.NumberObject;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.RootObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8ExpOperationAdv extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8SqrInteger.class);

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub
		
		List<Problem> gExponentBasics = new ArrayList<Problem>();
		
		for (int i = 0; i < 5; i++)
			gExponentBasics.add(getProblem1(mathConfig));
		for (int i = 0; i < 10; i++)
			gExponentBasics.add(getProblem2(mathConfig));
		for (int i = 0; i <10; i++)
			gExponentBasics.add(getProblem3(mathConfig));

		return gExponentBasics;
	}

	/*
	 * 8*2^2+6*sqrt(2)3
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		//ex- (sqrt(2)*3)- convert 4*sqrt(2)- whole-4, root-2
		int A1power = MathUtilities.getRandomNumber(2,6);
		int A1base = 2;
		String A11 = "$(\\sqrt"+A1base+ ")^"+ "{" +A1power+ "}" +"$";
		RootObject A11R = convertSquareRoottoRootObject(A1base, A1power, 2);
		
		int A12 = 2* MathUtilities.getRandomNumber(2, 6);
		String A1 = A12 + " X " + A11;
		//get then root object for this integer
		RootObject A12R = new RootObject();
		A12R.setRoot(1);
		A12R.setWhole(A12);
		
		//now need to multiply the operation by passing on 2 root objects.
		RootObject r1 = new RootObject();

		ArrayList<RootObject> a1 = new ArrayList<RootObject>();
		a1.add(A11R);
		a1.add(A12R);

		//multiply 12 * 4*sqrt(2) = 48*sqrt(2)
		r1 = MathUtilities.multiplyRoots(a1);

		
		//multiply a number with anothernumber to the power something to get a whole number
		int A2power = MathUtilities.getRandomNumber(2, 3);
		int A2base = 2;
		int A21 = 2* MathUtilities.getRandomNumber(2, 6);
		int A22 = A21 * (int)Math.pow(2, A2power);
		String A2 = A21 + " X " + "$" + A2base + "^" + "{" +A2power+ "}" + "$";
		RootObject r2 = new RootObject();
		r2.setWhole(A22);
		r2.setRoot(1);
		
		List <RootObject> numeratorList = new ArrayList<RootObject>();
		numeratorList.add(r1);
		numeratorList.add(r2);
		
		List <RootObject> denominatorList = new ArrayList<RootObject>();
		RootObject rObject = new RootObject();
		rObject.setRoot(1);
		rObject.setWhole(1);
		denominatorList.add(rObject);
		
		//format the number object
		NumberObject numeratorN = MathUtilities.createNumberObject(numeratorList);
		List<NumberObject> nObjectList = new ArrayList<NumberObject>();
		nObjectList.add(numeratorN);
		//nObjectList.add(e);
		NumberObject denominatorN = MathUtilities.createNumberObject(denominatorList);
		nObjectList.add(denominatorN);
		
		String ans = MathUtilities.formatNumberObject(nObjectList);
		
		//fake answers
		List<String> fakeAnswers = getFakeAnswers(nObjectList);
		
		question = A2 + " + " + A1;

		answer.setAnswer(ans);
		
		answer.setType(Constants.RADIO_TYPE);
		

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH) + "  " + question, null);
		questionList.add(qLine1);
	//	questionList.add(new QuestionLine(question, null));
		questionList.add(new QuestionLine(answer.getAnswer(), Constants.RADIO_TYPE));
		for (int i=0; i<fakeAnswers.size(); i++ ) {
			questionList.add(new QuestionLine(fakeAnswers.get(i), Constants.RADIO_TYPE));
		}

		//questionList.add(new QuestionLine("$" + base +"^"+power*2 +"$"));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * 8*2^2+8*sqrt(2)^-3
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {

		String question = "";
		Answer answer = new Answer();
		String result = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		//ex- (sqrt(2)^3)- 8- convert 4*sqrt(2)- whole-4, root-2
		int A1power = MathUtilities.getRandomNumber(-6,-2);
		int A1base = 2;
		String A11 = "$(\\sqrt"+A1base+ ")^"+ "{" +A1power+ "}" +"$";
		RootObject A11R = convertSquareRoottoRootObject(A1base, A1power, 2);

		
		int A12 = MathUtilities.getRandomNumber(2, 6);
		//make a square of the wh
		Fraction frac1 = Fraction.getReducedFraction((int)Math.pow(A12, A1base), (int)Math.pow(A11R.getWhole(), A1base)*A11R.getRoot());
		RootObject fracNumeratorRootA1 = MathUtilities.getRoot(frac1.getNumerator(), A1base);
		RootObject fracDenominatorRootA2 = MathUtilities.getRoot(frac1.getDenominator(), A1base);
		List<RootObject> firstRootList = new ArrayList<RootObject>();
		firstRootList.add(fracNumeratorRootA1);
		firstRootList.add(fracDenominatorRootA2);
		
		String A1 = A12 + " X " + A11;

		//multiply a number with anothernumber to the power something to get a whole number
		int A2power = MathUtilities.getRandomNumber(2, 3);
		int A2base = 2;
		int A21 = 2* MathUtilities.getRandomNumber(2, 6);
		int A22 = A21 * (int)Math.pow(2, A2power);
		String A2 = A21 + " X " + "$" + A2base + "^" + "{" +A2power+ "}" + "$";
		
		//this is whole number so the denominator is set to 1
		Fraction frac2 = Fraction.getReducedFraction(A22,1);
		RootObject fracNumeratorRootB1 = new RootObject();
		fracNumeratorRootB1.setWhole(frac2.getNumerator());
		fracNumeratorRootB1.setRoot(frac2.getDenominator());

		RootObject fracDenominatorRootB2 = new RootObject();
		fracDenominatorRootB2.setRoot(1);
		fracDenominatorRootB2.setWhole(1);
		List<RootObject> secondRootList = new ArrayList<RootObject>();
		secondRootList.add(fracNumeratorRootB1);
		secondRootList.add(fracDenominatorRootB2);
		
		Map<Integer, List<RootObject>> rootListMap = new LinkedHashMap<Integer, List<RootObject>>();
		rootListMap.put(1, firstRootList);
		rootListMap.put(2, secondRootList);
		
		NumberObject numeratorObject = MathUtilities.performRootOperation(rootListMap).get(0);
		NumberObject denominatorObject = MathUtilities.performRootOperation(rootListMap).get(1);
		List<NumberObject> numberObjectList = new ArrayList<NumberObject>();
		numberObjectList.add(numeratorObject);
		numberObjectList.add(denominatorObject);
		
		result = MathUtilities.formatNumberObject(numberObjectList) ;
				
		question = A2 + " + " + A1;
		
		answer.setAnswer(result);
		
		//fake answers
		List<String> fakeAnswers = getFakeAnswers(numberObjectList);
		
		answer.setType(Constants.RADIO_TYPE);
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH) + "  " + question, null);
		questionList.add(qLine1);
	//	questionList.add(new QuestionLine(question, ""));
		questionList.add(new QuestionLine(answer.getAnswer(),Constants.RADIO_TYPE ));
		for (int i=0; i<fakeAnswers.size(); i++ ) {
			questionList.add(new QuestionLine(fakeAnswers.get(i), Constants.RADIO_TYPE));
		}
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * 2root2 - 3(root2)^3 + 5(root3)^2 + 3(root2)^4
	 */
	public Problem getProblem3(MathConfiguration mathConfig) {

		String question = "";
		Answer answer = new Answer();
		String result = "";

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		//A. construct 3(root2)^3 
		//A.1 construct (root2)^3
		int A1power = MathUtilities.getRandomNumber(1,6);
		int A1base = 2;
		int n1= 0;
		String A11 = "$\\sqrt"+A1base+ "^"+ "{" +A1power+ "}";
		RootObject A11R = convertSquareRoottoRootObject(A1base, A1power, 2);

		//A.2 Construct 3
		int A12 = -3;//MathUtilities.getRandomNumber(-3, 3);
		if (A12 ==0) A12= 3;
		
		if (A12 < 0)
			//convert 3(root2)^3  to a RootObject. First make that a square- square(3*root2^3)= square(6root2)= 72  and then make rootobject 
			n1 = -(int)Math.pow(A11R.getWhole()*A12, 2)*A11R.getRoot();
		else 
			n1 = (int)Math.pow(A11R.getWhole()*A12, 2)*A11R.getRoot();
		
		Fraction frac1 = Fraction.getReducedFraction(n1,1);
		RootObject fracNumeratorRootA1 = MathUtilities.getRoot(frac1.getNumerator(), A1base);
		RootObject fracDenominatorRootA2 = MathUtilities.getRoot(frac1.getDenominator(), A1base);
		List<RootObject> firstRootList = new ArrayList<RootObject>();
		firstRootList.add(fracNumeratorRootA1);
		firstRootList.add(fracDenominatorRootA2);
		
		String A1 = A12 + A11;

		
		//construct second one
		int B1power = MathUtilities.getRandomNumber(1,3);
		int B1base = MathUtilities.getRandomNumber(2,5);

		RootObject B11R = convertSquareRoottoRootObject(B1base, B1power, 2);
		
		int B12 = MathUtilities.getRandomNumber(1, 3);
		
		//convert 3(root2)^3  to a RootObject. First make that a square- square(3*root2^3)= square(6root2)= 72  and then make rootobject 
		int n2= (int)Math.pow(B11R.getWhole()*B12, 2)*B11R.getRoot();
		Fraction bfrac1 = Fraction.getReducedFraction(n2, 1);
		RootObject fracNumeratorRootB1 = MathUtilities.getRoot(bfrac1.getNumerator(), 2);
		RootObject fracDenominatorRootB2 = MathUtilities.getRoot(bfrac1.getDenominator(), 2);
		List<RootObject> secondRootList = new ArrayList<RootObject>();
		secondRootList.add(fracNumeratorRootB1);
		secondRootList.add(fracDenominatorRootB2);
			
		String B1 = A1 + " + " + B12 + "\\sqrt"+B1base+ "^"+ "{" +B1power+ "}";

		
		
		//Construct third one
		int C1power = MathUtilities.getRandomNumber(1,6);
		int C1base = 2;
		RootObject C11R = convertSquareRoottoRootObject(C1base, C1power, 2);

		//A.2 Construct 3
		int C12 = MathUtilities.getRandomNumber(1, 3);
		
		//convert 3(root2)^3  to a RootObject. First make that a square- square(3*root2^3)= square(6root2)= 72  and then make rootobject
		int n3 = (int)Math.pow(C11R.getWhole()*C12, 2)*C11R.getRoot();
		Fraction cfrac1 = Fraction.getReducedFraction(n3, 1);
		RootObject fracNumeratorRootC1 = MathUtilities.getRoot(cfrac1.getNumerator(), A1base);
		RootObject fracDenominatorRootC2 = MathUtilities.getRoot(cfrac1.getDenominator(), C1base);
		List<RootObject> thirdRootList = new ArrayList<RootObject>();
		thirdRootList.add(fracNumeratorRootC1);
		thirdRootList.add(fracDenominatorRootC2);
		
		String C1 = B1 + " + " + C12 + "\\sqrt"+C1base+ "^"+ "{" +C1power+ "}" + "$";
		logger.debug("The Number" + C1);
		
		List<RootObject> listOfRootObjects = new ArrayList<RootObject>();
		listOfRootObjects.add(fracNumeratorRootA1);
		listOfRootObjects.add(fracNumeratorRootB1);
		listOfRootObjects.add(fracNumeratorRootC1);
		
		
		List<RootObject> denominatorRootObjectList = new ArrayList<RootObject>();
		RootObject denominatorRoot = new RootObject();
		denominatorRoot.setRoot(1);
		denominatorRoot.setWhole(1);
		denominatorRootObjectList.add(denominatorRoot);
		

		//put the firstone as numerator and the second one as denominator in the map as key 1 and 2 respectively
		Map<Integer, List<RootObject>> rootListMap = new LinkedHashMap<Integer, List<RootObject>>();
		rootListMap.put(1, firstRootList);
		rootListMap.put(2, secondRootList);
		rootListMap.put(3, thirdRootList);
		
			
		//get the map as numberobject
		NumberObject numeratorObject = MathUtilities.performRootOperation(rootListMap).get(0);
		NumberObject denominatorObject = MathUtilities.performRootOperation(rootListMap).get(1);
		
		List<NumberObject> numberObjectList = new ArrayList<NumberObject>();
		numberObjectList.add(numeratorObject);
		numberObjectList.add(denominatorObject);
		
		result = MathUtilities.formatNumberObject(numberObjectList) ;
				
		question = C1;
		
		answer.setAnswer(result);
		
		//fake answers
		List<String> fakeAnswers = getFakeAnswers(numberObjectList);
		
		answer.setType(Constants.RADIO_TYPE);
		
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH) + "  " + question, null);
		questionList.add(qLine1);
	//	questionList.add(new QuestionLine(question));
		questionList.add(new QuestionLine(answer.getAnswer(), Constants.RADIO_TYPE));
		for (int i=0; i<fakeAnswers.size(); i++ ) {
			questionList.add(new QuestionLine(fakeAnswers.get(i), Constants.RADIO_TYPE));
		}
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(questionList, answer.getAnswer());
		answer.setAnswerOption(correctAnswerOption);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	public List<String> getFakeAnswers(List<NumberObject> nObjects) {

		List<String> fakeAnswers = new ArrayList<String>();

		//need three fake answers
		for (int m = 2; m < 5; m++) {

			nObjects.get(0).setCommonFactor(nObjects.get(0).getCommonFactor() * m);

			for (int i = 0; i < nObjects.size(); i++) {
				NumberObject no = nObjects.get(i);

				Map<Integer, Integer> rMap = no.getRootObject();
				Iterator<?> it = rMap.entrySet().iterator();

				while (it.hasNext()) {
					@SuppressWarnings("unchecked")
					Entry<Integer, Integer> nextEntry = (Entry<Integer, Integer>) it.next();
					Map.Entry<Integer, Integer> entry = nextEntry;
					Integer key = entry.getKey();
					Integer value = entry.getValue();
					// just add 1 to the value
					value = value + m;
					rMap.put(key, value);
				}
			}

			fakeAnswers.add(MathUtilities.formatNumberObject(nObjects));
		}

		return fakeAnswers;
	}
	
	/*
	 * sqrt(2)^3 = 2 sqrt(2)
	 * pow = 3
	 * sqrt =2
	 * % operation gives remainder which is the root section
	 * operation shows that what should be the new whole number
	 */
	
	public static RootObject convertSquareRoottoRootObject(int num, int pow, int sqrt) {
		
		RootObject rb = new RootObject();

		int num1 = (int)Math.pow(num, Math.abs(pow));
		rb = MathUtilities.getRoot(num1, sqrt);
		
		return rb;
	}
	

}
