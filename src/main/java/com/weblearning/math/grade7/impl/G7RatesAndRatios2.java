package com.weblearning.math.grade7.impl;

//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.Locale;

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
 
import org.apache.commons.math3.fraction.Fraction;

public class G7RatesAndRatios2 extends GenericQuestion{


	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		List<Problem> problemList = new ArrayList<Problem>();
		
		problemList.add(getProblem1(mathConfig));
		problemList.add(getProblem2(mathConfig));
		problemList.add(getProblem3(mathConfig));
		problemList.add(getProblem4(mathConfig));
		problemList.add(getProblem5(mathConfig));
		problemList.add(getProblem6(mathConfig));
		problemList.add(getProblem7(mathConfig));
		problemList.add(getProblem8(mathConfig));
		
	/*	resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( "classpath:/locale/math/grade7/problems/RatesAndRatios/Ratios1.xml" );

	
	    List<Problem> pList = ProblemParser.getProblems(baseresource);
	    
	    //assign variable values
	    pList = ReplaceExpressionUtility.replaceStringWithVariableValue(problemList);
	    
	    //get expression value
	    restMathClient = new RestMathClientServiceImpl();
	    pList = restMathClient.returnExpression(problemList);

	   
	    pList = ReplaceExpressionUtility.replaceExpressionWithValue(problemList);
	    
	    for (int i=0; i< pList.size(); i++) {
	    	problemList.add(pList.get(i));
	    }
	    */
	    
	
		return problemList;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
			
		questionList.add(new QuestionLine( "There are 8 Apples and 10 Oranges in a fruit basket"));
		questionList.add(new QuestionLine( "What is the ratio of Apples to Oranges?" +	Constants.ANSWER_TO_QUESTION + "4:5" ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is the ration of Oranges to Apples?" +	Constants.ANSWER_TO_QUESTION + "5:4" ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is the ratio of Apples to all fruits?" +	Constants.ANSWER_TO_QUESTION + "4:9", null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is the ratio of Oranges to all fruits?" +	Constants.ANSWER_TO_QUESTION + "5:9", null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = "Ratios";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		int boys = MathUtilities.getRandomNumber(5,8) * 5;
		int girls = MathUtilities.getRandomNumber(5, 8) * 5;
		int teachers = MathUtilities.getRandomNumber(2,3)*5;
		
		Fraction boyToGirl = new Fraction(boys, girls);
		Fraction girlToBoys = new Fraction(girls, boys);
		//Fraction boyGirlTeacher = new Fraction (boys, girls, teachers);
		Fraction studentToTeacher = new Fraction(boys + girls, teachers);
		Fraction girlToStudents = new Fraction(girls, boys + girls);
		Fraction boysToTotal = new Fraction(boys, boys+girls+teachers);

		String answer="";
			
		questionList.add(new QuestionLine( "A group of students and teachers went for a school tour. There were " + boys + ",boys " + girls + ", girls and,  " + teachers + "teachers."
				+ " Now answer the following. Put : when writing ratio"  ));
		questionList.add(new QuestionLine( "Ratio of boys to girls" +	Constants.ANSWER_TO_QUESTION + boyToGirl.getNumerator() + ":" + boyToGirl.getDenominator() ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Ratio of girls to boys" +	Constants.ANSWER_TO_QUESTION + girlToBoys.getNumerator() + ":" + girlToBoys.getDenominator() ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Ratio of student to teacher" +	Constants.ANSWER_TO_QUESTION + studentToTeacher.getNumerator() + ":" + studentToTeacher.getDenominator() ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Ratio of girls to all students" +	Constants.ANSWER_TO_QUESTION + girlToStudents.getNumerator() + ":" + girlToStudents.getDenominator() ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "Ratio of boys to all in the tour" +	Constants.ANSWER_TO_QUESTION + boysToTotal.getNumerator() + ":" + boysToTotal.getDenominator() ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = "Ratios";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		int fiction = 2;
		int horror = 3;
	//	int mystery = 5;
		
		int factor = MathUtilities.getRandomNumber(5, 8);
		int total = factor * (fiction + horror);
		

		String answer="";
			
		questionList.add(new QuestionLine( "A book self contains two different types of books; fiction, and horror. The ratio of fiction: horror is " + fiction + ":"
				+ horror +  "."));
		questionList.add(new QuestionLine( "If there are "+ fiction*factor + " fiction books, then how many horror books are there" +	Constants.ANSWER_TO_QUESTION + horror*factor ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is total number of books?" +	Constants.ANSWER_TO_QUESTION + total ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
		String heading = "Ratios";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		int fiction = 3;
		int mystery = 4;
	//	int mystery = 5;
		
		int factor = MathUtilities.getRandomNumber(5, 8);
		int total = factor * (fiction + mystery);
		

		String answer="";
			
		questionList.add(new QuestionLine( "A book self contains two different types of books; fiction, and horror. The ratio of fiction: horror is " + fiction + ":"
				+ mystery +  ". Total number of books are " + total + "."));
		questionList.add(new QuestionLine( "How many fiction books are there?" +	Constants.ANSWER_TO_QUESTION + fiction*factor ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "How many mystery books are there?" +	Constants.ANSWER_TO_QUESTION + mystery*factor ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
		String heading = "Ratios";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		int chicken = MathUtilities.getRandomNumber(3, 8);
		int ducks = MathUtilities.getRandomNumber(2 , 4);
	//	int mystery = 5;
		
		Fraction frac1 = new Fraction(chicken, ducks);
		
		int factor = MathUtilities.getRandomNumber(5, 8);
		int total = factor * (chicken + ducks);
		

		String answer="";
			
		questionList.add(new QuestionLine( "A poultry farm has chickens and ducks at the ratio of  " + frac1.getNumerator() + ":" + frac1.getDenominator() +
				 " There are total " + total + " birds in the farm."));
		questionList.add(new QuestionLine( "How many chicken are there? " +	Constants.ANSWER_TO_QUESTION + chicken*factor ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "How many ducks are there?" +	Constants.ANSWER_TO_QUESTION + ducks*factor ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
		String heading = "Ratios";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		int apple = 2;
		int orange = 3;
	//	int mystery = 5;
		
		
		int factor = MathUtilities.getRandomNumber(5, 8);
		int total = factor * (apple + orange);
		
		int totalApple = apple*factor;
		int totalOrange = orange*factor;
		
		Fraction frac1 = new Fraction(totalOrange , totalApple);

		String answer="";
			
		questionList.add(new QuestionLine( "Julie's mother brought apple and orange juice packs for Julie's birthday party. Total number of juice packs are " + total
				+ " . Total apple juice packs are " + totalApple));
		questionList.add(new QuestionLine( "How many orange packs are there?" +	Constants.ANSWER_TO_QUESTION + totalOrange ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is the ratio of orange: apple? " +	Constants.ANSWER_TO_QUESTION + frac1.getNumerator() + ":" + 
				frac1.getDenominator() ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "How many more apple juice pack needed to make ratio 1:1?" +	Constants.ANSWER_TO_QUESTION + Integer.toString(totalOrange - totalApple) ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
		String heading = "Ratios";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem7(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		//Double answer = (double) 0;
		String answer;
		
		QuestionLine qLine1 = new QuestionLine("3 Pens cost 6.00 and 2 pencils cost 1.00. What is the cost ratio of pen:pencil ");
		answer = "4:1";

		questionList.add(qLine1);

		String heading = "Ratios";
		answ.setAnswer(answer);
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig) {

		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();

		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		//Double answer = (double) 0;
		String answer;
		
		QuestionLine qLine1 = new QuestionLine("Ratio of Math: Physics students is 1:2. Number of Physics students are 14. How many more Math students needed to make "
				+ "the ratio of Math:Physics as 2:1?");
		answer = "21";

		questionList.add(qLine1);

		String heading = "Ratios";
		answ.setAnswer(answer);
		
		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
}
