package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.Locale;

import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.core.io.FileSystemResourceLoader;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
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

public class G7AlgebricExpEval1 extends GenericQuestion{
	
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
				
			g7AgExpression = assignAnswer(g7AgExpression);
		

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

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(2, 5);
			
			question = "$"+ a1 + "x" + " + " + a2 + "x$" ;
			int temp = a1+a2;

			ans ="$" + temp+"x$" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "x" + " + " +a2 + " $"));
			answerList.add( new AnswerLine("$" +a2 + "x" + " + " +a1 + "$"));
			answerList.add(new AnswerLine("$" + a2 + "x$" ));
			answerList.add(new AnswerLine("$" + a1 + "x$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(2, 5);
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(-12, -20);
			
			question = "$"+ a1 + "x + " + Integer.toString(a3)+ " + " + a2 + "x "+ Integer.toString(a4) +"$" ;
			int temp1 = a1 + a2;
			int temp2 = a3 + a4;

			ans ="$" + temp1 +"x" + Integer.toString(temp2) +" $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "x +" + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x +" + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$" + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + "x$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(2, 5);
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(2, 10);
			
			question = "$"+ a1 + "x + " + Integer.toString(a3)+ " + " + a2 + "x + "+ Integer.toString(a4) +"  $" ;
			int temp1 = a1 + a2;
			int temp2 = a3 + a4;

			ans ="$" + temp1 +"x +" + Integer.toString(temp2) +" $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "x +" + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x +" + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$" + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + "x$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(-7, -20);
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(-11, -20);
			
			question = "$"+ a2 + "x + " + Integer.toString(a3)+ " + " + a1 + "x "+ Integer.toString(a4) +" $" ;
			int temp1 = a1 + a2;
			int temp2 = a3 + a4;
			

			ans ="$" + Integer.toString(temp2) + "  " + Integer.toString(temp1)+"x $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "x " + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x " + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$" + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + "x$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(-7, -20);
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(-11, -20);
			
			question = "$"+ a1 + "x " + Integer.toString(a2)+ "x " + a4 + " + " + Integer.toString(a3) +" $" ;
			int temp1 = a1 + a2;
			int temp2 = a3 + a4;

			ans ="$" + Integer.toString(temp2) + "  " + Integer.toString(temp1)+"x $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "x " + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x " + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$" + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + "x$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 =5;
			int a2 = -6;
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(-11, -20);
			
			question = "$"+ a1 + "x " + Integer.toString(a2)+ "x " + a4 + " + " + Integer.toString(a3) +" $" ;
			int temp1 = a1 + a2;
			int temp2 = a3 + a4;

			ans ="$" + Integer.toString(temp2) + "  " +"-x $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "x " + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x " + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$" + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + "x$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 =MathUtilities.getRandomNumber(2,10);
			int a2 = a1-1;
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(-11, -20);
			
			question = "$"+ a1 + "x - " + Integer.toString(a2)+ "x " + a4 + " + " + Integer.toString(a3) +" $" ;
			int temp1 = a1 - a2;
			int temp2 = a3 + a4;

			ans ="$ x" + Integer.toString(temp2) + " $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "x " + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x " + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$" + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + "x$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 =MathUtilities.getRandomNumber(2,10);
			int a2 = a1;
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(-11, -20);
			
			question = "$"+ a1 + "x - " + Integer.toString(a2)+ "x " + a4 + " + " + a3 +" $" ;
			int temp1 = a1 - a2;
			int temp2 = a3 + a4;

			ans ="$" + Integer.toString(temp2) + " $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "x + " + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x " + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$" + temp2 + "x$" ));
			answerList.add(new AnswerLine("$" + "x$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(-7, -20);
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(-11, -20);
			
			question = "$"+ a1 + "x " + Integer.toString(a2)+ "x " + a4 + " + " + Integer.toString(a3) +" + y $" ;
			int temp1 = a1 + a2;
			int temp2 = a3 + a4;

			ans ="$" + Integer.toString(temp2) + "  " + Integer.toString(temp1)+"x + y $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "y " + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x " + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$" + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + "y$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(-7, -20);
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(-11, -20);
			int a5 = MathUtilities.getRandomNumber(2,10);
			
			question = "$"+ a5 + "y + " + a1 + "x  " + a2 + "x " + a4 + " + " + a3 + " $" ;
			int temp1 = a1 + a2;
			int temp2 = a3 + a4;

			ans ="$" + Integer.toString(temp2) + " + " + a5 + "y "  + temp1 +"x$" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "y " + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x " + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$ y + " + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + "y$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(-7, -20);
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(-11, -20);
			int a5 = MathUtilities.getRandomNumber(2,10);
			
			question = "$"+ a5 + "y -( " + a1 + "x  " + a2 + "x) " + a4 + " + " + a3 + " $" ;
			int temp1 = (a1 + a2)*-1;
			int temp2 = a3 + a4;

			ans ="$" + temp2 + " + " + a5 + "y +"  + temp1 +"x$" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "y " + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x " + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$ y + " + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + " + y$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

	
			question = "$  5x + 2y + 2(2x + 3) - y $" ;

			ans ="$ 9x + y + 6 $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$6 + 2y + 9x $")) ;
			answerList.add( new AnswerLine("$6 + 9x + y$"));
			answerList.add(new AnswerLine("$ 5x -y + 3$" ));
			answerList.add(new AnswerLine("$-y + 5x + 6$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

	
			question = "$ x^{2} + 2y + 2(2x -3y) + y $" ;

			ans ="$ x^{2} + 4x -3y $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$x^{2} + 3x + 2 $") ) ;
			answerList.add( new AnswerLine("$x^{2} + 3x + 2y $") ) ;
			answerList.add( new AnswerLine("$x^{2} + x - 2y $") ) ;
			answerList.add( new AnswerLine("$ 3x + 2 + x^{2}$") ) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

	
			question = "$ 2x^{2} + 2y + 3(2x^{2} -y^{2}) + y $" ;

			ans ="$ 8x^{2} + 3y -3y^{2} $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$x^{2} + 3y + y^{2} $") ) ;
			answerList.add( new AnswerLine("$8x^{3} + 3y  - 3y^{2} $") ) ;
			answerList.add( new AnswerLine("$x^{2} + 3y - 3y^{2} $") ) ;
			answerList.add( new AnswerLine("$8x^{2} - 3y - 3y^{2} $") ) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

	
			question = "$ .2x - 1.5(4x - 10) +  .6 + 10x $" ;

			ans ="$ 4.2x + 15.6 $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$4x + 15 $") ) ;
			answerList.add( new AnswerLine("$4.2x + 15 $") ) ;
			answerList.add( new AnswerLine("$ 15.6 + 3.2x $") ) ;
			answerList.add( new AnswerLine("$4.23x + 15.6 $") ) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

	
			question = "$ .7x + .3x + 12 - 2.5 + 1.2y - .2y $" ;

			ans ="$ y + x + 9.5$" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("1.0x + 1y + 12") ) ;
			answerList.add( new AnswerLine("$1x + y + 9.5 $") ) ;
			answerList.add( new AnswerLine("$ y-x -.2 $") ) ;
			answerList.add( new AnswerLine("$x - y + 1.2 $") ) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem17(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();

	
			question = "$ 25 + 3y -1.2(-.3x - 5 + 2.5y) $" ;

			ans ="$ .36x + 31$" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("31 + .6x - 2.5y") ) ;
			answerList.add( new AnswerLine("$.36x - y + 32.76 $") ) ;
			answerList.add( new AnswerLine("$x + 32 $") ) ;
			answerList.add( new AnswerLine("$ 3y + .36x + 32.76 $") ) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem18(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();

	
			question = "$ 3x^{2} + y^{2} + -3(x^{2} - y^{2}) $" ;

			ans ="$ -2y^{2} $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$x^{2} + y^{2} $") ) ;
			answerList.add( new AnswerLine("$2x^{2} + 2y^{2} $") ) ;
			answerList.add( new AnswerLine("$x^{2} + y^{2} $") ) ;
			answerList.add( new AnswerLine("$2y^{2} $") ) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

	
			question = "$ y(3 + 5x) $" ;

			ans ="$ 3y + 5x $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$3 + 5x$") ) ;
			answerList.add( new AnswerLine("$5x + y $") ) ;
			answerList.add( new AnswerLine("$5x + 3 $") ) ;
			answerList.add( new AnswerLine("$y + 3x $") ) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

	
			question = "$ x(2.5x + 1.5x + 3) -2 $" ;

			ans ="$ 1 + 4x^{2} $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("x^{2}")  ) ;
			answerList.add( new AnswerLine("x^{2} + 1")  ) ;
			answerList.add( new AnswerLine("3x^{2}")  ) ;
			answerList.add( new AnswerLine("3x^{2} + 1")  ) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
			problem.setAnswer(answer);

			return problem;
		}
		
		public Problem getProblem21(MathConfiguration mathConfig) {

			String question = "";
			String ans = "";

			CreateProblem cProblem = new CreateProblem();
			List<QuestionLine> questionList = new LinkedList<QuestionLine>();
			Answer answer = new Answer();

			// MessageSource mSource = mathConfig.getmSource();

	
			question = "$ xy(3y + 5x) $" ;

			ans ="$ 3y^{2}x + 5x^{2}y $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$3y + 5x^{2}$")  ) ;
			answerList.add( new AnswerLine("$5x + 3y^{2} $")  ) ;
			answerList.add( new AnswerLine("$5x^{} + 3y $")   ) ;
			answerList.add( new AnswerLine("$5 + 3y^{2} $")  ) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

	
			question = "$ (x + y)x + 2xy $" ;

			ans ="$ x^{2} + 3xy $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$3y + x^{2}$")  ) ;
			answerList.add( new AnswerLine("$xy + x^{2} $")  ) ;
			answerList.add( new AnswerLine("$2x^{2} + xy $")   ) ;
			answerList.add( new AnswerLine("$2y + 3x^{2} $")  ) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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
			question = "$ -(x + 2y)x + 2xy $" ;

			ans ="$ -x^{2} $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$2x^{2}$")) ;
			answerList.add( new AnswerLine("$x^{2}$")) ;
			answerList.add( new AnswerLine("$2x^{2} + xy$")) ;
			answerList.add( new AnswerLine("$2x^{2- 2xy}$")) ;
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(2, 5);
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(2, 10);
			
			question = "$"+ a1 + "x + " + Integer.toString(a3)+ " + " + a2 + "x + "+ Integer.toString(a4) +"  $" ;
			int temp1 = a1 + a2;
			int temp2 = a3 + a4;

			ans ="$" + temp1 +"x +" + Integer.toString(temp2) +" $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "x +" + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x +" + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$" + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + "x$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

			int a1 = MathUtilities.getRandomNumber(2, 5);
			int a2 = MathUtilities.getRandomNumber(2, 5);
			int a3 = MathUtilities.getRandomNumber(2,10);
			int a4 = MathUtilities.getRandomNumber(2, 10);
			
			question = "$"+ a1 + "x + " + Integer.toString(a3)+ " + " + a2 + "x + "+ Integer.toString(a4) +"  $" ;
			int temp1 = a1 + a2;
			int temp2 = a3 + a4;

			ans ="$" + temp1 +"x +" + Integer.toString(temp2) +" $" ;

			questionList.add( new QuestionLine( "Select the correct option"));
			questionList.add( new QuestionLine( question, null, Constants.LATEX_FORMAT));
		
			List<AnswerLine> answerList = new LinkedList<AnswerLine>();
			answerList.add(new AnswerLine(ans));
			answerList.add( new AnswerLine("$" + a1 + "x +" + Integer.toString(temp1) + "$")) ;
			answerList.add( new AnswerLine("$" + a2 + "x +" + Integer.toString(temp2) + "$"));
			answerList.add(new AnswerLine("$" + temp2 + "$" ));
			answerList.add(new AnswerLine("$" + temp2 + "x$" ));
			answer.setAnswerList(answerList);

			logger.debug("Question: " + question + " " + "answer: " + answer.getAnswer());

			String heading = "Algebric Expression Evaluation";

			Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.RADIO_TYPE);
			
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

	}
