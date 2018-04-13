package com.weblearning.domain.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.weblearning.domain.TopicDetail;
import com.weblearning.domain.dao.TopicDetailDAO;

/* This class returns the TpicDetail from Database.
 * 
 */

@Repository("topicDetail")
public class TopicDetailDAOImpl implements TopicDetailDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public TopicDetail findAllTopicDetails(String topicId) {
		
		int topic= Integer.parseInt(topicId);		
		
		String sql = "from TopicDetail t where t.topicDetailsID=:topic";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("topic", topic );
		
		
		@SuppressWarnings("unchecked")
		List<TopicDetail> result = query.list();
		
		TopicDetail topicDetail= (TopicDetail) result.get(0);
		
		return topicDetail;
	}

}
