package com.weblearning.domain.dao;


import com.weblearning.domain.TopicDetail;

/*DAO layer to return specific TopicDetail Object based on detail Id
 * 
 */
		

public interface TopicDetailDAO {
	
	TopicDetail findAllTopicDetails(String topicId);

}
