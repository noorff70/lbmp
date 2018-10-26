package com.weblearning.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weblearning.domain.Chapter;
import com.weblearning.domain.Lesson;
import com.weblearning.domain.LessonBody;
import com.weblearning.domain.Problem;
import com.weblearning.domain.TopicDetail;
import com.weblearning.service.MathClassLoaderService;
import com.weblearning.service.TopicDetailService;
import com.weblearning.utilities.Constants;

@RestController
public class RestMathController {

	@Autowired
	private TopicDetailService topicDetailService;

	@Autowired
	private MathClassLoaderService mathClassLoaderService;

	@RequestMapping(value = "/mathDetail", method = RequestMethod.GET)
	public Chapter getProblems(@RequestParam("TOPICDETAILID") String topicDetailId, @RequestParam("GRADEID") String gradeId) {

		Chapter ch = new Chapter();
		
		// Create a list of problems
		List<Problem> problemList = new ArrayList<Problem>();
		List<Lesson> lessonList = new LinkedList<Lesson>();

		// Get the TopicDetail from db based on the topicDetailId passed by the URL get
		// method
		TopicDetail topicDetail = topicDetailService.getTopicDetail(topicDetailId);

		// Get the name of the class from TopicDetail object
		String packageName = getPackageName(gradeId);
		String className = packageName + topicDetail.getClassName();
		
		String lessonName = topicDetail.getTopic().getGradeSubject();
		String lessonClassName = getLessonPackageName(gradeId) + lessonName;

		// Get the list of problems and add that to session for later retrieval
		mathClassLoaderService.setGradeId(gradeId);
		problemList = mathClassLoaderService.getProblemList(className);

		ch.setProblemList(problemList);
		
		lessonList = mathClassLoaderService.getLessonList(lessonClassName);
		ch.setLessonList(lessonList);
		
		return ch;
	}
	
	
	/*
	 * Get the package name of the class
	 * 
	 */
	public String getPackageName(String gradeId){
		
		if (Integer.parseInt(gradeId)== 7)
			return Constants.GRADE_7_PACKAGE;
		if (Integer.parseInt(gradeId)== 8)
			return Constants.GRADE_8_PACKAGE;
		
		return null;
		
	}
	
	public String getLessonPackageName(String gradeId) {
		
		if (Integer.parseInt(gradeId)== 7)
			return Constants.GRADE_7_PACKAGE_LESSON;
		if (Integer.parseInt(gradeId)== 8)
			return Constants.GRADE_8_PACKAGE_LESSON;
		
		return null;
	}

}
