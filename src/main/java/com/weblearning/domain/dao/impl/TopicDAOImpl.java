package com.weblearning.domain.dao.impl;

import java.util.List;




import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.weblearning.domain.Topic;
import com.weblearning.domain.dao.TopicDAO;

@Repository("topicDAO")
public class TopicDAOImpl implements TopicDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Returns the list of topics for a subject.
	 * 
	 */
	@Override
	public List<Topic> findAllTopics(String gradeId, String subjectId) {
		
		int grade= Integer.parseInt(gradeId);
		int subject = Integer.parseInt(subjectId);
		
		String sql = "from Topic t where t.gradeId=:grade AND t.subjectId=:subject";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("grade", grade );
		query.setParameter("subject", subject);
		
		
		@SuppressWarnings("unchecked")
		List<Topic> result = query.list();
		
		return result;
	}

}
