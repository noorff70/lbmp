package com.weblearning.utilities;

import java.util.List;

import com.weblearning.domain.Answer;
//import com.weblearning.domain.GeometryObject;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;

/*Create a problem with all parameters and send to Controller
 * 
 */

public class CreateProblem {
	
	public Problem constructProblem(List<QuestionLine> questionList, String questionHeading, int rank, String type  ){
		
		Problem problem = new Problem();
		
		Answer answer = new Answer();
	//	answer.setAnswer(answ);
	//	answer.setType(type);
		
		problem.setQuestionLines(questionList);
		problem.setQuestionHeading(questionHeading);
	//	problem.setQuestionSubHeading(subHeading);
		problem.setRank(rank);
		problem.setAnswer(answer);
		problem.setQuestionType(type);
		
		return problem;
		
	}
	
	
	/*public Problem constructProblem(List<QuestionLine> questionList, GeometryObject geoObject, String answ, String questionHeading,  String subHeading, int rank, String type){
		
		Problem problem = new Problem();
		
		Answer answer = new Answer();
		answer.setAnswer(answ);
	//	answer.setType(type);
		
		problem.setQuestionLines(questionList);
		problem.setGeometryObject(geoObject);
		problem.setQuestionHeading(questionHeading);
		problem.setQuestionSubHeading(subHeading);
		problem.setRank(rank);
		problem.setAnswer(answer);
		problem.setQuestionType(type);
		
		return problem;
		
	}*/
	
	/*public Problem constructProblem(List<QuestionLine> questionList, String answ, String questionHeading,  String subHeading, int rank, String type, String picturePath  ){
		
		Problem problem = new Problem();
		
		Answer answer = new Answer();
		answer.setAnswer(answ);
	//	answer.setType(type);
		
		problem.setQuestionLines(questionList);
		problem.setQuestionHeading(questionHeading);
		problem.setQuestionSubHeading(subHeading);
		problem.setRank(rank);
		problem.setAnswer(answer);
		problem.setPicturePath(picturePath);
		problem.setQuestionType(type);
		
		return problem;
		
	}*/

}
