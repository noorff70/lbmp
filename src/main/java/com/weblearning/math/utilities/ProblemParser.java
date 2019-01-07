package com.weblearning.math.utilities;

import com.weblearning.domain.Answer;
import com.weblearning.domain.AnswerLine;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.Variable;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import org.springframework.core.io.Resource;

public class ProblemParser {

	private static String configFile;
	private static Problem problem;
	private static List<Problem> problemList;
	private static Answer answer;
	private static QuestionLine qLine;
	private static List<QuestionLine> qLineList;
	private static List<Variable> vList;
	private static Variable variable;
	private static AnswerLine answerLine;
	private static List<AnswerLine> answerLineList;
	

	public static List<Problem> getProblems(Resource resource) {

		problemList = null;
		problem = null;
		String tagContent = null;

		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			configFile = resource.getFile().getAbsolutePath();

			InputStream in = new FileInputStream(configFile);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(in);
			
			while (reader.hasNext()) {
				int event = reader.next();

				switch (event) {

				case XMLStreamConstants.START_ELEMENT:
					if ("problems".equals(reader.getLocalName())) {
						problemList = new ArrayList<Problem>();
					}
					if ("problem".equals(reader.getLocalName())) {
						problem = new Problem();
						qLineList = new ArrayList<QuestionLine>();
						vList = new ArrayList<Variable>();
						answer = new Answer();
						answerLineList = new ArrayList<AnswerLine>();
					}
					if ("questionline".equals(reader.getLocalName())) {
						qLine = new QuestionLine();
					}
					if ("variable".equals(reader.getLocalName())) {
						variable = new Variable();
					}
					if ("answerLine".equals(reader.getLocalName())) {
						answerLine = new AnswerLine();
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					tagContent = reader.getText().trim();
					break;

				case XMLStreamConstants.END_ELEMENT:
					switch (reader.getLocalName()) {

					case "problem":
						problemList.add(problem);
						break;
					case "questionline":
						qLine.setQuestionLn(tagContent);
						qLineList.add(qLine);
						problem.setQuestionLines(qLineList);
						break;
					case "Answer":
						problem.setAnswer(answer);
						break;
					case "displayableanswer":
						answer.setDisplayableAsnwer(tagContent);
						break;
					case "answerType":
						answer.setAnswerType(tagContent);
						break;
					case "answer":
						answer.setAnswer(tagContent);
						break;
					case "heading":
						problem.setQuestionHeading(tagContent);
						break;
					case "rank":
						problem.setRank(1);
						break;
					case "variableName":
						variable.setVariableName(tagContent);
						break;
					case "variableType":
						variable.setVariableType(tagContent);
						break;
					case "lowerlimit":
						variable.setLowerLimit(Integer.parseInt(tagContent));
						break;
					case "upprlimit":
						variable.setUpperLimit(Integer.parseInt(tagContent));
						break;
					case "variableValue":
						variable.setVariableValue(Integer.parseInt(tagContent));
						break;
					case "variable":
						vList.add(variable);
						problem.setVariableList(vList);
						break;
					case "questionType":
						problem.setQuestionType(tagContent);;
						break;
					case "expression":
						answer.setExpression(tagContent);;
						break;
					case "answerLine":
						answerLine.setAnswerLn(tagContent);
						answerLineList.add(answerLine);
						answer.setAnswerList(answerLineList);
						break;
					}
					
					break;
				case XMLStreamConstants.START_DOCUMENT:
					problemList = new ArrayList<Problem>();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return problemList;
	}

}

