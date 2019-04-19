package com.weblearning.domain.dao.impl;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.weblearning.domain.TopicDetail;
import com.weblearning.domain.dao.TopicDetailDAO;

/* This class returns the TpicDetail from Database.
 * 
 */

@Repository("topicDetail")
public class TopicDetailDAOImpl implements TopicDetailDAO{

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public TopicDetail findAllTopicDetails(String topicId) {
		
		int topic = Integer.parseInt(topicId);
		List<TopicDetail> topicDetailList = new LinkedList<TopicDetail>();
		
		topicDetailList = (List<TopicDetail>) entityManager
				.createQuery("Select t from TopicDetail t where t.topicDetailsID=:topic order by t.topicDetailsID")
				.setParameter("topic", topic)
				.getResultList();
		
		return topicDetailList.get(0);
	}
	
}
