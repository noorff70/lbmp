package com.weblearning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weblearning.domain.TopicDetail;
import com.weblearning.domain.dao.TopicDetailDAO;
import com.weblearning.service.TopicDetailService;

/*Implementation class that returns a TopicDetail to Controller
 * with topic name, topic detail id etc
 * 
 */

@Service("topicDetailService")
@Transactional
public class TopicDetailServiceImpl implements TopicDetailService{

	
	@Autowired 
	TopicDetailDAO topicDetailDAO;
	
	@Override
	public TopicDetail getTopicDetail(String topicDetailID) {
		
		return (TopicDetail) topicDetailDAO.findAllTopicDetails(topicDetailID);
	}

	
}
