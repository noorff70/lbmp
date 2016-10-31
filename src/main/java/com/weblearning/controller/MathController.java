package com.weblearning.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.weblearning.domain.Answer;
import com.weblearning.domain.Lesson;
import com.weblearning.domain.Problem;
import com.weblearning.domain.TopicDetail;
import com.weblearning.service.MathClassLoaderService;
import com.weblearning.service.TopicDetailService;
import com.weblearning.utilities.Constants;

/*Returns to UI the TopicDetail Object while taking Topic Detail ID
 * Will be invoked to call the first problem only. 
 */

@Controller
public class MathController {
	
	@Autowired
	private TopicDetailService topicDetailService;
	
	@Autowired
	private MathClassLoaderService mathClassLoaderService;
	
	
	/* First time the controller is invoked to return to view a list of question headings to display
	 * 
	 */
	@RequestMapping(value="mathview", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView topicdetail(@RequestParam("TOPICDETAILID") String topicDetailId, HttpServletRequest request) {
				
		//Create a list of problems
		List<Problem> problemList = new ArrayList<Problem>();
		List <String> questionHeadingList = new ArrayList<String>();
		List <String> questionSubHeadingList = new ArrayList<String>();
		
		String gradeId = (String) request.getSession().getAttribute("GRADEID");
				

		ModelAndView model = new ModelAndView();
		
		//Get the TopicDetail from db based on the topicDetailId passed by the URL get method  
		TopicDetail topicDetail = topicDetailService.getTopicDetail(topicDetailId);
		
		//Get the name of the class from TopicDetail object
		String packageName= getPackageName(gradeId);
		String className = packageName + topicDetail.getClassName();
		
		//Get the list of problems and add that to session for later retrieval
		mathClassLoaderService.setGradeId(gradeId);
		problemList = mathClassLoaderService.getProblemList(className);
		request.getSession().setAttribute(Constants.PROBLM_LIST, problemList);
		
	
		//Create a list of question headings from the list of problems. Only add the items once.
		int currentRank=0, newRank =0;
		for (Problem problems: problemList){
			currentRank = problems.getRank();
			if (newRank ==0 && currentRank !=0){//first time
				questionHeadingList.add(problems.getQuestionHeading());
				newRank = currentRank; //set newrank and currentrank same
			}
			if(newRank != currentRank){
				questionHeadingList.add(problems.getQuestionHeading());
				newRank = currentRank;
			}
			else
				continue;
		}
		
		//add all the sub headings on the list to display on screen
		for (Problem problems: problemList){
			questionSubHeadingList.add(problems.getQuestionSubHeading());
		}
					
		//create the model
		model.addObject(Constants.LIST_OF_QUESTION_HEADING, questionHeadingList);
		model.addObject(Constants.LIST_OF_QUESTION_SUBHEADING,questionSubHeadingList );
    	model.setViewName(Constants.MATH_VIEW);
		
		return model;
	}
	
	/*Will be invoked after the list of question heading is displayed
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/mathviewnext", method = RequestMethod.POST)
	@ResponseBody
    public Lesson removeLesson(@ModelAttribute(value = "lesson") Lesson lesson, @RequestBody Answer answer, BindingResult result,HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
       
        int noCorrectAnswers = answer.getNoOfCorrectAnswer();
        List questionList = new ArrayList();
          
        
        //Get the list of questions from session
        questionList = (List) request.getSession().getAttribute(Constants.PROBLM_LIST);
		
        int numberOfRemainingProblems = questionList.size()-1;
		int numberOfProblems= getNumberOfProblems(request, questionList);
       
        Problem problem = (Problem) questionList.get(0);
        
        lesson.setProblem(problem);
        lesson.setNumberOfProblems(numberOfProblems);
        lesson.setRemainingProblems(numberOfRemainingProblems);
        lesson.setNumberOfCorrectAnswers(noCorrectAnswers);
        
        if (questionList.size()>0){
        //Add the new list
        	model.addObject("lesson", lesson);
        	model.setViewName(Constants.MATH_VIEW);
        }
        else
        	//return to home page
        	model.setViewName(Constants.INDEX_PAGE);
        
        questionList.remove(0);
        request.getSession().setAttribute(Constants.PROBLM_LIST, questionList);
        
        return lesson;
    }
	
	/*
	 * Get the package name of the class
	 * 
	 */
	public String getPackageName(String gradeId){
		
		if (Integer.parseInt(gradeId)== 5)
			return Constants.GRADE_5_PACKAGE;
		else if (Integer.parseInt(gradeId)== 6)
			return Constants.GRADE_6_PACKAGE;
		
		return null;
		
	}
	
	/*Returns the number of problems in a Lesson
	 * 
	 */
	public int getNumberOfProblems(HttpServletRequest request, List<?> questionList){
		
		int numberOfProblems=0; 
		
		if (null == request.getSession().getAttribute(Constants.NUMBER_OF_PROBLEMS)){
			numberOfProblems = questionList.size();
			request.getSession().setAttribute(Constants.NUMBER_OF_PROBLEMS, numberOfProblems);
		}
		else 
			numberOfProblems = (int) request.getSession().getAttribute(Constants.NUMBER_OF_PROBLEMS);
		
		return numberOfProblems;
		
	}
	
}
