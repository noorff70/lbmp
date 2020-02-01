package com.weblearning.math.grade7.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.weblearning.domain.Answer;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.domain.QuestionLine;
import com.weblearning.domain.utility.geometry.GeometryObject;
import com.weblearning.domain.utility.geometry.LabelObject;
import com.weblearning.domain.utility.geometry.LineObject;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade7.utilities.GR7_Constants;
import com.weblearning.service.RestMathClientService;
import com.weblearning.service.impl.RestMathClientServiceImpl;
import com.weblearning.utilities.Constants;
import com.weblearning.utilities.CreateProblem;

public class G7Angles extends GenericQuestion{
	
	@Autowired
	private RestMathClientService restMathClient;

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
		problemList.add(getProblem9(mathConfig));
		problemList.add(getProblem10(mathConfig));
		problemList.add(getProblem11(mathConfig));
		problemList.add(getProblem12(mathConfig));
		problemList.add(getProblem13(mathConfig));
		problemList.add(getProblem14(mathConfig));
		problemList.add(getProblem15(mathConfig));
		problemList.add(getProblem16(mathConfig));
		problemList.add(getProblem17(mathConfig));
		problemList.add(getProblem18(mathConfig));
		problemList.add(getProblem19(mathConfig));
		problemList.add(getProblem20(mathConfig));
		problemList.add(getProblem21(mathConfig));
		problemList.add(getProblem22(mathConfig));
		problemList.add(getProblem23(mathConfig));
		problemList.add(getProblem24(mathConfig));
		problemList.add(getProblem25(mathConfig));
		
		restMathClient = new RestMathClientServiceImpl();
		problemList = restMathClient.returnGraph(problemList);
	
		return problemList;
	}
	
	public Problem getProblem1(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("40");
				
		l2.setxCo(0.0);
		l2.setyCo(2.0);
		l2.setLabelName("90");
			
		l3.setxCo(-2.0);
		l3.setyCo(1.0);
		l3.setLabelName("a");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-5.0);
		ln1.setX2(5.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(0.0);
		ln2.setX2(4.0);
		ln2.setY1(0.0);
		ln2.setY2(4.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(-4.0);
		ln3.setY1(0.0);
		ln3.setY2(4.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of a";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = "Angles";
		answ.setAnswer("50");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem2(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("30");
				
		l2.setxCo(2.0);
		l2.setyCo(-.5);
		l2.setLabelName("x");
			
		l3.setxCo(0.0);
		l3.setyCo(-2.0);
		l3.setLabelName("120");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-4.0);
		ln1.setX2(3.0);
		ln1.setY1(-3.0);
		ln1.setY2(3.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-.45);
		ln2.setX2(6.0);
		ln2.setY1(0.0);
		ln2.setY2(1.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(-.45);
		ln3.setX2(6.0);
		ln3.setY1(0.0);
		ln3.setY2(-2.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of x";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("30");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem3(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("90");
				
		l2.setxCo(-2.0);
		l2.setyCo(0.0);
		l2.setLabelName("120");
			
		l3.setxCo(0.0);
		l3.setyCo(-2.0);
		l3.setLabelName("x");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(0.0);
		ln1.setX2(4.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(0.0);
		ln2.setX2(0.0);
		ln2.setY1(0.0);
		ln2.setY2(4.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(-5.0);
		ln3.setY1(0.0);
		ln3.setY2(-3.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of x";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("150");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem4(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("90");
				
		l2.setxCo(-2.0);
		l2.setyCo(0.0);
		l2.setLabelName("120");
			
		l3.setxCo(1.0);
		l3.setyCo(-2.0);
		l3.setLabelName("x");
		
		l4.setxCo(-1.0);
		l4.setyCo(-2.0);
		l4.setLabelName("70");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(0.0);
		ln1.setX2(4.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(0.0);
		ln2.setX2(0.0);
		ln2.setY1(0.0);
		ln2.setY2(4.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(-5.0);
		ln3.setY1(0.0);
		ln3.setY2(-3.0);
		
		LineObject ln4 = new LineObject();
		ln4.setX1(0.0);
		ln4.setX2(1.0);
		ln4.setY1(0.0);
		ln4.setY2(-5.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		lineList.add(ln4);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of x";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("80");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem5(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("40");
				
		l2.setxCo(.5);
		l2.setyCo(2.0);
		l2.setLabelName("a");
			
		l3.setxCo(-1.0);
		l3.setyCo(2.0);
		l3.setLabelName("a");
		
		l4.setxCo(-2.0);
		l4.setyCo(-1.0);
		l4.setLabelName("130");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(0.0);
		ln1.setX2(5.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(0.0);
		ln2.setX2(5.0);
		ln2.setY1(0.0);
		ln2.setY2(4.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(-.5);
		ln3.setY1(0.0);
		ln3.setY2(4.0);
		
		LineObject ln4 = new LineObject();
		ln4.setX1(0.0);
		ln4.setX2(-5.0);
		ln4.setY1(0.0);
		ln4.setY2(3.0);
		
		LineObject ln5 = new LineObject();
		ln5.setX1(0.0);
		ln5.setX2(0.0);
		ln5.setY1(0.0);
		ln5.setY2(-5.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		lineList.add(ln4);
		lineList.add(ln5);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of a";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("50");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem6(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("c");
				
		l2.setxCo(0.0);
		l2.setyCo(1.0);
		l2.setLabelName("d");
			
		l3.setxCo(-2.0);
		l3.setyCo(0.0);
		l3.setLabelName("80");
		
		l4.setxCo(2.0);
		l4.setyCo(-.5);
		l4.setLabelName("35");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-2.0);
		ln1.setX2(2.0);
		ln1.setY1(-2.0);
		ln1.setY2(2.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(3.0);
		ln2.setX2(-3.0);
		ln2.setY1(-2.0);
		ln2.setY2(2.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(3.0);
		ln3.setY1(0.0);
		ln3.setY2(0.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of d";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("100");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem7(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("c");
				
		l2.setxCo(0.0);
		l2.setyCo(1.0);
		l2.setLabelName("d");
			
		l3.setxCo(-2.0);
		l3.setyCo(0.0);
		l3.setLabelName("80");
		
		l4.setxCo(2.0);
		l4.setyCo(-.5);
		l4.setLabelName("35");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-2.0);
		ln1.setX2(2.0);
		ln1.setY1(-2.0);
		ln1.setY2(2.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(3.0);
		ln2.setX2(-3.0);
		ln2.setY1(-2.0);
		ln2.setY2(2.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(3.0);
		ln3.setY1(0.0);
		ln3.setY2(0.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of c";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("45");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem8(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		LabelObject l5 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("2e");
				
		l2.setxCo(2.0);
		l2.setyCo(-.5);
		l2.setLabelName("e");
			
		l3.setxCo(-2.0);
		l3.setyCo(-.5);
		l3.setLabelName("g");
		
		l4.setxCo(-1.0);
		l4.setyCo(1.0);
		l4.setLabelName("120");
		
		l5.setxCo(.0);
		l5.setyCo(-2.0);
		l5.setLabelName("f");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-4.0);
		ln1.setX2(4.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-2.0);
		ln2.setX2(2.0);
		ln2.setY1(-3.5);
		ln2.setY2(3.5);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(4.0);
		ln3.setY1(0.0);
		ln3.setY2(-2.5);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of e";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("30");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem9(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		LabelObject l5 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("2e");
				
		l2.setxCo(2.0);
		l2.setyCo(-.5);
		l2.setLabelName("e");
			
		l3.setxCo(-2.0);
		l3.setyCo(-.5);
		l3.setLabelName("g");
		
		l4.setxCo(-1.0);
		l4.setyCo(1.0);
		l4.setLabelName("120");
		
		l5.setxCo(.0);
		l5.setyCo(-2.0);
		l5.setLabelName("f");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-4.0);
		ln1.setX2(4.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-2.0);
		ln2.setX2(2.0);
		ln2.setY1(-3.5);
		ln2.setY2(3.5);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(4.0);
		ln3.setY1(0.0);
		ln3.setY2(-2.5);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of f";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("90");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem10(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		LabelObject l5 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("2e");
				
		l2.setxCo(2.0);
		l2.setyCo(-.5);
		l2.setLabelName("e");
			
		l3.setxCo(-2.0);
		l3.setyCo(-.5);
		l3.setLabelName("g");
		
		l4.setxCo(-1.0);
		l4.setyCo(1.0);
		l4.setLabelName("120");
		
		l5.setxCo(.0);
		l5.setyCo(-2.0);
		l5.setLabelName("f");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-4.0);
		ln1.setX2(4.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-2.0);
		ln2.setX2(2.0);  
		ln2.setY1(-3.5);
		ln2.setY2(3.5);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(4.0);
		ln3.setY1(0.0);
		ln3.setY2(-2.5);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of g";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("60");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem11(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		LabelObject l5 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(.5);
		l1.setLabelName("t");
				
		l2.setxCo(0.0);
		l2.setyCo(2.0);
		l2.setLabelName("s");
			
		l3.setxCo(-2.0);
		l3.setyCo(.75);
		l3.setLabelName("u");
		
		l4.setxCo(-2.0);
		l4.setyCo(-.75);
		l4.setLabelName("35");
		
		l5.setxCo(2.0);
		l5.setyCo(-1.0);
		l5.setLabelName("45");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-4.0);
		ln1.setX2(4.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-4.0);
		ln2.setX2(3.0);  
		ln2.setY1(-3.0);
		ln2.setY2(2.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(3.0);
		ln3.setX2(-3.0);
		ln3.setY1(-3.0);
		ln3.setY2(3.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of t";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("35");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem12(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		LabelObject l5 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(.5);
		l1.setLabelName("t");
				
		l2.setxCo(0.0);
		l2.setyCo(2.0);
		l2.setLabelName("s");
			
		l3.setxCo(-2.0);
		l3.setyCo(.75);
		l3.setLabelName("u");
		
		l4.setxCo(-2.0);
		l4.setyCo(-.75);
		l4.setLabelName("35");
		
		l5.setxCo(2.0);
		l5.setyCo(-1.0);
		l5.setLabelName("45");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-4.0);
		ln1.setX2(4.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-4.0);
		ln2.setX2(3.0);  
		ln2.setY1(-3.0);
		ln2.setY2(2.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(3.0);
		ln3.setX2(-3.0);
		ln3.setY1(-3.0);
		ln3.setY2(3.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of u";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("45");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem13(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		LabelObject l5 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(.5);
		l1.setLabelName("t");
				
		l2.setxCo(0.0);
		l2.setyCo(2.0);
		l2.setLabelName("s");
			
		l3.setxCo(-2.0);
		l3.setyCo(.75);
		l3.setLabelName("u");
		
		l4.setxCo(-2.0);
		l4.setyCo(-.75);
		l4.setLabelName("35");
		
		l5.setxCo(2.0);
		l5.setyCo(-1.0);
		l5.setLabelName("45");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-4.0);
		ln1.setX2(4.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-4.0);
		ln2.setX2(3.0);  
		ln2.setY1(-3.0);
		ln2.setY2(2.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(3.0);
		ln3.setX2(-3.0);
		ln3.setY1(-3.0);
		ln3.setY2(3.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of s";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("100");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem14(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(1.0);
		l1.setLabelName("45");
				
		l2.setxCo(0.5);
		l2.setyCo(1.0);
		l2.setLabelName("q");
			
		l3.setxCo(-1.0);
		l3.setyCo(.5);
		l3.setLabelName("q");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-4.0);
		ln1.setX2(4.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(0.0);
		ln2.setX2(3.0);  
		ln2.setY1(0.0);
		ln2.setY2(3.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(-1.0);
		ln3.setY1(0.0);
		ln3.setY2(4.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of q";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("67.5");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem15(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
				
		l1.setxCo(0.0);
		l1.setyCo(1.0);
		l1.setLabelName("140");
				
		l2.setxCo(1.0);
		l2.setyCo(-.5);
		l2.setLabelName("m");
			
		l3.setxCo(-1.0);
		l3.setyCo(-.5);
		l3.setLabelName("m");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(.0);
		ln1.setX2(5.0);
		ln1.setY1(0.0);
		ln1.setY2(1.9);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(0.0);
		ln2.setX2(-5.0);  
		ln2.setY1(0.0);
		ln2.setY2(1.8);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(0.0);
		ln3.setY1(0.0);
		ln3.setY2(-4.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

		geo.setLabels(labelList);
		geo.setLines(lineList);
					
		question = "Find the value of m";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
					
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("110");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem16(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		LabelObject l5 = new LabelObject();
		LabelObject l6 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(.5);
		l1.setLabelName("x");
				
		l2.setxCo(2.0);
		l2.setyCo(2.0);
		l2.setLabelName("x");
			
		l3.setxCo(1.0);
		l3.setyCo(3.0);
		l3.setLabelName("x");
		
		l4.setxCo(-.75);
		l4.setyCo(2.0);
		l4.setLabelName("x");
				
		l5.setxCo(-2.5);
		l5.setyCo(2.5);
		l5.setLabelName("x");
			
		l6.setxCo(-2.0);
		l6.setyCo(.5);
		l6.setLabelName("x");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		labelList.add(l6);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-4.0);
		ln1.setX2(4.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(0.0);
		ln2.setX2(4.0);  
		ln2.setY1(0.0);
		ln2.setY2(2.3);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(2.4);
		ln3.setY1(0.0);
		ln3.setY2(4.0);
		
		LineObject ln4 = new LineObject();
		ln4.setX1(0.0);
		ln4.setX2(0.0);
		ln4.setY1(0.0);
		ln4.setY2(4.0);
		
		LineObject ln5 = new LineObject();
		ln5.setX1(0.0);
		ln5.setX2(-2.1);
		ln5.setY1(0.0);
		ln5.setY2(4.0);
		
		LineObject ln6 = new LineObject();
		ln6.setX1(0.0);
		ln6.setX2(-4.8);
		ln6.setY1(0.0);
		ln6.setY2(3.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		lineList.add(ln4);
		lineList.add(ln5);
		lineList.add(ln6);

		geo.setLabels(labelList);
		geo.setLines(lineList);
					
		question = "Find the value of x";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));
					
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("30");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem17(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
				
		l1.setxCo(0.0);
		l1.setyCo(.50);
		l1.setLabelName("220");
				
		l2.setxCo(-2.0);
		l2.setyCo(-1.5);
		l2.setLabelName("x");
			
		l3.setxCo(1.0);
		l3.setyCo(-2.0);
		l3.setLabelName("x");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(0.0);
		ln1.setX2(-4.0);
		ln1.setY1(0.0);
		ln1.setY2(-.4);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(0.0);
		ln2.setX2(-1.0);  
		ln2.setY1(0.0);
		ln2.setY2(-4.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(3.0);
		ln3.setY1(0.0);
		ln3.setY2(-2.0);
		
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);

				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of x";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("70");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem18(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(-1.0);
		l1.setLabelName("x");
				
		l2.setxCo(-1.0);
		l2.setyCo(-1.5);
		l2.setLabelName("x + 40");
			
		l3.setxCo(.50);
		l3.setyCo(1.5);
		l3.setLabelName("y");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-3.0);
		ln1.setX2(3.0);
		ln1.setY1(-1.0);
		ln1.setY2(1.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-2.0);
		ln2.setX2(2.2);  
		ln2.setY1(3.0);
		ln2.setY2(-3.0);
			
		lineList.add(ln1);
		lineList.add(ln2);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of x";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("70");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem19(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
				
		l1.setxCo(2.0);
		l1.setyCo(-1.0);
		l1.setLabelName("x");
				
		l2.setxCo(-1.0);
		l2.setyCo(-1.5);
		l2.setLabelName("x + 40");
			
		l3.setxCo(.50);
		l3.setyCo(1.5);
		l3.setLabelName("y");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-3.0);
		ln1.setX2(3.0);
		ln1.setY1(-1.0);
		ln1.setY2(1.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-2.0);
		ln2.setX2(2.2);  
		ln2.setY1(3.0);
		ln2.setY2(-3.0);
			
		lineList.add(ln1);
		lineList.add(ln2);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of y";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("110");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem20(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
				
		l1.setxCo(3.0);
		l1.setyCo(1.0);
		l1.setLabelName("60");
				
		l2.setxCo(-1.0);
		l2.setyCo(.5);
		l2.setLabelName("x");
			
		l3.setxCo(-2.0);
		l3.setyCo(.5);
		l3.setLabelName("z");
		
		l4.setxCo(-3.0);
		l4.setyCo(-1.0);
		l4.setLabelName("y");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-5.0);
		ln1.setX2(5.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(3.0);
		ln2.setX2(-1.0);  
		ln2.setY1(3.0);
		ln2.setY2(-4.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(-4.0);  
		ln3.setY1(3.0);
		ln3.setY2(-4.0);
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of x";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("60");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem21(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
				
		l1.setxCo(3.0);
		l1.setyCo(1.0);
		l1.setLabelName("60");
				
		l2.setxCo(-1.0);
		l2.setyCo(.5);
		l2.setLabelName("x");
			
		l3.setxCo(-2.0);
		l3.setyCo(.5);
		l3.setLabelName("z");
		
		l4.setxCo(-3.0);
		l4.setyCo(-1.0);
		l4.setLabelName("y");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-5.0);
		ln1.setX2(5.0);
		ln1.setY1(0.0);
		ln1.setY2(0.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(3.0);
		ln2.setX2(-1.0);  
		ln2.setY1(3.0);
		ln2.setY2(-4.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(0.0);
		ln3.setX2(-4.0);  
		ln3.setY1(3.0);
		ln3.setY2(-4.0);
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "Find the value of y";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("60");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem22(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		LabelObject l5 = new LabelObject();
		LabelObject l6 = new LabelObject();
		LabelObject l7 = new LabelObject();
		LabelObject l8 = new LabelObject();
				
		l1.setxCo(-8.0);
		l1.setyCo(2.5);
		l1.setLabelName("A");
				
		l2.setxCo(-5.0);
		l2.setyCo(-3.5);
		l2.setLabelName("B");
			
		l3.setxCo(-4.8);
		l3.setyCo(5.3);
		l3.setLabelName("C");
		
		l4.setxCo(-1.0);
		l4.setyCo(-2.0);
		l4.setLabelName("D");
		
		l5.setxCo(-6.5);
		l5.setyCo(1.0);
		l5.setLabelName("69");
		
		l6.setxCo(-1.0);
		l6.setyCo(.5);
		l6.setLabelName("60");
		
		l7.setxCo(-6.0);
		l7.setyCo(-.5);
		l7.setLabelName("a");
		
		l8.setxCo(-4.0);
		l8.setyCo(2.0);
		l8.setLabelName("b");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		labelList.add(l6);
		labelList.add(l7);
		labelList.add(l8);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-1.0);
		ln1.setX2(-4.8);
		ln1.setY1(-2.0);
		ln1.setY2(5.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-5.0);
		ln2.setX2(-8.0);  
		ln2.setY1(-3.0);
		ln2.setY2(2.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(-6.5);
		ln3.setX2(-3.0);  
		ln3.setY1(-.5);
		ln3.setY2(4.0);
		
		LineObject ln4 = new LineObject();
		ln4.setX1(-6.5);
		ln4.setX2(0.0);  
		ln4.setY1(-.5);
		ln4.setY2(0.0);
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		lineList.add(ln4);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "AB || CD. Find the value of a";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("51");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem23(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
		LabelObject l4 = new LabelObject();
		LabelObject l5 = new LabelObject();
		LabelObject l6 = new LabelObject();
		LabelObject l7 = new LabelObject();
		LabelObject l8 = new LabelObject();
				
		l1.setxCo(-8.0);
		l1.setyCo(2.5);
		l1.setLabelName("A");
				
		l2.setxCo(-5.0);
		l2.setyCo(-3.5);
		l2.setLabelName("B");
			
		l3.setxCo(-4.8);
		l3.setyCo(5.3);
		l3.setLabelName("C");
		
		l4.setxCo(-1.0);
		l4.setyCo(-2.0);
		l4.setLabelName("D");
		
		l5.setxCo(-6.5);
		l5.setyCo(1.0);
		l5.setLabelName("69");
		
		l6.setxCo(-1.0);
		l6.setyCo(.5);
		l6.setLabelName("60");
		
		l7.setxCo(-6.0);
		l7.setyCo(-.5);
		l7.setLabelName("a");
		
		l8.setxCo(-4.0);
		l8.setyCo(2.0);
		l8.setLabelName("b");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);
		labelList.add(l4);
		labelList.add(l5);
		labelList.add(l6);
		labelList.add(l7);
		labelList.add(l8);
		
		LineObject ln1 = new LineObject();
		ln1.setX1(-1.0);
		ln1.setX2(-4.8);
		ln1.setY1(-2.0);
		ln1.setY2(5.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(-5.0);
		ln2.setX2(-8.0);  
		ln2.setY1(-3.0);
		ln2.setY2(2.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(-6.5);
		ln3.setX2(-3.0);  
		ln3.setY1(-.5);
		ln3.setY2(4.0);
		
		LineObject ln4 = new LineObject();
		ln4.setX1(-6.5);
		ln4.setX2(0.0);  
		ln4.setY1(-.5);
		ln4.setY2(0.0);
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		lineList.add(ln4);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "AB || CD. Find the value of b";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("69");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem24(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();
						
		l1.setxCo(-1.0);
		l1.setyCo(1.5);
		l1.setLabelName("45");
				
		l2.setxCo(.5);
		l2.setyCo(4.0);
		l2.setLabelName("m");
		
		l3.setxCo(1.2);
		l3.setyCo(3.2);
		l3.setLabelName("n");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);

		
		LineObject ln1 = new LineObject();
		ln1.setX1(0.0);
		ln1.setX2(-4.0);
		ln1.setY1(0.0);
		ln1.setY2(4.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(0.0);
		ln2.setX2(0.0);  
		ln2.setY1(0.0);
		ln2.setY2(7.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(2.0);
		ln3.setX2(-2.0);  
		ln3.setY1(2.0);
		ln3.setY2(6.0);
		
		LineObject ln4 = new LineObject();
		ln4.setX1(2.0);
		ln4.setX2(2.0);  
		ln4.setY1(2.0);
		ln4.setY2(9.0);
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		lineList.add(ln4);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "We have two pairs of parallel lines. Find the value of m";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("135");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
	public Problem getProblem25(MathConfiguration mathConfig) {
		
		CreateProblem cProblem = new CreateProblem();
		Answer answ = new Answer();
				
		MessageSource mSource = mathConfig.getmSource();
					
		List<QuestionLine> questionList = new LinkedList<QuestionLine>();
		String question="";
					
		GeometryObject geo = new GeometryObject();
		List <LabelObject> labelList = new ArrayList<LabelObject>();
		List <LineObject> lineList = new ArrayList<LineObject>();
				
		LabelObject l1 = new LabelObject();
		LabelObject l2 = new LabelObject();
		LabelObject l3 = new LabelObject();

						
		l1.setxCo(-1.0);
		l1.setyCo(1.5);
		l1.setLabelName("45");
				
		l2.setxCo(.5);
		l2.setyCo(4.0);
		l2.setLabelName("m");
		
		l3.setxCo(1.2);
		l3.setyCo(3.2);
		l3.setLabelName("n");
		
		labelList.add(l1);
		labelList.add(l2);
		labelList.add(l3);

		
		LineObject ln1 = new LineObject();
		ln1.setX1(0.0);
		ln1.setX2(-4.0);
		ln1.setY1(0.0);
		ln1.setY2(4.0);
		
		LineObject ln2 = new LineObject();
		ln2.setX1(0.0);
		ln2.setX2(0.0);  
		ln2.setY1(0.0);
		ln2.setY2(7.0);
		
		LineObject ln3 = new LineObject();
		ln3.setX1(2.0);
		ln3.setX2(-2.0);  
		ln3.setY1(2.0);
		ln3.setY2(6.0);
		
		LineObject ln4 = new LineObject();
		ln4.setX1(2.0);
		ln4.setX2(2.0);  
		ln4.setY1(2.0);
		ln4.setY2(9.0);
			
		lineList.add(ln1);
		lineList.add(ln2);
		lineList.add(ln3);
		lineList.add(ln4);
				
		geo.setLabels(labelList);
		geo.setLines(lineList);
				
					
		question = "We have two pairs of parallel lines. Find the value of n";

		questionList.add( new QuestionLine( "", null, Constants.PI_PLOT));
		questionList.add( new QuestionLine( question, null, Constants.DEFAULT));

						
		String heading = mSource.getMessage(GR7_Constants.GEOMETRY_AREAS, null, Locale.ENGLISH);
		answ.setAnswer("45");

		Problem problem = cProblem.constructProblem(questionList, heading, Constants.RANK_ONE, Constants.PI_PLOT);
		problem.setGeometryObject(geo);
		problem.setAnswer(answ);

		return problem;
	}
	
}
