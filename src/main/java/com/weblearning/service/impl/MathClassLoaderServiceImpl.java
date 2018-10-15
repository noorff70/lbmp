package com.weblearning.service.impl;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weblearning.domain.Lesson;
import com.weblearning.domain.LessonBody;
import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.math.grade.GenericQuestion;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.service.MathClassLoaderService;
import com.weblearning.service.MessageResolveService;


@Service("classLoaderService")
@Transactional
public class MathClassLoaderServiceImpl implements MathClassLoaderService{

	private String gradeId;
	
	@Autowired
	MessageResolveService mService;
	

	@Override
	public String getGradeId() {

		return this.gradeId;
	}


	@Override
	public void setGradeId(String gId) {
		gradeId = gId;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Problem> getProblemList(String className){

		MathConfiguration mathConfig = new MathConfiguration();
		createConfigValues(mathConfig);
		
		List<Problem> problemList = new LinkedList<Problem>();
		
		Question question = loadQuestionClass(className);
		question.setMathConfiguration(mathConfig);
		
		if (question instanceof GenericQuestion)
			problemList = (List<Problem>) question.getQuestions(mathConfig);
	
				
		return problemList;
	}
	
	@SuppressWarnings("unchecked")
	public List<LessonBody> getLesson(String className) {
		
		//List<Lesson> lessionList = new LinkedList<Lesson>();
		Lesson ls = loadLessonClass(className);
		
		return ls.getLessonList();		
	}
	
	
	@Override
	public MessageSource getMessageResource(String gradeId) {

		return mService.getMessageSource(gradeId);
	}
	
	
	public Question loadQuestionClass(String className) {

		try {
			Class<?> clazz = Class.forName(className);
			return (Question) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public Lesson loadLessonClass(String className) {

		try {
			Class<?> clazz = Class.forName(className);
			return (Lesson) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	 /* Create a static value for different purposes 
	  */
	 
	
	public void createConfigValues (MathConfiguration mConfig){
		
		Map<Integer, List<Integer>> mapOfFactors = MathUtilities.getFactors();
		Map<Integer, List<Integer>> mapOfPrimeFactors = MathUtilities.getPrimeFactors();
		
		mConfig.setFactors(mapOfFactors);
		mConfig.setPrimeFactors(mapOfPrimeFactors);
		mConfig.setmSource(getMessageResource(getGradeId()));
	}



}
