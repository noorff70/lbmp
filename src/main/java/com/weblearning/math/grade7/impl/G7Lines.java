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

public class G7Lines extends GenericQuestion{
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private RestMathClientService restMathClient;

	@Override
	public List<?> getQuestions(MathConfiguration mathConfig) {
		

		//List<Problem> problemList = new ArrayList<Problem>();
		
		resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( "classpath:/locale/math/grade7/problems/geometry/Lines.xml" );

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
		double _5x = 7;
		double _5y = 6;
		co5.setxCo(Double.valueOf(_5x));
		co5.setyCo(Double.valueOf(_5y));
		lo5.setxCo(Double.valueOf(_5x+.025));
		lo5.setyCo(Double.valueOf(_5y+.025));
		lo5.setLabelName("E");
		
		CircleObject co6= new CircleObject();
		LabelObject lo6 = new LabelObject();
		double _6x = 3;
		double _6y = -4;
		co6.setxCo(Double.valueOf(_6x));
		co6.setyCo(Double.valueOf(_6y));
		lo6.setxCo(Double.valueOf(_6x+.025));
		lo6.setyCo(Double.valueOf(_6y+.025));
		lo6.setLabelName("F");
		
		//CircleObject co7= new CircleObject();
		LabelObject lo7 = new LabelObject();
		double _7x = 6;
		double _7y = 3;
		//co7.setxCo(Double.valueOf(_7x));
		//co7.setyCo(Double.valueOf(_7y));
		lo7.setxCo(Double.valueOf(_7x+.025));
		lo7.setyCo(Double.valueOf(_7y+.025));
		lo7.setLabelName("G");
		
		//CircleObject co8= new CircleObject();
		LabelObject lo8 = new LabelObject();
		double _8x = 4;
		double _8y = -2;
		//co8.setxCo(Double.valueOf(_8x));
		//co8.setyCo(Double.valueOf(_8y));
		lo8.setxCo(Double.valueOf(_8x+.025));
		lo8.setyCo(Double.valueOf(_8y+.025));
		lo8.setLabelName("H");
			
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
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
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
		labelList.add(lo7);
		labelList.add(lo8);
		geo.setLabels(labelList);
		
		//int EGB = MathUtilities.getRandomNumber(25, 35);
		
		String a1 = "Parallel";
		String a2 = "Traversal";
		String a3 = "Corresponding";
		String a4 = "Interior";
		String a5 = "Exterior";
			
		question = "See the picture and answer the following:" ;
			
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

		questionList.add(new QuestionLine( "AB and CD are:"+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Line EF is called"+ GR8_Constants.ANSWER_TO_QUESTION + a2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle AGE and Angle CHG are called ____ Angles:"+ GR8_Constants.ANSWER_TO_QUESTION + a3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle AGH and Angle GHD are called Alternate ____ Angles:"+ GR8_Constants.ANSWER_TO_QUESTION + a4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle CHF and Angle EGB are called Alternate ____ Angles:"+ GR8_Constants.ANSWER_TO_QUESTION + a5  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		
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
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		List<LineObject> lineList = new ArrayList<LineObject>();
				
		//CircleObject co1= new CircleObject();
		LabelObject lo1 = new LabelObject();
		double _1x = -1.75;
		int _1y = 5;
		lo1.setxCo(Double.valueOf(1.5));
		lo1.setyCo(Double.valueOf(3));
		lo1.setLabelName("m");
			
		LabelObject lo2 = new LabelObject();
		int _2x = 6;
		double _2y = -1.5;
		lo2.setxCo(Double.valueOf(-1.25));
		lo2.setyCo(Double.valueOf(.5));
		lo2.setLabelName("n");
				
		LabelObject lo3 = new LabelObject();
		double _3x = -5;
		double _3y = 2.95;
		lo3.setxCo(Double.valueOf(-1.25));
		lo3.setyCo(Double.valueOf(-1));
		lo3.setLabelName("o");
				
		LabelObject lo4 = new LabelObject();
		double _4x = 4;
		double _4y = -4;
		lo4.setxCo(Double.valueOf(2));
		lo4.setyCo(Double.valueOf(2.5));
		lo4.setLabelName("p");

		LabelObject lo5 = new LabelObject();
		double _5x = 2;
		double _5y = 2.75;
		lo5.setxCo(Double.valueOf(.5));
		lo5.setyCo(Double.valueOf(2.5));
		lo5.setLabelName("q");
			
		LabelObject lo6 = new LabelObject();
		double _6x = -3;
		double _6y = -2;
		lo6.setxCo(Double.valueOf(1.5));
		lo6.setyCo(Double.valueOf(1.5));
		lo6.setLabelName("r");
			
		LabelObject lo7 = new LabelObject();
		lo7.setxCo(Double.valueOf(-2));
		lo7.setyCo(Double.valueOf(-.5));
		lo7.setLabelName("s");
			
			//CircleObject co8= new CircleObject();
		LabelObject lo8 = new LabelObject();
		lo8.setxCo(Double.valueOf(-.5));
		lo8.setyCo(Double.valueOf(.1));
		lo8.setLabelName("t");
				
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
				
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		geo.setLines(lineList);
				
			
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		labelList.add(lo4);
		labelList.add(lo5);
		labelList.add(lo6);
		labelList.add(lo7);
		labelList.add(lo8);
		geo.setLabels(labelList);
			
		//int EGB = MathUtilities.getRandomNumber(25, 35);
			
		String a1 = "False";
		String a2 = "True";
		String a3 = "False";
		String a4 = "True";
		String a5 = "False";
		String a6 = "True";
		String a7 = "True";
		String a8 = "False";
		String a9 = "True";
				
		question = "See the picture and answer the following:" ;
				
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

		questionList.add(new QuestionLine( "m and q are equal"+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "n and o are equal"+ GR8_Constants.ANSWER_TO_QUESTION + a2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "m and o are not equal:"+ GR8_Constants.ANSWER_TO_QUESTION + a3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "p and t are equal:"+ GR8_Constants.ANSWER_TO_QUESTION + a4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "p and o are equal:"+ GR8_Constants.ANSWER_TO_QUESTION + a5  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "p and s are equal:"+ GR8_Constants.ANSWER_TO_QUESTION + a6  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "r and m are equal:"+ GR8_Constants.ANSWER_TO_QUESTION + a7  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "p + t = 180:"+ GR8_Constants.ANSWER_TO_QUESTION + a8  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "t = 180 - r:"+ GR8_Constants.ANSWER_TO_QUESTION + a9  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
			
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
					
		MessageSource mSource = mathConfig.getmSource();
				
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
					
		GeometryObject geo = new GeometryObject();
		List<LabelObject> labelList = new ArrayList<LabelObject>();
		List<LineObject> lineList = new ArrayList<LineObject>();
					
		//CircleObject co1= new CircleObject();
		LabelObject lo1 = new LabelObject();
		double _1x = -1.75;
		int _1y = 5;
		lo1.setxCo(Double.valueOf(1.5));
		lo1.setyCo(Double.valueOf(3));
		lo1.setLabelName("m");
				
		LabelObject lo2 = new LabelObject();
		int _2x = 6;
		double _2y = -1.5;
		lo2.setxCo(Double.valueOf(-1.25));
		lo2.setyCo(Double.valueOf(.5));
		lo2.setLabelName("n");
					
		LabelObject lo3 = new LabelObject();
		double _3x = -5;
		double _3y = 2.95;
		lo3.setxCo(Double.valueOf(-1.25));
		lo3.setyCo(Double.valueOf(-1));
		lo3.setLabelName("o");
					
		LabelObject lo4 = new LabelObject();
		double _4x = 4;
		double _4y = -4;
		lo4.setxCo(Double.valueOf(2));
		lo4.setyCo(Double.valueOf(2.5));
		lo4.setLabelName("p");

		LabelObject lo5 = new LabelObject();
		double _5x = 2;
		double _5y = 2.75;
		lo5.setxCo(Double.valueOf(.5));
		lo5.setyCo(Double.valueOf(2.5));
		lo5.setLabelName("q");
				
		LabelObject lo6 = new LabelObject();
		double _6x = -3;
		double _6y = -2;
		lo6.setxCo(Double.valueOf(1.5));
		lo6.setyCo(Double.valueOf(1.5));
		lo6.setLabelName("r");
				
		LabelObject lo7 = new LabelObject();
		lo7.setxCo(Double.valueOf(-2));
		lo7.setyCo(Double.valueOf(-.5));
		lo7.setLabelName("s");
				
		//CircleObject co8= new CircleObject();
		LabelObject lo8 = new LabelObject();
		lo8.setxCo(Double.valueOf(-.5));
		lo8.setyCo(Double.valueOf(.1));
		lo8.setLabelName("t");
					
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
					
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		geo.setLines(lineList);
					
				
		labelList.add(lo1);
		labelList.add(lo2);
		labelList.add(lo3);
		labelList.add(lo4);
		labelList.add(lo5);
		labelList.add(lo6);
		labelList.add(lo7);
		labelList.add(lo8);
		geo.setLabels(labelList);
		
		int m= MathUtilities.getRandomNumber(92, 110);
		int p = 180 -m;
		
		
		String a1 = Integer.toString(p);
		String a2 = Integer.toString(p);
		String a3 = Integer.toString(m);
		String a4 = Integer.toString(m);
		String a5 = Integer.toString(m);
		String a6 = Integer.toString(p);
					
		question = "See the picture (not drawn to scale) where Angle m is " + m + " and answer the following:" ;
					
		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

		questionList.add(new QuestionLine( "Angle p is: "+ GR8_Constants.ANSWER_TO_QUESTION + a1 ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle q is: "+ GR8_Constants.ANSWER_TO_QUESTION + a2  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle r is:"+ GR8_Constants.ANSWER_TO_QUESTION + a3  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle n is:"+ GR8_Constants.ANSWER_TO_QUESTION + a4  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle o is:"+ GR8_Constants.ANSWER_TO_QUESTION + a5  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
		questionList.add(new QuestionLine(  "Angle t is:"+ GR8_Constants.ANSWER_TO_QUESTION + a6  ,  null, Constants.PROBLEM_TYPE_MULTIPLE_QUESTIONS));
				
		String heading = mSource.getMessage(GR7_Constants.COORDINATE_GEOMETRY, null, Locale.ENGLISH);
		answ.setAnswer("Blank");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
		
	//draw a triangle
	public Problem getProblem4(MathConfiguration mathConfig) {
			
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
			
		MessageSource mSource = mathConfig.getmSource();
			
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();

		String question="";
		String ans="";
		
		int a = MathUtilities.getRandomNumber(50, 110);
		
		if (a == 90)
			ans = "Right";
		else if (a < 90)
			ans = "Acute";
		else 
			ans = "Obtuse";

		question = "Lines AB and BC meets at point B and Angle ABC is " + Integer.toString(a) + "What type of angle is ABC (acute/ obtuse/ right)" ;

		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

		String heading = "Lines and Angles";
		answ.setAnswer(ans);

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PROBLEM_TYPE_FRACTION);
		problem.setAnswer(answ);

		return problem;
	}	
	
		
}
