package com.weblearning.domain.dao;

import java.util.List;

import com.weblearning.domain.Topic;

public interface TopicDAO {
	
	List<Topic> findAllTopics(String gradeId, String subjectId);

}
