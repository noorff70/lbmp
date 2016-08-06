package com.weblearning.domain.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.weblearning.domain.Subject;
import com.weblearning.domain.dao.SubjectDAO;


@Repository
public class SubjectDAOImpl implements SubjectDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> list() {
		 
        return sessionFactory.getCurrentSession().createQuery("from SUBJECT")
                .list();
    }

}

