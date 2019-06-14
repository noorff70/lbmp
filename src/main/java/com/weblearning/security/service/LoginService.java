package com.weblearning.security.service;

import com.weblearning.domain.MessageReturned;
import com.weblearning.security.model.User;

public interface LoginService {
	
	public MessageReturned isValidUser(String username, String password);
	public MessageReturned insertUser(User user);

}
