package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

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
		
		//for (int i = 0; i < 5; i++)
		//	gExponentBasics.add(getProblem1(mathConfig));
		for (int i = 0; i < 5; i++)
			gExponentBasics.add(getProblem2(mathConfig));

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
		RootObject A11R = MathUtilities.convertRoottoWhole(A1base, A1power, 2);
		RootObject fakeA1= MathUtilities.convertRoottoWhole(A1base, A1power+1, 2);
		RootObject fakeA2= MathUtilities.convertRoottoWhole(A1base, A1power-1, 2);
		
		int A12 = 2* MathUtilities.getRandomNumber(2, 6);
		//ex A12= 12
		String A1 = A12 + " X " + A11;
		//get then root object for this integer
		RootObject A12R = new RootObject();
		A12R.setRoot(1);
		A12R.setWhole(A12);
		
		//now need to multiply the operation by passing on 2 root objects.
		RootObject r1 = new RootObject();
		RootObject fakeR1 = new RootObject();
		RootObject fakeR2 = new RootObject();
		ArrayList<RootObject> a1 = new ArrayList<RootObject>();
		ArrayList<RootObject> f1 = new ArrayList<RootObject>();
		ArrayList<RootObject> f2 = new ArrayList<RootObject>();
		a1.add(A11R);
		a1.add(A12R);
		
		f1.add(fakeA1);
		f1.add(A12R);
		
		f2.add(fakeA2);
		f2.add(A12R);
		//multiply 12 * 4*sqrt(2) = 48*sqrt(2)
		r1 = MathUtilities.multiplyRoots(a1);
		fakeR1 = MathUtilities.multiplyRoots(f1);
		fakeR2 = MathUtilities.multiplyRoots(f2);
	
		
		//multiply a number with anothernumber to the power something to get a whole number
		int A2power = MathUtilities.getRandomNumber(2, 3);
		int A2base = 2;
		int A21 = 2* MathUtilities.getRandomNumber(2, 6);
		int A22 = A21 * (int)Math.pow(2, A2power);
		String A2 = A21 + " X " + "$" + A2base + "^" + "{" +A2power+ "}" + "$";
		RootObject r2 = new RootObject();
		r2.setWhole(A22);
		r2.setRoot(1);
		
		List <RootObject> rList = new ArrayList<RootObject>();
		List <RootObject> fakeList1 = new ArrayList<RootObject>();
		List <RootObject> fakeList2 = new ArrayList<RootObject>();
		rList.add(r1);
		rList.add(r2);
		fakeList1.add(fakeR1);
		fakeList1.add(r2);
		fakeList2.add(fakeR2);
		fakeList2.add(r2);
		
		//format the number object
		NumberObject no = MathUtilities.createNumberObject(rList);
		NumberObject fakeNo1 = MathUtilities.createNumberObject(fakeList1);
		NumberObject fakeNo2 = MathUtilities.createNumberObject(fakeList1);
		
		String ans = MathUtilities.formatNumberObject(no);
		ans = format(ans);
		
		String fakeAns1 = MathUtilities.formatNumberObject(fakeNo1);
		fakeAns1 = format(fakeAns1);
		
		String fakeAns2 = MathUtilities.formatNumberObject(fakeNo2);
		fakeAns2 = format(fakeAns2);
		
		question = A2 + " + " + A1;
		

		answer.setAnswer(ans);
		
		answer.setType(Constants.RADIO_TYPE);
		

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH) + "  ");
		questionList.add(new QuestionLine(question));
		questionList.add(new QuestionLine(answer.getAnswer()));
		questionList.add(new QuestionLine(fakeAns2));
		//questionList.add(new QuestionLine("$" + base +"^"+power*2 +"$"));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	/*
	 * 8*2^2+6*sqrt(2)^-3
	 */
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		String question = "";
		Answer answer = new Answer();

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
		
		//ex- (sqrt(2)*3)- convert 4*sqrt(2)- whole-4, root-2
		int A1power = -3;//MathUtilities.getRandomNumber(-6,-2);
		int A1base = 2;
		String A11 = "$(\\sqrt"+A1base+ ")^"+ "{" +A1power+ "}" +"$";
		RootObject A11R = MathUtilities.convertRoottoWhole(A1base, A1power, 2);
		RootObject fakeA1= MathUtilities.convertRoottoWhole(A1base, A1power+1, 2);
		RootObject fakeA2= MathUtilities.convertRoottoWhole(A1base, A1power-1, 2);
		
		int A12 = 2* MathUtilities.getRandomNumber(2, 6);
		//ex A12= 12
		String A1 = A12 + " X " + A11;
		//get then root object for this integer
		RootObject A12R = new RootObject();
		A12R.setRoot(1);
		A12R.setWhole(A12);
		
		//now need to multiply the operation by passing on 2 root objects.
		RootObject r1 = new RootObject();
		RootObject fakeR1 = new RootObject();
		RootObject fakeR2 = new RootObject();
		ArrayList<RootObject> a1 = new ArrayList<RootObject>();
		ArrayList<RootObject> f1 = new ArrayList<RootObject>();
		ArrayList<RootObject> f2 = new ArrayList<RootObject>();
		a1.add(A11R);
		a1.add(A12R);
		
		f1.add(fakeA1);
		f1.add(A12R);
		
		f2.add(fakeA2);
		f2.add(A12R);
		//multiply 12 * 4*sqrt(2) = 48*sqrt(2)
		r1 = MathUtilities.multiplyRoots(a1);
		fakeR1 = MathUtilities.multiplyRoots(f1);
		fakeR2 = MathUtilities.multiplyRoots(f2);
	
		
		//multiply a number with anothernumber to the power something to get a whole number
		int A2power = MathUtilities.getRandomNumber(2, 3);
		int A2base = 2;
		int A21 = 2* MathUtilities.getRandomNumber(2, 6);
		int A22 = A21 * (int)Math.pow(2, A2power);
		String A2 = A21 + " X " + "$" + A2base + "^" + "{" +A2power+ "}" + "$";
		RootObject r2 = new RootObject();
		r2.setWhole(A22);
		r2.setRoot(1);
		
		List <RootObject> rList = new ArrayList<RootObject>();
		List <RootObject> fakeList1 = new ArrayList<RootObject>();
		List <RootObject> fakeList2 = new ArrayList<RootObject>();
		rList.add(r1);
		rList.add(r2);
		fakeList1.add(fakeR1);
		fakeList1.add(r2);
		fakeList2.add(fakeR2);
		fakeList2.add(r2);
		
		//format the number object
		NumberObject no = MathUtilities.createNumberObject(rList);
		NumberObject fakeNo1 = MathUtilities.createNumberObject(fakeList1);
		NumberObject fakeNo2 = MathUtilities.createNumberObject(fakeList1);
		
		String ans = MathUtilities.formatNumberObject(no);
		ans = format(ans);
		
		String fakeAns1 = MathUtilities.formatNumberObject(fakeNo1);
		fakeAns1 = format(fakeAns1);
		
		String fakeAns2 = MathUtilities.formatNumberObject(fakeNo2);
		fakeAns2 = format(fakeAns2);
		
		question = A2 + " + " + A1;
		

		answer.setAnswer(ans);
		
		answer.setType(Constants.RADIO_TYPE);
		

		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_EIGHT_EXPONENT_EXPRES_SELECT, null, Locale.ENGLISH) + "  ");
		questionList.add(new QuestionLine(question));
		questionList.add(new QuestionLine(answer.getAnswer()));
		questionList.add(new QuestionLine(fakeAns2));
		//questionList.add(new QuestionLine("$" + base +"^"+power*2 +"$"));
		
		questionList = MathUtilities.getQuestionList(questionList, questionList.size()-1, 1);
		
		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_EXPONENT_BASICS, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answer);

		return problem;
	}
	
	
	
	/*
	 * remove the trailing + sign
	 */
	public String format(String result) {
		
		StringBuilder sb = new StringBuilder(result);
		int index = result.lastIndexOf("+");
		sb.deleteCharAt(index);
		
		return sb.toString();
		
	}
	

}
