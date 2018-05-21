package com.weblearning.math.grade7.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
import com.weblearning.math.grade.GeometryQuestion;
import com.weblearning.math.utilities.GeometryShapeUtility;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;


public class G7GeoAreaTriangle extends GeometryQuestion {
	
	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	public List<Problem> getGeometryQuestions(MathConfiguration mathConfig) {
		
		resourceLoader = new FileSystemResourceLoader();
	    Resource resource = resourceLoader.getResource( "classpath:/geometry/G7Geometry.xml" );
		
	    List <GeometryObject> geometryObjectList = new ArrayList<GeometryObject>();

	    String fileLocation = "";
	    try {
			fileLocation =  resource.getFile().getAbsolutePath();
		} catch (IOException e1) 
	    {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File inputFile = new File(fileLocation);
		
		List<Problem> g7GeoAreaTriangle = new ArrayList<Problem>();
		Document doc= null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			
			geometryObjectList = GeometryShapeUtility.listOfTriangles(doc, Constants.SET_PRECISION_THREE);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//g7GeoAreaTriangle.add(getProblem(mathConfig));
		for (int i=0; i< geometryObjectList.size(); i++){
			g7GeoAreaTriangle.add(getProblem2(mathConfig, doc,geometryObjectList, i));
		}

		return g7GeoAreaTriangle;
	}

	
	private Problem getProblem2(MathConfiguration mathConfig, Document doc, List<GeometryObject> geometryObjectList, int i) {

		MessageSource mSource = mathConfig.getmSource();
		CreateProblem cProblem = new CreateProblem();
		List<QuestionLine> questionList = new ArrayList<QuestionLine>();
		
		GeometryObject geoObject = geometryObjectList.get(i);

		// add the questions
		QuestionLine qLine1 = new QuestionLine(mSource.getMessage(Constants.FIND_OUT_AREA_OF_TRIANGLE, null, Locale.ENGLISH));

		questionList.add(qLine1);

		String heading = mSource.getMessage( Constants.GRADE_7_GEOMETRY_AREA_TRIANGLE, null, Locale.ENGLISH);

		Problem problem = cProblem.constructProblem(questionList, geoObject, String.valueOf(geoObject.getTriangle().getArea()), heading, null, Constants.RANK_ONE, Constants.PROBLEM_TYPE_GEOMETRY);

		return problem;

	}
	

	
}
