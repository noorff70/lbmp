package com.weblearning.domain.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.weblearning.domain.Subject;
import com.weblearning.domain.dao.SubjectDAO;


@Repository
public class SubjectDAOImpl implements SubjectDAO{

	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Subject> list() {
		return (List<Subject>) entityManager
  				.createQuery("from SUBJECT", Subject.class)
  				.getResultList();
	}
	

}

