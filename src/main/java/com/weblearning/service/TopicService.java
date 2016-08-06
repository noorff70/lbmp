package com.weblearning.service;

import java.util.List;

import com.weblearning.domain.Topic;

public interface TopicService {
	
	public List <Topic>getAllTopics(String gradeId, String subjectId);
	

}
