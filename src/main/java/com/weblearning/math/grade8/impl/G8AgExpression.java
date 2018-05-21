package com.weblearning.math.grade8.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.utility.FractionObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8AgExpression extends GenericQuestion {

	private static final Logger logger = Logger.getLogger(G8AgExpression.class);

	// @Autowired
	private RestMathClientService restMathClient;

	public List<?> getQuestions(MathConfiguration mathConfig) {
		// TODO Auto-generated method stub

		List<Problem> g8AgExpression = new ArrayList<Problem>();

		for (int i = 0; i < 5; i++)
			g8AgExpression.add(getProblem1(mathConfig));
		
		
		restMathClient = new RestMathClientServiceImpl();
		g8AgExpression = restMathClient.returnAnswerList(g8AgExpression);
		
		g8AgExpression = assignAnswer(g8AgExpression);

		return g8AgExpression;
	}

	/*
	 * 3x + 10 -5x + 8
	 */
	public Problem getProblem1(MathConfiguration mathConfig) {

		String question = "";
		String ans = "";
		String a1Sign, a2Sign, n1Sign, n2Sign;

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		Answer answer = new Answer();

		MessageSource mSource = mathConfig.getmSource();

		int a1 = MathUtilities.getRandomNumber(-10, 20);
		if ( a1== 0) a1 = 3;
		int a2 = MathUtilities.getRandomNumber(-10, 20);
		if (a2 ==0) a2 = 5;
		int n1 = MathUtilities.getRandomNumber(-10, 20);
		int n2 = MathUtilities.getRandomNumber(-10, 20);
		
		if (a1 < 0)
			a1Sign = ""; else a1Sign = "-";
		if (a2>=0)
			a2Sign = "+"; else a2Sign = "-";
		if (n1>=0)
			n1Sign = "+"; else n1Sign = "-";
		if (n2>=0)
			n2Sign = "+"; else n2Sign = "-";

		question = a1Sign + Math.abs(a1)+ "x" + a2Sign + Math.abs(a2)+ "x" + n1Sign + Math.abs(n1) + n2Sign + Math.abs(n2);


		ans = a1Sign + Math.abs(a1)+ "*x" + a2Sign + Math.abs(a2)+ "*x" +n1Sign+ Math.abs(n1) + n2Sign + Math.abs(n2) ;

		questionList.add( new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH) , null, null));
		questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
	
		List<AnswerLine> answerList = new LinkedList<AnswerLine>();
		answerList.add(new AnswerLine(ans));
		answerList.add( new AnswerLine(a1Sign + Math.abs(a1)+ "*x" + a2Sign + Math.abs(a2)+ "*x" + n1Sign + Integer.toString(Math.abs(n1+1)) + n2Sign + Math.abs(n2)));
		answerList.add(new AnswerLine(a1Sign + Math.abs(2*a1)+ "*x" + a2Sign+ Math.abs(a2)+ "*x" + n1Sign+ Math.abs(n1) + n2Sign + Integer.toString(Math.abs(n2-1))));
		answer.setAnswerList(answerList);

		logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());


		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, "", heading, null, Constants.RANK_ONE, Constants.RADIO_TYPE);
		problem.setAnswer(answer);

		return problem;
	}

	
	public List<Problem> assignAnswer (List<Problem> problemList) {
		
		for (int i=0; i< problemList.size(); i++) {
			Problem prb = problemList.get(i);
			Answer ans = prb.getAnswer();
			//set the first one as correct answer
			ans.setAnswer(ans.getAnswerList().get(0).getAnswerLn().replaceAll("$", ""));
			//rearrange answers
			List<?>answerList = MathUtilities.getQuestionList(ans.getAnswerList(), ans.getAnswerList().size() - 1, 0);
			
			String correctAnswerOption = MathUtilities.getCorrectAnswerPosition(answerList, ans.getAnswer());
			ans.setAnswerOption(correctAnswerOption);
		}
		
		return problemList;
	}
	
	

	public String getEquation(List<FractionObject> fracList) {

		String result = "";

		for (int i = 0; i < fracList.size(); i++) {
			FractionObject f1 = new FractionObject();
			f1 = (FractionObject) fracList.get(i);

			if (f1.getDenominator() == 1) {
				if (f1.getUnknownValueNumerator() == null) {
					if (f1.getNumerator() >= 0) {
						if (StringUtils.isEmpty(result))
							result = Integer.toString(f1.getNumerator());
						else
							result = result + " + " + Integer.toString(f1.getNumerator());
					} else if (f1.getNumerator() < 0) {
						result = result + " " + Integer.toString(f1.getNumerator());
					}
				}
				if (f1.getUnknownValueNumerator() != null) {
					if (!StringUtils.isEmpty(result)) {
						result = result + f1.getUnknownValueNumerator();
					}
				}
			} else {
				result = result + "$" + f1.getUnknownValueNumerator() + "\\over" + f1.getUnknownValueDenominator()
						+ "$";
			}

			if (f1.getUnknownValueDenominator() != null) {

				result = result + f1.getPrefix() + "$" + f1.getUnknownValueNumerator() + "\\over"
						+ f1.getUnknownValueDenominator() + "$";
			} else {
				result = result + f1.getPrefix() + "$" + f1.getUnknownValueNumerator();
			}

		}
		result = MathUtilities.removeZeroAndOne(result);
		return result;
		// return "$" + result + "$";
	}

	public String findDenominatorLCM(List<FractionObject> fracList) {

		int fracDNumber = 1;
		String fracDString = "";

		for (int i = 0; i < fracList.size(); i++) {
			FractionObject f1 = fracList.get(i);

			if (f1.getDenominator() != 1) {
				fracDNumber = fracDNumber * f1.getDenominator();
			}

			if (f1.getUnknownValueDenominator() != null) {
				fracDString = f1.getUnknownValueDenominator();
			}
		}

		if (fracDNumber == 1) {
			return fracDString;
		} else
			return Integer.toString(fracDNumber);

	}

	public String getAnswer(List<FractionObject> fracList, String lcm) {

		String result = "";

		for (int i = 0; i < fracList.size(); i++) {
			FractionObject f1 = new FractionObject();
			f1 = (FractionObject) fracList.get(i);

			if (f1.getDenominator() == 1) {
				if (f1.getUnknownValueNumerator() == null) {
					if (f1.getNumerator() >= 0) {
						if (StringUtils.isEmpty(result))
							result = Integer.toString(f1.getNumerator() * Integer.parseInt(lcm) / f1.getDenominator());
						else
							result = result + " + "
									+ Integer.toString(f1.getNumerator() * Integer.parseInt(lcm) / f1.getDenominator());
					} else if (f1.getNumerator() < 0) {
						result = result + " "
								+ Integer.toString(f1.getNumerator() * Integer.parseInt(lcm) / f1.getDenominator());
					}
				}
				if (f1.getUnknownValueNumerator() != null) {
					if (!StringUtils.isEmpty(result)) {
						result = result + f1.getUnknownValueNumerator() + Integer.parseInt(lcm);
					}
				}
			} else {
				result = result + "$" + Integer.toString(f1.getNumerator()) + "\\over"
						+ Integer.toString(f1.getDenominator()) + "$";
			}

		}
		result = MathUtilities.removeZeroAndOne(result);
		return result;
		// return "$" + result + "$";
	}

}
