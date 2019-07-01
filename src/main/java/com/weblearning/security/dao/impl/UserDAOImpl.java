package com.weblearning.security.dao.impl;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.weblearning.security.dao.UserDAO;
import com.weblearning.security.model.LoggedUser;
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
	public LoggedUser isValidUser(String username, String password) {
		
		User user = new User();
		LoggedUser loggedUser = new LoggedUser();
		
		List<User> userList = new ArrayList<User>();
		//MessageReturned msgRtn = new MessageReturned();
		
		userList = entityManager.createQuery("Select u from User u where u.username =:username and u.password =:password")
				.setParameter("username", username)
				.setParameter("password", password)
				.getResultList();
		
		user = userList.get(0);
		
		loggedUser.setGradeTutor(user.getGradeUser());
		loggedUser.setUserRole(user.getUserRole());
		loggedUser.setUsername(user.getUsername());
		//user.setPassword(null);
		
		/*if (null != userList && userList.size() > 0) {
			msgRtn.setSuccess(true);
			msgRtn.setMsg("Login Successful");
		}
		else {
			msgRtn.setSuccess(false);
			msgRtn.setMsg("Could not login. User with matching Password not found.");
		}*/
			
		
		return loggedUser;
	}

}
