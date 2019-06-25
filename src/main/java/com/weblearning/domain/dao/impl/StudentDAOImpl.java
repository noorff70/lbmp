package com.weblearning.domain.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.weblearning.domain.MessageReturned;
import com.weblearning.domain.Student;
import com.weblearning.domain.dao.StudentDAO;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO{
	
	private static final Logger logger = Logger.getLogger(TutorDAOImpl.class);

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public MessageReturned saveStudent(Student student) {

		MessageReturned msgRtn = new MessageReturned();
		Long maxId;
		List<Student> studentList = new ArrayList<Student>();
		String studentName = student.getUsername();
		
		studentList = entityManager.createQuery("Select u from User u where u.username =:studentName")
				.setParameter("studentName", studentName)
				.getResultList();
		
		
		if (null != studentList && studentList.size() == 0) {
			try {
				maxId = (Long)entityManager.createQuery("select max(u.userId) from User u").getSingleResult();
				if (null == maxId)
					maxId = Long.valueOf(0);
				student.setUserId(maxId+1);
				
				entityManager.persist(student);
				
				msgRtn.setMsg("User saved Successfully");
				msgRtn.setSuccess(true);
				
			}catch(Exception e) {
				msgRtn.setMsg("System error. Please contact Administrator.");
				msgRtn.setSuccess(false);
				logger.error(e);
			}
		} else {
			msgRtn.setMsg("User already exists. Please try with a new UserId.");
			msgRtn.setSuccess(false);
		}

		
		return msgRtn;
	}

}
