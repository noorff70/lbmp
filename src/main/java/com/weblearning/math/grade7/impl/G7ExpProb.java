package com.weblearning.math.grade7.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.GraphObject;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.Variable;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.grade8.impl.GR8_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7ExpProb extends GenericQuestion{
	
	@Autowired
	private RestMathClientService restMathClient;

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		

		List<Problem> problemList = new ArrayList<Problem>();
		
		problemList.add(getProblem1(mathConfig));
		problemList.add(getProblem2(mathConfig));
		problemList.add(getProblem3(mathConfig));
		problemList.add(getProblem4(mathConfig));
		problemList.add(getProblem5(mathConfig));
		
		restMathClient = new RestMathClientServiceImpl();
		problemList = restMathClient.returnGraph(problemList);
	
		return problemList;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		int headCount=0, tailCount=0;
						
		GraphObject go = new GraphObject();
		List<Variable> vList = new LinkedList<Variable>();
		
		Variable head = new Variable();
		head.setVariableName("Head");
		List<String> headList = new LinkedList<String>();
		for (int i=0; i< 1; i++) {
			headCount = MathUtilities.getRandomNumber(2, 10);
			headList.add(Integer.toString(headCount));
		}
		head.setValueList(headList);
		
		Variable tail = new Variable();
		tail.setVariableName("Tail");
		List<String> tailList = new LinkedList<String>();
		for (int i=0; i< 1; i++) {
			tailCount = MathUtilities.getRandomNumber(2, 10);
			tailList.add(Integer.toString(tailCount));
		}
		tail.setValueList(tailList);
		
		vList.add(head);
		vList.add(tail);
		
		go.setVariableList(vList);
		go.setGraphType(Constants.TABLE);
		
		String ans1 = Integer.toString(headCount+tailCount);
		String ans2 = Integer.toString(headCount);
		String ans3 = Integer.toString(tailCount);
		String ans4 = Integer.toString(headCount) + "/" + Integer.toString(headCount+tailCount);
		String ans5 = Integer.toString(tailCount) + "/" + Integer.toString(headCount+tailCount);
		
		
		question = "Steve Tossed a coin and got the Heads and Tails as shown in the table above."   ;
		
		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "What is total observation?"+ GR8_Constants.ANSWER_TO_QUESTION + ans1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is total Heads outcome?"+ GR8_Constants.ANSWER_TO_QUESTION + ans2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is total Tails outcome?"+ GR8_Constants.ANSWER_TO_QUESTION + ans3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is relative frequency of Heads?"+ GR8_Constants.ANSWER_TO_QUESTION + ans4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is relative frequency of Tails?"+ GR8_Constants.ANSWER_TO_QUESTION + ans5  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.EXPERIMENTAL_PROBABILITY, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGraphObject(go);
		problem.setAnswer(answ);

		return problem;
	}
	
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="", question1="", question2="", question3="", question4="", question5="";
		String answer1="", answer2="", answer3="", answer4="", answer5="";
		
		int redBall = MathUtilities.getRandomNumber(2, 5);
		int yellowBall = MathUtilities.getRandomNumber(2, 5);
		int blackBall = MathUtilities.getRandomNumber(2, 5);
		int total = redBall+yellowBall+blackBall;
		
		question = "There are some red, yellow and blue balls in a jar. Jim picked " + Integer.toString(redBall) 
			+ ", " + Integer.toString(yellowBall) + ", and " + Integer.toString(blackBall) + " Red, Yellow and Blue balls respectively from the jar" ; 
		
		question1 = "What is total observations?";
		answer1 = Integer.toString(total);
		
		question2= "What is relative frequency for picking a red ball? Write in fractions(Don't reduce fraction).";
		answer2 = Integer.toString(redBall) + "/" + Integer.toString(total);
		
		question3= "What is relative frequency for picking a yellow ball? Write in decimals.";
		answer3 = new BigDecimal((double)yellowBall/total).setScale(2, RoundingMode.HALF_UP).toString();
		
		question4= "What is relative frequency for picking a black ball? Write in percentage(put % sign at end).";
		answer4 = new BigDecimal((double)(blackBall*100)/total).setScale(2, RoundingMode.HALF_UP).toString()+"%";
		
		question5= "What is relative frequency for not picking a black ball? Write in fraction (don't reduce)";
		answer5 = Integer.toString(redBall+yellowBall) + "/" + Integer.toString(total);
		
			
		//questionList.add(new QuestionLine( mSource.getMessage(GR7_Constants.EXPERIMENTAL_PROBABILITY, null, Locale.ENGLISH), null, Constants.DEFAULT));
		questionList.add(new QuestionLine(question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( question1 +	Constants.ANSWER_TO_QUESTION + answer1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question2 +	Constants.ANSWER_TO_QUESTION + answer2 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question3 +	Constants.ANSWER_TO_QUESTION + answer3, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question4 + 	Constants.ANSWER_TO_QUESTION  + answer4, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( question5 + Constants.ANSWER_TO_QUESTION  + answer5, null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		

		String heading = mSource.getMessage(GR7_Constants.EXPERIMENTAL_PROBABILITY, null, Locale.ENGLISH);
		answ.setAnswer("BLANK");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String q1="", q2="", q3="", q4="";
		String a1="", a2="", a3="", a4="";
						
		GraphObject go = new GraphObject();
		List<Variable> vList = new LinkedList<Variable>();
		
		Variable antMan = new Variable();
		antMan.setVariableName("Ant Man");
		List<String> antManList = new LinkedList<String>();
		int antCount = MathUtilities.getRandomNumber(10, 15);
		antManList.add(Integer.toString(antCount));
		antMan.setValueList(antManList);
		
		Variable spiderMan = new Variable();
		spiderMan.setVariableName("Spider Man");
		List<String> spiderList = new LinkedList<String>();
		int spiderCount = MathUtilities.getRandomNumber(10, 15);
		spiderList.add(Integer.toString(spiderCount));
		spiderMan.setValueList(spiderList);
		
		Variable ironMan = new Variable();
		ironMan.setVariableName("Iron Man");
		List<String> ironList = new LinkedList<String>();
		int ironCount = 30-antCount -spiderCount;
		ironList.add(Integer.toString(ironCount));
		ironMan.setValueList(ironList);		
		
		vList.add(antMan);
		vList.add(spiderMan);
		vList.add(ironMan);
		
		go.setVariableList(vList);
		go.setGraphType(Constants.TABLE);
		
		q1 = "Write in percentage the relative frequency of students liking Spider Man. Put Percentage at end.";
		a1 = new BigDecimal((double)(spiderCount*100)/30).setScale(2, RoundingMode.HALF_UP).toString();
		
		q2 = "Write in fraction the relative frequency of students not liking Ant Man (don't reduce).";
		a2 = Integer.toString(spiderCount+ironCount) + "/" + Integer.toString(30);
		
		q3 = "Write in fraction the relative frequency of Students like either Spider Man or Ant Man (don't reduce)?";
		a3 = Integer.toString(spiderCount+antCount) + "/" + Integer.toString(30);
		
		q4 = "Write in decimals the relative frequency of students not liking Spider Man";
		a4 = new BigDecimal((double)(antCount+ironCount)/30).setScale(2, RoundingMode.HALF_UP).toString();

		

		question = "The above table shows how many student in a class like different movies"  ;
		
		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( q1 + GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q2 + GR8_Constants.ANSWER_TO_QUESTION + a2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q3 + GR8_Constants.ANSWER_TO_QUESTION + a3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q4 + GR8_Constants.ANSWER_TO_QUESTION + a4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.EXPERIMENTAL_PROBABILITY, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGraphObject(go);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String q1="", q2="", q3="", q4="", q5="";
		String a1="", a2="", a3="", a4="", a5="";
		
		int total = MathUtilities.getRandomNumber(25, 30);
		int head = MathUtilities.getRandomNumber(10, 20);
		int tail = total-head;
		
		question= "You tossed a coin and the relative frequency for Head was $\\frac{" + Integer.toString(head)+ "}{" + Integer.toString(total) + "}$" ;
		
		q1 = "What was the total observation?";
		a1 = Integer.toString(total);
		
		q2 = "How many times Tail came up?";
		a2 = Integer.toString(tail);
		
		q3 = "What is the relative frequency of Tail";
		a3 = Integer.toString(tail) + "/" + Integer.toString(total);
		
		q4 = "Write in decimals the relative frequency of Tail";
		a4 = new BigDecimal((double)(tail)/total).setScale(2, RoundingMode.HALF_UP).toString();

		q5="Write in percentage relative frequency of Head (two decimals and add percentage at end)";
		a5 = new BigDecimal((double)(head*100)/total).setScale(2, RoundingMode.HALF_UP).toString();
		
		questionList.add( new QuestionLine( question, null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( q1 + GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q2 + GR8_Constants.ANSWER_TO_QUESTION + a2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q3 + GR8_Constants.ANSWER_TO_QUESTION + a3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q4 + GR8_Constants.ANSWER_TO_QUESTION + a4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( q5 + GR8_Constants.ANSWER_TO_QUESTION + a5  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.EXPERIMENTAL_PROBABILITY, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="You have three outcomes from a survey which are a, b and c. What would be the relative frequency of a (put parenthesis)?";
		String answer= "a"+ "/" + "(a+b+c)";
		
		questionList.add(new QuestionLine(question, null, Constants.DEFAULT));

		String heading = mSource.getMessage(GR7_Constants.EXPERIMENTAL_PROBABILITY, null, Locale.ENGLISH);
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	

	
}
