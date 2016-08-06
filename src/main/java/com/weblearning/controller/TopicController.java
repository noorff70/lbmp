package com.weblearning.controller;

import java.util.List;




import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.weblearning.domain.Topic;
import com.weblearning.service.TopicService;

@Controller
public class TopicController{
	
	@Autowired
	private TopicService topicService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/topics", method=RequestMethod.GET)
	public List<Topic> topics(@RequestParam("GRADEID") String gradeId, @RequestParam("SUBJECTID") String subjectId, HttpServletRequest request) {
	  
		List<Topic> topicList = (List<Topic>) request.getSession().getAttribute("topicList");
		
		if (null != topicList){
			//Match the session topiclist with request topic
			Topic topic = topicList.get(0);
			if (Integer.toString(topic.getGradeId()).equals(gradeId))
				return topicList;
			else{
				topicList = topicService.getAllTopics(gradeId, subjectId);
				request.getSession().setAttribute("topicList", topicList);
			}
			request.getSession().setAttribute("GRADEID", gradeId);
				
		}
		else 
		{
			topicList = topicService.getAllTopics(gradeId, subjectId);
			request.getSession().setAttribute("topicList", topicList);
			request.getSession().setAttribute("GRADEID", gradeId);
		}

		return topicList;
	}
	   
  
}
