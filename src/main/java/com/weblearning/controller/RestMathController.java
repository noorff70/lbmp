package com.weblearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weblearning.domain.Lesson;
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
	public Lesson getProblems(@RequestParam("TOPICDETAILID") String topicDetailId, @RequestParam("GRADEID") String gradeId) {

		Lesson ls = new Lesson();
		
		// Create a list of problems
		List<Problem> problemList = new ArrayList<Problem>();
		

		// Get the TopicDetail from db based on the topicDetailId passed by the URL get
		// method
		TopicDetail topicDetail = topicDetailService.getTopicDetail(topicDetailId);

		// Get the name of the class from TopicDetail object
		String packageName = getPackageName(gradeId);
		String className = packageName + topicDetail.getClassName();

		// Get the list of problems and add that to session for later retrieval
		mathClassLoaderService.setGradeId(gradeId);
		problemList = mathClassLoaderService.getProblemList(className);

		ls.setProblemList(problemList);
		
		return ls;
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

}
