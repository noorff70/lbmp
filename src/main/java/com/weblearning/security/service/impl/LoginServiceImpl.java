package com.weblearning.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weblearning.domain.MessageReturned;
import com.weblearning.domain.Student;
import com.weblearning.domain.Tutor;
import com.weblearning.domain.dao.StudentDAO;
import com.weblearning.domain.dao.TutorDAO;
import com.weblearning.security.dao.UserDAO;
import com.weblearning.security.model.LoggedUser;
import com.weblearning.security.service.LoginService;

/*
 * Service layer class that eturns the request from controller and passes to DAO Layer
 */

@Service ("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	TutorDAO tutorDAO;
	
	@Autowired
	StudentDAO studentDAO;
	
	//check user in system
	public LoggedUser isValidUser(String username, String password) {
		
		return userDAO.isValidUser(username, password);
	}
	
	//save student
	public MessageReturned insertStudent(Student student) {
		
		return studentDAO.saveStudent(student);
	}
	
	//save tutor
	public MessageReturned insertTutor(Tutor tutor) {
		return tutorDAO.saveTutor(tutor);
	}

	@Override
	public MessageReturned updateStudent(Student student) {
		
		return studentDAO.updateStudent(student);
	}

	@Override
	public MessageReturned updateTutor(Tutor tutor) {
		
		return tutorDAO.updateTutor(tutor);
	}
	

}
