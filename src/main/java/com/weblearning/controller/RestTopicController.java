package com.weblearning.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weblearning.domain.Topic;
import com.weblearning.domain.ui.UIObject;
import com.weblearning.domain.utility.ui.RoutingUtility;
import com.weblearning.domain.utility.ui.WebConstants;
import com.weblearning.service.TopicService;

@RestController
public class RestTopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "/subMenu", method = RequestMethod.GET)
	public UIObject topics(@RequestParam("GRADEID") String gradeId, @RequestParam("SUBJECTID") String subjectId,
			HttpServletRequest request) {

		// UIObject uiObject = (UIObject) request.getSession().getAttribute(WebConstants.UI_OBJECT);
		// List<Topic> topicList;

		// Look for the UIObject in Session
/*		if (null != uiObject) {
			topicList = uiObject.getTopicList();

			if (null != topicList && topicList.size() > 0) {
				// get the first Topic and the Subject and Grade
				Topic topic = topicList.get(0);
				int sId = topic.getSubjectId();
				int gId = topic.getGradeId();

				// if the current subject and gradeid match with session, then return the same
				// object
				if (sId == Integer.parseInt(subjectId) && gId == Integer.parseInt(gradeId))
					return uiObject;
				// Look into DB, create a new UIObject and return
				else
					return getNewUIObject(gradeId, subjectId, request);

			} else {
				return getNewUIObject(gradeId, subjectId, request);
			}
		} else {

			return getNewUIObject(gradeId, subjectId, request);

		}*/

		return getNewUIObject(gradeId, subjectId, request);
	}

	public UIObject getNewUIObject(String gradeId, String subjectId, HttpServletRequest request) {

		// Create a new UIObject
		UIObject uiObject = new UIObject();
		List<Topic> topicList;

		// Get the view page
		String viewPage = RoutingUtility.getViewPage(Integer.parseInt(subjectId));
		// Get the topicList for a particular GradeId and SubjectId
		topicList = topicService.getAllTopics(gradeId, subjectId);

		// set the UIObject values
		uiObject.setViewpage(viewPage);
		uiObject.setTopicList(topicList);

		// Set the session for GradeId
		request.getSession().setAttribute("GRADEID", gradeId);
		request.getSession().setAttribute(WebConstants.UI_OBJECT, uiObject);

		return uiObject;

	}

}
