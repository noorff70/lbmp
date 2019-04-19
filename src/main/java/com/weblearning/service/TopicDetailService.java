package com.weblearning.service;


import org.springframework.stereotype.Service;

import com.weblearning.domain.TopicDetail;

/*
 * Return the TopicDetail Object from Database that consists 
 * name, topic detail id etc
 */

@Service
public interface TopicDetailService {
	
	public TopicDetail getTopicDetail(String topicDetailID);

}
