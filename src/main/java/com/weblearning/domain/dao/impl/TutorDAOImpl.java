package com.weblearning.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.weblearning.domain.MessageReturned;
import com.weblearning.domain.Tutor;
import com.weblearning.domain.dao.TutorDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

@Repository("tutorDAO")
public class TutorDAOImpl implements TutorDAO {

	private static final Logger logger = Logger.getLogger(TutorDAOImpl.class);

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public MessageReturned saveTutor(Tutor tutor) {

		MessageReturned msgRtn = new MessageReturned();
		Long maxId;
		List<Tutor> tutorList = new ArrayList<Tutor>();
		String tutorName = tutor.getUsername();
		
		tutorList = entityManager.createQuery("Select u from User u where u.username =:tutorName")
				.setParameter("tutorName", tutorName)
				.getResultList();
		
		
		if (null != tutorList && tutorList.size() == 0) {
			try {
				maxId = (Long)entityManager.createQuery("select max(u.userId) from User u").getSingleResult();
				if (null == maxId)
					maxId = Long.valueOf(0);
				tutor.setUserId(maxId+1);
				
				entityManager.persist(tutor);
				
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

	@Override
	public MessageReturned updateTutor(Tutor tutor) {
		
		MessageReturned msg = new MessageReturned();
		Tutor tut = new Tutor();
		
		String tutorName = tutor.getUsername();
		
		try {
			tut = (Tutor)entityManager.createQuery("Select u from User u where u.username =:tutorName")
					.setParameter("tutorName", tutorName)
					.getSingleResult();
			
			tut.setPassword(tutor.getPassword());
			tut.setPostalCode(tutor.getPostalCode());
			tut.setGradeUser(tutor.getGradeUser());
			
			entityManager.persist(tut);
			
			msg.setMsg("Tutor Updated Successfully");
			msg.setSuccess(true);
			
		}catch(Exception e) {
			msg.setMsg("Failed to update Tutor");
			msg.setSuccess(false);
			
		}
		
		return msg;
	}

}
