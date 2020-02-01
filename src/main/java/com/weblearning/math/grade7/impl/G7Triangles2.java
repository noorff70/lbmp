package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.utility.geometry.CircleObject;
import com.weblearning.domain.utility.geometry.GeometryObject;
import com.weblearning.domain.utility.geometry.LabelObject;
import com.weblearning.domain.utility.geometry.LineObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.math.grade8.impl.GR8_Constants;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.math.utilities.ProblemParser;
import com.weblearning.math.utilities.ReplaceExpressionUtility;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7Triangles2 extends GenericQuestion{
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private RestMathClientService restMathClient;

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		

		//List<Problem> problemList = new ArrayList<Problem>();
		
		resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( "classpath:/locale/math/grade7/problems/geometry/Triangles_2.xml" );

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
		problemList.add(getProblem2(mathConfig));
		problemList.add(getProblem3(mathConfig));
		problemList.add(getProblem4(mathConfig));
		problemList.add(getProblem5(mathConfig));
		problemList.add(getProblem6(mathConfig));
		problemList.add(getProblem7(mathConfig));
		problemList.add(getProblem8(mathConfig));
				
		//restMathClient = new RestMathClientServiceImpl();
		problemList = restMathClient.returnGraph(problemList);
	
		return problemList;
	}
	

	
	//draw a triangle
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
		
		MessageSource mSource = mathConfig.getmSource();
		
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		
		GeometryObject geo = new GeometryObject();
		List<CircleObject> circleList = new ArrayList<CircleObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		List<LineObject> lineList = new ArrayList<LineObject>();
		
		CircleObject co1= new CircleObject();
		LabelObject lo1 = new LabelObject();
		int _1x = 0;
		int _1y = 0;
		co1.setxCo(Double.valueOf(_1x));
		co1.setyCo(Double.valueOf(_1y));
		lo1.setxCo(Double.valueOf(_1x+.025));
		lo1.setyCo(Double.valueOf(_1y+.025));
		lo1.setLabelName("A");
		
		CircleObject co2= new CircleObject();
		LabelObject lo2 = new LabelObject();
		int _2x = 6;
		int _2y = 0;
		co2.setxCo(Double.valueOf(_2x));
		co2.setyCo(Double.valueOf(_2y));
		lo2.setxCo(Double.valueOf(_2x+.025));
		lo2.setyCo(Double.valueOf(_2y+.025));
		lo2.setLabelName("B");
		
		CircleObject co3= new CircleObject();
		LabelObject lo3 = new LabelObject();
		int _3x = 3;
		double _3y = 5.5;
		co3.setxCo(Double.valueOf(_3x));
		co3.setyCo(Double.valueOf(_3y));
		lo3.setxCo(Double.valueOf(_3x+.025));
		lo3.setyCo(Double.valueOf(_3y+.025));
		lo3.setLabelName("C");
		
		CircleObject co4= new CircleObject();
		LabelObject lo4 = new LabelObject();
		double _4x = 8.5;
		double _4y = 8.5;
		co4.setxCo(Double.valueOf(_4x));
		co4.setyCo(Double.valueOf(_4y));
		lo4.setxCo(Double.valueOf(_4x+.025));
		lo4.setyCo(Double.valueOf(_4y+.025));
		lo4.setLabelName("D");
		
		LineObject ln1 = new LineObject();
		ln1.setX1(Double.valueOf(_1x));
		ln1.setX2(Double.valueOf(_2x));
		ln1.setY1(Double.valueOf(_1y));
		ln1.setY2(Double.valueOf(_2y));
		
		LineObject ln2 = new LineObject();
		ln2.setX1(Double.valueOf(_1x));
		ln2.setX2(Double.valueOf(_3x));
		ln2.setY1(Double.valueOf(_1y));
		ln2.setY2(Double.valueOf(_3y));
		
		LineObject ln3 = new LineObject();
		ln3.setX1(Double.valueOf(_2x));
		ln3.setX2(Double.valueOf(_3x));
		ln3.setY1(Double.valueOf(_2y));
		ln3.setY2(Double.valueOf(_3y));
		
		LineObject ln4 = new LineObject();
		ln4.setX1(Double.valueOf(_3x));
		ln4.setX2(Double.valueOf(_4x));
		ln4.setY1(Double.valueOf(_3y));
		ln4.setY2(Double.valueOf(_4y));
		
		LineObject ln5 = new LineObject();
		ln5.setX1(Double.valueOf(_2x));
		ln5.setX2(Double.valueOf(_4x));
		ln5.setY1(Double.valueOf(_2y));
		ln5.setY2(Double.valueOf(_4y));
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		lineList.add(ln4);
		lineList.add(ln5);
		geo.setLines(lineList);
		
		circleList.add(co1);
		circleList.add(co2);
		circleList.add(co3);
		circleList.add(co4);
		geo.setCircles(circleList);	
		
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		labelList.add(lo4);
		geo.setLabels(labelList);
		
		String ans1 = Integer.toString(60);
		String ans2 = Integer.toString(60);
		String ans3 = Integer.toString(45);
		String ans6 = Integer.toString(90);
		
		question = "Angle CAB = 60 . AC=BC=CD. CD is perpendicular on BC. Now answer the following questions. "   ;
		
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "$\\angle ABC$ ="+ GR8_Constants.ANSWER_TO_QUESTION + ans1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "$\\angle ACB$ ="+ GR8_Constants.ANSWER_TO_QUESTION + ans2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "$\\angle CBD$ ="+ GR8_Constants.ANSWER_TO_QUESTION + ans3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
	//	questionList.add(new QuestionLine(  "$\\triangle ABC$ is what type of triangle"+ GR8_Constants.ANSWER_TO_QUESTION + ans4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
	//	questionList.add(new QuestionLine(  "$\\triangle BCD$ is what type of triangle"+ GR8_Constants.ANSWER_TO_QUESTION + ans5  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "$\\angle BCD$ ="+ GR8_Constants.ANSWER_TO_QUESTION + ans6  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));

		String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem2(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		List<CircleObject> circleList = new ArrayList<CircleObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		List<LineObject> lineList = new ArrayList<LineObject>();
			
		CircleObject co1= new CircleObject();
		LabelObject lo1 = new LabelObject();
		int _1x = 0;
		int _1y = 0;
		co1.setxCo(Double.valueOf(_1x));
		co1.setyCo(Double.valueOf(_1y));
		lo1.setxCo(Double.valueOf(_1x+.025));
		lo1.setyCo(Double.valueOf(_1y+.025));
		lo1.setLabelName("A");
			
		CircleObject co2= new CircleObject();
		LabelObject lo2 = new LabelObject();
		int _2x = 9;
		int _2y = 0;
		co2.setxCo(Double.valueOf(_2x));
		co2.setyCo(Double.valueOf(_2y));
		lo2.setxCo(Double.valueOf(_2x+.025));
		lo2.setyCo(Double.valueOf(_2y+.025));
		lo2.setLabelName("B");
			
		CircleObject co3= new CircleObject();
		LabelObject lo3 = new LabelObject();
		double _3x = 2.2;
		double _3y = 3.8;
		co3.setxCo(Double.valueOf(_3x));
		co3.setyCo(Double.valueOf(_3y));
		lo3.setxCo(Double.valueOf(_3x+.025));
		lo3.setyCo(Double.valueOf(_3y+.025));
		lo3.setLabelName("C");
			
		CircleObject co4= new CircleObject();
		LabelObject lo4 = new LabelObject();
		double _4x = 0;
		double _4y = 5;
		co4.setxCo(Double.valueOf(_4x));
		co4.setyCo(Double.valueOf(_4y));
		lo4.setxCo(Double.valueOf(_4x+.025));
		lo4.setyCo(Double.valueOf(_4y+.025));
		lo4.setLabelName("D");
			
		LineObject ln1 = new LineObject();
		ln1.setX1(Double.valueOf(_1x));
		ln1.setX2(Double.valueOf(_2x));
		ln1.setY1(Double.valueOf(_1y));
		ln1.setY2(Double.valueOf(_2y));
			
		LineObject ln2 = new LineObject();
		ln2.setX1(Double.valueOf(_1x));
		ln2.setX2(Double.valueOf(_3x));
		ln2.setY1(Double.valueOf(_1y));
		ln2.setY2(Double.valueOf(_3y));
			
		LineObject ln3 = new LineObject();
		ln3.setX1(Double.valueOf(_2x));
		ln3.setX2(Double.valueOf(_4x));
		ln3.setY1(Double.valueOf(_2y));
		ln3.setY2(Double.valueOf(_4y));
			
		/*LineObject ln4 = new LineObject();
		ln4.setX1(Double.valueOf(_3x));
		ln4.setX2(Double.valueOf(_4x));
		ln4.setY1(Double.valueOf(_3y));
		ln4.setY2(Double.valueOf(_4y));*/
			
		LineObject ln5 = new LineObject();
		ln5.setX1(Double.valueOf(_1x));
		ln5.setX2(Double.valueOf(_4x));
		ln5.setY1(Double.valueOf(_1y));
		ln5.setY2(Double.valueOf(_4y));
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		//lineList.add(ln4);
		lineList.add(ln5);
		geo.setLines(lineList);
			
		circleList.add(co1);
		circleList.add(co2);
		circleList.add(co3);
		circleList.add(co4);
		geo.setCircles(circleList);	
			
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		labelList.add(lo4);
		geo.setLabels(labelList);
			
		String ans1 = Integer.toString(60);
		String ans2 = Integer.toString(30);
		String ans3 = Integer.toString(60);
			
		question = "BD and AC are perpendicular. Angle CAD =30. Now answer the following: "   ;
			
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "$\\angle CAB$ ="+ GR8_Constants.ANSWER_TO_QUESTION + ans1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "$\\angle ABC$ ="+ GR8_Constants.ANSWER_TO_QUESTION + ans2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "$\\angle ADC$ ="+ GR8_Constants.ANSWER_TO_QUESTION + ans3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
		String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem3(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
	//	MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		question = "Sum of all interior angles can be represented as (n-1) $\\times$ 180. What would be sum of interior angles of a Hexagon ";
 
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = "Angles and Polygons";
		answ.setAnswer("900");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	

	
	//draw a triangle
	public Problem getProblem4(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="", q2="";
			
		GeometryObject geo = new GeometryObject();
		List<CircleObject> circleList = new ArrayList<CircleObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		List<LineObject> lineList = new ArrayList<LineObject>();
			
		CircleObject co1= new CircleObject();
		LabelObject lo1 = new LabelObject();
		int _1x = 2;
		int _1y = -1;
		co1.setxCo(Double.valueOf(_1x));
		co1.setyCo(Double.valueOf(_1y));
		lo1.setxCo(Double.valueOf(_1x+.025));
		lo1.setyCo(Double.valueOf(_1y+.025));
		lo1.setLabelName("A");
			
		CircleObject co2= new CircleObject();
		LabelObject lo2 = new LabelObject();
		int _2x = 5;
		int _2y = -1;
		co2.setxCo(Double.valueOf(_2x));
		co2.setyCo(Double.valueOf(_2y));
		lo2.setxCo(Double.valueOf(_2x+.025));
		lo2.setyCo(Double.valueOf(_2y+.025));
		lo2.setLabelName("B");
			
		CircleObject co3= new CircleObject();
		LabelObject lo3 = new LabelObject();
		double _3x = 3;
		double _3y = 3;
		co3.setxCo(Double.valueOf(_3x));
		co3.setyCo(Double.valueOf(_3y));
		lo3.setxCo(Double.valueOf(_3x+.025));
		lo3.setyCo(Double.valueOf(_3y+.025));
		lo3.setLabelName("C");
			
			
		LineObject ln1 = new LineObject();
		ln1.setX1(Double.valueOf(_1x));
		ln1.setX2(Double.valueOf(_2x));
		ln1.setY1(Double.valueOf(_1y));
		ln1.setY2(Double.valueOf(_2y));
			
		LineObject ln2 = new LineObject();
		ln2.setX1(Double.valueOf(_1x));
		ln2.setX2(Double.valueOf(_3x));
		ln2.setY1(Double.valueOf(_1y));
		ln2.setY2(Double.valueOf(_3y));
			
		LineObject ln3 = new LineObject();
		ln3.setX1(Double.valueOf(_2x));
		ln3.setX2(Double.valueOf(_3x));
		ln3.setY1(Double.valueOf(_2y));
		ln3.setY2(Double.valueOf(_3y));
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		geo.setLines(lineList);
			
		circleList.add(co1);
		circleList.add(co2);
		circleList.add(co3);
		geo.setCircles(circleList);	
			
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		geo.setLabels(labelList);
			
			
		question = "What type of triangle is the above? (Choose among- Obtuse, Acute, Right, Isosceles)";
		q2 = "$\\angle A \\neq \\angle B \\neq \\angle C$";
			
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add( new QuestionLine( q2, null, Constants.DEFAULT));
		
		
		String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
		answ.setAnswer("Acute");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem5(MathConfiguration mathConfig) {
				
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
				
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
				
		GeometryObject geo = new GeometryObject();
		List<CircleObject> circleList = new ArrayList<CircleObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		List<LineObject> lineList = new ArrayList<LineObject>();
				
		CircleObject co1= new CircleObject();
		LabelObject lo1 = new LabelObject();
		int _1x = 2;
		int _1y = 2;
		co1.setxCo(Double.valueOf(_1x));
		co1.setyCo(Double.valueOf(_1y));
		lo1.setxCo(Double.valueOf(_1x+.025));
		lo1.setyCo(Double.valueOf(_1y+.025));
		lo1.setLabelName("A");
				
		CircleObject co2= new CircleObject();
		LabelObject lo2 = new LabelObject();
		int _2x = 6;
		int _2y = 2;
		co2.setxCo(Double.valueOf(_2x));
		co2.setyCo(Double.valueOf(_2y));
		lo2.setxCo(Double.valueOf(_2x+.025));
		lo2.setyCo(Double.valueOf(_2y+.025));
		lo2.setLabelName("B");
				
		CircleObject co3= new CircleObject();
		LabelObject lo3 = new LabelObject();
		double _3x = 4;
		double _3y = 5;
		co3.setxCo(Double.valueOf(_3x));
		co3.setyCo(Double.valueOf(_3y));
		lo3.setxCo(Double.valueOf(_3x+.025));
		lo3.setyCo(Double.valueOf(_3y+.025));
		lo3.setLabelName("C");
				
				
		LineObject ln1 = new LineObject();
		ln1.setX1(Double.valueOf(_1x));
		ln1.setX2(Double.valueOf(_2x));
		ln1.setY1(Double.valueOf(_1y));
		ln1.setY2(Double.valueOf(_2y));
				
		LineObject ln2 = new LineObject();
		ln2.setX1(Double.valueOf(_1x));
		ln2.setX2(Double.valueOf(_3x));
		ln2.setY1(Double.valueOf(_1y));
		ln2.setY2(Double.valueOf(_3y));
				
		LineObject ln3 = new LineObject();
		ln3.setX1(Double.valueOf(_2x));
		ln3.setX2(Double.valueOf(_3x));
		ln3.setY1(Double.valueOf(_2y));
		ln3.setY2(Double.valueOf(_3y));
				
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		geo.setLines(lineList);
				
		circleList.add(co1);
		circleList.add(co2);
		circleList.add(co3);
		geo.setCircles(circleList);	
				
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		geo.setLabels(labelList);
		
		int angle = MathUtilities.getRandomNumber(50,60);
				
				
		question = "ABC is an Isosceles Triangle and AC= BC. What is the angle A when B is " + Integer.toString(angle);
				
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
			
			
		String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
		answ.setAnswer(Integer.toString(angle));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem6(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		GeometryObject geo = new GeometryObject();
		List<CircleObject> circleList = new ArrayList<CircleObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		List<LineObject> lineList = new ArrayList<LineObject>();
			
		CircleObject co1= new CircleObject();
		LabelObject lo1 = new LabelObject();
		int _1x = 2;
		int _1y = 3;
		co1.setxCo(Double.valueOf(_1x));
		co1.setyCo(Double.valueOf(_1y));
		lo1.setxCo(Double.valueOf(_1x+.025));
		lo1.setyCo(Double.valueOf(_1y+.025));
		lo1.setLabelName("A");
			
		CircleObject co2= new CircleObject();
		LabelObject lo2 = new LabelObject();
		int _2x = 11;
		int _2y = 3;
		co2.setxCo(Double.valueOf(_2x));
		co2.setyCo(Double.valueOf(_2y));
		lo2.setxCo(Double.valueOf(_2x+.025));
		lo2.setyCo(Double.valueOf(_2y+.025));
		lo2.setLabelName("B");
			
		CircleObject co3= new CircleObject();
		LabelObject lo3 = new LabelObject();
		double _3x = 2;
		double _3y = -2;
		co3.setxCo(Double.valueOf(_3x));
		co3.setyCo(Double.valueOf(_3y));
		lo3.setxCo(Double.valueOf(_3x+.025));
		lo3.setyCo(Double.valueOf(_3y+.025));
		lo3.setLabelName("C");
			
		CircleObject co4= new CircleObject();
		LabelObject lo4 = new LabelObject();
		double _4x = 11;
		double _4y = -2;
		co4.setxCo(Double.valueOf(_4x));
		co4.setyCo(Double.valueOf(_4y));
		lo4.setxCo(Double.valueOf(_4x+.025));
		lo4.setyCo(Double.valueOf(_4y+.025));
		lo4.setLabelName("D");
		
		CircleObject co5= new CircleObject();
		LabelObject lo5 = new LabelObject();
		double _5x = 6;
		double _5y = 3;
		co5.setxCo(Double.valueOf(_5x));
		co5.setyCo(Double.valueOf(_5y));
		lo5.setxCo(Double.valueOf(_5x+.025));
		lo5.setyCo(Double.valueOf(_5y+.025));
		lo5.setLabelName("E");
		
		CircleObject co6= new CircleObject();
		LabelObject lo6 = new LabelObject();
		double _6x = 4;
		double _6y = -2;
		co6.setxCo(Double.valueOf(_6x));
		co6.setyCo(Double.valueOf(_6y));
		lo6.setxCo(Double.valueOf(_6x+.025));
		lo6.setyCo(Double.valueOf(_6y+.025));
		lo6.setLabelName("F");
			
		LineObject ln1 = new LineObject();
		ln1.setX1(Double.valueOf(_1x));
		ln1.setX2(Double.valueOf(_2x));
		ln1.setY1(Double.valueOf(_1y));
		ln1.setY2(Double.valueOf(_2y));
			
		LineObject ln2 = new LineObject();
		ln2.setX1(Double.valueOf(_3x));
		ln2.setX2(Double.valueOf(_4x));
		ln2.setY1(Double.valueOf(_3y));
		ln2.setY2(Double.valueOf(_4y));
			
		LineObject ln3 = new LineObject();
		ln3.setX1(Double.valueOf(_5x));
		ln3.setX2(Double.valueOf(_6x));
		ln3.setY1(Double.valueOf(_5y));
		ln3.setY2(Double.valueOf(_6y));
			
		LineObject ln4 = new LineObject();
		ln4.setX1(Double.valueOf(_5x));
		ln4.setX2(Double.valueOf(_4x));
		ln4.setY1(Double.valueOf(_5y));
		ln4.setY2(Double.valueOf(_4y));
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		lineList.add(ln4);
		//lineList.add(ln5);
		geo.setLines(lineList);
			
		circleList.add(co1);
		circleList.add(co2);
		circleList.add(co3);
		circleList.add(co4);
		circleList.add(co5);
		circleList.add(co6);
		geo.setCircles(circleList);	
			
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		labelList.add(lo4);
		labelList.add(lo5);
		labelList.add(lo6);
		geo.setLabels(labelList);
		
		int BED = MathUtilities.getRandomNumber(25, 35);
		int DEF = MathUtilities.getRandomNumber(55, 75);
		String EDF = Integer.toString(BED);
		String EFD = Integer.toString(180-BED-DEF);
		String AEF = Integer.toString(180-BED-DEF);
		String EFC = Integer.toString(BED+DEF);
		
			
		question = "See the picture with the folowing conditions and answer:" ;
		String q2 = "$\\angle BED$ =" + Integer.toString(BED);
		String q3 = "$\\angle DEF$ =" + Integer.toString(DEF);
			
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add( new QuestionLine( q2, null, Constants.DEFAULT));
		questionList.add( new QuestionLine( q3, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "$\\angle EDF$ ="+ GR8_Constants.ANSWER_TO_QUESTION + EDF ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "$\\angle EFD$ ="+ GR8_Constants.ANSWER_TO_QUESTION + EFD  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "$\\angle AEF$ ="+ GR8_Constants.ANSWER_TO_QUESTION + AEF  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "$\\angle EFC$ ="+ GR8_Constants.ANSWER_TO_QUESTION + EFC  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
		String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	//draw a triangle
	public Problem getProblem7(MathConfiguration mathConfig) {
			
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
	
//MessageSource mSource = mathConfig.getmSource();
	
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
	
		GeometryObject geo = new GeometryObject();

		List<LineObject> lineList = new ArrayList<LineObject>();
		List<LabelObject> labelList = new ArrayList<LabelObject>();

		LineObject l1 = new LineObject();
		l1.setX1(Double.valueOf(-4));
		l1.setY1(Double.valueOf(0));
		l1.setX2(Double.valueOf(4));
		l1.setY2(Double.valueOf(0));

		LineObject l2 = new LineObject();
		l2.setX1(Double.valueOf(-2));
		l2.setY1(Double.valueOf(0));
		l2.setX2(Double.valueOf(-3));
		l2.setY2(Double.valueOf(4));

		LineObject l3 = new LineObject();
		l3.setX1(Double.valueOf(2));
		l3.setY1(Double.valueOf(0));
		l3.setX2(Double.valueOf(3));
		l3.setY2(Double.valueOf(4));

		LineObject l4 = new LineObject();
		l4.setX1(Double.valueOf(3));
		l4.setY1(Double.valueOf(4));
		l4.setX2(Double.valueOf(0));
		l4.setY2(Double.valueOf(6));

		LineObject l5 = new LineObject();
		l5.setX1(Double.valueOf(-3));
		l5.setY1(Double.valueOf(4));
		l5.setX2(Double.valueOf(0));
		l5.setY2(Double.valueOf(6));



		lineList.add(l1);
		lineList.add(l2);
		lineList.add(l3);
		lineList.add(l4);
		lineList.add(l5);

		geo.setLines(lineList);

		LabelObject lo1 = new LabelObject();
		lo1.setLabelName("x");
		lo1.setxCo(3.0);
		lo1.setyCo(1.0);

		labelList.add(lo1);

		geo.setLabels(labelList);

	
		question = "Above is a pentagon with equal sides and equal interior angles." ;

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
		questionList.add(new QuestionLine( "What is sum of all angles inside the pentagon? "+ GR8_Constants.ANSWER_TO_QUESTION + "540" ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "How much is each angle of the pentagon?" + GR8_Constants.ANSWER_TO_QUESTION + "108",  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine( "What is the value of angle X??" + GR8_Constants.ANSWER_TO_QUESTION + "72",  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
		String heading = "Angles and Polygons";
		answ.setAnswer("");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem; 
	}
	
	public Problem getProblem8(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
	//	MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		int n= MathUtilities.getRandomNumber(4, 8);
		int sum = (n-2)*180;
			
		question = "If sum of angles of an object is  " + sum + ", then how many sides it has?";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = "Angles and Polygons";
		answ.setAnswer(Integer.toString(n));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem9(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
	//	MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
			
		question = "An interior angle of an Octagon is";

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

				
		String heading = "Angles and Polygons";
		answ.setAnswer(Integer.toString(135));

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}
	
		
}
