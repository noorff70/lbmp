package com.weblearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weblearning.domain.Topic;

@Service
public interface TopicService {
	
	public List <Topic>getAllTopics(String gradeId, String subjectId);
	

}
