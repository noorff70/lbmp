package com.weblearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weblearning.domain.Topic;
import com.weblearning.domain.dao.TopicDAO;
import com.weblearning.service.TopicService;

@Service("topicService")
@Transactional
public class TopicServiceImpl implements TopicService{

	@Autowired
	TopicDAO topicDAO;
	
	@Override
	@Transactional
	public List<Topic> getAllTopics(String gradeId, String subjectId) {
		
		return topicDAO.findAllTopics(gradeId, subjectId);
	}
	

}
