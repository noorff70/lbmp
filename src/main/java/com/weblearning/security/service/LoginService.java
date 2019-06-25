package com.weblearning.security.service;

import com.weblearning.domain.MessageReturned;
import com.weblearning.domain.Student;
import com.weblearning.domain.Tutor;

public interface LoginService {
	
	public MessageReturned isValidUser(String username, String password);
	public MessageReturned insertStudent(Student student);
	public MessageReturned insertTutor(Tutor tutor);

}
