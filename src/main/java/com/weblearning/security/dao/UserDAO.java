package com.weblearning.security.dao;

import com.weblearning.security.model.LoggedUser;

public interface UserDAO {
	
	public LoggedUser isValidUser(String username, String password);

}
