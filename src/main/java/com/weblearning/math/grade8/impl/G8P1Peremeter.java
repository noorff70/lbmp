package com.weblearning.math.grade8.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;

import com.weblearning.domain.GeometryObject;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.utilities.GeometryParser;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G8P1Peremeter extends GenericQuestion {
	
	private static final Logger logger = Logger.getLogger(G8P1Peremeter.class);
	
	@Autowired
	private ResourceLoader resourceLoader;

	public List<?> getQuestions(MathConfiguration mathConfig) {
		
		resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( "classpath:/g8Geometry/peremeters/G8Peremeter.xml" );
	    Resource picResource = resourceLoader.getResource( "classpath:/g8Geometry/peremeters/" );
	    
	    List<GeometryObject> gObjectList = GeometryParser.getQuestions(baseresource, picResource);
		
		
		List<Problem> g8P1Peremeter = new ArrayList<Problem>();
		
		for (int i = 0; i < gObjectList.size(); i++)
			g8P1Peremeter.add(getProblem1(mathConfig, gObjectList.get(i)));

		
		return g8P1Peremeter;
	}

	/*
	 * Add simple fraction for two fractions. Add + Add
	 */
	public Problem getProblem1(MathConfiguration mathConfig, GeometryObject gObj) {
		
		

		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		
		MessageSource mSource = mathConfig.getmSource();
	
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION_EVALUATE, null, Locale.ENGLISH));
		QuestionLine qLine2 = new QuestionLine(gObj.getQuestion());
		questionList.add(qLine1);
		questionList.add(qLine2);
		
		logger.debug("Question: " + gObj.getQuestion() + " " + "answer: " + gObj.getAnswer());

		String heading = mSource.getMessage(Constants.GRADE_8_INTEGER_OPERATION, null, Locale.ENGLISH);


		Problem problem = cProblem.constructProblem(questionList, gObj.getAnswer(), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION, gObj.getPathToPicture());

		return problem;
	}
	
}
