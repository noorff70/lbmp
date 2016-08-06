package com.weblearning.domain.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weblearning.domain.Grade;
import com.weblearning.domain.dao.GradeDAO;


@Service
public class GradeDAOImpl implements GradeDAO  {

  	SessionFactory sessionFactory;
	
  	public GradeDAOImpl(){
  		
  	}
  	
	
	public GradeDAOImpl(SessionFactory sFactory){
		sessionFactory = sFactory;
	}
 
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Grade> findAllGrades() {
		 
		@SuppressWarnings("unused")
		Session session = sessionFactory.getCurrentSession();

		return sessionFactory.getCurrentSession()
	            .createQuery("from Grade").list();
	
    }
}
