package com.weblearning.security.dao.impl;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.weblearning.security.dao.UserDAO;
import com.weblearning.security.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
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
	public boolean isValidUser(String username, String password) {
		
		List<User> userList = new ArrayList<User>();
		
		userList = entityManager.createQuery("Select u from User u where u.username =: username")
				.setParameter("username", username)
				.setParameter("password", password)
				.getResultList();
		
		User user = userList.get(0);
		
		if (user.getPassword().equals(password))
			return true;
		
		return false;
	}

}
