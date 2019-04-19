package com.weblearning.domain.dao.impl;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.weblearning.domain.Topic;
import com.weblearning.domain.dao.TopicDAO;

@Repository("topicDAO")
public class TopicDAOImpl implements TopicDAO{

	
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findAllTopics(String gradeId, String subjectId) {
		
		int GRADEID= Integer.parseInt(gradeId);
		int SUBJECTID = Integer.parseInt(subjectId);
		List<Topic> topicList = new LinkedList<Topic>();
		
		topicList = (List<Topic>) em
  				.createQuery("select t from Topic t where t.gradeId=:GRADEID AND t.subjectId=:SUBJECTID")
  				.setParameter("GRADEID", GRADEID)
  				.setParameter("SUBJECTID", SUBJECTID)
  				.getResultList();
		
		return topicList;
	}
	
}
