package com.weblearning.math.grade7.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.ProblemParser;
import com.weblearning.math.utilities.ReplaceExpressionUtility;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7RatesAndRatios extends GenericQuestion{

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private RestMathClientService restMathClient;

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		//PythonExpressionThread pExpress;
		
		resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( "classpath:/locale/math/grade7/problems/RatesAndRatios/Rates1.xml" );

	    //get all the problems
	    List<Problem> problemList = ProblemParser.getProblems(baseresource);
	    
	    //assign variable values
	    problemList = ReplaceExpressionUtility.replaceStringWithVariableValue(problemList);
	    
	    
	    //get expression value
	    restMathClient = new RestMathClientServiceImpl();
	    problemList = restMathClient.returnExpression(problemList);

	    //replace expression with values
	    problemList = ReplaceExpressionUtility.replaceExpressionWithValue(problemList);
	    
	    problemList.add(getProblem1(mathConfig));
	
		return problemList;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String answer="";
			
		questionList.add(new QuestionLine( "Brenda types 120 words in 5 minutes and Jill types 180 words in 8 minutes."));
		questionList.add(new QuestionLine( "Who types faster? Brenda or Jill" +	Constants.ANSWER_TO_QUESTION + "Brenda" ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "How many words Can Jill type in 20 minutes" +	Constants.ANSWER_TO_QUESTION + "450" ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is the Brenda's typing speed per minute?" +	Constants.ANSWER_TO_QUESTION + "24", null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is the Brenda's typing speed per hour?" +	Constants.ANSWER_TO_QUESTION + "1440", null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = "Rates";
		answ.setAnswer(answer);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_MULTIPLES);
		problem.setAnswer(answ);

		return problem;
	}
	
}
