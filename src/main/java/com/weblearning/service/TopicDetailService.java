package com.weblearning.service;


import com.weblearning.domain.TopicDetail;

/*
 * Return the TopicDetail Object from Database that consists 
 * name, topic detail id etc
 */

public interface TopicDetailService {
	
	public TopicDetail getTopicDetail(String topicDetailID);

}
