package com.weblearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	public List<Problem> getProblems(@RequestParam("TOPICDETAILID") String topicDetailId, @RequestParam("GRADEID") String gradeId) {

		// Create a list of problems
		List<Problem> problemList = new ArrayList<Problem>();
		List<String> questionHeadingList = new ArrayList<String>();
		List<String> questionSubHeadingList = new ArrayList<String>();
		Lesson lesson = new Lesson();
		

		ModelAndView model = new ModelAndView();

		// Get the TopicDetail from db based on the topicDetailId passed by the URL get
		// method
		TopicDetail topicDetail = topicDetailService.getTopicDetail(topicDetailId);

		// Get the name of the class from TopicDetail object
		String packageName = getPackageName(gradeId);
		String className = packageName + topicDetail.getClassName();

		// Get the list of problems and add that to session for later retrieval
		mathClassLoaderService.setGradeId(gradeId);
		problemList = mathClassLoaderService.getProblemList(className);


		// Create a list of question headings from the list of problems. Only add the
		// items once.
/*		int currentRank = 0, newRank = 0;
		for (Problem problems : problemList) {
			currentRank = problems.getRank();
			if (newRank == 0 && currentRank != 0) {// first time
				questionHeadingList.add(problems.getQuestionHeading());
				newRank = currentRank; // set newrank and currentrank same
			}
			if (newRank != currentRank) {
				questionHeadingList.add(problems.getQuestionHeading());
				newRank = currentRank;
			} else
				continue;
		}*/

		// add all the sub headings on the list to display on screen
		for (Problem problems : problemList) {
			questionSubHeadingList.add(problems.getQuestionSubHeading());
		}

		// create the model
	//	model.addObject(Constants.LIST_OF_QUESTION_HEADING, questionHeadingList);
	//	model.addObject(Constants.LIST_OF_QUESTION_SUBHEADING, questionSubHeadingList);
	//	model.setViewName(Constants.MATH_VIEW);

		return problemList;
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
