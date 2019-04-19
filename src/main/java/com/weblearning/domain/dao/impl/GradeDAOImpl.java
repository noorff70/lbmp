package com.weblearning.domain.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.weblearning.domain.Grade;
import com.weblearning.domain.dao.GradeDAO;


@Repository
public class GradeDAOImpl implements GradeDAO  {

	@PersistenceContext
	EntityManager entityManager;
	
  	public GradeDAOImpl(){
  		
  	}
  	
  	public List<Grade> findAllGrades() {
  		return (List<Grade>) entityManager
  				.createQuery("from Grade", Grade.class)
  				.getResultList();
  	}
  	
}
