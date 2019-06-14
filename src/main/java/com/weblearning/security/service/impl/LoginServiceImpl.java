package com.weblearning.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weblearning.domain.MessageReturned;
import com.weblearning.security.dao.UserDAO;
import com.weblearning.security.model.User;
import com.weblearning.security.service.LoginService;

/*
 * Service layer class that eturns the request from controller and passes to DAO Layer
 */

@Service ("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserDAO userDAO;
	
	/*Returns boolean value based on the user in System
	 * (non-Javadoc)
	 * @see com.weblearning.security.service.LoginService#isValidUser(java.lang.String, java.lang.String)
	 */
	public MessageReturned isValidUser(String username, String password) {
		
		return userDAO.isValidUser(username, password);
		
	}
	
	public MessageReturned insertUser(User user) {
		
		return userDAO.saveUser(user);
		
	}

}
