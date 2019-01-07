package com.weblearning.math.utilities;

import java.util.List;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.Variable;

public class ReplaceExpressionUtility {

	public static List<Problem> replaceExpressionWithValue(List<Problem> pList) {

		for (int i = 0; i < pList.size(); i++) {

			Problem p = pList.get(i);
			Answer ans = pList.get(i).getAnswer();

			if (null != ans.getExpression()) {
				String displayableAnsToReplace = ans.getDisplayableAnswer();
				displayableAnsToReplace = displayableAnsToReplace.replaceAll("exp", ans.getExpression());
				p.getAnswer().setDisplayableAsnwer(displayableAnsToReplace);
			}

			List<AnswerLine> answerLineList = ans.getAnswerList();
			for (int j = 0; j < answerLineList.size(); j++) {
				String answerLineToReplace = answerLineList.get(j).getAnswerLn();
				if (null != ans.getExpression()) {
					answerLineToReplace = answerLineToReplace.replace("exp", ans.getExpression());
					p.getAnswer().getAnswerList().get(j).setAnswerLn(answerLineToReplace);
				}
			}
		}

		return pList;

	}
	
	public static List<Problem> replaceStringWithVariableValue(List <Problem> pList) {
		
		//set the variable values
		for (int i = 0; i < pList.size(); i++) {
			Problem p = pList.get(i);
			List<Variable> vList = p.getVariableList();
			for (int j = 0; j < vList.size(); j++) {
				Variable var = vList.get(j);
				String dataType = var.getVariableType();
				if (dataType.equals("int")) {
					int variableValue = MathUtilities.getRandomNumber(var.getLowerLimit(), var.getUpperLimit());
					var.setVariableValue(variableValue);
				}
			}
		
		//replace for displayable answers
		String display = p.getAnswer().getDisplayableAnswer();

		for (int j=0; j< vList.size(); j++) {
			Variable var = vList.get(j);
			display = display.replaceAll( var.getVariableName(), Integer.toString(var.getVariableValue()));
			p.getAnswer().setDisplayableAsnwer(display);
		}
		
		//replace for answers
		List <AnswerLine> answLineList = p.getAnswer().getAnswerList();
		for (int j=0; j< answLineList.size(); j++) {
			AnswerLine ansLine = answLineList.get(j);
			String ansToTeplace = ansLine.getAnswerLn();
			for (int v=0; v< vList.size(); v++) {
				Variable var = vList.get(v);
				ansToTeplace = ansToTeplace.replaceAll( var.getVariableName(), Integer.toString(var.getVariableValue()));
				p.getAnswer().getAnswerList().get(j).setAnswerLn(ansToTeplace);
			}
		}
		
		//replace for questions
		List <QuestionLine> qLineList = p.getQuestionLines();
		for (int j=0; j< qLineList.size(); j++) {
			QuestionLine qLine = qLineList.get(j);
			String questionToReplace = qLine.getQuestionLn();
			for (int v=0; v< vList.size(); v++) {
				Variable var = vList.get(v);
				questionToReplace = questionToReplace.replaceAll( var.getVariableName(), Integer.toString(var.getVariableValue()));
				p.getQuestionLines().get(j).setQuestionLn(questionToReplace);
			}
		}
		
		if (null != p.getAnswer().getExpression()) {
			String expressionToReplace = p.getAnswer().getExpression();
			for (int v=0; v< vList.size(); v++) {
				Variable var = vList.get(v);
				expressionToReplace = expressionToReplace.replaceAll( var.getVariableName(), Integer.toString(var.getVariableValue()));
				p.getAnswer().setExpression(expressionToReplace);
			}
		  }
		}
		return pList;
	}

}
