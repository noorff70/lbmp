package com.weblearning.security.dao.impl;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.weblearning.domain.MessageReturned;
import com.weblearning.security.dao.UserDAO;
import com.weblearning.security.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@PersistenceContext
	EntityManager entityManager;
	

	/*
	 * (non-Javadoc)
	 * @see com.weblearning.security.dao.UserDAO#isValidUser(java.lang.String, java.lang.String)
	 * Returns the User if find based on name and password
	 * In- username, password,
	 * out- boolean
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MessageReturned isValidUser(String username, String password) {
		
		List<User> userList = new ArrayList<User>();
		MessageReturned msgRtn = new MessageReturned();
		
		userList = entityManager.createQuery("Select u from User u where u.username =:username and u.password =:password")
				.setParameter("username", username)
				.setParameter("password", password)
				.getResultList();
		
		//User user = userList.get(0);
		
		if (null != userList && userList.size() > 0) {
			msgRtn.setSuccess(true);
			msgRtn.setMsg("Login Successful");
		}
		else {
			msgRtn.setSuccess(false);
			msgRtn.setMsg("Could not login. User with matching Password not found.");
		}
			
		
		return msgRtn;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public MessageReturned saveUser(User user) {
		
		MessageReturned msgRtn = new MessageReturned();
		Long maxId;
		List<User> userList = new ArrayList<User>();
		String username = user.getUsername();
		
		userList = entityManager.createQuery("Select u from User u where u.username =:username")
				.setParameter("username", username)
				.getResultList();
		
		
		if (null != userList && userList.size() == 0) {
			try {
				maxId = (Long)entityManager.createQuery("select max(u.userId) from User u").getSingleResult();
				user.setUserId(maxId+1);
				
				entityManager.persist(user);
				
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
