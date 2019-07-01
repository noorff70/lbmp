package com.weblearning.security.service;

import com.weblearning.domain.MessageReturned;
import com.weblearning.domain.Student;
import com.weblearning.domain.Tutor;
import com.weblearning.security.model.LoggedUser;

public interface LoginService {
	
	public LoggedUser isValidUser(String username, String password);
	public MessageReturned insertStudent(Student student);
	public MessageReturned insertTutor(Tutor tutor);
	public MessageReturned updateStudent(Student student);
	public MessageReturned updateTutor(Tutor tutor);
}
