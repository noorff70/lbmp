package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.Locale;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.core.io.FileSystemResourceLoader;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.MathUtilities;
//import com.weblearning.math.utilities.ProblemParser;
//import com.weblearning.math.utilities.ReplaceExpressionUtility;
//import com.weblearning.service.RestMathClientService;
//import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7AlgExpSimplify extends GenericQuestion{
	
		private static final Logger logger = Logger.getLogger(G7AlgebricExpEval1.class);

		// @Autowired
		//private RestMathClientService restMathClient;

		public List<?> getQuestions(MathConfiguration mathConfig) {
			// TODO Auto-generated method stub

			List<Problem> g7AgExpression = new ArrayList<Problem>();

			g7AgExpression.add(getProblem1(mathConfig));
			g7AgExpression.add(getProblem2(mathConfig));
			g7AgExpression.add(getProblem3(mathConfig));
			g7AgExpression.add(getProblem4(mathConfig));
			g7AgExpression.add(getProblem5(mathConfig));
			g7AgExpression.add(getProblem6(mathConfig));
			g7AgExpression.add(getProblem7(mathConfig));
			g7AgExpression.add(getProblem8(mathConfig));
			g7AgExpression.add(getProblem9(mathConfig));
			g7AgExpression.add(getProblem10(mathConfig));
			g7AgExpression.add(getProblem11(mathConfig));
			g7AgExpression.add(getProblem12(mathConfig));
			g7AgExpression.add(getProblem13(mathConfig));
			g7AgExpression.add(getProblem14(mathConfig));
			g7AgExpression.add(getProblem15(mathConfig));
			g7AgExpression.add(getProblem16(mathConfig));
			g7AgExpression.add(getProblem17(mathConfig));
			g7AgExpression.add(getProblem18(mathConfig));
			g7AgExpression.add(getProblem19(mathConfig));
			g7AgExpression.add(getProblem20(mathConfig));
			g7AgExpression.add(getProblem21(mathConfig));
			g7AgExpression.add(getProblem22(mathConfig));
			g7AgExpression.add(getProblem23(mathConfig));
			g7AgExpression.add(getProblem24(mathConfig));
			g7AgExpression.add(getProblem25(mathConfig));

			return g7AgExpression;
		}

		/*
		 * 3x + 5x
		 */
		public Problem getProblem1(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(2, 5);

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(2, 5);
			
			question = "$"+ a1 + "x" + " + " + a2 + "x$" ;
			int temp = a1*x + a2*x;

			ans =Integer.toString(temp) ;

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		//3x +3 + 5x +8
		
		public Problem getProblem2(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(-2, -5);

			int a1 = MathUtilities.getRandomNumber(2, 9);
			int a2 = MathUtilities.getRandomNumber(2, 5);
			
			question = "$"+ a1 + "x" + " + " + a2 + "x$" ;
			int temp = a1*x + a2*x;

			ans =Integer.toString(temp) ;

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		
		public Problem getProblem3(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(1, 5);

			int a1 = MathUtilities.getRandomNumber(6, 10);
			int a2 = MathUtilities.getRandomNumber(2, 5);
			
			question = "$"+ a1 + "x" + " - " + a2 + "x$" ;
			int temp = a1*x - a2*x;

			ans =Integer.toString(temp) ;

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		
		public Problem getProblem4(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(1, 5);

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(6, 10);
			
			question = "$"+ a1 + "x" + " - " + a2 + "x$" ;
			int temp = a1*x - a2*x;

			ans =Integer.toString(temp) ;

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem5(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(-5, -1);

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(6, 10);
			
			question = "$"+ a1 + "x" + " - " + a2 + "x$" ;
			int temp = a1*x - a2*x;

			ans =Integer.toString(temp) ;

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem6(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = 0;

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(6, 10);
			
			question = "$"+ a1 + "x" + " - " + a2 + "x$" ;
			int temp = a1*x - a2*x;

			ans =Integer.toString(temp) ;

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem7(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(1, 5);

			int a2 = MathUtilities.getRandomNumber(2, 5);
			int a1 = MathUtilities.getRandomNumber(2, 5) * a2;
			
			question = "$"+ a1 + "x" + "\\over " + a2 + "$" ;
			int temp = a1*x/a2;

			ans =Integer.toString(temp) ;

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem8(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(1, 5);

			int a2 = MathUtilities.getRandomNumber(2, 5);
			int a1 = MathUtilities.getRandomNumber(2, 5) * a2;
			
			question = "$\\frac{"+ Integer.toString(a1)+ "}{" + Integer.toString(a2)+ "}"+"x$" ;
			int temp = a1*x/a2;

			ans =Integer.toString(temp) ;

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem9(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(-5, -1);

			int a2 = MathUtilities.getRandomNumber(2, 5);
			int a1 = MathUtilities.getRandomNumber(2, 5) * a2;
			
			question = "$\\frac{"+ Integer.toString(a1)+ "}{" + Integer.toString(a2)+ "x}"+"$" ;
			Fraction frac = new Fraction(a1, a2*x);

			ans = frac.toString();

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x)+ " .Answer in Fraction."));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem10(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(1, 5);
			int y = MathUtilities.getRandomNumber(1, 5);
	
			question = "$ 2x + 3y$" ;

			ans = Integer.toString(2*x + 3*y);

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x) + " and y= " + Integer.toString(y)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem11(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(1, 5);
			int y = MathUtilities.getRandomNumber(-5, -1);
	
			question = "$ 5x - 3y$" ;

			ans = Integer.toString(5*x - 3*y);

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x) + " and y= " + Integer.toString(y)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem12(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(-1, -5);
			int y = MathUtilities.getRandomNumber(1,5);
	
			question = "$ 2x^{2} + 3y$" ;

			ans = Integer.toString(2*x*x + 3*y);

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x) + " and value of y = " + Integer.toString(y)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem13(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(-1, -5);
			int y = MathUtilities.getRandomNumber(1,5);
	
			question = "$ x^{2} - y$" ;

			ans = Integer.toString(x*x - y);

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x) + " and value of y = " + Integer.toString(y)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem14(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(-1, -5);
			int y = MathUtilities.getRandomNumber(1,5);
	
			question = "$ x^{2} - y^{2}$" ;

			ans = Integer.toString(x*x - y*y);

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x) + " and value of y = " + Integer.toString(y)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem15(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(-1, -5);
			int y = MathUtilities.getRandomNumber(1,5);
	
			question = "$ (2x)^{2} + (3y)^{2}$" ;

			ans = Integer.toString(4*x*x + 9*y*y);

			questionList.add( new QuestionLine( "Find the value of expression when x = " + Integer.toString(x) + " and value of y = " + Integer.toString(y)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem16(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = -3;
			int y = 1;
	
			question = "$\\frac{ (2x)^{2} + (3y)^{2}}{xy}$" ;
			
			Fraction frac = new Fraction(4*x*x + 9*y*y, x*y);

			ans = frac.toString();

			questionList.add( new QuestionLine( "Find value of expression when x = " + Integer.toString(x) + " and value of y = " + Integer.toString(y)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem17(MathConfiguration mathConfig) {

			String question = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			int y = MathUtilities.getRandomNumber(2,5);
	
			question = "$\\frac{1}{y}$" ;

			Fraction frac = new Fraction(1, y);

			questionList.add( new QuestionLine( "Find the value of expression when value of y = " + Integer.toString(y)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(frac.toString());

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem18(MathConfiguration mathConfig) {

			String question = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			int y = MathUtilities.getRandomNumber(2,5);
	
			question = "$\\frac{1}{y}$" ;

			Fraction frac = new Fraction(1, y);

			questionList.add( new QuestionLine( "Find the value of expression when value of y = " + Integer.toString(y)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(frac.toString());

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem19(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int a = MathUtilities.getRandomNumber(-1, -5);
			int b = MathUtilities.getRandomNumber(1,5);
			int c = MathUtilities.getRandomNumber(5, 30);
			
	
			question = "$ (a)^{3} + (3b)^{2} - c$" ;

			ans = Integer.toString(a*a*a + 9*b*b - c);

			questionList.add( new QuestionLine( "Find the value of expression when a = " + 
					Integer.toString(a) + " and value of b = " + Integer.toString(b) + " and c = " + Integer.toString(c)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem20(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int a = MathUtilities.getRandomNumber(1, 5);
			int b = MathUtilities.getRandomNumber(1,5);
			int c = MathUtilities.getRandomNumber(5, 30);
			
	
			question = "$ c- (a)^{3} + (3b)^{2}$" ;

			ans = Integer.toString(c - a*a*a + 9*b*b);

			questionList.add( new QuestionLine( "Find the value of expression when a = " + 
					Integer.toString(a) + " and value of b = " + Integer.toString(b) + " and c = " + Integer.toString(c)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem21(MathConfiguration mathConfig) {

			String question = "";
		//	String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			int x = MathUtilities.getRandomNumber(2, 5);
			int b = MathUtilities.getRandomNumber(2, 5);
				
			question = "$\\frac{b}{x}$" ;

			Fraction frac = new Fraction(b, x);

			questionList.add( new QuestionLine( "Find the value of expression when b = " + Integer.toString(b) + " and x = " + Integer.toString(x)));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(frac.toString());

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem22(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			Fraction xFrac = new Fraction(1, 2);
				
			question = "$\\frac{2}{x}$" ;

			ans = Integer.toString(4);

			questionList.add( new QuestionLine( "Find the value of expression when x = " + xFrac));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem23(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			Fraction xFrac = new Fraction(1, 2);
				
			question = "$\\frac{2}{2x}$" ;

			ans = Integer.toString(2);

			questionList.add( new QuestionLine( "Find the value of expression when x = " + xFrac));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem24(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			Fraction xFrac = new Fraction(1, 2);
			Fraction yFrac = new Fraction(1, 2);
				
			question = "$\\frac{1}{x} + \\frac{1}{y}$" ;

			Fraction fracAnswer = new Fraction(5, 2);

			questionList.add( new QuestionLine( "Find the value in Fraction for expression when x and y are  = " + xFrac + ",and " + yFrac));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(fracAnswer.toString());

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem25(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();
			Fraction xFrac = new Fraction(1, 2);
			Fraction yFrac = new Fraction(1, 2);
				
			question = "$\\frac{1}{x} + \\frac{1}{y}$" ;

			ans  = "2.5";

			questionList.add( new QuestionLine( "Find the value in Decimals for expression when x and y are  = " + xFrac + ",and " + yFrac));
			questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			answer.setAnswer(ans);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Simplification";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
			
			problem.setAnswer(answer);

			return problem;
		}
		
	}
