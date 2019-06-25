package com.weblearning.security.dao;

import com.weblearning.domain.MessageReturned;
import com.weblearning.security.model.User;

public interface UserDAO {
	
	public MessageReturned isValidUser(String username, String password);

}
