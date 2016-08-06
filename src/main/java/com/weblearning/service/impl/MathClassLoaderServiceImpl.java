package com.weblearning.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weblearning.domain.MathConfiguration;
import com.weblearning.domain.Problem;
import com.weblearning.math.grade.Question;
import com.weblearning.math.utilities.MathUtilities;
import com.weblearning.service.MathClassLoaderService;


@Service("classLoaderService")
@Transactional
public class MathClassLoaderServiceImpl implements MathClassLoaderService{

	@SuppressWarnings("unchecked")
	public List<Problem> getProblemList(String className){
		
		MathConfiguration mathConfig = new MathConfiguration();
		createConfigValues(mathConfig);
		
		List<Problem> problemList = new LinkedList<Problem>();
		
		Question question = getQuestion(className);
		question.setMathConfiguration(mathConfig);
		
		//Get the list of the problems	
		problemList = (List<Problem>) question.getQuestions(mathConfig);
				
		return problemList;
	}
	
	
	public Question getQuestion(String className) {
		
					
			try {
				Class clazz = Class.forName(className);
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
	
	/*
	 * Create a static value for different purposes
	 */
	
	public void createConfigValues (MathConfiguration mConfig){
		
		Map mapOfFactors = MathUtilities.getFactors();
		Map mapOfPrimeFactors = MathUtilities.getPrimeFactors();
		
		mConfig.setFactors(mapOfFactors);
		mConfig.setPrimeFactors(mapOfPrimeFactors);
	}
	


}
